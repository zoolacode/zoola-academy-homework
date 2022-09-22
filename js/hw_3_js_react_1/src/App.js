import './App.css';
import React, { useState } from 'react';

const rows = 25,
      columns = 25,
      initialBoostTimerValue = 10,
      redrawBoostTimerValue = 5,
      defaultFoodBoost = 2,
      gameTimer = 120,
      pauseToEndGame = 120;

let meshData = [];

//initial state
const initialSnakeState = {
  bodyData: [
    [10, 10],
    [10, 11],
    [10, 12],
    [10, 13],
    [10, 14],
  ],
  currentScore: 0,
  round: 0,
  gameTimer: 0,
  boostCoefficient: defaultFoodBoost,
  boostTimerToPubish: initialBoostTimerValue,
  boostPublishFlag: false,
  gameOver: false,
  restart: true,
  pause: false,
  direction: [0, -1],
  directionChanged: false,
  foodObjects: [],
  foodEatenArray: [],
  gameTimer: gameTimer,
};

function App() {
  const [snakeState, setSnake] = useState(initialSnakeState);

  //cach end of game
  React.useEffect(()=>{
    renderGameAlert(snakeState, setSnake)
  })

  //Game timer
  React.useEffect(() => {
    const roundInterval = setInterval(() => {
      if(!isGameOnHold(snakeState)){
        setSnake(prevSnake => {
          return {
            ...prevSnake, 
            gameTimer: prevSnake.gameTimer - 1,
          }
        })
      } 
    }, 1000);

    return () => {
      clearInterval(roundInterval);
    };
    
  },[snakeState.gameTimer,snakeState.gameOver])

  //boost timer
  React.useEffect(() => {

    const roundInterval = setInterval(() => {
      if(!isGameOnHold(snakeState)){
        setSnake(prevSnake => {
          return {
            ...prevSnake, 
            boostTimerToPubish: prevSnake.boostTimerToPubish - 1,
          }
        })
      }
    }, 1000);

    return () => {
      clearInterval(roundInterval);
    };

    
  },[snakeState.boostTimerToPubish])

  //end game if on pause 120 sec
  React.useEffect(() => {
    renderGamePause(snakeState)
    if(snakeState.pause && !snakeState.gameOver){
      
      const roundInterval = setInterval(() => {
        //end game
        setSnake({
          ...snakeState,
          gameOver: true,
        })
      }, pauseToEndGame*1000);

      return () => {
        clearInterval(roundInterval);
      };
    }
    
  },[snakeState.pause])

  // checkIsGameEnded
  React.useEffect(()=>{
    // renderGameAlert()
    if(!isGameOnHold(snakeState)){
      checkIsGameEnded(snakeState,setSnake)    
    }
  })

  //Render round depend on speed of Snake
  React.useEffect(() => {
    if(!isGameOnHold(snakeState)){
      const roundInterval = setInterval(() => {
      
        setSnake(prevSnake => {
          return {
            ...prevSnake, 
            round: prevSnake.round +1,
          }
        })
      }, 1000/snakeState.boostCoefficient);

      return () => {
        clearInterval(roundInterval);
      };
    }
     
    

  },[snakeState.round, snakeState.pause])

  //Move Snake body data
  React.useEffect(() => {
    if(!snakeState.gameOver){
      moveSnakeBody(snakeState,setSnake)
    }
  },[snakeState.round])  
  
  //add boost when boost Timer expired
  React.useEffect(() => {
    //check food eaten details
    if(snakeState.boostTimerToPubish === 0 && !isGameOnHold(snakeState)){
      addFood(snakeState, 
        setSnake, 
        {
          newFoodPossition: getNewFoodPossition(snakeState),
          isBooster: true,
        }
      )
    }
  }, [snakeState.boostTimerToPubish])

  //check eaten food and add score if we did it
  React.useEffect(() => {
    if(!isGameOnHold(snakeState)){
      checkFoodEatenArray(snakeState, setSnake)
    }
  }, [snakeState.currentScore])

// add initial food first time
  React.useEffect(() => {
    if(snakeState.foodObjects.length === 0){
      addFood(snakeState, 
              setSnake, 
              {
                newFoodPossition: getNewFoodPossition(snakeState),
                isBooster: false,
              }
      )
    }
  },[snakeState])

  //Event Handler
  React.useEffect(() => {
    if(!snakeState.gameOver){
      document.addEventListener("keyup", eventHandler);
    }
    return () => {
      document.removeEventListener("keyup", eventHandler);
    }
  })

  function eventHandler(e) {
    if (e.code === "Space") {
      setSnake(prevSnake => {
        return {
          ...prevSnake, 
          pause: !prevSnake.pause
        }
      })
    } else if(e.code === "KeyF") {
      setSnake(prevSnake => {
        addFood(prevSnake, 
          setSnake, 
          {
            newFoodPossition: getNewFoodPossition(prevSnake),
            isBooster: true,
          }
        )
        return {
          ...prevSnake,
        }
      })
    } else {
      setSnake(prevSnake => {
        return  !prevSnake.directionChanged 
                ? changeDirection(prevSnake, e)
                : {...prevSnake}
      })
    }
  }


  return (
    <div className='snake-game'>
      <Board />
      <Timer time={snakeState.gameTimer}/>
      <TimerBoost time={snakeState.boostTimerToPubish} show={snakeState.boostPublishFlag} isGameOver={snakeState.gameOver}/>
      <Score score={snakeState.currentScore}/>
      <Food state={snakeState}/>
      <Snake state={snakeState} />
    </div>
  );
}

