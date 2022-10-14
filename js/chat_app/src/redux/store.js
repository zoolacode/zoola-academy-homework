import { configureStore } from '@reduxjs/toolkit';
import authSlice from './slicies/authSlice';

const store = configureStore({
  reducer: authSlice.reducer
});

export default store;
