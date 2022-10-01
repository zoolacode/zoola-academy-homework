import React from "react";
import WbSunnyIcon from "@mui/icons-material/WbSunny";
import NightsStayIcon from "@mui/icons-material/NightsStay";
import * as session from "./session";
import Grid from "@mui/material/Unstable_Grid2";
import LoginIcon from "@mui/icons-material/Login";
import { addBackendErrorHandler, getChats, getUsers } from "./httpUtils";
import "./App.css";
import { LoginForm } from "./Login";
import { NewChatForm } from "./NewChatForm";
import { Chat } from "./Chat";
import { ChatList } from "./ChatList";
import {
  AppBar,
  Button,
  Container,
  createTheme,
  Dialog,
  DialogActions,
  DialogContent,
  Paper,
  Stack,
  Switch,
  ThemeProvider,
  Toolbar,
  Typography,
} from "@mui/material";
import BadgeAvatar from "./BadgeAvatar";
import { NewUserForm } from "./NewUserForm";

function App() {
  const [currentChatId, setCurrentChatId] = React.useState(null);
  const [chats, setChats] = React.useState([]);
  const [users, setUsers] = React.useState([]);
  const [currentSession, setCurrentSession] = React.useState(null);

  function onLogin(newSession) {
    setCurrentSession(newSession);
    session.set(newSession);
  }

  React.useEffect(() => {
    const unsubscribe = addBackendErrorHandler((res) => {
      if (res.status === 401) {
        setCurrentSession(null);
      }
    });

    return () => {
      unsubscribe();
    };
  }, []);

  React.useEffect(() => {
    if (currentSession === null) {
      return;
    }
    reloadUsers();
  }, [currentSession]);

  React.useEffect(() => {
    setCurrentSession(session.get());
  }, []);

  const currentChat = chats.find(({ id }) => id === currentChatId);

  React.useEffect(() => {
    if (currentSession === null) {
      return;
    }

    function reload() {
      getChats(currentSession.user.id).then(setChats);
    }
    reload();
    const intervalId = setInterval(reload, 2000);

    return () => {
      clearInterval(intervalId);
    };
  }, [currentSession]);

  React.useEffect(() => {
    if (currentChatId === null && chats.length > 0) {
      setCurrentChatId(chats[0].id);
    }
  }, [chats, currentChatId]);

  const [isProfileMenuOpen, setIsProfileMenuOpen] = React.useState(false);
  const [isCreateChatOpen, setIsCreateChatOpen] = React.useState(false);
  const [isCreateUserDialogOpen, setIsCreateUserDialogOpen] =
    React.useState(false);

  const defaultMode = true;
  const [mode, setMode] = React.useState(defaultMode);

  const theme = createTheme({
    palette: {
      mode: mode ? "light" : "dark",
    },
  });

  function reloadUsers() {
    getUsers().then(setUsers);
  }

  return (
    <ThemeProvider theme={theme}>
      <Paper sx={{ minHeight: "100vh" }}>
        <Container fixed>
          <AppBar
            color={currentSession?.isAdmin ? "transparent" : "primary"}
            sx={{ mb: 4 }}
            position="static"
          >
            <Toolbar sx={{ justifyContent: "space-between" }}>
              {currentSession?.user.username ? (
                <>
                  <BadgeAvatar
                    onClick={() => {
                      setIsProfileMenuOpen(true);
                    }}
                  >
                    {currentSession?.user.username[0]}
                  </BadgeAvatar>
                  <Typography pl={2} variant="h6">
                    Welcome, {currentSession?.user?.username}!
                  </Typography>
                </>
              ) : (
                <LoginIcon />
              )}
              <Switch
                checkedIcon={<WbSunnyIcon fontSize="small" />}
                icon={<NightsStayIcon fontSize="small" />}
                defaultChecked={defaultMode}
                onChange={() => setMode((v) => !v)}
                color={currentSession?.isAdmin ? "warning" : "default"}
              />
            </Toolbar>
          </AppBar>
          {!currentSession?.user && (
            <Grid spacing={2}>
              <Grid xs={12}>
                <LoginForm onLogin={onLogin} />
              </Grid>
            </Grid>
          )}
          {currentSession?.user && (
            <Grid container spacing={2}>
              <Grid xs={4}>
                <Stack spacing={1} direction="column">
                  {currentSession?.isAdmin && (
                    <Button
                      variant="contained"
                      onClick={() => setIsCreateUserDialogOpen(true)}
                    >
                      Create user
                    </Button>
                  )}
                  <Button
                    variant="outlined"
                    onClick={() => setIsCreateChatOpen(true)}
                  >
                    Create new chat
                  </Button>
                </Stack>
                <div className="chats">
                  <div className="new-chat">
                    <NewChatForm
                      users={users}
                      open={isCreateChatOpen}
                      onClose={() => setIsCreateChatOpen(false)}
                      currentUser={currentSession?.user}
                    />
                  </div>
                  <ChatList
                    chats={chats}
                    currentChatId={currentChatId}
                    onChatChange={setCurrentChatId}
                  />
                </div>
              </Grid>
              {currentChat && (
                <Grid xs={8}>
                  <Chat
                    users={users}
                    currentUser={currentSession?.user}
                    chat={currentChat}
                  />
                </Grid>
              )}
            </Grid>
          )}
          <Dialog
            onClose={() => setIsProfileMenuOpen(false)}
            open={isProfileMenuOpen}
          >
            <DialogContent>
              <DialogActions>
                <Button
                  color="error"
                  variant="contained"
                  onClick={() => {
                    setCurrentSession(null);
                    setIsProfileMenuOpen(false);
                  }}
                >
                  Log out
                </Button>
              </DialogActions>
            </DialogContent>
          </Dialog>
          {currentSession?.isAdmin && (
            <NewUserForm
              users={users}
              onUsersUpdated={reloadUsers}
              currentUser={currentSession?.user}
              open={isCreateUserDialogOpen}
              onClose={() => setIsCreateUserDialogOpen(false)}
            />
          )}
        </Container>
      </Paper>
    </ThemeProvider>
  );
}

export default App;
