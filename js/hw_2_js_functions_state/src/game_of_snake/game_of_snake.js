import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";

const rows = 25,
  columns = 25,
  initialBoostTimerValue = 15,
  redrawBoostTimerValue = 5,
  defaultFoodBoost = 3,
  gameTimer = 120;

let meshData = [];

//initial state
const snakeState = {
  bodyData: [
    [10, 10],
    [10, 11],
    [10, 12],
    [10, 13],
    [10, 14],
  ],
  currentScore: 0,
  round: 0,
  boostCoefficient: defaultFoodBoost,
  boostTimerToPubish: initialBoostTimerValue,
  boostPublishFlag: false,
  gameOver: false,
  pause: false,
  direction: [0, -1],
  directionChanged: false,
  foodObjects: [],

  gameTimer: gameTimer,
};

const engine = createEngine();

//start Redusers
engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return snakeState;
});

engine.addSignalReducer("restartGame", () => {
  return snakeState;
});

//Help Redusers

engine.addSignalReducer("changeDirection", (state, keyEvent) => {
  if (state.pause) {
    return state;
  }

  let newDirection = getNewDirection(state, keyEvent);

  return {
    ...state,
    direction: state.directionChanged ? state.direction : newDirection,
    directionChanged: state.direction === newDirection ? false : true,
  };
});

engine.addSignalReducer("pressPause", (state) => {
  return {
    ...state,
    pause: state.pause ? false : true,
  };
});

engine.addSignalReducer("moveSnake", (state) => {
  let newBodyData = moveSnakeBody(state);

  if (checkIsGameEnded({ ...state, bodyData: newBodyData })) {
    return {
      ...state,
      gameOver: true,
    };
  }

  return {
    ...state,
    round: state.round + 1,
    bodyData: newBodyData,
    directionChanged: false,
  };
});

engine.addSignalReducer("nextMoveData", (state) => {
  return {
    ...state,
    newBodyData: [],
  };
});

engine.addSignalReducer("removeFood", (state) => {
  (foodObjectDetails = checkingFoodOnHead(
    [...state.bodyData],
    state.foodObjects
  )),
    (newFoodObjects = foodObjectDetails.foodObjects);

  return {
    ...state,
    foodObjects: newFoodObjects,
  };
});

engine.addSignalReducer("addNewFood", (state, foodParams) => {
  let boostValues = [2, 4, 6, 8, 10],
    newFoodObjects = [...state.foodObjects];

  newFoodObjects.push({
    possition: foodParams.newFoodPossition,
    isBooster: foodParams.isBooster,
    foodBoostCoefficient: foodParams.isBooster
      ? boostValues[getRandomNumber(boostValues.length - 1)]
      : defaultFoodBoost,
  });

  return {
    ...state,
    foodObjects: newFoodObjects,
  };
});

engine.addSignalReducer("changeScore", (state) => {
  return {
    ...state,
    currentScore: state.currentScore + 1,
  };
});

engine.addSignalReducer("gameTimerChange", (state, reset = false) => {
  return {
    ...state,
    gameTimer: reset ? 0 : state.gameTimer - 1,
    gameOver: reset ? true : state.gameOver,
  };
});

engine.addSignalReducer("removeBooster", (state) => {
  newFoodObjects = removeBoost(state);

  return {
    ...state,
    foodObjects: newFoodObjects,
  };
});

engine.addSignalReducer("changeBoostCoefficient", (state, newCoefficient) => {
  newFoodObjects = removeBoost(state);

  return {
    ...state,
    boostCoefficient: newCoefficient,
  };
});

engine.addSignalReducer("changeBoostTimer", (state) => {
  return {
    ...state,
    boostTimerToPubish: state.boostTimerToPubish - 1,
  };
});

engine.addSignalReducer("updateBoostParams", (state, boostParams) => {
  return {
    ...state,
    boostTimerToPubish: boostParams.boostTimerToPubish,
    boostPublishFlag: boostParams.boostPublishFlag,
  };
});

