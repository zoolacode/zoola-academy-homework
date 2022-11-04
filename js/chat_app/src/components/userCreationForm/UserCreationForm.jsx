import React from "react";
import { useState, useEffect, useContext } from "react";
import "./userCreationForm.css";
import Avatar from "@mui/material/Avatar";
import { green } from "@mui/material/colors";
import { UserContext } from "../UserContext";
import {
  Button,
  Dialog,
  DialogContent,
  DialogTitle,
  TextField,
} from "@mui/material";

export const UserCreationForm = ({ isOpen, setOpen }) => {
  const { auth } = useContext(UserContext);
  const [usernameInput, setUsernameInput] = useState("");
  const [passwordInput, setPasswordInput] = useState("");
  const [users, setUsers] = useState([]);

  useEffect(() => {
    getUsers(auth.authToken);
  }, [users]);

  function createUser(adminToken, adminId, username, password) {
    fetch("/api/users", {
      method: "POST",
      headers: {
        "Content-type": "application/json",
        "Auth-Token": adminToken,
      },
      body: JSON.stringify({
        adminId: adminId,
        username: username,
        password: password,
      }),
    }).then(getUsers(adminToken));
  }

  async function getUsers(adminToken) {
    const response = await fetch("/api/users", {
      method: "GET",
      headers: {
        "Content-type": "application/json",
        "Auth-Token": adminToken,
      },
    });
    const json = await response.json();
    setUsers(json);
  }

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <Dialog open={isOpen} onClose={handleClose}>
      <DialogTitle>Create user</DialogTitle>
      <DialogContent
        sx={{
          width: "30vw",
          minWidth: 250,
        }}
      >
        <form
          className="formBody"
          onSubmit={(e) => {
            createUser(
              auth.authToken,
              auth.user.id,
              usernameInput,
              passwordInput
            );
            setPasswordInput("");
            setUsernameInput("");
            e.preventDefault();
          }}
        >
          <TextField
            variant="outlined"
            placeholder="Username"
            value={usernameInput}
            onChange={(e) => setUsernameInput(e.target.value)}
          />
          <TextField
            variant="outlined"
            placeholder="Password"
            type="password"
            value={passwordInput}
            onChange={(e) => setPasswordInput(e.target.value)}
          />
          <Button variant="outlined" type="submit">
            SEND
          </Button>
        </form>
        <ul className="userListUl">
          {users?.map((user) => {
            if (user.id === auth.user.id) {
              return (
                <li key={user.id} className="userListLi">
                  <Avatar sx={{ bgcolor: green[500] }} variant="square">
                    {user.username.charAt(0).toUpperCase()}
                  </Avatar>
                  {user.username}
                </li>
              );
            } else {
              return (
                <li key={user.id} className="userListLi">
                  <Avatar>{user.username.charAt(0).toUpperCase()}</Avatar>
                  {user.username}
                </li>
              );
            }
          }) ?? "Loading..."}
        </ul>
      </DialogContent>
    </Dialog>
  );
};
