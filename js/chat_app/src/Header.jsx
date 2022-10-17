import React from 'react';
import Container from '@mui/material/Container';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import LoginIcon from '@mui/icons-material/Login';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import FormGroup from '@mui/material/FormGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import Switch from '@mui/material/Switch';
import WbSunnyIcon from '@mui/icons-material/WbSunny';
import NightsStayIcon from '@mui/icons-material/NightsStay';
import { deepOrange } from '@mui/material/colors';
import { styled } from '@mui/material/styles';
import Badge from '@mui/material/Badge';

export function Header({ setMode, mode, userData }) {
  const StyledBadge = styled(Badge)(({ theme }) => ({
    '& .MuiBadge-badge': {
      backgroundColor: '#44b700',
      color: '#44b700',
      boxShadow: `0 0 0 2px ${theme.palette.background.paper}`,
      '&::after': {
        position: 'absolute',
        top: 0,
        left: 0,
        width: '100%',
        height: '100%',
        borderRadius: '50%',
        animation: 'ripple 1.2s infinite ease-in-out',
        border: '1px solid currentColor',
        content: '""',
      },
    },
    '@keyframes ripple': {
      '0%': {
        transform: 'scale(.8)',
        opacity: 1,
      },
      '100%': {
        transform: 'scale(2.4)',
        opacity: 0,
      },
    },
  }));

  return (
    <Container maxWidth='lg' fixed={true}>
      <AppBar position='static'>
        <Toolbar sx={{ display: 'flex', justifyContent: 'space-between' }}>
          {userData.isAdmin ? (
            <>
              <StyledBadge
                overlap='circular'
                anchorOrigin={{ vertical: 'bottom', horizontal: 'right' }}
                variant='dot'
              >
                <Avatar sx={{ bgcolor: deepOrange[500] }}>
                  {userData.user.username[0]}
                </Avatar>
              </StyledBadge>
              <Typography variant='h6'>
                {`Welcome, ${userData.user.username}`}
              </Typography>
            </>
          ) : (
            <LoginIcon />
          )}
          <FormGroup>
            <FormControlLabel
              control={
                <Switch
                  sx={{ ml: 1 }}
                  onClick={() => setMode(mode === 'light' ? 'dark' : 'light')}
                  icon={<WbSunnyIcon edge='end' fontSize='small' />}
                  checkedIcon={<NightsStayIcon edge='start' fontSize='small' />}
                ></Switch>
              }
            />
          </FormGroup>
        </Toolbar>
      </AppBar>
    </Container>
  );
}
