import React, {useState,useEffect} from 'react'
import './Messager.css';

const Messager = ({userName}) => {
   const [messageHistory,setMessageHistory] = useState([]);
   

   useEffect(() => {
    setInterval(() => {
        fetch("/api/chat")
        .then((res) => res.json())
        .then((data) => setMessageHistory(data))
    },2000);
   },[]);
   

   return (
    <ul className='message-list'>
        {messageHistory.map((member,id) => {
            const className = member.user === userName ? 'message currentMember' : 'message'
            return (
                <li key={id} className={className}>
                   <div className='message-content' >
                      <div className='username'>{member.user}</div>
                      <div className='time'>{member.time}</div>
                      <div className='text'>{member.message}</div>
                      
                   </div>
                </li>
            )
        })}
    </ul>
  )
}

export default Messager