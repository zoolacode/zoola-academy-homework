import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import { useSelector } from 'react-redux';
import { Header } from './Header';
import { UserModal } from '../modals/userForm';
import { ChatModal } from '../modals/ChatForm';
import authSelectors from '../redux/auth/selector';
import ChatList from './ChatList/ChatList';
import userSelectors from '../redux/user/selector';

function Chat() {
  const [currentChatId, setCurrentChatId] = useState(null);
  const currentUser = useSelector(userSelectors.getUserId);
  const chats = useSelector(userSelectors.getChats);
  const isAdmin = useSelector(authSelectors.getAdmin);

  useEffect(() => {
    if (currentChatId === null && chats.length > 0) {
      setCurrentChatId(chats[0].id);
    }
  }, [chats, currentChatId]);

  const memberChat = chats?.filter((userId) => userId !== currentUser.id).find(({ id }) => id === currentChatId);

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
            <ChatList currentChatId={currentChatId} onChatChange={setCurrentChatId} />
          </Box>
          <Box
            sx={{
              width: '100%',
              borderRight: '1px solid',
              p: '0 10px',
              height: '100%'
            }}
          >
            <ul>
              <li>{memberChat?.title}</li>
            </ul>
          </Box>
        </Box>
      </Container>
    </Box>
  );
}

export default Chat;
