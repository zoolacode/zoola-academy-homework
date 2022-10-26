import { createContext, useState } from "react";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import { CssBaseline } from "@mui/material";
import { get } from "./themeStorage.ts";

export const ThemeContext = createContext(null);

export const Theme = ({ children }) => {
  const [darkMode, setDarkMode] = useState(Boolean(get("darkMode")));

  const theme = createTheme({
    palette: {
      mode: darkMode ? "dark" : "light",
    },
  });

  const toggleMode = () => {
    setDarkMode(!darkMode);
  };

  return (
    <ThemeContext.Provider value={{ toggleMode, setDarkMode, darkMode }}>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        {children}
      </ThemeProvider>
    </ThemeContext.Provider>
  );
};
