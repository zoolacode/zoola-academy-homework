import React, { useEffect, useState, useContext } from "react";
import {
  Box,
  TextField,
  MenuItem,
  Select,
  InputLabel,
  FormControl,
  OutlinedInput,
  Button,
  DialogTitle,
  Dialog,
  DialogActions,
} from "@mui/material";
import { UserContext } from "./UserContext";

function fetchCreateChatWithMembers(chatName, token, selectedUsers, userId) {
  return fetch("/api/chats", {
    method: "post",
    body: JSON.stringify({ title: chatName }),
    headers: {
      "content-type": "application/json",
      "auth-token": token,
    },
  })
    .then((response) => response.json())
    .then((date) => date.id)
    .then((date) => {
      return fetch(`/api/chats/${date}/members`, {
        method: "post",
        body: JSON.stringify({ members: [...selectedUsers, userId] }),
        headers: {
          "content-type": "application/json",
          "auth-token": token,
        },
      }).then((r) => r.json());
    });
}
function fetchGetUsers(token) {
  return fetch(`/api/users/`, {
    method: "get",
    headers: {
      "content-type": "application/json",
      "auth-token": token,
    },
  }).then((response) => response.json());
}

export function CreateChatForm() {
  const { auth } = useContext(UserContext);

  const [open, setOpen] = useState(false);
  const [users, setUsers] = useState([]);
  useEffect(() => {
    fetchGetUsers(auth.authToken).then(setUsers);
  }, [open]);

  const [selectedUsers, setSelectedUsers] = useState([auth.user.id]);
  const handleChangeSelect = (event) => {
    setSelectedUsers(event.target.value);
  };

  const [chatName, setChatName] = useState("");
  const handleChatName = (event) => {
    setChatName(event.target.value);
  };

  const handleClickOpen = () => {
    setOpen(true);
  };
  const handleClose = () => {
    setOpen(false);
    setChatName("");
    setSelectedUsers([]);
  };
  const handleSubmit = () => {
    fetchCreateChatWithMembers(
      chatName,
      auth.authToken,
      selectedUsers,
      auth.user.id
    ).then(() => {
      handleClose();
    });
  };

  return (
    <>
      <Button
        variant="outlined"
        onClick={handleClickOpen}
        sx={{
          width: "100%",
          mb: 5,
        }}
      >
        Create New Chat
      </Button>
      <Dialog sx={{ m: 2 }} onClose={handleClose} open={open}>
        <DialogTitle>Create new chat</DialogTitle>
        <Box sx={{ p: 3 }}>
          <TextField
            fullWidth
            label="Chat name"
            onChange={handleChatName}
          ></TextField>

          <FormControl fullWidth sx={{ mb: 5, mt: 2 }}>
            <InputLabel id="usersSelect">Members</InputLabel>
            <Select
              labelId="usersSelect"
              multiple
              value={selectedUsers}
              onChange={handleChangeSelect}
              input={<OutlinedInput label="Members" />}
            >
              {users.map((el) => {
                if (el.id !== auth.user.id)
                  return (
                    <MenuItem key={el.id} value={el.id}>
                      {el.username}
                    </MenuItem>
                  );
              })}
            </Select>
          </FormControl>

          <DialogActions sx={{ mr: -1 }}>
            <Button onClick={handleSubmit} variant="outlined">
              Create
            </Button>
          </DialogActions>
        </Box>
      </Dialog>
    </>
  );
}
