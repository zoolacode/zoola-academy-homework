import { arrayOfLength, getRandomNumber, stringifyCoordinates } from "../utils";

export function getRandomFoodCoordinates(currentFood, currentSnake, boardSize) {
  const board = arrayOfLength(boardSize ** 2).map((_, index) => {
    const x = index % boardSize;
    const y = Math.floor(index / boardSize);
    return stringifyCoordinates([x, y]);
  });

  const disallowedBoard = getForbiddenFoodCoordinates(
    currentFood,
    currentSnake
  );

  const allowedBoard = board.filter(
    (coordinates) => !disallowedBoard[coordinates]
  );

  const randomNumber = getRandomNumber(allowedBoard.length - 1);
  return allowedBoard[randomNumber];
}

export function getAllFood(state) {
  return state.superFood
    .map(({ location }) => location)
    .reduce(
      (acc, location) => {
        return {
          ...acc,
          [location]: true,
        };
      },
      { ...state.food }
    );
}

export function getIsFoodThere(coordinates, food) {
  return food[coordinates];
}

export function removeFood(coordinate, food) {
  return {
    ...food,
    [coordinate]: false,
  };
}

export function getForbiddenFoodCoordinates(currentFood, currentSnake) {
  return currentSnake.reduce(
    (acc, coordinate) => {
      return {
        ...acc,
        [coordinate]: true,
      };
    },
    { ...currentFood }
  );
}

export function removeSuperFood(superFood, coordinates) {
  return superFood.filter(({ location }) => {
    return location !== coordinates;
  });
}
