import React from "react";
import { Button } from "@mui/material";
import { UserCreationForm } from "./UserCreationForm";
import { useState, useContext } from "react";
import "./userCreationForm.css";
import { UserContext } from "../UserContext";

export const UserCreationButton = () => {
  const { auth } = useContext(UserContext);
  const [styleForm, setStyleForm] = useState(" invisible");

  return (
    <div className="userCreate">
      <Button
        variant="contained"
        onClick={() => setStyleForm(" block")}
        className="userCreateButton"
        disabled={auth.isAdmin ? false : true}
      >
        Create User
      </Button>
      <div
        className={`formMask ${styleForm}`}
        onClick={() => setStyleForm(" invisible")}
      ></div>
      <UserCreationForm styleForm={styleForm} />
    </div>
  );
};
