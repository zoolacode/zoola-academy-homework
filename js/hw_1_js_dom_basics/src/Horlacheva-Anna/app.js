const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");

for(i = 0; i <= 24; i++){
    let item = document.createElement('div');
    item.className = 'item';
    meshContainer.append(item);
  };
  const meshSize = meshContainer.children.length;

/* 
 * @description A function to be executed after each game iteration, is set to null by default
 */

let deactivateElement = null;

/* 
 * @description Current score
 */
let currentScore = 0;
scoreContainer.innerText = 0;
let activeIndex;
let isClicked =0:

/* 
 * @description Game speed
 */

let gameIterationDuration = 1500;
let intervalID;

setInterval(runGameIteration, gameIterationDuration);

function runGameIteration() {
    
  /* 
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */
  if (deactivateElement) {
    deactivateElement();
  };

  let randomIndex = getRandomNumber(meshSize - 1);

  if(randomIndex === activeIndex) {
    randomIndex = getRandomNumber(meshSize);
  };

  activeIndex = randomIndex;

  let activeElement = meshContainer.children[randomIndex];

  if (activeElement) {
    deactivateElement = activateElement(activeElement, randomIndex);
  };

  scoreContainer.innerText = currentScore;
  isClicked = 0;

  gameOver ();
};

function gameOver () {
    if (currentScore >= 24) {
        deactivateElement ();
        clearInterval (intervalID);
        alert ('Great job, Honeybunny!');
    } else if (currentScore <= -20) {
        deactivateElement ();
        clearInterval (intervalID);
        alert ('So sorry, Sweetie');
    };
};

function sucsess(){
    if (isClicked = 1){
    currentScore +=4;
    scoreContainer.innerText = currentScore;
    clearInterval(intervalID);
    deactivateElement();
    intervalID = setInterval(runGameIteration, gameIterationDuration);
    runGameIteration();
    };
    };

function doNothing(){
    if (isClicked === 0) {
    currentScore -=5; 
    };
};

function miss(){
    currentScore -=3;
    scoreContainer.innerText = currentScore;
};

function scoreboardColor() {
    if (currentScore < 0) {
      scoreContainer.style.backgroundColor = 'red';
    } else {
      scoreContainer.style.backgroundColor = 'green';
    };
  };
 
function activateElement(element, index) {
  const variant = getVariantForIndex(index);
  element.classList.add("item-highlighted", variant);
  element.addEventListener('click', sucsess);
  meshContainer.addEventListener('click', miss);
  element.addEventListener('click', gameOver);
  /*
   * activateElement returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have variant and element available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.classList.remove("item-highlighted", variant);
    element.removeEventListener('click', sucsess);
    meshContainer.removeEventListener('click', miss);
    doNothing();
    scoreboardColor();
    
  };
};

/*
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */
function getRandomNumber(max) {
  return Math.floor(Math.random() * 10) % max;
};

function getVariantForIndex(index) {
  const variants = [
    "item-highlighted-1",
    "item-highlighted-2",
    "item-highlighted-3",
  ];
  return variants[getRandomNumber(variants.length)];
};
//# sourceMappingURL=index.816e7b21.js.map
