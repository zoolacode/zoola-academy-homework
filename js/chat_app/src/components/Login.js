import React from "react";
import "./Login.css";
import {
  AppBar,
  Button,
  Container,
  TextField,
  Typography,
  Toolbar,
  Switch,
} from "@mui/material";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useContext } from "react";
import { UserContext } from "./UserContext";

const Login = () => {
  const { setAuth } = useContext(UserContext);

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
    sessionStorage.setItem("user-info", JSON.stringify(result));
    navigate("/dashboard", { replace: true });
  }

  return (
    <Container maxWidth="lg">
      <AppBar position="static" color="primary">
        <Toolbar sx={{ flexDirection: "row-reverse" }}>
          <Switch color="default" />
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

export default Login;
