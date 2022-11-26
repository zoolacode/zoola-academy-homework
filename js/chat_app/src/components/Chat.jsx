import React from 'react';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { useSelector } from 'react-redux';
import { Header } from './Header';
import { UserModal } from '../modals/userForm';
import { ChatModal } from '../modals/ChatForm';
import ChatWindow from './ChatWindow/ChatWindow';
import authSelectors from '../redux/auth/selector';
import ChatList from './ChatList/ChatList';

function Chat() {
  const isAdmin = useSelector(authSelectors.getAdmin);

  return (
    <Box
      sx={{
        width: '100vw',
        height: '100vh'
      }}
    >
      <Container fixed>
        <Header />
        <Box
          display="flex"
          sx={{
            height: '85vh'
          }}
        >
          <Box
            sx={{
              width: '400px',
              pr: '10px',
              height: '100%'
            }}
          >
            {isAdmin ? <UserModal /> : null}
            <ChatModal />
            <ChatList />
          </Box>
          <Box
            sx={{
              width: '100%',
              p: '0 10px',
              height: '100%'
            }}
          >
            <ChatWindow />
          </Box>
        </Box>
      </Container>
    </Box>
  );
}

export default Chat;
