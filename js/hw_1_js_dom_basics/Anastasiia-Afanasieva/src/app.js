'use strict';

const mesh = document.querySelector('.mesh');
const gameParamsContainer = document.querySelector('.game-params-container');
const scoreContainer = document.querySelector('.score-number');
const selectGameSpeed = document.querySelector('.game-speed__select');

const itemsQuantity = 25;
const successClickPoint = 1;
const doubleClickPoint = 2;
const clickOutsideElementPoint = 3;
const missedClickPoint = 5;
const upperLimit = 20;
const lowerLimit = -20;

function appendItemsOnMesh() {
  const newItem = document.createElement('div');
  newItem.className = 'mesh__item';
  mesh.append(newItem);
}

for (let i = 0; i < itemsQuantity; i++) {
  appendItemsOnMesh();
}

const meshSize = mesh.children.length;

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
 * @description Status of click on highlighted element
 */
let isClickedOnElement = false;
/**
 * @description A function that checks if index is different from previous
 */
let randomIndex;
/**
 * @description Current highlighted element on the mesh
 */
let highlightedElement;

selectGameSpeed.addEventListener('change', setGameSpeed);

function setGameSpeed(e) {
  clearStartButton();
  resetPrevGameResult();
  createStartButton();

  gameIterationDuration = e.target.value;
}

function startNewGame() {
  const startButton = document.querySelector('.start-game__button');

  startButton.innerText = 'Start';
  mesh.addEventListener('click', handleClickOutsideElement);
  resetPrevGameResult();
  setIntervalImmediately(runGameIteration, gameIterationDuration);
}

function setIntervalImmediately(func, interval) {
  if (currentScore <= lowerLimit || currentScore >= upperLimit) {
    createResultNotification(currentScore);
    stopGameIteration(highlightedElement);
  } else {
    func();

    gameInterval = setInterval(func, interval);
  }
}

function resetPrevGameResult() {
  if (highlightedElement) {
    deactivateElement();
  }

  clearResultNotification();
  clearInterval(gameInterval);

  scoreContainer.innerText = '0';
  handleScoreColor();
  currentScore = missedClickPoint;
  isClicked = false;
}

function stopGameIteration(element) {
  clearInterval(gameInterval);
  element.removeEventListener('click', handleClick);
  mesh.removeEventListener('click', handleClickOutsideElement);
}

function handleClick() {
  if (Boolean(isClicked)) {
    currentScore -= doubleClickPoint;
    scoreContainer.innerText = currentScore;
  } else {
    currentScore += successClickPoint;
    scoreContainer.innerText = currentScore;
    isClickedOnElement = true;
  }

  handleScoreColor();

  isClicked = true;

  clearInterval(gameInterval);
  setIntervalImmediately(runGameIteration, gameIterationDuration);
}

function handleClickOutsideElement() {
  if (!isClickedOnElement) {
    currentScore -= clickOutsideElementPoint;
    scoreContainer.innerText = currentScore;
  }

  if (currentScore <= lowerLimit) {
    createResultNotification(currentScore);
    stopGameIteration(highlightedElement);
  }

  handleScoreColor();
  isClickedOnElement = false;
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

  const activeElement = mesh.children[randomIndex];

  if (!isClicked) {
    currentScore -= missedClickPoint;
    scoreContainer.innerText = currentScore;
  }

  handleScoreColor();

  if (activeElement) {
    deactivateElement = activateElement(activeElement);
    isClicked = false;
  }

  if (currentScore <= lowerLimit || currentScore >= upperLimit) {
    createResultNotification(currentScore);
    stopGameIteration(activeElement);
  }
}

function activateElement(element) {
  const variant = getVariantForIndex();
  element.classList.add('item-highlighted', variant);
  element.addEventListener('click', handleClick);
  highlightedElement = element;

  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.removeEventListener('click', handleClick);
    element.classList.remove('item-highlighted', variant);
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
    'item-highlighted-1',
    'item-highlighted-2',
    'item-highlighted-3',
  ];

  return variants[getRandomNumber(variants.length - 1)];
}

function getIndex() {
  let index;
  do {
    index = getRandomNumber(meshSize - 1);
  } while (randomIndex === index);

  return index;
}

function handleScoreColor() {
  if (Number(scoreContainer.innerText) < 0) {
    scoreContainer.classList.add('danger-score');
  } else {
    scoreContainer.classList.remove('danger-score');
  }
}

function createResultNotification(result) {
  const notification = document.createElement('div');
  const startButton = document.querySelector('.start-game__button');

  notification.className = 'result-notification';
  if (result <= lowerLimit) {
    notification.innerText = `Oops! Try again? ${String.fromCodePoint(0x1F340)}`;
  } else {
    notification.innerText = `Congrats! You win ${String.fromCodePoint(0x1F389)}`;
  }

  startButton.innerText = 'Try again';
  gameParamsContainer.append(notification);
}

function clearResultNotification() {
  const activeNotification = document.querySelector('.result-notification');

  if (activeNotification) {
    activeNotification.remove();
  }
}

function createStartButton() {
  const startButtonContainer = document.createElement('div');
  const startButton = document.createElement('button');

  startButtonContainer.className = 'start-game';
  startButton.className = 'start-game__button';
  startButton.innerText = 'Start';

  startButtonContainer.append(startButton);
  gameParamsContainer.append(startButtonContainer);

  startButton.addEventListener('click', startNewGame);
}

function clearStartButton() {
  const startButtonContainer = document.querySelector('.start-game');

  if (startButtonContainer) {
    startButtonContainer.remove();
  }
}
