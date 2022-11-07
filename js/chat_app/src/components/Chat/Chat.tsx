import { Box, CircularProgress, Container, TextField } from "@mui/material";
import React, { useContext, useEffect, useState } from "react";
import { UserContext } from "../UserContext";

import Timeline from "@mui/lab/Timeline";
import TimelineItem from "@mui/lab/TimelineItem";
import TimelineSeparator from "@mui/lab/TimelineSeparator";
import TimelineConnector from "@mui/lab/TimelineConnector";
import TimelineContent from "@mui/lab/TimelineContent";
import TimelineDot from "@mui/lab/TimelineDot";
import TimelineOppositeContent from "@mui/lab/TimelineOppositeContent";
import { ChatMembersList } from "./ChatMemberList";
import { useHttpClient } from "../serverResponse";

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
  message: string;
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
  const { auth } = useContext(UserContext);
  const fetchJSON = useHttpClient();


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

  const getMessages = () => {
    fetchJSON(`/api/chats/${chatId}`)
      .then((data) => {
        setMessagesList(data.messages);
      });
  };

  const postMessage = (message: string): void => {

    fetchJSON(`/api/chats/${chatId}/messages`,{ method: "POST", body: JSON.stringify({
          message: message,
          authorId: auth.user.id,
        })})
  };

  const getUsersList = (): void => {
    fetchJSON("/api/users")
      .then((data) => setUsersList(data));
  };

  const getUserName = (
    array: UsersListType[],
    messageItem: MessageListType
  ): string => {
    const items = array.find((item) => item.id === messageItem.authorId);
    const username = items?.username;
    return username ?? "";
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
          <ChatMembersList chatId={chatId}/>
          <form
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
                width: "95%",
              }}
              onChange={(e) => {
                setMessage(e.currentTarget.value);
              }}
              value={message}
            />
          </form>
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
                      {messageItem.message}
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
