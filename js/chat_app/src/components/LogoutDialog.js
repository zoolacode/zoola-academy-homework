import { Button, Dialog, DialogActions, DialogContent } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";

export const LogoutDialog = ({ open, onClose }) => {
  const navigate = useNavigate();

  const handleLogOut = () => {
    sessionStorage.removeItem("user-info");
    navigate("/login");
  };

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogContent>
        <DialogActions>
          <Button onClick={handleLogOut} variant="contained" color="error">
            Log out
          </Button>
        </DialogActions>
      </DialogContent>
    </Dialog>
  );
};
