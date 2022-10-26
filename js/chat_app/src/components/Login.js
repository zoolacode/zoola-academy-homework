import React, { useState, useContext } from "react";
import "../styles/Login.css";
import {
  AppBar,
  Button,
  Container,
  TextField,
  Typography,
  Toolbar,
  Switch,
} from "@mui/material";
import { useNavigate } from "react-router-dom";
import { UserContext } from "./UserContext";
import { ThemeContext } from "./ThemeContext";
import Brightness4RoundedIcon from "@mui/icons-material/Brightness4Rounded";
import Brightness5RoundedIcon from "@mui/icons-material/Brightness5Rounded";
import { set } from "./themeStorage.ts";

export const Login = () => {
  const { setAuth } = useContext(UserContext);

  const { toggleMode, darkMode } = useContext(ThemeContext);

  const navigate = useNavigate();
  const [username, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState(false);

  async function handleClick(e) {
    e.preventDefault();
    let response = await fetch("/api/login", {
      method: "POST",
      headers: {
        "content-type": "application/json",
      },
      body: JSON.stringify({ username, password }),
    });
    if (response.status === 401) {
      setError(true);
    }
    const result = await response.json();
    setAuth(result);
    set("user-info", result);
    navigate("/dashboard", { replace: true });
  }

  return (
    <Container maxWidth="lg">
      <AppBar position="static" color="primary">
        <Toolbar sx={{ flexDirection: "row-reverse" }}>
          <Switch
            color="default"
            onChange={toggleMode}
            checked={darkMode}
            checkedIcon={<Brightness4RoundedIcon fontSize="small" />}
            icon={<Brightness5RoundedIcon fontSize="small" />}
          />
        </Toolbar>
      </AppBar>
      <form className="form" onSubmit={handleClick}>
        <Typography variant="h5" mb={1}>
          Welcome to chat
        </Typography>
        <TextField
          margin="normal"
          label="Username"
          error={error}
          variant="outlined"
          onChange={(e) => setUserName(e.target.value)}
        />
        <TextField
          margin="normal"
          label="Password"
          error={error}
          type="password"
          variant="outlined"
          onChange={(e) => setPassword(e.target.value)}
        />
        <Button
          sx={{ m: 2 }}
          type="submit"
          size="medium"
          variant="contained"
          color="primary"
        >
          Login
        </Button>
      </form>
    </Container>
  );
};
