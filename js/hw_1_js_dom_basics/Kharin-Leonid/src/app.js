// Невиконані завдання:

// Змінити алгоритм вибору варіанту (кольору) активного елементу на 
// такий що базується на Math.random(). (2 бали)

// Параметризуйте свій код таким чином щоб кожне з правил було прив‘язане
// до константи (наприклад, штрафи за програний раунт та лишні кліки, 
// винагорода за виграний раунд, швидкість гри та інше). (1.5 бали)

// Після успішного кліку по активному елементу, наступна ітерація гри
// запускається миттєво, не чекаючи доки сплинуть 1000 мілісекунд (3 бали)




const meshContainer = document.querySelector(".mesh");
for(let i=0, el ; i<24; i++){
  el = document.createElement("div")
  el.classList.add("item")
  meshContainer.appendChild(el)  
}

const meshSize = meshContainer.children.length;
const scoreContainer = document.querySelector(".score");

let temp;
let deactivateElement = null;
let currentScore = 0;
let gameIterationDuration = 1000;
currentScoreColor()

scoreContainer.innerText = currentScore;
let masForRandomIndex=["samsa"] // feature for (not to repeat randomIndex)

intervalId = setInterval(runGameIteration, gameIterationDuration);

function runGameIteration() {

  if (deactivateElement) {
    deactivateElement();
  }

  let randomIndex = getRandomNumber(meshSize - 1);
  while (masForRandomIndex[0]===randomIndex){
    randomIndex = getRandomNumber(meshSize - 1);
  }
  masForRandomIndex.push(randomIndex)
  masForRandomIndex.shift()

  let activeElement = meshContainer.children[randomIndex];
  if (activeElement) {
    deactivateElement = activateElement(activeElement, randomIndex);
  }

  temp = 0;
}

function calculation(event){
  
  temp++;
  event.stopPropagation();
  if (temp===1){
    currentScore++;
    scoreContainer.innerText = currentScore;
  } else{
    console.log("fff")
    currentScore-=2;
    scoreContainer.innerText = currentScore;
  }
  currentScoreColor()

  result()
}

function noClick(){

  if (temp===0) {
    currentScore-=5;
    scoreContainer.innerText = currentScore;
    currentScoreColor()

    result()
  }
}

function result(){

  if (currentScore<-19){
    alert("Loser")
    clearInterval(intervalId)
    deactivateElement()
  } else if(currentScore>19){
    alert("Winner")
    clearInterval(intervalId)
    deactivateElement()
  }
}

function missClick(){
  
  currentScore -= 3;
  scoreContainer.innerText = currentScore;
  currentScoreColor()

  result()
}



function activateElement(element, index) {

  let variant = getVariantForIndex(index);
  element.classList.add("item-highlighted", variant);
  element.addEventListener('click', calculation);  
  meshContainer.addEventListener('click', missClick) 
  noClick()

  return function unhighlight() {
    element.classList.remove("item-highlighted", variant);
    element.removeEventListener('click', calculation);      
    meshContainer.removeEventListener('click', missClick); 
  };
}

function getRandomNumber(max) {
  return Math.floor(Math.random()*max)
}
function getVariantForIndex(index) {
  const variants = [
    "item-highlighted-1",
    "item-highlighted-2",
    "item-highlighted-3",
  ];
  return variants[index % variants.length];
}
function currentScoreColor(){
  if (currentScore>-1){
    scoreContainer.style.backgroundColor = "green"
  } else{
    scoreContainer.style.backgroundColor = "red"
  }    
}




