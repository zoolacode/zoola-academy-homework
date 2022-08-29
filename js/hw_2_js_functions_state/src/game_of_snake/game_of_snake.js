import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";
import {
  renderGame,
  renderGameAlert,
  renderGameScore,
  renderGameTime,
  renderPauseScreen,
  renderSuperFoodTimer,
} from "./renderer";
import {
  flattenSuperFood,
  getRandomNumber,
  parseStringCoordinates,
  pipe,
  stringifyCoordinates,
} from "./utils";

// Good luck!

const boardSize = 25;
const adjustedBoardSize = boardSize - 1;

const engine = createEngine();

const initialState = {
  pause: false,
  isGameEnded: false,
  snake: ["10:10", "11:10", "12:10", "13:10", "14:10"],
  direction: [1, 0],
  directionCandidates: [],
  food: {},
  superFood: [],
  frame: 0,
  points: 0,
  speed: 200,
  gameTime: 0,
  speedUp: false,
  maxGameTime: 10,
  boardSize: 25,
};
engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => initialState);

engine.addSignalReducer("restartGame", () => initialState);

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    prevState?.pause !== state.pause ||
    prevState?.isGameEnded !== state.isGameEnded ||
    prevState?.gameTime !== state.gameTime,
  effect: ({ state }, emit) => {
    if (getIsGameEnded(state) || getIsGameOnPause(state)) {
      return;
    }

    const timeoutId = setTimeout(() => {
      emit("incrementGameTime");
    }, 1000);

    return () => {
      clearTimeout(timeoutId);
    };
  },
});

engine.addSignalReducer("incrementGameTime", (state) => {
  const nextGameTime = state.gameTime + 1;

  return {
    ...state,
    isGameEnded: nextGameTime > state.maxGameTime,
    gameTime: nextGameTime,
  };
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    prevState?.food !== state.food ||
    prevState?.snake !== state.snake ||
    prevState.isGameEnded !== state.isGameEnded,
  effect: ({ state }) => renderGame(state, boardSize),
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    prevState?.isGameEnded !== state.isGameEnded,
  effect: renderGameAlert,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) => prevState?.pause !== state.pause,
  effect: renderPauseScreen,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) => !prevState || !getIsGameEnded(state),
  effect: ({ state }, emit) => {
    const onKeyUp = (e) => {
      if (
        !["ArrowUp", "ArrowRight", "ArrowLeft", "ArrowDown"].includes(e.code)
      ) {
        return;
      }

      const arrowToDirection = {
        ArrowUp: [0, -1],
        ArrowRight: [1, 0],
        ArrowLeft: [-1, 0],
        ArrowDown: [0, 1],
      };
      const nextDirection = arrowToDirection[e.code];
      emit("changeDirection", nextDirection);
    };

    document.addEventListener("keyup", onKeyUp);

    return () => {
      document.removeEventListener("keyup", onKeyUp);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState }) => !prevState,
  effect: (_, emit) => {
    const onKeyUp = (e) => {
      if (e.key === "Shift") {
        emit("speedUp", false);
      }
    };

    const onKeyDown = (e) => {
      if (e.key === "Shift") {
        emit("speedUp", true);
      }
    };

    document.addEventListener("keydown", onKeyDown);
    document.addEventListener("keyup", onKeyUp);

    return () => {
      document.removeEventListener("keydown", onKeyDown);
      document.removeEventListener("keyup", onKeyUp);
    };
  },
});

engine.addSignalReducer("speedUp", (state, value) => {
  return {
    ...state,
    speedUp: value,
    speed: value ? initialState.speed / 2 : initialState.speed,
  };
});

engine.addSignalReducer("changeDirection", (state, nextDirection) => {
  const prevDirection =
    state.directionCandidates.length === 0
      ? state.direction
      : state.directionCandidates[state.directionCandidates.length - 1];

  if (
    !getIsSameDirection(prevDirection, nextDirection) &&
    getCanChangeDirection(prevDirection, nextDirection)
  ) {
    return getNextFrameState({
      ...state,
      directionCandidates: [...state.directionCandidates, nextDirection],
    });
  }

  return state;
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

const getNextFrameState = (state) => {
  if (getIsGameEnded(state)) {
    return state;
  }

  const { snake, direction, food } = state;

  const nextHead = getNextSnakeHead(snake, direction);

  if (getIsSnakeBodyThere(nextHead, snake) || getIsWallThere(nextHead)) {
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
            snake
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
    direction:
      state.directionCandidates.length === 0
        ? state.direction
        : state.directionCandidates[0],
    directionCandidates:
      state.directionCandidates.length === 0
        ? state.directionCandidates
        : state.directionCandidates.slice(1),
    points: isFoodThere
      ? state.points +
        (isSuperFoodThere ? superFoodInterest : normalFoodInterest)
      : state.points,
  };
};

engine.addSignalReducer("nextFrame", getNextFrameState);

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) => prevState?.points !== state.points,
  effect: renderGameScore,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) => prevState?.gameTime !== state.gameTime,
  effect: renderGameTime,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) => prevState?.frame !== state.frame,
  effect: ({ state }, emit) => {
    if (state.frame === 0) {
      emit("newFood");
    }
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) => prevState?.gameTime !== state.gameTime,
  effect: ({ state }, emit) => {
    if (getIsGameOnPause(state) || getIsGameEnded(state)) {
      return;
    }

    emit("removeExpiredSuperFood");

    if (state.gameTime !== 0 && state.gameTime % 5 === 0) {
      emit("newSuperFood");
    }
  },
});

