import React, {useEffect,useState} from 'react'
import "../styles/GameBoard.css";
import Timer from './Timer';
import Score from './Score';
import { initialTimer,Up,Down,Left,Right,Space,initialSnake,extraFoodTime,board} from '../constants';
import { getClassName,
    generateExtraFood,
    generateFood,
    getIsCollapsed,
    getIsExtraFoodEaten,
    getIsFoodEaten,
    getIsHitBorder,
    getSnakeBodyExtraTail,
    growSnake } from '../utils';


const GameBoard = () => {
  const [score,setScore] = useState(0);
  const [timer,setTimer] = useState(initialTimer);
  const [gameLost,setGameLost] = useState(false);
  const [food,setFood] = useState(generateFood(initialSnake,[]));
  const [pause,setPause] = useState(false);
  const [direction,setDirection] = useState('Up');
  const [snake,setSnake] = useState(initialSnake);
  const [extraFood,setExtraFood] = useState(undefined);

  useEffect(() => { 
    document.addEventListener('keydown',handlePressKey);
    return () => {
     document.removeEventListener('keydown',handlePressKey)
    }
  

  })

// WORKS 
useEffect(() => {
  if(pause){
    return;
  }
    
    const prevSnakeBody = [...snake];


    let head = [...snake[0]];
   
 
    let prevSnakeHead = prevSnakeBody[0]; 

  
  switch(direction) {
      case "Left":
          head = [prevSnakeHead[0] - 1,prevSnakeHead[1]]
          break;
      case "Right":
          head = [prevSnakeHead[0] + 1,prevSnakeHead[1]]
          break;
      case "Up":
          head = [prevSnakeHead[0], prevSnakeHead[1] - 1] 
          break;
      case "Down":
          head = [prevSnakeHead[0],prevSnakeHead[1] + 1]
          break;
      default:
          break;          
  }

  const isSnakeCollapsed = getIsCollapsed(prevSnakeBody,head);

  const isGameLost = getIsHitBorder(head);

  const snakeBodyExtraTail = getSnakeBodyExtraTail(isGameLost,prevSnakeHead,head,prevSnakeBody);

  
  const isFoodEaten = getIsFoodEaten(head,food);

  const isExtraEaten = getIsExtraFoodEaten(head,extraFood);

  const finalEaten = isFoodEaten || isExtraEaten;

  const newSnake = growSnake(finalEaten,prevSnakeBody,head,snakeBodyExtraTail)

  

  if(isGameLost || isSnakeCollapsed || timer === 0){
      document.addEventListener('keydown', restartGame);
      setGameLost(true);
      
      return () => {
        document.removeEventListener('keydown',restartGame);
      }
    }

    

  if(isFoodEaten){
      setFood(generateFood(snake,food));
      setScore((prevScore) => prevScore + 1);
   }

   if(isExtraEaten) {
    setExtraFood(undefined);
    setScore((prevScore) => prevScore + 1);
   }

   if(timer % extraFoodTime === 0 && timer !== initialTimer && timer !== 0){
      setExtraFood(generateExtraFood(snake,food,extraFood));
   }

   
    setSnake(newSnake);
 
    const timeoutId = setTimeout(() => {
      setTimer((prevState) => prevState - 100)
    },100);
 
    return () => {
     clearTimeout(timeoutId);
    }
  
 
},[timer,pause])

function restartGame(e){
  if(e.code === 'Enter'){
    startNewGame();
  }
}

function startNewGame(){
  setSnake(initialSnake);
  setDirection('Up');
  setFood(generateFood(initialSnake,[]));
  setScore(0);
  setTimer(initialTimer);
  setGameLost(false);
  setPause(false);
  setExtraFood(undefined);




}



function handlePressKey(e) {
   if(e.keyCode === Up && direction !== 'Down'){
    setDirection('Up');
   } else if (e.keyCode === Left && direction !== 'Right'){
    setDirection('Left');
   } else if (e.keyCode === Down && direction !== 'Up'){
    setDirection('Down');
   } else if (e.keyCode === Right && direction !== 'Left'){
    setDirection('Right')
   }
   if(e.keyCode === Space && !gameLost){
    setPause(!pause);
   }
}



  return (
    <div className={`${pause ? 'grid pause-game' : 'grid'}`}>
    {gameLost && (
      <div className='alert'>Game over.Press 'Enter' to restart</div>
    )}
     <Timer timer={timer} />
     { board.map((row,rowId) => (
           <div key={rowId} className='cell'>{
            row.map((_,cellId) => {
              const className = getClassName(
                rowId,
                cellId,
                snake,
                food,
                extraFood
              );
              return (
                <div key={cellId} className={className}></div>
              );
             })
           }
              
          </div>
        )) }

     <Score score={score} />
    </div>
  );
};

export default GameBoard