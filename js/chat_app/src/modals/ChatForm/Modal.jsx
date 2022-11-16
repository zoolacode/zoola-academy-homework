import React, { useState } from 'react';
import Button from '@mui/material/Button';
import { useDispatch } from 'react-redux';
import CreateChatForm from './Form';
import { getAllUsersThunk } from '../../redux/users/slice';

export default function CreateChatModal() {
  const [open, setOpen] = useState(false);

  const dispatch = useDispatch();

  const handleClickOpen = () => {
    dispatch(getAllUsersThunk());
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <Button
        sx={{
          width: '100%',
          mb: 1
        }}
        variant="outlined"
        onClick={handleClickOpen}
      >
        Create Chat
      </Button>
      <CreateChatForm open={open} onClose={handleClose} />
    </div>
  );
}
