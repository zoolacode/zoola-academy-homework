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

import { login } from "../function/requests";

export const LoginPage = ({ setUserData }) => {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");

  function submitLogin() {
    if (userName && password) {
      login({username: userName.trim(), password: password.trim()})
      .then((result) =>
        setUserData(result)
      ).catch(err => console.log(err));

      setUserName("");
      setPassword("");
    }
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
