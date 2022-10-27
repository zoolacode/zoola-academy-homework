import React from 'react'
import styles from '../styles.module.css'


export const MessageItem = ({messageSender, messageText,messageTime, isMyMessage}) => {
    return (
      <div 
        className={isMyMessage ? styles.myMessage : styles.message }
      >
          <div className={styles.messageSender}>{messageSender}</div>
          <p className={styles.messageText}>{messageText}</p>
          <div className={styles.messageTime}>{messageTime}</div>
      </div>
    )
  }
  