//side-efects...

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    (((getIsStateChanged("boostTimerToPubish", { prevState, state }) ||
      getIsStateChanged("boostPublishFlag", { prevState, state })) &&
      !state.pause) ||
      getIsPauseUnlocked({ prevState, state })) &&
    !getIsGameEnded(state),
  effect: ({ prevState, state }, emit) => {
    const timeoutIdGame = setTimeout(() => {
      if (state.boostTimerToPubish === 0) {
        if (state.boostPublishFlag) {
          emit("addNewFood", {
            newFoodPossition: getNewFoodPossition(state),
            isBooster: true,
          });
          emit("removeBooster");

          let boostParams = {
            boostTimerToPubish: redrawBoostTimerValue,
            boostPublishFlag: state.boostPublishFlag,
          };
          emit("updateBoostParams", boostParams);
          // redraw old booster after 5 sec delay
          // change boostTimerToPubish to 5
        } else {
          // change boostTimerToPubish to 5
          // change boostPublishFlag to true
          let boostParams = {
            boostTimerToPubish: redrawBoostTimerValue,
            boostPublishFlag: true,
          };
          emit("updateBoostParams", boostParams);

          // publish new booster after 15 sec delay
          emit("addNewFood", {
            newFoodPossition: getNewFoodPossition(state),
            isBooster: true,
          });
        }
      } else {
        emit("changeBoostTimer");
      }
    }, 1000);

    return () => {
      clearTimeout(timeoutIdGame);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    ((getIsStateChanged("gameTimer", { prevState, state }) && !state.pause) ||
      getIsPauseUnlocked({ prevState, state })) &&
    !getIsGameEnded(state),
  effect: ({ prevState, state }, emit) => {
    const timeoutIdGame = setTimeout(() => {
      emit("gameTimerChange");
    }, 1000);

    return () => {
      clearTimeout(timeoutIdGame);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) => !state.pause && !getIsGameEnded(state),

  effect: ({ prevState, state }, emit) => {
    const timeoutIdPause = setTimeout(() => {
      emit("gameTimerChange", true);
    }, 120000);

    return () => {
      clearTimeout(timeoutIdPause);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    ((getIsRoundChanged({ prevState, state }) && !state.pause) ||
      getIsPauseUnlocked({ prevState, state })) &&
    !checkIsGameEnded(state),

  effect: ({ prevState, state }, emit) => {
    let boostCoefficient = state.boostCoefficient;
    console.log("boostCoefficient", boostCoefficient, "Round: ", state.round);

    const timeoutId = setTimeout(() => {
      emit("moveSnake");
    }, 1000 / boostCoefficient);

    return () => {
      clearTimeout(timeoutId);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("gameTimer", { prevState, state }) && !state.gameOver,
  effect: ({ prevState, state }) => renderGameTimer(state),
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    (prevState === undefined || getIsRoundChanged({ prevState, state })) &&
    !getIsGameEnded(state),
  effect: renderGameBoard,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("currentScore", { prevState, state }),
  effect: ({ prevState, state }) => {
    renderGameScore({ prevState, state });
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("pause", { prevState, state }) && !getIsGameEnded(state),
  effect: ({ prevState, state }) => {
    renderGamePause({ prevState, state });
  },
});

engine.addSideEffect({
  onlyWhen: getIsRoundChanged,
  effect: isFoodEaten,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("gameOver", { prevState, state }) && state.gameOver,
  effect: ({ prevState, state }) => {
    drawSnake({ prevState, state }, false);
    renderGameTimer(state);
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("gameOver", { prevState, state }),
  effect: renderGameAlert,
});

engine.start();

//Help functions

function removeBoost(state) {
  let newFoodObjects = [...state.foodObjects];

  for (let index = 0; index < state.foodObjects.length; index++) {
    const element = state.foodObjects[index];
    if (element.isBooster) {
      newFoodObjects.splice(index, 1);
      break;
    }
  }

  return newFoodObjects;
}

function renderGameScore({ state, prevState }) {
  let scoreContainer = document.querySelector(".score");

  if (!scoreContainer) {
    scoreContainer = document.createElement("div");
    scoreContainer.classList.add("score");
    scoreContainer.classList.add("score-positive");
    document.body.appendChild(scoreContainer);
  }
  scoreContainer.innerHTML = state.currentScore;
}

function renderGameTimer(state) {
  let timerContainer = document.querySelector(".timer");

  if (!timerContainer) {
    timerContainer = document.createElement("div");
    timerContainer.classList.add("timer");
    document.body.appendChild(timerContainer);
  }
  let number = state.gameTimer,
    minutes = ("0" + Math.floor(number / 60)).slice(-2),
    seconds = ("0" + (number % 60)).slice(-2),
    timeString = `${minutes}:${seconds}`;

  timerContainer.innerHTML = timeString;
}

function renderGamePause({ state, prevState }) {
  let pauseContainer = document.querySelector(".pause");

  if (!pauseContainer) {
    pauseContainer = document.createElement("div");
    document.body.appendChild(pauseContainer);
  }

  if (state?.pause) {
    pauseContainer.classList.add("pause");
    pauseContainer.innerHTML = "PAUSE";
  } else {
    pauseContainer.classList.remove("pause");
    pauseContainer.innerHTML = "";
  }
}

function renderGameBoard({ state, prevState }, emit) {
  let meshContainer = document.querySelector(".mesh");

  if (!meshContainer) {
    meshContainer = document.createElement("div");
    meshContainer.classList.add("mesh");
    for (let x = 0; x < rows; x++) {
      let row = [];

      for (let y = 0; y < columns; y++) {
        const cell = document.createElement("div");
        cell.classList.add("item");
        meshContainer.appendChild(cell);
        document.body.appendChild(meshContainer);
        row.push(cell);
      }
      meshData.push(row);
    }

    emit("addNewFood", {
      newFoodPossition: getNewFoodPossition(state),
      isBooster: false,
    });

    setKeybordListeners(emit);
  }
  drawSnake({ prevState, state });
  drawFood({ prevState, state });

  return () => {
    drawSnake({ prevState, state }, false);
    drawFood({ prevState, state }, false);
  };
}

function getIsRoundChanged({ prevState, state }) {
  return (
    getIsStateChanged("round", { prevState, state }) && !getIsGameEnded(state)
  );
}

function moveSnakeBody(state) {
  let newBodyData = [...state.bodyData],
    head = [...newBodyData[0]];

  head[0] += state.direction[0];
  head[1] += state.direction[1];
  newBodyData.unshift(head);

  let foodObjectDetails = checkingFoodOnHead(newBodyData, state.foodObjects);

  if (!foodObjectDetails.isFoodEaten) {
    newBodyData.pop();
  }

  return newBodyData;
}

function checkingFoodOnHead(bodyArray, foodObjects) {
  let head = [...bodyArray[0]],
    isFoodEatenFlag = false,
    newFoodObjects = [],
    isBoostEatenFlag = false,
    foodBoostCoefficient;

  foodObjects.forEach((element) => {
    if (
      element?.possition[0] === head[0] &&
      element?.possition[1] === head[1]
    ) {
      isFoodEatenFlag = true;
      isBoostEatenFlag = element.isBooster;
      foodBoostCoefficient = element.foodBoostCoefficient;
    } else {
      newFoodObjects.push(element);
    }

    if (isFoodEatenFlag && isBoostEatenFlag) {
      console.log(newFoodObjects);
    }
  });

  return {
    isFoodEaten: isFoodEatenFlag,
    isBoostEaten: isBoostEatenFlag,
    foodObjects: [...newFoodObjects],
    foodBoostCoefficient: foodBoostCoefficient,
  };
}

function isFoodEaten({ state, prevState }, emit) {
  console.log("isFoodEaten: ", state.round);
  let foodObjectDetails = checkingFoodOnHead(
    [...state.bodyData],
    [...state.foodObjects]
  );

  if (foodObjectDetails.isFoodEaten) {
    emit("changeScore");
    emit("removeFood");
    emit("changeBoostCoefficient", foodObjectDetails.foodBoostCoefficient);

    if (!foodObjectDetails.isBoostEaten) {
      emit("addNewFood", {
        newFoodPossition: getNewFoodPossition(state),
        isBooster: false,
      });
    } else {
      let boostParams = {
        boostTimerToPubish: initialBoostTimerValue,
        boostPublishFlag: false,
      };
      emit("updateBoostParams", boostParams);
    }
  }
}

function renderGameAlert({ state, prevState }, emit) {
  let alert = document.querySelector(".alert");

  if (!alert) {
    alert = document.createElement("div");
    alert.classList.add("alert");
    alert.innerHTML = 'Game has ended. Press "Enter" to start again.';
    document.body.appendChild(alert);
  }

  const onAlertEnter = (e) => {
    if (e.key === "Enter") {
      emit("restartGame");
      emit("addNewFood", {
        newFoodPossition: getNewFoodPossition(state),
        isBooster: false,
      });
    }
  };

  if (state.gameOver) {
    document.addEventListener("keyup", onAlertEnter);
    alert.classList.add("alert-win");
  } else {
    alert.classList.remove("alert-win");
  }

  return () => {
    document.removeEventListener("keyup", onAlertEnter);
  };
}

function setKeybordListeners(emit) {
  const onKeyClick = (e) => {
    if (e.code === "Space") {
      emit("pressPause");
    } else {
      emit("changeDirection", e);
    }
  };
  document.addEventListener("keyup", onKeyClick);
}

function drawSnake({ prevState, state }, draw = true) {
  state.bodyData.forEach((element) => {
    let x = element[0],
      y = element[1];

    if (draw) {
      meshData[x][y].classList.add("snake-body");
    } else {
      meshData[x][y].classList.remove("snake-body");
    }
  });
}

function drawFood({ prevState, state }, draw = true) {
  state.foodObjects.forEach((element) => {
    let x = element.possition[0],
      y = element.possition[1],
      foodClassName = element.isBooster ? "food-booster-cell" : "food-cell";

    if (draw) {
      meshData[x][y].classList.add(foodClassName);
    } else {
      meshData[x][y].classList.remove(foodClassName);
    }
  });
}

function getIsStateChanged(stateKey, { prevState, state }) {
  return prevState?.[stateKey] !== state[stateKey];
}

function scalarProduct(a, b) {
  if (a.length !== b.length) {
    return 1;
  }

  let prod = 0;
  for (let index = 0; index < a.length; index++) {
    prod += a[index] * b[index];
  }
  return prod;
}

function getIsGameEnded(state) {
  return state.gameOver;
}

function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

function getNewDirection(state, e) {
  let proposedDirection = state.direction;

  switch (e.code) {
    case "ArrowRight":
      proposedDirection = [0, 1]; // [y, x]
      break;
    case "ArrowLeft":
      proposedDirection = [0, -1]; // [y, x]
      break;
    case "ArrowDown":
      proposedDirection = [1, 0]; // [-y, x]
      break;
    case "ArrowUp":
      proposedDirection = [-1, 0]; // [y, x]
      break;
  }

  if (scalarProduct(state.direction, proposedDirection) === 0) {
    return proposedDirection;
  }

  return state.direction;
}

function getIsPauseUnlocked({ prevState, state }) {
  return prevState?.pause && !state.pause;
}

function getNewFoodPossition(state) {
  while (true) {
    let x = getRandomNumber(rows),
      y = getRandomNumber(columns),
      occlude = false,
      newPossition = [x, y];

    state.foodObjects.forEach((element) => {
      if (element[0] === newPossition[0] && element[1] === newPossition[1]) {
        occlude = true;
      }
    });

    state.bodyData.forEach((element) => {
      if (element[0] === newPossition[0] && element[1] === newPossition[1]) {
        occlude = true;
      }
    });

    if (occlude === false) {
      return newPossition;
    }
  }
}

function checkIsGameEnded(state) {
  let endGameFlag = false,
    head = [...state.bodyData[0]];

  if (!(0 <= head[0] && head[0] < rows && 0 <= head[1] && head[1] < columns)) {
    //check out of mesh
    return true;
  }

  let body = [...state.bodyData.slice(1)]; // get body without head

  body.forEach((element) => {
    if (head[0] === element[0] && head[1] === element[1]) {
      // check on the body
      endGameFlag = true;
      return true;
    }
  });

  if (state.gameTimer <= 0) {
    return true;
  }

  return endGameFlag;
}

// Good luck!
