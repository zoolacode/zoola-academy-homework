const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
const items = 24

let gameIterationDuration = 1500;
let intervalID;

function startGame(){
  intervalID = null; 

for(i = 0; i <= items; i++){
    let item = document.createElement('div');
    item.className = 'item';
    meshContainer.append(item);
  };
    const meshSize = meshContainer.children.length;

  intervalID = setInterval(runGameIteration, gameIterationDuration);
};

let deactivateElement = null;

let currentScore = 0;
scoreContainer.innerText = 0;
let activeIndex = null;
let isClicked = 0;


const sucsessClick = 1
const clickMiss = 3
const afkIteration = 5

function runGameIteration() {
    
 
  if (deactivateElement) {
    deactivateElement();
  };

  let randomIndex = getRandomNumber(meshSize - 1);
  if(currentIndex){
  
  while (currentIndex === randomIndex) {
    randomIndex = getRandomNumber(meshSize - 1);
  };
};

  currentIndex = randomIndex;

  const activeElement = meshContainer.children[randomIndex];

  if (activeElement) {
    deactivateElement = activateElement(activeElement, randomIndex);
  };

  scoreContainer.innerText = currentScore;
  isClicked = 0;

  gameOver ();
};

const scoreResult = 20;

function gameOver () {
    if (currentScore >= scoreResult) {
        deactivateElement ();
        clearInterval (intervalID);
    } else if (currentScore <= -scoreResult) {
        deactivateElement ();
        clearInterval (intervalID);
    };
};

function sucsess(){
    if (isClicked = 1){
    currentScore +=sucsessClick;
    scoreContainer.innerText = currentScore;
    clearInterval(intervalID);
    deactivateElement();
    intervalID = setInterval(runGameIteration, gameIterationDuration);
    runGameIteration();
    };
    };


function doNothing(){
    if (isClicked === 0) {
    currentScore -=afkIteration; 
    };
};

function miss(){
    currentScore -=clickMiss;
    scoreContainer.innerText = currentScore;
};


function scoreboardColor() {
    if (currentScore < 0) {
      scoreContainer.style.backgroundColor = 'red';
    } else if (currentScore >= 0) {
      scoreContainer.style.backgroundColor = 'green';
    };
 };
 
function activateElement(element, index) {
  const variant = getVariantForIndex(index);
  element.classList.add("item-highlighted", variant);
  element.addEventListener('click', sucsess);
  meshContainer.addEventListener('click', miss);
  
  return function unhighlight() {
    element.classList.remove("item-highlighted", variant);
    element.removeEventListener('click', sucsess);
    meshContainer.removeEventListener('click', miss);
    doNothing();
    scoreboardColor();
  };
};


function getRandomNumber(max) {
  return Math.floor(Math.random() * (max + 1));
};

function getVariantForIndex(index) {
  const variants = [
    "item-highlighted-1",
    "item-highlighted-2",
    "item-highlighted-3",
  ];
  return variants[getRandomNumber(variants.length)];
};
