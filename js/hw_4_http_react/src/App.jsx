import React from "react";
import "./App.css";
//components
import Chat from "./components/Chat";

function App() {
  const [draftUserName, setDraftUserName] = React.useState("");
  const [userName, setUserName] = React.useState("");


  if (!userName) {
    return (
      <form
        className="form"
        onSubmit={(e) => {
          e.preventDefault();
          setUserName(draftUserName);
          setDraftUserName("");
        }}
      >
        <label>
          Enter your username:{" "}
          <input placeholder="user" onChange={(e) => setDraftUserName(e.target.value)} />
        </label>
      </form>
    );
  }


  return <Chat userName={userName} />;
}

export default App;
