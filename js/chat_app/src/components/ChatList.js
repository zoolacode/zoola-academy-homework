import React from "react";
import { Box, Paper, MenuItem, MenuList, Typography } from "@mui/material";

export const ChatList = ({ chatId, setChatId, chats }) => {
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
                  onClick={() => setChatId(chat.id)}
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
