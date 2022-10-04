const path = require("path");
const express = require("express");
const uuid = require("uuid");
const multer = require("multer");
const { createDatabase } = require("./database");

const uploadDir = path.resolve(__dirname, "../public/uploads");
const upload = multer({ dest: uploadDir });

const adminUserId = "fhs8dhf9s8dhf9sd8hf9sd8hf";
const storage = createDatabase(path.resolve(__dirname, "../database"), {
  users: [
    {
      id: adminUserId,
      username: "admin",
    },
  ],
  adminUsers: [adminUserId],
  chats: [],
  passwords: {
    [adminUserId]: "admin", //
  },
  authTokens: {},
});

async function authenticate(req, res, next) {
  const authWhiteList = ["/login"];

  if (authWhiteList.includes(req.path)) {
    next();
    return;
  }

  const tokens = await storage.authTokens.read();
  const allTokens = Object.values(tokens);
  const authToken = req.headers["auth-token"];

  if (!authToken || !allTokens.includes(authToken)) {
    res.writeHead(401);
    res.end("authentication failed");
    return;
  }

  next();
}

function withErrorHandle(fn) {
  return async (req, res, next) => {
    try {
      await fn(req, res, next);
    } catch (err) {
      next(err);
    }
  };
}

const app = express();

const chatApp = express();

chatApp.use(express.json());

chatApp.use(authenticate);

chatApp.post(
  "/login",
  withErrorHandle(async (req, res, next) => {
    const { username, password } = req.body;
    const users = await storage.users.read();
    const passwords = await storage.passwords.read();

    const user = users.find(
      (user) => user.username === username && passwords[user.id] === password
    );
    if (!user) {
      res.writeHead(401);
      res.end("user not found");
      return;
    }

    const newAuthToken = uuid.v4();
    const allTokens = await storage.authTokens.read();
    const adminUsers = await storage.adminUsers.read();

    await storage.authTokens.write({
      ...allTokens,
      [user.id]: newAuthToken,
    });

    res.send({
      user,
      authToken: newAuthToken,
      isAdmin: adminUsers.includes(user.id),
    });
  })
);

chatApp.get(
  "/users/:id",
  withErrorHandle(async (req, res) => {
    const { id } = req.params;
    storage.users.read().then((users) => {
      res.send(users.find((user) => user.id === id));
    });
  })
);

chatApp.post(
  "/users",
  withErrorHandle(async (req, res) => {
    const body = req.body;

    if (!body.username?.length) {
      res.writeHead(400);
      res.end('"username" not defined');
      return;
    }

    if (!body.password?.length) {
      res.writeHead(400);
      res.end('"password" not defined');
      return;
    }

    const users = await storage.users.read();
    const isNonUnique = users.some((user) => user.username === body.username);

    if (isNonUnique) {
      res.writeHead(400);
      res.end('"username" already exists');
      return;
    }

    const id = uuid.v4();
    const user = {
      id,
      username: body.username,
    };

    await storage.users.write([...users, user]);

    const passwords = await storage.passwords.read();
    await storage.passwords.write({ ...passwords, [id]: body.password });

    res.send(user);
  })
);

chatApp.get(
  "/users",
  withErrorHandle(async (req, res) => {
    const { searchQuery } = req.query;

    const users = await storage.users.read();

    if (!searchQuery) {
      res.send(users);
      return;
    }

    res.send(
      users.filter(
        ({ username }) => username.toLowerCase().indexOf(searchQuery) !== -1
      )
    );
  })
);

chatApp.get(
  "/users/:id/chats",
  withErrorHandle(async (req, res) => {
    const { id: userId } = req.params;
    const chats = await storage.chats.read();

    const matchedChats = chats.filter((chat) => {
      const { members } = chat;
      return members.some((memberId) => memberId === userId);
    });

    res.send(matchedChats);
  })
);

