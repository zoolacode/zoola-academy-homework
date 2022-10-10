import React from 'react'
import "./index.css"

const BOARD_SIZE =25;
const CELLS_OF_BOARD = Array(BOARD_SIZE).fill(Array(BOARD_SIZE).fill(0));


export default function SnakeInBoard(props) {
    return (
        <div className='mesh'>

            {CELLS_OF_BOARD.map((row, indexX) => {
                return (
                    <div key={indexX} >
                        {row.map((column, indexY) => {
                            let part_of_snake = props.snake.some(el => el[0] === indexX && el[1] === indexY) && "snake";
                            let part_of_food = (props.food[0] === indexX && props.food[1] === indexY) && "food";
                            return (<div key={indexY} className={`cell ${part_of_snake} ${part_of_food}`}></div>)
                        })}
                    </div>)
            })}

        </div>
    )
}
