import {
  Box,
  CircularProgress,
  Container,
  Dialog,
  DialogContent,
  TextField,
} from "@mui/material";
import React, { useContext, useEffect, useState } from "react";
import { useDropzone } from "react-dropzone";
import { UserContext } from "../UserContext";
import Timeline from "@mui/lab/Timeline";
import TimelineItem from "@mui/lab/TimelineItem";
import TimelineSeparator from "@mui/lab/TimelineSeparator";
import TimelineConnector from "@mui/lab/TimelineConnector";
import TimelineContent from "@mui/lab/TimelineContent";
import TimelineDot from "@mui/lab/TimelineDot";
import TimelineOppositeContent from "@mui/lab/TimelineOppositeContent";
import AttachFileIcon from "@mui/icons-material/AttachFile";
import { Stack } from "@mui/system";
import { useHttpClient } from "../serverResponse";

import Linkify from "react-linkify";

interface DateOptionsType {
  day: "numeric";
  month: "numeric";
  year: "numeric";
  hour: "numeric";
  minute: "numeric";
  second: "numeric";
}

type MessageListType = {
  id: string;
  message?: string;
  attachment?: string | Blob;
  authorId: string;
  date: number;
};

type UsersListType = {
  id?: string;
  username?: string;
};

type PropsType = {
  chatId: string | null;
};

export const Chat = ({ chatId }: PropsType) => {
  const [messagesList, setMessagesList] = useState<MessageListType[]>([]);
  const [usersList, setUsersList] = useState<UsersListType[]>([]);
  const [message, setMessage] = useState<string>("");
  const [attachment, setAttachment] =
    useState<MessageListType["attachment"]>(undefined);
  const [preview, setPreview] =
    useState<MessageListType["attachment"]>(undefined);
  const { auth } = useContext(UserContext);
  const fetchJSON = useHttpClient();

  const { getInputProps, getRootProps } = useDropzone({
    onDrop: (files) => {
      setAttachment(files[0]);
    },
    multiple: false,
  });

  const options: DateOptionsType = {
    day: "numeric",
    month: "numeric",
    year: "numeric",
    hour: "numeric",
    minute: "numeric",
    second: "numeric",
  };

  useEffect(() => {
    getUsersList();
    getMessages();

    const interval = setInterval(() => {
      if (chatId !== null) {
        getMessages();
      }
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  }, [chatId]);

  useEffect(() => {
    if (attachment) {
      uploadFile(attachment, auth.user.id);
    }
  }, [attachment]);

  const getMessages = () => {
    fetchJSON(`/api/chats/${chatId}`).then((data) => {
      setMessagesList(data.messages);
    });
  };

  const postMessage = (message: string): void => {
    fetchJSON(`/api/chats/${chatId}/messages`, {
      method: "POST",
      body: JSON.stringify({
        message: message,
        authorId: auth.user.id,
      }),
    });
  };

  const getUsersList = (): void => {
    fetchJSON("/api/users").then((data) => setUsersList(data));
  };

  const getUserName = (
    array: UsersListType[],
    messageItem: MessageListType
  ): string => {
    const items = array.find((item) => item.id === messageItem.authorId);
    const username = items?.username;
    return username ?? "";
  };

  const uploadFile = (attachment: string | Blob, id: string): void => {
    const formData = new FormData();
    formData.append("file", attachment);
    formData.append("authorId", id);

    fetch(`/api/chats/${chatId}/attachments`, {
      method: "POST",
      headers: {
        "Auth-Token": auth.authToken,
      },
      body: formData,
    });
  };

  if (chatId === null) {
    return (
      <Box
        sx={{
          display: "flex",
          width: "100%",
          alignItems: "center",
          justifyContent: "space-around",
        }}
      >
        <div>Click on chat</div>
      </Box>
    );
  } else {
    return (
      <Container>
        <Box
          sx={{
            marginLeft: "auto",
            marginTop: 5,
          }}
        >
          <Stack alignItems="center" direction="row">
            <form
              style={{ display: "flex", flexGrow: "1" }}
              onSubmit={(e) => {
                postMessage(message);
                e.preventDefault();
                setMessage("");
              }}
            >
              <TextField
                variant="standard"
                placeholder="Enter your message"
                sx={{
                  width: "100%",
                }}
                onChange={(e) => {
                  setMessage(e.currentTarget.value);
                }}
                value={message}
              />
            </form>
            <Box {...getRootProps()}>
              <AttachFileIcon fontSize="medium" sx={{ cursor: "pointer" }} />
              <input {...getInputProps()} type="file" />
            </Box>
          </Stack>
          <Dialog open={Boolean(preview)} onClose={() => setPreview(undefined)}>
            <DialogContent>
              <img style={{ width: "100%" }} src={`/uploads/${preview}`} />
            </DialogContent>
          </Dialog>
          <Box
            sx={{
              maxHeight: "75vh",
              overflow: "auto",
              overflowX: "hidden",
            }}
          >
            <Timeline>
              {messagesList
                ?.slice(0)
                .reverse()
                .map((messageItem) => (
                  <TimelineItem key={messageItem.id}>
                    <TimelineOppositeContent>
                      {messageItem.attachment ? (
                        <>
                          <div
                            onClick={() => setPreview(messageItem.attachment)}
                          >
                            <img
                              alt="img"
                              style={{
                                width: "15rem",
                                borderRadius: 4,
                                cursor: "pointer",
                              }}
                              src={`/uploads/${messageItem.attachment}`}
                            />
                          </div>
                        </>
                      ) : (
                        <Linkify
                          properties={{
                            style: { color: "green" },
                          }}
                        >
                          {messageItem.message}
                        </Linkify>
                      )}
                    </TimelineOppositeContent>
                    <TimelineSeparator>
                      <TimelineDot />
                      <TimelineConnector />
                    </TimelineSeparator>
                    <TimelineContent color="text.secondary">
                      {getUserName(usersList, messageItem)}
                      <br />
                      {`${new Date(messageItem.date).toLocaleDateString(
                        undefined,
                        options
                      )}`}
                    </TimelineContent>
                  </TimelineItem>
                )) ?? <CircularProgress />}
            </Timeline>
          </Box>
        </Box>
      </Container>
    );
  }
};
