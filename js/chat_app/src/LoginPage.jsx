import React from "react";
import { useState } from "react";
import LoginIcon from "@mui/icons-material/Login";
import {
  Grid,
  FormControl,
  Typography,
  Box,
  TextField,
  Button,
} from "@mui/material";

export const LoginPage = ({ setUserData }) => {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");

  function submitLogin() {
    if (userName && password) {
      request(userName.trim(), password.trim()).then((result) =>
        setUserData(result)
      );

      setUserName("");
      setPassword("");
    }
  }

  function request(username, password) {
    return fetch("/api/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json; charset=UTF-8",
      },
      body: JSON.stringify({
        username,
        password,
      }),
    }).then((response) => response.json());
  }

  return (
    <Grid container spacing={2} mt={5}>
      <Grid item xs={12}>
        <FormControl>
          <Typography variant="h5" mb={5}>
            Welcome to chat
          </Typography>
          <Box
            component="form"
            sx={{ display: "flex", flexDirection: "column", gap: 2 }}
            noValidate
            autoComplete="off"
          >
            <TextField
              value={userName}
              placeholder="Username"
              onChange={(e) => setUserName(e.target.value)}
            />
            <TextField
              value={password}
              type="password"
              placeholder="Password"
              onChange={(e) => setPassword(e.target.value)}
            />
          </Box>
          <Button sx={{ mt: 3 }} endIcon={<LoginIcon />} onClick={submitLogin}>
            Login
          </Button>
        </FormControl>
      </Grid>
    </Grid>
  );
};
