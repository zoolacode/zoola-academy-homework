import './App.css';
import React, { useState, useMemo } from 'react';
import { Header } from './Header';
import { LoginPage } from './LoginPage';
import { ThemeProvider, createTheme } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';

function App() {
  const [mode, setMode] = useState('light');
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
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <div className='App'>
        <Header setMode={setMode} mode={mode} userData={userData} />
        {!userData.isAdmin && (
          <LoginPage setUserData={setUserData} setMode={setMode} mode={mode} />
        )}
      </div>
    </ThemeProvider>
  );
}

export default App;
