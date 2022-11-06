import { Container, Box, TextField } from "@mui/material";
import React, { useEffect, useState, useRef } from "react";
import { Messages } from "../Messages/Message";
import AttachFileIcon from "@mui/icons-material/AttachFile";

import { getUsers, getChatById, addChatMessage, uploadFileToChat } from "../../function/requests";
import { INTERVAL_UPDATE } from "../../constants";

export const Chat = ({ chatId, userData = {} }) => {
  const [usersList, setUsersList] = useState([]);
  const [messagesList, setMessagesList] = useState([]);
  const [message, setMessage] = useState("");
  const hiddenFileInputRef = useRef(null);

  useEffect(() => {
    if (chatId) {
      getUsers(userData.authToken).then((data) =>
        setUsersList(data)
      );
      getChatById(userData.authToken, chatId).then(
        (data) => setMessagesList(data.messages)
      );
      const interval = setInterval(() => {
        getChatById(userData.authToken, chatId)
        .then((data) => setMessagesList(data.messages));
      }, INTERVAL_UPDATE);

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
    addChatMessage(userData.authToken, chatId, data)
    .then(
      (data) => setMessagesList(data.messages)
    );
  };

  const onUploadClick = (e) => {
    if (hiddenFileInputRef.current) {
      hiddenFileInputRef.current.click();
    }
  }
  const onUploadPhoto = (e) => {
    try {
        const uploadedFile = e?.target?.files[0];
        uploadFileToChat(
          userData.authToken,
          chatId,
          uploadedFile
        );
    } catch (err) {
        console.log(err);
    }
  };

  if (!chatId) {
    return (
      <Box
        sx={{
          display: "flex",
          width: "100%",
          alignItems: "center",
          justifyContent: "space-around",
          minHeight: "50vh"
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
            position: "relative"
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
            ml={1}
            sx={{
              position: "absolute",
              right: "10px",
              top: "5px"
            }}
          >
            <AttachFileIcon fontSize="small" sx={{ cursor: "pointer" }} onClick={onUploadClick}/>
            <input
              id="attach"
              type="file"
              accept="image/png, image/jpeg"
              style={{display: "none"}}
              ref={hiddenFileInputRef}
              onChange={onUploadPhoto}
            />
          </Box>
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
