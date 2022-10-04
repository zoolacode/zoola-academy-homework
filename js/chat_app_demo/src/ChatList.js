import { MenuItem, MenuList, Paper, Typography } from "@mui/material";
import React from "react";

export function ChatList({ chats, currentChatId, onChatChange }) {
  if (!chats.length) {
    return <Typography variant="body2">No chats</Typography>;
  }

  return (
    <Paper>
      <MenuList>
        {chats?.map((chat) => {
          return (
            <MenuItem
              selected={chat.id === currentChatId}
              onClick={() => onChatChange(chat.id)}
              key={chat.id}
            >
              {chat.title}
            </MenuItem>
          );
        })}
      </MenuList>
    </Paper>
  );
}
