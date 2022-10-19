import React from "react";
import { Button } from "@mui/material";
import { UserCreationForm } from "./UserCreationForm";
import { useState } from "react";
import "./user_create_form.css";

export const UserCreationButton = () => {
  const [trigger, setTrigger] = useState(false);
  return (
    <div className="userCreate">
      <Button
        variant="contained"
        onClick={() => setTrigger(!trigger)}
        className="userCreate__button"
      >
        Create User
      </Button>
      <div
        className="form__mask"
        style={trigger ? { display: "block" } : { display: "none" }}
        onClick={() => setTrigger(!trigger)}
      ></div>
      <UserCreationForm trigger={trigger} />
    </div>
  );
};
