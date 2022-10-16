import React from 'react'
import { AppBar, Avatar, Toolbar, Typography,Switch } from '@mui/material';
import { deepOrange } from '@mui/material/colors';
import { Container } from '@mui/system';
import { useLocation } from 'react-router-dom';

const Chat = () => {
  const location = useLocation();
  return (
    <Container maxWidth="lg">
      <AppBar 
      position='static'
      color='inherit'> 
        <Toolbar sx={{justifyContent:'space-between'}}>
          <Avatar sx={{bgcolor:deepOrange[500]}}>{`${location.state.name.charAt(0)}`}</Avatar>
          <Typography sx={{flexGrow:1,textAlign:'center'}} variant='h6' color="inherit" >
              {`Welcome,  ${location.state.name}`}
          </Typography>
          <Switch color='default' />
        </Toolbar>
    </AppBar>    
    </Container>
    
  )
}

export default Chat