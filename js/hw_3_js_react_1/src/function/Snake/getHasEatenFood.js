export function getHasEatenFood([snakeHeadX, snakeHeadY], foodX, foodY) {
  if (snakeHeadX === foodX && snakeHeadY === foodY) {
    return true;
  } else {
    return false;
  }
}
