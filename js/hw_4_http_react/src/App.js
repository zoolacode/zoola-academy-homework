import React, { useState } from "react";
import "./App.css";
import Chat from "./Chat";

function App() {
  const [draftUserName, setDraftUserName] = useState("");
  const [userName, setUserName] = useState("");

  if (!userName) {
    return (
      <form
        style={{
          position: "fixed",
          height: "100vh",
          width: "100vw",
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
        }}
        onSubmit={(e) => {
          e.preventDefault();
          setUserName(draftUserName);
          setDraftUserName("");
        }}
      >
        <label>
          Enter your username:{" "}
          <input onChange={(e) => setDraftUserName(e.target.value)} />
        </label>
      </form>
    );
  }

  return (
    <div>
      <Chat userName={userName} />
    </div>
  );
}

export default App;
