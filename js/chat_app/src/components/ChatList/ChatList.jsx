import { MenuItem, MenuList, Paper, Typography } from '@mui/material';
import { useState } from 'react';
import { useSelector } from 'react-redux';
import userSelectors from '../../redux/user/selector';

function ChatList() {
  const [currentChatId, setCurrentChatId] = useState(null);
  const chats = useSelector(userSelectors.getChats);

  if (!chats.length) {
    return <Typography variant='body2'>No chats</Typography>;
  }

  return (
    <Paper>
      <MenuList>
        {chats?.map((chat) => {
          return (
            <MenuItem selected={chat.id === currentChatId} onClick={() => setCurrentChatId(chat.id)} key={chat.id}>
              {chat.title}
            </MenuItem>
          );
        })}
      </MenuList>
    </Paper>
  );
}

export default ChatList;
