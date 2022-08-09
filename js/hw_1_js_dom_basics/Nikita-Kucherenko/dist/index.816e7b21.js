const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
scoreContainer.textContent = 0;
scoreContainer.style.background = "green";
/**
 * @description cycle for creating items into mesh
 */ for(let i = 0; i < 25; i++){
    const item = createElement("div", "item");
    meshContainer.appendChild(item);
}
const meshSize = meshContainer.children.length;
const arrayOfElements = meshContainer.getElementsByClassName("item");
const rules = {
    gameSpeed: 1000,
    positiveСlick: 1,
    negativeClick: 2,
    onOutsideActiveElement: ()=>{
        for(let i1 = 0; i1 < arrayOfElements.length; i1++)arrayOfElements[i1].addEventListener("click", (e)=>{
            const currentElement = e.target;
            if (!currentElement.classList.contains("item-highlighted")) {
                if (currentScore > -20 && currentScore < 20) {
                    currentScore -= 3;
                    scoreContainer.innerText = currentScore;
                }
            }
            console.log("click");
            currentScore < 0 ? scoreContainer.style.background = "red" : scoreContainer.style.background = "green";
        });
    },
    onActiveElement: ()=>{
        currentClick = currentClick + 1;
        if (currentClick >= rules.negativeClick) currentScore -= 2;
        else if (currentClick === rules.positiveСlick) currentScore += 1;
        scoreContainer.innerText = currentScore;
    }
};
/**
 * @description A function to be executed after each game iteration, is set to null by default
 */ let deactivateElement = null;
/**
 * @description Current score
 */ let currentScore = 0;
/**
 * @description Current click
 */ let currentClick = 0;
/**
 * @description previous index of  active elemnt
 */ let prevIndexOfElement = 0;
/**
 * @description previous index of  active color
 */ let prevIndexOfColor = 0;
const gameInterval = setInterval(runGameIteration, rules.gameSpeed);
function runGameIteration() {
    /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */ if (deactivateElement) deactivateElement();
    const randomIndexOfActiveEl = getNoRepeatedRandomIndex(prevIndexOfElement, meshSize);
    const activeElement = meshContainer.children[randomIndexOfActiveEl];
    if (activeElement) deactivateElement = activateElement(activeElement, randomIndexOfActiveEl);
    scoreContainer.innerText = currentScore;
    currentScore < 0 ? scoreContainer.style.background = "red" : scoreContainer.style.background = "green";
    if (currentScore < -20 || currentScore > 20) {
        clearInterval(gameInterval);
        deactivateElement();
    }
}
function activateElement(element, index) {
    const variant = getVariantForIndex();
    element.classList.add("item-highlighted", variant);
    element.addEventListener("click", rules.onActiveElement);
    /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */ return function unhighlight() {
        prevIndexOfElement = index;
        element.classList.remove("item-highlighted", variant);
        element.removeEventListener("click", rules.onActiveElement);
        if (currentClick === 0) currentScore -= 5;
        currentClick = 0;
    };
}
rules.onOutsideActiveElement();
/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */ function getRandomNumber(max) {
    return Math.floor(Math.random() * max);
}
function getVariantForIndex() {
    const variants = [
        "item-highlighted-1",
        "item-highlighted-2",
        "item-highlighted-3", 
    ];
    const maxIndex = variants.length;
    const randomColorIndex = getNoRepeatedRandomIndex(prevIndexOfColor, maxIndex);
    prevIndexOfColor = randomColorIndex;
    return variants[randomColorIndex];
}
/**
 * @description This function created index and replace index if it repeated 
 */ function getNoRepeatedRandomIndex(prevIndex, maxIndex) {
    const newIndex = getRandomNumber(maxIndex);
    if (prevIndex !== newIndex) return newIndex;
    return getNoRepeatedRandomIndex(prevIndex, maxIndex);
}
/**
 * @description The function for creating a new element
 */ function createElement(element, className) {
    const newElement = document.createElement(element);
    newElement.classList.add(className);
    return newElement;
}

//# sourceMappingURL=index.816e7b21.js.map
