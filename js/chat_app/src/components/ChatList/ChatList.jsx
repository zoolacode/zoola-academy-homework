import { MenuItem, MenuList, Paper, Typography } from '@mui/material';
import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import getChatsUsers from '../../redux/chat/operation';
import userSelectors from '../../redux/user/selector';

function ChatList() {
  const [currentChatId, setCurrentChatId] = useState(null);
  const chats = useSelector(userSelectors.getChats);
  const authToken = useSelector(userSelectors.getAuthToken);
  const dispatch = useDispatch();

  // useEffect(() => {
  //   dispatch(getChatsUsers.getAllChats({
  //     currentChatId, authToken
  //   }));
  // }, [dispatch]);

  if (!chats.length) {
    return <Typography variant="body2">No chats</Typography>;
  }

  return (
    <Paper>
      <MenuList>
        {chats?.map((chat) => (
          <MenuItem
            selected={chat.id === currentChatId}
            onClick={() => {
              // dispatch(getChatsUsers.getUserChat({
              //   currentChatId, authToken
              // }));
              setCurrentChatId(chat.id);
            }}
            key={chat.id}
          >
            {chat.title}
          </MenuItem>
        ))}
      </MenuList>
    </Paper>
  );
}

export default ChatList;
