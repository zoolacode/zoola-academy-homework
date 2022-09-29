import React, { useState, useEffect } from "react";
import "./App.css";
import { getData, updateData } from './comunication/comunication';
import { v4 as uuidv4 } from 'uuid';

const user = {
  userID: undefined,
  userName: undefined,
  regTime: undefined,
}

function App() {
  const [draftUserName, setDraftUserName] = useState("");
  const [userData, setUser] = useState(user);
  const [message,setMessage] = useState("");

  useEffect(() => {
    console.log(draftUserName)
  },[draftUserName])


  const handleSubmit = () => {
    if(message.length === 0) {
      return;
    }

    const currentTime = new Date().toLocaleTimeString('en-US',{weekday:'short'});

    updateData({
      userName: userData.userName,
      userID: userData.userID,
      message: message,
      publishTime: currentTime
    })
  }

  if (userData.userID === undefined) {
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
          setUser({ 
            ...userData,
            userID: uuidv4(),
            userName: draftUserName,
            regTime: new Date().toLocaleTimeString('en-US',{weekday:'short'}),
          })
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

  return <div className="chat-body">
    <ChatInterface messageData = {userData}/>
    <form 
      style={{
        position: "sticky",
        height: "50px",
        width: "60%",
        minWidth: "500px",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        bottom: "5px",
        left: "10px",
        right: "10px",
        backgroundColor: "rgba(0, 42, 194, 0.1)",
        alignSelf: "flex-end",
        marginTop: "5px",
        borderRadius: "10px",
      }}

      onSubmit={(e) => {
       e.preventDefault();
       setMessage(e.target.value)
       setMessage('')
     }}>
       <div className="message-container">
        <input className="message-input" placeholder="Enter message"  onChange={(e) => setMessage(e.target.value)} value={message} />
        <button className="message-send" onClick={handleSubmit}>Send</button>
       </div>


      </form>
  </div>;
}

function ChatInterface({messageData}) {
  const [chat, setChat] = useState([])

  useEffect(() => {
      setInterval(() => {
          fetch("/api/chat")
          .then((response) => response.json())
          .then((response) => setChat(response))
      },1000);    
  },[])

  return (
      <>
          {chat.map((user,id) => {
           const className = user.userName === messageData.userName ? 'message message-right' : 'message message-left'
           return (
               <div key={id} className={className}>
                  <div className='message-content' >
                     <div className='message-content-username'>[{user.userName}] </div>
                     <div className='message-content-time'>{user.publishTime}</div>
                     <div className='message-content-text'>{user.message}</div>
                  </div>
               </div>
           )
       })}
      </>
  )
}

export default App;
