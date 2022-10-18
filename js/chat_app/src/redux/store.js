import { configureStore } from '@reduxjs/toolkit';
import authSlice from './slices/authSlice';
import usersSlice from './slices/usersSlice';

const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
    users: usersSlice.reducer
  }
});

export default store;
