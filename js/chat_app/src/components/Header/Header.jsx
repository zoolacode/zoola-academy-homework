import AppBar from '@mui/material/AppBar';
import Button from '@mui/material/Button';
import { deepOrange } from '@mui/material/colors';
import { useContext, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Avatar from '@mui/material/Avatar';
import Typography from '@mui/material/Typography';
import Dialog from '@mui/material/Dialog';
import DialogContent from '@mui/material/DialogContent';
import DialogActions from '@mui/material/DialogActions';
import Stack from '@mui/material/Stack';
import { ThemeProvider } from '@emotion/react';
import { StyledBadge } from '../StyleBadge';
import authSelectors from '../../redux/auth/selector';
import { isLogout } from '../../redux/auth/slice';
import { ThemeContext } from '../ThemeContext/ThemeContext';

function Header() {
  const [isWindowLogoutOpen, setIsWindowLogoutOpen] = useState(false);
  const name = useSelector(authSelectors.getUsername);
  const dispatch = useDispatch();
  const navigation = useNavigate();

  const isAdmin = useSelector((state) => state.auth.auth.isAdmin);

  const theme = useContext(ThemeContext);

  const handleLogoutClick = () => {
    setIsWindowLogoutOpen(false);
    localStorage.removeItem('auth');
    navigation('/');
    dispatch(isLogout());
  };
  const handleOpenWindowLogout = () => {
    setIsWindowLogoutOpen(true);
  };
  const handleCloseWindowLogout = () => {
    setIsWindowLogoutOpen(false);
  };
  return (
    <ThemeProvider theme={theme}>
      <Box
        sx={{
          backgroundColor: `${!isAdmin ? 'rgb(25, 118, 210)' : 'white'}`,
          color: `${!isAdmin ? 'white' : 'black'}`
        }}
      >
        <AppBar
          color="transparent"
          sx={{
            mb: 4
          }}
          position="static"
        >
          <Toolbar
            sx={{
              justifyContent: 'space-between'
            }}
          >
            <Stack direction="row" spacing={2}>
              <StyledBadge
                overlap="circular"
                anchorOrigin={{
                  vertical: 'bottom',
                  horizontal: 'right'
                }}
                variant="dot"
              >
                <Avatar
                  sx={{
                    bgcolor: deepOrange[500]
                  }}
                  onClick={handleOpenWindowLogout}
                >
                  {name.slice(0, 1)}
                </Avatar>
              </StyledBadge>
            </Stack>
            <Typography variant="h6">{`Welcome, ${name}!`}</Typography>
          </Toolbar>
        </AppBar>

        <Dialog onClose={handleCloseWindowLogout} open={isWindowLogoutOpen}>
          <DialogContent>
            <DialogActions>
              <Button color="error" variant="contained" onClick={handleLogoutClick}>
                Log out
              </Button>
            </DialogActions>
          </DialogContent>
        </Dialog>
      </Box>
    </ThemeProvider>
  );
}

export default Header;
