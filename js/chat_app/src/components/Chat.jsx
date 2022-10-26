import Box from '@mui/material/Box';
import React from 'react';
import Container from '@mui/material/Container';
import { Header } from './Header';
import { UserModal } from '../modals/userForm';

function Chat() {
  return (
    <Box
      sx={{
        width: '100vw',
        height: '100vh'
      }}
    >
      <Container fixed>
        <Header />
        <UserModal />
      </Container>
    </Box>
  );
}

export default Chat;
