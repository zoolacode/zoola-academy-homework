import React, { useState, useEffect } from "react";
import {
  Box,
  Button,
  Dialog,
  DialogContent,
  DialogTitle,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  Stack,
  TextField,
} from "@mui/material";

const currentUserToken = "d46c97b0-ddcc-4897-b327-8593fcf6cb78";
const currentUserId = "75da786f-b490-408d-9ea1-ee1675b98d3c";

export const NewChatForm = ({ open, onClose }) => {
  const [chatMembers, setChatMembers] = useState([]);
  const [users, setUsers] = useState([]);
  const [chatName, setChatName] = useState("");

  const submitHandler = async () => {
    const data1 = {
      userId: currentUserId,
      title: chatName,
    };

    const data2 = {
      members: [currentUserId, ...chatMembers],
    };

    await fetch("/api/chats", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "auth-token": currentUserToken,
      },
      body: JSON.stringify(data1),
    })
      .then((response) => response.json())
      .then((chat) => {
        fetch(`/api/chats/${chat.id}/members`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            "auth-token": currentUserToken,
          },
          body: JSON.stringify(data2),
        }).then((response) => response.json());
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  useEffect(() => {
    const interval = setInterval(() => {
      fetch("/api/users", {
        headers: {
          "Content-Type": "application/json",
          "auth-token": currentUserToken,
        },
      })
        .then((response) => response.json())
        .then((data) => setUsers(data));
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  }, []);

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>Create new chat</DialogTitle>
      <DialogContent>
        <Box>
          <form
            onSubmit={(e) => {
              e.preventDefault();
            }}
          >
            <Stack spacing={2}>
              <TextField
                label="Chat name"
                value={chatName}
                onChange={(e) => setChatName(e.target.value)}
              />
              <FormControl sx={{ width: 300 }}>
                <InputLabel>Members</InputLabel>
                <Select
                  label="Members"
                  multiple
                  value={chatMembers}
                  onChange={(e) => {
                    setChatMembers(e.target.value);
                  }}
                >
                  {users
                    .filter((user) => user.id !== currentUserId)
                    .map((user) => (
                      <MenuItem key={user.id} value={user.id}>
                        {user.username}
                      </MenuItem>
                    ))}
                </Select>
              </FormControl>
              <Button variant="outlined" onClick={submitHandler}>
                Create
              </Button>
            </Stack>
          </form>
        </Box>
      </DialogContent>
    </Dialog>
  );
}
