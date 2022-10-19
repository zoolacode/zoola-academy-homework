import React, { useEffect, useState } from 'react';
import Button from '@mui/material/Button';
import Form from './Form';

export default function CreateUserModal() {
  const [open, setOpen] = useState(false);

  const [adminToken, setAdminToken] = useState('');
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
        setAdminToken(res.authToken);
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
          color: 'white',
          backgroundColor: 'rgb(25, 118, 210)'
        }}
        variant="contained"
        onClick={handleClickOpen}
      >
        Create User
      </Button>
      <Form open={open} onClose={handleClose} adminToken={adminToken} adminId={adminId} />
    </div>
  );
}
