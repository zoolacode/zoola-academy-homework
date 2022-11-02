import React, { useState } from 'react';
import FormControl from '@mui/material/FormControl';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import { useDispatch, useSelector } from 'react-redux';
import { addChatMembersThunk } from '../../redux/slices/chatSlice';

function Select({ usersDontMembers }) {
  const [selectedMembers, setSelectedMembers] = useState([]);
  const [membersId, setMembersId] = useState([]);
  const dispatch = useDispatch();
  const chatId = useSelector((state) => state.chat.chatData.id);
  console.log(chatId);

  const handleChange = (event) => {
    const { target: { value } } = event;

    setSelectedMembers(
      // On autofill we get a stringified value.
      typeof value === 'string' ? value.split(',') : value
    );

    setMembersId(usersDontMembers.filter((user) => value.includes(user.username)).map((user) => user.id));
  };

  const handleSubmit = () => {
    dispatch(addChatMembersThunk({
      chatId, members: membersId
    }));
    setSelectedMembers([]);
  };

  return (
    <div>
      {usersDontMembers?.length
        ? (
          <FormControl
            fullWidth
          >
            <TextField
              select
              label="New members"
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
            <Button
              sx={{
                margin: '15px 0'
              }}
              type="button"
              fullWidth
              variant="text"
              onClick={handleSubmit}
            >
              Add
            </Button>
          </FormControl>
        )
        : null}
    </div>
  );
}

export default Select;
