import { createContext, useState } from "react";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import { CssBaseline } from "@mui/material";

export const ThemeContext = createContext(null);

export const Theme = ({ children }) => {
  const [darkMode, setDarkMode] = useState(
    !!JSON.parse(sessionStorage.getItem("darkMode"))
  );

  const [checked, setChecked] = useState(
    !!JSON.parse(sessionStorage.getItem("isChecked"))
  );

  const theme = createTheme({
    palette: {
      mode: darkMode ? "dark" : "light",
    },
  });

  const toggleMode = (e) => {
    setChecked(e.target.checked);
    sessionStorage.setItem("isChecked", !checked);
    setDarkMode(!darkMode);
    sessionStorage.setItem("darkMode", !darkMode);
  };

  return (
    <ThemeContext.Provider
      value={{ checked, toggleMode, setDarkMode, setChecked }}
    >
      <ThemeProvider theme={theme}>
        <CssBaseline />
        {children}
      </ThemeProvider>
    </ThemeContext.Provider>
  );
};