chatApp.post(
  "/chats",
  withErrorHandle(async (req, res) => {
    const { title } = req.body;
    const chatId = uuid.v4();
    const chats = await storage.chats.read();
    const chat = {
      id: chatId,
      members: [],
      messages: [],
      title: title || `Chat ${chats.length + 1}`,
    };
    await storage.chats.write([...chats, chat]);
    res.send(chat);
  })
);

chatApp.post(
  "/chats/:id/members",
  withErrorHandle(async (req, res) => {
    const { id } = req.params;
    const { members: memberIds } = req.body;
    const chats = await storage.chats.read();
    const chat = chats.find((chat) => chat.id === id);

    if (!chat) {
      res.writeHead(400);
      res.end('chat with given "id" was not found');
      return;
    }

    if (memberIds === undefined) {
      res.writeHead(400);
      res.end('"memberIds" not found');
      return;
    }

    const { members } = chat;

    const isNonUnique = members.some((id) => memberIds.includes(id));

    if (isNonUnique) {
      res.writeHead(400);
      res.end("some users have been added to this chat already");
      return;
    }

    const nextMembers = [...members, ...memberIds];
    const nextChat = { ...chat, members: nextMembers };

    const nextChats = [...chats].map((chat) => {
      if (chat.id === id) {
        return nextChat;
      }
      return chat;
    });

    await storage.chats.write(nextChats);

    res.send(nextChat);
  })
);

chatApp.get(
  "/chats/:id",
  withErrorHandle(async (req, res) => {
    const { id } = req.params;
    const chats = await storage.chats.read();
    const chat = chats.find((chat) => chat.id === id);

    if (!chat) {
      res.writeHead(404);
      res.end("no such chat");
      return;
    }

    res.send(chat);
  })
);

chatApp.post(
  "/chats/:chatId/attachments",
  upload.single("file"),
  withErrorHandle(async (req, res) => {
    if (!req.file) {
      res.writeHead(400);
      res.end("no file uploaded");
      return;
    }

    const { chatId } = req.params;
    const chats = await storage.chats.read();
    const chat = chats.find((chat) => chat.id === chatId);

    if (!chat) {
      res.writeHead(404);
      res.end("chat not found");
      return;
    }

    const { messages } = chat;
    const { authorId } = req.body;
    const messageId = uuid.v4();

    const message = {
      date: Date.now(),
      authorId,
      message: "",
      attachment: req.file.filename,
      id: messageId,
    };
    const nextMessages = [...messages, message];
    const nextChat = {
      ...chat,
      messages: nextMessages,
    };

    const nextChats = chats.map((chat) => {
      if (chat.id === nextChat.id) {
        return nextChat;
      }

      return chat;
    });

    await storage.chats.write(nextChats);

    res.send(nextChat);
    res.end();
  })
);

chatApp.post(
  "/chats/:id/messages",
  withErrorHandle(async (req, res) => {
    const { id: chatId } = req.params;
    const { message, authorId } = req.body;

    if (!message) {
      res.writeHead(400);
      res.end("no message provided");
      return;
    }

    const chats = await storage.chats.read();
    const chat = chats.find((chat) => chat.id === chatId);

    if (!chat) {
      res.writeHead(404);
      res.end("chat not found");
      return;
    }

    const memberId = chat.members.find((member) => member === authorId);
    if (memberId === undefined) {
      res.writeHead(400);
      res.end("author is not a member of this chat");
      return;
    }

    const { messages } = chat;
    const messageId = uuid.v1();
    const nextMessages = [
      ...messages,
      { id: messageId, message, authorId, date: Date.now() },
    ];
    const nextChat = {
      ...chat,
      messages: nextMessages,
    };

    const nextChats = chats.map((chat) => {
      if (chat.id === nextChat.id) {
        return nextChat;
      }

      return chat;
    });

    await storage.chats.write(nextChats);

    res.send(nextChat);
  })
);

app.use("/api", chatApp);

app.listen(4000, () => {
  console.log("Listening on port 4000");
});