//snake logic
function moveSnakeBody(state,setState) {
  let newBodyData = [...state.bodyData],
      head = [...newBodyData[0]];

  head[0] += state.direction[0];
  head[1] += state.direction[1];
  newBodyData.unshift(head);

  let foodObjectDetails = checkingFoodOnHead(newBodyData, state.foodObjects);

  if (!foodObjectDetails.isFoodEaten) {
    newBodyData.pop();
    
    setState({
      ...state, 
      bodyData: newBodyData,
      directionChanged: false,
    }) 
  } else {
    setState({
      ...state, 
      bodyData: newBodyData,
      directionChanged: false,
      foodObjects: foodObjectDetails.foodObjects,
      foodEatenArray: foodObjectDetails.eatenFood,
      currentScore: state.currentScore + 1,
    })
  }
}

function changeDirection(state, keyEvent) {
  if (state.pause) {
    return state
  }

  let proposedDirection = state.direction;

  switch (keyEvent.code) {
    case "ArrowRight":
      proposedDirection = [0, 1]; // [y, x]
      break;
    case "ArrowLeft":
      proposedDirection = [0, -1]; // [y, x]
      break;
    case "ArrowDown":
      proposedDirection = [1, 0]; // [-y, x]
      break;
    case "ArrowUp":
      proposedDirection = [-1, 0]; // [y, x]
      break;
  }

  if (scalarProduct(state.direction, proposedDirection) === 0) {
    return {
      ...state,
      direction: state.directionChanged? state.directionChanged: proposedDirection,
      directionChanged: state.direction === proposedDirection ? false : true,
    }
  }
  return state
}

//food logic
function checkingFoodOnHead(bodyArray, foodObjects) {
  let head = [...bodyArray[0]],
    isFoodEatenFlag = false,
    newFoodObjects = [],
    eatenFoodObjects = [],
    isBoostEatenFlag = false,
    foodBoostCoefficient;

  foodObjects.forEach((element) => {
    if (
      element?.possition[0] === head[0] &&
      element?.possition[1] === head[1]
    ) {
      isFoodEatenFlag = true;
      isBoostEatenFlag = element.isBooster;
      foodBoostCoefficient = element.foodBoostCoefficient;
      eatenFoodObjects.push(element)
    } else {
      newFoodObjects.push(element);
    }

  });

  return {
    isFoodEaten: isFoodEatenFlag,
    isBoostEaten: isBoostEatenFlag,
    foodObjects: [...newFoodObjects],
    foodBoostCoefficient: foodBoostCoefficient,
    eatenFood: eatenFoodObjects,
  };
}

