const meshContainer = document.querySelector(".mesh");
const scoreContainer = document.querySelector(".score");
const gameStart = document.querySelector(".btn_start ");
const fastModeBtn = document.querySelector(".mode_500");
const normalModeBtn = document.querySelector(".mode_1000");
const slowModeBtn = document.querySelector(".mode_1500");
fastModeBtn.addEventListener("click", fastMode);
normalModeBtn.addEventListener("click", mediumMode);
slowModeBtn.addEventListener("click", slowMode);
for(i = 0; i <= 24; i++){
    let item = document.createElement("div");
    item.className = "item";
    meshContainer.append(item);
}
const meshSize = meshContainer.children.length;
gameStart.addEventListener("click", start);
let deactivateElement = null;
scoreContainer.innerText = 0;
let activeIndex;
let currentScore = 0;
let fine = 0;
let gameIterationDuration = 1000;
/**
 * @description Game speed
 */ let interval;
function runGameIteration() {
    if (deactivateElement) deactivateElement();
    let randomIndex = getRandomNumber(meshSize);
    if (randomIndex === activeIndex) randomIndex = getRandomNumber(meshSize);
    activeIndex = randomIndex;
    let activeElement = meshContainer.children[randomIndex];
    if (activeElement) deactivateElement = activateElement(activeElement, randomIndex);
    scoreContainer.innerText = currentScore;
    fine = 0;
    end();
}
function start() {
    deactivateElement = null;
    currentScore = 0;
    interval = setInterval(runGameIteration, gameIterationDuration);
}
function end() {
    if (currentScore >= 20) {
        deactivateElement();
        clearInterval(interval);
        alert("You won");
    } else if (currentScore <= -20) {
        deactivateElement();
        clearInterval(interval);
        alert("You lost");
    }
}
function slowMode() {
    gameIterationDuration = 1500;
    fastModeBtn.style.backgroundColor = "#002255";
    normalModeBtn.style.backgroundColor = "#002255";
    slowModeBtn.style.backgroundColor = "green";
}
function mediumMode() {
    gameIterationDuration = 1000;
    fastModeBtn.style.backgroundColor = "#002255";
    normalModeBtn.style.backgroundColor = "green";
    slowModeBtn.style.backgroundColor = "#002255";
}
function fastMode() {
    gameIterationDuration = 500;
    fastModeBtn.style.backgroundColor = "green";
    normalModeBtn.style.backgroundColor = "#002255";
    slowModeBtn.style.backgroundColor = "#002255";
}
function score(e) {
    e.stopPropagation();
    ++fine;
    if (fine <= 1) {
        ++currentScore;
        scoreContainer.innerText = currentScore;
        clearInterval(interval);
        deactivateElement();
        interval = setInterval(runGameIteration, gameIterationDuration);
        runGameIteration();
    } else {
        currentScore -= 2;
        scoreContainer.innerText = currentScore;
    }
}
function scoreboardColor() {
    if (currentScore < 0) scoreContainer.style.backgroundColor = "#ff0000";
    else scoreContainer.style.backgroundColor = "green";
}
function inactivity() {
    if (fine === 0) currentScore -= 5;
}
function missTarget() {
    currentScore -= 3;
    scoreContainer.innerText = currentScore;
}
function activateElement(element, index) {
    const variant = getVariantForIndex(index);
    element.classList.add("item-highlighted", variant);
    element.addEventListener("click", score);
    meshContainer.addEventListener("click", missTarget);
    return function unhighlight() {
        element.classList.remove("item-highlighted", variant);
        element.removeEventListener("click", score);
        meshContainer.removeEventListener("click", missTarget);
        inactivity();
        scoreboardColor();
    };
}
/**
 * @description This function takes an integer and returns a random integer between 0 and the given number
 */ function getRandomNumber(max) {
    return Math.floor(Math.random() * (max - 1 + 1));
}
function getVariantForIndex() {
    const variants = [
        "item-highlighted-1",
        "item-highlighted-2",
        "item-highlighted-3", 
    ];
    return variants[getRandomNumber(variants.length)];
}

//# sourceMappingURL=index.816e7b21.js.map
