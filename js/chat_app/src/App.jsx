import { useState, useMemo } from "react";
import { Button, ThemeProvider, createTheme, CssBaseline } from "@mui/material";
import { NewUserForm } from "./components/NewUserForm/NewUserForm";
import { NewChatForm } from "./components/NewChatForm/NewChatForm";
import { Chats } from "./components/Chats/Chats";
import { Header } from "./Header";
import { LoginPage } from "./LoginPage";

import "./App.css";

function App() {
  const [isCreateUserOpen, setIsCreateUserOpen] = useState(false);
  const [isCreateChatOpen, setIsCreateChatOpen] = useState(false);
  const [mode, setMode] = useState("light");
  const [userData, setUserData] = useState({});

  //userData is saved in this format {
  //   isAdmin: boolean
  //   authToken: string
  //   user: {
  //     id: string
  //     username: string
  //   }
  // }

  const theme = useMemo(
    () =>
      createTheme({
        palette: {
          mode: mode,
        },
      }),
    [mode]
  );

  return (
    <>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        <div className="App">
          <Header setMode={setMode} mode={mode} userData={userData} />
          {!userData.authToken && (
            <LoginPage
              setUserData={setUserData}
              setMode={setMode}
              mode={mode}
            />
          )}
        </div>
      </ThemeProvider>
      <div className="App">
        <Button variant="contained" onClick={() => setIsCreateUserOpen(true)}>
          Create user
        </Button>
        <Button variant="outlined" onClick={() => setIsCreateChatOpen(true)}>
          Create new chat
        </Button>
        <NewUserForm
          open={isCreateUserOpen}
          onClose={() => setIsCreateUserOpen(false)}
        />
        <NewChatForm
          open={isCreateChatOpen}
          onClose={() => setIsCreateChatOpen(false)}
        />
        <Chats />
      </div>
    </>
  );
}

export default App;
