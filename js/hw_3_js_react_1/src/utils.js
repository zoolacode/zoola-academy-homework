const boardWidth = 25;
export const meshSize = boardWidth ** 2;
export const timerLimitMs = 120000;

export function getIndex(x, y) {
  return y * boardWidth - (boardWidth - x) - 1;
}

export function getRandomDishPosition(snakeCoords, dish, bonusDish) {
  const items = [...Array(meshSize)]
    .map((_, index) => index)
    .filter(
      (coord) =>
        !snakeCoords.includes(coord) && dish !== coord && bonusDish !== coord
    );

  return items[Math.floor(Math.random() * items.length)];
}

export function getMinSec(value) {
  const min = Math.floor(value / (60 * 1000));
  const sec = Math.floor((value / 1000) % 60);

  return { min, sec };
}

export function getTimeString(min, sec) {
  return `${min}:${sec < 10 ? '0' : ''}${sec}`;
}

export function getNextSnakeHead(currentSnakeHead, currentDirection) {
  const movements = {
    moveUp: ({ x, y }) => ({ x, y: y - 1 }),
    moveDown: ({ x, y }) => ({ x, y: y + 1 }),
    moveRight: ({ x, y }) => ({ x: x + 1, y }),
    moveLeft: ({ x, y }) => ({ x: x - 1, y }),
  };
  const move = movements[currentDirection];
  const nextSnakeHead = move(currentSnakeHead);

  return nextSnakeHead;
}

export function getNewSnakeCoords(
  hasEatenDish,
  hasEatenBonusDish,
  currentSnakeCoords
) {
  const newSnakeCoords =
    hasEatenDish || hasEatenBonusDish
      ? [...currentSnakeCoords]
      : currentSnakeCoords.slice(1, currentSnakeCoords.length);

  return newSnakeCoords;
}

export function getSnakeHitBorders(nextSnakeHead) {
  const borderWidth = 25;
  return (
    nextSnakeHead.x > borderWidth ||
    nextSnakeHead.y > borderWidth ||
    nextSnakeHead.x === 0 ||
    nextSnakeHead.y === 0
  );
}

export function addMovement(state, { ...inputDirection }) {
  const speedUpCondition = getSpeedUpCondition(
    state.direction,
    inputDirection.type
  );

  if (state.direction !== inputDirection.oppositeDirection) {
    return {
      ...state,
      direction: inputDirection.type,
      speedUp: speedUpCondition ? true : false,
    };
  }

  return state;
}

export function getSpeedUpCondition(currentDirection, nextDirection) {
  return currentDirection === nextDirection;
}

export function getHasEatenDish(snakeHeadCoords, dishCoords) {
  return dishCoords === snakeHeadCoords;
}

export function getHasEatenBonusDish(snakeHeadCoords, bonusDishCoords) {
  return bonusDishCoords === snakeHeadCoords;
}

export function getNextScore(score, hasEatenDish, hasEatenBonusDish) {
  const dishPoint = 1;
  const bonusDishPoint = 5;
  let nextScore = score;

  if (hasEatenDish) {
    nextScore = score + dishPoint;
  } else if (hasEatenBonusDish) {
    nextScore = score + bonusDishPoint;
  }

  return nextScore;
}

export function getIsBonusDishNeeded(gameTimer, bonusDishLifeTime) {
  return gameTimer % bonusDishLifeTime === 0 && gameTimer !== 0;
}

export function getIsGameLost(
  isSnakeHitBody,
  isSnakeHitBorders,
  gameTimerValue
) {
  return isSnakeHitBody || isSnakeHitBorders || gameTimerValue === timerLimitMs;
}

export function isSnakeDead(snakeCoords, mesh, gameLost) {
  return snakeCoords.includes(mesh) && gameLost;
}

export function isSnakeShouldSpeedUp(snakeCoords, mesh, speedUpStatus) {
  return snakeCoords.includes(mesh) && speedUpStatus;
}

export function isDishActive(dish, mesh) {
  return dish === mesh;
}

export function isBonusDishActive(bonusDish, mesh) {
  return bonusDish === mesh;
}
