export function getIsSnakeHeadOutsideBoard(headX, headY) {
  if (headX > 24 || headX < 0 || headY > 24 || headY < 0) {
    return true;
  } else {
    return false;
  }
}
export function getIsSnakeHeadOnBody([headX, headY], snakeBody) {
  let snakeHeadOnBody = snakeBody.filter(
    ([x, y]) => x === headX && y === headY
  );
  if (snakeHeadOnBody.length === 2) {
    return true;
  }
}
export function getIsTimeOut(time) {
  const deadLine = 0;
  if (time <= deadLine) {
    return true;
  }
}
