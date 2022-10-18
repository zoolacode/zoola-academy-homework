import React, { useState, useEffect } from "react";
import {
  Avatar,
  Box,
  Button,
  Dialog,
  DialogContent,
  DialogTitle,
  Stack,
  TextField,
  Typography,
} from "@mui/material";

const adminId = "c8e26274-93ee-4acb-9f51-126264adaeb2";

export const NewUserForm = ({ open, onClose }) => {
  const [userName, setUserName] = useState("");
  const [userPassword, setUserPassword] = useState("");
  const [users, setUsers] = useState([]);

  useEffect(() => {
    const interval = setInterval(() => {
      fetch("/api/users", {
        headers: {
          "Content-Type": "application/json",
          "auth-token": adminId,
        },
      })
        .then((response) => response.json())
        .then((data) => setUsers(data));
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  }, []);

  const submitHandler = async () => {
    if (userName.length === 0 || userPassword.length === 0) {
      return;
    }

    const data = {
      username: userName,
      password: userPassword,
    };

    await fetch("/api/users", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "auth-token": adminId,
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  return (
    <Dialog
      open={open}
      onClose={() => {
        onClose();
      }}
    >
      <DialogTitle>Create user</DialogTitle>
      <DialogContent sx={{ width: 400 }}>
        <Stack mt={1} spacing={5}>
          <Box>
            <form
              onSubmit={(e) => {
                e.preventDefault();
                setUserName("");
                setUserPassword("");
              }}
            >
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
                <Button fullWidth variant="outlined" onClick={submitHandler}>
                  Send
                </Button>
              </Stack>
            </form>
          </Box>
          <Box>
            <Stack spacing={1}>
              {users.map((user) => {
                return (
                  <Box key={user.id}>
                    <Stack sx={{ alignItems: "center" }} direction="row">
                      <Avatar>{user.username[0]}</Avatar>
                      <Box ml={2}>
                        <Typography>{user.username}</Typography>
                      </Box>
                    </Stack>
                  </Box>
                );
              })}
            </Stack>
          </Box>
        </Stack>
      </DialogContent>
    </Dialog>
  );
};
