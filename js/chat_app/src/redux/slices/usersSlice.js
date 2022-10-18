import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { userServices } from '../../services/userServices';

const usersSlice = createSlice({
  name: 'users',
  initialState: {
    users: []
  },
  extraReducers: (builder) => {
    builder.addCase(getAllUsers.fulfilled, (state, actions) => {
      state.users = actions.payload;
    });
  }
});

export const getAllUsers = createAsyncThunk('/api/users', async () => {
  const result = await userServices.getAllUsers().then((response) => response);
  return result.data;
});

export const { setIsAuth } = usersSlice.actions;
export default usersSlice;
