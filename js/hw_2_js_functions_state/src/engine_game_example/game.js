import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";

const meshSize = 25;

const initialState = {
  currentColor: { },
  currentScore: 0,
  currentIndex: 0,
  round: 0,
  gameWon: false,
  gameLost: false,
  shouldRestart: false,
  clickData: null,
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer("restartGame", () => {
  return initialState;
});


engine.addSideEffect({
  onlyWhen: getIsRoundChanged,
  effect: (_, emit) => {
    emit("startNextRound");
    const timeoutId = setTimeout(() => {
      emit("roundTimedOut");
    }, 1000);
    
    return () => {
      clearTimeout(timeoutId);
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
  effect: renderGameBoard,
});

engine.addGlobalReducer((state) => {
  const winScore = 5;
  const lossScore = -10;

  if (state.currentScore >= winScore) {
    return {
      ...state,
      gameWon: true,
    };
  } else if (state.currentScore <= lossScore) {
    return {
      ...state,
      gameLost: true,
    };
  }
  return state;
});

engine.addSignalReducer("roundTimedOut", (state) => {
  if (getIsGameEnded(state)) {
    return state;
  }

  const timeoutPenalty = 3;

  return {
    ...state,
    currentScore: state.currentScore - timeoutPenalty,
    round: state.round + 1,
  };
});

engine.addSignalReducer("misclick", (state) => {
  if (getIsGameEnded(state)) {
    return state;
  }

  const misclickPenalty = 5;

  return {
    ...state,
    currentScore: state.currentScore - misclickPenalty,
  };
});

engine.addSignalReducer("startNextRound", (state) => {
  const prevIndex = state.currentIndex;
  const nextIndex = getRandomNumber(meshSize - 1);

  return {
    ...state,
    currentIndex:
      nextIndex === prevIndex
        ? shiftIndexForward(nextIndex, meshSize - 1)
        : nextIndex,
    currentColor: {
      r: getRandomNumber(255),
      g: getRandomNumber(255),
      b: getRandomNumber(255),
    },
  };
});

engine.addSignalReducer("clickOnTarget", (state, clickData) => {
  if (getIsGameEnded(state)) {
    return state;
  }

  const clickOnTargetBonus = 1;

  return {
    ...state,
    currentScore: state.currentScore + clickOnTargetBonus,
    round: state.round + 1,
    clickData,
  };
});

engine.addSideEffect({
  effect: ({ state }) => {
    console.log(state.clickData);
  },
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

  if (state.currentScore < 0) {
    scoreContainer.classList.remove("score-positive");
    scoreContainer.classList.add("score-negative");
  } else {
    scoreContainer.classList.remove("score-negative");
    scoreContainer.classList.add("score-positive");
  }

  scoreContainer.innerHTML = state.currentScore;
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
    }
  }

  const activeElement = meshContainer.children[state.currentIndex];
  activeElement.setAttribute(
    "style",
    `background-color: rgba(${state.currentColor.r}, ${state.currentColor.g}, ${state.currentColor.b})`
  );

  const onElementClick = (clickEvent) => {
    clickEvent.stopPropagation();

  
    emit("clickOnTarget", { x: clickEvent.x, y: clickEvent.y });
  };
  activeElement.addEventListener("click", onElementClick);

  const onDocumentClick = () => {
    emit("misclick");
  };
  document.addEventListener("click", onDocumentClick);

  return () => {
    activeElement.setAttribute("style", "");
    activeElement.removeEventListener("click", onElementClick);

    document.removeEventListener("click", onDocumentClick);
  };
}

function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}


function shiftIndexForward(currentIndex, maxIndex) {
  return (currentIndex + 1) % maxIndex;
}

function getIsGameEnded(state) {
  return state.gameWon || state.gameLost;
}

function getIsStateChanged(stateKey, { prevState, state }) {
 
  return prevState?.[stateKey] !== state[stateKey];
}

function getIsRoundChanged({ prevState, state }) {
  return (
    getIsStateChanged("round", { prevState, state }) && !getIsGameEnded(state)
  );
}
