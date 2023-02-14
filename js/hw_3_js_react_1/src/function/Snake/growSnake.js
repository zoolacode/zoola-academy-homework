export function growSnake(
  hasEatenFood,
  snakeBody,
  snakeHead,
  snakeBodyWithExtraTail
) {
  if (hasEatenFood) {
    return [snakeHead, ...snakeBody];
  } else {
    return snakeBodyWithExtraTail.slice(0, -1);
  }
}
