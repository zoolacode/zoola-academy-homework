import { useEffect, useState } from "react";
import "./Chat.css";

export const Chat = ({ userMessage, userName }) => {
  const [userMessageArr, setUserMessageArr] = useState([]);

  useEffect(() => {
    const interval = setInterval(() => {
      fetch("/api/chat")
        .then((response) => response.json())
        .then((data) => setUserMessageArr(data));
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  }, [userMessage]);

  return (
    <div className="userMessage">
      {userMessageArr.map((user, i) => {
        if (userName === user.user) {
          return (
            <div key={i} className="mainUser">
              <div className="userMessage">{user.message}</div>
              <div className="userName">{user.user}</div>
              <div className="userTime">({user.time})</div>
            </div>
          );
        }
        return (
          <div key={i} className="user">
            <div className="userName">{user.user}</div>
            <div className="userTime">({user.time})</div>
            <div className="userMessage">{user.message}</div>
          </div>
        );
      })}
    </div>
  );
};
