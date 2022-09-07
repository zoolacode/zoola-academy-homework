// In comments below I refer to "createEngine" as "framework"
import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";

const meshSize = 25;
const colors = ['white', 'black', 'silver', 'gray', 'maroon', 'red', 'purple', 'fuchsia',
  'green', 'lime', 'olive', 'yellow', 'navy', 'blue', 'teal', 'aqua']

const initialState = {
  bodyColorIndex: 0,
  currentColor: {
    r: 0,
    g: 0,
    b: 0,
  },
  currentScore: 0,
  currentIndex: 0,
  round: 0,
  gameWon: false,
  gameLost: false,
  shouldRestart: false,

  // This property is not involved in any business logic, it is there only for demonstration purposes.
  clickData: null,
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer("restartGame", () => {
  return initialState;
});

// The following effect has a big role because it emits "startNextRound" signal.
// Notice how it only triggers it when "round" has changed and while that game is not ended yet.
//
// IMPORTANT
//
// A valid question could be asked here: "why is it that we couldn't just use "clickOnTarget" to create a new element index and colors?".
// Doesn't "clickOnTarget" trigger next round already?
// - It is true, "clickOnTarget" does increment "round", but the problem is FIRST round - nobody triggers it, it just starts (in the current implementation anyways).
//
// The next question should be: "then why don't we just merge "clickOnTarget" logic into "startNextRound" reducer and remove "clickOnTarget" altogether?".
// - We could to it, there's nothing wrong about this idea. I encourage you to try and do it yourself, it's good practice. But "clickOnTargetBonus" wouldn't be a great name, then.
engine.addSideEffect({
  onlyWhen: getIsRoundChanged,
  // Notice how we name the first parameter as "_". We could name it properly but it's not used here (only "emit" is used), so "_" is okay.
  effect: (_, emit) => {
    emit("startNextRound");
  },
});

// This effect has the same "onlyWhen" condition function as the previous one, so they could easily be merged. Try it out yourself!
engine.addSideEffect({
  onlyWhen: getIsRoundChanged,
  effect: (_, emit) => {
    const timeoutId = setTimeout(() => {
      emit("roundTimedOut");
    }, 1000);

    return () => {
      clearTimeout(timeoutId);
    };
  },
});

// Thanks to our signal-based framework, we can now safely split all rendering logic.
// Pay attention to the fact that each rendering function has its own condition as to WHEN it gets called.
// For example "alert" rendering only happens when "gameWon" or "gameLost" state has changed, and "score" - only when "currentScore" is changed.
// This is a minor detail but it can have major implications in terms of application performance.
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

/**
 * IMPORTANT
 *
 * The commented block below is an alternative "game end" detection approach which is there to show how the same thing can be achieved by different means.
 * It shows that if something can be achieved by reducer only, it should be done this way instead of by creating additional side effects.
 */

/*
// This effect keeps track of the "currentScore" and triggers "gameWon" or "gameLost" signal.
// Notice how these signals are used to set "gameWon" and "gameLost" state down the line, which creates a strong feeling of tautology.
// Much better would be to use a "global" reducer function that can calculate "gameWon" and "gameLost" whenever "currentScore" is changed.
// The reason we don't want to add this calculation into EVERY reducer function that changes "currentScore" is that it would create unnecessary code duplication.

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged("currentScore", prevState, state) &&
    !getIsGameEnded(state),
  effect: ({ state, prevState }, emit) => {
    const winScore = 5;
    const lossScore = -10;

    if (state.currentScore >= winScore) {
      emit("gameWon");
    } else if (state.currentScore <= lossScore) {
      emit("gameLost");
    }
  },
});

engine.addStateReducer("gameWon", (state) => {
  return {
    ...state,
    gameWon: true,
  };
});

engine.addStateReducer("gameLost", (state) => {
  return {
    ...state,
    gameLost: true,
  };
});
*/

// Global reducers are called in the same order they were added, but only AFTER signal-based reducer has been called.
// For example, when "roundTimedOut" signal was emitted, "currentScore" will be lowered FIRST, and only then the global reducer will determine if game has ended.
engine.addGlobalReducer((state) => {
  const winScore = 5;
  const lossScore = -10;

  if (state.currentScore >= winScore) {
    // Notice how we NEVER change state like this:
    //    state.gameWon = true
    //    return state
    //
    // Our framework detects change based on === operator. It literally does the following:
    //    if (prevState !== nextState) {
    //      runSideEffects()
    //    }
    // So if we make changes to the current "state" object, our framework won't pick them up right away.
    // If we want to inform the framework that changes were made - we create a copy of current state and make our changes there.
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

  // Notice how reducer informs the framework that nothing has changed by returning the same "state" object it was passed.
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

    // This can be safely removed if you want to refactor, it's here for demonstration purposes only.
    clickData,
  };
});

// This can be safely removed if you want to refactor, it's here for demonstration purposes only.
// It merely logs click data in console, nothing crazy.
// Notice how this effect does not have "onlyWhen" prop informing the framework that it should run whenever anything changed
engine.addSideEffect({
  effect: ({ state }) => {
    console.log(state.clickData);
  },
});

engine.addSideEffect({
  onlyWhen: getIsRoundChanged,
  effect: (_, emit) => {
    emit("changedBodyColor")
  }
})

engine.addSignalReducer("changedBodyColor", (state) => {
  const colorIndex = getRandomNumber(colors.length - 1)
  return {
    ...state,
    bodyColorIndex: colorIndex
  }
})

engine.addSideEffect({ effect: ({ state }) => console.log(state) })

// Start engine :)
// It is strongly recommended to start after all reducers and side-effects have been registered.
engine.start();

// Not all side effects publish (emit) signals, some just do what they need to do
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

    // Although it is not required by our functionality right now, IT IS POSSIBLE to pass second parameter to "emit" in order to get access to it in reducer.
    // I recommend investigating this approach further, as it can become very handy in more complex scenarios.
    // Here it is made only in demonstration purposes - there's no real need in "clickData" in our application.
    emit("clickOnTarget", { x: clickEvent.x, y: clickEvent.y });
  };
  activeElement.addEventListener("click", onElementClick);

  const onDocumentClick = () => {
    emit("misclick");
  };
  document.addEventListener("click", onDocumentClick);

  const body = window.document.body
  body.setAttribute(
    "style",
    `background-color: ${colors[state.bodyColorIndex]}`
  );

  return () => {
    activeElement.setAttribute("style", "");
    activeElement.removeEventListener("click", onElementClick);

    // Although it seems like we don't want to add/remove document event listeners every time something changed, it is a good practice,
    //  because we don't know at which moment our game will terminate (stop existing) and we don't want anything left behind.
    // Framework relies on us proving clean-up logic, we rely on framework to execute it when needed.
    document.removeEventListener("click", onDocumentClick);
  };
}

