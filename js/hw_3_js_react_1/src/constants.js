export const initialTimer = 120000;

export const initialSnake = [
    [10,10],
    [10,11],
    [10,12],
    [10,13],
    [10,14],
    
  ]
 export const Up = 38;
 export const Down = 40;
 export const Left = 37;
 export const Right = 39;
 export const Space = 32;
 export const extraFoodTime = 15000;
 const cellWidth = 25;
 export const board = Array(cellWidth).fill(0).map(_=> Array(cellWidth).fill(0));
