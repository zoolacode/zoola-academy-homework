import { createSlice, createAction } from '@reduxjs/toolkit';
import loginAuth from './operation';

export const isLogout = createAction('logout');
const initialState = {
  auth: {},
  isLogin: false,
  error: false,
  isLogout: true
};

const authSlice = createSlice({
  name: 'isAdmin',
  initialState,
  extraReducers: {
    [loginAuth.fulfilled](state, action) {
      state.auth = action.payload;
      state.isLogin = true;
      state.isLogout = false;
    },
    [loginAuth.rejected](state) {
      state.isLogin = false;
      state.error = true;
    },
    [isLogout](state) {
      state.auth = {};
      state.error = null;
      state.isLogin = false;
      state.isLogout = true;
    }
  }
});

export default authSlice;
