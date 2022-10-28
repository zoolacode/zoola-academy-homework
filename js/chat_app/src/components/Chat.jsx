import React from 'react';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { useSelector } from 'react-redux';
import { Header } from './Header';
import { UserModal } from '../modals/userForm';

function Chat() {
  const isAdmin = useSelector((state) => state.auth.auth.isAdmin);

  return (
    <Box
      sx={{
        width: '100vw',
        height: '100vh'
      }}
    >
      <Container fixed>
        <Header />
        {isAdmin
          ? <UserModal />
          : null}
      </Container>
    </Box>
  );
}

export default Chat;
