import { useState } from "react";

import { Button } from "@mui/material";
import { NewChatForm } from "../NewChatForm/NewChatForm";
import { NewUserForm } from "../NewUserForm/NewUserForm";

import "./CreateButtons.css";

export const CreateButtons = ({ userData }) => {
  const [isCreateUserOpen, setIsCreateUserOpen] = useState(false);
  const [isCreateChatOpen, setIsCreateChatOpen] = useState(false);

  return (
    <div className="container">
      {userData.authToken && (
        <>
          <div className="Buttons">
            {userData.isAdmin && (
              <Button
                variant="contained"
                onClick={() => setIsCreateUserOpen(true)}
              >
                Create user
              </Button>
            )}
            <Button
              variant="outlined"
              onClick={() => setIsCreateChatOpen(true)}
            >
              Create new chat
            </Button>
          </div>

          <NewUserForm
            userInfo={userData}
            open={isCreateUserOpen}
            onClose={() => setIsCreateUserOpen(false)}
          />
          <NewChatForm
            userInfo={userData}
            open={isCreateChatOpen}
            onClose={() => setIsCreateChatOpen(false)}
          />
        </>
      )}
    </div>
  );
};
