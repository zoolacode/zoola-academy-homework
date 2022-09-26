import React, { useState } from 'react';
import s from './App.module.css';
import Chat from './components/Chat';
import { addNewUser } from './services/apiServices';

function App() {
  const [draftUserName, setDraftUserName] = useState('');
  const [userName, setUserName] = useState('');
  const [userMessage, setUserMessage] = useState('');

  const handlerSubmitName = e => {
    e.preventDefault();
    setUserName(draftUserName);
    setDraftUserName('');
  };
  const handlerSubmitMessage = e => {
    e.preventDefault();
    setUserMessage('');
  };
  const onChangeName = e => {
    setDraftUserName(e.target.value);
  };
  const onChangeMessage = e => {
    setUserMessage(e.target.value);
  };
  return (
    <>
      {!userName ? (
        <form className={s.form} onSubmit={handlerSubmitName}>
          <label>
            Enter your username: <input onChange={onChangeName} />
          </label>
        </form>
      ) : (
        <>
          <Chat userName={userName} />
          <form className={s.form} onSubmit={handlerSubmitMessage}>
            <div className={s.chatContainer}>
              <input
                className={s.messageInput}
                placeholder="Enter message"
                onChange={onChangeMessage}
                value={userMessage}
              />
              <button
                className={s.messageSend}
                onClick={() => addNewUser(userName, userMessage)}
              >
                Send
              </button>
            </div>
          </form>
        </>
      )}
    </>
  );
}

export default App;
