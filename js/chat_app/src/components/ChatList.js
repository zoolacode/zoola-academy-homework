import React from "react";
import { Box, Paper, MenuItem, MenuList, Typography } from "@mui/material";

export const ChatList = ({ chatId, setChatID, chats }) => {
  const handleChatListItemClick = (event, id) => {
    setChatID(id);
  };

  return (
    <Box sx={{ width: "100%", maxWidth: 360, bgcolor: "background.paper" }}>
      <Paper>
        {chats.length === 0 ? (
          <Typography align="center" sx={{ p: 1 }}>
            No existing chats
          </Typography>
        ) : (
          <MenuList>
            {chats.map((chat) => {
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
