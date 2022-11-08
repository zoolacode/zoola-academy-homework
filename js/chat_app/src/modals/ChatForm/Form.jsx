import React, { useState } from 'react';
import Button from '@mui/material/Button';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import DialogContent from '@mui/material/DialogContent';
import TextField from '@mui/material/TextField';
import Alert from '@mui/material/Alert';
import { useDispatch, useSelector } from 'react-redux';
import CreateChatSelect from './Select';
import { createChatThunk } from '../../redux/chat/slice';
import chatSelectors from '../../redux/chat/selector';
import userSelectors from '../../redux/user/selector';
import getAllUserChats from '../../redux/user/operation';

export default function CreateChatForm({ onClose, open }) {
  const [chatName, setChatName] = useState('');
  const [resetMembersTrigger, setResetMembersTrigger] = useState(true);
  const authToken = useSelector(userSelectors.getAuthToken);
  const userId = useSelector(userSelectors.getUserId);
  const isError = useSelector(chatSelectors.getError);

  const dispatch = useDispatch();

  const handleClose = () => {
    setChatName('');
    onClose();
  };

  const handleChatName = (e) => {
    setChatName(e.target.value);
  };

  const handleSendButton = () => {
    dispatch(createChatThunk(chatName));
    // dispatch(getAllUserChats({authToken, userId}));
    setChatName('');
    setResetMembersTrigger((prev) => !prev);
  };

  return (
    <Dialog onClose={handleClose} open={open}>
      <DialogTitle variant="h6">Create chat</DialogTitle>
      <DialogContent sx={{
        width: 450
      }}
      >
        {isError
          ? <Alert severity="error">Something went wrong - try again!</Alert>
          : null}
        <TextField
          value={chatName}
          onChange={(e) => handleChatName(e)}
          type="text"
          fullWidth
          margin="normal"
          label="Chat name"
          variant="outlined"
        />
        <CreateChatSelect resetMembersTrigger={resetMembersTrigger} />
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
