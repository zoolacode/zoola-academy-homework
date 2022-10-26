import { configureStore } from '@reduxjs/toolkit';
import authSlice from './auth/slice';

let preloadedState;
const persistedAuthString = localStorage.getItem('auth');

if (persistedAuthString) {
  preloadedState = {
    auth: {
      auth: JSON.parse(persistedAuthString)
    }
  };
}

const store = configureStore({
  reducer: { auth: authSlice.reducer },
  preloadedState
});

export default store;
