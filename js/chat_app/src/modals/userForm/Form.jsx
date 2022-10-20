import React, { useState, useEffect } from 'react';
import Button from '@mui/material/Button';
import Avatar from '@mui/material/Avatar';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import DialogContent from '@mui/material/DialogContent';
import TextField from '@mui/material/TextField';
import { useDispatch, useSelector } from 'react-redux';
import { getAllUsersThunk, createUserThunk } from '../../redux/slices/usersSlice';

export default function CreateUserForm({ onClose, open, adminToken, adminId }) {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const [errorUsername, setErrorUsername] = useState(false);
  const [errorPassword, setErrorPassword] = useState(false);

  const dispatch = useDispatch();

  const users = useSelector((state) => state.users.allUsers);

  useEffect(() => {
    // TODO: check it after implement loginization
    dispatch(getAllUsersThunk(adminToken));
  }, [adminToken]);

  const handleClose = () => {
    setPassword('');
    setUsername('');
    onClose();
  };

  const handleUsername = (e) => {
    const isUsernameExists = users.some((item) => item.username === e.target.value);

    if (isUsernameExists) {
      setErrorUsername(true);
    } else setErrorUsername(false);

    setUsername(e.target.value);
  };

  const handlePassword = (e) => {
    if (e.target.value.trim()) {
      setErrorPassword(false);
    }

    setPassword(e.target.value);
  };

  const handleSendButton = async () => {
    if (!username.trim()) {
      setErrorUsername(true);
      return;
    }

    if (!password.trim()) {
      setErrorPassword(true);
      return;
    }

    if (!errorUsername && !errorPassword) {
      const paramsForCreateUser = {
        adminToken,
        username,
        password,
        adminId
      };

      await dispatch(createUserThunk(paramsForCreateUser));
      dispatch(getAllUsersThunk(adminToken));

      setUsername('');
      setPassword('');
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
          error={errorUsername}
          value={username}
          onChange={(e) => handleUsername(e)}
          type="text"
          fullWidth
          margin="normal"
          label="Username"
          variant="outlined"
        />
        <TextField
          error={errorPassword}
          value={password}
          onChange={(e) => handlePassword(e)}
          type="password"
          fullWidth
          margin="normal"
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
          {users.map((user) => (
            <ListItem
              sx={{
                pr: 0,
                pl: 0,
                bgcolor: 'background.paper'
              }}
              key={user.id}
            >
              <ListItemAvatar>
                <Avatar variant={user.username === 'admin' ? 'square' : 'circular'}>{user.username[0]}</Avatar>
              </ListItemAvatar>
              <ListItemText primary={user.username} />
            </ListItem>
          ))}
        </List>
      </DialogContent>
    </Dialog>
  );
}
