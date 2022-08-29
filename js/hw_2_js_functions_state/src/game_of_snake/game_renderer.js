import {
  arrayOfLength,
  flattenSuperFood,
  parseStringCoordinates,
} from "./utils";

export function renderGame(state, boardSize) {
  let container = document.querySelector(".container");

  if (!container) {
    container = document.createElement("div");
    container.classList.add("container");
    const gridColumns = arrayOfLength(boardSize, "1fr").join(" ");
    container.setAttribute("style", `grid-template-columns: ${gridColumns}`);
    document.body.appendChild(container);
  }

  let squares = container.querySelectorAll(".square");

  if (!squares.length) {
    for (let i = 0; i < boardSize ** 2; i++) {
      let square = document.createElement("div");
      square.classList.add("square");
      container.appendChild(square);
    }
    squares = container.querySelectorAll(".square");
  }

  squares.forEach((el) => {
    el.classList.remove(
      "snake",
      "food",
      "food-super",
      "snake-head",
      "snake-tail",
      "snake-speed",
      "snake-dead"
    );
  });

  state.snake.forEach((coordinates, index) => {
    const [x, y] = parseStringCoordinates(coordinates);
    const squareElement = squares[getSquareIndex([x, y], boardSize)];
    squareElement.classList.add("snake");

    if (state.isGameEnded) {
      squareElement.classList.add("snake-dead");
    }

    if (index === 0) {
      squareElement.classList.add("snake-tail");
    } else if (index === state.snake.length - 1) {
      squareElement.classList.add("snake-head");
    }
    if (state.speedUp) {
      squareElement.classList.add("snake-speed");
    }
  });

  Object.entries(state.food)
    .filter(([key, value]) => value)
    .map(([key, value]) => key)
    .forEach((coordinate) => {
      const [x, y] = parseStringCoordinates(coordinate);
      const foodSquare = squares[getSquareIndex([x, y], boardSize)];
      foodSquare.classList.add("food");

      if (flattenSuperFood(state.superFood)[coordinate]) {
        foodSquare.classList.add("food-super");
      }
    });
}

export function getSquareIndex([x, y], boardSize) {
  return x + y * boardSize;
}
