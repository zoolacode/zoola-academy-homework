import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";

// Good luck! :: Thanks!
const boardCellsWide = 25
const boardSize = Math.pow(boardCellsWide, 2)

const initialState = {
    firstPosition: { x: 10, y: 10 },
    foodPosition: { x: 0, y: 0 },
    snakePosition: [],
    snakeSize: 5,
    direction: "ArrowRight",
    isEnd: false,
    isPaused: false,
    score: 0,
    timer: 15,
    round: 0,
    gameSpeed: 1000
}

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
    return initialState;
});

engine.addSignalReducer("restartGame", () => {
    return initialState
})

engine.addGlobalReducer((state) => {
    const snakePosition = [...state.snakePosition]
    const headOfSnakePosX = snakePosition[0]?.x
    const headOfSnakePosY = snakePosition[0]?.y

    // game is ended
    if (headOfSnakePosX > 25 || headOfSnakePosX < 1 || headOfSnakePosY > 25 || headOfSnakePosY < 1) {
        return { ...state, isEnd: true }
    } else if (state.timer === 0) {
        return { ...state, isEnd: true }
    }
    return state
})

engine.addSideEffect({
    onlyWhen: getIsRoundChanged,
    effect: renderScore
})

engine.addSideEffect({
    onlyWhen: () => !document.querySelector(".mesh"),
    effect: renderGameBoard
})

engine.addSideEffect({
    onlyWhen: getIsTimerChanged,
    effect: renderTimer
})

engine.addSideEffect({
    onlyWhen: ({ state }) => state.timer === state.timer,
    effect: renderFood
})

engine.addSideEffect({
    effect: renderSnake
})

engine.addSideEffect({
    onlyWhen: ({ state }) => state.isEnd || state.isPaused,
    effect: renderAlert
})


engine.addSideEffect({
    onlyWhen: getIsRoundChanged,
    effect: ({ state }, emit) => {
        if (!state.isEnd) {
            const roundTimeout = setTimeout(() => {
                emit("roundTimeout")
            }, state.gameSpeed)

            return () => {
                clearTimeout(roundTimeout)
            }
        }
    }
})

engine.addSignalReducer("roundTimeout", (state) => {
    if (state.isEnd) {
        return state
    }
    return {
        ...state,
        round: state.round + 1,
    }
})

engine.addSideEffect({
    onlyWhen: ({ state }) => !state.snakePosition.length,
    effect: (_, emit) => {
        emit("determiningSnakePosition")
    }
})

engine.addSignalReducer("determiningSnakePosition", (state) => {
    const snakePosition = [...state.snakePosition]
    let posX = state.firstPosition.x
    let posY = state.firstPosition.y
    for (let i = 0; i < state.snakeSize; i++) {
        if (snakePosition.length !== state.snakeSize || !snakePosition.length) {
            const bodyPosition = { x: posX, y: posY }
            snakePosition.push(bodyPosition)
            posX--
        }
    }
    return {
        ...state,
        snakePosition: snakePosition
    }
})

engine.addSideEffect({
    onlyWhen: getIsRoundChanged,
    effect: (_, emit) => {
        emit("moveSnake")
    }
})

engine.addSignalReducer("moveSnake", (state) => {
    const snakePosition = [...state.snakePosition]
    const headOfSnakePosX = snakePosition[0].x
    const headOfSnakePosY = snakePosition[0].y
    const removedSnakeBodyPosition = snakePosition.pop()
    const removedSnakeBody = getBoardCell(removedSnakeBodyPosition.x, removedSnakeBodyPosition.y)
    removedSnakeBody.classList.remove("snake")

    switch (state.direction) {
        case "ArrowLeft":
            snakePosition.unshift({ x: headOfSnakePosX - 1, y: headOfSnakePosY })
            break;
        case "ArrowUp":
            snakePosition.unshift({ x: headOfSnakePosX, y: headOfSnakePosY - 1 })
            break;
        case "ArrowRight":
            snakePosition.unshift({ x: headOfSnakePosX + 1, y: headOfSnakePosY })
            break;
        case "ArrowDown":
            snakePosition.unshift({ x: headOfSnakePosX, y: headOfSnakePosY + 1 })
            break;
        default:
            break;
    }

    return {
        ...state,
        snakePosition: snakePosition,
    }
})

