import { createSlice } from '@reduxjs/toolkit';

const authSlice = createSlice({
  name: 'isAauth',
  initialState: {
    isAuth: false
  },
  reducers: {
    setIsAuth: (state) => {
      state.isAuth = !state.isAuth;
    }
  }
});

export const { setIsAuth } = authSlice.actions;
export default authSlice;
