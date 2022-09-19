const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
const gameAreaColor = meshContainer.style.backgroundColor;

const gameIterationDuration = 1000;
const meshSize = 25;
const finishScore = 20;

const firstClickPoints = 1;
const nextClickPoints = -2;
const skipedClickPoints = -5;
const missedClickPoints = -3;

const gameComplexity = getPrefComplexity();
const isHardcoreSelected = isHardcore();

/**
 * @description Game complexity coefficient, which effects on game iteration duration
 */
let complexityMod = 0;
/**
 * @description A function to be executed after each game iteration, is set to null by default
 */
let deactivateElement = null;
/**
 * @description Current score
 */
let currentScore = 0;
/**
 * @description Current active element
 */
let activeElement = null;
/**
 * @description Boolean, whick checks if current element is clicked
 */
let isElementClicked = false;

let isGameFinished = false;
let previousElementIndex;
let gameIntervalId;

updateScore();
addGameElements();
document.body.addEventListener("click", checkGlobalCkick);
setUpGameIteration();

function addGameElements() {
  for (let i = 0; i < meshSize; i++) {
    const div = document.createElement("div");
    div.classList.add("item");
    meshContainer.append(div);
  }
}

function getPrefComplexity() {
  let complexity = prompt(
    `Welcome to "Crazy Squares"!
Choose game comlexity 
(type "newbie", "amateur", "pro" below'):`,
    "newbie"
  );

  try {
    complexity = complexity.toLowerCase();
  } catch (error) {
    document.location.reload();
    throw new Error("Exit the game!");
  }

  switch (complexity) {
    case "newbie":
      return 10;
    case "amateur":
      return 18;
    case "pro":
      return 25;
    default:
      alert(`Sorry, can't find ${complexity}. Try again!`);
      return getPrefComplexity();
  }
}

function isHardcore() {
  return confirm('Do you want to try "hardcode" mode?');
}

function runGameIteration() {
  /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */

  if (deactivateElement) {
    deactivateElement();
  }

  let randomIndex;

  do {
    randomIndex = getRandomNumber(meshSize - 1);
  } while (randomIndex === previousElementIndex);

  previousElementIndex = randomIndex;
  activeElement = meshContainer.children[randomIndex];

  if (activeElement) {
    deactivateElement = activateElement(activeElement);
    activeElement.addEventListener("click", checkFirstClick, { once: true });
  }

  if (currentScore > finishScore) finishGame(true);
  if (currentScore < -finishScore) finishGame(false);
}

function activateElement(element) {
  let variant;
  do {
    variant = getRandomColor();
  } while (variant === gameAreaColor);

  element.classList.add("item-highlighted");
  element.style.backgroundColor = variant;

  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.classList.remove("item-highlighted");
    element.style.backgroundColor = gameAreaColor;

    if (isElementClicked) {
      element.removeEventListener("click", checkNextClicks);
      isElementClicked = false;
    } else {
      element.removeEventListener("click", checkFirstClick);

      if (!isGameFinished) updateScore(skipedClickPoints);
    }
  };
}

/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */
function getRandomNumber(max) {
  return Math.floor(Math.random() * (max + 1));
}

function getRandomColor() {
  let color = {
    red: 0,
    green: 0,
    blue: 0,
  };

  for (const element in color) {
    color[element] = getRandomNumber(255);
  }

  return `rgb(${color.red}, ${color.green}, ${color.blue})`;
}

function eventHandler(targetElement) {
  checkFirstClick(targetElement);
}

function updateScore(amount = 0) {
  currentScore += amount;
  scoreContainer.innerText = currentScore;
  updateScoreColor();
  updateComplexity(amount);
}

function updateScoreColor() {
  if (currentScore >= 0) {
    scoreContainer.style.backgroundColor = "green";
  } else {
    scoreContainer.style.backgroundColor = "red";
  }
}

function updateComplexity(amount) {
  const deltaComplexity = gameComplexity;
  complexityMod -= amount * deltaComplexity;
  console.log(gameIterationDuration + complexityMod);
}

function checkFirstClick() {
  isElementClicked = true;
  updateScore(firstClickPoints);
  activeElement.addEventListener("click", checkNextClicks);
  clearTimeout(gameIntervalId);
  setUpGameIteration();
}

function checkNextClicks() {
  updateScore(nextClickPoints);
}

function checkGlobalCkick(event) {
  if (event.target !== activeElement) {
    updateScore(missedClickPoints);
  }
}

function setUpGameIteration() {
  gameIntervalId = setTimeout(function handler() {
    runGameIteration();
    gameIntervalId = setTimeout(handler, getCurrentGameSpeed());
  }, getCurrentGameSpeed());
}

function getCurrentGameSpeed() {
  if (isHardcoreSelected) {
    return isElementClicked ? 0 : gameIterationDuration + complexityMod;
  } else {
    return gameIterationDuration + complexityMod;
  }
}

function finishGame(isGameWon) {
  isGameFinished = true;
  clearTimeout(gameIntervalId);
  deactivateElement();
  document.body.removeEventListener("click", checkGlobalCkick);

  if (isGameWon) {
    alert("You won, congratulations!\nYou can try other game modes");
  } else {
    alert(
      "Unfortunatly you lost, but you can try again or choose another game mode"
    );
  }

  document.location.reload();
}
