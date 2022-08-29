import { adjustedBoardSize } from "../game_constants";
import { getRandomNumber, stringifyCoordinates } from "../utils";

export function getRandomFoodCoordinates(
  currentFood,
  currentSnake,
  forbiddenCoordinates = getForbiddenFoodCoordinates(currentFood, currentSnake)
) {
  const nextFoodCoordinates = [
    getRandomNumber(adjustedBoardSize),
    getRandomNumber(adjustedBoardSize),
  ];

  if (forbiddenCoordinates[nextFoodCoordinates]) {
    return getRandomFoodCoordinates(
      currentFood,
      currentSnake,
      forbiddenCoordinates
    );
  }

  return stringifyCoordinates(nextFoodCoordinates);
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
