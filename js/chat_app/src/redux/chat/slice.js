import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { chatServices } from '../../services/chatServices';
import getChatsUsers from './operation';

const initialState = {
  chat: {
},
  chats: [],
  chatData: null,
  selectedMembers: [],
  status: 'fullfield',
  isError: false
};

const chatSlice = createSlice({
  name: 'chat',
  initialState,
  reducers: {
    setSelectedMembers: (state, action) => {
      state.selectedMembers = action.payload;
    }
  },
  extraReducers: (builder) => {
    builder
      .addCase(createChatThunk.fulfilled, (state, action) => {
        state.status = action.meta.requestStatus;
        state.isError = false;
      })
      .addCase(createChatThunk.pending, (state, action) => {
        state.status = action.meta.requestStatus;
      })
      .addCase(createChatThunk.rejected, (state, action) => {
        state.status = action.meta.requestStatus;
        state.isError = true;
      })
      .addCase(getChatsUsers.getUserChat.fulfilled, (state, action) => {
        state.chat = action.payload;
      })
      .addCase(getChatsUsers.getAllChats.fulfilled, (state, action) => {
        state.chats = action.payload;
      });
  }
});

export const addChatMembersThunk = createAsyncThunk(
  'addMembers/api/chat/:chatId/members',
  async (paramsForAddMembers, { getState }) => {
    const { authToken } = getState().auth.auth;
    const { chatId, members } = paramsForAddMembers;
    return chatServices.addChatMembers(chatId, authToken, members);
  }
);

export const createChatThunk = createAsyncThunk(
  'createChat/api/chats',
  async (title, { getState, dispatch, rejectWithValue }) => {
    try {
      const { authToken } = getState().auth.auth;
      const authId = getState().auth.auth.user.id;
      const membersId = getState().chat.selectedMembers;

      const response = await chatServices.createChat(title, authToken);

      const paramsForAddMembers = {
        chatId: response.id,
        members: [authId, ...membersId],
        authToken
      };

      dispatch(addChatMembersThunk(paramsForAddMembers));

      return response;
    } catch (error) {
      if (!error.response) {
        throw error;
      }

      return rejectWithValue(error.response.data);
    }
  }
);

export const { setSelectedMembers } = chatSlice.actions;
export default chatSlice;
