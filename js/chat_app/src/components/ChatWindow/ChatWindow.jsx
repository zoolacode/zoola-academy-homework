import Box from '@mui/material/Box';
import Input from '@mui/material/Input';
import React, { useState, useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { getChatByIdThunk, sendMessageByChatIdThunk } from '../../redux/slices/chatSlice';
import ListOfChats from './ListOfChats';
import UploadButton from '../ChatImageUpload/UploadButton';

function ChatWindow() {
  const [message, setMessage] = useState('');
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getChatByIdThunk());
    setInterval(() => {
      dispatch(getChatByIdThunk());
    }, 2000);
  }, []);

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
      <UploadButton
        fontSize="small"
        sx={{
          cursor: 'pointer'
        }}
      />
      <ListOfChats />
    </Box>
  );
}

export default ChatWindow;
