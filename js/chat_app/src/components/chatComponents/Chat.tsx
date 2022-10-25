import { Box, Container, TextField } from "@mui/material";
import React, { useContext, useEffect, useState } from "react";
import { UserContext } from "../UserContext";

import Timeline from "@mui/lab/Timeline";
import TimelineItem from "@mui/lab/TimelineItem";
import TimelineSeparator from "@mui/lab/TimelineSeparator";
import TimelineConnector from "@mui/lab/TimelineConnector";
import TimelineContent from "@mui/lab/TimelineContent";
import TimelineDot from "@mui/lab/TimelineDot";
import TimelineOppositeContent from "@mui/lab/TimelineOppositeContent";

interface dateOptions {
  day: "numeric";
  month: "numeric";
  year: "numeric";
  hour: "numeric";
  minute: "numeric";
  second: "numeric";
}

type messageListType = {
  id: string;
  message: string;
  authorId: string;
  date: number;
};

type usersListType = {
  id?: string;
  username?: string;
};

export const Chat: React.FC = () => {
  const [messagesList, setMessagesList] = useState<messageListType[]>([]);
  const [usersList, setUsersList] = useState<usersListType[]>([]);
  const [message, setMessage] = useState<string>("");
  const { auth } = useContext(UserContext);
  const chatId: string = "e2f96143-b219-40e1-b6dc-a9a6a0cd01c0";

  const options: dateOptions = {
    day: "numeric",
    month: "numeric",
    year: "numeric",
    hour: "numeric",
    minute: "numeric",
    second: "numeric",
  };

  useEffect(() => {
    getUsersList();
    const interval = setInterval(() => {
      fetch(`/api/chats/${chatId}`, {
        method: "GET",
        headers: {
          "Content-type": "application/json",
          "Auth-Token": auth.authToken,
        },
      })
        .then((res) => res.json())
        .then((data) => {
          setMessagesList(data.messages);
        });
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  }, []);

  const postMessage = (message: string): void => {
    fetch(`/api/chats/${chatId}/messages`, {
      method: "POST",
      headers: {
        "Content-type": "application/json",
        "Auth-Token": auth.authToken,
      },
      body: JSON.stringify({
        message: message,
        authorId: auth.user.id,
      }),
    });
  };

  const getUsersList = (): void => {
    fetch("/api/users", {
      method: "GET",
      headers: {
        "Content-type": "application/json",
        "Auth-Token": auth.authToken,
      },
    })
      .then((res) => res.json())
      .then((data) => setUsersList(data));
  };

  const getUserName = (
    array: usersListType[],
    messageItem: messageListType
  ): string | undefined => {
    const items = array.find((item) => item.id === messageItem.authorId);
    const username = items?.username;
    return username;
  };

  return (
    <Container>
      <Box
        sx={{
          width: 800,
          height: 600,
          marginLeft: "auto",
          marginTop: 5,
        }}
      >
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
              width: 750,
            }}
            onChange={(e) => {
              setMessage(e.currentTarget.value);
            }}
            value={message}
          />
        </form>
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
            )) ?? "Loading..."}
        </Timeline>
      </Box>
    </Container>
  );
};
