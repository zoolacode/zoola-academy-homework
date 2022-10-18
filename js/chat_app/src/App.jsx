import { useState } from "react";
import { Button } from "@mui/material";
import { NewUserForm } from "./components/NewUserForm/NewUserForm";
import { NewChatForm } from "./components/NewChatForm/NewChatForm";
import { Chats } from "./components/Chats/Chats";

import "./App.css";

function App() {
  const [isCreateUserOpen, setIsCreateUserOpen] = useState(false);
  const [isCreateChatOpen, setIsCreateChatOpen] = useState(false);

  return (
    <div className="App">
      <Button variant="contained" onClick={() => setIsCreateUserOpen(true)}>
        Create user
      </Button>
      <Button variant="outlined" onClick={() => setIsCreateChatOpen(true)}>
        Create new chat
      </Button>
      <NewUserForm
        open={isCreateUserOpen}
        onClose={() => setIsCreateUserOpen(false)}
      />
      <NewChatForm
        open={isCreateChatOpen}
        onClose={() => setIsCreateChatOpen(false)}
      />
      <Chats />
    </div>
  );
}

export default App;
