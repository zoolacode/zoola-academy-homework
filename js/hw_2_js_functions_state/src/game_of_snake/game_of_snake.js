import { emit } from "process";
import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";

const meshSize = 25;
const boardSize = meshSize ** 2;

const initialState = {
  snakeHead: [10, 10],
  snakeBody: [
    [10, 10],
    [10, 11],
    [10, 12],
    [10, 13],
    [10, 14],
  ],
  food: [[15, 15]],
  direction: "up",
  win: false,
  lose: false,
  timer: 120000,
  timeGone: 0,
  score: 0,
  pause: false,
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer("restartGame", () => {
  return initialState;
});

engine.addSignalReducer("nextTick", (state) => {
  if (state.win || state.lose || state.pause) return state;

  if (state.timer === 0) {
    return {
      ...state,
      lose: true,
    };
  }

  return {
    ...state,
    timer: state.timer - 100,
    timeGone: state.timeGone + 100,
  };
});

engine.addSignalReducer("turn", (state, direction) => {
  if (state.win || state.lose || state.pause) return state;

  if (state.direction === direction) {
    return state;
  }
  return {
    ...state,
    direction: direction,
  };
});

engine.addSignalReducer("snakeMove", (state) => {
  const prevBodyPosition = state.snakeBody;
  const prevHeadPosition = prevBodyPosition[0];
  let newSnakeHead = state.snakeHead;
  const snakeLength = state.snakeBody.length;

  newSnakeHead = moveSnake(newSnakeHead, prevHeadPosition, state.direction);

  if (
    getIsHitBorder(newSnakeHead) ||
    getIsHitSelf(newSnakeHead, state.snakeBody)
  ) {
    return {
      ...state,
      lose: true,
    };
  } else if (state.pause) {
    return state;
  }

  if (getIsFoodEaten(newSnakeHead, state.food)) {
    return {
      ...state,
      snakeBody: [newSnakeHead, ...state.snakeBody],
      snakeHead: newSnakeHead,
      food: generateFood(state.snakeBody),
      score: state.score + 1,
      timeGone: 0,
    };
  } else if (state.timeGone % 15000 === 0) {
    return {
      ...state,
      snakeBody: [newSnakeHead, ...state.snakeBody.slice(0, snakeLength - 1)],
      snakeHead: newSnakeHead,
      food: generateFood(state.snakeBody),
      timeGone: 0,
    };
  } else {
    return {
      ...state,
      snakeBody: [newSnakeHead, ...state.snakeBody.slice(0, snakeLength - 1)],
      snakeHead: newSnakeHead,
    };
  }
});

engine.addSignalReducer("pauseGame", (state) => {
  if (state.win || state.lose) {
    return state;
  }

  return {
    ...state,
    pause: !state.pause,
  };
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("timer", { prevState, state }) ||
    getIsStateChanged("pause", { prevState, state }),

  effect: ({ state }, emit) => {
    emit("snakeMove");
    const timeoutId = setTimeout(() => {
      emit("nextTick");
    }, 100);

    return () => {
      clearTimeout(timeoutId);
    };
  },
});

engine.addSideEffect({
  effect: renderGameBoard,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("lose", { prevState, state }),
  effect: renderAlert,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("score", { prevState, state }),
  effect: renderScore,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("timer", { prevState, state }),
  effect: renderTimer,
});

engine.start();

function renderAlert({ state }, emit) {
  let alert = document.querySelector(".alert");

  if (!alert) {
    alert = document.createElement("div");
    alert.classList.add("alert");
    alert.innerHTML = 'Game has ended. Press "Enter" to start again';
    document.body.appendChild(alert);
  }

  const onAlertEnter = (e) => {
    if (e.keyCode === 13) {
      emit("restartGame");
    }
  };

  if (state.lose) {
    document.addEventListener("keyup", onAlertEnter);
    alert.classList.add("alert-loss");
  } else {
    alert.classList.remove("alert-loss");
  }

  return () => {
    document.removeEventListener("keyup", onAlertEnter);
  };
}

function renderScore({ state }) {
  let scoreContainer = document.querySelector(".score");

  if (!scoreContainer) {
    scoreContainer = document.createElement("div");
    scoreContainer.classList.add("score");
    const span = document.createElement("span");
    span.classList.add("score-value");
    scoreContainer.appendChild(span);
    document.body.append(scoreContainer);
  }
  document.querySelector(".score-value").innerHTML = state.score;
}

function renderTimer({ state }) {
  let timerContainer = document.querySelector(".timer");

  if (!timerContainer) {
    timerContainer = document.createElement("div");
    timerContainer.classList.add("timer");
    document.body.append(timerContainer);
  }

  let minutes = Math.floor(state.timer / (1000 * 60));
  let seconds = Math.floor(state.timer / 1000 - minutes * 60);

  timerContainer.innerHTML = `${getFormatedTime(minutes)} : ${getFormatedTime(
    seconds
  )}`;
}

function renderGameBoard({ state }, emit) {
  let mesh = document.querySelector(".mesh");

  if (!mesh) {
    mesh = document.createElement("div");
    mesh.classList.add("mesh");

    for (let i = 0; i < boardSize; i++) {
      var cell = document.createElement("div");
      mesh.appendChild(cell);
    }

    document.body.append(mesh);
  }

  const snakeMeshBody = state.snakeBody.map(([x, y]) => {
    let index = x + y * meshSize;
    return mesh.children[index];
  });

  snakeMeshBody.forEach((item) => item.classList.add("snakeBody"));
  snakeMeshBody[0].classList.add("snakeHead");

  const foodLocation = state.food[0] + state.food[1] * meshSize;

  if ((state.score + 1) % 10 === 0) {
    mesh.children[foodLocation]?.classList.add("apple_gold");
  } else {
    mesh.children[foodLocation]?.classList.add("apple");
  }

  const handlePressKey = (event) => {
    switch (event.keyCode) {
      case 37:
        emit("turn", "left");
        break;
      case 38:
        emit("turn", "up");
        break;
      case 39:
        emit("turn", "right");
        break;
      case 40:
        emit("turn", "down");
        break;
      case 32:
        emit("pauseGame");
      default:
        break;
    }
  };
  document.addEventListener("keydown", handlePressKey);

  return () => {
    state.snakeBody.forEach(([x, y]) => {
      const index = x + y * 25;
      mesh.children[index].classList.remove("snakeBody");
      mesh.children[index].classList.remove("snakeHead");
    });

    mesh.children[foodLocation]?.classList.remove("apple");
    mesh.children[foodLocation]?.classList.remove("apple_gold");

    document.removeEventListener("keydown", handlePressKey);
  };
}

function getIsStateChanged(stateKey, { prevState, state }) {
  return prevState?.[stateKey] !== state[stateKey];
}

function getIsHitBorder(head) {
  if (head[0] > 24 || head[1] < 0 || head[0] < 0 || head[1] > 24) {
    return true;
  }

  return false;
}

function getIsHitSelf(head, body) {
  const event = (element) => element[0] === head[0] && element[1] === head[1];

  return body.some(event);
}

function getIsFoodEaten(head, position) {
  if (head[0] === position[0] && head[1] === position[1]) {
    return true;
  } else {
    return false;
  }
}

function generateFood(snakeBody) {
  let newPosition = [getRandomNum(24), getRandomNum(24)];

  if (snakeBody.includes(newPosition)) {
    newPosition = [getRandomNum(24), getRandomNum(24)];
  } else {
    return newPosition;
  }
  /* for (let i = 0; i < snakeBody.length; i++) {
    if (
      snakeBody[i][0] === newPosition[0] ||
      snakeBody[i][0] === newPosition[1]
    ) {
      newPosition = [getRandomNum(24), getRandomNum(24)];
    }
  } */

  // return newPosition;
}

function getFormatedTime(time) {
  return time.toString().padStart(2, "0");
}

function getRandomNum(num) {
  return Math.floor(Math.random() * num);
}

function moveSnake(newSnakeHead, prevHeadPosition, direction) {
  switch (direction) {
    case "down":
      newSnakeHead = [prevHeadPosition[0], prevHeadPosition[1] + 1];
      break;

    case "up":
      newSnakeHead = [prevHeadPosition[0], prevHeadPosition[1] - 1];
      break;

    case "left":
      newSnakeHead = [prevHeadPosition[0] - 1, prevHeadPosition[1]];
      break;

    case "right":
      newSnakeHead = [prevHeadPosition[0] + 1, prevHeadPosition[1]];
      break;

    default:
      break;
  }

  return newSnakeHead;
}
