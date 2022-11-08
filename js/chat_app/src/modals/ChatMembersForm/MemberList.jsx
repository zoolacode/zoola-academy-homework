import React from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import DialogContent from '@mui/material/DialogContent';
import MemberAvatar from './MemberAvatar';
import Select from './SelectForm';

function MemberList({ onClose, open, membersData, allUsers }) {
  const users = allUsers.filter((user) => !membersData?.includes(user));

  return (
    <Dialog onClose={onClose} open={open}>
      <DialogTitle>Group members</DialogTitle>
      <DialogContent
        sx={{
          width: 450
        }}
      >
        <Select users={users} />
        <List>
          {membersData?.map((user) => (
            <ListItem
              sx={{
                pr: 2,
                pl: 2,
                bgcolor: 'background.paper'
              }}
              key={user.id}
            >
              <ListItemAvatar>
                <MemberAvatar username={user.username} />
              </ListItemAvatar>
              <ListItemText primary={user.username} />
            </ListItem>
          ))}
        </List>
      </DialogContent>
    </Dialog>
  );
}

export default MemberList;
