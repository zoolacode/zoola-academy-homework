import AppBar from '@mui/material/AppBar';
import Button from '@mui/material/Button';
import { deepOrange } from '@mui/material/colors';
import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import authSelectors from '../../redux/auth/authSelector';
import Container from '@mui/material/Container';
import Toolbar from '@mui/material/Toolbar';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import Dialog from '@mui/material/Dialog';
import DialogContent from '@mui/material/DialogContent';
import DialogActions from '@mui/material/DialogActions';
import Stack from '@mui/material/Stack';
import Badge from '@mui/material/Badge';
import { createTheme, styled } from '@mui/material';
import { ThemeProvider } from '@emotion/react';
import { isLogout } from '../../redux/auth/authSlice';

function LogOut({ username, password }) {
  const defaultMode = true;
  const [mode, setMode] = useState(defaultMode);
  const [isWindowLogoutOpen, setIsWindowLogoutOpen] = useState(false);
  const name = useSelector(authSelectors.getUsername);
  const isLogin = useSelector(authSelectors.getLogin);
  const dispatch = useDispatch();
  const navigation = useNavigate();
  const theme = createTheme({
    palette: {
      mode: mode ? 'light' : 'dark'
    }
  });

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
        content: '""'
      }
    },
    '@keyframes ripple': {
      '0%': {
        transform: 'scale(.8)',
        opacity: 1
      },
      '100%': {
        transform: 'scale(2.4)',
        opacity: 0
      }
    }
  }));

  useEffect(() => {
    navigation('/chat');
  }, []);

  const handleBtnClick = () => {
    setIsWindowLogoutOpen(false);
    localStorage.removeItem('auth');
    navigation('/');
    dispatch(isLogout());
  };
  const isOpenWindowLogout = () => {
    setIsWindowLogoutOpen(true);
  };
  const isCloseWindowLogout = () => {
    setIsWindowLogoutOpen(false);
  };
  return (
    <>
      <ThemeProvider theme={theme}>
        <Container fixed>
          <AppBar color='transparent' sx={{ mb: 4 }} position='static'>
            <Toolbar sx={{ justifyContent: 'space-between' }}>
              <Stack direction='row' spacing={2}>
                <StyledBadge
                  overlap='circular'
                  anchorOrigin={{ vertical: 'bottom', horizontal: 'right' }}
                  variant='dot'
                >
                  <Avatar sx={{ bgcolor: deepOrange[500] }} onClick={isOpenWindowLogout} alt={name.slice(0, 1)} />
                </StyledBadge>
              </Stack>
              <>
                <Typography pl={2} variant='h6'>
                  Welcome, {name}!
                </Typography>
              </>
            </Toolbar>
          </AppBar>

          <Dialog onClose={isCloseWindowLogout} open={isWindowLogoutOpen}>
            <DialogContent>
              <DialogActions>
                <Button color='error' variant='contained' onClick={handleBtnClick}>
                  Log out
                </Button>
              </DialogActions>
            </DialogContent>
          </Dialog>
        </Container>
      </ThemeProvider>
    </>
  );
}

export default LogOut;
