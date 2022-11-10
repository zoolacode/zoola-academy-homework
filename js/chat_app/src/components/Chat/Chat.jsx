import React, { useEffect, useState, useRef } from "react";

import { Messages } from "../Messages/Message";
import { AddChatMembersForm } from "../AddChatMembersForm/AddChatMembersForm";
import {
  getUsers,
  getChatById,
  addChatMessage,
  uploadFileToChat,
} from "../../function/requests";
import { INTERVAL_UPDATE } from "../../constants";
import AttachFileIcon from "@mui/icons-material/AttachFile";
import { Container, Box, TextField, AvatarGroup, Avatar } from "@mui/material";

export const Chat = ({ chatId, userData = {} }) => {
  const [chatMembers, setChatMembers] = useState([]);
  const [usersList, setUsersList] = useState([]);
  const [messagesList, setMessagesList] = useState([]);
  const [message, setMessage] = useState("");
  const [isMembersOpen, setIsMembersOpen] = useState(false);
  const hiddenFileInputRef = useRef(null);

  useEffect(() => {
    if (chatId) {
      getUsers(userData.authToken).then((data) => setUsersList(data));
      getChatById(userData.authToken, chatId).then((data) =>
        setMessagesList(data.messages)
      );
      getChatById(userData.authToken, chatId).then((data) =>
        setChatMembers(
          usersList.filter((user) => data.members.includes(user.id))
        )
      );
      const interval = setInterval(() => {
        getChatById(userData.authToken, chatId).then((data) =>
          setMessagesList(data.messages)
        );
      }, INTERVAL_UPDATE);

      return () => {
        clearInterval(interval);
      };
    }
  }, [chatId, usersList]);

  const postMessage = (message) => {
    const data = {
      message: message,
      authorId: userData.user.id,
    };
    addChatMessage(userData.authToken, chatId, data).then((data) =>
      setMessagesList(data.messages)
    );
  };

  const onUploadClick = (e) => {
    if (hiddenFileInputRef.current) {
      hiddenFileInputRef.current.click();
    }
  };
  const onUploadPhoto = (e) => {
    try {
      const uploadedFile = e?.target?.files[0];
      uploadFileToChat(userData.authToken, chatId, uploadedFile);
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
          minHeight: "50vh",
        }}
      >
        <div>Click on chat</div>
      </Box>
    );
  } else {
    return (
      <>
        <AddChatMembersForm
          userData={userData}
          chatId={chatId}
          usersList={chatMembers}
          open={isMembersOpen}
          onClose={() => setIsMembersOpen(false)}
        />
        <Container>
          <AvatarGroup total={chatMembers?.length}>
            {chatMembers.map((user) => (
              <Avatar
                onClick={() => setIsMembersOpen(true)}
                sx={{ cursor: "pointer" }}
                key={user?.id}
              >
                {user?.username[0]}
              </Avatar>
            ))}
          </AvatarGroup>
          <Box
            sx={{
              marginLeft: "auto",
              marginTop: 5,
              position: "relative",
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
                top: "5px",
              }}
            >
              <AttachFileIcon
                fontSize="small"
                sx={{ cursor: "pointer" }}
                onClick={onUploadClick}
              />
              <input
                id="attach"
                type="file"
                accept="image/png, image/jpeg"
                style={{ display: "none" }}
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
      </>
    );
  }
};
