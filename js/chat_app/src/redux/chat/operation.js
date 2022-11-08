import { createAsyncThunk } from '@reduxjs/toolkit';
import { chatServices } from '../../services/chatServices';

const getUserChat = createAsyncThunk('chat/chats', async ({ authToken, chatId }) => {
  const data = await chatServices.getChat({
    authToken,
    chatId
  });
  // const data = await response.json();
  console.log('data', data);
  localStorage.setItem('user', JSON.stringify(data));
  return data;
});

const getAllChats = createAsyncThunk('chat/all/chats', async ({ authToken }) => {
  const data = await chatServices.getAllChats({
    authToken
  });
    // const data = await response.json();
  console.log('data', data);
  localStorage.setItem('user', JSON.stringify(data));
  return data;
});
const getChatsUsers = {
  getUserChat,
  getAllChats
};
export default getChatsUsers;
