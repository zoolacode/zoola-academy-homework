import React, { useState, useEffect } from 'react';
import Button from '@mui/material/Button';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import DialogContent from '@mui/material/DialogContent';
import TextField from '@mui/material/TextField';
import { useDispatch, useSelector } from 'react-redux';
import ChatSelect from './Select';
import { getAllUsersThunk } from '../../redux/slices/usersSlice';

export default function CreateChatForm({ onClose, open, adminToken }) {
  const [chatName, setChatName] = useState('');
  const [errorChatName, setErrorChatName] = useState(false);

  const dispatch = useDispatch();

  const users = useSelector((state) => state.users.allUsers);

  useEffect(() => {
    // TODO: check it after implement loginization
    dispatch(getAllUsersThunk(adminToken));
  }, [adminToken]);

  const handleClose = () => {
    setChatName('');
    onClose();
  };

  const handleChatName = (e) => {
    setChatName(e.target.value);
  };

  const handleSendButton = () => {
    setChatName('');
    setErrorChatName(false);
  };

  return (
    <Dialog onClose={handleClose} open={open}>
      <DialogTitle variant="h6">Create chat</DialogTitle>
      <DialogContent
        sx={{
          maxWidth: '450px'
        }}
      >
        <TextField
          error={errorChatName}
          value={chatName}
          onChange={(e) => handleChatName(e)}
          type="text"
          fullWidth
          margin="normal"
          label="Chat name"
          variant="outlined"
        />
        <ChatSelect users={users} />
        <Button
          sx={{
            margin: '15px 0'
          }}
          type="button"
          fullWidth
          variant="outlined"
          onClick={handleSendButton}
        >
          Create
        </Button>
      </DialogContent>
    </Dialog>
  );
}
