const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
const meshSize = meshContainer.children.length;

/**
 * @description A function to be executed after each game iteration, is set to null by default
 */
let deactivateElement = null;
/**
 * @description Current score
 */
let currentScore = 0;
/**
 * @description Game speed
 */
let gameIterationDuration = 1000;

let isIterationComplete = true;
let prevIndex = null;
let currentElement = null;

const errorFine = 2;
const iterationFailFine = 5;
const clickOutsideFine = 3;
const iterationSuccessTreat = 1;

const subscribeToOutsideClicks = () => {
  const onDocumentClick = (e) => {
    if (currentElement && e.target !== currentElement) {
      currentScore -= clickOutsideFine;
      showScore();
      stopIfGameEnded();
    }
  };
  document.addEventListener("click", onDocumentClick);

  return () => {
    document.removeEventListener("click", onDocumentClick);
  };
};

const unsubscribeFromOutsideClicks = subscribeToOutsideClicks();

showScore();

let hitNextIterationImmediately;
let stopGame;

runGameIteration();

function runGameIteration() {
  /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */
  if (deactivateElement) {
    deactivateElement();
  }

  let activeIndex = null;
  const randomIndex = getRandomNumber(meshSize - 1);

  if (prevIndex !== null && prevIndex === randomIndex) {
    activeIndex = shiftIndexForward(randomIndex, meshSize - 1);
  } else {
    activeIndex = randomIndex;
  }

  const activeElement = meshContainer.children[activeIndex];
  prevIndex = activeIndex;
  currentElement = activeElement;

  if (activeElement) {
    deactivateElement = activateElement(activeElement, activeIndex);
  }

  if (!isIterationComplete) {
    currentScore -= iterationFailFine;
    showScore();
    const gameOver = stopIfGameEnded();
    if (gameOver) {
      return;
    }
  } else {
    isIterationComplete = false;
  }

  const timeoutId = setTimeout(runGameIteration, gameIterationDuration);

  hitNextIterationImmediately = () => {
    clearTimeout(timeoutId);
    runGameIteration();
  };

  stop = () => {
    clearTimeout(timeoutId);
  };
}

function showScore() {
  scoreContainer.innerText = currentScore;
  if (currentScore >= 0) {
    scoreContainer.classList.remove("score-negative");
    scoreContainer.classList.add("score-positive");
  } else {
    scoreContainer.classList.remove("score-positive");
    scoreContainer.classList.add("score-negative");
  }
}

function stopIfGameEnded() {
  if (isGameEnded(currentScore)) {
    stop();
    unsubscribeFromOutsideClicks();
    deactivateElement();
    return true;
  }
  return false;
}

function activateElement(element) {
  const variant = getRandomVariant();
  element.classList.add("item-highlighted", variant);

  function onClick() {
    if (!isIterationComplete) {
      currentScore += iterationSuccessTreat;
      isIterationComplete = true;
      showScore();
      const gameOver = stopIfGameEnded();
      if (!gameOver) {
        setTimeout(hitNextIterationImmediately);
      }
      return;
    }

    currentScore -= errorFine;
    showScore();
    stopIfGameEnded();
  }

  element.addEventListener("click", onClick);

  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.classList.remove("item-highlighted", variant);

    element.removeEventListener("click", onClick);
  };
}

/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */
function getRandomNumber(max) {
  return Math.floor(Math.random() * 10) % max;
}

function getRandomVariant() {
  const variants = [
    "item-highlighted-1",
    "item-highlighted-2",
    "item-highlighted-3",
  ];
  return variants[getRandomNumber(variants.length)];
}

function shiftIndexForward(currentIndex, maxIndex) {
  return (currentIndex + 1) % maxIndex;
}

function isGameEnded(currentScore) {
  const gameEndHigherLimit = 20;
  const gameEndLowerLimit = -20;
  return (
    currentScore >= gameEndHigherLimit || currentScore <= gameEndLowerLimit
  );
}
