import React from "react";
import { Button } from "@mui/material";
import { UserCreationForm } from "./UserCreationForm";
import { useState } from "react";
import "./user_create_form.css";

export const UserCreationButton = () => {
  const [styleForm, setStyleForm] = useState(" invisible");
  return (
    <div className="userCreate">
      <Button
        variant="contained"
        onClick={() => setStyleForm(" block")}
        className="userCreateButton"
      >
        Create User
      </Button>
      <div
        className={"formMask" + styleForm}
        onClick={() => setStyleForm(" invisible")}
      ></div>
      <UserCreationForm styleForm={styleForm} />
    </div>
  );
};
