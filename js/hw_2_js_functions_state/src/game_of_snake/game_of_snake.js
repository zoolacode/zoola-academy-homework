import { emit } from "process";
import { createEngine, ENGINE_INITIALIZE_SIGNAL } from "../engine/engine";


const meshSize = 625;

const initialState = {
  snakeHead: [10, 10],
  snakeBody: [
    [10,10],
    [10,11],
    [10,12],
    [10,13],
    [10,14]
  ],
  food: [[15, 15]],
  direction: 'up',
  getWin: false,
  getLose: false,
  timer: 120000000,
  timeGone: 0,
  score: 0,
  pause: false
}


const engine = createEngine();

engine.addSignalReducer(ENGINE_INITIALIZE_SIGNAL, () => {
  return initialState;
});

engine.addSignalReducer("restartGame", () => {
  return initialState
});

engine.addSignalReducer('setTimer',state => {
  if(state.getWin || state.getLose  || state.pause) return state
  
  if(state.timer === 0){
      return {
          ...state,
          getLose: true
      }
  }

  return {
      ...state,
      timer: state.timer - 100,
      timeGone: state.timeGone + 100
  }
})


engine.addSignalReducer('up', state => {
  if(state.getWin || state.getLose || state.pause) return state


  if(state.direction === 'up' || state.direction === 'down'){
    return state;
  }
  return {
      ...state,
      direction: 'up',
  };
})

engine.addSignalReducer('down', state => {
  if(state.getWin || state.getLose || state.pause) return state


  if(state.direction === 'down'  || state.direction === 'up'){
    return state;
  }
  return {
      ...state,
      direction: 'down',
  };
})

engine.addSignalReducer('left', state => {
  if(state.getWin || state.getLose || state.pause) return state


  if(state.direction === 'left'  || state.direction === 'right'){
    return state;
  }
  return {
      ...state,
      direction: 'left',
  };
})

engine.addSignalReducer('right', state => {
  if(state.getWin || state.getLose || state.pause) return state


  if(state.direction === 'right'  || state.direction === 'left'){
    return state;
  }
  return {
      ...state,
      direction: 'right',
  };
})

