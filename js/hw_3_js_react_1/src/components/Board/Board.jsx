import React, { useState, useEffect } from "react";

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
import { GameScore } from "../GameScore/GameScore"

import "./Board.css";

const boardWidth = 25;
const board = Array(boardWidth).fill(Array(boardWidth).fill(0));
const initialSnakeBody = [
  [10, 10],
  [10, 11],
  [10, 12],
  [10, 13],
  [10, 14],
];
const initialFood = [[]];
const speed = 50;
const initialTime = 120

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
      const intervalId = setTimeout(() => {
        snakeMove();
      }, speed)

      return () => {
        clearInterval(intervalId);
      };
    }
  }, [direction, snake, gameOver, pause, start]);

  function play() {
    setSnake(initialSnakeBody);
    setFood(generateNewFood(snake));
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
        getIsSnakeHeadOutsideBoard(...snakeBodyFirstElemMove) ||
          getIsSnakeHeadOnBody([...snakeBodyFirstElemMove], snakeBody) ||
          getIsTimeOut(time)
      );

      if (hasEatenFood) {
        setScore((prevScore) => prevScore + pointForEat);
        setFood(generateNewFood(snakeBody));
      }

      setSnake(snakeBody);

  }

  return (
    <div>
      <div className="mesh">
        {board.map((row, indexX) => (
          <div key={indexX} className="item">
            {row.map((cell, indexY) => {
              let snakeBody = snake.some((item) => item[0] === indexX && item[1] === indexY) && "snakeBody";
              let snakeHead = snake.some((item, index) => item[0] === indexX && item[1] === indexY && index === 0) && "snakeHead";
              let foodStyle = food.some((item) => item[0] === indexX && item[1] === indexY) && "food";
              return (
                <div
                  key={indexY}
                  className={`item ${snakeBody} ${snakeHead} ${foodStyle}`}
                />
              );
            })}
          </div>
        ))}
        <div className="mesh_action">
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
