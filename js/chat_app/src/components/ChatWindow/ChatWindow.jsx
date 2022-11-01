import Box from '@mui/material/Box';
import Input from '@mui/material/Input';
import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { sendMessageByChatIdThunk } from '../../redux/slices/chatSlice';
import ListOfChats from './ListOfChats';

function ChatWindow() {
  const [message, setMessage] = useState('');
  const dispatch = useDispatch();

  const handleMessage = (e) => {
    const textMessage = e.target.value;

    setMessage(textMessage);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const params = {
      message
    };

    dispatch(sendMessageByChatIdThunk(params));
    setMessage('');
  };

  return (
    <Box component="form" onSubmit={(e) => handleSubmit(e)} noValidate autoComplete="off">
      <Input fullWidth onChange={(e) => handleMessage(e)} value={message} placeholder="Enter your message" />
      <ListOfChats />
    </Box>
  );
}

export default ChatWindow;
