import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { chatServices } from '../../services/chatServices';
import authSelectors from '../auth/selector';
import chatSelectors from './selector';

const initialState = {
  chatData: null,
  selectedMembers: [],
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
      .addCase(createChatThunk.fulfilled, (state) => {
        state.isError = false;
      })
      .addCase(createChatThunk.rejected, (state) => {
        state.isError = true;
      })

      .addCase(getChatByIdThunk.fulfilled, (state, action) => {
        state.isError = false;
        state.chatData = action.payload;
      })
      .addCase(getChatByIdThunk.rejected, (state) => {
        state.isError = true;
      });
  }
});

export const addChatMembersThunk = createAsyncThunk(
  'addMembers/api/chat/:chatId/members',
  async (paramsForAddMembers, { getState, dispatch }) => {
    const authToken = authSelectors.getAuthToken(getState());
    const currentChatId = chatSelectors.getChatId(getState());
    const { chatId, members } = paramsForAddMembers;

    const response = await chatServices.addChatMembers(chatId, authToken, members);

    if (currentChatId === chatId) {
      dispatch(getChatByIdThunk(response?.id, authToken));
    }
  }
);

export const createChatThunk = createAsyncThunk(
  'createChat/api/chats',
  async (title, { getState, dispatch, rejectWithValue }) => {
    try {
      const authToken = authSelectors.getAuthToken(getState());
      const authId = authSelectors.getAuthUserId(getState());
      const membersId = chatSelectors.getSelectedMembers(getState());

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

export const getChatByIdThunk = createAsyncThunk('getChatById/api/chats/:id', async (chatId, { getState }) => {
  try {
    const authToken = authSelectors.getAuthToken(getState());

    return chatServices.getChatById(chatId, authToken);
  } catch (error) {
    if (!error.response) {
      throw error;
    }

    return rejectWithValue(error.response.data);
  }
});

export const { setSelectedMembers } = chatSlice.actions;
export default chatSlice;
