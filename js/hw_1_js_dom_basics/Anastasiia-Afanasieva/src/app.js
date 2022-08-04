const meshContainer = document.querySelector(".mesh");
const gameParamsContainer = document.querySelector(".game-params-container");
const itemsPerRow = 5;
const itemsPerColumn = 5;
const meshContainerWidth = meshContainer.clientWidth;
const meshContainerHeight = meshContainer.clientHeight;
const scoreContainer = document.querySelector(".score");
const selectGameSpeed = document.querySelector(".select-speed");
const itemWidth = meshContainerWidth / itemsPerRow;
const itemHeight = meshContainerHeight / itemsPerColumn;
const itemsQuantity = (meshContainerWidth / itemWidth) * (meshContainerHeight / itemHeight);
const successClickPoint = 1;
const doubleClickPoint = 2;
const clickOutsideElementPoint = 3;
const limitScore = 7;

function appendItems() {
  const newItem = document.createElement("div");
  newItem.className = "item";
  meshContainer.append(newItem);
}

for (let i = 0; i < itemsQuantity; i++) {
  appendItems();
}

const meshSize = meshContainer.children.length;

/**
 * @description A function that will run our game using SetInterval
 * The number id value returned by setInterval() function and it’s passed into the clearInterval() function to clear the interval
 */
let gameInterval;
/**
 * @description A function to be executed after each game iteration, is set to null by default
 */
let deactivateElement = null;
/**
 * @description Current score
 */
let currentScore;
/**
 * @description Game speed
 */
let gameIterationDuration;
/**
 * @description Status of click
 */
let isClicked = false;
/**
 * @description Status of click outside of highlighted element
 */
let isClickedOutOfElement = false;
/**
 * @description A function that checks if index is different from previous
 */
let randomIndex;
/**
 * @description Current highlighted element on the mesh
 */
let highlightedElement;

selectGameSpeed.addEventListener('change', setGameSpeed);
meshContainer.addEventListener('click', handleClickOutsideElement, true);

function setIntervalImmediately(func, interval) {
  func();
   return gameInterval = setInterval(func, interval);
}

function resetPrevGameResult() {
  if (highlightedElement) {
    highlightedElement.className = "item";
  }

  clearResultNotification();
  clearInterval(gameInterval);

  scoreContainer.innerText = '0';
  handleScoreColor();
  currentScore = 0;
}

function startNewGame() {
  resetPrevGameResult();
  setIntervalImmediately(runGameIteration, gameIterationDuration);
}

function setGameSpeed(e) {
  clearStartButton();
  resetPrevGameResult();
  createStartButton();

  gameIterationDuration = e.target.value;
}

function stopGameIteration(element) {
    clearInterval(gameInterval);
    element.removeEventListener('click', handleClick);
    meshContainer.removeEventListener('click', handleClickOutsideElement, true);
}

function handleScoreColor() {
  if (+scoreContainer.innerText < 0) {
    scoreContainer.classList.add('danger');
  } else {
    scoreContainer.classList.remove('danger');
  }
}

function handleClick() {
  if (isClicked) {
    scoreContainer.innerText = currentScore -= doubleClickPoint;
  } else {
    scoreContainer.innerText = currentScore += successClickPoint;
    // clearInterval(gameInterval);
    // gameInterval = setIntervalImmediately(runGameIteration, gameIterationDuration);
  }

  handleScoreColor();

  isClicked = true;

  if (currentScore <= -limitScore || currentScore >= limitScore) {
    createResultNotification(currentScore);
    stopGameIteration(highlightedElement);
  }
}

function handleClickOutsideElement(element) {
  if (element.target.classList.value === 'item') {
    scoreContainer.innerText = currentScore -= clickOutsideElementPoint;
  }

  if (currentScore <= -limitScore || currentScore >= limitScore) {
    createResultNotification(currentScore);
    stopGameIteration(highlightedElement);
  }

  handleScoreColor();
}

function runGameIteration() {
  randomIndex = getIndex();

  /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */
  if (deactivateElement) {
    deactivateElement();
  }

  const activeElement = meshContainer.children[randomIndex];

  if (!isClicked) {
    scoreContainer.innerText = currentScore -= 5;
  }

  handleScoreColor();

  if (activeElement) {
    deactivateElement = activateElement(activeElement);
    isClicked = false;
  }


  if (currentScore <= -limitScore || currentScore >= limitScore) {
    createResultNotification(currentScore);
    stopGameIteration(activeElement);
  }
}

function activateElement(element) {
  const variant = getVariantForIndex();
  element.classList.add("item-highlighted", variant);
  element.addEventListener('click', handleClick);
  highlightedElement = element;

  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.removeEventListener('click', handleClick);
    element.classList.remove("item-highlighted", variant);
  };
}

/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */
function getRandomNumber(max) {
  return Math.floor(Math.random() * 100) % max;
}

function getVariantForIndex() {
  const variants = [
    "item-highlighted-1",
    "item-highlighted-2",
    "item-highlighted-3",
  ];
  return variants[getRandomNumber(meshSize - 1) % variants.length];
}

function getIndex() {
  let index;
  do {
    index = getRandomNumber(meshSize - 1);
  } while (randomIndex === index);

  return index;
}

function createResultNotification(result) {
  const notification = document.createElement("div");
  notification.className = "mesh-notification";
  if (result <= -limitScore) {
    notification.innerText = 'Oops! Try again!';
  } else {
    notification.innerText = 'Congratulations! You win';
  }

  gameParamsContainer.append(notification);
}

function clearResultNotification() {
  const activeNotification = document.querySelector(".mesh-notification");
  
  if (activeNotification) {
    activeNotification.remove();
  }
}

function createStartButton() {
  const startButtonContainer = document.createElement("div");
  const startButton = document.createElement("button");

  startButtonContainer.className = "start-game";
  startButton.className = "start-button";
  startButton.innerText = "Start"
  
  startButtonContainer.append(startButton);
  gameParamsContainer.append(startButtonContainer);

  startButton.addEventListener('click', startNewGame);
}

function clearStartButton() {
  const startButtonContainer = document.querySelector(".start-game");

  if (startButtonContainer) {
    startButtonContainer.remove();
  }
}
