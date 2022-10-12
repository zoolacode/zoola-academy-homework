import { createSlice } from '@reduxjs/toolkit';

const testSlice = createSlice({
  name: 'test',
  initialState: {
    test: false
  },
  reducers: {
    setStatus: (state) => {
      state.test = !state.test;
    }
  }
});

export const { setStatus } = testSlice.actions;
export default testSlice;
