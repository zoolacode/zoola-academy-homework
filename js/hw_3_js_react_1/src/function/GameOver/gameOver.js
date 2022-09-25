export function getIsSnakeHeadOutsideBoard(headX, headY, boardWidth) {
  return (
    headX > boardWidth - 1 || headX < 0 || headY > boardWidth - 1 || headY < 0
  );
}

export function getIsSnakeHeadOnBody([headX, headY], snakeBody) {
  let snakeHeadOnBody = snakeBody.filter(
    ([x, y]) => x === headX && y === headY
  );
  return snakeHeadOnBody.length === 2;
}

export function getIsTimeOut(time) {
  const deadLine = 0;
  return time <= deadLine;
}
