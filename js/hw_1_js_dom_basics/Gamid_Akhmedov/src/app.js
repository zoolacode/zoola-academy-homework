const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
const startBtn = document.querySelector(".button_start");

/**
 * @description A function to be executed after each game iteration, is set to null by default
 */
let deactivateElement = null;
/**
 * @description Current score
 */
let currentScore = 0;
let currentClicks = 1;
scoreContainer.innerText = currentScore;
/**
 * @description Game speed
 */
let gameIterationDuration = 500;

let prevIndex;

for (let i = 0; i < 25; i++) {
  let element = document.createElement("div");
  element.classList.add("item");
  meshContainer.appendChild(element);
}

const meshSize = meshContainer.children.length;

let interval;

const onGameStart = () => {
  interval = setInterval(runGameIteration, gameIterationDuration);

  startBtn.removeEventListener("click", onGameStart);
};

startBtn.addEventListener("click", onGameStart);

let restart = () => {
  runGameIteration();
  interval = setInterval(runGameIteration, gameIterationDuration);
};

function runGameIteration() {
  if (deactivateElement) {
    deactivateElement();
  }

  let randomIndex;

  do {
    randomIndex = getRandomNumber(meshSize - 1);
  } while (randomIndex === prevIndex);

  const activeElement = meshContainer.children[randomIndex];
  prevIndex = randomIndex;

  const meshClick = (e) => {
    if (e.target.classList.contains("item-highlighted")) {
      if (currentScore > -20) {
        meshContainer.removeEventListener("click", meshClick);
        currentScore += 1;
        currentClicks += 1;
        scoreContainer.innerText = currentScore;
        if (currentScore >= 20) {
          clearInterval(interval);
        } else {
          clearInterval(interval);
          restart();
        }
      } else {
        meshContainer.removeEventListener("click", meshClick);
      }
    } else {
      currentScore -= 3;
    }
    e.stopImmediatePropagation();
  };

  meshContainer.addEventListener("click", meshClick);

  if (activeElement) {
    deactivateElement = activateElement(activeElement);
  }

  if (currentClicks === 0) {
    currentScore -= 5;
  }

  scoreContainer.innerText = currentScore;
  currentClicks = 0;

  if (currentScore >= 0) {
    meshContainer.style.backgroundColor = "#419884";
  } else {
    meshContainer.style.backgroundColor = "#ba7474";
  }

  if (currentScore <= -20) {
    clearInterval(interval);
  }
}

function activateElement(element) {
  const variant = getVariantForIndex();
  element.classList.add("item-highlighted", variant);

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
    "item-highlighted-4",
    "item-highlighted-5",
    "item-highlighted-6",
  ];
  return variants[getRandomNumber(variants.length)];
}
