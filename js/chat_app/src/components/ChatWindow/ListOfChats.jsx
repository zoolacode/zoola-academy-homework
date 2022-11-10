import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import React from 'react';
import { useSelector } from 'react-redux';
import Separator from './Separator';

function ListOfChats() {
  const { chatData } = useSelector((state) => state.chat);
  const arrayOfMessages = chatData?.messages;

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
        {arrayOfMessages.map((message, index) => (
          // eslint-disable-next-line react/no-array-index-key
          <ListItem key={index}>
            <Separator message={message} date={message.date} authorId={message.authorId} />
          </ListItem>
        ))}
      </List>
    );
  }
  return null;
}

export default ListOfChats;
