import { configureStore } from '@reduxjs/toolkit';
import authSlice from './auth/authSlice';

let preloadedState;
const persistedTodosString = localStorage.getItem('auth');

if (persistedTodosString) {
  preloadedState = {
    auth: {
      auth: JSON.parse(persistedTodosString)
    }
  };
}

const store = configureStore({
  reducer: { auth: authSlice.reducer },
  preloadedState
});

export default store;