engine.addSideEffect({
    onlyWhen: getIsRoundChanged,
    effect: ({ state }, emit) => {
        const getDirection = (e) => {
            if (e.key.includes("Arrow")) {
                emit("setDirection", { key: e.key, prevKey: state.direction })
            }
        }

        document.addEventListener("keyup", getDirection)
        return () => document.removeEventListener("keyup", getDirection)
    }
})

engine.addSignalReducer("setDirection", (state, { key, prevKey }) => {
    const reversDirection = {
        ArrowLeft: "ArrowRight",
        ArrowRight: "ArrowLeft",
        ArrowUp: "ArrowDown",
        ArrowDown: "ArrowUp",
    }
    if (key !== prevKey && key !== reversDirection[prevKey]) {
        return { ...state, direction: key, gameSpeed: 1000 }
    }
    return { ...state, gameSpeed: 1000 }
})

engine.addSideEffect({
    onlyWhen: getIsRoundChanged,
    effect: ({ state }, emit) => {
        const reversDirection = {
            ArrowLeft: "ArrowRight",
            ArrowRight: "ArrowLeft",
            ArrowUp: "ArrowDown",
            ArrowDown: "ArrowUp",
        }
        const acceleration = (e) => {
            if (e.key !== reversDirection[state.direction]) {
                emit("acceleration", e.key)
            }
        }

        document.addEventListener("keydown", acceleration)
        return () => document.removeEventListener("keydown", acceleration)
    }
})

engine.addSignalReducer("acceleration", (state, key) => {
    const newSpeed = 100
    return { ...state, gameSpeed: newSpeed, direction: key }
})

engine.addSignalReducer("setFoodPosition", (state, { posX, posY }) => {
    const newFoodPosition = { x: posX, y: posY }
    return { ...state, foodPosition: newFoodPosition }
})

engine.addSideEffect({
    onlyWhen: getIsRoundChanged,
    effect: ({ state }, emit) => {
        const foodPosX = state.foodPosition.x
        const foodPosY = state.foodPosition.y
        const headOfSnakePosX = state.snakePosition[0]?.x
        const headOfSnakePosY = state.snakePosition[0]?.y

        if (foodPosX === headOfSnakePosX && foodPosY === headOfSnakePosY) {
            emit("eatingFood")
        }
    }
})

engine.addSignalReducer("eatingFood", (state) => {
    const snakePosition = [...state.snakePosition]
    const headOfSnakePosX = snakePosition[0].x
    const headOfSnakePosY = snakePosition[0].y

    switch (state.direction) {
        case "ArrowLeft":
            snakePosition.unshift({ x: headOfSnakePosX - 1, y: headOfSnakePosY })
            break;
        case "ArrowUp":
            snakePosition.unshift({ x: headOfSnakePosX, y: headOfSnakePosY - 1 })
            break;
        case "ArrowRight":
            snakePosition.unshift({ x: headOfSnakePosX + 1, y: headOfSnakePosY })
            break;
        case "ArrowDown":
            snakePosition.unshift({ x: headOfSnakePosX, y: headOfSnakePosY + 1 })
            break;
        default:
            break;
    }

    console.log({ snakePosition })

    const food = document.querySelector(".food")
    food.classList.remove('food')
    return { ...state, timer: initialState.timer, score: state.score + 1, snakePosition: snakePosition }
})

engine.addSideEffect({
    onlyWhen: getIsRoundChanged,
    effect: (_, emit) => {
        emit("eatingHimself")
    }
})

