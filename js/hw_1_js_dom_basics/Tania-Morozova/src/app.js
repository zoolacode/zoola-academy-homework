const MISSED_POINTS = -5;
const NEGATIVE_POINTS_OUT_ITEM = -3;
const NEGATIVE_EXTRA_CLICK_POINTS = -2;
const HIT_POINTS = 1;
const WIN_POINTS = 20;
const LOSE_POINTS = -20;
const ITEMS_COUNT = 25;
const GAME_ITERATION_DURATION = 1000;

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

let counterClick = 0;
let previousIndex = null;



const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
const startModal = document.querySelector(".js-start-modal");
const modalButton = startModal.querySelector(".modal__button");
const modalWin = document.querySelector(".modal__win");
const modalLose = document.querySelector(".modal__lose");
const restartButtonWin = modalWin.querySelector(".modal__button");
const restartButtonLose = modalLose.querySelector(".lose-button");


for (let i = 0; i < ITEMS_COUNT; ++i) {
  meshContainer.appendChild(createItemWithClass('div', "item"));
}

const meshSize = meshContainer.children.length;

scoreContainer.innerText = currentScore;

let intervalId = setInterval(runGameIteration, GAME_ITERATION_DURATION);


restartButtonWin.addEventListener('click', () => {
  modalWin.classList.remove("modal__active");
  intervalId = setInterval(runGameIteration, GAME_ITERATION_DURATION)
});

restartButtonLose.addEventListener('click', ()=> {
  modalLose.classList.remove("modal__active");
  intervalId = setInterval(runGameIteration, GAME_ITERATION_DURATION)
})

modalButton.addEventListener('click', () => startModal.classList.remove("modal__active"))


function createItemWithClass(type, className) {
  const item = document.createElement(type);
  item.classList.add(className);
  return item;
}

function runGameIteration() {
  /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */
  if (deactivateElement) {
    deactivateElement();
  }

  let randomIndex = getRandomNumber(meshSize - 1);

  while (previousIndex === randomIndex) {
    randomIndex = getRandomNumber(meshSize - 1);
  }

  const activeElement = meshContainer.children[randomIndex];

  if (activeElement) {
    scoreContainer.classList.toggle("negative-score", currentScore < 0);
    previousIndex = randomIndex;
    deactivateElement = activateElement(activeElement);
    meshContainer.addEventListener('click', changeGameCounter);
  }

  stopGame(currentScore, activeElement);
}


function activateElement(element) {
  element.classList.toggle("item-highlighted");
  element.style.backgroundColor = `rgb(${getRandomColor()})`

  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.classList.toggle("item-highlighted");
    element.removeAttribute('style')

    meshContainer.removeEventListener('click', changeGameCounter);

    if (counterClick === 0) {
      currentScore += MISSED_POINTS;
      scoreContainer.innerText = currentScore;
    }

    counterClick = 0;
  };
}


/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */
function getRandomNumber(max) {
  return Math.floor(Math.random() * 10) % max;
}

/**
 * @description  This function changes the value of counterClick and, depending on its value, changes the currentScore
 */
function changeGameCounter(event) {
  counterClick += 1;
  const isHighlighted = event.target.classList.contains('item-highlighted')

  if (isHighlighted && counterClick === 1) {
    currentScore += HIT_POINTS;
  } else if (counterClick > 1) {
    currentScore += NEGATIVE_EXTRA_CLICK_POINTS;
  } else if (!isHighlighted) {
    currentScore += NEGATIVE_POINTS_OUT_ITEM;
  }

  scoreContainer.innerText = currentScore;
}

/**
 * @description This function that checks the score, stops the game under certain conditions.
 */
function stopGame(score, element) {
  if (score >= WIN_POINTS || score <= LOSE_POINTS) {
    clearInterval(intervalId);
    deactivateElement = null;
    element.classList.toggle("item-highlighted");
    element.removeAttribute('style')
    meshContainer.removeEventListener('click', changeGameCounter);
    currentScore = 0;
    scoreContainer.innerText = currentScore;
  }

  if(score >= WIN_POINTS) {
    modalWin.classList.add("modal__active")
  }

  if(score <= LOSE_POINTS) {
    modalLose.classList.add("modal__active")
  }
}

/**
 * @description This function generate random color.
 */
function getRandomColor() {
  function randomNumber() {
    return Math.floor(Math.random() * (255));
  }
  return `${randomNumber()},${randomNumber()},${randomNumber()}`;
}



