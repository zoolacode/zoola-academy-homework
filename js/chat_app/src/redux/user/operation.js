import { createAsyncThunk } from '@reduxjs/toolkit';
import { userServices } from '../../services/userServices';

const getAllUserChats = createAsyncThunk('user/chats', async ({ authToken, userId }) => {
  const response = await userServices.getUserChats({
    authToken,
    userId
  });
  const data = await response.json();
  localStorage.setItem('user', JSON.stringify(data));
  return data;
});

export default getAllUserChats;
