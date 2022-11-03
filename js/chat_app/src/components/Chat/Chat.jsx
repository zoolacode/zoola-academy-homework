import { Container, Box, TextField } from "@mui/material";
import React, { useEffect, useState } from "react";
import { fetchRequestJSON } from "../../function/fetch";
import { Messages } from "../Messages/Message";

export const Chat = ({ chatId, userData }) => {
  const [usersList, setUsersList] = useState([]);
  const [messagesList, setMessagesList] = useState([]);
  const [message, setMessage] = useState("");

  useEffect(() => {
    if (chatId) {
      fetchRequestJSON("/api/users", "GET", userData.authToken).then((data) =>
        setUsersList(data)
      );
      fetchRequestJSON(`/api/chats/${chatId}`, "GET", userData.authToken).then(
        (data) => setMessagesList(data.messages)
      );
      const interval = setInterval(() => {
        fetchRequestJSON(
          `/api/chats/${chatId}`,
          "GET",
          userData.authToken
        ).then((data) => setMessagesList(data.messages));
      }, 1000);

      return () => {
        clearInterval(interval);
      };
    }
  }, [chatId]);

  const postMessage = (message) => {
    const data = {
      message: message,
      authorId: userData.user.id,
    };
    fetchRequestJSON(
      `/api/chats/${chatId}/messages`,
      "POST",
      userData.authToken,
      data
    ).then((data) => setMessagesList(data.messages));
  };

  if (!chatId) {
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
            <Messages messagesList={messagesList} usersList={usersList} />
          </Box>
        </Box>
      </Container>
    );
  }
};
