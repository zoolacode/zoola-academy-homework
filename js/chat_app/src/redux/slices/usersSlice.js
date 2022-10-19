import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { userServices } from '../../services/userServices';

const initialState = {
  allUsers: []
};

const usersSlice = createSlice({
  name: 'users',
  initialState,
  reducers: {
  },
  extraReducers: (builder) => {
    builder.addCase(getAllUsers.fulfilled, (state, action) => {
      state.allUsers = action.payload;
    });
  }
});

export const getAllUsers = createAsyncThunk('/api/users', async (adminToken) => {
  const response = await userServices.getAllUsers(adminToken);
  return response;
});

export const { setIsAuth } = usersSlice.actions;
export default usersSlice;
