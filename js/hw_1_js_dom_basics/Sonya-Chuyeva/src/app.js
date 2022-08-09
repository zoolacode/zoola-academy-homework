const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");

const startButton = document.querySelector(".btn");
const select = document.querySelector('.select');
const itemsAmount = 25;

for(let i = 0; i < itemsAmount; i++) {
     var item = document.createElement("div");
     item.classList.add('item')
     meshContainer.append(item);
     
}

const meshSize = meshContainer.children.length;
const oneClick = 1;
const multipleClick = 2;
const missedClick = 5;
const clickOutElement = 3;
const finalScore = 20;

var isElementClicked = true;

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

let activeElement = 0;
let gameIterationDuration = 500;

let randomIndex;

var intervalID;

function chooseSpeed(e){
  gameIterationDuration = e.target.value;
}


select.addEventListener('change',chooseSpeed);
startButton.addEventListener('click',startGame);

function startGame() {
 
  deactivateElement = null;
  currentScore = 0
  scoreContainer.innerText = currentScore;
  intervalID = setInterval(runGameIteration, gameIterationDuration);
   
}


function getIndex() {
  while(true){
    newIndex = getRandomNumber(meshSize - 1);
    if(randomIndex !== newIndex) {
      return newIndex;
    }
  }

}


 
function immediateInterval(gameFunction, interval) {
  if(currentScore >= finalScore || currentScore <= -finalScore){
    stopGame(activeElement);
  } else 
  {
    gameFunction()
    return intervalID = setInterval(gameFunction, interval);
  }
    
}

function runGameIteration() {
   
  /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */
  if (deactivateElement) {
    deactivateElement();
  }

  randomIndex = getIndex()
  activeElement = meshContainer.children[randomIndex];

  noClick();

  changeColorScore();

  if (activeElement) {
    deactivateElement = activateElement(activeElement);
    isElementClicked = false;
  }
  scoreContainer.innerText = currentScore;

  
  if (currentScore >= finalScore || currentScore <= -finalScore) {
    stopGame(activeElement);
  }
  

}


function clickHandle(e){
    if(e.target == activeElement && e.detail == oneClick){  
        currentScore += oneClick;
        scoreContainer.innerText = currentScore;
    } else if (e.target == activeElement && e.detail >= multipleClick){
        currentScore -= multipleClick;
        scoreContainer.innerText = currentScore;
            
    } 
        changeColorScore();
        isElementClicked = true;

        clearInterval(intervalID);
        immediateInterval(runGameIteration,gameIterationDuration);

    }
 
function clickOutsideElement(e) {
    if (!e.target.closest(".item-highlighted")) {
        currentScore -= clickOutElement;
        scoreContainer.innerText = currentScore;
            
        }
    }

function noClick(){
    if(!isElementClicked){
    currentScore -= missedClick;
    scoreContainer.innerText = currentScore;
       }
    }

    
function changeColorScore(){
       if(currentScore > 0){
        scoreContainer.style.backgroundColor = '#419884'
       } else {
        scoreContainer.style.backgroundColor = '#cc4040'
       }
   }
    
  
function activateElement(element) {
  const variant = getVariantForIndex();
  element.classList.add("item-highlighted", variant);
  element.addEventListener('click', clickHandle);
  meshContainer.addEventListener('click',clickOutsideElement);


  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    element.classList.remove("item-highlighted", variant);
   
    
  };
}

/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */
function getRandomNumber(max) {
  return Math.floor(Math.random() * 10) % max;
}


function getVariantForIndex() {
  const variants = [
    "item-highlighted-1",
    "item-highlighted-2",
    "item-highlighted-3",
  ];
  return variants[getRandomNumber(meshSize - 1) % variants.length];
}



function stopGame(element)  {
        alert('GAME OVER')
        deactivateElement();
        element.removeEventListener('click',clickHandle);
        meshContainer.removeEventListener('click',clickOutsideElement);
        clearInterval(intervalID);
  
}
