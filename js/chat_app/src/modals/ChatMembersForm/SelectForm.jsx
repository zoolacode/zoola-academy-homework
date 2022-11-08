import React, { useState } from 'react';
import FormControl from '@mui/material/FormControl';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import { useDispatch, useSelector } from 'react-redux';
import { addChatMembersThunk } from '../../redux/chat/slice';
import chatSelectors from '../../redux/chat/selector';

function Select({ users }) {
  const [selectedMembers, setSelectedMembers] = useState([]);
  const [selectedMembersError, setSelectedMembersError] = useState(false);

  const [membersIds, setMembersIds] = useState([]);

  const dispatch = useDispatch();

  const chatId = useSelector(chatSelectors.getChatId);

  const handleChange = (event) => {
    const { target: { value } } = event;

    setSelectedMembersError(false);

    setSelectedMembers(
      // On autofill we get a stringified value.
      typeof value === 'string' ? value.split(',') : value
    );

    setMembersIds(users.filter((user) => value.includes(user.username)).map((user) => user.id));
  };

  const handleSubmit = () => {
    if (!selectedMembers.length) {
      setSelectedMembersError(true);
      return;
    }

    dispatch(
      addChatMembersThunk({
        chatId,
        members: membersIds
      })
    );

    setSelectedMembers([]);
  };

  return (
    <div>
      {users?.length ? (
        <FormControl fullWidth>
          <TextField
            sx={{
              mb: 1,
              mt: 1
            }}
            error={selectedMembersError}
            select
            label="New members"
            variant="outlined"
            SelectProps={{
              multiple: true,
              onChange: handleChange,
              value: selectedMembers
            }}
          >
            {users.map((user) => (
              <MenuItem key={user.id} value={user.username}>
                {user.username}
              </MenuItem>
            ))}
          </TextField>
          <Button
            sx={{
              mb: 1
            }}
            type="button"
            fullWidth
            variant="text"
            onClick={handleSubmit}
          >
            Add
          </Button>
        </FormControl>
      ) : null}
    </div>
  );
}

export default Select;
