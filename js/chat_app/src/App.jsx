import { useState, useMemo } from "react";
import { ThemeProvider, createTheme, CssBaseline } from "@mui/material";
import { ButtonsAndChatList } from "./components/ButtonsAndChatList/ButtonsAndChatList";
import { Header } from "./components/Header";
import { LoginPage } from "./components/LoginPage";
import { Logout } from "./components/Logout";

import "./App.css";

function App() {
  const [mode, setMode] = useState("light");
  const [userData, setUserData] = useState({});
  const [isProfileOpen, setIsProfileOpen] = useState(false);

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

  const closeProfile = () => {
    setIsProfileOpen(false);
  };

  const logout = () => {
    setUserData({});
    closeProfile();
  };

  return (
    <>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        <div className="App">
          <Header setMode={setMode} mode={mode} userData={userData} setIsProfileOpen={setIsProfileOpen} />
          {userData.authToken ? (
            <div className="container">
              <ButtonsAndChatList userData={userData} />
              <Logout isOpen={isProfileOpen} onClose={closeProfile} userLogout={logout} />
            </div>
          ) : (
            <LoginPage
              setUserData={setUserData}
              setMode={setMode}
              mode={mode}
            />
          )}
        </div>
      </ThemeProvider>
    </>
  );
}

export default App;
