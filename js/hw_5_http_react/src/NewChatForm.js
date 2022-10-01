import {
  Box,
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  Divider,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  Stack,
  TextField,
} from "@mui/material";
import React from "react";
import { createChat } from "./httpUtils";

export function NewChatForm({ currentUser, open, onClose, users }) {
  const [chatMembers, setChatMembers] = React.useState([]);
  const [submitted, setSubmitted] = React.useState(true);
  const [chatName, setChatName] = React.useState("");

  React.useEffect(() => {
    if (submitted) {
      return;
    }
    createChat({
      userId: currentUser.id,
      members: chatMembers,
      title: chatName,
    }).then(() => {
      setSubmitted(true);
      onClose();
      setChatMembers([]);
      setChatName("");
    });
  }, [submitted]);

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogTitle>Create new chat</DialogTitle>
      <DialogContent>
        <Box mt={1}>
          <form
            onSubmit={(e) => {
              e.preventDefault();
              setSubmitted(false);
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
                    .filter((user) => user.id !== currentUser.id)
                    .map((user) => (
                      <MenuItem key={user.id} value={user.id}>
                        {user.username}
                      </MenuItem>
                    ))}
                </Select>
              </FormControl>
              <input type="submit" style={{ display: "none" }} />
            </Stack>
          </form>
        </Box>
      </DialogContent>
      <DialogActions>
        <Button
          onClick={() => {
            setSubmitted(false);
          }}
        >
          Create
        </Button>
      </DialogActions>
    </Dialog>
  );
}
