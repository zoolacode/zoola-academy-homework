import React, { useState, useEffect } from "react";
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

import { createChat, getUsers, addChatMembers } from "../../function/requests";
import { INTERVAL_UPDATE } from "../../constants";

export const NewChatForm = ({ open, onClose, authToken, user }) => {
  const [chatMembers, setChatMembers] = useState([]);
  const [users, setUsers] = useState([]);
  const [chatName, setChatName] = useState("");

  const submitHandler = async (e) => {
    e.preventDefault();
    setUsers([]);
    setChatName("");

    const userData = {
      userId: user?.id,
      title: chatName,
    };

    const membersData = {
      members: [user?.id, ...chatMembers],
    };

    createChat(userData, authToken).then(
      (chat) => {
        addChatMembers(authToken, chat.id, membersData);
      }
    );
  };

  useEffect(() => {
    const interval = setInterval(() => {
      getUsers(authToken).then((data) =>
        setUsers(data)
      );
    }, INTERVAL_UPDATE);

    return () => {
      clearInterval(interval);
    };
  }, [authToken]);

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
                    .filter(({id}) => id !== user?.id)
                    .map(({id, username}) => (
                      <MenuItem key={id} value={id}>
                        {username}
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