function checkFoodEatenArray(snakeState, setSnake) {
  
  if(!snakeState.foodEatenArray[0]?.isBooster){
    addFood(snakeState, 
      setSnake, 
      {
        newFoodPossition: getNewFoodPossition(snakeState),
        isBooster: false,
      }
    ) 
  } else {
    setSnake({
      ...snakeState,
      boostTimerToPubish: initialBoostTimerValue,
      boostPublishFlag: false,
      boostCoefficient: snakeState.foodEatenArray[0].foodBoostCoefficient,
    })
  }

  
}

function removeBoost(foodObjects) {
  let newFoodObjects = [...foodObjects],
      eatenFoodObjects = [];       

  for (let index = 0; index < newFoodObjects.length; index++) {
    const element = newFoodObjects[index];
    if (element.isBooster) {
      eatenFoodObjects = newFoodObjects.splice(index,1);
      break;
    }
  }

  return [newFoodObjects, eatenFoodObjects];
}

function addFood(state, setSnake, foodParams){

  let boostValues = [2, 4, 6, 8, 10],
      newFoodObjects = [...state.foodObjects],
      eatenFoodObjects = state.foodEatenArray;

  newFoodObjects?.push({
    possition: foodParams.newFoodPossition,
    isBooster: foodParams.isBooster,
    foodBoostCoefficient: foodParams.isBooster
      ? boostValues[getRandomNumber(boostValues.length - 1)]
      : defaultFoodBoost,
  });
  
  if(foodParams.isBooster){
    if(state.boostPublishFlag===true){
      [newFoodObjects, eatenFoodObjects] = removeBoost(newFoodObjects);
    }
    setSnake(prevSnake => {
      return {
        ...prevSnake,
        foodObjects: newFoodObjects,
        boostCoefficient: defaultFoodBoost,
        boostPublishFlag: true,
        boostTimerToPubish: redrawBoostTimerValue,
        foodEatenArray: eatenFoodObjects
      }
    })
  } else {
    setSnake(prevSnake => {
      return {
        ...prevSnake,
        foodObjects: newFoodObjects,
        boostCoefficient: defaultFoodBoost,
      }
    }) 
  }
}

function getNewFoodPossition(state) {
  while (true) {
    let x = getRandomNumber(rows),
      y = getRandomNumber(columns),
      occlude = false,
      newPossition = [x, y];

    state.foodObjects.forEach((element) => {
      if (element[0] === newPossition[0] && element[1] === newPossition[1]) {
        occlude = true;
      }
    });

    state.foodEatenArray.forEach((element) => {
      if (element[0] === newPossition[0] && element[1] === newPossition[1]) {
        occlude = true;
      }
    });

    state.bodyData.forEach((element) => {
      if (element[0] === newPossition[0] && element[1] === newPossition[1]) {
        occlude = true;
      }
    });

    if (occlude === false) {
      return newPossition;
    }
  }
}

//help function
function scalarProduct(a, b) {
  if (a.length !== b.length) {
    return 1;
  }

  let prod = 0;
  for (let index = 0; index < a.length; index++) {
    prod += a[index] * b[index];
  }
  return prod;
}

function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

function checkIsGameEnded(state, setState) {
  let endGameFlag = false,
    head = [...state.bodyData[0]];

  if (!(0 <= head[0] && head[0] < rows && 0 <= head[1] && head[1] < columns)) {
    //check out of mesh
    endGameFlag = true;
  }

  let body = [...state.bodyData.slice(1)]; // get body without head

  body.forEach((element) => {
    if (head[0] === element[0] && head[1] === element[1]) {
      // check on the body
      endGameFlag = true;
    }
  });

  if (state.gameTimer === 0) {
    endGameFlag = true;
  }

  if(endGameFlag){
    setState(prevSnake => {
        return {
          ...prevSnake,
        gameOver: endGameFlag,
        bodyData: prevSnake.bodyData,
      }
    })
  }
}

