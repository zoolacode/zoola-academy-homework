import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";

const boardWidth = 25;
const meshSize = boardWidth ** 2;

const initialState = {
  currentScore: 0,
  gameWon: false,
  gameLost: false,
  shouldRestart: false,
  pause: false,
  time: 0,
  snakeBody: [
    [10, 10],
    [10, 11],
    [10, 12],
    [10, 13],
    [10, 14],
  ],
  food: [1, 1],
  direction: "up",
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer("restartGame", () => {
  return initialState;
});

engine.addSideEffect({
  onlyWhen: ifScoreChanged,
  effect: (_, emit) => {
    emit("createFood");
    const intervalId = setInterval(() => {
      emit("createFood");
    }, 15000);

    return () => {
      clearInterval(intervalId);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ifDirectionChanged,
  effect: (_, emit) => {
    emit("snakeMove");
    const intervalId = setInterval(() => {
      emit("snakeMove");
    }, 200);

    return () => {
      clearInterval(intervalId);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("time", { prevState, state }),
  effect: (_, emit) => {
    const intervalId = setInterval(() => {
      emit("nextSecond");
    }, 1000);

    return () => {
      clearInterval(intervalId);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("gameWon", { prevState, state }) ||
    getIsStateChanged("gameLost", { prevState, state }),
  effect: renderGameAlert,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("currentScore", { prevState, state }),
  effect: renderGameScore,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("time", { prevState, state }),
  effect: renderGameTime,
});

engine.addSideEffect({
  effect: renderGameBoard,
});

engine.addGlobalReducer((state) => {
  if (getIsGameEnded(state) || getIsGamePause(state)) {
    return state;
  }

  const [snakeHeadX, snakeHeadY] = [...state.snakeBody[0]];

  const snakeHeadOnBody = state.snakeBody.filter(([x, y]) => x === snakeHeadX && y === snakeHeadY);

  const gameLost = snakeHeadOnBody.length === 2;

  return {
    ...state,
    gameLost,
  };
});

engine.addSignalReducer("nextSecond", (state) => {
  if (getIsGameEnded(state) || getIsGamePause(state)) {
    return state;
  }

  const timeSec = 1;
  const timeWon = 120;
  let gameWon = false;

  if (state.time === timeWon - 1) {
    gameWon = true;
  }

  return {
    ...state,
    time: state.time + timeSec,
    gameWon,
  };
});

addMovement(engine, {signal: "keyClickUp", direction: "up", dontMove: "down"});
addMovement(engine, {signal: "keyClickDown", direction: "down", dontMove: "up"});
addMovement(engine, {signal: "keyClickLeft", direction: "left", dontMove: "right"});
addMovement(engine, {signal: "keyClickRight", direction: "right", dontMove: "left"});

engine.addSignalReducer("pauseGame", (state) => {
  if (getIsGameEnded(state)) {
    return state;
  }

  return {
    ...state,
    pause: !state.pause,
  };
});

engine.addSignalReducer("snakeMove", (state) => {
  if (getIsGameEnded(state) || getIsGamePause(state)) {
    return state;
  }
  const snakeBodyBefore = [...state.snakeBody];
  const [snakeHeadX, snakeHeadY] = [...state.snakeBody[0]];
  const [foodX, foodY] = [...state.food];
  const pointForEat = 1;
  let snakeBodyFirstElem = [snakeHeadX, snakeHeadY];

  const movements = {
    right: ([x, y]) => [x + 1, y],
    left: ([x, y]) => [x - 1, y],
    up: ([x, y]) => [x, y - 1],
    down: ([x, y]) => [x, y + 1],
  };

  const moveSnakeHead = movements[state.direction];
  const snakeBodyFirstElemMove = moveSnakeHead(snakeBodyFirstElem);
  const gameLost = getIsSnakeHeadOutsideBoard(...snakeBodyFirstElemMove);
  const snakeBodyWithExtraTail = snakeBodyWithTail(
    gameLost,
    snakeBodyFirstElem,
    snakeBodyFirstElemMove,
    snakeBodyBefore
  );
  const hasEatenFood = getHasEatenFood(snakeBodyFirstElemMove, foodX, foodY);
  const snakeBody = growSnake(
    hasEatenFood,
    snakeBodyBefore,
    snakeBodyFirstElemMove,
    snakeBodyWithExtraTail
  );

  return {
    ...state,
    snakeBody,
    gameLost,
    currentScore: hasEatenFood
      ? state.currentScore + pointForEat
      : state.currentScore,
  };
});

engine.addSignalReducer("createFood", (state) => {
  if (getIsGameEnded(state) || getIsGamePause(state)) {
    return state;
  }

  const snakeBody = [...state.snakeBody];

  const food = generateNewFood(snakeBody);

  return {
    ...state,
    food,
  };
});

engine.start();

function renderGameAlert({ state, prevState }, emit) {
  let alert = document.querySelector(".alert");

  if (!alert) {
    alert = document.createElement("div");
    alert.classList.add("alert");
    alert.innerHTML = 'Game has ended. Press "Enter" to start again';
    document.body.appendChild(alert);
  }

  const onAlertEnter = (e) => {
    if (e.key === "Enter") {
      emit("restartGame");
    }
  };

  if (state.gameWon || state.gameLost) {
    document.addEventListener("keyup", onAlertEnter);
    alert.classList.add(state.gameWon ? "alert-win" : "alert-loss");
  } else {
    alert.classList.remove("alert-win");
    alert.classList.remove("alert-loss");
  }

  return () => {
    document.removeEventListener("keyup", onAlertEnter);
  };
}

function renderGameScore({ state, prevState }, emit) {
  let scoreContainer = document.querySelector(".score");

  if (!scoreContainer) {
    scoreContainer = document.createElement("div");
    scoreContainer.classList.add("score");
    document.body.appendChild(scoreContainer);
  }

  scoreContainer.innerHTML = state.currentScore;
}

function renderGameTime({ state, prevState }, emit) {
  let timeContainer = document.querySelector(".time");

  if (!timeContainer) {
    timeContainer = document.createElement("div");
    timeContainer.classList.add("time");
    document.body.appendChild(timeContainer);
  }

  timeContainer.innerHTML = state.time;
}

function renderGameBoard({ state, prevState }, emit) {
  let meshContainer = document.querySelector(".mesh");

  if (!meshContainer) {
    meshContainer = document.createElement("div");
    meshContainer.classList.add("mesh");

    for (let i = 0; i < meshSize; i++) {
      const cell = document.createElement("div");
      cell.classList.add("item");
      meshContainer.appendChild(cell);
      document.body.appendChild(meshContainer);
      const x = i % boardWidth;
      const y = Math.floor(i / boardWidth);

      let excel = document.querySelectorAll(".item");
      excel[i].dataset.x = x;
      excel[i].dataset.y = y;
    }
  }

  const snakeBody = state.snakeBody.map(([x, y]) => {
    const meshIndex = x + y * boardWidth;
    return meshContainer.children[meshIndex];
  });
  snakeBody.forEach((item) => item.classList.add("snakeBody"));
  snakeBody[0].classList.add("snakeHead");

  const food = document.querySelector(
    `[data-x = '${state.food[0]}'][data-y = '${state.food[1]}']`
  );
  food.classList.add("food");

  const onDocumentClick = (e) => {
    switch (e.key) {
      case "ArrowLeft":
        emit("keyClickLeft");
        break;
      case "ArrowUp":
        emit("keyClickUp");
        break;
      case "ArrowRight":
        emit("keyClickRight");
        break;
      case "ArrowDown":
        emit("keyClickDown");
        break;
    }
    if (e.code === "Space") {
      emit("pauseGame");
    }
  };

  window.addEventListener("keydown", onDocumentClick);

  return () => {
    window.removeEventListener("keydown", onDocumentClick);
    snakeBody.forEach((item) => item.classList.remove("snakeBody"));
    snakeBody[0].classList.remove("snakeHead");
    food.classList.remove("food");
  };
}

function addMovement(engine, obj) {
  engine.addSignalReducer(obj.signal, (state) => {
    if (
      getIsGameEnded(state) ||
      getIsGamePause(state) ||
      state.direction === obj.dontMove
    ) {
      return state;
    }

    const direction = obj.direction;

    return {
      ...state,
      direction,
    };
  });
}

function getHasEatenFood([snakeHeadX, snakeHeadY], foodX, foodY) {
  if (snakeHeadX === foodX && snakeHeadY === foodY) {
    return true;
  } else {
    return false;
  }
}

function getIsGameEnded(state) {
  return state.gameWon || state.gameLost;
}

function getIsGamePause(state) {
  return state.pause;
}

function getIsStateChanged(stateKey, payload) {
  return payload.prevState?.[stateKey] !== payload.state[stateKey];
}

function ifDirectionChanged({ prevState, state }) {
  return (
    getIsStateChanged("direction", { prevState, state }) &&
    !getIsGameEnded(state)
  );
}

function ifScoreChanged({ prevState, state }) {
  return (
    getIsStateChanged("currentScore", { prevState, state }) &&
    !getIsGameEnded(state)
  );
}

function getIsSnakeHeadOutsideBoard(headX, headY) {
  if (headX > 24 || headX < 0 || headY > 24 || headY < 0) {
    return true;
  } else {
    return false;
  }
}
function growSnake(hasEatenFood, snakeBody, snakeHead, snakeBodyWithExtraTail) {
  if (hasEatenFood) {
    return [snakeHead, ...snakeBody];
  } else {
    return snakeBodyWithExtraTail.slice(0, snakeBodyWithExtraTail.length - 1);
  }
}

function snakeBodyWithTail(
  gameLost,
  snakeBodyFirstElem,
  snakeBodyFirstElemMove,
  snakeBody
) {
  if (gameLost) {
    return [snakeBodyFirstElem, ...snakeBody];
  } else {
    return [snakeBodyFirstElemMove, ...snakeBody];
  }
}

function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

function generateNewFood(snakeBody) {
  let food = [getRandomNumber(25), getRandomNumber(25)];
  let foodOnSnake = snakeBody.filter(
    (item) => item[0] === food[0] && item[1] === food[1]
  );

  while (foodOnSnake.length === 1) {
    food = [getRandomNumber(25), getRandomNumber(25)];
    foodOnSnake = snakeBody.filter(
      (item) => item[0] === food[0] && item[1] === food[1]
    );
  }
  return food;
}
