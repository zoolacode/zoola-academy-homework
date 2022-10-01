import * as session from "./session";

function fetchJSON(url, method = "get", body = {}, auth = true) {
  const defaultHeaders = {
    "content-type": "application/json",
  };
  const authHeaders = {
    "auth-token": session.getAuthToken(),
  };
  const headers = auth ? { ...defaultHeaders, ...authHeaders } : defaultHeaders;
  return fetch(url, {
    method,
    body: method.toLowerCase() !== "get" ? JSON.stringify(body) : undefined,
    headers,
  }).then((response) => response.json());
}

export function login({ username, password }) {
  return fetchJSON(
    "/api/login",
    "post",
    {
      username,
      password,
    },
    false
  );
}

export function getChats(userId) {
  return fetchJSON(`/api/users/${userId}/chats`);
}

export function getUsers() {
  return fetchJSON(`/api/users`);
}

export function getUser(userId) {
  return fetchJSON(`/api/users/${userId}`);
}

export function addChatMembers({ chatId, members }) {
  return fetchJSON(`/api/chats/${chatId}/members`, "post", { members });
}

export function createChat({ title, userId, members }) {
  return fetchJSON(`/api/chats`, "post", { title }).then((chat) => {
    return addChatMembers({ chatId: chat.id, members: [userId, ...members] });
  });
}

export function addChatMessage({ chatId, authorId, message }) {
  return fetchJSON(`/api/chats/${chatId}/messages`, "post", {
    authorId,
    message,
  });
}

export function uploadFileToChat({ chatId, authorId, file }) {
  const formData = new FormData();
  formData.append("file", file);
  formData.append("authorId", authorId);

  return fetch(`/api/chats/${chatId}/attachments`, {
    method: "post",
    body: formData,
    headers: {
      "auth-token": session.getAuthToken(),
    },
  });
}
