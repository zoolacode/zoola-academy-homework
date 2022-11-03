import React, { useState, useEffect } from "react";
import { MenuItem, MenuList, Paper } from "@mui/material";
import { fetchRequestJSON } from "../../function/fetch";
import { Chat } from "../Chat/Chat";
import { CreateButtons } from "../CreateButtons/CreateButtons";

import "./ButtonsAndChatList.css";

const intervalUpdate = 1000;

export const ButtonsAndChatList = ({ userData }) => {
  const [chats, setChats] = useState([]);
  const [chatId, setChatId] = useState("");

  useEffect(() => {
    if (userData.authToken) {
      console.log(userData);
      const interval = setInterval(() => {
        fetchRequestJSON(
          `api/users/${userData.user.id}/chats`,
          "GET",
          userData.authToken
        ).then((data) => setChats(data));
      }, intervalUpdate);

      return () => {
        clearInterval(interval);
      };
    }
  }, [userData]);

  return (
    <div className="chatsAndButtons">
      <div className="container">
        <CreateButtons userData={userData} />
        <div className="chat">
          <Paper>
            <MenuList className="chatList">
              {chats.map((chat) => {
                return (
                  <MenuItem key={chat.id} onClick={() => setChatId(chat.id)}>
                    {chat.title}
                  </MenuItem>
                );
              })}
            </MenuList>
          </Paper>
        </div>
      </div>
      <Chat chatId={chatId} userData={userData} />
    </div>
  );
};
