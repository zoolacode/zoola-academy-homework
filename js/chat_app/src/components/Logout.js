import { Button, Dialog, DialogActions, DialogContent } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";

const Logout = ({ open, onClose }) => {
  const navigate = useNavigate();

  const handleLogOut = () => {
    sessionStorage.removeItem("user-info");
    navigate("/login", { replace: true });
  };

  return (
    <Dialog open={open} onClose={onClose}>
      <DialogContent>
        <DialogActions>
          <Button
            onClick={handleLogOut}
            sx={{ m: 2 }}
            variant="contained"
            color="error"
          >
            Log out
          </Button>
        </DialogActions>
      </DialogContent>
    </Dialog>
  );
};

export default Logout;
