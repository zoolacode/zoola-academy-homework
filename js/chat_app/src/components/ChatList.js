import React, { useContext } from "react";
import { UserContext } from "./UserContext";
import { serverResponse } from "./serverResponse";
import { Box, Paper, MenuItem, MenuList, Typography } from "@mui/material";

export const ChatList = ({ chatId, setChatID }) => {
  const [chatsData, setChatsData] = React.useState([]);
  const { auth } = useContext(UserContext);

  const userId = auth?.user.id;
  const token = auth?.authToken;

  const handleChatListItemClick = (event, id) => {
    setChatID(id);
  };

  React.useEffect(() => {
    const url = `api/users/${userId}/chats`;

    serverResponse(url, { "auth-token": token }).then(setChatsData);
  }, []);

  return (
    <Box sx={{ width: "100%", maxWidth: 360, bgcolor: "background.paper" }}>
      <Paper>
        {(chatsData.length === 0 && (
          <Typography align="center" sx={{ p: 1 }}>
            No existing chats
          </Typography>
        )) || (
          <MenuList>
            {chatsData.map((params) => {
              return (
                <MenuItem
                  selected={chatId === params.id}
                  onClick={(event) => handleChatListItemClick(event, params.id)}
                >
                  {params.title}
                </MenuItem>
              );
            })}
          </MenuList>
        )}
      </Paper>
    </Box>
  );
};
