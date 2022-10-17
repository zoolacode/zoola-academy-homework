import { configureStore } from '@reduxjs/toolkit';
import authSlice from './slicies/authSlice';
import usersSlice from './slicies/usersSlice';

const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
    users: usersSlice.reducer
  }
});

export default store;
