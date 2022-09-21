import React from "react";
import "./App.css";

function App() {
  const [draftUserName, setDraftUserName] = React.useState("");
  const [userName, setUserName] = React.useState("");

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

  return <div></div>;
}

export default App;
