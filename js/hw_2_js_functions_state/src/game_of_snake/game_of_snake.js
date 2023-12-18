import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";

// Good luck!
const boardSize = 625;
const cellWidth = 25;

const up = 38;
const down = 40;
const left = 37;
const right = 39;
const space = 32;
const extraFoodTime = 15000;
const initialTimer = 120000;


const initialSnake = [
    [10,10],
    [10,11],
    [10,12],
    [10,13],
    [10,14]        
];


const initialState = {
    currentScore: 0,
    gameLost: false,
    shouldRestart: false,
    food: generateFood(initialSnake,[]),
    extraFood : undefined,
    direction: 'setDirectionUp',
    currentSnake: initialSnake,
    timer: initialTimer,
    pause: false,
    currentHead: [10,10],
    
};

const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
    return initialState;
  });
  
engine.addSignalReducer("restartGame", () => {
    return {
        ...initialState,
        food: generateFood(initialSnake,[]),
       
        
    }
  });

engine.addSideEffect({
    onlyWhen: ({prevState,state}) => 
          getIsStateChanged('timer',{ prevState,state }) ||
          getIsStateChanged('pause',{prevState,state}),
    effect: ({state},emit) => {
        emit('moveSnake');
        const timeoutId = setTimeout(() => {
              emit('setTimer');
           },100);

        if(state.timer % extraFoodTime === 0 && state.timer !== initialTimer && state.timer !== 0){
            emit('placeExtraFood')
        } 
    
           return () => {
             clearTimeout(timeoutId);
           }  
    
    }

})


engine.addSideEffect({
    onlyWhen: ({ prevState, state }) =>
        getIsStateChanged("currentScore", { prevState, state }),
    effect: renderGameScore,
  });

engine.addSideEffect({
    onlyWhen: ({prevState,state}) => 
         getIsStateChanged("timer", {prevState,state}),
    effect: renderGameTimer,
  });

engine.addSideEffect({
    effect: renderGameBoard,
  });

engine.addSideEffect({
    onlyWhen: ({ prevState, state }) =>
       getIsStateChanged("gameLost", { prevState, state }),
    effect: renderGameAlert,
  });



engine.addSignalReducer('setTimer',state => {
    if(getIsGameEnded(state) || getIsGamePaused(state)){
        return state;
    };
    
    if(state.timer === 0){
        return {
            ...state,
            gameLost: true
        }
    }

    return {
        ...state,
        timer: state.timer - 100,
    }
})

engine.addSignalReducer('placeExtraFood',(state) => {
    if(getIsGameEnded(state)){
        return state;
    }
    

    const nextExtraFood = generateExtraFood(state.currentSnake,state.food,state.extraFood); 

    return {
        ...state,
        extraFood: nextExtraFood

    }
})

engine.addSignalReducer('PauseGame',state => {
    if(getIsGameEnded(state)){
        return state;
    }

    return {
        ...state,
        pause: !state.pause,
    }
})


engine.addSignalReducer('setDirectionLeft', state => {
    if(getIsGameEnded(state) || getIsGamePaused(state)){
        return state;
    };
    if(state.direction !== 'setDirectionRight'){
        return {
            ...state,
            direction: 'setDirectionLeft',
        };
    }
    return state;
})

engine.addSignalReducer('setDirectionUp', state => {
    if(getIsGameEnded(state) || getIsGamePaused(state)){
        return state;
    };
    if(state.direction !== 'setDirectionDown'){
        return {
            ...state,
            direction: 'setDirectionUp',
        };
    }
    return state;
})

engine.addSignalReducer('setDirectionRight', state => {
    if(getIsGameEnded(state) || getIsGamePaused(state)){
        return state;
    };
    if(state.direction !== 'setDirectionLeft'){
        return {
            ...state,
            direction: 'setDirectionRight',
        };
    }
    return state;
})


engine.addSignalReducer('setDirectionDown', state => {
    if(getIsGameEnded(state) || getIsGamePaused(state)){
        return state;
    };
    if(state.direction !== 'setDirectionUp'){
        return {
            ...state,
            direction: 'setDirectionDown',
        };
    }
    return state;
})


