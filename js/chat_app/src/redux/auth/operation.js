import { createAsyncThunk } from '@reduxjs/toolkit';

import login from '../../services/authServices';

const loginAuth = createAsyncThunk('auth/login', async ({ username, password }) => {
  const response = await login({
    username,
    password
  });
  const data = await response.json();
  localStorage.setItem(
    'auth',
    JSON.stringify({
      authToken: data.authToken,
      isAdmin: data.isAdmin,
      user: {
        id: data.user.id,
        username: data.user.username
      }
    })
  );
  return data;
});

export default loginAuth;
