import {
  AppBar,
  Container,
  Toolbar,
  Button,
  Stack,
  TextField,
  Typography,
} from '@mui/material';
import LoginIcon from '@mui/icons-material/Login';
import { Box } from '@mui/system';

function Login() {
  return (
    <Container fixed>
      <AppBar color={'primary'} sx={{ mb: 3 }} position="static">
        <Toolbar sx={{ justifyContent: 'space-between' }}>
          <LoginIcon />
        </Toolbar>
      </AppBar>
      <form className="login-form">
        <Typography variant="h5">Welcome to chat</Typography>
        <Box padding={4}>
          <Stack spacing={2}>
            <TextField label="Username" />
            <TextField label="Password" type="password" />
            <Button endIcon={<LoginIcon />} color="primary" type="submit">
              Login
            </Button>
          </Stack>
        </Box>
      </form>
    </Container>
  );
}

export default Login;