engine.addSignalReducer('moveSnake',state => {
    if(getIsGameEnded(state) || getIsGamePaused(state)){
        return state;
    };

    const prevSnakeBody = state.currentSnake;
   
    let prevSnakeHead = prevSnakeBody[0]; 
    
    switch(state.direction) {
        case "setDirectionLeft":
            currentHead = [prevSnakeHead[0] - 1,prevSnakeHead[1]]
            break;
        case "setDirectionRight":
            currentHead = [prevSnakeHead[0] + 1,prevSnakeHead[1]]
            break;
        case "setDirectionUp":
            currentHead = [prevSnakeHead[0], prevSnakeHead[1] - 1] 
            break;
        case "setDirectionDown":
            currentHead = [prevSnakeHead[0],prevSnakeHead[1] + 1]
            break;
        default:
            break;          
    }
 
    const isSnakeCollapsed = getIsCollapsed(prevSnakeBody,currentHead);

    const isGameLost = getIsHitBorder(currentHead);

    const snakeBodyExtraTail = getSnakeBodyExtraTail(isGameLost,prevSnakeHead,currentHead,prevSnakeBody);

    const isFoodEaten = getIsFoodEaten(currentHead,state.food);

    const isExtraEaten = getIsExtraFoodEaten(currentHead,state.extraFood);

    const finalEaten = isFoodEaten || isExtraEaten;

    const newSnake = growSnake(finalEaten,prevSnakeBody,currentHead,snakeBodyExtraTail)

    if(isGameLost || isSnakeCollapsed ) {
        return {
            ...state,
            gameLost: true
        }
    }

    return {
        ...state,
        currentSnake: newSnake, 
        food: isFoodEaten ? generateFood(...state.currentSnake,state.food) : state.food,
        extraFood: isExtraEaten ? undefined : state.extraFood,
        currentScore: finalEaten ? state.currentScore + 1 : state.currentScore
    }



})
  
engine.start();


function renderGameAlert({ state }, emit) {
    let alert = document.querySelector('.alert');
  
    if (!alert) {
      alert = document.createElement('div');
      alert.classList.add('alert');
      alert.innerHTML = 'Game has ended. Press "Enter" to start again';
      document.body.appendChild(alert);
    }
  
    const onAlertEnter = (e) => {
      if (e.key === 'Enter') {
        emit('restartGame');
      }
    };
  
    if (state.gameLost) {
      document.addEventListener('keyup', onAlertEnter);
      alert.classList.add('alert-loss');
    } else {
      alert.classList.remove('alert-loss');
    }
  
    return () => {
      document.removeEventListener('keyup', onAlertEnter);
    };
  }




function renderGameScore({state,prevState},emit){
    let scoreContainer = document.querySelector('.score');
    let span = document.createElement('span');

    if(!scoreContainer){
        scoreContainer = document.createElement('div');
        scoreContainer.classList.add('score');
        span = document.createElement('span');
        span.classList.add('score-value')
        scoreContainer.appendChild(span);
        document.body.append(scoreContainer);
    }
    document.querySelector('.score-value').innerHTML = state.currentScore;
    
}

function renderGameTimer({state,prevState},emit) {
    let timerContainer = document.querySelector('.timer');
    if(!timerContainer) {
        timerContainer = document.createElement('div');
        timerContainer.classList.add('timer');
        span = document.createElement('span');
        span.classList.add('timer-display');
        timerContainer.appendChild(span);
        document.body.append(timerContainer);

    }

    const minutes = Math.floor(state.timer/ (1000 * 60));
    const sec = Math.floor((state.timer / 1000) % 60);

    span.innerHTML = `${timeFormat(minutes)} : ${timeFormat(sec)}`;

}


