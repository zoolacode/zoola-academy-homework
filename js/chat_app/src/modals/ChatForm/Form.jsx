import React, { useState } from 'react';
import Button from '@mui/material/Button';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import DialogContent from '@mui/material/DialogContent';
import TextField from '@mui/material/TextField';
import { useDispatch, useSelector } from 'react-redux';
import CreateChatSelect from './Select';
import { createChatThunk } from '../../redux/slices/chatSlice';

export default function CreateChatForm({ onClose, open }) {
  const [chatName, setChatName] = useState('');
  const [errorChatName, setErrorChatName] = useState(false);
  const [resetMembersTrigger, setResetMembersTrigger] = useState(true);

  const dispatch = useDispatch();

  const users = useSelector((state) => state.users.allUsers);

  const handleClose = () => {
    setChatName('');
    onClose();
  };

  const handleChatName = (e) => {
    setChatName(e.target.value);
  };

  const handleSendButton = () => {
    const paramsForCreateChat = {
      chatName,
      authToken
    };

    dispatch(createChatThunk(paramsForCreateChat));
    setChatName('');
    setErrorChatName(false);
    setResetMembersTrigger((prev) => !prev);
  };

  return (
    <Dialog onClose={handleClose} open={open}>
      <DialogTitle variant="h6">Create chat</DialogTitle>
      <DialogContent>
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
        <CreateChatSelect resetMembersTrigger={resetMembersTrigger} users={users} />
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
