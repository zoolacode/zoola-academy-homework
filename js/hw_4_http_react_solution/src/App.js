import React from "react";
import "./App.css";

function fetchChatHistory() {
  return fetch("/api/chat", {
    method: "get",
    headers: {
      "content-type": "application/json",
    },
  }).then((response) => response.json());
}

function addChatMessage(userName, message) {
  return fetch("/api/chat", {
    method: "post",
    body: JSON.stringify({ user: userName, message }),
    headers: {
      "content-type": "application/json",
    },
  }).then((response) => response.json());
}

function App() {
  const [value, setValue] = React.useState("");

  const [scoreBoard, setScoreboard] = React.useState([]);

  React.useEffect(() => {
    fetchChatHistory().then(setScoreboard);

    const id = setInterval(() => {
      fetchChatHistory().then(setScoreboard);
    }, 1000);
    return () => {
      clearInterval(id);
    };
  }, []);

  const saveAndReload = () => {
    setValue("");
    addChatMessage(userName, value);
  };

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

  return (
    <div className="App">
      <div style={{ textAlign: "left", paddingLeft: "20vw" }}>
        {scoreBoard.map(({ user, message }, index) => {
          return (
            <div key={index}>
              <span style={{ color: "gray" }}>[{user}]:</span>{" "}
              <span>{message}</span>
            </div>
          );
        })}
      </div>
      <form
        onSubmit={(e) => {
          e.preventDefault();
          saveAndReload();
        }}
      >
        <input value={value} onChange={(e) => setValue(e.target.value)} />
        <input type="submit" />
      </form>
    </div>
  );
}

export default App;
