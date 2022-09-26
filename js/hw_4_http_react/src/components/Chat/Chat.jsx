import { useState, useEffect, useRef } from 'react';
import s from './Chat.module.css';

const Chat = ({ userName }) => {
  const [chatHistory, setChatHistory] = useState([]);
  const scrollRef = useRef(null);

  useEffect(() => {
    scrollRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [chatHistory.length]);

  useEffect(() => {
    setInterval(() => {
      fetch('/api/chat')
        .then(res => res.json())
        .then(data => setChatHistory(data));
    }, 2000);
  }, []);

  return (
    <div>
      <ul className={s.chatList}>
        {chatHistory.map((item, id) => {
          return (
            <li
              key={id}
              className={`${
                item.user === userName ? s.chatCurrentMember : s.chat
              }`}
            >
              <div className={s.chatContent}>
                <div className={s.username}>{item.user}</div>
                <div className={s.date}>{item.date}</div>
                <div className={s.text}>{item.message}</div>
              </div>
            </li>
          );
        })}
      </ul>
      <div ref={scrollRef} />
    </div>
  );
};

export default Chat;
