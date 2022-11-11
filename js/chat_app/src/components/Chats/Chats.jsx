import React, { useState, useEffect } from "react";

import { getChatsByUserId } from "../../function/requests";
import { INTERVAL_UPDATE } from "../../constants";
import { MenuItem, MenuList, Paper } from "@mui/material";

export const Chats = ({ userData = {} }) => {
  const [chats, setChats] = useState([]);

  useEffect(() => {
    const interval = setInterval(() => {
      if (userData?.user?.id) {
        getChatsByUserId(userData.authToken, userData.user.id).then((data) =>
          setChats(data)
        );
      }
    }, INTERVAL_UPDATE);

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
};
