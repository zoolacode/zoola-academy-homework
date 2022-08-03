const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
const startGame = document.querySelector(".btn_start ");
const mode_500 = document.querySelector(".mode_500");
const mode_1000 = document.querySelector(".mode_1000");
const mode_1500 = document.querySelector(".mode_1500");

for(i = 0; i <= 24; i++){
  let item = document.createElement('div');
  item.className = 'item';
  meshContainer.append(item);
};

const meshSize = meshContainer.children.length;

mode_500.addEventListener('click', fastMode);
mode_1000.addEventListener('click', mediumMode);
mode_1500.addEventListener('click', slowMode);

startGame.addEventListener('click', start);
/**
 * @description A function to be executed after each game iteration, is set to null by default 
 */
let deactivateElement = null;
/**
 * @description Current score
 */
 scoreContainer.innerText = 0;
let activeIndex;
let currentScore = 0;
let penalty = 0;

/**
 * @description Game speed
 */
let gameIterationDuration = 1000;
let intervalID;

function runGameIteration() {

  /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */  
  if (deactivateElement) {
    deactivateElement();
  };  

  let randomIndex = getRandomNumber(meshSize);

  if(randomIndex === activeIndex) {
    randomIndex = getRandomNumber(meshSize);
  };

  activeIndex = randomIndex;

  let activeElement = meshContainer.children[randomIndex];
 
  if (activeElement) {
    deactivateElement = activateElement(activeElement, randomIndex);
  };
  
  
  
  scoreContainer.innerText = currentScore;

  penalty = 0;

  gameEnd();
};

function start() {
  deactivateElement = null;
  currentScore = 0;
  intervalID = setInterval(runGameIteration, gameIterationDuration);
  };

function gameEnd() {
  if (currentScore >= 20) {
    deactivateElement();
    clearInterval(intervalID);
    alert('You won');
  } else if (currentScore <= -20) {
    deactivateElement();
    clearInterval(intervalID);
    alert('You lost');
  };
};

function slowMode() {
  gameIterationDuration = 1500;
  mode_500.style.backgroundColor = '#ff7b47';
  mode_1000.style.backgroundColor = '#ff7b47';
  mode_1500.style.backgroundColor = 'green';
};

function mediumMode() {
  gameIterationDuration = 1000;
  mode_500.style.backgroundColor = '#ff7b47';
  mode_1000.style.backgroundColor = 'green';
  mode_1500.style.backgroundColor = '#ff7b47';
};

function fastMode() {
  gameIterationDuration = 500;
  mode_500.style.backgroundColor = 'green';
  mode_1000.style.backgroundColor = '#ff7b47';
  mode_1500.style.backgroundColor = '#ff7b47';
};

function score(e) {
  e.stopPropagation();
  ++penalty;
  if (penalty <= 1) {
    ++currentScore;
    scoreContainer.innerText = currentScore;
    clearInterval(intervalID);
    deactivateElement();
    intervalID = setInterval(runGameIteration, gameIterationDuration);
    runGameIteration();
  } else {
    --currentScore;
    --currentScore;
    scoreContainer.innerText = currentScore;
  };
};

function afk() {
  if (penalty === 0) {
    currentScore -= 5;
  };
};

function scoreboardColor() {
  if (currentScore < 0) {
    scoreContainer.style.backgroundColor = '#cc4040';
  } else {
    scoreContainer.style.backgroundColor = 'green';
  };
};

function missTarget() {
  currentScore -= 3;
  scoreContainer.innerText = currentScore;
};

function activateElement(element, index) {
  const variant = getVariantForIndex(index);
  element.classList.add("item-highlighted", variant);
  element.addEventListener('click', score);
  meshContainer.addEventListener('click', missTarget)

  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.classList.remove("item-highlighted", variant);
    element.removeEventListener('click', score);
    meshContainer.removeEventListener('click', missTarget);
    afk();
    scoreboardColor();
  };
};

/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */
function getRandomNumber(max) {
  return Math.floor(0 + Math.random() * ((max - 1) + 1 - 0));
};

function getVariantForIndex() {
  const variants = [
    "item-highlighted-1",
    "item-highlighted-2",
    "item-highlighted-3",
  ];
  return variants[getRandomNumber(variants.length)];
};
