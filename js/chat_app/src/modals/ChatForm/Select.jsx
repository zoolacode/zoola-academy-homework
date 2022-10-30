import React, { useEffect, useState } from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import { useDispatch, useSelector } from 'react-redux';
import { setMembers } from '../../redux/slices/chatSlice';

export default function CreateChatSelect({ users, resetMembersTrigger }) {
  const [membersName, setMembersName] = useState([]);
  const authUsername = useSelector((state) => state.auth.auth.user.username);
  const dispatch = useDispatch();

  useEffect(() => {
    setMembersName([]);
  }, [resetMembersTrigger]);

  const handleChange = (event) => {
    const { target: { value } } = event;

    setMembersName(
      // On autofill we get a stringified value.
      typeof value === 'string' ? value.split(',') : value
    );

    const membersIds = users.filter((user) => value.includes(user.username)).map((user) => user.id);
    dispatch(setMembers(membersIds));
  };

  return (
    <div>
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
            value: membersName
          }}
        >
          {users.map((user) => {
            if (user.username !== authUsername) {
              return (
                <MenuItem key={user.id} value={user.username}>
                  {user.username}
                </MenuItem>
              );
            }
            return null;
          })}
        </TextField>
      </FormControl>
    </div>
  );
}