engine.addSignalReducer("eatingHimself", (state) => {
    const snakePosition = [...state.snakePosition]
    const headOfSnake = snakePosition[0]
    const bodyOfSnake = snakePosition.map((item, i) => {
        if(i > 0) {
            return item
        }
    })
    let isEatedHimself = false

    bodyOfSnake.forEach(item => {
        const headOfSnakePosX = headOfSnake.x
        const headOfSnakePosY = headOfSnake.y
        const bodyOfSnakePosX = item?.x
        const bodyOfSnakePosY = item?.y
        if(headOfSnakePosX === bodyOfSnakePosX && headOfSnakePosY === bodyOfSnakePosY){
            isEatedHimself = true
        }
    })
    
    if(isEatedHimself) return {...state, isEnd: true}
    return state
})

// effect for debug state
engine.addSideEffect({ onlyWhen: getIsRoundChanged, effect: ({ state }) => console.log("debug state", state) })

engine.start();

function renderGameBoard() {
    let meshContainer = document.querySelector(".mesh");

    if (!meshContainer) {
        meshContainer = document.createElement("div");
        meshContainer.classList.add("mesh");

        let cellPosition = { x: 0, y: 0 }

        for (let i = 0; i < boardSize; i++) {
            const cell = document.createElement("div");
            cell.classList.add("item");
            if (i % 25 === 0) {
                cellPosition.x = 1
                cellPosition.y++
            }
            cell.setAttribute("x", cellPosition.x)
            cell.setAttribute("y", cellPosition.y)
            meshContainer.appendChild(cell);
            document.body.appendChild(meshContainer);
            cellPosition.x++
        }
    }
}

function getIsStateChanged(stateKey, { prevState, state }) {
    return prevState?.[stateKey] !== state[stateKey];
}

function getIsRoundChanged({ prevState, state }) {
    return (
        getIsStateChanged("round", { prevState, state })
    );
}

function getIsTimerChanged({ prevState, state }) {
    return (
        getIsStateChanged("timer", { prevState, state })
    );
}

function renderSnake({ state }) {
    state.snakePosition.forEach(pos => {
        const snakeBody = getBoardCell(pos.x, pos.y)
        if (snakeBody) {
            snakeBody.classList.add('snake')
        }
    });
}

function getBoardCell(x, y) {
    const snakeBody = document.querySelector('[x = "' + x + '"][y = "' + y + '"]')
    return snakeBody
}

function renderAlert(_, emit) {
    let alert = document.querySelector('.alert')

    if (!alert) {
        alert = document.createElement("div");
        alert.classList.add("alert");
        alert.innerHTML = 'Game has ended. Press "Enter" to start again';
        document.body.appendChild(alert);
    }

    const getEnterKey = (e) => {
        if (e.key === "Enter") {
            const snakes = document.querySelectorAll('.snake')
            snakes.forEach(item => {
                item.classList.remove('snake')
            })

            document.body.removeChild(alert)

            emit("restartGame")
        }
    }

    document.addEventListener("keyup", getEnterKey)

    return () => document.removeEventListener("keyup", getEnterKey)
}

function renderFood({ state }, emit) {
    const food = document.querySelector('.food')
    const x = getRandomNumber(25)
    const y = getRandomNumber(25)

    if (state.isEnd && food) {
        food.classList.remove('food')
    }

    if (!food) {
        const foodPosition = getBoardCell(x, y)
        foodPosition?.classList.add('food')

        emit("setFoodPosition", { posX: x, posY: y })
    }
}

function getRandomNumber(max) {
    return Math.floor(Math.random() * max);
}

function renderTimer({ state }, emit) {
    let timer = document.querySelector('.timer')

    if (!timer) {
        timer = document.createElement('div')
        timer.classList.add('timer')
        document.body.appendChild(timer)
    }
    timer.innerHTML = `timer: ${state.timer}`
    if (!state.isEnd && !state.isPaused) {
        const timerTimeout = setTimeout(() => {
            emit("timer")
        }, 1000)
        return () => clearTimeout(timerTimeout)
    }
}

engine.addSignalReducer('timer', (state) => {
    return { ...state, timer: state.timer - 1 }
})

function renderScore({ state }) {
    let score = document.querySelector('.score')

    if (!score) {
        score = document.createElement('div')
        score.classList.add('score')
        document.body.appendChild(score)
    }

    score.innerHTML = `score: ${state.score}`
}