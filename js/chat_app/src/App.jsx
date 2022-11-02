import { useState, useMemo } from "react";
import { ThemeProvider, createTheme, CssBaseline } from "@mui/material";
import { Header } from "./components/Header";
import { LoginPage } from "./pages/LoginPage";
import { ChatPage } from "./pages/ChatPage";

import "./App.css";
import { Logout } from "./components/Logout";

function App() {
  const [mode, setMode] = useState("light");
  const [userData, setUserData] = useState({});
  const [isProfileOpen, setIsProfileOpen] = useState(false);

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
            <>
              <ChatPage userData={userData} />
              <Logout isOpen={isProfileOpen} onClose={closeProfile} userLogout={logout} />
            </>
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
