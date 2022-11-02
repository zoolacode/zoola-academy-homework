import React from "react";
//style
import "./../styles/App.css"
//utils
import { getCoordinatesForCells, getFirstSnakePosition, getGameIsEnd, getNextSnakePosition, directionRules, getFoodPositions, getSnakePositionAfterEating, getFoodPositionAfterEating, compearingPosition } from "./../utils/utils"
import BonusFood from "./BonusFood";
//components
import Cell from "./Cell";
import Food from "./Food";
import GameTime from "./GameTime";
import ModalGameEnd from "./ModalGameEnd";
import ModalGamePause from "./ModalGamePause";
import Score from "./Score";
import Snake from "./Snake";

const initialState = {
    round: 0,
    gameSpeed: 100,
    snakePosition: [[10, 10]],
    snakeSize: 5,
    boardSize: 25,
    direction: 'ArrowRight',
    gameIsEnd: false,
    gameIsPaused: false,
    foodPositions: [],
    gameTime: 120,
    foodTimeout: 15,
    bonusFoodPosition: [],
    score: 0
}

const Board = () => {
    const [state, setState] = React.useState(initialState)

    //debug state
    // console.log("debugState", state)

    //food timeout
    React.useEffect(() => {
        try {
            if (!state.gameIsEnd && !state.gameIsPaused) {
                const foodTimeout = setTimeout(() => {
                    setState(prevState => {
                        if (prevState.foodTimeout === 0) {
                            const newFoodPos = getFoodPositions(prevState.bonusFoodPosition, prevState.snakePosition)

                            return { ...prevState, bonusFoodPosition: newFoodPos, foodTimeout: 15 }
                        }

                        return { ...prevState, foodTimeout: prevState.foodTimeout - 1 }
                    })
                }, 1000)

                return () => clearTimeout(foodTimeout)
            }
        } catch (error) {
            console.log(error)
        }
    }, [state.foodTimeout, state.gameIsEnd, state.gameIsPaused])

    //game timeout
    React.useEffect(() => {
        try {
            if (!state.gameIsEnd && !state.gameIsPaused) {
                const gameTimeout = setTimeout(() => {
                    setState(prevState => {
                        if (prevState.gameTime === 0) {
                            return { ...prevState, gameIsEnd: true }
                        }

                        return { ...prevState, gameTime: prevState.gameTime - 1 }
                    })
                }, 1000)

                return () => clearTimeout(gameTimeout)
            }
        } catch (error) {
            console.log(error)
        }
    }, [state.gameTime, state.gameIsEnd, state.gameIsPaused])

    //determining the position of the food 
    React.useEffect(() => {
        try {
            setState(prevState => {
                const newFoodPos = getFoodPositions(prevState.foodPositions, prevState.snakePosition)
                return { ...prevState, foodPositions: newFoodPos }
            })
        } catch (error) {
            console.log(error)
        }
    }, [state.gameIsEnd])

    //handle keyUp
    React.useEffect(() => {
        try {
            const handleKeyUp = (e) => {
                setState(prevState => {
                    const isValidDirection = directionRules(prevState.direction, e.key)
                    if (isValidDirection && !prevState.gameIsEnd) {
                        return { ...prevState, direction: e.key, round: prevState.round + 1 }
                    } else if(e.key === "Enter" && state.gameIsEnd) {
                        return initialState
                    }else if(e.code === "Space") {
                        return {...prevState, gameIsPaused: !prevState.gameIsPaused}
                    } else return { ...prevState }
                })
            }

            document.addEventListener('keyup', handleKeyUp)

            return () => document.removeEventListener('keyup', handleKeyUp)
        } catch (error) {
            console.log(error)
        }
    }, [state.round, state.direction, state.gameIsEnd])

    //game is end 
    React.useEffect(() => {
        try {
            setState((prevState => {
                const gameIsEnd = getGameIsEnd(prevState.snakePosition)

                if (gameIsEnd) {
                    return { ...prevState, gameIsEnd: gameIsEnd }
                }
                return { ...prevState }
            }))
        } catch (error) {
            console.log(error)
        }
    }, [state.round, state.gameIsEnd])

    //round timeout
    React.useEffect(() => {
        try {
            if (!state.gameIsEnd && !state.gameIsPaused) {
                const roundTimeout = setTimeout(() => {
                    setState(prevState => {
                        return { ...prevState, round: prevState.round + 1 }
                    })
                }, state.gameSpeed)

                return () => clearTimeout(roundTimeout)
            }
        } catch (error) {
            console.log(error)
        }
    }, [state.round, state.gameSpeed, state.gameIsEnd, state.direction, state.gameIsPaused])

    //determining the position of the snake 
    React.useEffect(() => {
        try {
            setState(prevState => {
                const snakePosition = getFirstSnakePosition(prevState.snakePosition, prevState.snakeSize)

                return { ...prevState, snakePosition: snakePosition }
            })
        } catch (error) {
            console.log(error)
        }
    }, [state.gameIsEnd])

    //move snake
    React.useEffect(() => {
        try {
            setState((prevState) => {
                const snakePosition = getNextSnakePosition(prevState.snakePosition, prevState.direction)
                const gameIsEnd = getGameIsEnd(prevState.snakePosition)

                if (!gameIsEnd && !state.gameIsPaused) {
                    return { ...prevState, snakePosition: snakePosition }
                } else return { ...prevState }
            })
        } catch (error) {
            console.log(error)
        }
    }, [state.round, state.direction, state.gameIsPaused])

    //eating food 
    React.useEffect(() => {
        setState(prevState => {
            const nextSnakePosition = getSnakePositionAfterEating(prevState.foodPositions, prevState.snakePosition, prevState.bonusFoodPosition)
            const nextFoodPosition = getFoodPositionAfterEating(prevState.foodPositions, prevState.snakePosition, prevState.bonusFoodPosition)
            if (nextFoodPosition.food !== prevState.foodPositions || nextFoodPosition.bonusFood !== prevState.bonusFoodPosition) {
                return { ...prevState, foodPositions: nextFoodPosition.food, snakePosition: nextSnakePosition, snakeSize: prevState.snakeSize + 1, bonusFoodPosition: nextFoodPosition.bonusFood, score: prevState.score + 1 }
            }

            return prevState
        })
    }, [state.round])

    const memoCoordinatesForCells = React.useMemo(() => getCoordinatesForCells(state.boardSize), [state.boardSize])

    return (
        <>
            <ModalGameEnd gameIsEnd={state.gameIsEnd} />
            <ModalGamePause gameIsPaused={state.gameIsPaused} />
            <Score score={state.score} />
            <section
                className="board">
                {
                    memoCoordinatesForCells.map((item, index) => {
                        if (state.snakePosition.some((el) => compearingPosition(item, el))) {
                            return <Snake key={index} />
                        } else if (state.foodPositions.some((el) => compearingPosition(item, el))) {
                            return <Food key={index} />
                        } else if (state.bonusFoodPosition.some((el) => compearingPosition(item, el))) {
                            return <BonusFood key={index} />
                        }
                        return <Cell key={index} />
                    }
                    )
                }
            </section>
            <GameTime gameTime={state.gameTime} />
        </>
    )
};

export default Board;
