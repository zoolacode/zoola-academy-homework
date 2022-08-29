export const initialState = {
  pause: false,
  isGameEnded: false,
  snake: ["10:10", "11:10", "12:10", "13:10", "14:10"],
  direction: [1, 0],
  food: {},
  superFood: [],
  frame: 0,
  points: 0,
  speed: 200,
  gameTime: 0,
  speedUp: false,
  maxGameTime: 100,
  boardSize: 25,
};

export const adjustedBoardSize = initialState.boardSize - 1;
