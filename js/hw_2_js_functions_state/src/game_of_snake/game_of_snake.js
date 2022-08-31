import { createEngine, ENGINE_INITIALIZE_SIGNAL } from '../engine/engine';

const meshSize = 625;
const timerLimitMs = 120000;
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
  round: 0,
  direction: 'moveDown',
  gameLost: false,
  gameOn: true,
  snakeCoords: initialSnakeCoords,
  dishIndexes: [getRandomDishPosition([], initialSnakeCoords)],
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer('restartGame', () => {
  return {
    ...initialState,
    dishIndexes: [getRandomDishPosition([], initialSnakeCoords)],
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
    getIsStateChanged('round', { prevState, state }) ||
    getIsStateChanged('gameOn', { prevState, state }),
  effect: ({ state }, emit) => {
    if (!state.gameOn) {
      return;
    }

    const timeoutId = setTimeout(() => {
      emit('giveNewDish');
    }, 15000);

    return () => {
      clearTimeout(timeoutId);
    };
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
      emit('startTimer');
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
  effect: renderGameTimer,
});

engine.addSideEffect({
  effect: renderSnakeDish,
});

engine.addGlobalReducer((state) => {
  if (state.gameTimer < 1000) {
    return {
      ...state,
      gameLost: true,
      snakeCoords: [],
      dishIndexes: [],
    };
  }

  return state;
});

engine.addSignalReducer('startTimer', (state) => {
  return {
    ...state,
    gameTimer: state.gameTimer - 100,
  };
});

engine.addSignalReducer('moveRight', (state) => {
  if (state.direction !== 'moveLeft') {
    return {
      ...state,
      direction: 'moveRight',
    };
  }

  return state;
});

engine.addSignalReducer('moveLeft', (state) => {
  if (state.direction !== 'moveRight') {
    return {
      ...state,
      direction: 'moveLeft',
    };
  }

  return state;
});

engine.addSignalReducer('moveDown', (state) => {
  if (state.direction !== 'moveUp') {
    return {
      ...state,
      direction: 'moveDown',
    };
  }

  return state;
});

engine.addSignalReducer('moveUp', (state) => {
  if (state.direction !== 'moveDown') {
    return {
      ...state,
      direction: 'moveUp',
    };
  }

  return state;
});

engine.addSignalReducer('pauseGame', (state) => {
  return {
    ...state,
    gameOn: !state.gameOn,
  };
});

engine.addSignalReducer('moveSnake', (state) => {
  const prevSnakeHead = { ...state.snakeHead };
  let x = prevSnakeHead.x;
  let y = prevSnakeHead.y;

  switch (state.direction) {
    case 'moveDown':
      y++;
      break;
    case 'moveUp':
      y--;
      break;
    case 'moveRight':
      x++;
      break;
    case 'moveLeft':
      x--;
      break;

    default:
      break;
  }

  const nextSnakeHead = {
    x,
    y,
  };

  const minBorderCoords = 0;
  const maxBorderCoords = 26;
  const isSnakeHitBorders =
    x === maxBorderCoords ||
    y === maxBorderCoords ||
    x === minBorderCoords ||
    y === minBorderCoords;
  const isSnakeHitBody = state.snakeCoords.includes(getIndex(x, y));

  if (isSnakeHitBody || isSnakeHitBorders) {
    return {
      ...state,
      gameLost: true,
      snakeCoords: [],
      dishIndexes: [],
    };
  }

  const catchDishPoint = 1;
  const snakeLength = state.snakeCoords.length;
  const snakeHeadCoordinates = [...state.snakeCoords][snakeLength - 1];
  const prevStateDishIndexes = [...state.dishIndexes];
  const indexDishToRemove = prevStateDishIndexes.indexOf(snakeHeadCoordinates);
  const newData = state.dishIndexes.includes(snakeHeadCoordinates)
    ? [...state.snakeCoords]
    : [...state.snakeCoords].slice(1, snakeLength);

  if (indexDishToRemove > -1) {
    prevStateDishIndexes.splice(indexDishToRemove, 1);
  }

  return {
    ...state,
    snakeHead: nextSnakeHead,
    currentScore: state.dishIndexes.includes(snakeHeadCoordinates)
      ? state.currentScore + catchDishPoint
      : state.currentScore,
    dishIndexes: state.dishIndexes.includes(snakeHeadCoordinates)
      ? prevStateDishIndexes
      : state.dishIndexes,
    snakeCoords: newData.concat(getIndex(nextSnakeHead.x, nextSnakeHead.y)),
  };
});

engine.addSignalReducer('giveNewDish', (state) => {
  if (getIsGameEnded(state)) {
    return state;
  }

  const prevDishIndexes = [...state.dishIndexes];
  const nextDishIndex = getRandomDishPosition(
    prevDishIndexes,
    state.snakeCoords
  );

  return {
    ...state,
    dishIndexes: prevDishIndexes.concat(nextDishIndex),
    round: state.round + 1,
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
  } else {
    alert.classList.remove('alert-loss');
  }

  return () => {
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
  let timerContainer = document.querySelector('.timer');
  let gameContainer = document.querySelector('.game-container');

  if (!timerContainer) {
    timerContainer = document.createElement('div');
    timerContainer.classList.add('timer');
    gameContainer.appendChild(timerContainer);
  }

  if (state.gameTimer < 10000) {
    timerContainer.classList.remove('score-positive');
    timerContainer.classList.add('score-negative');
  } else {
    timerContainer.classList.remove('score-negative');
    timerContainer.classList.add('score-positive');
  }

  const mins = Math.floor(state.gameTimer / (60 * 1000));
  const secs = Math.floor((state.gameTimer / 1000) % 60);

  timerContainer.innerHTML = `${mins}:${secs < 10 ? '0' : ''}${secs}`;
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
      gameContainer.appendChild(meshContainer);
    }
  }

  state.snakeCoords.forEach((snakeCoord) =>
    meshContainer.children[snakeCoord].classList.add('snake-body')
  );

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
    state.snakeCoords.forEach((snakeCoord) =>
      meshContainer.children[snakeCoord].classList.remove('snake-body')
    );
    document.removeEventListener('keydown', onKeyBoardClick);
  };
}

function renderSnakeDish({ state }) {
  let meshContainer = document.querySelector('.mesh');
  state.dishIndexes.forEach((dishIndex) =>
    meshContainer.children[dishIndex].classList.add('active-dish')
  );

  return () => {
    state.dishIndexes.forEach((dishIndex) =>
      meshContainer.children[dishIndex].classList.remove('active-dish')
    );
  };
}

function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

function getRandomDishPosition(prevDishIndexes, snakeCoords) {
  let result;
  do {
    result = getRandomNumber(meshSize - 1);
  } while (prevDishIndexes.includes(result) || snakeCoords.includes(result));

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
