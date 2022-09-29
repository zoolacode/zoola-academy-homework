import React from 'react'
import { useEffect,useState } from 'react'
import styles from '../styles.module.css'
import {MessageItem} from './MessageItem'
import {getChatHistory, sendMessage} from '../utils/api.js'

export const Chat = ({userName}) => {
  const [chatHistory, setChatHistory]=useState([])
  const [messageData, setMessageData]=useState(
    {user:userName,
      message:'',
      date:''}
  )

  useEffect(() => {
    setInterval(() => getChatHistory().then(data => setChatHistory(data)),2000);
  }, []);
  
  return (
    <div className={styles.chat}>
      <div className={styles.chatHistory}>
      {chatHistory.map((data, index)=><MessageItem 
        messageSender={data.user} 
        messageText={data.message} 
        messageTime={data.date} key={index}
        isMyMessage={data.user===userName}
      />)}
      </div>
      <div className={styles.chatInputContainer}>
        <label>
          <input
                value={messageData.message}
                className={styles.chatInputField}
                onChange={(e) => setMessageData({...messageData, message:e.target.value})}
                placeholder='Type smth...'/>
          <button
                    autoFocus
                    disabled={!messageData.message.trim()}
                    type='submit'
                    className={styles.chatInputBtn}
                    onClick={() => {
                      sendMessage(messageData); setMessageData({...messageData, message:""})
                    }}
                  >
                    Send
          </button>
        </label>
      </div>
    </div>
  )
}
