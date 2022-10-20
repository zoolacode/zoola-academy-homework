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
    builder
      .addCase(getAllUsersThunk.fulfilled, (state, action) => {
        state.allUsers = action.payload;
      });
  }
});

export const getAllUsersThunk = createAsyncThunk('getAllUsers/api/users', async (adminToken) => {
  const response = await userServices.getAllUsers(adminToken);
  return response;
});

export const createUserThunk = createAsyncThunk('createUser/api/users', async (paramsForCreateUser) => {
  const { adminToken, username, password, adminId } = paramsForCreateUser;
  await userServices.createUser(adminToken, username, password, adminId);
});

export const { setIsAuth } = usersSlice.actions;
export default usersSlice;
