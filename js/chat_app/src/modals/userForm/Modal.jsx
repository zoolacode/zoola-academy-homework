import React, { useState } from 'react';
import Button from '@mui/material/Button';
import { useDispatch } from 'react-redux';
import CreateUserForm from './Form';
import { getAllUsersThunk } from '../../redux/slices/usersSlice';

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
          color: 'white',
          backgroundColor: 'rgb(25, 118, 210)',
          width: '100%'
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
