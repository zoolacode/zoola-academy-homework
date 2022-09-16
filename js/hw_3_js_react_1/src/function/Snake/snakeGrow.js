export function snakeGrow(
    hasEatenFood,
    snakeBody,
    snakeHead,
    snakeBodyWithExtraTail
  ) {
    if (hasEatenFood) {
      return [snakeHead, ...snakeBody];
    } else {
      return snakeBodyWithExtraTail.slice(0, snakeBodyWithExtraTail.length - 1);
    }
  }