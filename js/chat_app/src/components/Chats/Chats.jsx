import React, { useState, useEffect } from "react";
import { MenuItem, MenuList, Paper } from "@mui/material";
import { fetchRequestJSON } from "../../function/fetch";

const adminId = "c8e26274-93ee-4acb-9f51-126264adaeb2";
const currentUserId = "75da786f-b490-408d-9ea1-ee1675b98d3c";
const intervalUpdate = 1000;

export const Chats = () => {
  const [chats, setChats] = useState([]);

  useEffect(() => {
    const interval = setInterval(() => {
      fetchRequestJSON(`api/users/${currentUserId}/chats`, "GET", adminId).then((data) => setChats(data));
    }, intervalUpdate);

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
