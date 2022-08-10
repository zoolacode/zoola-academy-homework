const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
/**
   * @description A function to be executed after each game iteration, is set to null by default
   */
 let deactivateElement = null;
 /**
  * @description Current score
  */
 let currentScore = 0;
 /**
  * @description Count clicks
  */
 let countClicks = 0;
 //let clicks = myClick(0);
 scoreContainer.innerText = currentScore;
 /**
  * @description Game speed
  */
  let gameIterationDuration = 1000;

  let numberOfElements = 25;

  let colorNumber = null;
  let squareNum = null;
  /**
  * @description Round interval
  */
  let nIntervId = null;

  let meshSize = 1;
  /**
  * @description Score for end of the game
  */
  let winScoreAbs = 20;
  /**
  * @description Bonus score
  */
  let winStream = 0;

  let loseScore = -5;
  /**
  * @description Win round score
  */
  let winScore = 1;

/**
* @description Setting of Updatad version the game
*/
function startGame(){
  let typeGame = updateGame()
  switch(typeGame){
    case "simple":

    break;
    case "updated":
      updateSpeed()
      updateLoseRaund()
      updateWinRaund()
    break;
  }
  start();
}

function start(){
  countClicks = 0;
  currentScore = 0;
  meshContainer.innerHTML = '';
  clearInterval(nIntervId);
  nIntervId = null;
  
  for(var i = 0; i<numberOfElements;i++){
    var container = document.createElement("div")
    container.classList.add("Item");
    container.addEventListener('click',missClick)
    meshContainer.appendChild(container)
  }

  meshSize = meshContainer.children.length;


  nIntervId = setInterval(runGameIteration, gameIterationDuration);
  updateScore()
}

function runGameIteration() {
  /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */
  if(winStream>2){
    updateScore(3)
  }
  
  if (deactivateElement) {
    deactivateElement();
  }

  let randomIndex = getRandomNumber(meshSize - 1);
  if(squareNum){
    while (squareNum === randomIndex) {
      randomIndex = getRandomNumber(meshSize - 1);
    }
  }

  squareNum = randomIndex;
  
  const activeElement = meshContainer.children[randomIndex];

  if (activeElement) {
    deactivateElement = activateElement(activeElement, randomIndex);
  }
  
  if(Math.abs(currentScore)>=winScoreAbs){
    activeElement.classList.remove("item-highlighted");
    clearInterval(nIntervId);
    nIntervId = null;
  }
}

function activateElement(element, index) {
  const variant = getVariantForIndex(index);
  element.classList.add("item-highlighted", variant);
  element.removeEventListener('click',missClick)
  element.addEventListener("click",myClick)

  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    if(countClicks===0 && Math.abs(currentScore)<winScoreAbs){
      updateScore(loseScore)
    }
    countClicks = 0;
    element.classList.remove("item-highlighted", variant);
    element.removeEventListener("click", myClick)
    element.addEventListener('click',missClick)
    
  };
}

/**
  * @description Click logic
  */
function myClick() {
  countClicks++
  winStream++
  if(countClicks>1){
    updateScore(-2)
    winStream = 0;
  } else {
    updateScore(winScore)
    clearInterval(nIntervId);
    //nIntervId = null;
    runGameIteration();
    nIntervId = setInterval(runGameIteration, gameIterationDuration);
  }
}

function missClick(){
  winStream = 0;
  updateScore(-3)
}

/**
 * @description This function takes an integer and update score variable and check color of score
 */
function updateScore(addScore = 0){ 
  currentScore+=addScore
  scoreContainer.innerText = currentScore;
  if(currentScore>=0){
    scoreContainer.classList.remove("negative-score")
    scoreContainer.classList.add("positive-score")
  } else {
    scoreContainer.classList.remove("positive-score")
    scoreContainer.classList.add("negative-score")
  }
};

/**
   * @description This function takes an integer and returns a random integer between 0 and the given number
   */
 function getRandomNumber(max) {
  return Math.floor(Math.random() * (max+1)); //% max;
}

function getVariantForIndex(index) {
  const variants = [
    "item-highlighted-1",
    "item-highlighted-2",
    "item-highlighted-3",
    "item-highlighted-4",
    "item-highlighted-5",
    "item-highlighted-6",
  ];
  let tmpNum = getRandomNumber(variants.length-1);
  if(colorNumber){
    while(colorNumber == tmpNum){
      tmpNum = getRandomNumber(variants.length-1) ;
    }
  }
  colorNumber = tmpNum;
  return variants[colorNumber];
}

function updateGame() {
  var select = document.getElementById('type');
  var option = select.options[select.selectedIndex];
  let additiveConditions = document.getElementsByClassName("type-game-add")
  
  if(option.value === "updated"){
    for (let index = 0; index < additiveConditions.length; index++) {
      const element = additiveConditions[index];
      element.classList.add("type-game-add-active")
    }
  }else{
    for (let index = 0; index < additiveConditions.length; index++) {
      const element = additiveConditions[index];
      element.classList.remove("type-game-add-active")
    }
  }
  
  return option.value;
}


function updateSpeed() {
  var select = document.getElementById('speed');
  var option = select.options[select.selectedIndex];
  gameIterationDuration = Number(option.value)
}

function updateLoseRaund(){
  var select = document.getElementById('loseRaund');
  var option = select.options[select.selectedIndex];
  loseScore = Number(option.value)
}

function updateWinRaund(){
  var select = document.getElementById('winRaund');
  var option = select.options[select.selectedIndex];
  winScore = Number(option.value)
}
