import { configureStore } from '@reduxjs/toolkit';
import authSlice from './auth/slice';
import userSlice from './user/slice';

let preloadedState;
const persistedAuthString = localStorage.getItem('auth');
const persistedChatsString = localStorage.getItem('user');
if (persistedAuthString && persistedChatsString) {
  preloadedState = {
    auth: {
      auth: JSON.parse(persistedAuthString)
    },
    user: {
      user: JSON.parse(persistedChatsString)
    }
  };
}

const store = configureStore({
  reducer: { auth: authSlice.reducer, user: userSlice.reducer },
  preloadedState
});

export default store;