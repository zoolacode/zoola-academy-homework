import React from "react";
import { useDropzone } from "react-dropzone";
import AttachFileIcon from "@mui/icons-material/AttachFile";
import Timeline from "@mui/lab/Timeline";
import TimelineItem from "@mui/lab/TimelineItem";
import TimelineSeparator from "@mui/lab/TimelineSeparator";
import TimelineConnector from "@mui/lab/TimelineConnector";
import TimelineContent from "@mui/lab/TimelineContent";
import TimelineDot from "@mui/lab/TimelineDot";

import { addChatMembers, addChatMessage, uploadFileToChat } from "./httpUtils";
import { TimelineOppositeContent } from "@mui/lab";
import {
  Typography,
  Input,
  Dialog,
  DialogTitle,
  AvatarGroup,
  Avatar,
  DialogContent,
  Box,
  Button,
  Select,
  MenuItem,
  InputLabel,
  FormControl,
} from "@mui/material";
import { Stack } from "@mui/system";
import {
  amber,
  blueGrey,
  deepOrange,
  deepPurple,
  lightBlue,
} from "@mui/material/colors";

function getAvatarColor(index) {
  const max = 5;
  const colors = [deepOrange, deepPurple, lightBlue, blueGrey, amber];
  return colors[index % max][500];
}

export function Chat({ chat, currentUser, users }) {
  const [message, setMessage] = React.useState("");
  const [isMembersOpen, setIsMembersOpen] = React.useState(false);
  const [newChatMembers, setNewChatMembers] = React.useState([]);
  const [attachment, setAttachment] = React.useState(null);
  const dropzone = useDropzone({
    multiple: false,
    onDrop: (files) => {
      setAttachment(files[0]);
    },
  });

  React.useEffect(() => {
    if (attachment) {
      uploadFileToChat({
        authorId: currentUser.id,
        chatId: chat.id,
        file: attachment,
      }).finally(() => {
        setAttachment(null);
      });
    }
  }, [attachment]);

  React.useEffect(() => {
    setMessage("");
  }, [chat?.id]);

  function onSubmitMessage(e) {
    e.preventDefault();
    setMessage("");
    addChatMessage({
      chatId: chat.id,
      authorId: currentUser.id,
      message,
    });
  }

  const messages = chat?.messages ?? [];
  const chatMessages = [...messages].reverse();

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

  const [previewAttachment, setPreviewAttachment] = React.useState(null);

  return (
    <div>
      <Dialog
        open={isMembersOpen}
        onClose={() => {
          setIsMembersOpen(false);
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
                    setIsMembersOpen(false);
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
      <Stack spacing={4}>
        <AvatarGroup total={members.length}>
          {members.map((user, index) => (
            <Avatar
              onClick={() => setIsMembersOpen(true)}
              sx={{ bgcolor: getAvatarColor(index), cursor: "pointer" }}
            >
              {user?.username[0]}
            </Avatar>
          ))}
        </AvatarGroup>
        <Stack direction="row" alignItems="center">
          <form
            style={{ flexGrow: "1", display: "flex" }}
            onSubmit={onSubmitMessage}
          >
            <Input
              placeholder="Enter your message"
              style={{ width: "100%" }}
              value={message}
              onChange={(e) => setMessage(e.target.value)}
            />
          </form>
          <div {...dropzone.getRootProps()}>
            <AttachFileIcon fontSize="small" sx={{ cursor: "pointer" }} />
            <input {...dropzone.getInputProps()} type="file" />
          </div>
        </Stack>
      </Stack>
      <Dialog
        open={Boolean(previewAttachment)}
        onClose={() => setPreviewAttachment(null)}
      >
        <DialogContent>
          <img
            style={{ width: "100%" }}
            src={`/uploads/${previewAttachment}`}
          />
        </DialogContent>
      </Dialog>
      <div>
        {chatMessages.length ? (
          <Timeline>
            {chatMessages.map(
              ({ id, authorId, attachment, message, date: date_ }, index) => {
                const author = usersMap[authorId];
                const date = new Date(date_).toLocaleTimeString();
                const time = new Date(date_).toLocaleDateString();
                const isLast = index === chatMessages.length - 1;
                return (
                  <TimelineItem key={id}>
                    <TimelineOppositeContent>
                      {attachment ? (
                        <>
                          <div
                            style={{ cursor: "pointer" }}
                            onClick={() => setPreviewAttachment(attachment)}
                          >
                            <img
                              className="attachment-preview"
                              src={`/uploads/${attachment}`}
                            />
                          </div>
                        </>
                      ) : (
                        <Typography variant="body1">{message}</Typography>
                      )}
                    </TimelineOppositeContent>

                    <TimelineSeparator>
                      <TimelineDot />
                      {!isLast && <TimelineConnector />}
                    </TimelineSeparator>
                    <TimelineContent style={{ color: "grey" }}>
                      <Typography variant="body2">{author.username}</Typography>
                      <Typography variant="caption">
                        {time}/{date}
                      </Typography>
                    </TimelineContent>
                  </TimelineItem>
                );
              }
            )}
          </Timeline>
        ) : (
          <Box mt={4}>
            <Typography variant="body2">This chat is empty</Typography>
          </Box>
        )}
      </div>
    </div>
  );
}
