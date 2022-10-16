import React from "react";
import { Button } from "@mui/material";
import User_creation_form from "./User_creation_form";
import { useState } from "react";
import "./user_create_form.css";

const UserCreationButton = () => {
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
      <User_creation_form trigger={trigger} />
    </div>
  );
};

export default UserCreationButton;
