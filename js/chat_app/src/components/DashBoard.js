import React, { useContext, useState } from "react";
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
import Brightness4RoundedIcon from "@mui/icons-material/Brightness4Rounded";
import Brightness5RoundedIcon from "@mui/icons-material/Brightness5Rounded";

import { UserCreationButton } from "./userCreationForm/UserCreationButton";
import { CreateChatForm } from "./CreateChatForm";

export const DashBoard = () => {
  const { auth } = useContext(UserContext);
  const { toggleMode, darkMode } = useContext(ThemeContext);

  const [open, setOpen] = useState(false);
  const [chatId, setChatID] = useState(null);

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <>
      <Container maxWidth="lg">
        <AppBar position="static" color="inherit">
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
            <CreateChatForm />
            <ChatList chatId={chatId} setChatID={setChatID} />
          </Box>
          <Chat chatId={chatId} />
        </Stack>
      </Container>
      <LogoutDialog open={open} onClose={handleClose} />
    </>
  );
};
