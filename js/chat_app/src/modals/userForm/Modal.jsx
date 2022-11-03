import React, { useState } from 'react';
import Button from '@mui/material/Button';
import { useDispatch } from 'react-redux';
import CreateUserForm from './Form';
import { getAllUsersThunk } from '../../redux/users/slice';

export default function CreateUserModal() {
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
        variant="contained"
        onClick={handleClickOpen}
      >
        Create User
      </Button>
      <CreateUserForm open={open} onClose={handleClose} />
    </div>
  );
}
