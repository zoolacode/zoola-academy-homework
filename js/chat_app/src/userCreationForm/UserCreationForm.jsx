import React from "react";
import { useState, useEffect } from "react";
import "./user_create_form.css";
import Avatar from "@mui/material/Avatar";
import { green } from "@mui/material/colors";

export const UserCreationForm = ({ styleForm }) => {
  const [usernameInput, setUsernameInput] = useState("");
  const [passwordInput, setPasswordInput] = useState("");
  const [token, setToken] = useState("");
  const [users, setUsers] = useState([]);

  useEffect(() => {
    function getAdminId() {
      fetch("/api/login", {
        method: "POST",
        headers: {
          "Content-type": "application/json; charset=UTF-8",
        },
        body: JSON.stringify({
          username: "admin",
          password: "admin",
        }),
      })
        .then((res) => {
          return res.json();
        })
        .then((data) => {
          setToken(data);
          getUsers(data.authToken);
        });
    }
    getAdminId();
  }, []);

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
    });
    getUsers(adminToken);
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

  return (
    <div className={"form" + styleForm}>
      <div className="formHeader">Create user</div>
      <form
        className="formBody"
        onSubmit={(e) => {
          createUser(
            token.authToken,
            token.user.id,
            usernameInput,
            passwordInput
          );
          setPasswordInput("");
          setUsernameInput("");
          e.preventDefault();
        }}
      >
        <input
          placeholder="Username"
          value={usernameInput}
          onChange={(e) => setUsernameInput(e.target.value)}
        />
        <input
          placeholder="Password"
          type="password"
          value={passwordInput}
          onChange={(e) => setPasswordInput(e.target.value)}
        />
        <button>SEND</button>
      </form>
      <div>
        <ul className="userListUl">
          {users
            ? users.map((user) => {
                if (
                  user.username === "admin" &&
                  token.user.id === "fhs8dhf9s8dhf9sd8hf9sd8hf"
                ) {
                  return (
                    <li key={user.id} className="userListLi">
                      <Avatar sx={{ bgcolor: green[500] }} variant="square">
                        {user.username.charAt(0)}
                      </Avatar>
                      {user.username}
                    </li>
                  );
                } else {
                  return (
                    <li key={user.id} className="userListLi">
                      <Avatar>{user.username.charAt(0)}</Avatar>
                      {user.username}
                    </li>
                  );
                }
              })
            : "Loading..."}
        </ul>
      </div>
    </div>
  );
};
