import React, { useContext, useEffect, useState } from "react";
import { AppBar, Avatar, Toolbar, Typography, Switch } from "@mui/material";
import { deepOrange } from "@mui/material/colors";
import { Container } from "@mui/system";
import { UserContext } from "./UserContext";
import { ThemeContext } from "./ThemeContext";
import { LogoutDialog } from "./LogoutDialog";
import { BadgeAvatar } from "./BadgeAvatar";
import { ChatList } from "./ChatList";
import { getServerResponse } from "./getServerResponse";
import Brightness4RoundedIcon from "@mui/icons-material/Brightness4Rounded";
import Brightness5RoundedIcon from "@mui/icons-material/Brightness5Rounded";

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

  useEffect(() => {
    const url = `api/users/${auth?.user.id}/chats`;
    const token = auth?.authToken;

    getServerResponse(url, { "auth-token": token }).then((response) =>
      setChatID(response[0]?.id)
    );
  }, []);

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
      </Container>
      <LogoutDialog open={open} onClose={handleClose} />
      <ChatList chatId={chatId} setChatID={setChatID} />
    </>
  );
};
