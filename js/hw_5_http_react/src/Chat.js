import React from "react";
import { useDropzone } from "react-dropzone";
import AttachFileIcon from "@mui/icons-material/AttachFile";
import Timeline from "@mui/lab/Timeline";
import { addChatMessage, uploadFileToChat } from "./httpUtils";
import {
  AvatarGroup,
  Avatar,
  DialogContent,
  Box,
  Input,
  Dialog,
  Typography,
  CircularProgress,
} from "@mui/material";
import { Stack } from "@mui/system";
import { ChatMembersDialog } from "./ChatMembersDialog";
import { getAvatarColor } from "./avatarUtils";
import { ChatMessage } from "./ChatMessage";
import { LoadingButton } from "@mui/lab";

export function Chat({ chat, currentUser, users }) {
  const [message, setMessage] = React.useState("");
  const [isMembersOpen, setIsMembersOpen] = React.useState(false);

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

  const [previewAttachment, setPreviewAttachment] = React.useState(null);

  return (
    <Box>
      <ChatMembersDialog
        currentUser={currentUser}
        chat={chat}
        users={users}
        open={isMembersOpen}
        onClose={setIsMembersOpen}
      />
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
          <Box ml={1} {...dropzone.getRootProps()}>
            <AttachFileIcon fontSize="small" sx={{ cursor: "pointer" }} />
            <input {...dropzone.getInputProps()} type="file" />
          </Box>
        </Stack>
      </Stack>
      <Dialog
        open={Boolean(previewAttachment)}
        onClose={() => setPreviewAttachment(null)}
      >
        <DialogContent>
          <img
            alt="preview"
            style={{ width: "100%" }}
            src={`/uploads/${previewAttachment}`}
          />
        </DialogContent>
      </Dialog>
      <Box>
        {chatMessages.length ? (
          <Timeline>
            {chatMessages.map((message, index) => {
              return (
                <ChatMessage
                  key={message.id}
                  message={message}
                  isLast={index === chatMessages.length - 1}
                  users={usersMap}
                  onPreview={setPreviewAttachment}
                />
              );
            })}
          </Timeline>
        ) : (
          <Box mt={4}>
            <Typography variant="body2">This chat is empty</Typography>
          </Box>
        )}
      </Box>
    </Box>
  );
}
