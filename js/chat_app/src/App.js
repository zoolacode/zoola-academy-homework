/* eslint-disable jsx-quotes */

import React  from 'react';
import { ChatEngine } from 'react-chat-engine';
import { useDispatch, useSelector } from 'react-redux';
import { Button, Box, Typography } from '@mui/material';
import { setIsAuth } from './redux/slicies/authSlice';
import ChatFeed from './components/Message/ChatFeed.jsx'

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
      <ChatEngine
       height="100vh"
       userName={localStorage.getItem('username')}
       userSecret={localStorage.getItem('password')}
      renderChatFeed={(chatAppProps) => <ChatFeed {...chatAppProps} />}
      />
    </Box>
  );
}

export default App;