function isGameOnHold(state) {
  return (state.gameOver || state.pause);
}

//render Pause || Alert
function renderGameAlert(state, setState) {
  let alert = document.querySelector(".alert");

  if (!alert) {
    alert = document.createElement("div");
    alert.classList.add("alert");
    alert.innerHTML = 'Game has ended. Press "Enter" to start again.';
    document.body.appendChild(alert);
  }

  const onAlertEnter = (e) => {
    if (e.key === "Enter") {
      setState(prevSnake => {
        
        return {
          ...initialSnakeState,
        }
      })
    }
  };

  if (state.gameOver) {
    document.addEventListener("keyup", onAlertEnter);
    alert.classList.add("alert-win");
  } else {
    alert.classList.remove("alert-win");
  }

  return () => {

    document.removeEventListener("keyup", onAlertEnter);
  };
}

function renderGamePause(state) {

  let pauseContainer = document.querySelector(".pause");

  if (!pauseContainer) {
    pauseContainer = document.createElement("div");
    document.body.appendChild(pauseContainer);
  }

  if (state.pause) {
    pauseContainer.classList.add("pause");
    pauseContainer.innerHTML = "PAUSE";
  } else {
    pauseContainer.classList.remove("pause");
    pauseContainer.innerHTML = "";
  }
}

//components
  function Board() {
    let meshContainer = document.querySelector(".mesh");
  
    if (!meshContainer) {
      meshContainer = document.createElement("div");
      meshContainer.classList.add("mesh");
      for (let x = 0; x < rows; x++) {
        let row = [];
  
        for (let y = 0; y < columns; y++) {
          const cell = document.createElement("div");
          cell.classList.add("item");
          meshContainer.appendChild(cell);
          document.body.appendChild(meshContainer);
          row.push(cell);
        }
        meshData.push(row);
      }
    }
  }
  
  function Timer(props) {
    let number = props.time,
    minutes = ("0" + Math.floor(number / 60)).slice(-2),
    seconds = ("0" + (number % 60)).slice(-2),
    timeString = `${minutes}:${seconds}`;
    
    return (
      <div className='timer'>
        {timeString}
      </div>
    )
  }

  function TimerBoost(props) {
    let number = props.time,
    minutes = ("0" + Math.floor(number / 60)).slice(-2),
    seconds = ("0" + (number % 60)).slice(-2),
    timeString = `${minutes}:${seconds}`;

    return (
      <div className={props.show && !props.isGameOver ? 'timer-boost' : "timer-boost-hide"}>
        {timeString} 
      </div>
    )
  }

  function Score(props) {
    return (
      <div className='score score-positive'>
        {props.score}
      </div>
    )
  }

  function Food(props) {

    props.state.foodObjects?.forEach((element) => {
      let x = element.possition[0],
        y = element.possition[1],
        foodClassName = element.isBooster ? "food-booster-cell" : "food-cell";

      meshData[x][y].classList.add(foodClassName);
      if(props.state.gameOver){
        meshData[x][y].classList.remove(foodClassName);
      }
    });
    props.state.foodEatenArray?.forEach((element) => {
      let x = element.possition[0],
        y = element.possition[1],
        foodClassName = element.isBooster ? "food-booster-cell" : "food-cell";
        meshData[x][y].classList.remove(foodClassName);
    });
  
  
  }

  function Snake(props) {
    meshData.forEach( x => {
      x.forEach( y => {
        y.classList.remove("snake-body");
      })
    })
    if(!props.state.gameOver){
      props.state.bodyData.forEach((element) => {
        let x = element[0],
          y = element[1];
        
        meshData[x]?.[y]?.classList.add("snake-body");
        
      });
    }
  }

export default App;
