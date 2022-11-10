import React, { useEffect, useState } from "react";

import { INTERVAL_UPDATE } from "../../constants";
import { getUsers, addChatMembers } from "../../function/requests";
import {
  Avatar,
  Button,
  Dialog,
  DialogContent,
  DialogTitle,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  Typography,
} from "@mui/material";
import { Stack } from "@mui/system";

export const AddChatMembersForm = ({
  userData = {},
  chatId,
  usersList,
  open,
  onClose,
}) => {
  const [chatMembers, setChatMembers] = useState([]);
  const [users, setUsers] = useState([]);

  const submitHandler = (e) => {
    e.preventDefault();
    setChatMembers([]);

    const membersData = {
      members: [...chatMembers],
    };

    addChatMembers(userData?.authToken, chatId, membersData);
  };

  useEffect(() => {
    if (userData.authToken) {
      const interval = setInterval(() => {
        getUsers(userData?.authToken).then((data) => setUsers(data));
      }, INTERVAL_UPDATE);

      return () => {
        clearInterval(interval);
      };
    }
  }, [userData]);

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>Group members</DialogTitle>
      <DialogContent sx={{ width: 400 }}>
        <Stack direction="column" spacing={1}>
          <form onSubmit={submitHandler}>
            <Stack spacing={2}>
              <FormControl sx={{ mt: 2 }}>
                <InputLabel>New members</InputLabel>
                <Select
                  label="Members"
                  multiple
                  value={chatMembers}
                  onChange={(e) => {
                    setChatMembers(e.target.value);
                  }}
                >
                  {users
                    .filter((user) => {
                      const userId = usersList.map((item) => item.id);
                      return !userId.includes(user.id);
                    })
                    .map((user) => (
                      <MenuItem key={user.id} value={user.id}>
                        {user.username}
                      </MenuItem>
                    ))}
                </Select>
              </FormControl>
              <Button type="submit">Add</Button>
            </Stack>
          </form>

          {usersList.map((user) => {
            return (
              <Stack
                direction="row"
                sx={{ alignItems: "center" }}
                key={user.id}
              >
                <Avatar>{user.username[0]}</Avatar>
                <Typography pl={2} variant="body1">
                  {user.username}
                </Typography>
              </Stack>
            );
          })}
        </Stack>
      </DialogContent>
    </Dialog>
  );
};
