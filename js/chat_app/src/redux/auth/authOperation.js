import { createAsyncThunk } from '@reduxjs/toolkit';

import login from '../../services/services';

const loginAuth = createAsyncThunk('auth/login', async ({ username, password }) => {
  const response = await login({ username, password });
  const data = await response.json();
  const result = await localStorage.setItem('auth', JSON.stringify(data));
  return data;
});

export default loginAuth;
