import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";
import { addGamePause } from "./game_pause";
import { addGameTime } from "./game_timer";
import { getIsGameEnded, getIsGameOnPause } from "./game_utils";
import { renderGame } from "./game_renderer";
import { addSnakeControls } from "./snake_controls";
import { initialState } from "./game_constants";
import {
  flattenSuperFood,
  parseStringCoordinates,
  pipe,
  stringifyCoordinates,
} from "./utils";
import {
  getAllFood,
  getIsFoodThere,
  getRandomFoodCoordinates,
  removeFood,
  removeSuperFood,
} from "./snake_food/snake_food_utils";
import { addSnakeFood } from "./snake_food/snake_food_engine";
import { addGameEndAlert } from "./game_end_alert";
import { addGameScore } from "./game_score";

// Good luck!

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => initialState);

engine.addSignalReducer("restartGame", () => initialState);

addGameTime(engine);
addGamePause(engine);
addSnakeControls(engine);
addSnakeFood(engine);
addGameEndAlert(engine);
addGameScore(engine);

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    prevState?.food !== state.food ||
    prevState?.snake !== state.snake ||
    prevState.isGameEnded !== state.isGameEnded,
  effect: ({ state }) => renderGame(state, state.boardSize),
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    prevState?.frame !== state.frame ||
    getIsGameOnPause(prevState) !== getIsGameOnPause(state) ||
    getIsGameEnded(prevState) !== getIsGameEnded(state),
  effect: ({ state }, emit) => {
    if (getIsGameOnPause(state) || getIsGameEnded(state)) {
      return;
    }

    const timeout = setTimeout(() => {
      emit("nextFrame");
    }, state.speed);

    return () => {
      clearTimeout(timeout);
    };
  },
});

engine.addSignalReducer("changeDirection", (state, nextDirection) => {
  const prevDirection = state.direction;

  if (
    !getIsSameDirection(prevDirection, nextDirection) &&
    getCanChangeDirection(prevDirection, nextDirection)
  ) {
    return getNextFrame({
      ...state,
      direction: nextDirection,
    });
  }

  return state;
});

const getNextFrame = (state) => {
  if (getIsGameEnded(state)) {
    return state;
  }

  const { snake, direction, food } = state;

  const nextHead = getNextSnakeHead(snake, direction);

  if (
    getIsSnakeBodyThere(nextHead, snake) ||
    getIsWallThere(nextHead, state.boardSize)
  ) {
    return {
      ...state,
      snake,
      isGameEnded: true,
    };
  }

  const [tail, ...body] = snake;
  const isFoodThere = getIsFoodThere(nextHead, getAllFood(state));
  const isSuperFoodThere =
    isFoodThere && flattenSuperFood(state.superFood)[nextHead];

  const nextSnake = [...(isFoodThere ? snake : body), nextHead];

  const nextFood = isFoodThere
    ? pipe(
        (food) => removeFood(nextHead, food),
        (food) => {
          if (isSuperFoodThere) {
            return food;
          }

          const foodCoordinates = getRandomFoodCoordinates(
            getAllFood(state),
            snake,
            state.boardSize
          );
          return {
            ...food,
            [foodCoordinates]: true,
          };
        }
      )(food)
    : food;

  const nextSuperFood = isSuperFoodThere
    ? removeSuperFood(state.superFood, nextHead)
    : state.superFood;

  const normalFoodInterest = 1;
  const superFoodInterest = 5;

  return {
    ...state,
    snake: nextSnake,
    food: nextFood,
    frame: state.frame + 1,
    superFood: nextSuperFood,
    points: isFoodThere
      ? state.points +
        (isSuperFoodThere ? superFoodInterest : normalFoodInterest)
      : state.points,
  };
};

engine.addSignalReducer("nextFrame", getNextFrame);

engine.start();

function getIsSameDirection([x1, y1], [x2, y2]) {
  return x1 === x2 && y1 === y2;
}

function getCanChangeDirection([x1, y1], [x2, y2]) {
  if (x1 !== x2) {
    return y1 !== y2;
  }

  if (y1 !== y2) {
    return x1 !== x2;
  }

  return false;
}

function getNextSnakeHead(snake, direction) {
  const currentHead = parseStringCoordinates(snake[snake.length - 1]);

  const nextHead = currentHead.reduce(
    (acc, coordinate, index) => {
      const directionCoordinate = direction[index];

      if (directionCoordinate === 0) {
        // do nothing, we're not moving in that direction
        acc[index] = coordinate;
      } else {
        const nextCoordinate = coordinate + directionCoordinate;
        acc[index] = nextCoordinate;
      }

      return acc;
    },
    [-1, -1]
  );

  return stringifyCoordinates(nextHead);
}

function getIsSnakeBodyThere(targetCoordinate, snake) {
  return snake.some((coordinate) => coordinate === targetCoordinate);
}

function getIsWallThere(coordinates, boardSize) {
  const [x, y] = parseStringCoordinates(coordinates);
  const adjustedBoardSize = boardSize - 1;
  return x > adjustedBoardSize || y > adjustedBoardSize || x < 0 || y < 0;
}
