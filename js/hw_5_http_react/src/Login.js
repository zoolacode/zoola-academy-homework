import { Button, Stack, TextField, Typography } from "@mui/material";
import LoginIcon from "@mui/icons-material/Login";
import React from "react";
import { login } from "./httpUtils";
import { Box } from "@mui/system";

export function LoginForm({ onLogin }) {
  const [username, setUsername] = React.useState("");
  const [password, setPassword] = React.useState("");

  function onSubmitLoginForm(e) {
    e.preventDefault();
    login({ username, password }).then(onLogin);
  }

  return (
    <form className="login-form" onSubmit={onSubmitLoginForm}>
      <Typography variant="h5">Welcome to chat</Typography>
      <Box padding={4}>
        <Stack spacing={2}>
          <TextField
            label="Username"
            onChange={(e) => setUsername(e.target.value)}
          />

          <TextField
            label="Password"
            onChange={(e) => setPassword(e.target.value)}
            type="password"
          />

          <Button endIcon={<LoginIcon />} color="primary" type="submit">
            Login
          </Button>
        </Stack>
      </Box>
    </form>
  );
}
