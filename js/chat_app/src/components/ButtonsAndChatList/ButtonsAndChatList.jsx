import React, { useState, useEffect } from "react";
import { MenuItem, MenuList, Paper, Container } from "@mui/material";

import { Chat } from "../Chat/Chat";
import { CreateButtons } from "../CreateButtons/CreateButtons";
import { getChatsByUserId } from "../../function/requests";
import { INTERVAL_UPDATE } from "../../constants";

import "./ButtonsAndChatList.css";

export const ButtonsAndChatList = ({ userData = {} }) => {
  const [chats, setChats] = useState([]);
  const [chatId, setChatId] = useState("");

  useEffect(() => {
    if (userData.authToken) {
      const interval = setInterval(() => {
        getChatsByUserId(userData.authToken, userData.user.id)
        .then((data) => setChats(data));
      }, INTERVAL_UPDATE);

      return () => {
        clearInterval(interval);
      };
    }
  }, [userData]);

  return (
    <Container maxWidth="lg" fixed={true}>
    <div className="chatsAndButtons">
      <div className="container">
        <CreateButtons userData={userData} />
        <div className="chat">
          <Paper>
            <MenuList className="chatList">
              {chats.map(chat => (
                  <MenuItem key={chat.id} onClick={() => setChatId(chat.id)}>
                    {chat.title}
                  </MenuItem>
                )
              )}
            </MenuList>
          </Paper>
        </div>
      </div>
      <Chat chatId={chatId} userData={userData} />
    </div>
    </Container>
  );
};
