import {
  Avatar,
  Button,
  Dialog,
  DialogContent,
  DialogTitle,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  Typography,
} from "@mui/material";
import { Stack } from "@mui/system";
import React from "react";
import { addChatMembers } from "./httpUtils";
import { getAvatarColor } from "./avatarUtils";

export const ChatMembersDialog = ({
  currentUser,
  chat,
  users,
  open,
  onClose,
}) => {
  const [newChatMembers, setNewChatMembers] = React.useState([]);

  const usersMap = React.useMemo(() => {
    return users.reduce((acc, user) => {
      return {
        ...acc,
        [user.id]: user,
      };
    }, {});
  }, [users]);

  const members = chat?.members
    ?.filter((userId) => userId !== currentUser.id)
    .map((userId) => usersMap[userId]);

  const possibleNewMembers = React.useMemo(() => {
    if (!chat) {
      return [];
    }
    return users.filter((user) => !chat.members.includes(user.id));
  }, [chat, users]);

  return (
    <Dialog
      open={open}
      onClose={() => {
        onClose();
        setNewChatMembers([]);
      }}
    >
      <DialogTitle>Group members</DialogTitle>
      <DialogContent sx={{ width: 400 }}>
        <Stack direction="column" spacing={1}>
          {possibleNewMembers.length > 0 && (
            <form
              onSubmit={(e) => {
                e.preventDefault();
                addChatMembers({
                  chatId: chat.id,
                  members: newChatMembers,
                }).then(() => {
                  onClose();
                  setNewChatMembers([]);
                });
              }}
            >
              <Stack spacing={2}>
                <FormControl sx={{ mt: 2 }}>
                  <InputLabel>New members</InputLabel>
                  <Select
                    label="New members"
                    multiple
                    value={newChatMembers}
                    onChange={(e) => {
                      setNewChatMembers(e.target.value);
                    }}
                  >
                    {possibleNewMembers.map((user) => (
                      <MenuItem key={user.id} value={user.id}>
                        {user.username}
                      </MenuItem>
                    ))}
                  </Select>
                </FormControl>
                <Button type="submit">Add</Button>
              </Stack>
            </form>
          )}

          {members.map((user, index) => {
            return (
              <Stack direction="row" sx={{ alignItems: "center" }}>
                <Avatar sx={{ bgcolor: getAvatarColor(index) }}>
                  {user.username[0]}
                </Avatar>
                <Typography pl={2} variant="body1">
                  {user.username}
                </Typography>
              </Stack>
            );
          })}
        </Stack>
      </DialogContent>
    </Dialog>
  );
};
