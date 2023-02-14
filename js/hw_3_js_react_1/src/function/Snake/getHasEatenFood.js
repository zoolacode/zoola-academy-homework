export function getHasEatenFood([snakeHeadX, snakeHeadY], foodX, foodY) {
  return snakeHeadX === foodX && snakeHeadY === foodY;
}
