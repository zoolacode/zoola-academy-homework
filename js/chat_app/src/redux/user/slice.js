import { createSlice } from '@reduxjs/toolkit';
import getAllUserChats from './operation';


const initialState = {
  user: []
};

const userSlice = createSlice({
  name: 'user',
  initialState,
  extraReducers: {
    [getAllUserChats.fulfilled](state, action) {
      state.user = action.payload;
    }
  }
});

export default userSlice;
