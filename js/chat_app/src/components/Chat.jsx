import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { useDispatch, useSelector } from 'react-redux';
import { Header } from './Header';
import { UserModal } from '../modals/userForm';
import { ChatModal } from '../modals/ChatForm';
import authSelectors from '../redux/auth/selector';
import ChatList from './ChatList/ChatList';

function Chat() {
  const isAdmin = useSelector(authSelectors.getAdmin);
//   const [currentChatId, setCurrentChatId] = useState(null);
//   const dispatch = useDispatch();
// useEffect (()=>{
// dispatch()
// },[])
  return (
    <Box sx={{
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
          <Box sx={{
            width: '400px',
            borderRight: '1px solid',
            pr: '10px',
            height: '100%'
          }}
          >
            {isAdmin
              ? <UserModal />
              : null}
            <ChatModal />
          <ChatList />
          </Box>
          <Box sx={{
            width: '100%',
            borderRight: '1px solid',
            p: '0 10px',
            height: '100%'
          }}
          >
            <div>Chat</div>
          </Box>
        </Box>
      </Container>
    </Box>
  );
}

export default Chat;
