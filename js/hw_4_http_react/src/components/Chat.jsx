import React from 'react'
import styles from '../styles.module.css'
import {MessageItem} from './MessageItem'

export const Chat = ({userName}) => {
  
  const [message, setMessage] = React.useState('');

  return (
    <div className={styles.chat}>
      <div className={styles.chatHistory}>
              <MessageItem/>
              <MessageItem/>
              <MessageItem/>
      </div>
      <div className={styles.chatInputContainer}>
        <label>
          <input
                value={message}
                className={styles.chatInputField}
                onChange={(e) => setMessage(e.target.value)}
                placeholder='Type smth...'/>
          <button
                    className={styles.chatInputBtn}
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
  )
}
