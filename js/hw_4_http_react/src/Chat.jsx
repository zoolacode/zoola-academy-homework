import React, { useRef, useState, useEffect } from "react";
import { getMessages, sendMessage } from "./APIFunctions";
import { getCurrentDate } from "./functions";

const Chat = ({ userName }) => {
  const [messages, setMessages] = useState([]);
  const [message, setMessage] = useState("");
  const entryField = useRef();
  const [update, setUpdate] = useState(true);

  useEffect(() => {
    const interval = setInterval(() => {
      getMessages().then((data) => setMessages(data));
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  }, [update]);

  function postMessage(userName, message) {
    const currentTime = getCurrentDate();
    sendMessage(userName, message, currentTime);
    setMessage("");
    setUpdate(!update);
    entryField.current.value = "";
  }

  function handleEnterPress(e) {
    if (e.code === "Enter") {
      postMessage(userName, message);
    }
  }

  return (
    <div className="chat_body">
      <div className="chat__column">
        {messages.map((item, ind) => (
          <li
            key={ind}
            className={
              item.user === userName
                ? "chat__li current-user"
                : "chat__li another-user"
            }
          >
            <div>
              <p className="user__name">
                {item.user} <span className="message__time">({item.time})</span>
              </p>
              <p className="message">{item.message}</p>
            </div>
          </li>
        ))}
      </div>
      <div>
        <form
          onSubmit={(e) => {
            e.preventDefault();
            setMessage("");
          }}
          className="input__form"
        >
          <input
            placeholder="Enter your message."
            onChange={(e) => setMessage(e.target.value)}
            ref={entryField}
            className="input__form-text"
          />
          <input
            type="submit"
            className="input__form-submit"
            value="Send"
            disabled={!message.trim()}
            onClick={() => {
              postMessage(userName, message);
            }}
          />
        </form>
      </div>
    </div>
  );
};

export default Chat;
