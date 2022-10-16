import React from 'react'
import './Login.css';
import { AppBar, Button, Container, TextField, Typography,Toolbar,Switch } from '@mui/material';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';


const Login = () => {
    const navigate = useNavigate();
    const [userName,setUserName] = useState('');
    const [password,setPassword] = useState('');
    const [error,setError] = useState(false);

    async function handleClick() {
      let response = await fetch("/api/login", {
        method: 'POST',
        headers: {
          "content-type": "application/json",
        },
        body: JSON.stringify({
          username: userName,
          password: password
        })
      })
      if(response.status === 401){
        setError(true)
      }
      let result = await response.json();
      sessionStorage.setItem("user-info",JSON.stringify(result));
      navigate('chat',{state: {name: userName}});
    }

  
  return (
    <Container maxWidth="lg">
      <AppBar 
      position='static'
      color='primary'> 
        <Toolbar sx={{flexDirection:"row-reverse"}}>
          <Switch color='default' />
        </Toolbar>
    </AppBar>    
    <form className='form' onSubmit={(e) => e.preventDefault()}>
    <Typography variant='h5' mb={1}>Welcome to chat</Typography>
    <TextField 
      margin='normal' 
      label='Username' 
      error={error}
      variant='outlined'
      onChange={(e) => setUserName(e.target.value)}/>
    <TextField 
      margin='normal' 
      label='Password' 
      error={error}
      type="password"
      variant='outlined' 
      onChange={(e) => setPassword(e.target.value)}/>
    <Button 
      sx={{m:2}} 
      size='medium'
      variant="contained" 
      color="primary"
      onClick={handleClick}
      >
      Login
    </Button>
  </form>
    </Container>
    
  )
}

export default Login