function renderGameBoard({state,prevState},emit){
    let grid = document.querySelector('.grid');

    if(!grid){
        grid = document.createElement('div')
        grid.classList.add('grid')
            for(let k = 0;k < boardSize;k++){
                var cell = document.createElement('div');
                grid.appendChild(cell); 
            }
            document.body.append(grid);
    }
    
    state.currentSnake.forEach(([x,y]) => {
        const index = x + y * cellWidth
        grid.children[index].classList.add('snake')
    })

    const k = state.food[0] + state.food[1] * cellWidth;
    grid.children[k]?.classList.add('apple');


    if(state.extraFood !== undefined){
        const j = state.extraFood[0] + state.extraFood[1] * cellWidth;
        grid.children[j]?.classList.add('bonus-apple')
    }
    
    const handlePressKey = (e) => {
        switch(e.keyCode){
            case left:
                emit('setDirectionLeft');
                break;
            case up:
                emit('setDirectionUp');
                break;
            case right:
                emit('setDirectionRight');
                break;
            case down:
                emit('setDirectionDown');
                break;
            case space:
                emit('PauseGame');
                state.pause ? document.body.classList.remove('pause-game') : document.body.classList.add('pause-game') 
            default:
                break;  
        }
    }
    document.addEventListener('keydown',handlePressKey);

    return () => {
        state.currentSnake.forEach(([x,y]) => {
            const index = x + y * cellWidth
            grid.children[index].classList.remove('snake')
        })
        
        grid.children[k]?.classList.remove('apple');

        if(state.extraFood !== undefined){
            const j = state.extraFood[0] + state.extraFood[1] * cellWidth;
            grid.children[j]?.classList.remove('bonus-apple')
        }
    
        document.removeEventListener('keydown',handlePressKey);
        
    }


}

function getIsHitBorder(head){ 
    if(head[0] > 24 || head[1] < 0 || head[0] < 0 || head[1] > 24){
        return true;
    } else {
        return false;
    }

}

function getIsCollapsed(snake,head) {
    for(let i = 0;i < snake.length;i++){
        if(head[0] === snake[i][0] && head[1] === snake[i][1]){
            return true;
        }
    }
    return false

}


function getSnakeBodyExtraTail(isGameLost,prevSnakeHead,currentHead,prevSnakeBody){
    if(isGameLost){
        return [prevSnakeHead, ...prevSnakeBody];
    } else {
        return [currentHead, ...prevSnakeBody];
    }

}

function growSnake(finalEaten,prevSnakeBody,currentHead,snakeBodyExtraTail){
    if(!finalEaten){
        return snakeBodyExtraTail.slice(0,snakeBodyExtraTail.length - 1);
    } else {
        return [currentHead, ...prevSnakeBody];
    }
}

function getIsFoodEaten(head,food) {     
    if(head[0] === food[0] && head[1] === food[1]){
        return true;
    } else {
        return false;
    }


}

function getIsExtraFoodEaten(head,extraFood){
    if(extraFood !== undefined && head[0] === extraFood[0] && head[1] === extraFood[1]){
        return true;
    } else {
        return false;
    }
}

function getIsGameEnded(state){
    return  state.gameLost;
}

function getIsGamePaused(state){
    return state.pause;
}


function getIsStateChanged(stateKey, { prevState, state }) {
    return prevState?.[stateKey] !== state[stateKey];
  }

function timeFormat(t) {
    return t < 10 ? '0' + t : t;
}

function generateFood(snakeBody,food) {
    for(let i = 0;i < snakeBody.length; i++){
        if(snakeBody[i][0] !== food[0] && snakeBody[i][0] !== food[1]){
            food = [Math.floor(Math.random() * 24),Math.floor(Math.random() * 24)];
           
           
        }
    }
    return food;
}

function generateExtraFood(snakeBody,food,extraFood){
    for(let i = 0;i < snakeBody.length; i++){
        if(extraFood == undefined || (snakeBody[i][0] !== extraFood[0] && snakeBody[i][0] !== extraFood[1] && extraFood[0] !== food[0] && extraFood[1] !== food[1])){
            extraFood = [Math.floor(Math.random() * 24),Math.floor(Math.random() * 24)];
        }
    }

    return extraFood;
}

