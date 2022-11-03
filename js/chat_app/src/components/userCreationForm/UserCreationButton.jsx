import React from "react";
import { Button } from "@mui/material";
import { UserCreationForm } from "./UserCreationForm";
import { useState, useContext } from "react";
import "./userCreationForm.css";
import { UserContext } from "../UserContext";

export const UserCreationButton = () => {
  const { auth } = useContext(UserContext);
  const [open, setOpen] = useState(false);

  return (
    <div className="userCreate">
      <Button
        variant="contained"
        onClick={() => setOpen(true)}
        className="userCreateButton"
        disabled={!auth.isAdmin}
      >
        Create User
      </Button>
      <UserCreationForm isOpen={open} setOpen={setOpen} />
    </div>
  );
};
