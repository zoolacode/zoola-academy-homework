import { Button } from '@mui/material';
import React from 'react';
import { useDispatch } from 'react-redux';
import { getAllUsers } from '../../redux/slices/usersSlice';
import { Form } from './index';

export default function CreateUserModal() {
  const [open, setOpen] = React.useState(false);
  const dispatch = useDispatch();

  const handleClickOpen = async () => {
    await dispatch(getAllUsers());
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
          backgroundColor: 'rgb(25, 118, 210)'
        }}
        variant="contained"
        onClick={handleClickOpen}
      >
        Create User
      </Button>
      <Form open={open} onClose={handleClose} />
    </div>
  );
}
