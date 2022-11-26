import { createAsyncThunk } from '@reduxjs/toolkit';
import { chatServices } from '../../services/chatServices';

const getUserChat = createAsyncThunk('chat/chats', async ({ authToken, currentChatId }) => {
  console.log('chatId', currentChatId);
  console.log('authToken', authToken);
  const data = await chatServices.getChat({
    authToken,
    currentChatId
  });
  console.log('data', data);
  return data;
});

export default getUserChat;
