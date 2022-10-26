import React, { useEffect, useState, useRef } from 'react';
import './App.css';
import classNames from 'classnames';
import { getData, submitMessage } from './api/api';
import { getCurrentDate, formatUserName } from './utils';

import { UserNameForm } from './UserNameForm/UserNameForm';

function App() {
  const [draftUserName, setDraftUserName] = useState('');
  const [userName, setUserName] = useState('');
  const [chatHistory, setChatHistory] = useState([]);
  const [message, setMessage] = useState('');
  const bottomRef = useRef(null);

  useEffect(() => {
    getDataIteratively();
  }, []);

  useEffect(() => {
    bottomRef.current?.scrollIntoView({ behavior: 'smooth' });
  }, [chatHistory.length]);

  function getDataIteratively() {
    setInterval(() => {
      getData().then((data) => setChatHistory(data));
    }, 2000);
  }

  function submitUsername(e) {
    e.preventDefault();
    setUserName(formatUserName(draftUserName));
    setDraftUserName('');
  }

  function postMessage(name, message) {
    const currentTime = getCurrentDate();
    submitMessage(name, message, currentTime);
    setMessage('');
  }

  function handleKeypress(e) {
    if (e.code === 'Enter') {
      postMessage(userName, message);
    }
  }

  if (!userName) {
    return (
      <UserNameForm
        submitUsername={submitUsername}
        setDraftUserName={setDraftUserName}
      />
    );
  }

  return (
    <div className='chat-wrapper'>
      <div className='chat'>
        <ul className='chat__list'>
          {chatHistory.map((item, index) => (
            <li
              key={index}
              className={classNames('chat__item', {
                'current-item': item.user === userName,
              })}
            >
              <div
                className={classNames('chat__info-wrapper', {
                  'current-user': item.user === userName,
                })}
              >
                <p className='chat__user-name'>
                  {item.user} ({item.time})
                </p>
                <p className='chat__message'>{item.message}</p>
              </div>
            </li>
          ))}
        </ul>
        <div ref={bottomRef} />
      </div>
      <div className='chat__input'>
        <label>
          <input
            className='chat__input-message'
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            onKeyPress={(e) => handleKeypress(e)}
            placeholder='Type a message...'
          />
          <button
            className='chat__input-button'
            type='submit'
            disabled={!message.trim()}
            autoFocus
            onClick={() => {
              postMessage(userName, message);
            }}
          >
            Send message
          </button>
        </label>
      </div>
    </div>
  );
}

export default App;
