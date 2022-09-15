import React from 'react'

import '../styles/Timer.css';

function timeFormat(time) {
    return time < 10 ? '0' + time : time;
}

const Timer = (props) => {
  const minutes = Math.floor(props.timer/(1000 * 60));
  const sec = Math.floor((props.timer/ 1000) % 60);
  
  
  return (
    <>
    <div className='timer'>
       <span className='timer-display'>{`${timeFormat(minutes)} : ${timeFormat(sec)}`}</span>
    </div>
    </>
  )
}


export default Timer