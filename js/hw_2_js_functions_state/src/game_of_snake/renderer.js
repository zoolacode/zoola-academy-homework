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

export function renderGameAlert({ state, prevState }, emit) {
  let alert = document.querySelector(".alert");

  if (!alert) {
    alert = document.createElement("div");
    alert.classList.add("alert");
    alert.innerHTML = 'Game has ended. Press "Enter" to start again';
    document.body.appendChild(alert);
  }

  const onAlertEnter = (e) => {
    if (e.key === "Enter") {
      emit("restartGame");
    }
  };

  if (state.isGameEnded) {
    document.addEventListener("keyup", onAlertEnter);
    alert.classList.add(state.gameWon ? "alert-win" : "alert-loss");
  } else {
    alert.classList.remove("alert-win");
    alert.classList.remove("alert-loss");
  }

  return () => {
    document.removeEventListener("keyup", onAlertEnter);
  };
}

export function renderGameScore({ state, prevState }, emit) {
  let scoreContainer = document.querySelector(".score");

  if (!scoreContainer) {
    scoreContainer = document.createElement("div");
    scoreContainer.classList.add("score");
    document.body.appendChild(scoreContainer);
  }

  scoreContainer.innerHTML = state.points;
}

export function renderGameTime({ state, prevState }, emit) {
  let gameTimeContainer = document.querySelector(".gametime");

  if (!gameTimeContainer) {
    gameTimeContainer = document.createElement("div");
    gameTimeContainer.classList.add("gametime");
    document.body.appendChild(gameTimeContainer);
  }

  console.log(state.maxGameTime, state.gameTime);

  const secondsLeft = state.maxGameTime - state.gameTime;

  if (secondsLeft < 0) {
    gameTimeContainer.innerHTML = "00:00";
    return;
  }

  const minutes = Math.floor(secondsLeft / 60);
  const seconds = secondsLeft % 60;
  gameTimeContainer.innerHTML = `${adjustTimeToScreen(
    minutes
  )}:${adjustTimeToScreen(seconds)}`;
}

export function renderPauseScreen({ state }) {
  let pauseScreen = document.querySelector(".pause-screen");

  if (!pauseScreen) {
    pauseScreen = document.createElement("div");
    pauseScreen.classList.add("pause-screen");
    document.body.appendChild(pauseScreen);
  }

  if (state.pause) {
    pauseScreen.classList.add("active");
  } else {
    pauseScreen.classList.remove("active");
  }
}

export function renderSuperFoodTimer({ state }) {
  let superFoodTimer = document.querySelector(".superfood-timer");

  if (!superFoodTimer) {
    superFoodTimer = document.createElement("div");
    superFoodTimer.classList.add("superfood-timer");
    document.body.appendChild(superFoodTimer);
  }

  if (state.superFood.length === 0) {
    superFoodTimer.classList.remove("active");
    return;
  }

  superFoodTimer.classList.add("active");

  const text = state.superFood
    .map((item) => item.expiresAt)
    .reduce((acc, expiresAt) => {
      const secondsLeft = expiresAt - state.gameTime;
      const minutes = Math.floor(secondsLeft / 60);
      const seconds = secondsLeft % 60;
      return `${adjustTimeToScreen(minutes)}:${adjustTimeToScreen(seconds)}\n`;
    }, "");

  superFoodTimer.innerHTML = text;
}

function adjustTimeToScreen(num) {
  const str = String(num);
  if (str.length < 2) {
    return `0${str}`;
  }
  return str;
}
