import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";

const meshSize = 625;

const initialState = {
    currentScore: 0,
    endGameWinning: false,
    endGameLosing: false,
    isGameRestart: false,
    pause: false,
    time: 0,
    snakeBody: [
      [10, 10],
      [10, 11],
      [10, 12],
      [10, 13],
      [10, 14],
    ],
    food: [1 ,1],
    direction: 'down',
  };

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer("restartGame", () => {
  return initialState;
});

engine.addSideEffect({
  onlyWhen: ifScoreChanged,
  effect: (_, emit) => {
    emit("createFood");
    emit("snakeGrowUp");
    const intervalId = setInterval(() => {
      emit("createFood");
    }, 15000);
    
    return () => {
      clearInterval(intervalId);
    };
  },
});

engine.addSideEffect({
    onlyWhen: ifDirectionChanged,
    effect: (_, emit) => {
      emit("snakeMove");
      const intervalId = setInterval(() => {
        emit("snakeMove");
      }, 1000);
      
      return () => {
        clearInterval(intervalId);
      };
    },
  });
  
  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) =>
      getIsStateChanged("time", { prevState, state }),
    effect: (_, emit) => {
      const intervalId = setInterval(() => {
        emit("nextSecond");
      }, 1000);
  
      return () => {
        clearInterval(intervalId);
      };
    },
  });
  
  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) =>
      getIsStateChanged("currentScore", { prevState, state }),
    effect: renderGameScore    
  });
  
  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) =>
      getIsStateChanged("time", { prevState, state }),
    effect: renderGameTime
  });
  
  engine.addSideEffect({
    effect: renderGameBoard,
  });
  
  engine.addGlobalReducer( state  => {
    if (getIsGameEnded(state)) {
      return state;
    };
  
    if(getIsGamePause(state)) {
      return state;
    };
  
    const snakeHead = [...state.snakeBody[0]];
    const pointForEat = 1;
    let gameLost = false;
    let score = 0;  
    
    if (state.snakeBody[0][0] === state.food[0] && state.snakeBody[0][1] === state.food[1]) {
      score = pointForEat;
    };
  
    const snakeHeadOnBody = state.snakeBody.filter( item => item[0] === snakeHead[0] && item[1] === snakeHead[1] );
  
    if(snakeHeadOnBody.length == 2) {
      gameLost = true;
    };
  
    return {
      ...state,
      currentScore: state.currentScore + score,
      gameLost,
    };
  });

engine.addSignalReducer('nextSecond', state => {
    if (getIsGameEnded(state)) {
      return state;
    };
    if (getIsGamePause(state)) {
      return state;
    };
  
    const timeSec = 1;
    const timeWon = 120;
    let endGameWinning = false;
  
    if (state.time === timeWon - 1) {
        endGameWinning = true;
    };
  
    return ({
      ...state,
      time: state.time + timeSec,
      endGameWinning
    });
  });

  engine.addSignalReducer('keyClickDown', state => {
    if (getIsGameEnded(state)) {
      return state;
    };
    if(getIsGamePause(state)) {
      return state;
    };
  
    const direction = 'down';
  
    return {
      ...state,
      direction,
    };
  });
  
  engine.addSignalReducer('keyClickUp', state => {
    if (getIsGameEnded(state)) {
      return state;
    };
    if(getIsGamePause(state)) {
      return state;
    };
  
    const direction = 'up';
    return {
        ...state,
        direction,
     };
  });
    
 engine.addSignalReducer('keyClickLeft', state => {
     if (getIsGameEnded(state)) {
      return state;
     };
    if(getIsGamePause(state)) {
      return state;
    };
      
    const direction = 'left';
      
    return {
     ...state,
     direction,
     };
  });
      
 engine.addSignalReducer('keyClickRight', state => {
     if (getIsGameEnded(state)) {
       return state;
    };
    if(getIsGamePause(state)) {
       return state;
     };
      
    const direction = 'right';
    return {
        ...state,
        direction,
   };
});
        
     engine.addSignalReducer('pauseGame', state =>  {
        if (getIsGameEnded(state)) {
         return state;
         };
        
        return {
          ...state,
          pause: !state.pause,
    };
 });
        
 engine.addSignalReducer('snakeGrowUp', state => {
        if (getIsGameEnded(state)) {
          return state;
            };
        if(getIsGamePause(state)) {
          return state;
            };
            const snakeBody = [...state.snakeBody, [+state.snakeBody[state.snakeBody.length - 1][0], +state.snakeBody[state.snakeBody.length - 1][1]]];
            
        return {
         ...state,
        snakeBody,
    };
 });

