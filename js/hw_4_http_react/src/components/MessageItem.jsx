import React from 'react'
import styles from '../styles.module.css'


export const MessageItem = ({messageSender, messageText,messageTime }) => {
    return (
      <div className={styles.message}>
          <div className={styles.messageSender}>Daniel</div>
          <p className={styles.messageText}>Hello world! </p>
          <div className={styles.messageTime}>12:44</div>
      </div>
    )
  }
  