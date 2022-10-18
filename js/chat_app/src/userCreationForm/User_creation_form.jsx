import React from "react";
import { useState, useEffect, useRef } from "react";
import "./user_create_form.css";
import Avatar from "@mui/material/Avatar";
import { green } from "@mui/material/colors";
import { useCallback } from "react";

const User_creation_form = ({ trigger }) => {
  const usernameInput = useRef();
  const passwordInput = useRef();
  const [token, setToken] = useState("");
  const [users, setUsers] = useState();
  const [updateUsersList, setUpdateUsersList] = useState(true);

  useEffect(() => {
    async function getAdminId() {
      await fetch("/api/login", {
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
    setUpdateUsersList(!updateUsersList);
    getUsers(adminToken);
  }

  const getUsers = useCallback(
    async (adminToken) => {
      const response = await fetch("/api/users", {
        method: "GET",
        headers: {
          "Content-type": "application/json",
          "Auth-Token": adminToken,
        },
      });
      const json = await response.json();
      setUsers(json);
    },
    [token, updateUsersList]
  );

  return (
    <div
      className="form"
      style={trigger ? { display: "block" } : { display: "none" }}
    >
      <div className="form__header">Create user</div>
      <form
        className="form__body"
        onSubmit={(e) => {
          createUser(
            token.authToken,
            token.user.id,
            usernameInput.current.value,
            passwordInput.current.value
          );
          e.preventDefault();
          usernameInput.current.value = "";
          passwordInput.current.value = "";
        }}
      >
        <input
          placeholder="Username"
          className="form__body-username"
          ref={usernameInput}
        />
        <input
          placeholder="Password"
          type="password"
          className="form__body-password"
          ref={passwordInput}
        />
        <button>SEND</button>
      </form>
      <div className="form__userList">
        <ul className="userList__ul">
          {users
            ? users.map((user) => {
                if (
                  user.username === "admin" &&
                  token.user.id === "fhs8dhf9s8dhf9sd8hf9sd8hf"
                ) {
                  return (
                    <li key={user.id} className="userList__li">
                      <Avatar sx={{ bgcolor: green[500] }} variant="square">
                        {user.username.charAt(0)}
                      </Avatar>
                      {user.username}
                    </li>
                  );
                } else {
                  return (
                    <li key={user.id} className="userList__li">
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

export default User_creation_form;
