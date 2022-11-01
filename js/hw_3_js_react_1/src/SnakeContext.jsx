import React, { useReducer } from 'react';
import {
  getRandomDishPosition,
  getIndex,
  getHasEatenDish,
  getHasEatenBonusDish,
  getNextScore,
  getIsGameLost,
  getNextSnakeHead,
  getSnakeHitBorders,
  getNewSnakeCoords,
  addMovement,
} from './utils';
import {
  initialState,
  initialSnakeCoords,
  bonusDishLifeTime,
} from './game_constants';

function reducer(state, action) {
  switch (action.type) {
    case 'runGameTimer':
      return {
        ...state,
        gameTimer: state.gameTimer + action.timeFrame,
      };
    case 'moveSnake':
      const nextSnakeHead = getNextSnakeHead(state.snakeHead, state.direction);
      const isSnakeHitBorders = getSnakeHitBorders(nextSnakeHead);
      const isSnakeHitBody = state.snakeCoords.includes(
        getIndex(nextSnakeHead.x, nextSnakeHead.y)
      );
      const snakeLength = state.snakeCoords.length;
      const snakeHeadCoordinates = [...state.snakeCoords][snakeLength - 1];
      const hasEatenDish = getHasEatenDish(snakeHeadCoordinates, state.dish);
      const hasEatenBonusDish = getHasEatenBonusDish(
        snakeHeadCoordinates,
        state.bonusDish
      );
      const newData = getNewSnakeCoords(
        hasEatenDish,
        hasEatenBonusDish,
        state.snakeCoords
      );
      const nextScore = getNextScore(
        state.currentScore,
        hasEatenDish,
        hasEatenBonusDish
      );
      const isGameLost = getIsGameLost(
        isSnakeHitBody,
        isSnakeHitBorders,
        state.gameTimer
      );

      if (
        isGameLost &&
        action.type !== 'restartGame' &&
        action.type !== 'gameOver'
      ) {
        return {
          ...state,
          gameLost: true,
        };
      }
      return {
        ...state,
        snakeHead: nextSnakeHead,
        currentScore: nextScore,
        snakeCoords: [...newData, getIndex(nextSnakeHead.x, nextSnakeHead.y)],
        dish: hasEatenDish
          ? getRandomDishPosition(
              state.snakeCoords,
              state.dish,
              state.bonusDish
            )
          : state.dish,
        bonusDish: hasEatenBonusDish ? null : state.bonusDish,
      };
    case 'moveRight':
      return addMovement(state, action);
    case 'moveLeft':
      return addMovement(state, action);
    case 'moveDown':
      return addMovement(state, action);
    case 'moveUp':
      return addMovement(state, action);
    case 'giveBonusDish':
      const nextBonusDish = getRandomDishPosition(
        state.snakeCoords,
        state.dish,
        state.bonusDish
      );
      return {
        ...state,
        bonusDish: nextBonusDish,
        bonusDishExpiresTime: state.gameTimer + bonusDishLifeTime,
      };
    case 'pauseGame':
      return {
        ...state,
        gameOn: !state.gameOn,
      };
    case 'gameOver':
      return {
        ...state,
        dish: null,
        bonusDish: null,
        bonusDishExpiresTime: 0,
      };
    case 'restartGame':
      return {
        ...initialState,
        dish: getRandomDishPosition(initialSnakeCoords, null, null),
      };
    default:
      return state;
  }
}

export const DispatchContext = React.createContext(() => {});
export const SnakeContext = React.createContext(initialState);

export function StateProvider({ children }) {
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <DispatchContext.Provider value={dispatch}>
      <SnakeContext.Provider value={state}>{children}</SnakeContext.Provider>
    </DispatchContext.Provider>
  );
}
