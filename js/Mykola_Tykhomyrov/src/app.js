const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
const startGame = document.querySelector(".btn_start ");
const mode500 = document.querySelector(".mode_500");
const mode1000 = document.querySelector(".mode_1000");
const mode1500 = document.querySelector(".mode_1500");
const wonGame = document.querySelector(".won__game");
const lostGame = document.querySelector(".lost__game");
const againPlayWonBtn = document.querySelector(".won_game_btn");
const againPlayLostBtn = document.querySelector(".lost_game_btn");

const win = 20;
const lose = -20;
const numberOfSlote = 25;
const fastGame = 500;
const mediumGame = 1000;
const slowGame = 1500;
const missClickPenalty = 3;
const afkPenalty = 5;
const notAfkPlay = 1;
const correctClick = 1;

for(i = 1; i <= numberOfSlote; i++){
  let item = document.createElement('div');
  item.classList = 'item';
  meshContainer.append(item);
};

const meshSize = meshContainer.children.length;

mode500.addEventListener('click', onFastModeClick);
mode1000.addEventListener('click', onMediumModeClick);
mode1500.addEventListener('click', onSlowModeClick);
againPlayWonBtn.addEventListener('click', () => wonGame.style.visibility = 'hidden');
againPlayLostBtn.addEventListener('click', () => lostGame.style.visibility = 'hidden');

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

  gameOver();
};

function start() {
  deactivateElement = null;
  currentScore = 0;
  intervalID = setInterval(runGameIteration, gameIterationDuration);
  mode500.removeEventListener('click', onFastModeClick);
  mode1000.removeEventListener('click', onMediumModeClick);
  mode1500.removeEventListener('click', onSlowModeClick);
  startGame.removeEventListener('click', start);
};

function gameOver() {
  if(currentScore >= win || currentScore <= lose) {
    if(currentScore >= win) {
      wonGame.style.visibility = 'visible';
    } else if(currentScore <= lose) {
      lostGame.style.visibility = 'visible';
    };
    deactivateElement();
    clearInterval(intervalID);
    mode500.addEventListener('click', onFastModeClick);
    mode1000.addEventListener('click', onMediumModeClick);
    mode1500.addEventListener('click', onSlowModeClick);
    startGame.addEventListener('click', start);
    
  };
};

function onSlowModeClick() {
  gameIterationDuration = slowGame;
  mode500.style.backgroundColor = '#ff7b47';
  mode1000.style.backgroundColor = '#ff7b47';
  mode1500.style.backgroundColor = 'green';
};

function onMediumModeClick() {
  gameIterationDuration = mediumGame;
  mode500.style.backgroundColor = '#ff7b47';
  mode1000.style.backgroundColor = 'green';
  mode1500.style.backgroundColor = '#ff7b47';
};

function onFastModeClick() {
  gameIterationDuration = fastGame;
  mode500.style.backgroundColor = 'green';
  mode1000.style.backgroundColor = '#ff7b47';
  mode1500.style.backgroundColor = '#ff7b47';
};

function onScoreClick(e) {
  e.stopPropagation();
  penalty = notAfkPlay;
  currentScore += correctClick;
  scoreContainer.innerText = currentScore;
  clearInterval(intervalID);
  deactivateElement();
  intervalID = setInterval(runGameIteration, gameIterationDuration);
  runGameIteration();
};

function afk() {
  if (penalty === 0) {
    currentScore -= afkPenalty;
  };
};

function scoreboardColor() {
  if (currentScore < 0) {
    scoreContainer.style.backgroundColor = '#cc4040';
  } else {
    scoreContainer.style.backgroundColor = 'green';
  };
};

function onMissTargetClick() {
  currentScore -= missClickPenalty;
  scoreContainer.innerText = currentScore;
};

function activateElement(element, index) {
  const variant = getVariantForIndex(index);
  element.classList.add("item-highlighted", variant);
  element.addEventListener('click', onScoreClick);
  meshContainer.addEventListener('click', onMissTargetClick);

  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.classList.remove("item-highlighted", variant);
    element.removeEventListener('click', onScoreClick);
    meshContainer.removeEventListener('click', onMissTargetClick);
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
