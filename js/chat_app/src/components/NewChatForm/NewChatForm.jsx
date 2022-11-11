import React, { useState, useEffect } from "react";

import { createChat, getUsers, addChatMembers } from "../../function/requests";
import { INTERVAL_UPDATE } from "../../constants";
import {
  Box,
  Button,
  Dialog,
  DialogContent,
  DialogTitle,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  Stack,
  TextField,
} from "@mui/material";

export const NewChatForm = ({ open, onClose, userInfo = {} }) => {
  const [chatMembers, setChatMembers] = useState([]);
  const [users, setUsers] = useState([]);
  const [chatName, setChatName] = useState("");

  const submitHandler = (e) => {
    e.preventDefault();
    setChatMembers([]);
    setChatName("");

    const userData = {
      userId: userInfo.user?.id,
      title: chatName,
    };

    const membersData = {
      members: [userInfo.user?.id, ...chatMembers],
    };

    createChat(userData, userInfo.authToken).then((chat) => {
      addChatMembers(userInfo.authToken, chat.id, membersData);
    });
  };

  useEffect(() => {
    if (userInfo.authToken) {
      const interval = setInterval(() => {
        getUsers(userInfo.authToken).then((data) => setUsers(data));
      }, INTERVAL_UPDATE);

      return () => {
        clearInterval(interval);
      };
    }
  }, [userInfo]);

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>Create new chat</DialogTitle>
      <DialogContent>
        <Box>
          <form onSubmit={submitHandler}>
            <Stack spacing={2}>
              <TextField
                label="Chat name"
                value={chatName}
                onChange={(e) => setChatName(e.target.value)}
              />
              <FormControl sx={{ width: 300 }}>
                <InputLabel>Members</InputLabel>
                <Select
                  label="Members"
                  multiple
                  value={chatMembers}
                  onChange={(e) => {
                    setChatMembers(e.target.value);
                  }}
                >
                  {users
                    .filter((user) => user.id !== userInfo.user.id)
                    .map((user) => (
                      <MenuItem key={user.id} value={user.id}>
                        {user.username}
                      </MenuItem>
                    ))}
                </Select>
              </FormControl>
              <Button variant="outlined" type="submit">
                Create
              </Button>
            </Stack>
          </form>
        </Box>
      </DialogContent>
    </Dialog>
  );
};
