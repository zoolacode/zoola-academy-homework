import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { getChatByIdThunk } from '../../redux/slices/chatSlice';
import Separator from './Separator';

function ListOfChats() {
  const { chatData } = useSelector((state) => state.chat);
  const dispatch = useDispatch();
  const arrayOfMessages = chatData?.messages;

  useEffect(() => {
    dispatch(getChatByIdThunk());
  }, []);

  if (arrayOfMessages?.length) {
    return (
      <List
        sx={{
          display: 'flex',
          jastifyContent: 'center',
          flexDirection: 'column-reverse',
          alignItems: 'center'
        }}
      >
        <form
          onSubmit={(e) => {
            sendMessageByChatId(message);
            e.preventDefault();
            setMessage('');
          }}
        />
        {arrayOfMessages.map((message, index) => (
          // eslint-disable-next-line react/no-array-index-key
          <ListItem key={index}>
            <Separator message={message.message} date={message.date} authorId={message.authorId} />
          </ListItem>
        ))}
      </List>
    );
  }
  return null;
}

export default ListOfChats;
