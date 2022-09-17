import React, { useEffect } from 'react'
import { useState } from 'react';
import GameScore from './GameScore';
import GameTimer from './GameTimer';
import Restart from './Restart';

const Board = () => {
    const [sHead, setSHead] = useState([10, 10])
    const [sBody, setSBody] = useState([
        [10,10],
        [10,11],
        [10,12],
        [10,13],
        [10,14]
    ])
    const [food, setFood] = useState([15,15])
    const [timer, setTimer] = useState(120000)
    const [getLose, setGetLose] = useState(false)
    const [pause, setPause] = useState(false)
    const [score, setScore] = useState(0)
    const [direction, setDirection] = useState('up')
    const meshSize = 625;
    let countOfCells = []


    function startNewGame(){
        setSBody([
            [10,10],
            [10,11],
            [10,12],
            [10,13],
            [10,14]
        ]);
        setDirection('up');
        setFood([15,15]);
        setScore(0);
        setTimer(120000);
        setGetLose(false);
        setPause(false);
    }

    for(let i = 1; i <= meshSize; i++) {
        countOfCells.push(i)
    }

    let snakeMeshBody = sBody.map(([x, y]) => {
        let index = x + y * 25;
        return index
    });

    const foodLocation = food[0] + food[1] * 25;

    const hitTheBorder = (head) => {
        if(head[0] > 24 || head[1]-1 < 0 || head[0]-2 < 0 || head[1]+1 > 24){
            return true;
        } else {
            return false;
        }
    }

    function isHitSelf(head, body) {
        for(let i = 0;i < body.length;i++){
          if(head[0] === body[i][0] && head[1] === body[i][1]){
              return true;
          }
      }
      return false
    }

    function isFoodEaten(head, position) {
        if (head[0] === position[0] && head[1] === position[1]) {
          return true
        } else {
          return false
        }
    }

    function getRandomNum(num) {
        return Math.floor(Math.random() * num)
    }

    function generateFood(snakeBody) {
        let newPosition = [getRandomNum(24), getRandomNum(24)]
        for (let i = 0; i < snakeBody.length; i++) {
          if(snakeBody[i][0] === newPosition[0] || snakeBody[i][0] === newPosition[1]) {
            newPosition = [getRandomNum(24), getRandomNum(24)]
          }
        }
      
        return newPosition
    }

    const handlePressKey = (event) => {     
        switch(event.keyCode){
            case 37:
                if (direction !== 'right') {
                    setDirection('left');
                }
                break;
            case 38:
                if (direction !== 'down') {
                    setDirection('up');
                }
                break;
            case 39:
                if (direction !== 'left') {
                    setDirection('right');
                }
                break;
            case 40:
                if (direction !== 'up') {
                    setDirection('down');
                }
                break;
            case 32: 
                setPause(!pause);
                break;
            default:
                break;  
        }
    }


    useEffect(() => {
        document.addEventListener('keydown', handlePressKey);
        var timerr = setTimeout(() => {
            let newSnakeHead = sHead;
            let prevHeadPosition = sBody[0]

            switch (direction) {
                case 'down':
                  newSnakeHead = [prevHeadPosition[0], prevHeadPosition[1] + 1]
                  break;
                
                case 'up':
                  newSnakeHead = [prevHeadPosition[0], prevHeadPosition[1] - 1]
                  break;
            
                case 'left':
                  newSnakeHead = [prevHeadPosition[0] - 1, prevHeadPosition[1]]
                  break;
                
                case 'right':
                  newSnakeHead = [prevHeadPosition[0] + 1, prevHeadPosition[1]]
                  break;
              
                default:
                  break;
            }

            if(hitTheBorder(sBody[0]) || isHitSelf(newSnakeHead, sBody) || timer === 0) {
                setGetLose(true)
            } else if (pause) {
                console.log('pause');
            } else {
                if(isFoodEaten(newSnakeHead, food)) {
                    setSBody(s => [
                        newSnakeHead,
                        ...s
                    ])
                    setFood(generateFood(sBody))
                    setScore(score + 1)
                } else {
                    setSBody(s => [
                        newSnakeHead,
                        ...s.slice(0, sBody.length - 1)
                    ])
                }
                setTimer(timer - 100)
                setSHead(newSnakeHead)
            }
        }, 100);

        return () => {
            clearTimeout(timerr)
            document.removeEventListener('keydown', handlePressKey)
        }
    }, [timer, pause, getLose])


  return (
    <>
        <GameScore score={score}/>
        <div className="mesh">
            {
                countOfCells.map(item => {
                    if(snakeMeshBody.includes(item)) {
                        return (<div key={item} className='snakeBody'></div>)
                    } else if (item === foodLocation) {
                        return (<div key={item} className='apple'></div>)
                    } else {
                        return (<div key={item}></div>)
                    }
                })

            }
        </div>
        <GameTimer timer={timer}/>
        {getLose && <Restart restart={startNewGame} isLose={getLose}/>}
    </>
  )
}

export default Board