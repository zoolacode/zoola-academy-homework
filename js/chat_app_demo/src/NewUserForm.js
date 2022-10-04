import { useUpdateEffect } from "react-use";
import {
  Avatar,
  Box,
  Button,
  Dialog,
  DialogContent,
  DialogTitle,
  MenuItem,
  MenuList,
  Stack,
  TextField,
  Typography,
} from "@mui/material";
import React from "react";
import { createUser } from "./httpUtils";

export const NewUserForm = ({
  users,
  open,
  onClose,
  currentUser,
  onUsersUpdated,
}) => {
  const [submitted, setSubmitted] = React.useState(true);
  const [username, setUsername] = React.useState("");
  const [password, setPassword] = React.useState("");
  const [selectedUserId, setSelectedUserId] = React.useState(null);

  useUpdateEffect(() => {
    if (!submitted) {
      return;
    }

    onUsersUpdated();
  }, [submitted]);

  React.useEffect(() => {
    if (submitted) {
      return;
    }

    createUser({
      adminId: currentUser.id,
      username,
      password,
    }).finally(() => {
      setSubmitted(true);
    });
  }, [submitted]);

  return (
    <Dialog
      open={open}
      onClose={() => {
        setUsername("");
        setPassword("");
        onClose();
      }}
    >
      <DialogTitle>Create user</DialogTitle>
      <DialogContent sx={{ width: 400 }}>
        <Stack mt={1} spacing={5}>
          <Box>
            <form
              onSubmit={(e) => {
                e.preventDefault();
                setSubmitted(false);
              }}
            >
              <Stack spacing={2}>
                <TextField
                  label="Username"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                />
                <TextField
                  label="Password"
                  type="password"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
                <input type="submit" style={{ display: "none" }} />
              </Stack>
            </form>
            <Box mt={2} sx={{ justifyContent: "center", display: "flex" }}>
              <Button
                fullWidth
                variant="outlined"
                onClick={() => setSubmitted(false)}
              >
                Send
              </Button>
            </Box>
          </Box>
          <Box>
            <Stack spacing={1}>
              {users.map((user) => {
                return (
                  <Box key={user.id}>
                    <Stack sx={{ alignItems: "center" }} direction="row">
                      <Avatar
                        variant={user.id === currentUser?.id ? "square" : ""}
                      >
                        {user.username[0]}
                      </Avatar>
                      <Box ml={2}>
                        <Typography variant="body2">{user.username}</Typography>
                      </Box>
                    </Stack>
                  </Box>
                );
              })}
            </Stack>
          </Box>
        </Stack>
      </DialogContent>
    </Dialog>
  );
};
