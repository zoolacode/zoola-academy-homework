export const getCoordinatesForCells = (boardSize) => {
    let x = 1
    let y = 1
    const coordinates = []
    const iterationValue = Math.pow(boardSize, 2)

    for (let i = 0; i < iterationValue; i++) {
        coordinates.push([x, y])
        x += 1
        if (x > 25) {
            x = 1
            y += 1
        }
    }

    return coordinates
}

export const getNextSnakePosition = (snakePosition, direction) => {
    const newSnakePosition = [...snakePosition]
    const headOfSnakePosX = snakePosition[0][0]
    const headOfSnakePosY = snakePosition[0][1]

    if (headOfSnakePosX > 25 || headOfSnakePosY > 25 || headOfSnakePosX < 1 || headOfSnakePosY < 1) {
        return snakePosition
    }

    newSnakePosition.pop()

    const directionMothods = {
        left: [headOfSnakePosX - 1, headOfSnakePosY],
        up: [headOfSnakePosX, headOfSnakePosY - 1],
        right: [headOfSnakePosX + 1, headOfSnakePosY],
        down: [headOfSnakePosX, headOfSnakePosY + 1]
    }


    switch (direction) {
        case "ArrowLeft":
            newSnakePosition.unshift(directionMothods.left)
            break;
        case "ArrowUp":
            newSnakePosition.unshift(directionMothods.up)
            break;
        case "ArrowRight":
            newSnakePosition.unshift(directionMothods.right)
            break;
        case "ArrowDown":
            newSnakePosition.unshift(directionMothods.down)
            break;
        default:
            break;
    }

    return newSnakePosition
}

export const getFirstSnakePosition = (snakePosition, snakeSize) => {
    const firstSnakePosition = []
    const headOfSnakePosX = snakePosition[0][0]
    const headOfSnakePosY = snakePosition[0][1]

    for (let i = 0; i < snakeSize; i++) {
        firstSnakePosition.push([headOfSnakePosX - i, headOfSnakePosY])
    }

    return firstSnakePosition
}

export const getGameIsEnd = (snakePosition) => {
    const headOfSnake = getHeadOfSnakePosition(snakePosition)

    let gameIsEnd = false

    //outside of the board 
    if (headOfSnake.x > 25 || headOfSnake.y > 25 || headOfSnake.x < 1 || headOfSnake.y < 1) {
        gameIsEnd = true
    }

    //eating himself 
    const positionOfBodySnake = [...snakePosition]
    positionOfBodySnake.shift()

    positionOfBodySnake.forEach(el => {
        const bodyPosX = el[0]
        const bodyPosY = el[1]
        if (bodyPosX === headOfSnake.x && bodyPosY === headOfSnake.y) {
            gameIsEnd = true
        }
    })

    return gameIsEnd
}

export const directionRules = (prevDirection, nextDirection) => {
    const reversDirection = {
        ArrowLeft: "ArrowRight",
        ArrowRight: "ArrowLeft",
        ArrowUp: "ArrowDown",
        ArrowDown: "ArrowUp",
    }

    const isReversDirection = nextDirection === reversDirection[prevDirection] ? false : true

    if (nextDirection.includes("Arrow") && isReversDirection && nextDirection !== prevDirection) {
        return true
    } else return false
}

const getRandomNumber = (min, max) => {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
}

export const getFoodPositions = (foodPosition, snakePosition) => {
    const foodPosX = getRandomNumber(1, 26)
    const foodPosY = getRandomNumber(1, 26)
    const newFoodPositions = [...foodPosition]

    const isValidPositionAboutFood = foodPosition.some(el => el[0] === foodPosX && el[1] === foodPosY)
    const isValidPositionAboutSnake = snakePosition.some(el => el[0] === foodPosX && el[1] === foodPosY)

    if (!isValidPositionAboutFood && !isValidPositionAboutSnake) {
        newFoodPositions.push([foodPosX, foodPosY])
    } else return getFoodPositions(foodPosition, snakePosition)

    return newFoodPositions
}

const getHeadOfSnakePosition = (snakePosition) => {
    const headOfSnakePosX = snakePosition[0][0]
    const headOfSnakePosY = snakePosition[0][1]

    return { x: headOfSnakePosX, y: headOfSnakePosY }
}

const isEatingFood = (foodPosition, snakePosition) => {
    const headOfSnake = getHeadOfSnakePosition(snakePosition)

    const eatingFood = foodPosition.some(el => el[0] === headOfSnake.x && el[1] === headOfSnake.y)

    return eatingFood
}

const isEatingBonusFood = (bonusFoodPosition, snakePosition) => {
    const headOfSnake = getHeadOfSnakePosition(snakePosition)

    const eatingBonusFood = bonusFoodPosition?.some(el => el[0] === headOfSnake.x && el[1] === headOfSnake.y)

    return eatingBonusFood
}

export const getSnakePositionAfterEating = (foodPosition, snakePosition, bonusFoodPosition) => {
    const eatingFood = isEatingFood(foodPosition, snakePosition)
    const eatingBonusFood = isEatingBonusFood(bonusFoodPosition, snakePosition)


    if (eatingFood || eatingBonusFood) {
        const newSnakePosition = [...snakePosition]
        newSnakePosition.push(snakePosition.pop())

        return newSnakePosition
    }

    return snakePosition
}

export const getFoodPositionAfterEating = (foodPosition, snakePosition, bonusFoodPosition) => {
    const headOfSnake = getHeadOfSnakePosition(snakePosition)

    const eatingFood = isEatingFood(foodPosition, snakePosition)
    const eatingBonusFood = isEatingBonusFood(bonusFoodPosition, snakePosition)

    if (eatingFood) {
        const filteringFoodPositions = [...foodPosition].filter(el => el[0] !== headOfSnake.x && el[1] !== headOfSnake.y)
        const nextFoodPosition = getFoodPositions(filteringFoodPositions, snakePosition)

        return { food: nextFoodPosition, bonusFood: bonusFoodPosition }
    }

    if (eatingBonusFood) {
        const filteringBonusFoodPositions = [...bonusFoodPosition].filter(el => el[0] !== headOfSnake.x && el[1] !== headOfSnake.y)

        return { food: foodPosition, bonusFood: filteringBonusFoodPositions }
    }

    return { food: foodPosition, bonusFood: bonusFoodPosition }
}

export const compearingPosition = (boardPosition, subjectPosition) => {
    return subjectPosition[0] === boardPosition[0] && subjectPosition[1] === boardPosition[1]
}