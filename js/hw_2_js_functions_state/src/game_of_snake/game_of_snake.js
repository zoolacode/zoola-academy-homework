import { createEngine, ENGINE_INITIALIZE_SIGNAL } from '../engine/engine';

const boardWidth = 25;
const meshSize = boardWidth ** 2;
const timerLimitMs = 120000;

const bonusDishLifeTime = 5000;
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
  gameTimer: 0,
  direction: 'moveDown',
  gameLost: false,
  gameOn: true,
  snakeCoords: initialSnakeCoords,
  dish: getRandomDishPosition(initialSnakeCoords, null, null),
  bonusDish: null,
  bonusDishExpiresTime: 0,
  speedUp: false,
  portal: [],
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer('restartGame', () => {
  return {
    ...initialState,
    dish: getRandomDishPosition(initialSnakeCoords, null, null),
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

    if (state.speedUp) {
      const timeoutId = setTimeout(() => {
        emit('moveSnake');
      }, 50);

      return () => {
        clearTimeout(timeoutId);
      };
    } else {
      const timeoutId = setTimeout(() => {
        emit('moveSnake');
      }, 100);

      return () => {
        clearTimeout(timeoutId);
      };
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

    if (state.gameTimer % bonusDishLifeTime === 0 && state.gameTimer !== 0) {
      emit('giveBonusDish');
      emit('openPortal');
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
    getIsStateChanged('gameTimer', { prevState, state }),
  effect: renderGameBonusTimer,
});

engine.addSideEffect({
  effect: renderSnakeDish,
});

engine.addSideEffect({
  effect: renderPortal,
});

engine.addSignalReducer('burnGameTime', (state) => {
  if (state.gameTimer === timerLimitMs) {
    return {
      ...state,
      gameLost: true,
      dish: null,
      bonusDish: null,
      bonusDishExpiresTime: 0,
      portal: [],
    };
  } else {
    return {
      ...state,
      gameTimer: state.gameTimer + 100,
      bonusDish:
        state.bonusDishExpiresTime === state.gameTimer ? null : state.bonusDish,
    };
  }
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
    bonusDishExpiresTime: state.gameTimer + bonusDishLifeTime,
  };
});

engine.addSignalReducer('openPortal', (state) => {
  if (getIsGameEnded(state)) {
    return state;
  }
  const nextPortal = [
    getRandomDishPosition(state.snakeCoords, state.dish, state.bonusDish),
    getRandomDishPosition(state.snakeCoords, state.dish, state.bonusDish),
  ];

  return {
    ...state,
    portal: nextPortal,
  };
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
  const borderWidth = 25;
  const isSnakeHitBorders =
    nextSnakeHead.x > borderWidth ||
    nextSnakeHead.y > borderWidth ||
    nextSnakeHead.x === 0 ||
    nextSnakeHead.y === 0;
  const isSnakeHitBody = state.snakeCoords.includes(
    getIndex(nextSnakeHead.x, nextSnakeHead.y)
  );

  if (isSnakeHitBody || isSnakeHitBorders) {
    return {
      ...state,
      gameLost: true,
      dish: null,
      bonusDish: null,
      bonusDishExpiresTime: 0,
      portal: [],
    };
  }

  const snakeLength = state.snakeCoords.length;
  const snakeHeadCoordinates = [...state.snakeCoords][snakeLength - 1];
  const hasEatenDish = getHasEatenDish(snakeHeadCoordinates, state.dish);
  const hasEatenBonusDish = getHasEatenBonusDish(
    snakeHeadCoordinates,
    state.bonusDish
  );
  const hasHitPortal = getHasHitPortal(snakeHeadCoordinates, state.portal);
  const newData =
    hasEatenDish || hasEatenBonusDish
      ? [...state.snakeCoords]
      : state.snakeCoords.slice(1, snakeLength);
  const nextScore = getNextScore(
    state.currentScore,
    hasEatenDish,
    hasEatenBonusDish
  );
  const newSnakeHead = getNewSnakeHead(snakeHeadCoordinates, state.portal);

  return {
    ...state,
    snakeHead: hasHitPortal ? newSnakeHead : nextSnakeHead,
    currentScore: nextScore,
    snakeCoords: [...newData, getIndex(nextSnakeHead.x, nextSnakeHead.y)],
    dish: hasEatenDish
      ? getRandomDishPosition(state.snakeCoords, state.dish, state.bonusDish)
      : state.dish,
    bonusDish: hasEatenBonusDish ? null : state.bonusDish,
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

  if (state.gameTimer > 110000) {
    gameTimer.classList.remove('timer-positive');
    gameTimer.classList.add('timer-negative');
  } else {
    gameTimer.classList.remove('timer-negative');
    gameTimer.classList.add('timer-positive');
  }

  const { min, sec } = getMinSec(timerLimitMs - state.gameTimer + 900);
  const timeStr = getTimeString(min, sec);

  gameTimer.innerHTML = timeStr;
}

function renderGameBonusTimer({ state }) {
  let gameBonusTimer = document.querySelector('.bonus-timer');
  let gameTimerContainer = document.querySelector('.game-timer-container');

  if (!gameBonusTimer) {
    gameBonusTimer = document.createElement('div');
    gameBonusTimer.classList.add('bonus-timer');
    gameTimerContainer.appendChild(gameBonusTimer);
  }

  const { min, sec } = getMinSec(
    bonusDishLifeTime - (state.gameTimer % bonusDishLifeTime) + 900
  );
  const timeStr = getTimeString(min, sec);

  gameBonusTimer.innerHTML = timeStr;

  if (state.bonusDish === null) {
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

  if (state.speedUp) {
    state.snakeCoords.forEach((snakeCoord) =>
      meshContainer.children[snakeCoord].classList.add('speed-up')
    );
  } else {
    state.snakeCoords.forEach((snakeCoord) =>
      meshContainer.children[snakeCoord].classList.add('snake-body')
    );
  }

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
      meshContainer.children[snakeCoord].classList.remove('speed-up');
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

function renderPortal({ state }) {
  let meshContainer = document.querySelector('.mesh');
  state.portal.forEach((portalCoord) =>
    meshContainer.children[portalCoord].classList.add('portal')
  );

  return () => {
    state.portal.forEach((portalCoord) =>
      meshContainer.children[portalCoord].classList.remove('portal')
    );
  };
}

function addMovement(framework, { ...direction }) {
  framework.addSignalReducer(direction.targetDirection, (state) => {
    const speedUpCondition = getSpeedUpCondition(
      state.direction,
      direction.targetDirection
    );

    if (state.direction !== direction.oppositeDirection) {
      return {
        ...state,
        direction: direction.targetDirection,
        speedUp: speedUpCondition ? true : false,
      };
    }

    return state;
  });
}

function getRandomDishPosition(snakeCoords, dish, bonusDish) {
  const items = [...Array(meshSize)]
    .map((_, index) => index)
    .filter(
      (coord) =>
        !snakeCoords.includes(coord) && dish !== coord && bonusDish !== coord
    );

  return items[Math.floor(Math.random() * items.length)];
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

function getCoords(index) {
  const x = (index % 25) + 1;
  const y = index / 25 + 1;

  return { x, y };
}

function getMinSec(value) {
  const min = Math.floor(value / (60 * 1000));
  const sec = Math.floor((value / 1000) % 60);

  return { min, sec };
}

function getTimeString(min, sec) {
  return `${min}:${sec < 10 ? '0' : ''}${sec}`;
}

function getHasEatenDish(snakeHeadCoords, dishCoords) {
  return dishCoords === snakeHeadCoords;
}

function getHasEatenBonusDish(snakeHeadCoords, bonusDishCoords) {
  return bonusDishCoords === snakeHeadCoords;
}

function getNextScore(score, hasEatenDish, hasEatenBonusDish) {
  const dishPoint = 1;
  const bonusDishPoint = 5;

  if (hasEatenDish) {
    score += dishPoint;
  } else if (hasEatenBonusDish) {
    score += bonusDishPoint;
  }

  return score;
}

function getSpeedUpCondition(currentDirection, nextDirection) {
  return currentDirection === nextDirection;
}

function getHasHitPortal(snakeHeadCoords, portalCoords) {
  return portalCoords.includes(snakeHeadCoords);
}

function getNewSnakeHead(coords, portalCoords) {
  const hittedPortalIndex = portalCoords.indexOf(coords);
  const snakeHead = getCoords(portalCoords[hittedPortalIndex === 0 ? 1 : 0]);

  return {
    x: snakeHead.x,
    y: Math.floor(snakeHead.y),
  };
}
