import React from 'react';
import { useState } from 'react';
import LoginIcon from '@mui/icons-material/Login';
import Grid from '@mui/material/Grid';
import FormControl from '@mui/material/FormControl';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

export function LoginPage({ setUserData }) {
  const [userName, setUserName] = useState('');
  const [password, setPassword] = useState('');

  function submitLogin() {
    if (userName && password) {
      request(userName.trim(), password.trim()).then((result) =>
        setUserData(result)
      );

      setUserName('');
      setPassword('');
    }
  }

  return (
    <Grid container spacing={2} mt={5}>
      <Grid item xs={12}>
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
          <Button
            sx={{ mt: 3 }}
            endIcon={<LoginIcon />}
            onClick={() => submitLogin()}
          >
            Login
          </Button>
        </FormControl>
      </Grid>
    </Grid>
  );
}

function request(userName, password) {
  return fetch('/api/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json; charset=UTF-8',
    },
    body: JSON.stringify({
      username: userName,
      password: password,
    }),
  }).then((response) => response.json());
}
