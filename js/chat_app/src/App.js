/* eslint-disable jsx-quotes */
import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Button, Box, Typography } from '@mui/material';
import { setIsAuth } from './redux/slicies/authSlice';

function App() {
  const dispatch = useDispatch();
  const isAuth = useSelector((state) => state.isAuth);

  return (
    <Box
      sx={{
        width: '100vw',
        height: '100vh',
        display: 'flex',
        justifyContent: 'center',
        alignContent: 'center'
      }}
    >
      {!isAuth ? (
        <Button onClick={() => dispatch(setIsAuth())}>Login</Button>
      ) : (
        <Typography variant='h1' color='blue'>
          Chat Page
        </Typography>
      )}
    </Box>
  );
}

export default App;
