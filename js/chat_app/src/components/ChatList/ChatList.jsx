import MenuItem from '@mui/material/MenuItem';
import MenuList from '@mui/material/MenuList';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';
import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import getUserChat from '../../redux/chat/operetion';
import userSelectors from '../../redux/user/selector';

function ChatList() {
  const [currentChatId, setCurrentChatId] = useState(null);
  const currentUser = useSelector(userSelectors.getUserId);
  const chats = useSelector(userSelectors.getChats);
  const dispatch = useDispatch();
  const authToken = useSelector(userSelectors.getAuthToken);
  
useEffect(() => {
  if (currentChatId === null && chats.length > 0) {
    setCurrentChatId(chats.id);
  }
  dispatch(getUserChat({authToken, currentChatId }))
}, [authToken, chats, currentChatId, dispatch]);

const memberChat = chats?.filter((userId) => userId !== currentUser.id).find(({ id }) => id === currentChatId);
  if (!chats.length) {
    return <Typography variant="body2">No chats</Typography>;
  }

  return (
    <Paper>
      <MenuList>
        {chats?.map(({ id, title }) => (
          <MenuItem
            selected={memberChat}
            onClick={() => {
              setCurrentChatId(id);
             
            }}
            key={id}
          >
            {title}
          </MenuItem>
        ))}
      </MenuList>
    </Paper>
  );
}

export default ChatList;
