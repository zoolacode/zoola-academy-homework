import React from 'react'
import '../styles/Score.css';

const Score = (props) => {
  return (
    <div className='score' >
       <span className='score-value'>{props.score}</span>
    </div>
  )
}


export default Score