import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

export default function CreateChatSelect({ users }) {
  const [username, setUsername] = useState([]);

  const handleChange = (event) => {
    const { target: { value } } = event;
    setUsername(
      // On autofill we get a stringified value.
      typeof value === 'string' ? value.split(',') : value
    );
  };

  return (
    <div>
      <FormControl
        fullWidth
        sx={{
          width: '350px'
        }}
      >
        <Select
          multiple
          displayEmpty
          value={username}
          onChange={handleChange}
          input={<TextField label="Members" variant="outlined" margin="normal" select />}
          renderValue={(selected) => {
            if (selected.length === 0) {
              return;
            }

            return selected.join(', ');
          }}
        >
          {users.map((user) => {
            if (user.username !== 'admin') {
              return (
                <MenuItem key={user.id} value={user.username}>
                  {user.username}
                </MenuItem>
              );
            } return null;
          })}
        </Select>
      </FormControl>
    </div>
  );
}
