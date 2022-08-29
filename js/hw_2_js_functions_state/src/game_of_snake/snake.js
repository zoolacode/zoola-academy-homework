let meshContainer = document.createElement("div");
document.body.appendChild(meshContainer)
meshContainer.classList.add("mesh");

const meshSize = 625;
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
}

function generateSnake() {
    let posX = 5;
    let posY = 5;
    return [posX, posY];
}

let cordinates = generateSnake();
let snakeBody = [document.querySelector(`[posX = '${cordinates[0]}'][posY = '${cordinates[1]}']`),
document.querySelector(`[posX = '${cordinates[0]-1}'][posY = '${cordinates[1]}']`),
document.querySelector(`[posX = '${cordinates[0]-2}'][posY = '${cordinates[1]}']`),
document.querySelector(`[posX = '${cordinates[0]-3}'][posY = '${cordinates[1]}']`),
document.querySelector(`[posX = '${cordinates[0]-4}'][posY = '${cordinates[1]}']`)];


snakeBody.forEach(item => item.classList.add('snakeBody'));
snakeBody[0].classList.add('snakeHead')

let corm;

function createCorm() {
    function generetaCorm(max) {
        let posX = Math.floor(Math.random() * max)
        let posY = Math.floor(Math.random() * max)
        return [posX, posY]
    }
    
    let cormCoordinates = generetaCorm(25)

    corm = document.querySelector(`[posX = '${cormCoordinates[0]}'][posY = '${cormCoordinates[1]}']`)

    while(corm.classList.contains('snakeBody')) {
        let cormCoordinates = generetaCorm(25)
        corm = document.querySelector(`[posX = '${cormCoordinates[0]}'][posY = '${cormCoordinates[1]}']`)
    }

    corm.classList.add('corm')
    
}

createCorm()

let direction = 'right';

function move() {
    let snakeCoordinates = [snakeBody[0].getAttribute('posX'), snakeBody[0].getAttribute('posY')];
    snakeBody[0].classList.remove('snakeHead');
    snakeBody[snakeBody.length - 1].classList.remove('snakeBody');
    snakeBody.pop();

    if(direction === 'right') {
        if (snakeCoordinates[0] < 25) {
            snakeBody.unshift(document.querySelector(`[posX = '${+snakeCoordinates[0] + 1}'][posY = '${snakeCoordinates[1]}']`));
        } else {
            snakeBody.unshift(document.querySelector(`[posX = '1'][posY = '${snakeCoordinates[1]}']`));
        }
    } else if(direction === 'left') {
        if (snakeCoordinates[0] > 1) {
            snakeBody.unshift(document.querySelector(`[posX = '${+snakeCoordinates[0] - 1}'][posY = '${snakeCoordinates[1]}']`));
        } else {
            snakeBody.unshift(document.querySelector(`[posX = '25'][posY = '${snakeCoordinates[1]}']`));
        }
    } else if(direction === 'down') {
        if (snakeCoordinates[1] > 1) {
            snakeBody.unshift(document.querySelector(`[posX = '${+snakeCoordinates[0]}'][posY = '${+snakeCoordinates[1] - 1}']`));
        } else {
            snakeBody.unshift(document.querySelector(`[posX = '${snakeCoordinates[0]}'][posY = '25']`));
        }
    } else if(direction === 'up') {
        if (snakeCoordinates[1] < 25) {
            snakeBody.unshift(document.querySelector(`[posX = '${+snakeCoordinates[0]}'][posY = '${+snakeCoordinates[1] + 1}']`));
        } else {
            snakeBody.unshift(document.querySelector(`[posX = '${snakeCoordinates[0]}'][posY = '1']`));
        }
    }
    
    if(snakeBody[0].getAttribute('posX') === corm.getAttribute('posX') && snakeBody[0].getAttribute('posY') === corm.getAttribute('posY')) {
        corm.classList.remove('corm')
        let a = snakeBody[snakeBody.length - 1].getAttribute('posX');
        let b = snakeBody[snakeBody.length - 1].getAttribute('posY');
        // snakeBody.push(document.querySelector(`[posX = '${+a}'][posY = '${+b}']`));
        snakeBody = [...snakeBody, document.querySelector(`[posX = '${+a}'][posY = '${+b}']`)]
        createCorm()

    }

    if(snakeBody[0].classList.contains('snakeBody')) {
        clearInterval(interval)
    }
    
    snakeBody[0].classList.add('snakeHead');
    snakeBody.forEach(item => item.classList.add('snakeBody'));
}

let interval = setInterval(move, 100)

window.addEventListener('keydown', e => {
    if(e.key === 'ArrowLeft' && direction!= 'right') {
        direction = 'left'
    } else if(e.key === 'ArrowUp' && direction!= 'down') {
        direction = 'up'
    } else if(e.key === 'ArrowRight' && direction!= 'left') {
        direction = 'right'
    } else if(e.key === 'ArrowDown' && direction!= 'up') {
        direction = 'down'
    }
})
