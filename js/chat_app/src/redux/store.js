import { configureStore } from '@reduxjs/toolkit';
import authSlice from './slices/authSlice';
import chatSlice from './slices/chatSlice';
import usersSlice from './slices/usersSlice';

const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
    users: usersSlice.reducer,
    chat: chatSlice.reducer
  }
});

export default store;
