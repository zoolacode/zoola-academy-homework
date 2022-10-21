import React, { useEffect, useState } from 'react';
import Button from '@mui/material/Button';
import CreateUserForm from './Form';

export default function CreateUserModal() {
  const [open, setOpen] = useState(false);

  const [authToken, setAuthToken] = useState('');
  const [adminId, setAdminId] = useState('');

  useEffect(() => {
    // TODO: refactoring when loginization will be implemented
    fetch('/api/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        username: 'admin',
        password: 'admin'
      })
    })
      .then((response) => response.json())
      .then((res) => {
        setAuthToken(res.authToken);
        setAdminId(res.user.id);
      });
  }, []);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <div>
      <Button
        sx={{
          width: '400px'
        }}
        variant="contained"
        onClick={handleClickOpen}
      >
        Create User
      </Button>
      <CreateUserForm open={open} onClose={handleClose} authToken={authToken} adminId={adminId} />
    </div>
  );
}
