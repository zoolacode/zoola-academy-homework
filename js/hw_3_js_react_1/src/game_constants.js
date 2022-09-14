import { getIndex, getRandomDishPosition } from './utils';

export const bonusDishLifeTime = 5000;

export const initialSnakeCoords = [
  getIndex(10, 10),
  getIndex(10, 11),
  getIndex(10, 12),
  getIndex(10, 13),
  getIndex(10, 14),
];

export const initialState = {
  snakeHead: {
    x: 10,
    y: 14,
  },
  currentScore: 0,
  gameTimer: 0,
  direction: 'moveDown',
  gameLost: false,
  gameOn: true,
  snakeCoords: initialSnakeCoords,
  dish: getRandomDishPosition(initialSnakeCoords, null, null),
  bonusDish: null,
  bonusDishExpiresTime: 0,
  speedUp: false,
};
