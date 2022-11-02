import React, { useState } from 'react';
import { Button } from "@mui/material";
import { NewUserForm } from "../components/NewUserForm/NewUserForm";
import { NewChatForm } from "../components/NewChatForm/NewChatForm";
import { Chats } from "../components/Chats/Chats";

export const ChatPage = ({
    userData = {}
}) => {
  const [isCreateUserOpen, setIsCreateUserOpen] = useState(false);
  const [isCreateChatOpen, setIsCreateChatOpen] = useState(false);

  return (
    <>
      <Button variant="contained" onClick={() => setIsCreateUserOpen(true)}>
        Create user
      </Button>
      <Button variant="outlined" onClick={() => setIsCreateChatOpen(true)}>
        Create new chat
      </Button>
      <NewUserForm
        open={isCreateUserOpen}
        onClose={() => setIsCreateUserOpen(false)}
        authToken={userData.authToken}
        user={userData.user}
      />
      <NewChatForm
        open={isCreateChatOpen}
        onClose={() => setIsCreateChatOpen(false)}
        authToken={userData.authToken}
        user={userData.user}
      />
      <Chats />
    </>
  );
}