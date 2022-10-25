import React, { useEffect, useState } from 'react';
import Button from '@mui/material/Button';
import CreateChatForm from './Form';

export default function CreateChatModal() {
  const [open, setOpen] = useState(false);

  const [authToken, setAuthToken] = useState('');

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
        variant="outlined"
        onClick={handleClickOpen}
      >
        Create Chat
      </Button>
      <CreateChatForm open={open} onClose={handleClose} authToken={authToken} />
    </div>
  );
}
