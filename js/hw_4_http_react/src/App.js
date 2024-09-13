import React, { useState } from "react";
import "./App.css";
import { Chat } from "./components/Chat/Chat";

function App() {
  const [draftUserName, setDraftUserName] = useState("");
  const [userName, setUserName] = useState("");
  const [userMessage, setUserMessage] = useState("");

  const submitHandler = async () => {
    if (userName.length === 0 || userMessage.length === 0) {
      return;
    }

    const today = new Date();
    const data = {
      user: userName,
      message: userMessage,
      time: today.toLocaleTimeString("en-US"),
    };

    await fetch("/api/chat", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .catch((error) => {
        console.error("Error:", error);
      });
  };

  if (!userName) {
    return (
      <div className="container">
        <form
          className="formName"
          onSubmit={(e) => {
            e.preventDefault();
            setUserName(draftUserName);
            setDraftUserName("");
          }}
        >
          <label>
            Enter your username:{" "}
            <input
              value={draftUserName}
              onChange={(e) => setDraftUserName(e.target.value)}
            />
          </label>
        </form>
      </div>
    );
  }

  return (
    <div className="container">
      <div className="container__message">
        <Chat userMessage={userMessage} userName={userName} />
      </div>
      <form
        className="formMessage"
        onSubmit={(e) => {
          e.preventDefault();
          setUserMessage("");
        }}
      >
        <input
          value={userMessage}
          onChange={(e) => setUserMessage(e.target.value)}
        />
        <button onClick={submitHandler}>send</button>
      </form>
    </div>
  );
}

export default App;
