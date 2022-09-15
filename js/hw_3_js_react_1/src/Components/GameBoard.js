import React, {useEffect,useState} from 'react'
import "../styles/GameBoard.css";
import Timer from './Timer';
import Score from './Score';

const initialTimer = 120000;


const GameBoard = () => {
  const [score,setScore] = useState(0);
  const [timer,setTimer] = useState(initialTimer);






  return (
    <div className='grid'>
     <Timer timer={timer} />
     <Score score={score} />
    </div>
  )
}

export default GameBoard