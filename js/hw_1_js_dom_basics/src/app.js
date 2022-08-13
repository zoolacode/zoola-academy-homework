const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
scoreContainer.textContent = 0
scoreContainer.style.background = "green"

/**
 * @description cycle for creating items into mesh
 */

for (let i = 0; i < 25; i++) {
  const item = createElement("div", "item")
  meshContainer.appendChild(item)
}

const meshSize = meshContainer.children.length;
const arrayOfElements = meshContainer.querySelectorAll('.item')
const classNameActiveElement = "item-highlighted"

const rules = {
  gameSpeed: 1000,
  positiveСlick: 1,
  negativeClick: 2,
  doubleClickPenalty: 2,
  outsideClickPenalty: 3,
  addingPointsInOneClick: 1,
  noClickPenalty: 5,
  maxPoints: 20,
  minPoints: -20,

  onOutsideActiveElementClick: () => {
    for (item of arrayOfElements) {
      item.addEventListener("click", e => {
        const currentElement = e.target
        if (!currentElement.classList.contains(classNameActiveElement)) {
          if (currentScore > rules.minPoints && currentScore < rules.maxPoints) {
            currentScore -= rules.outsideClickPenalty
            scoreContainer.innerText = currentScore;
          }
        }
        scoreContainer.style.background = currentScore < 0 ? "red" : "green"
      })
    }
  },

  onActiveElementClick: () => {
    currentClick = currentClick + 1
    if (currentClick >= rules.negativeClick) {
      currentScore -= rules.doubleClickPenalty
    } else if (currentClick === rules.positiveСlick) {
      currentScore += rules.addingPointsInOneClick
    }
    scoreContainer.innerText = currentScore;
  }
}

/**
 * @description A function to be executed after each game iteration, is set to null by default
 */
let deactivateElement = null;
/**
 * @description Current score
 */
let currentScore = 0;
/**
 * @description Current click
 */
let currentClick = 0;
/**
 * @description previous index of  active elemnt
 */
let prevIndexOfElement = 0
/**
 * @description previous index of  active color
 */
let prevIndexOfColor = 0

const gameInterval = setInterval(runGameIteration, rules.gameSpeed);

function runGameIteration() {
  /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */
  if (deactivateElement) {
    deactivateElement();
  }

  const randomIndexOfActiveEl = getNoRepeatedRandomIndex(prevIndexOfElement, meshSize);
  const activeElement = meshContainer.children[randomIndexOfActiveEl];

  if (activeElement) {
    deactivateElement = activateElement(activeElement, randomIndexOfActiveEl);
  }

  scoreContainer.innerText = currentScore;

  currentScore < 0 ? scoreContainer.style.background = "red" : scoreContainer.style.background = "green"

  if (currentScore < rules.minPoints || currentScore > rules.maxPoints) {
    clearInterval(gameInterval)
    deactivateElement();
  }
}


function activateElement(element, index) {
  const variant = getVariantForIndex();
  element.classList.add(classNameActiveElement, variant);
  element.addEventListener("click", rules.onActiveElementClick)

  /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */
  return function unhighlight() {
    prevIndexOfElement = index
    element.classList.remove(classNameActiveElement, variant);
    element.removeEventListener("click", rules.onActiveElementClick)
    if (currentClick === 0) { currentScore -= rules.noClickPenalty }
    currentClick = 0
  };
}

rules.onOutsideActiveElementClick()

/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */
function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

function getVariantForIndex() {
  const variants = [
    "item-highlighted-1",
    "item-highlighted-2",
    "item-highlighted-3",
  ];

  const maxIndex = variants.length
  const randomColorIndex = getNoRepeatedRandomIndex(prevIndexOfColor, maxIndex)
  prevIndexOfColor = randomColorIndex
  return variants[randomColorIndex];
}

/**
 * @description This function created index and replace index if it repeated 
 */
function getNoRepeatedRandomIndex(prevIndex, maxIndex) {
  const newIndex = getRandomNumber(maxIndex);
  if (prevIndex !== newIndex) {
    return newIndex
  }
  return getNoRepeatedRandomIndex(prevIndex, maxIndex)
}

/**
 * @description The function for creating a new element
 */
function createElement(element, className) {
  const newElement = document.createElement(element)
  newElement.classList.add(className)
  return newElement
}



