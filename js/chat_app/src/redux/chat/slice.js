import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { chatServices } from '../../services/chatServices';
import getUserChat from './operetion';
import { userServices } from '../../services/userServices';

const initialState = {
  chatData: {
  },
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
      .addCase(getUserChat.fulfilled, (state, action) => {
        state.chatData = action.payload;
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
      const authorId = getState().auth.auth.user.id;
      const membersId = getState().chat.selectedMembers;

      const response = await chatServices.createChat(title, authToken);

      const paramsForAddMembers = {
        chatId: response.id,
        members: [authorId, ...membersId],
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

export const getChatByIdThunk = createAsyncThunk(
  'getChatById/api/chats/:chatId',
  async (_, { getState }) => {
    const chatId = '6fd9d223-11c7-4969-98ce-2986bd2c2a88';
    const { authToken } = getState().auth.auth;

    return chatServices.getChatById(chatId, authToken);
  }
);

export const getUserByIdThunk = createAsyncThunk(
  'getUserById/api/users/:userId',
  async (userId, { getState }) => {
    const { authToken } = getState().auth.auth;
    const response = await userServices.getUserById(authToken, userId);

    return response;
  }
);

export const sendMessageByChatIdThunk = createAsyncThunk(
  'sendMessageByChatId/api/chats/:chatId/messages',
  async (params, { getState }) => {
    const { message } = params;
    const chatId = getState().chat.chatData.id;
    const { authToken } = getState().auth.auth;
    const authorId = getState().auth.auth.user.id;

    return chatServices.sendMessageByChatId(chatId, authToken, message, authorId);
  }
);

export const getMessageByChatId = createAsyncThunk(
  'getMessageByChatId/api/chats/:chatId',
  async (params, { getState }) => {
    const { message } = params;
    const chatId = getState().chat.chatData.id;
    const { authToken } = getState().auth.auth;
    const authorId = getState().auth.auth.user.id;

    return chatServices.sendMessageByChatId(chatId, authToken, message, authorId);
  }
);

export const sendUploadsByChatIdThunk = createAsyncThunk(
  'sendUploadsByChatId/api/chats/:chatId/attachments',
  async (fileObject, { getState }) => {
    const chatId = getState().chat.chatData.id;
    const { authToken } = getState().auth.auth;
    const authorId = getState().auth.auth.user.id;

    return chatServices.sendUploadsByChatId(chatId, authToken, fileObject, authorId);
  }
);

export const { setSelectedMembers } = chatSlice.actions;
export default chatSlice;
