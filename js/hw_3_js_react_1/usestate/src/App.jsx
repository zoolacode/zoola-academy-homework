import { useState, useEffect } from 'react';
import './App.css';
import {
  getIndex,
  getRandomDishPosition,
  getSpeedUpCondition,
  getHasEatenDish,
  getHasEatenBonusDish,
  getNextScore,
  timerLimitMs,
  getNextSnakeHead,
  getSnakeHitBorders,
  getNewSnakeCoords,
} from './utils';
import { initialSnakeCoords, bonusDishLifeTime } from './game_constants';

import { GameScore } from './components/GameScore/GameScore';
import { Board } from './components/Board/Board';
import { GameTimer } from './components/GameTimer/GameTimer';
import { BonusDishTimer } from './components/BonusDishTimer/BonusDishTimer';

export function App() {
  const [snakeHead, setSnakeHead] = useState({
    x: 10,
    y: 14,
  });
  const [currentScore, setCurrentScore] = useState(0);
  const [gameTimer, setGameTimer] = useState(0);
  const [direction, setDirection] = useState('moveDown');
  const [gameLost, setGameLost] = useState(false);
  const [gameOn, setGameOn] = useState(true);
  const [snakeCoords, setSnakeCoords] = useState(initialSnakeCoords);
  const [dish, setDish] = useState(
    getRandomDishPosition(initialSnakeCoords, null, null)
  );
  const [bonusDish, setBonusDish] = useState(null);
  const [speedUp, setSpeedUp] = useState(false);

  useEffect(() => {
    if (!gameOn) {
      return;
    }

    const nextSnakeHead = getNextSnakeHead(snakeHead, direction);
    const isSnakeHitBorders = getSnakeHitBorders(nextSnakeHead);
    const isSnakeHitBody = snakeCoords.includes(
      getIndex(nextSnakeHead.x, nextSnakeHead.y)
    );
    const snakeLength = snakeCoords.length;
    const snakeHeadCoordinates = [...snakeCoords][snakeLength - 1];
    const hasEatenDish = getHasEatenDish(snakeHeadCoordinates, dish);
    const hasEatenBonusDish = getHasEatenBonusDish(
      snakeHeadCoordinates,
      bonusDish
    );
    const newData = getNewSnakeCoords(
      hasEatenDish,
      hasEatenBonusDish,
      snakeCoords
    );
    const nextScore = getNextScore(
      currentScore,
      hasEatenDish,
      hasEatenBonusDish
    );

    if (isSnakeHitBody || isSnakeHitBorders || gameTimer === timerLimitMs) {
      window.addEventListener('keydown', restart);

      endGame();

      return () => {
        window.removeEventListener('keydown', restart);
      };
    }

    if (hasEatenDish) {
      setDish(getRandomDishPosition(snakeCoords, dish, bonusDish));
    }

    if (hasEatenBonusDish) {
      setBonusDish(null);
    }

    if (gameTimer % bonusDishLifeTime === 0 && gameTimer !== 0) {
      const nextBonusDish = getRandomDishPosition(snakeCoords, dish, bonusDish);
      setBonusDish(nextBonusDish);
    }

    updateSnake(nextSnakeHead, newData);
    updateScore(nextScore);

    if (speedUp) {
      const timeoutId = setTimeout(() => {
        setGameTimer((prevState) => prevState + 100);
      }, 50);

      return () => {
        clearTimeout(timeoutId);
      };
    } else {
      const timeoutId = setTimeout(() => {
        setGameTimer((prevState) => prevState + 100);
      }, 100);

      return () => {
        clearTimeout(timeoutId);
      };
    }
  }, [gameTimer, gameOn]);

  useEffect(() => {
    window.addEventListener('keydown', moveSnake);

    return () => {
      window.removeEventListener('keydown', moveSnake);
    };
  }, [gameTimer, gameOn]);

  function moveSnake(event) {
    switch (event.code) {
      case 'ArrowRight':
        addMovement({
          targetDirection: 'moveRight',
          oppositeDirection: 'moveLeft',
        });
        break;
      case 'ArrowLeft':
        addMovement({
          targetDirection: 'moveLeft',
          oppositeDirection: 'moveRight',
        });
        break;
      case 'ArrowDown':
        addMovement({
          targetDirection: 'moveDown',
          oppositeDirection: 'moveUp',
        });
        break;
      case 'ArrowUp':
        addMovement({
          targetDirection: 'moveUp',
          oppositeDirection: 'moveDown',
        });
        break;
      case 'Space':
        setGameOn(!gameOn);
        break;
      default:
        break;
    }
  }

  function addMovement({ ...inputDirection }) {
    const speedUpCondition = getSpeedUpCondition(
      direction,
      inputDirection.targetDirection
    );

    if (direction !== inputDirection.oppositeDirection) {
      setDirection(inputDirection.targetDirection);
      setSpeedUp(speedUpCondition ? true : false);
    }
  }

  function restart(event) {
    if (event.code === 'Enter') {
      restartGame();
    }
  }

  function updateSnake(newSnakeHead, newSnakeBody) {
    setSnakeHead(newSnakeHead);
    setSnakeCoords([...newSnakeBody, getIndex(newSnakeHead.x, newSnakeHead.y)]);
  }

  function updateScore(newScore) {
    setCurrentScore(newScore);
  }

  function endGame() {
    setGameLost(true);
    setDish(null);
    setBonusDish(null);
  }

  function restartGame() {
    setSnakeHead({ x: 10, y: 14 });
    setCurrentScore(0);
    setGameTimer(0);
    setDirection('moveDown');
    setGameLost(false);
    setGameOn(true);
    setSnakeCoords(initialSnakeCoords);
    setDish(getRandomDishPosition(initialSnakeCoords, null, null));
    setBonusDish(null);
    setSpeedUp(false);
  }

  return (
    <div className={`${gameOn ? 'App' : 'App pause'}`}>
      <GameScore currentScore={currentScore} />
      <Board
        snakeCoords={snakeCoords}
        dish={dish}
        bonusDish={bonusDish}
        gameLost={gameLost}
        speedUp={speedUp}
      />
      <div className='game-timer-container'>
        <GameTimer gameTimer={gameTimer} />
        {bonusDish && <BonusDishTimer gameTimer={gameTimer} />}
      </div>
      {gameLost && (
        <div className='alert'>
          'Game has ended. Press "Enter" to start again'
        </div>
      )}
    </div>
  );
}
