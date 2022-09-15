export const getClassName = (rowId,cellId,snake,food,extraFood) => {
    let className = 'cell';
    for(let i = 0; i < snake.length;i++){
      if(snake[i][0] === rowId && snake[i][1] === cellId){
        className = 'cell snake';
      }
    }
    
    if(food[0] === rowId && food[1] === cellId){
      className = 'cell food';
    }
     
    
    if(extraFood !== undefined && extraFood[0] === rowId && extraFood[1] === cellId){
      className  = 'cell bonus-food';
    }
  
  
    return className;
  };


  export function generateFood(snakeBody,food) {
    for(let i = 0;i < snakeBody.length; i++){
        if(snakeBody[i][0] !== food[0] && snakeBody[i][0] !== food[1]){
            food = [Math.floor(Math.random() * 24),Math.floor(Math.random() * 24)];
           
           
        }
    }
    return food;
}

export function generateExtraFood(snakeBody,food,extraFood){
    for(let i = 0;i < snakeBody.length; i++){
        if(extraFood === undefined || (snakeBody[i][0] !== extraFood[0] && snakeBody[i][0] !== extraFood[1] && extraFood[0] !== food[0] && extraFood[1] !== food[1])){
            extraFood = [Math.floor(Math.random() * 24),Math.floor(Math.random() * 24)];
        }
    }

    return extraFood;
}


export function getIsHitBorder(head){ 
    if(head[0] > 24 || head[1] < 0 || head[0] < 0 || head[1] > 24){
        return true;
    } else {
        return false;
    }

}

export function getIsCollapsed(snake,head) {
    for(let i = 0;i < snake.length;i++){
        if(head[0] === snake[i][0] && head[1] === snake[i][1]){
            
            return true;
        }
    }
    return false

}


export function getSnakeBodyExtraTail(isGameLost,prevSnakeHead,currentHead,prevSnakeBody){
    if(isGameLost){
        return [prevSnakeHead, ...prevSnakeBody];
    } else {
        return [currentHead, ...prevSnakeBody];
    }

}

export function growSnake(finalEaten,prevSnakeBody,currentHead,snakeBodyExtraTail){
    if(!finalEaten){
        return snakeBodyExtraTail.slice(0,snakeBodyExtraTail.length - 1);
    } else {
        return [currentHead, ...prevSnakeBody];
    }
}

export function getIsFoodEaten(head,food) {     
    if(head[0] === food[0] && head[1] === food[1]){
        console.log('Collapsed -- HEAD ' + head + ' ,FOOD - ' + food)
        return true;
    } else {
        return false;
    }


}

export function getIsExtraFoodEaten(head,extraFood){
    if(extraFood !== undefined && head[0] === extraFood[0] && head[1] === extraFood[1]){
        return true;
    } else {
        return false;
    }
}
