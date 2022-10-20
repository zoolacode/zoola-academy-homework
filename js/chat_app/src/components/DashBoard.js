import React, { useContext } from "react";
import { AppBar, Avatar, Toolbar, Typography, Switch } from "@mui/material";
import { deepOrange } from "@mui/material/colors";
import { Container } from "@mui/system";
import { UserContext } from "./UserContext";

const DashBoard = () => {
  const { auth } = useContext(UserContext);

  return (
    <Container maxWidth="lg">
      <AppBar position="static" color="inherit">
        <Toolbar sx={{ justifyContent: "space-between" }}>
          <Avatar sx={{ bgcolor: deepOrange[500] }}>
            {auth?.user.username.charAt(0)}
          </Avatar>
          <Typography
            sx={{ flexGrow: 1, textAlign: "center" }}
            variant="h6"
            color="inherit"
          >
            {"Welcome, " + auth?.user.username}
          </Typography>
          <Switch color="default" />
        </Toolbar>
      </AppBar>
    </Container>
  );
};

export default DashBoard;
