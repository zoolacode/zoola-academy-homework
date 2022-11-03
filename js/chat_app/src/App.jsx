import { useState, useMemo } from "react";
import { ThemeProvider, createTheme, CssBaseline } from "@mui/material";
import { ButtonsAndChatList } from "./components/ButtonsAndChatList/ButtonsAndChatList";
import { Header } from "./Header";
import { LoginPage } from "./LoginPage";

import "./App.css";

function App() {
  const [mode, setMode] = useState("light");
  const [userData, setUserData] = useState({});

  // userData is saved in this format {
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
        <div className="container">
          {userData.authToken && (
            <>
              <ButtonsAndChatList
                userData={userData}
              />
            </>
          )}
        </div>
      </ThemeProvider>
    </>
  );
}

export default App;
