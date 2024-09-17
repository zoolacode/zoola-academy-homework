import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";

const boardWidth = 25;//initial
const boardSize = boardWidth ** 2; //initial

const initialState = {
    direction: "up",
    score: 0,
    winGame: false,
    looseGame: false,
    shouldRestart: false,
    pause: false,
    time: 0,
    body: [
        [10, 10],
        [10, 11],
        [10, 12],
        [10, 13],
        [10, 14],
    ],
    food: [1, 1],
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer("restartGame", () => {
  return initialState;
});

engine.addSideEffect({
  onlyWhen: switchScore,
  effect: (_, emit) => {
    emit("createFoodItem");
    const interval = setInterval(() => {
      emit("createFoodItem");
    }, 15000);

    return () => {
      clearInterval(interval);
    };
  },
});

engine.addSideEffect({
  onlyWhen: directionHasChanged,
  effect: (_, emit) => {
    emit("activeMoving");
    const interval = setInterval(() => {
      emit("activeMoving");
    }, 200);

    return () => {
      clearInterval(interval);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    stateChangeAction("time", { prevState, state }),
  effect: (_, emit) => {
    const interval = setInterval(() => {
      emit("newSecond");
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    stateChangeAction("winGame", { prevState, state }) ||
    stateChangeAction("looseGame", { prevState, state }),
  effect: renderGamemessage,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    stateChangeAction("score", { prevState, state }),
  effect: renderGameScore,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    stateChangeAction("time", { prevState, state }),
  effect: renderGameTime,
});

engine.addSideEffect({
  effect: createBoard,
});

engine.addGlobalReducer((state) => {
  if (gameEnded(state) || gamePaused(state)) {
    return state;
  }

  const [headX, headY] = [...state.body[0]];

  const bodyHead = state.body.filter(([x, y]) => x === headX && y === headY);//correcting current index

  const looseGame = bodyHead.length === 2;

  return {
    ...state,
    looseGame,
  };
});

engine.addSignalReducer("newSecond", (state) => {
  if (gameEnded(state) || gamePaused(state)) {
    return state;
  }

  const timeInter = 1;
  const timeLimit = 120;
  let winGame = false;

  if (state.time === timeLimit - 1) {
    winGame = true;
  }

  return {
    ...state,
    time: state.time + timeInter,
    winGame,
  };
});

engine.addSignalReducer("pauseGame", (state) => {
  if (gameEnded(state)) {
    return state;
  }

  return {
    ...state,
    pause: !state.pause,
  };
});

engine.addSignalReducer("activeMoving", (state) => {
  if (gameEnded(state) || gamePaused(state)) {
    return state;
  }
  const prevBody = [...state.body];
  const [headX, headY] = [...state.body[0]];
  const [foodX, foodY] = [...state.food];
  const pointForEat = 1;
  let bodyHeadElem = [headX, headY];

  const moves = {
    right: ([x, y]) => [x + 1, y],
    left: ([x, y]) => [x - 1, y],
    up: ([x, y]) => [x, y - 1],
    down: ([x, y]) => [x, y + 1],
  };

  const movehead = moves[state.direction];
  const bodyNextMove = movehead(bodyHeadElem);
  const looseGame = snakeOutboard(...bodyNextMove);
  const bodyWithPoints = bodyWithTail(
    looseGame,
    bodyHeadElem,
    bodyNextMove,
    prevBody
  );
  const hasEatenFood = eatenFood(bodyNextMove, foodX, foodY);
  const body = addSnakeItems(
    hasEatenFood,
    prevBody,
    bodyNextMove,
    bodyWithPoints
  );

  return {
    ...state,
    body,
    looseGame,
    score: hasEatenFood
      ? state.score + pointForEat
      : state.score,
  };
});

engine.addSignalReducer("createFoodItem", (state) => {
  if (gameEnded(state) || gamePaused(state)) {
    return state;
  }

  const body = [...state.body];

  const food = renderFood(body);

  return {
    ...state,
    food,
  };
});

engine.start();

function renderGamemessage({ state, prevState }, emit) {
  let message = document.querySelector(".message");

  if (!message) {
    message = document.createElement("div");
    message.classList.add("message");
    message.innerHTML = 'Game has ended. Press "Enter" to start again';
    document.body.appendChild(message);
  }

  const pressEnter = (e) => {
    if (e.key === "Enter") {
      emit("restartGame");
    }
  };

  if (state.winGame || state.looseGame) {
    document.addEventListener("keyup", pressEnter);
    message.classList.add(state.winGame ? "message-win" : "message-loss");
  } else {
    message.classList.remove("message-win");
    message.classList.remove("message-loss");
  }

  return () => {
    document.removeEventListener("keyup", pressEnter);
  };
}

function renderGameScore({ state, prevState }, emit) {
  let scoreContainer = document.querySelector(".score");

  if (!scoreContainer) {
    scoreContainer = document.createElement("div");
    scoreContainer.classList.add("score");
    document.body.appendChild(scoreContainer);
  }
  scoreContainer.innerHTML = state.score;
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

function createBoard({ state, prevState }, emit) {
  let boardContainer = document.querySelector(".board");

  if (!boardContainer) {
    boardContainer = document.createElement("div");
    boardContainer.classList.add("board");

    for (let i = 0; i < boardSize; i++) {
      const cell = document.createElement("div");
      cell.classList.add("item");
      boardContainer.appendChild(cell);
      document.body.appendChild(boardContainer);
      const x = i % boardWidth;
      const y = Math.floor(i / boardWidth);

      let itemsArray = document.querySelectorAll(".item");
      itemsArray[i].dataset.x = x;
      itemsArray[i].dataset.y = y;
    }
  }

  const body = state.body.map(([x, y]) => {
    const boardIndex = x + y * boardWidth;
    return boardContainer.children[boardIndex];
  });
  body.forEach((item) => item.classList.add("body"));
  body[0].classList.add("head");

  const food = document.querySelector(
    `[data-x = '${state.food[0]}'][data-y = '${state.food[1]}']`
  );
  food.classList.add("food");

  const onDocumentClick = (e) => {
    switch (e.key) {
      case "ArrowLeft":
        emit("keyLeft");
        break;
      case "ArrowUp":
        emit("keyUp");
        break;
      case "ArrowRight":
        emit("keyRight");
        break;
      case "ArrowDown":
        emit("keyDown");
        break;
    }
    if (e.code === "Space") {
      emit("pauseGame");
    }
  };

  window.addEventListener("keydown", onDocumentClick);

  return () => {
    window.removeEventListener("keydown", onDocumentClick);
    body.forEach((item) => item.classList.remove("body"));
    body[0].classList.remove("head");
    food.classList.remove("food");
  };
}

function movingControl(engine, obj) {
  engine.addSignalReducer(obj.signal, (state) => {
    if (
      gameEnded(state) ||
      gamePaused(state) ||
      state.direction === obj.nonMoving
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

function eatenFood([headX, headY], foodX, foodY) {
  if (headX === foodX && headY === foodY) {
    return true;
  } else {
    return false;
  }
}
function renderFood(body) {
    let food = [getRandomNumber(25), getRandomNumber(25)];
    let foodOnSnake = body.filter(
      (item) => item[0] === food[0] && item[1] === food[1]
    );
  
    while (foodOnSnake.length === 1) {
      food = [getRandomNumber(25), getRandomNumber(25)];
      foodOnSnake = body.filter(
        (item) => item[0] === food[0] && item[1] === food[1]
      );
    }
    return food;
}
movingControl(engine, {signal: "keyUp", direction: "up", nonMoving: "down"});
movingControl(engine, {signal: "keyDown", direction: "down", nonMoving: "up"});
movingControl(engine, {signal: "keyLeft", direction: "left", nonMoving: "right"});
movingControl(engine, {signal: "keyRight", direction: "right", nonMoving: "left"});

function gameEnded(state) {
  return state.winGame || state.looseGame;
}

function gamePaused(state) {
  return state.pause;
}

function stateChangeAction(stateKey, payload) {
  return payload.prevState?.[stateKey] !== payload.state[stateKey];
}

function directionHasChanged({ prevState, state }) {
  return (
    stateChangeAction("direction", { prevState, state }) &&
    !gameEnded(state)
  );
}

function switchScore({ prevState, state }) {
  return (
    stateChangeAction("score", { prevState, state }) &&
    !gameEnded(state)
  );
}

function snakeOutboard(headX, headY) {
  if (headX > 24 || headX < 0 || headY > 24 || headY < 0) {
    return true;
  } else {
    return false;
  }
}
function addSnakeItems(hasEatenFood, body, head, bodyWithPoints) {
  if (hasEatenFood) {
    return [head, ...body];
  } else {
    return bodyWithPoints.slice(0, bodyWithPoints.length - 1);
  }
}

function bodyWithTail(
  looseGame,
  bodyHeadElem,
  bodyNextMove,
  body
) {
  if (looseGame) {
    return [bodyHeadElem, ...body];
  } else {
    return [bodyNextMove, ...body];
  }
}

function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

