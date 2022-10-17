import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { usersAPI } from '../../services/usersAPI';

const usersSlice = createSlice({
  name: 'users',
  initialState: {
    users: ['nikita']
  },
  extraReducers: (builder) => {
    builder.addCase(getAllUsers.fulfilled, (state, actions) => {
      state.users = actions.payload;
    });
  }
});

export const getAllUsers = createAsyncThunk('/api/users', async () => {
  const result = await usersAPI.getAllUsers().then((response) => response);
  return result.data;
});

export const { setIsAuth } = usersSlice.actions;
export default usersSlice;
