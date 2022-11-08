import React from 'react';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { useSelector } from 'react-redux';
import { Header } from './Header';
import { UserModal } from '../modals/userForm';
import { ChatModal } from '../modals/ChatForm';
import { MembersListModal } from '../modals/ChatMembersForm';
import authSelectors from '../redux/auth/selector';

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
              borderRight: '1px solid',
              pr: '10px',
              height: '100%'
            }}
          >
            {isAdmin ? <UserModal /> : null}
            <ChatModal />
          </Box>
          <Box
            sx={{
              width: '100%',
              borderRight: '1px solid',
              p: '0 10px',
              height: '100%'
            }}
          >
            <Box display="flex" justifyContent="flex-end">
              <MembersListModal />
            </Box>
            ChatWindow
          </Box>
        </Box>
      </Container>
    </Box>
  );
}

export default Chat;
