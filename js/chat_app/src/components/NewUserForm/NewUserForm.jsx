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
import { fetchRequestJSON } from "../../function/fetch";

const adminId = "c8e26274-93ee-4acb-9f51-126264adaeb2";
const intervalUpdate = 1000;

export const NewUserForm = ({ open, onClose }) => {
  const [userName, setUserName] = useState("");
  const [userPassword, setUserPassword] = useState("");
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const interval = setInterval(() => {
      fetchRequestJSON("/api/users", "GET", adminId).then((data) =>
        setUsers(data)
      );
    }, intervalUpdate);

    return () => {
      clearInterval(interval);
    };
  }, []);

  const submitHandler = async (e) => {
    if (userName.length === 0 || userPassword.length === 0) {
      return;
    }
    e.preventDefault();
    setUserName("");
    setUserPassword("");

    const data = {
      username: userName,
      password: userPassword,
    };

    fetchRequestJSON("/api/users", "POST", adminId, data);
  };

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>Create user</DialogTitle>
      <DialogContent sx={{ width: 400 }}>
        <Stack mt={1} spacing={5}>
          <Box>
            <form>
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
                <Button
                  fullWidth
                  variant="outlined"
                  onClick={submitHandler}
                  onSubmit
                >
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
