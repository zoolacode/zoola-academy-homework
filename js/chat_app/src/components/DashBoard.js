import React, { useContext, useState } from "react";
import { AppBar, Avatar, Toolbar, Typography, Switch } from "@mui/material";
import { deepOrange } from "@mui/material/colors";
import { Container } from "@mui/system";
import { UserContext } from "./UserContext";
import { ThemeContext } from "./ThemeContext";
import LogoutDialog from "./LogoutDialog";
import Brightness4RoundedIcon from "@mui/icons-material/Brightness4Rounded";
import Brightness5RoundedIcon from "@mui/icons-material/Brightness5Rounded";

export const DashBoard = () => {
  const { auth } = useContext(UserContext);
  const { toggleMode, checked } = useContext(ThemeContext);

  const [open, setOpen] = useState(false);

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
              <Avatar sx={{ bgcolor: deepOrange[500] }}>
                {auth?.user.username.charAt(0).toUpperCase()}
              </Avatar>
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
              checked={checked}
              checkedIcon={<Brightness4RoundedIcon fontSize="small" />}
              icon={<Brightness5RoundedIcon fontSize="small" />}
            />
          </Toolbar>
        </AppBar>
      </Container>
      <LogoutDialog open={open} onClose={handleClose} />
    </>
  );
};
