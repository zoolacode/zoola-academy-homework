import React, { useContext } from "react";
import { UserContext } from "./UserContext";
import { useHttpClient } from "./serverResponse";
import { Box, Paper, MenuItem, MenuList, Typography } from "@mui/material";

export const ChatList = ({ chatId, setChatID, chats }) => {
  const [chatsData, setChatsData] = React.useState([]);
  const { auth } = useContext(UserContext);

  const userId = auth?.user.id;
  //const token = auth?.authToken;

  const handleChatListItemClick = (event, id) => {
    setChatID(id);
  };
  const fetchJSON = useHttpClient();

  React.useEffect(() => {
    fetch(`api/users/${userId}/chats`, {
      method: "GET",
      headers: {
        "auth-token": authToken,
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then(setChatsData);
  }, [chats]);
    const url = `api/users/${userId}/chats`;

    fetchJSON(url).then(setChatsData);
  }, []);

  return (
    <Box sx={{ width: "100%", maxWidth: 360, bgcolor: "background.paper" }}>
      <Paper>
        {chatsData.length === 0 ? (
          <Typography align="center" sx={{ p: 1 }}>
            No existing chats
          </Typography>
        ) : (
          <MenuList>
            {chatsData.map((chat) => {
              return (
                <MenuItem
                  selected={chatId === chat.id}
                  onClick={(event) => handleChatListItemClick(event, chat.id)}
                >
                  {chat.title}
                </MenuItem>
              );
            })}
          </MenuList>
        )}
      </Paper>
    </Box>
  );
};
