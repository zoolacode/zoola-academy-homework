import React, { useState } from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemAvatar from '@mui/material/ListItemAvatar';
import ListItemText from '@mui/material/ListItemText';
import DialogTitle from '@mui/material/DialogTitle';
import Dialog from '@mui/material/Dialog';
import DialogContent from '@mui/material/DialogContent';
import FormControl from '@mui/material/FormControl';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import MemberAvatar from './MemberAvatar';

function MemberList({ onClose, open, membersData, allUsers }) {
  const usersDontMembers = allUsers.filter(((user) => !membersData?.includes(user)));
  const [selectedMembers, setSelectedMembers] = useState([]);

  const handleChange = (event) => {
    const { target: { value } } = event;

    setSelectedMembers(
      // On autofill we get a stringified value.
      typeof value === 'string' ? value.split(',') : value
    );
  };

  return (
    <Dialog onClose={onClose} open={open}>
      <DialogTitle>Group members</DialogTitle>
      <DialogContent>
        {usersDontMembers.length
          ? (
            <FormControl
              fullWidth
              sx={{
                width: '350px'
              }}
            >
              <TextField
                select
                label="Members"
                variant="outlined"
                SelectProps={{
                  multiple: true,
                  onChange: handleChange,
                  value: selectedMembers
                }}
              >
                {usersDontMembers.map((user) => (
                  <MenuItem key={user.id} value={user.username}>
                    {user.username}
                  </MenuItem>
                ))}
              </TextField>
            </FormControl>
          )
          : null}
        <List
          sx={{
            width: 450
          }}
        >
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
