import React, { useContext, useEffect, useState } from "react";
import {
  AppBar,
  Avatar,
  Toolbar,
  Typography,
  Switch,
  Box,
  Stack,
} from "@mui/material";
import { deepOrange } from "@mui/material/colors";
import { Container } from "@mui/system";
import { UserContext } from "./UserContext";
import { Chat } from "./Chat/Chat.tsx";
import { ThemeContext } from "./ThemeContext";
import { LogoutDialog } from "./LogoutDialog";
import { BadgeAvatar } from "./BadgeAvatar";
import { ChatList } from "./ChatList";
import { useHttpClient } from "./serverResponse";
import Brightness4RoundedIcon from "@mui/icons-material/Brightness4Rounded";
import Brightness5RoundedIcon from "@mui/icons-material/Brightness5Rounded";

import { UserCreationButton } from "./userCreationForm/UserCreationButton";
import { CreateChatForm } from "./CreateChatForm";

export const DashBoard = () => {
  const { auth } = useContext(UserContext);
  const { toggleMode, darkMode } = useContext(ThemeContext);

  const [open, setOpen] = useState(false);
  const [chatId, setChatId] = useState(null);
  const fetchJSON = useHttpClient();

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const [chats, setChats] = useState([]);

  function fetchChats() {
    return fetchJSON(`api/users/${auth.user.id}/chats`, {
      method: "GET",
    }).then((chats) => {
      setChats(chats);
      return chats;
    });
  }

  useEffect(() => {
    fetchChats().then((chats) => {
      setChatId(chats[0]?.id);
    });
  }, []);

  return (
    <>
      <Container maxWidth="lg">
        <AppBar position="static" color={auth.isAdmin ? "inherit" : "primary"}>
          <Toolbar sx={{ justifyContent: "space-between" }}>
            <div onClick={handleOpen} style={{ cursor: "pointer" }}>
              <BadgeAvatar>
                <Avatar sx={{ bgcolor: deepOrange[500] }}>
                  {auth?.user.username.charAt(0).toUpperCase()}
                </Avatar>
              </BadgeAvatar>
            </div>
            <Typography
              sx={{ flexGrow: 1, textAlign: "center" }}
              variant="h6"
              color="inherit"
            >
              {`Welcome, ${auth?.user.username}`}
            </Typography>
            <Switch
              color="default"
              onChange={toggleMode}
              checked={darkMode}
              checkedIcon={<Brightness4RoundedIcon fontSize="small" />}
              icon={<Brightness5RoundedIcon fontSize="small" />}
            />
          </Toolbar>
        </AppBar>
        <Stack direction="row" spacing={2}>
          <Box sx={{ mt: 3, width: "45%" }}>
            {auth.isAdmin && <UserCreationButton />}
            <CreateChatForm
              onCreateChat={() => {
                fetchChats().then((chats) => {
                  setChatId(chats[chats.length - 1].id);
                });
              }}
            />
            <ChatList chatId={chatId} setChatId={setChatId} chats={chats} />
          </Box>
          <Chat chatId={chatId} />
        </Stack>
      </Container>
      <LogoutDialog open={open} onClose={handleClose} />
    </>
  );
};
