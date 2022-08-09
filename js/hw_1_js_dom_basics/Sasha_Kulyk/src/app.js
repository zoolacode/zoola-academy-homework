import Notiflix from 'notiflix';
const WIN_POINTS = 20;
const LOST_POINTS = -20;
const ITEMS = 25;
const GAME_ITERATION_DURATION = 1000;

const meshContainer = document.querySelector('.mesh');
const scoreContainer = document.querySelector('.score');
const btnStart = document.querySelector('.btn_start ');

/**
 * @description A function to be executed after each game iteration, is set to null by default
 */
let deactivateElement = null;
/**
 * @description Current score
 */
let currentScore = 0;
scoreContainer.innerText = 0;

/**
 * @description Game speed
 */
let currentIndex;
let currentClick = 0;
let interval;


for (i = 0; i < ITEMS; i++) {
  let item = document.createElement('div');
  item.className = 'item';
  meshContainer.append(item);
}
const meshSize = meshContainer.children.length;

const startGame = () => {
  deactivateElement = null;
  currentScore = 0;
  interval = setInterval(runGameIteration, GAME_ITERATION_DURATION);
}

btnStart.addEventListener('click', startGame);

function runGameIteration() {
  if (deactivateElement) {
    deactivateElement();
  }
  let randomIndex = getRandomNumber(meshSize - 1);
  while (currentIndex === randomIndex) {
    randomIndex = getRandomNumber(meshSize - 1);
  }
  currentIndex = randomIndex;

  const activeElement = meshContainer.children[randomIndex];

  if (activeElement) {
    deactivateElement = activateElement(activeElement, randomIndex);
  }

  scoreContainer.innerText = currentScore;
  currentClick = 0;
  gameOwer();
}
const targetClick = e => {
  const targetItem = e.target.classList.contains('item-highlighted');
  currentClick += 1;
  oneClick(targetItem);
  twoClicks(targetItem);
  missClick(targetItem);
  console.log('currentScore', currentScore);

  // e.stopImmediatePropagation()
};

const oneClick = targetItem => {
  if (currentClick === 1 && targetItem) {
    currentScore += 1;
  }
};
const twoClicks = targetItem => {
  if (currentClick === 2 && targetItem) {
    currentScore -= 3;
  }
};

const missClick = targetItem => {
  if (currentClick === 1 && !targetItem) {
    currentScore -= 3;
  }
};

const noClick = () => {
  if (currentClick === 0) {
    currentScore -= 5;
  }
};

const changeColor = () => {
  if (currentScore >= 0) {
    meshContainer.style.backgroundColor = "#419884"
    scoreContainer.style.backgroundColor = "#419884"
  } else {
    meshContainer.style.backgroundColor = "#eb1c1c"
    scoreContainer.style.backgroundColor = "#eb1c1c"
  }
}

const gameOwer = () => {
  if (currentScore <= LOST_POINTS) {
    console.log('currentScore', currentScore);
    deactivateElement();
    clearInterval(interval);
    Notiflix.Notify.failure('You lost, try again!');
  }
  if (currentScore >= WIN_POINTS) {
    console.log('currentScore', currentScore);
    deactivateElement();
    clearInterval(interval);
    Notiflix.Notify.success('You won, congrats!');
  }
};
function activateElement(element, index) {
  const variant = getVariantForIndex(index);
  element.classList.add('item-highlighted', variant);
  meshContainer.addEventListener('click', targetClick);
changeColor()


  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.classList.remove('item-highlighted', variant);
    meshContainer.removeEventListener('click', targetClick);
    noClick();
  };
}

/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */
function getRandomNumber(max) {
  return Math.floor(Math.random() * max) % max;
}

function getVariantForIndex() {
  const variants = [
    'item-highlighted-1',
    'item-highlighted-2',
    'item-highlighted-3',
  ];
  return variants[getRandomNumber(variants.length)];
}
