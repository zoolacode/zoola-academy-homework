import React, { useState, useEffect } from "react";
import { MenuItem, MenuList, Paper } from "@mui/material";

const adminId = "c8e26274-93ee-4acb-9f51-126264adaeb2";
const currentUserId = "75da786f-b490-408d-9ea1-ee1675b98d3c";

export const Chats = () => {
  const [chats, setChats] = useState([]);

  useEffect(() => {
    const interval = setInterval(() => {
      fetch(`api/users/${currentUserId}/chats`, {
        headers: {
          "Content-Type": "application/json",
          "auth-token": adminId,
        },
      })
        .then((response) => response.json())
        .then((data) => setChats(data));
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  }, []);

  return (
    <Paper>
      <MenuList>
        {chats.map((chat) => {
          return <MenuItem key={chat.id}>{chat.title}</MenuItem>;
        })}
      </MenuList>
    </Paper>
  );
}
