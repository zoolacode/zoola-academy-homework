import { createEngine, ENGINE_INITIALIZE_SIGNAL } from '../engine/engine';

const boardWidth = 25;
const maxDish = 25;
const meshSize = boardWidth ** 2;
const gameTime = 120000;

const initialState = {
  currentScore: 0,
  gameWon: false,
  gameLost: false,
  shouldRestart: false,
  pause: false,
  gameTimer: 0,
  snakeBody: [
    [10, 10],
    [10, 11],
    [10, 12],
    [10, 13],
    [10, 14],
  ],
  dish: [1, 1],
  direction: 'up',
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer('restartGame', () => {
  return initialState;
});

engine.addSideEffect({
  onlyWhen: ifScoreChanged,
  effect: (_, emit) => {
    emit('makeDish');
    const intervalId = setInterval(() => {
      emit('makeDish');
    }, 15000);

    return () => {
      clearInterval(intervalId);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ifDirectionChanged,
  effect: (_, emit) => {
    emit('moveSnake');
    const intervalId = setInterval(() => {
      emit('moveSnake');
    }, 200);

    return () => {
      clearInterval(intervalId);
    };
  },
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('gameTimer', { prevState, state }) ||
    getIsStateChanged('gameWon', { prevState, state }),
  effect: ({ state }, emit) => {
    if (state.gameWon || state.gameLost) {
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
    getIsStateChanged('gameWon', { prevState, state }) ||
    getIsStateChanged('gameLost', { prevState, state }),
  effect: renderGameAlert,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('currentScore', { prevState, state }),
  effect: renderGameScore,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
    getIsStateChanged('gameTimer', { prevState, state }),
  effect: renderGameTimer,
});

engine.addSideEffect({
  effect: renderGameBoard,
});

engine.addSignalReducer('burnGameTime', state => {
  if (state.gameTimer === gameTime) {
    return {
      ...state,
      gameLost: true,
    };
  } else {
    return {
      ...state,
      gameTimer: state.gameTimer + 100,
    };
  }
});

engine.addGlobalReducer(state => {
  if (getIsGameEnded(state) || getIsGamePause(state)) {
    return state;
  }

  const [snakeHeadX, snakeHeadY] = [...state.snakeBody[0]];
  const snakeHeadOnBody = state.snakeBody.filter(
    ([x, y]) => x === snakeHeadX && y === snakeHeadY,
  );

  const gameLost = snakeHeadOnBody.length === 3;

  return {
    ...state,
    gameLost,
  };
});

addMovement(engine, {
  signal: 'keyClickUp',
  direction: 'up',
  dontMove: 'down',
});
addMovement(engine, {
  signal: 'keyClickDown',
  direction: 'down',
  dontMove: 'up',
});
addMovement(engine, {
  signal: 'keyClickLeft',
  direction: 'left',
  dontMove: 'right',
});
addMovement(engine, {
  signal: 'keyClickRight',
  direction: 'right',
  dontMove: 'left',
});

engine.addSignalReducer('pauseGame', state => {
  if (getIsGameEnded(state)) {
    return state;
  }

  return {
    ...state,
    pause: !state.pause,
  };
});

engine.addSignalReducer('moveSnake', state => {
  if (getIsGameEnded(state) || getIsGamePause(state)) {
    return state;
  }
  const snakeBodyBefore = [...state.snakeBody];

  const [snakeHeadX, snakeHeadY] = [...state.snakeBody[0]];

  const [dishX, dishY] = [...state.dish];
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
    snakeBodyBefore,
  );
  const hasEatenDish = getHasEatenDish(snakeBodyFirstElemMove, dishX, dishY);
  const snakeBody = growSnake(
    hasEatenDish,
    snakeBodyBefore,
    snakeBodyFirstElemMove,
    snakeBodyWithExtraTail,
  );

  return {
    ...state,
    snakeBody,
    gameLost,
    currentScore: hasEatenDish
      ? state.currentScore + pointForEat
      : state.currentScore,
  };
});

engine.addSignalReducer('makeDish', state => {
  if (getIsGameEnded(state) || getIsGamePause(state)) {
    return state;
  }

  const snakeBody = [...state.snakeBody];

  const dish = generateNewDish(snakeBody);

  return {
    ...state,
    dish,
  };
});

engine.start();

function renderGameTimer({ state }) {
  let gameTimer = document.querySelector('.timer');

  if (!gameTimer) {
    gameTimer = document.createElement('div');
    gameTimer.classList.add('timer');
    document.body.appendChild(gameTimer);
  }

  const { min, sec } = getMinSec(gameTime - state.gameTimer + 900);
  const timeStr = getTimeString(min, sec);

  gameTimer.innerHTML = timeStr;
}

function getMinSec(value) {
  const min = Math.floor(value / (60 * 1000));
  const sec = Math.floor((value / 1000) % 60);

  return { min, sec };
}

function getTimeString(min, sec) {
  return `${min}:${sec < 10 ? '0' : ''}${sec}`;
}
function renderGameAlert({ state, prevState }, emit) {
  let alert = document.querySelector('.alert');

  if (!alert) {
    alert = document.createElement('div');
    alert.classList.add('alert');
    alert.innerHTML = 'Game has ended. Press "Enter" to start again';
    document.body.appendChild(alert);
  }

  const onAlertEnter = e => {
    if (e.key === 'Enter') {
      emit('restartGame');
    }
  };

  if (state.gameWon || state.gameLost) {
    document.addEventListener('keyup', onAlertEnter);
    alert.classList.add(state.gameWon ? 'alert-win' : 'alert-loss');
  } else {
    alert.classList.remove('alert-win');
    alert.classList.remove('alert-loss');
  }

  return () => {
    document.removeEventListener('keyup', onAlertEnter);
  };
}

function renderGameScore({ state, prevState }, emit) {
  let scoreContainer = document.querySelector('.score');

  if (!scoreContainer) {
    scoreContainer = document.createElement('div');
    scoreContainer.classList.add('score');
    document.body.appendChild(scoreContainer);
  }

  scoreContainer.innerHTML = state.currentScore;
}

function renderGameBoard({ state, prevState }, emit) {
  let meshContainer = document.querySelector('.mesh');

  if (!meshContainer) {
    meshContainer = document.createElement('div');
    meshContainer.classList.add('mesh');

    for (let i = 0; i < meshSize; i++) {
      const cell = document.createElement('div');
      cell.classList.add('item');
      meshContainer.appendChild(cell);
      document.body.appendChild(meshContainer);
      const x = i % boardWidth;
      const y = Math.floor(i / boardWidth);

      let excel = document.querySelectorAll('.item');
      excel[i].dataset.x = x;
      excel[i].dataset.y = y;
    }
  }

  const snakeBody = state.snakeBody.map(([x, y]) => {
    const meshIndex = x + y * boardWidth;

    return meshContainer.children[meshIndex];
  });

  snakeBody.forEach(item => {
    item.classList.add('snake-body');
  });

  const dish = document.querySelector(
    `[data-x = '${state.dish[0]}'][data-y = '${state.dish[1]}']`,
  );
  dish.classList.add('dish');

  const onDocumentClick = e => {
    switch (e.key) {
      case 'ArrowLeft':
        emit('keyClickLeft');
        break;
      case 'ArrowUp':
        emit('keyClickUp');
        break;
      case 'ArrowRight':
        emit('keyClickRight');
        break;
      case 'ArrowDown':
        emit('keyClickDown');
        break;
    }
    if (e.code === 'Space') {
      emit('pauseGame');
    }
  };

  window.addEventListener('keydown', onDocumentClick);

  return () => {
    window.removeEventListener('keydown', onDocumentClick);
    snakeBody.forEach(item => item.classList.remove('snake-body'));
    dish.classList.remove('dish');
  };
}

function addMovement(engine, obj) {
  engine.addSignalReducer(obj.signal, state => {
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

function getHasEatenDish([snakeHeadX, snakeHeadY], dishX, dishY) {
  if (snakeHeadX === dishX && snakeHeadY === dishY) {
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
    getIsStateChanged('direction', { prevState, state }) &&
    !getIsGameEnded(state)
  );
}

function ifScoreChanged({ prevState, state }) {
  return (
    getIsStateChanged('currentScore', { prevState, state }) &&
    !getIsGameEnded(state)
  );
}

function getIsSnakeHeadOutsideBoard(headX, headY) {
  if (headX > 24 || headX < 0 || 0 > headY || headY > 24) {
    return true;
  } else {
    return false;
  }
}
function growSnake(hasEatenDish, snakeBody, snakeHead, snakeBodyWithExtraTail) {
  if (hasEatenDish) {
    return [snakeHead, ...snakeBody];
  } else {
    return snakeBodyWithExtraTail.slice(0, snakeBodyWithExtraTail.length - 1);
  }
}

function snakeBodyWithTail(
  gameLost,
  snakeBodyFirstElem,
  snakeBodyFirstElemMove,
  snakeBody,
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

function generateNewDish(snakeBody) {
  let dish = [getRandomNumber(maxDish), getRandomNumber(maxDish)];
  let dishOnSnake = snakeBody.filter(
    item => item[0] === dish[0] && item[1] === dish[1],
  );

  while (dishOnSnake.length === 1) {
    dish = [getRandomNumber(maxDish), getRandomNumber(maxDish)];
    dishOnSnake = snakeBody.filter(
      item => item[0] === dish[0] && item[1] === dish[1],
    );
  }
  return dish;
}