engine.addSideEffect({
  effect: ({ state }, emit) => {
    if (getIsGameEnded(state)) {
      return;
    }

    const onKeyUp = (e) => {
      if (e.code === "Space") {
        emit("togglePause");
      }
    };

    document.addEventListener("keyup", onKeyUp);

    return () => {
      document.removeEventListener("keyup", onKeyUp);
    };
  },
});

engine.addSignalReducer("removeExpiredSuperFood", (state) => {
  const expiredSuperFood = state.superFood
    .filter(({ expiresAt }) => state.gameTime >= expiresAt)
    .map(({ location }) => location);

  if (expiredSuperFood.length === 0) {
    return state;
  }

  return {
    ...state,
    food: expiredSuperFood.reduce(
      (acc, expiredLocation) => {
        return {
          ...acc,
          [expiredLocation]: false,
        };
      },
      { ...state.food }
    ),
    superFood: state.superFood.filter(
      ({ expiresAt }) => state.gameTime < expiresAt
    ),
  };
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    prevState?.gameTime !== state.gameTime ||
    prevState.superFood !== state.superFood,
  effect: renderSuperFoodTimer,
});

engine.addSignalReducer("newSuperFood", (state) => {
  const superfoodExpirationTime = 5;
  const superFoodCoordinates = getRandomFoodCoordinates(
    getAllFood(state),
    state.snake
  );
  return {
    ...state,
    superFood: [
      ...state.superFood,
      {
        location: superFoodCoordinates,
        expiresAt: state.gameTime + superfoodExpirationTime,
      },
    ],
    food: {
      ...state.food,
      [superFoodCoordinates]: true,
    },
  };
});

engine.addSignalReducer("newFood", (state) => {
  const allFood = Object.entries(state.food).filter(
    ([_, value]) => value
  ).length;

  if (allFood > 2) {
    return state;
  }

  const foodCoordinates = getRandomFoodCoordinates(
    getAllFood(state),
    state.snake
  );

  return {
    ...state,
    food: {
      ...state.food,
      [foodCoordinates]: true,
    },
  };
});

engine.addSignalReducer("togglePause", (state) => {
  return {
    ...state,
    pause: !state.pause,
  };
});

engine.start();

function getIsGameEnded(state) {
  return state.isGameEnded;
}

function getIsSameDirection([x1, y1], [x2, y2]) {
  return x1 === x2 && y1 === y2;
}

function getIsGameOnPause(state) {
  return state.pause;
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

function getIsWallThere(coordinates) {
  const [x, y] = parseStringCoordinates(coordinates);
  return x > adjustedBoardSize || y > adjustedBoardSize || x < 0 || y < 0;
}

function getIsFoodThere(coordinates, food) {
  return food[coordinates];
}

function removeFood(coordinate, food) {
  return {
    ...food,
    [coordinate]: false,
  };
}

function getForbiddenFoodCoordinates(currentFood, currentSnake) {
  return currentSnake.reduce(
    (acc, coordinate) => {
      return {
        ...acc,
        [coordinate]: true,
      };
    },
    { ...currentFood }
  );
}

function getRandomFoodCoordinates(
  currentFood,
  currentSnake,
  forbiddenCoordinates = getForbiddenFoodCoordinates(currentFood, currentSnake)
) {
  const nextFoodCoordinates = [
    getRandomNumber(adjustedBoardSize),
    getRandomNumber(adjustedBoardSize),
  ];

  if (forbiddenCoordinates[nextFoodCoordinates]) {
    return getRandomFoodCoordinates(
      currentFood,
      currentSnake,
      forbiddenCoordinates
    );
  }

  return stringifyCoordinates(nextFoodCoordinates);
}

function getAllFood(state) {
  return state.superFood
    .map(({ location }) => location)
    .reduce(
      (acc, location) => {
        return {
          ...acc,
          [location]: true,
        };
      },
      { ...state.food }
    );
}

function removeSuperFood(superFood, coordinates) {
  return superFood.filter(({ location }) => {
    return location !== coordinates;
  });
}
