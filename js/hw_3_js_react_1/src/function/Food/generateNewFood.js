function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

export function generateNewFood(snakeBody, boardWidth) {
  let food = [[getRandomNumber(boardWidth), getRandomNumber(boardWidth)]];
  let foodOnSnake = snakeBody.filter(
    ([x, y]) => x === food[0] && y === food[1]
  );

  while (foodOnSnake.length === 1) {
    let newFood = [[getRandomNumber(boardWidth), getRandomNumber(boardWidth)]];
    foodOnSnake = snakeBody.filter(
      ([x, y]) => x === newFood[0] && y === newFood[1]
    );
    food = newFood;
  }
  return food;
}
