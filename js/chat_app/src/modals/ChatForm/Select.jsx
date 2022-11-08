import React, { useEffect, useState } from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import { useDispatch, useSelector } from 'react-redux';
import { setSelectedMembers } from '../../redux/chat/slice';
import authSelectors from '../../redux/auth/selector';
import usersSelectors from '../../redux/users/selector';

export default function CreateChatSelect({ resetMembersTrigger }) {
  const [membersNames, setMembersNames] = useState([]);

  const authUsername = useSelector(authSelectors.getUsername);
  const users = useSelector(usersSelectors.getAllUsers);

  const dispatch = useDispatch();

  useEffect(() => {
    setMembersNames([]);
  }, [resetMembersTrigger]);

  const handleChange = (event) => {
    const { target: { value } } = event;

    setMembersNames(
      // On autofill we get a stringified value.
      typeof value === 'string' ? value.split(',') : value
    );

    const membersIds = users.filter((user) => value.includes(user.username)).map((user) => user.id);
    dispatch(setSelectedMembers(membersIds));
  };

  return (
    <div>
      <FormControl fullWidth>
        <TextField
          select
          label="Members"
          variant="outlined"
          SelectProps={{
            multiple: true,
            onChange: handleChange,
            value: membersNames
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
