import { configureStore } from '@reduxjs/toolkit';
import usersSlice from './users/slice';
import authSlice from './auth/slice';
import userSlice from './user/slice';
import chatSlice from './chat/slice';

let preloadedState;
const persistedAuthString = localStorage.getItem('auth');
const persistedChatsString = localStorage.getItem('user');
if (persistedAuthString && persistedChatsString) {
  preloadedState = {
    auth: {
      auth: JSON.parse(persistedAuthString)
    },
    // user: {
    //   user: JSON.parse(persistedChatsString)
    // }
  };
}

const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
    users: usersSlice.reducer,
    chat: chatSlice.reducer,
    user: userSlice.reducer
  },
  preloadedState
});

export default store;
