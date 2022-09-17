import React, { useEffect, useState } from 'react';

import SnakeInBoard from './SnakeInBoard';
import Score from './Score';
import Timer from './Timer';
import PopUp from './PopUp';

import "./index.css"

const BOARD_SIZE = 10
const AVAILABLE_MOVIES = ["ArrowDown", "ArrowUp", "ArrowRight", "ArrowLeft"]
const speed = 200;


function App() {

  const [isEndGame, setIsEndGame] = useState(false)
  const [timer, setTimer] = useState(20);
  const [isPauseGame, setIsPauseGame] = useState(false)
  const [isStartGame, setIsStartGame] = useState(false)
  const [direction, setDirection] = useState(AVAILABLE_MOVIES[0])
  const [food, setFood] = useState([5, 7])
  const [prevScore, setPrevScore] = useState(-1);
  const [snake, setSnake] = useState([[1, 1], [1, 2], [1, 3]]);
  const [score, setScore] = useState(0);


  useEffect(() => {
    document.addEventListener("keydown", handlePause);
    return () => {
      document.removeEventListener("keydown", handlePause)
    }
  })  

  function handlePause(event) {
    if (event.code === "Space" && isStartGame) {
      setIsPauseGame(!isPauseGame);
    }
    document.removeEventListener("keydown", handlePause)
  }

  useEffect(() => {
    document.addEventListener("keydown", handleStart);
    return () => {
      document.removeEventListener("keydown", handleStart)
    }
  }, [isStartGame, isEndGame])

  function handleStart(event) {
    
    if (event.key === "Enter") { 
      setIsEndGame(false)
      setIsStartGame(true);
      document.removeEventListener("keydown", handleStart)
    }
  }

  useEffect(() => {

    if (isStartGame && !isPauseGame && !isEndGame) {
      const timerID = setTimeout(() => {
        setTimer(timer - 1);
      }, 1000)
      if (timer === 0) { 
        clearTimeout(timerID)
        gameOver()
      }
      return () => {
        clearTimeout(timerID);
      }
    }
  }, [isStartGame, timer, isPauseGame])

  useEffect(() => {
    if (isStartGame && !isPauseGame) {
      document.addEventListener("keydown", handleKey);
      return () => {
        document.removeEventListener("keydown", handleKey);
      }
    }
  })

  function handleKey(event) {
    const index = AVAILABLE_MOVIES.indexOf(event.key);
    if (index > -1 && direction !== event.key) {
      if (direction === "ArrowDown" && event.key === "ArrowUp") return 0;
      if (direction === "ArrowUp" && event.key === "ArrowDown") return 0;
      if (direction === "ArrowRight" && event.key === "ArrowLeft") return 0;
      if (direction === "ArrowLeft" && event.key === "ArrowRight") return 0;
      setDirection(event.key);
    }
  }

  function generateFood() {
    let newFood = [Math.floor(Math.random() * BOARD_SIZE), Math.floor(Math.random() * BOARD_SIZE)]

    while (snake.some(el => el.toString() === newFood.toString())) {
      newFood = [Math.floor(Math.random() * BOARD_SIZE), Math.floor(Math.random() * BOARD_SIZE)]
    }
    setFood(newFood)

  }

  useEffect(() => {
    if (isStartGame && !isPauseGame && !isEndGame) {

      const interval = gameloop();
      return () => {
        clearTimeout(interval);
      }
    }

  }, [snake, isStartGame, isPauseGame]) 

  function gameloop() {
    const timerID = setTimeout(() => {
      const copySnake = snake;
      let oldHead = snake[snake.length - 1]
      let newHead;

      if (oldHead[0] === BOARD_SIZE || oldHead[0] < 0 || oldHead[1] === BOARD_SIZE || oldHead[1] < 0) {
        gameOver()
        return timerID;
      }

      switch (direction) {
        case "ArrowDown":
          newHead = [oldHead[0], oldHead[1] + 1]
          break;
        case "ArrowUp":
          newHead = [oldHead[0], oldHead[1] - 1]

          break;
        case "ArrowRight":
          newHead = [oldHead[0] + 1, oldHead[1]]
          break;
        case "ArrowLeft":
          newHead = [oldHead[0] - 1, oldHead[1]]
          break;

        default:
          break;
      }

      for (let i = 0; i < snake.length; i++) {
        if (snake[i].toString() === newHead.toString()) {
          gameOver()
          return timerID;
        }
      }

      let sliceIndex = 1;
      if (food[0] === newHead[0] && food[1] === newHead[1]) {
        sliceIndex = 0;
        generateFood()
      }

      copySnake.push(newHead)
      setSnake(copySnake.slice(sliceIndex));

    }, speed)

    return timerID;
  }

  useEffect(() => {
    setScore(snake.length - 3)
  }, [snake])


  function gameOver() {
    setPrevScore(score);
    setSnake([[1, 1], [1, 2], [1, 3]])
    setIsStartGame(false)
    setIsEndGame(false);
    setTimer(20);
    setIsPauseGame(false);
    setDirection("ArrowDown");
    setScore(0)
  }

  return (
    <div>
      <div className='container' >
        <Score score={score} />
        <SnakeInBoard snake={snake} food={food} />
        <Timer timer={timer} />

      </div>
      <PopUp isStartGame={isStartGame} timer={timer} isPauseGame={isPauseGame}  score={prevScore} />


    </div>
  );
}

export default App;
