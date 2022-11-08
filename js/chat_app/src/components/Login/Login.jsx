import { useDispatch, useSelector } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import AppBar from '@mui/material/AppBar';
import Container from '@mui/material/Container';
import Toolbar from '@mui/material/Toolbar';
import Button from '@mui/material/Button';
import Stack from '@mui/material/Stack';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import LoginIcon from '@mui/icons-material/Login';
import Box from '@mui/material/Box';
import loginAuth from '../../redux/auth/operation';
import authSelectors from '../../redux/auth/selector';
import Header from '../Header/Header';
import { Form } from './Form';
import userSelectors from '../../redux/user/selector';
import getAllUserChats from '../../redux/user/operation';

function Login() {
  const [password, setPassword] = useState('');
  const [username, setUsername] = useState('');
  const isLogin = useSelector(authSelectors.getLogin);
  const isError = useSelector(authSelectors.getError);
  const navigation = useNavigate();
  const dispatch = useDispatch();
  const authToken = useSelector(userSelectors.getAuthToken);
  const userId = useSelector(userSelectors.getUserId);

  const handleChange = ({ target: { name, value } }) => {
    switch (name) {
      case 'password':
        return setPassword(value);
      case 'username':
        return setUsername(value);
      default:
        return null;
    }
  };

  useEffect(() => {
    if (!isLogin) {
      navigation('/');
    } else {
      navigation('/chat');
      dispatch(
        getAllUserChats({
          authToken,
          userId
        })
      );
    }
  }, [isLogin]);

  const handleSubmit = (e) => {
    e.preventDefault();
    dispatch(
      loginAuth({
        username,
        password
      })
    );
    setUsername('');
    setPassword('');
  };

  return !isLogin ? (
    <Container fixed>
      <AppBar
        color="primary"
        sx={{
          mb: 3
        }}
        position="static"
      >
        <Toolbar
          sx={{
            justifyContent: 'space-between'
          }}
        >
          {/* <LoginIcon /> */}
        </Toolbar>
      </AppBar>

      <Form onSubmit={handleSubmit}>
        <Typography variant="h5">Welcome to chat</Typography>
        <Box
          sx={{
            p: 4,
            width: 1 / 2
          }}
          autoComplete="off"
        >
          <Stack spacing={2}>
            <TextField label="Username" name="username" onChange={handleChange} error={!!isError} autoComplete="off" />
            <TextField
              label="Password"
              name="password"
              type="password"
              onChange={handleChange}
              error={!!isError}
              autoComplete="off"
            />
            <Button endIcon={<LoginIcon password={password} username={username} />} color="primary" type="submit">
              Login
            </Button>
          </Stack>
        </Box>
      </Form>
    </Container>
  ) : (
    <Header />
  );
}

export default Login;
