import React from "react";
import WbSunnyIcon from "@mui/icons-material/WbSunny";
import NightsStayIcon from "@mui/icons-material/NightsStay";
import * as session from "./session";
import Grid from "@mui/material/Unstable_Grid2";
import LoginIcon from "@mui/icons-material/Login";
import { getChats, getUsers } from "./httpUtils";
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

function App() {
  const [currentUser, setCurrentUser] = React.useState(null);
  const [currentChatId, setCurrentChatId] = React.useState(null);
  const [chats, setChats] = React.useState([]);
  const [users, setUsers] = React.useState([]);

  function onLogin(newSession) {
    setCurrentUser(newSession.user);
    session.set(newSession);
  }

  React.useEffect(() => {
    setCurrentUser(session.getCurrentUser());
  }, []);

  React.useEffect(() => {
    if (currentUser === null) {
      return;
    }
    getUsers().then(setUsers);
  }, [currentUser]);

  const currentChat = chats.find(({ id }) => id === currentChatId);

  React.useEffect(() => {
    if (!currentUser) {
      return;
    }

    function reload() {
      getChats(currentUser?.id).then(setChats);
    }
    reload();
    const intervalId = setInterval(reload, 2000);

    return () => {
      clearInterval(intervalId);
    };
  }, [currentUser]);

  React.useEffect(() => {
    if (currentChatId === null && chats.length > 0) {
      setCurrentChatId(chats[0].id);
    }
  }, [chats, currentChatId]);

  const [isProfileMenuOpen, setIsProfileMenuOpen] = React.useState(false);
  const [isCreateChatOpen, setIsCreateChatOpen] = React.useState(false);

  const defaultMode = true;
  const [mode, setMode] = React.useState(defaultMode);

  const theme = createTheme({
    palette: {
      mode: mode ? "light" : "dark",
    },
  });

  return (
    <ThemeProvider theme={theme}>
      <Paper sx={{ minHeight: "100vh" }}>
        <Container fixed>
          <AppBar sx={{ marginBottom: 4 }} position="static">
            <Toolbar sx={{ justifyContent: "space-between" }}>
              {currentUser?.username ? (
                <>
                  <BadgeAvatar
                    onClick={() => {
                      setIsProfileMenuOpen(true);
                    }}
                  >
                    {currentUser.username[0]}
                  </BadgeAvatar>
                  <Typography sx={{ paddingLeft: "20px" }} variant="h6">
                    Welcome, {currentUser?.username}!
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
                color="default"
              />
            </Toolbar>
          </AppBar>
          {!currentUser && (
            <Grid spacing={2}>
              <Grid xs={12}>
                <LoginForm onLogin={onLogin} />
              </Grid>
            </Grid>
          )}
          {currentUser && (
            <Grid container spacing={2}>
              <Grid xs={4}>
                <Stack></Stack>
                <Button
                  variant="outlined"
                  onClick={() => setIsCreateChatOpen(true)}
                >
                  Create new chat
                </Button>
                <div className="chats">
                  <div className="new-chat">
                    <NewChatForm
                      users={users}
                      open={isCreateChatOpen}
                      onClose={() => setIsCreateChatOpen(false)}
                      currentUser={currentUser}
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
                    currentUser={currentUser}
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
                    setCurrentUser(null);
                    setIsProfileMenuOpen(false);
                  }}
                >
                  Log out
                </Button>
              </DialogActions>
            </DialogContent>
          </Dialog>
        </Container>
      </Paper>
    </ThemeProvider>
  );
}

export default App;
