import { configureStore } from '@reduxjs/toolkit';
import testSlice from './slicies/testSlise';

const store = configureStore({
  reducer: testSlice.reducer
});

export default store;
