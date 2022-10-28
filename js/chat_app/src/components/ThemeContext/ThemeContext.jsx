import { createContext } from 'react';
import { createTheme } from '@mui/material';

const theme = createTheme({
  palette: {
    mode: 'light'
  }
});

export const ThemeContext = createContext(theme);
