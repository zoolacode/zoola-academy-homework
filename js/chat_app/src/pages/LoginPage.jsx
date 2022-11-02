import React, { useState } from 'react';
import LoginIcon from '@mui/icons-material/Login';
import {
  FormControl,
  Typography,
  Box,
  TextField,
  Button,
} from '@mui/material';
import { login } from "../function/requests";

export function LoginPage({ setUserData }) {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');

  function submitLogin() {
    if (userName && password) {
      login({username: userName.trim(), password: password.trim()})
      .then((response) => {
        setUserData(response);
      })
      .catch(err => console.log(err));

      setUserName('');
      setPassword('');
    }
  }

  return (
    <FormControl>
      <Typography variant='h5' mb={5}>
        Welcome to chat
      </Typography>
      <Box
        component='form'
        sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}
        noValidate
        autoComplete='off'
      >
        <TextField
          value={userName}
          placeholder='Username'
          onChange={(e) => setUserName(e.target.value)}
        />
        <TextField
          value={password}
          type='password'
          placeholder='Password'
          onChange={(e) => setPassword(e.target.value)}
        />
      </Box>
      <Button sx={{ mt: 3 }} endIcon={<LoginIcon />} onClick={submitLogin}>
        Login
      </Button>
    </FormControl>
  );
}
