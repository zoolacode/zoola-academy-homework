import * as React from 'react';
import Button from '@mui/material/Button';
import Avatar from '@mui/material/Avatar';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import PersonIcon from '@mui/icons-material/Person';
import { grey } from '@mui/material/colors';
import { DialogContent, TextField } from '@mui/material';
import { useState } from 'react';
import { useSelector } from 'react-redux';

export default function CreateUserForm(props) {
  const { onClose, open } = props;

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const users = useSelector((state) => state.users.users);
  const [localUsers, setLocalUsers] = useState(users);

  const handleClose = () => {
    setPassword('');
    setUsername('');
    onClose();
  };

  const handleUsername = (e) => {
    e.preventDefault();

    setUsername(() => e.target.value);
  };

  const handlePassword = (e) => {
    e.preventDefault();

    setPassword(() => e.target.value);
  };

  const handleSendButton = () => {
    let isValidated = false;

    if (username.trim() && password.trim() && !localUsers.includes(username)) isValidated = true;

    if (localUsers.includes(username)) alert('This name already exists');

    if (isValidated) {
      setLocalUsers((prev) => [...prev, username]);
    }
  };

  return (
    <Dialog onClose={handleClose} open={open}>
      <DialogTitle variant="h6">Create user</DialogTitle>
      <DialogContent
        sx={{
          maxWidth: '450px'
        }}
      >
        <TextField
          value={username}
          onChange={(e) => handleUsername(e)}
          type="text"
          fullWidth
          margin="normal"
          id="outlined-basic1"
          label="Username"
          variant="outlined"
        />
        <TextField
          value={password}
          onChange={(e) => handlePassword(e)}
          type="password"
          fullWidth
          margin="normal"
          id="outlined-basic2"
          label="Password"
          variant="outlined"
        />
        <Button
          sx={{
            margin: '15px 0'
          }}
          type="button"
          fullWidth
          variant="outlined"
          onClick={handleSendButton}
        >
          Send
        </Button>
        <List>
          {localUsers.map((email) => (
            <ListItem
              sx={{
                p: 1,
                bgcolor: 'background.paper'
              }}
              key={email}
            >
              <ListItemAvatar>
                <Avatar
                  sx={{
                    bgcolor: grey[400],
                    color: 'whitesmoke'
                  }}
                >
                  <PersonIcon />
                </Avatar>
              </ListItemAvatar>
              <ListItemText primary={email} />
            </ListItem>
          ))}
        </List>
      </DialogContent>
    </Dialog>
  );
}
