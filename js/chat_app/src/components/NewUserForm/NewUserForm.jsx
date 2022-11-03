import React, { useState, useEffect } from "react";
import {
  Box,
  Button,
  Dialog,
  DialogContent,
  DialogTitle,
  Stack,
  TextField,
} from "@mui/material";

import { UsersList } from "../UsersList/UsersList";
import { getUsers, createUser } from "../../function/requests";
import { INTERVAL_UPDATE } from "../../constants";

export const NewUserForm = ({ open, onClose, userInfo = {} }) => {
  const [userName, setUserName] = useState("");
  const [userPassword, setUserPassword] = useState("");
  const [users, setUsers] = useState([]);

  useEffect(() => {
    if (userInfo.authToken) {
      const interval = setInterval(() => {
        getUsers(userInfo.authToken).then((data) =>
          setUsers(data)
        );
      }, INTERVAL_UPDATE);

      return () => {
        clearInterval(interval);
      };
    }
  }, [userInfo]);

  const submitHandler = (e) => {
    if (userName.length === 0 || userPassword.length === 0) {
      return;
    }
    e.preventDefault();

    const data = {
      username: userName,
      password: userPassword,
    };
    createUser(data,  userInfo.authToken);

    setUserName("");
    setUserPassword("");
  };

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>Create user</DialogTitle>
      <DialogContent sx={{ width: 400 }}>
        <Stack mt={1} spacing={5}>
          <Box>
            <form onSubmit={submitHandler}>
              <Stack spacing={2}>
                <TextField
                  label="Username"
                  value={userName}
                  onChange={(e) => setUserName(e.target.value)}
                />
                <TextField
                  label="Password"
                  type="password"
                  value={userPassword}
                  onChange={(e) => setUserPassword(e.target.value)}
                />
                <Button fullWidth variant="outlined" type="submit">
                  Send
                </Button>
              </Stack>
            </form>
          </Box>
          <UsersList users={users} />
        </Stack>
      </DialogContent>
    </Dialog>
  );
};
