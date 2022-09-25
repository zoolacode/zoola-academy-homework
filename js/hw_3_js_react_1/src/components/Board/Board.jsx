import React, { useState, useEffect } from "react";

import { getCellStyle } from "../../function/Helpers/getCellStyle";
import { generateNewFood } from "../../function/Food/generateNewFood";
import { growSnake } from "../../function/Snake/growSnake";
import { snakeBodyWithTail } from "../../function/Snake/snakeBodyWithTail";
import {
  getIsSnakeHeadOutsideBoard,
  getIsSnakeHeadOnBody,
  getIsTimeOut,
} from "../../function/GameOver/gameOver";
import { getHasEatenFood } from "../../function/Snake/getHasEatenFood";
import { GameTimer } from "../GameTimer/GameTimer";
import { GameScore } from "../GameScore/GameScore";
import {
  boardWidth,
  board,
  initialSnakeBody,
  initialFood,
  initialTime,
  speed,
} from "../../constats";

import "./Board.css";

const Board = () => {
  const [snake, setSnake] = useState([initialSnakeBody]);
  const [food, setFood] = useState(initialFood);
  const [direction, setDirection] = useState("");
  const [gameOver, setGameOver] = useState(false);
  const [score, setScore] = useState(0);
  const [time, setTime] = useState(initialTime);
  const [start, setStart] = useState(false);
  const [pause, setPause] = useState(false);

  useEffect(() => {
    if (gameOver) {
      return;
    }
    document.addEventListener("keydown", changeDirection);
    return () => document.removeEventListener("keydown", changeDirection);
  });

  useEffect(() => {
    if (gameOver) {
      setStart(false);
    }
    if (start && !pause) {
      const intervalId = setInterval(() => {
        setTime((prevTime) => prevTime - 1);
      }, 1000);
      return () => clearInterval(intervalId);
    }
  }, [start, time, gameOver, pause]);

  useEffect(() => {
    if (gameOver) {
      return;
    }
    if (start && !gameOver && !pause) {
      const intervalId = setInterval(() => {
        snakeMove();
      }, speed)

      return () => {
        clearInterval(intervalId);
      };
    }
  }, [direction, snake, gameOver, pause, start]);

  function play() {
    setSnake(initialSnakeBody);
    setFood(generateNewFood(snake, boardWidth));
    setDirection("ArrowUp");
    setScore(0);
    setGameOver(false);
    setTime(initialTime);
    setStart(true);
  }

  function changeDirection(e) {
    if (e.key === "ArrowLeft" && direction !== "ArrowRight") {
      setDirection("ArrowLeft");
    } else if (e.key === "ArrowUp" && direction !== "ArrowDown") {
      setDirection("ArrowUp");
    } else if (e.key === "ArrowRight" && direction !== "ArrowLeft") {
      setDirection("ArrowRight");
    } else if (e.key === "ArrowDown" && direction !== "ArrowUp") {
      setDirection("ArrowDown");
    }
    if (e.code === "Space") {
      setPause(!pause);
    }
  }

  function snakeMove() {
      const snakeBodyBefore = [...snake];
      const [snakeHeadX, snakeHeadY] = [...snake[0]];
      const [foodX, foodY] = [...food[0]];
      const pointForEat = 1;

      let snakeBodyFirstElem = [snakeHeadX, snakeHeadY];

      const movements = {
        ArrowRight: ([x, y]) => [x + 1, y],
        ArrowLeft: ([x, y]) => [x - 1, y],
        ArrowUp: ([x, y]) => [x, y - 1],
        ArrowDown: ([x, y]) => [x, y + 1],
      };

      const moveSnakeHead = movements[direction];
      const snakeBodyFirstElemMove = moveSnakeHead(snakeBodyFirstElem);
      const snakeBodyWithExtraTail = snakeBodyWithTail(
        snakeBodyFirstElemMove,
        snakeBodyBefore
      );
      const hasEatenFood = getHasEatenFood(
        snakeBodyFirstElemMove,
        foodX,
        foodY
      );
      const snakeBody = growSnake(
        hasEatenFood,
        snakeBodyBefore,
        snakeBodyFirstElemMove,
        snakeBodyWithExtraTail
      );

      setGameOver(
        getIsSnakeHeadOutsideBoard(...snakeBodyFirstElemMove, boardWidth) ||
          getIsSnakeHeadOnBody([...snakeBodyFirstElemMove], snakeBody) ||
          getIsTimeOut(time)
      );

      if (hasEatenFood) {
        setScore((prevScore) => prevScore + pointForEat);
        setFood(generateNewFood(snakeBody, boardWidth));
      }

      setSnake(snakeBody);

  }

  return (
    <div>
      <div className="mesh">
        {board.map((row, indexX) => (
          <div key={indexX} className="item">
            {row.map((cell, indexY) => {
              const snakeBody = getCellStyle(snake, indexX, indexY) ? "snakeBody" : "";
              const snakeHead = snake.some(([x, y], index) => x === indexX && y === indexY && index === 0) ? "snakeHead" : "";
              const foodStyle = getCellStyle(food, indexX, indexY) ? "food" : "";
              return (
                <div
                  key={indexY}
                  className={`item ${snakeBody} ${snakeHead} ${foodStyle}`}
                />
              );
            })}
          </div>
        ))}
        <div className="meshAction">
          {gameOver && (
            <div className="alert">
              <span>Game has ended</span>
            </div>
          )}
          {pause && (
            <div className="alert">
              <span>Pause</span>
            </div>
          )}
          {!start || gameOver ? (
            <div className="alert">
              <button className="sturtButton" onClick={play}>
                Start
              </button>
            </div>
          ) : null}
        </div>
      </div>
      <GameTimer time={time}/>
      <GameScore score={score}/>
    </div>
  );
};

export default Board;