engine.addSignalReducer('snakeMove', state => {
  const prevBodyPosition = state.snakeBody;
  let prevHeadPosition = prevBodyPosition[0];
  let newSnakeHead = state.snakeHead
  let snakeLength = state.snakeBody.length

  switch (state.direction) {
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


  if(isHitBorder(newSnakeHead) || isHitSelf(newSnakeHead, state.snakeBody)) {
    return {
      ...state,
      getLose: true
    }
  } else if(state.pause) {
    return state
  }

  let newData = []
  let newFoodPosition = state.food
  let newScore = state.score
  let newTimeGone = state.timeGone

  if (isFoodEaten(newSnakeHead, state.food)) {
    newData = [
      newSnakeHead,
      ...state.snakeBody
    ]

    newFoodPosition = generateFood(state.snakeBody)
    newScore = state.score + 1
    newTimeGone = 0
  }else if(state.timeGone % 15000 === 0) {
    newData = [
      newSnakeHead,
      ...state.snakeBody.slice(0, snakeLength - 1)
    ]

    newFoodPosition = generateFood(state.snakeBody)
    newTimeGone = 0
  } else {
    newData = [
      newSnakeHead,
      ...state.snakeBody.slice(0, snakeLength - 1)
    ]
  }

  return {
    ...state,
    snakeBody: newData,
    snakeHead: newSnakeHead,
    food: newFoodPosition,
    score: newScore,
    timeGone: newTimeGone
  }
})

engine.addSignalReducer('pauseGame',state => {
  if(state.getWin || state.getLose){
      return state;
  }

  return {
      ...state,
      pause: !state.pause,
  }
})

engine.addSideEffect({
  onlyWhen: ({prevState,state}) => 
        getIsStateChanged('timer',{ prevState,state }) ||
        getIsStateChanged('pause',{prevState,state}),

  effect: ({ state }, emit) => {
        emit('snakeMove');
        const timeoutId = setTimeout(() => {
           emit('setTimer');
        },100);
      
        return () => {
          clearTimeout(timeoutId);
        }  
  
  }
})

engine.addSideEffect({
  effect: renderGameBoard,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
     getIsStateChanged("getLose", { prevState, state }),
  effect: renderAlert,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
      getIsStateChanged("score", { prevState, state }),
  effect: renderScore,
});

engine.addSideEffect({
  onlyWhen: ({ prevState, state }) =>
      getIsStateChanged("timer", { prevState, state }),
  effect: renderTimer,
});

engine.start();

function renderAlert({ state }, emit) {
  let alert = document.querySelector('.alert');
  
    if (!alert) {
      alert = document.createElement('div');
      alert.classList.add('alert');
      alert.innerHTML = 'Game has ended. Press "Enter" to start again';
      document.body.appendChild(alert);
    }

    const onAlertEnter = (e) => {
      if (e.keyCode === 13) {
        emit('restartGame');
      }
    }

    if (state.getLose) {
      document.addEventListener('keyup', onAlertEnter);
      alert.classList.add('alert-loss');
    } else {
      alert.classList.remove('alert-loss');
    }
  
    return () => {
      document.removeEventListener('keyup', onAlertEnter);
    };
}

function renderScore({ state }) {
  let scoreContainer = document.querySelector('.score');

    if(!scoreContainer){
        scoreContainer = document.createElement('div');
        scoreContainer.classList.add('score');
        let span = document.createElement('span');
        span.classList.add('score-value')
        scoreContainer.appendChild(span);
        document.body.append(scoreContainer);
    }
    document.querySelector('.score-value').innerHTML = state.score;
}

function renderTimer({ state }) {
  let timerContainer = document.querySelector('.timer');
  
  if(!timerContainer) {
      timerContainer = document.createElement('div');
      timerContainer.classList.add('timer');
      document.body.append(timerContainer);
  }

  let minutes = Math.floor(state.timer/ (1000 * 60));
  let seconds = Math.floor((state.timer / 1000) - (minutes * 60));

  timerContainer.innerHTML = `${getFormatedTime(minutes)} : ${getFormatedTime(seconds)}`;

}




function renderGameBoard({ state }, emit) {
  let mesh = document.querySelector('.mesh')

  if(!mesh) {
    mesh = document.createElement('div')
    mesh.classList.add('mesh')

    for( let i = 0; i < meshSize; i++) {
      var cell = document.createElement('div')
      mesh.appendChild(cell)
    }

    document.body.append(mesh)
  }

  const snakeMeshBody = state.snakeBody.map(([x, y]) => {
    let index = x + y * 25;
    return mesh.children[index]
  });

  snakeMeshBody.forEach((item) => item.classList.add("snakeBody"));
  snakeMeshBody[0].classList.add("snakeHead");

  const foodLocation = state.food[0] + state.food[1] * 25;
  
  if (((state.score + 1) % 10) === 0) {
    mesh.children[foodLocation]?.classList.add('apple_gold')
  } else {
    mesh.children[foodLocation]?.classList.add('apple')
  }

  const handlePressKey = (event) => {     
    switch(event.keyCode){
        case 65/* 37 */:
            emit('left');
            break;
        case 87/* 38 */:
            emit('up');
            break;
        case 68/* 39 */:
            emit('right');
            break;
        case 83/* 40 */:
            emit('down');
            break;
        case 32: 
            emit('pauseGame');
        default:
            break;  
    }
  }
  document.addEventListener('keydown', handlePressKey);

  return () => {
    state.snakeBody.forEach(([x,y]) => {
        const index = x + y * 25
       mesh.children[index].classList.remove('snakeBody')
       mesh.children[index].classList.remove('snakeHead')
    })

    mesh.children[foodLocation]?.classList.remove('apple');
    mesh.children[foodLocation]?.classList.remove('apple_gold');

    document.removeEventListener('keydown', handlePressKey);

  }
}

function getIsStateChanged(stateKey, { prevState, state }) {
  return prevState?.[stateKey] !== state[stateKey];
}

function isHitBorder(head){ 
  if(head[0] > 24 || head[1] < 0 || head[0] < 0 || head[1] > 24){
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

function generateFood(snakeBody) {
  let newPosition = [getRandomNum(24), getRandomNum(24)]
  for (let i = 0; i < snakeBody.length; i++) {
    if(snakeBody[i][0] === newPosition[0] || snakeBody[i][0] === newPosition[1]) {
      newPosition = [getRandomNum(24), getRandomNum(24)]
    }
  }

  return newPosition
}

function getFormatedTime (time) {
  return time.toString().padStart(2, '0')
}

function getRandomNum(num) {
  return Math.floor(Math.random() * num)
}