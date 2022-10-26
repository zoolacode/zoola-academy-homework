import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { chatServices } from '../../services/chatServices';

const initialState = {
  chatData: null,
  selectedMembers: []
};

const chatSlice = createSlice({
  name: 'chat',
  initialState,
  reducers: {
    setMembers: (state, action) => {
      state.selectedMembers = action.payload;
    }
  }
});

export const addChatMembersThunk = createAsyncThunk(
  'addMembers/api/chat/:chatId/members',
  async (paramsForAddMembers) => {
    const { chatId, authToken, members } = paramsForAddMembers;
    await chatServices.addChatMembers(chatId, authToken, members);
  }
);

export const createChatThunk = createAsyncThunk(
  'createChat/api/chats',
  async (paramsForCreateChat, { getState, dispatch }) => {
    const { title, authToken } = paramsForCreateChat;
    const membersId = getState().chat.selectedMembers;

    const response = await chatServices.createChat(title, authToken);

    const paramsForAddMembers = {
      chatId: response.id,
      members: membersId,
      authToken
    };

    dispatch(addChatMembersThunk(paramsForAddMembers));
  }
);

export const { setMembers } = chatSlice.actions;
export default chatSlice;
