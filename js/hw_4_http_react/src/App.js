import React from "react";
import "./App.css";
import { Chat } from "./components/Chat";
import styles from './styles.module.css'

function App() {
  const [draftUserName, setDraftUserName] = React.useState("");
  const [userName, setUserName] = React.useState("");
  
  const submitName = (e)=>{
    e.preventDefault();
    setUserName(draftUserName);
    setDraftUserName("");
  }

  return (
    <div className={styles.screen}>
      {!userName ? (
        <form
        className={styles.form}
        onSubmit={submitName}>
        <label className={styles.loginLabel}>
          Enter your username:{" "}
          <input style={{borderRadius:'5px', padding:'5px'}} onChange={(e) => setDraftUserName(e.target.value)} />
          <p className={styles.loginLabel}>You will be logged in as: {draftUserName && <span>{draftUserName}</span>}</p>
        </label>
      </form>) :
       <Chat userName={userName}/>}
    </div>
  );
}

export default App;