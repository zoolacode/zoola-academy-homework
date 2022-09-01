import { createEngine, ENGINE_INITIALIZE_SIGNAL } from '../engine/engine';

const boardWidth = 25;
const meshSize = boardWidth ** 2;
const timerLimitMs = 120900;
const bonusTimerLimitMs = 5900;
const initialSnakeCoords = [
  getIndex(10, 10),
  getIndex(10, 11),
  getIndex(10, 12),
  getIndex(10, 13),
  getIndex(10, 14),
];

const initialState = {
  snakeHead: {
    x: 10,
    y: 14,
  },
  currentScore: 0,
  gameTimer: timerLimitMs,
  direction: 'moveDown',
  gameLost: false,
  gameOn: true,
  snakeCoords: initialSnakeCoords,
  dish: getRandomDishPosition(initialSnakeCoords, undefined, undefined),
  bonusDish: undefined,
  burnBonusTime: bonusTimerLimitMs,
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer('restartGame', () => {
  return {
    ...initialState,
    dish: getRandomDishPosition(initialSnakeCoords, undefined, undefined),
    bonusDish: undefined,
    gameTimer: timerLimitMs,
    burnBonusTime: bonusTimerLimitMs,
  };
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('snakeHead', { prevState, state }) ||
    getIsStateChanged('gameOn', { prevState, state }),
  effect: ({ state }, emit) => {
    if (!state.gameOn || state.gameLost) {
      return;
    }

    const timeoutId = setTimeout(() => {
      emit('moveSnake');
    }, 100);

    return () => {
      clearTimeout(timeoutId);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('gameTimer', { prevState, state }),
  effect: ({ state }, emit) => {
    if (state.burnBonusTime < 1000) {
      emit('giveBonusDish');
    }
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('gameTimer', { prevState, state }) ||
    getIsStateChanged('gameOn', { prevState, state }),
  effect: ({ state }, emit) => {
    if (!state.gameOn || state.gameLost) {
      return;
    }

    const timeoutId = setTimeout(() => {
      emit('burnGameTime');
    }, 100);

    return () => {
      clearTimeout(timeoutId);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('gameLost', { prevState, state }),
  effect: renderGameAlert,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('currentScore', { prevState, state }),
  effect: renderGameScore,
});

engine.addSideEffect({
  effect: renderGameBoard,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('gameTimer', { prevState, state }),
  effect: renderGameTimer,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('burnBonusTime', { prevState, state }),
  effect: renderGameBonusTimer,
});

engine.addSideEffect({
  effect: renderSnakeDish,
});

engine.addSignalReducer('burnGameTime', (state) => {
  if (state.gameTimer < 1000) {
    return {
      ...state,
      gameLost: true,
      snakeCoords: [],
      dish: undefined,
      bonusDish: undefined,
      burnBonusTime: bonusTimerLimitMs,
    };
  } else {
    return {
      ...state,
      gameTimer: state.gameTimer - 100,
      burnBonusTime:
        state.burnBonusTime < 1000
          ? bonusTimerLimitMs
          : state.burnBonusTime - 100,
    };
  }
});

addMovement(engine, {
  targetDirection: 'moveRight',
  oppositeDirection: 'moveLeft',
});
addMovement(engine, {
  targetDirection: 'moveLeft',
  oppositeDirection: 'moveRight',
});
addMovement(engine, {
  targetDirection: 'moveUp',
  oppositeDirection: 'moveDown',
});
addMovement(engine, {
  targetDirection: 'moveDown',
  oppositeDirection: 'moveUp',
});

engine.addSignalReducer('pauseGame', (state) => {
  return {
    ...state,
    gameOn: !state.gameOn,
  };
});

engine.addSignalReducer('moveSnake', (state) => {
  const movements = {
    moveUp: ({ x, y }) => ({ x, y: y - 1 }),
    moveDown: ({ x, y }) => ({ x, y: y + 1 }),
    moveRight: ({ x, y }) => ({ x: x + 1, y }),
    moveLeft: ({ x, y }) => ({ x: x - 1, y }),
  };
  const move = movements[state.direction];
  const nextSnakeHead = move(state.snakeHead);
  const borderWidth = 26;
  const isSnakeHitBorders =
    nextSnakeHead.x === borderWidth ||
    nextSnakeHead.y === borderWidth ||
    nextSnakeHead.x === 0 ||
    nextSnakeHead.y === 0;
  const isSnakeHitBody = state.snakeCoords.includes(
    getIndex(nextSnakeHead.x, nextSnakeHead.y)
  );

  if (isSnakeHitBody || isSnakeHitBorders) {
    return {
      ...state,
      gameLost: true,
      dish: undefined,
      bonusDish: undefined,
      burnBonusTime: bonusTimerLimitMs,
    };
  }

  let catchDishPoint;
  const snakeLength = state.snakeCoords.length;
  const snakeHeadCoordinates = [...state.snakeCoords][snakeLength - 1];
  const newData =
    state.dish === snakeHeadCoordinates ||
    state.bonusDish === snakeHeadCoordinates
      ? [...state.snakeCoords]
      : state.snakeCoords.slice(1, snakeLength);

  if (state.dish === snakeHeadCoordinates) {
    catchDishPoint = 1;
  } else if (state.bonusDish === snakeHeadCoordinates) {
    catchDishPoint = 5;
  }

  return {
    ...state,
    snakeHead: nextSnakeHead,
    currentScore:
      state.dish === snakeHeadCoordinates ||
      state.bonusDish === snakeHeadCoordinates
        ? state.currentScore + catchDishPoint
        : state.currentScore,
    snakeCoords: [...newData, getIndex(nextSnakeHead.x, nextSnakeHead.y)],
    dish:
      state.dish === snakeHeadCoordinates
        ? getRandomDishPosition(state.snakeCoords, state.dish, state.bonusDish)
        : state.dish,
    bonusDish:
      state.bonusDish === snakeHeadCoordinates ? undefined : state.bonusDish,
  };
});

engine.addSignalReducer('giveBonusDish', (state) => {
  if (getIsGameEnded(state)) {
    return state;
  }
  const nextBonusDish = getRandomDishPosition(
    state.snakeCoords,
    state.dish,
    state.bonusDish
  );

  return {
    ...state,
    bonusDish: nextBonusDish,
  };
});

engine.start();

function renderGameAlert({ state }, emit) {
  let alert = document.querySelector('.alert');

  if (!alert) {
    alert = document.createElement('div');
    alert.classList.add('alert');
    alert.innerHTML = 'Game has ended. Press "Enter" to start again';
    document.body.appendChild(alert);
  }

  const onAlertEnter = (e) => {
    if (e.key === 'Enter') {
      emit('restartGame');
    }
  };

  if (state.gameLost) {
    document.addEventListener('keyup', onAlertEnter);
    alert.classList.add('alert-loss');
  }

  return () => {
    alert.classList.remove('alert-loss');
    document.removeEventListener('keyup', onAlertEnter);
  };
}

function renderGameScore({ state }) {
  let scoreContainer = document.querySelector('.score');
  let gameContainer = document.querySelector('.game-container');

  if (!scoreContainer) {
    scoreContainer = document.createElement('div');
    scoreContainer.classList.add('score');
    gameContainer.appendChild(scoreContainer);
  }

  scoreContainer.innerHTML = state.currentScore;
}

function renderGameTimer({ state }) {
  let gameTimer = document.querySelector('.timer');
  let gameContainer = document.querySelector('.game-container');

  if (!gameTimer) {
    let timerContainer = document.createElement('div');
    timerContainer.classList.add('game-timer-container');
    gameContainer.appendChild(timerContainer);
    gameTimer = document.createElement('div');
    gameTimer.classList.add('timer');
    timerContainer.appendChild(gameTimer);
  }

  if (state.gameTimer < 10000) {
    gameTimer.classList.remove('timer-positive');
    gameTimer.classList.add('timer-negative');
  } else {
    gameTimer.classList.remove('timer-negative');
    gameTimer.classList.add('timer-positive');
  }

  const mins = convertToMins(state.gameTimer);
  const secs = convertToSecs(state.gameTimer);

  gameTimer.innerHTML = `${mins}:${secs < 10 ? '0' : ''}${secs}`;
}

function renderGameBonusTimer({ state }) {
  let gameBonusTimer = document.querySelector('.bonus-timer');
  let gameTimerContainer = document.querySelector('.game-timer-container');

  if (!gameBonusTimer) {
    gameBonusTimer = document.createElement('div');
    gameBonusTimer.classList.add('bonus-timer');
    gameTimerContainer.appendChild(gameBonusTimer);
  }

  const mins = convertToMins(state.burnBonusTime);
  const secs = convertToSecs(state.burnBonusTime);

  gameBonusTimer.innerHTML = `${mins}:${secs < 10 ? '0' : ''}${secs}`;

  if (state.bonusDish === undefined) {
    gameBonusTimer.classList.remove('bonus-timer');
    gameBonusTimer.innerHTML = '';
  }
}

function renderGameBoard({ state }, emit) {
  let meshContainer = document.querySelector('.mesh');
  let gameContainer = document.querySelector('.game-container');

  if (!meshContainer) {
    meshContainer = document.createElement('div');
    meshContainer.classList.add('mesh');
    for (let i = 0; i < meshSize; i++) {
      const cell = document.createElement('div');
      cell.classList.add('item');
      meshContainer.appendChild(cell);
    }
    gameContainer.appendChild(meshContainer);
  }

  state.snakeCoords.forEach((snakeCoord) =>
    meshContainer.children[snakeCoord].classList.add('snake-body')
  );

  if (Boolean(state.gameLost)) {
    state.snakeCoords.forEach((snakeCoord) => {
      meshContainer.children[snakeCoord].classList.remove('snake-body');
      meshContainer.children[snakeCoord].classList.add('snake-dead');
    });
  }

  const onKeyBoardClick = (clickEvent) => {
    switch (clickEvent.code) {
      case 'ArrowRight':
        emit('moveRight');
        break;
      case 'ArrowLeft':
        emit('moveLeft');
        break;
      case 'ArrowDown':
        emit('moveDown');
        break;
      case 'ArrowUp':
        emit('moveUp');
        break;
      case 'Space':
        emit('pauseGame');
        state.gameOn
          ? document.body.classList.add('pause')
          : document.body.classList.remove('pause');
        break;
      default:
        break;
    }
  };

  document.addEventListener('keydown', onKeyBoardClick);

  return () => {
    state.snakeCoords.forEach((snakeCoord) => {
      meshContainer.children[snakeCoord].classList.remove('snake-body');
      meshContainer.children[snakeCoord].classList.remove('snake-dead');
    });
    document.removeEventListener('keydown', onKeyBoardClick);
  };
}

function renderSnakeDish({ state }) {
  let meshContainer = document.querySelector('.mesh');
  meshContainer.children[state.dish]?.classList.add('active-dish');
  meshContainer.children[state.bonusDish]?.classList.add('active-bonus-dish');

  return () => {
    meshContainer.children[state.dish]?.classList.remove('active-dish');
    meshContainer.children[state.bonusDish]?.classList.remove(
      'active-bonus-dish'
    );
  };
}

function addMovement(framework, { ...direction }) {
  framework.addSignalReducer(direction.targetDirection, (state) => {
    if (state.direction !== direction.oppositeDirection) {
      return {
        ...state,
        direction: direction.targetDirection,
      };
    }

    return state;
  });
}

function getRandomDishPosition(snakeCoords, dish, bonusDish) {
  let items = [];
  for (let i = 0; i < meshSize; i++) {
    if (!snakeCoords.includes(i) && !dish !== i && !bonusDish !== i) {
      items.push(i);
    }
  }

  let result = items[Math.floor(Math.random() * items.length)];

  return result;
}

function getIsGameEnded(state) {
  return state.gameLost;
}

function getIsStateChanged(stateKey, { prevState, state }) {
  return prevState?.[stateKey] !== state[stateKey];
}

function getIndex(x, y) {
  return y * 25 - (25 - x) - 1;
}

function convertToMins(value) {
  const mins = Math.floor(value / (60 * 1000));

  return mins;
}

function convertToSecs(value) {
  const secs = Math.floor((value / 1000) % 60);

  return secs;
}
