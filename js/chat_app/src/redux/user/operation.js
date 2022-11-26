import { createAsyncThunk } from '@reduxjs/toolkit';
import { userServices } from '../../services/userServices';

const getAllUserChats = createAsyncThunk('user/chats/all', async ({ authToken, userId }) => {
  const data = await userServices.getUserChats({
    authToken,
    userId
  });
  console.log('data', data);
  localStorage.setItem('user', JSON.stringify(data));
  return data;
});

export default getAllUserChats;
