import React from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Button, Box } from '@mui/material';
import { setIsAuth } from './redux/slices/authSlice';
import { ChatModal } from './modals/chatForm';

function App() {
  const dispatch = useDispatch();
  const isAuth = useSelector((state) => state.auth.isAuth);

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
      {!isAuth ? <Button onClick={() => dispatch(setIsAuth())}>Login</Button> : <ChatModal />}
    </Box>
  );
}

export default App;
