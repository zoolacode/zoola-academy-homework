function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

export function generateNewFood(snakeBody, boardWidth) {
  let food = [[getRandomNumber(boardWidth), getRandomNumber(boardWidth)]];
  let foodOnSnake = snakeBody.filter(
    (item) => item[0] === food[0] && item[1] === food[1]
  );

  while (foodOnSnake.length === 1) {
    let newFood = [[getRandomNumber(boardWidth), getRandomNumber(boardWidth)]];
    foodOnSnake = snakeBody.filter(
      (item) => item[0] === newFood[0] && item[1] === newFood[1]
    );
    food = newFood;
  }
  return food;
}
