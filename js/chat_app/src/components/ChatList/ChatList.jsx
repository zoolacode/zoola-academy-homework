import MenuItem from '@mui/material/MenuItem';
import MenuList from '@mui/material/MenuList';
import Paper from '@mui/material/Paper';
import Typography from '@mui/material/Typography';
import { useSelector } from 'react-redux';
import userSelectors from '../../redux/user/selector';

function ChatList({ currentChatId, onChatChange }) {
  const chats = useSelector(userSelectors.getChats);

  if (!chats.length) {
    return <Typography variant="body2">No chats</Typography>;
  }

  return (
    <Paper>
      <MenuList>
        {chats?.map(({ id, title }) => (
          <MenuItem
            selected={id === currentChatId}
            onClick={() => {
              onChatChange(id);
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