function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

// Alternatively, this function could be named "getShiftedForwardIndex", to avoid "imperative" tone
function shiftIndexForward(currentIndex, maxIndex) {
  return (currentIndex + 1) % maxIndex;
}

// Functions that return boolean can be named like this - "get" + "is something true" - meaning that they return boolean value.
// In this case it is "get" + "is game ended".
// It may sound a bit weird, but it's a decent approach to naming boolean-returing pure functions.
function getIsGameEnded(state) {
  return state.gameWon || state.gameLost;
}

function getIsStateChanged(stateKey, { prevState, state }) {
  // We already know that during the first run, prevState equals undefined, so we need to make sure our code does not break.
  // This syntax is called "optional chaining" and it helps us read a value or call a function that MIGHT be undefined.
  // Alternatively, we could write it this way: prevState && prevState[stateKey]
  // With functions, it works similarly: doSomething?.()
  // Alternative way: doSomething && doSomething
  // Even better alternative way: typeof doSomething === 'function' && doSomething()
  // Also, with dot-notation in objects it would look like this: someObject?.someKey, or someObject?.['someKey']
  //
  // Optional chaining is widely used these days and you should know this syntax and what it does.
  return prevState?.[stateKey] !== state[stateKey];
}

function getIsRoundChanged({ prevState, state }) {
  return (
    getIsStateChanged("round", { prevState, state }) && !getIsGameEnded(state)
  );
}


