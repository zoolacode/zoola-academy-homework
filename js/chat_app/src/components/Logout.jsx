import React from "react";
import {
    Dialog,
    DialogContent,
    DialogActions,
    Button
} from "@mui/material";

export const Logout = ({isOpen, onClose, userLogout}) => {

    return (
        <Dialog
            onClose={onClose}
            open={isOpen}
          >
            <DialogContent>
              <DialogActions>
                <Button
                  color="error"
                  variant="contained"
                  onClick={userLogout}
                >
                  Log out
                </Button>
              </DialogActions>
            </DialogContent>
        </Dialog>
    );
};