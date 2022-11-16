
/* eslint-disable jsx-quotes */

import React  from 'react';
import { ChatEngine } from 'react-chat-engine';
import { useDispatch, useSelector } from 'react-redux';
import { Button, Box, Typography } from '@mui/material';
import { setIsAuth } from './redux/slicies/authSlice';
import ChatFeed from './components/Message/ChatFeed.jsx'


import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { Login } from './components/Login';
import Chat from './components/Chat';

<div>
<Router>
  <Routes>
    <Route path="/" element={<Login />} />
    <Route path="/chat" element={<Chat />} />
  </Routes>
</Router>
</div>

function App() {
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