engine.addSignalReducer('snakeMove', state => {
     if (getIsGameEnded(state)) {
      return state;
            };
     if(getIsGamePause(state)) {
      return state;
            };
          
        let snakeCoordinates = [...state.snakeBody[0]];
        let snakeBodyFirstElem = [];
        let endGameLosing = false;


        if (state.direction === 'right') {
        if (snakeCoordinates[0] < 25) {
          snakeBodyFirstElem = [+snakeCoordinates[0] + 1, snakeCoordinates[1]];
            } else {
          snakeBodyFirstElem = [+snakeCoordinates[0], snakeCoordinates[1]];
             endGameLosing = true;
            }

            } else if (state.direction === 'left') {
             if (snakeCoordinates[0] > 1) {
                  snakeBodyFirstElem = [+snakeCoordinates[0] - 1, snakeCoordinates[1]];

            } else {
                  snakeBodyFirstElem = [+snakeCoordinates[0], snakeCoordinates[1]];
                  endGameLosing = true;
            }

            } else if (state.direction === 'down') {
                if (snakeCoordinates[1] > 1) {
                  snakeBodyFirstElem = [snakeCoordinates[0], +snakeCoordinates[1] - 1];
                } else {
                  snakeBodyFirstElem = [+snakeCoordinates[0], snakeCoordinates[1]];
                  endGameLosing = true;
                }

              } else if (state.direction === 'up') {
                if (snakeCoordinates[1] < 25) {
                  snakeBodyFirstElem = [snakeCoordinates[0], +snakeCoordinates[1] + 1];

                } else {
                  snakeBodyFirstElem = [+snakeCoordinates[0], snakeCoordinates[1]];
                  endGameLosing = true;
     }
 };

 const snakeBody = [snakeBodyFirstElem, ...state.snakeBody];
 snakeBody.pop();
            
   return {
    ...state,
    snakeBody,
     endGameLosing,
     };
});

 engine.addSignalReducer('createFood', state => {
  if (getIsGameEnded(state)) {
     return state;
  };

  if(getIsGamePause(state)) {
      return state;
  };
                
     const snakeBody = [...state.snakeBody];
              
     let food = [getRandomNumber(25), getRandomNumber(25)];
     let foodOnSnake = snakeBody.filter( item => item[0] === food[0] && item[1] === food[1] );
              
     while(foodOnSnake.length === 1) {
     food = [getRandomNumber(25), getRandomNumber(25)];
     foodOnSnake = snakeBody.filter( item => item[0] === food[0] && item[1] === food[1] );
  };
              
      return {
      ...state,
      food,
    };
 });

 
 engine.start();

 function renderGameBoard({ state, prevState }, emit) {
   let meshContainer = document.querySelector(".mesh");
 
   if (!meshContainer) {
     meshContainer = document.createElement("div");
     meshContainer.classList.add("mesh");
     let x = 1;
     let y = 25;
     for (let i = 0; i < meshSize; i++) {
         const cell = document.createElement("div");
         cell.classList.add("item");
         meshContainer.appendChild(cell);
         document.body.appendChild(meshContainer);
     
         if(x > 25) {
             x = 1;
             y--;
         };
         let excel = document.querySelectorAll('.item');
         excel[i].setAttribute('posX', x);
         excel[i].setAttribute('posY', y);
         x++;  
     };
   };
 
   const snakeBody = state.snakeBody.map( item => document.querySelector(`[posX = '${item[0]}'][posY = '${item[1]}']`) );
   snakeBody.forEach(item => item.classList.add('snakeBody'));
   snakeBody[0].classList.add('snakeHead');

   const onDocumentClick = (e) => {
    if (e.key === 'ArrowLeft' && state.direction !== 'right') {
      emit("keyClickLeft");
    } else if (e.key === 'ArrowUp' && state.direction !== 'down') {
      emit("keyClickUp");
    } else if (e.key === 'ArrowRight' && state.direction !== 'left') {
      emit("keyClickRight");
    } else if (e.key === 'ArrowDown' && state.direction !== 'up') {
      emit("keyClickDown");
    } else if (e.keyCode == 32) {
      emit("pauseGame")
    }
  };

  window.addEventListener('keydown', onDocumentClick);

  return () => {
    window.removeEventListener('keydown', onDocumentClick);
    snakeBody.forEach(item => item.classList.remove('snakeBody'));
    snakeBody[0].classList.remove('snakeHead');
    food.classList.remove('food');
  };
};

function renderGameScore({ state, prevState }, emit) {
    let scoreContainer = document.querySelector(".score");
  
    if (!scoreContainer) {
      scoreContainer = document.createElement("div");
      scoreContainer.classList.add("score");
      document.body.appendChild(scoreContainer);
    };
  
    scoreContainer.innerHTML = state.currentScore;
  };
  
  function renderGameTime({ state, prevState }, emit) {
    let timeContainer = document.querySelector(".time");
  
    if (!timeContainer) {
      timeContainer = document.createElement("div");
      timeContainer.classList.add("time");
      document.body.appendChild(timeContainer);
    }
  
    timeContainer.innerHTML = state.time;
  };

  function getRandomNumber(max) {
    return Math.floor(Math.random() * max + 1);
  };
  
  function getIsGameEnded(state) {
    return state.endGameWinning || state.endGameLosing;
  };
  
  function getIsGamePause(state) {
    return state.pause;
  };
 
