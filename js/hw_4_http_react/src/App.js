import React,{useState} from "react";
import "./App.css";
import Messager from "./Components/Messager";

function App() {
  
  const [draftUserName, setDraftUserName] = useState("");
  const [userName, setUserName] = useState("");
  const [message,setMessage] = useState("");

  const handleSubmit = () => {
    if(message.length === 0) {
      return;
    }

    const currentTime = new Date().toLocaleTimeString('en-US',{weekday:'short'});

    fetch("/api/chat", {
        method: 'POST',
        headers: {
          'Content-type':'application/json'
        },
        body: JSON.stringify({
          user: userName,
          message: message,
          time: currentTime
        })
      })
      .then((res) => res.json())
    
    
  
  }
  
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
          <input 
          onChange={(e) => setDraftUserName(e.target.value)} />
        </label>
        
      </form>
    );
  }

  return (
    <>
     <Messager userName={userName} />
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
      setMessage('')
    }}>
      <div className="message-container">
      <input className="message-input" placeholder="Enter message"  onChange={(e) => setMessage(e.target.value)} value={message} />
      <button className="message-send" onClick={handleSubmit}>Send</button>
      </div>
      
         
     </form>
  </>
  );
}

export default App;