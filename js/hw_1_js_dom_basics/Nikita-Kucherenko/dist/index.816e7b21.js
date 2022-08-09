const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
const meshSize = meshContainer.children.length;
/**
 * @description A function to be executed after each game iteration, is set to null by default
 */ let deactivateElement = null;
/**
 * @description Current score
 */ let currentScore = 0;
/**
 * @description Game speed
 */ let gameIterationDuration = 1000;
setInterval(runGameIteration, gameIterationDuration);
function runGameIteration() {
    /**
   * Alternatively, this could be written like following: deactivateElement?.()
   * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Optional_chaining
   */ if (deactivateElement) deactivateElement();
    const randomIndex = getRandomNumber(meshSize - 1);
    const activeElement = meshContainer.children[randomIndex];
    if (activeElement) deactivateElement = activateElement(activeElement, randomIndex);
    scoreContainer.innerText = currentScore;
}
function activateElement(element, index) {
    const variant = getVariantForIndex(index);
    element.classList.add("item-highlighted", variant);
    /**
   * `activateElement` returns a clean-up function that we can later execute to undo any changes made to the active element.
   * It it very convenient to have such function defined immediately, while we still have `variant` and `element` available.
   * A mechanism of returning a function is called "closure".
   */ return function unhighlight() {
        element.classList.remove("item-highlighted", variant);
    };
}
/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */ function getRandomNumber(max) {
    return Math.floor(Math.random() * 10) % max;
}
function getVariantForIndex(index) {
    const variants = [
        "item-highlighted-1",
        "item-highlighted-2",
        "item-highlighted-3", 
    ];
    return variants[index % variants.length];
}

//# sourceMappingURL=index.816e7b21.js.map
