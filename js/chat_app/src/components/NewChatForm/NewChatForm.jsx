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
import { fetchRequestJSON } from "../../function/fetch";

const currentUserToken = "d46c97b0-ddcc-4897-b327-8593fcf6cb78";
const currentUserId = "75da786f-b490-408d-9ea1-ee1675b98d3c";
const intervalUpdate = 1000;

export const NewChatForm = ({ open, onClose }) => {
  const [chatMembers, setChatMembers] = useState([]);
  const [users, setUsers] = useState([]);
  const [chatName, setChatName] = useState("");

  const submitHandler = async (e) => {
    e.preventDefault();
    setUsers([]);
    setChatName("");

    const userData = {
      userId: currentUserId,
      title: chatName,
    };

    const membersData = {
      members: [currentUserId, ...chatMembers],
    };

    fetchRequestJSON("/api/chats", "POST", currentUserToken, userData).then(
      (chat) => {
        fetchRequestJSON(
          `/api/chats/${chat.id}/members`,
          "POST",
          currentUserToken,
          membersData
        );
      }
    );
  };

  useEffect(() => {
    const interval = setInterval(() => {
      fetchRequestJSON("/api/users", "GET", currentUserToken).then((data) =>
        setUsers(data)
      );
    }, intervalUpdate);

    return () => {
      clearInterval(interval);
    };
  }, []);

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>Create new chat</DialogTitle>
      <DialogContent>
        <Box>
          <form>
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
              <Button variant="outlined" onClick={submitHandler} onSubmit>
                Create
              </Button>
            </Stack>
          </form>
        </Box>
      </DialogContent>
    </Dialog>
  );
};
