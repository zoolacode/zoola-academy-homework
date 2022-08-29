import { getIsGameEnded, getIsGameOnPause } from "../game_utils";
import { adjustTimeToScreen } from "../utils";
import { getAllFood, getRandomFoodCoordinates } from "./snake_food_utils";

export function addSnakeFood(engine) {
  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) => prevState?.gameTime !== state.gameTime,
    effect: ({ state }, emit) => {
      if (getIsGameOnPause(state) || getIsGameEnded(state)) {
        return;
      }

      emit("removeExpiredSuperFood");

      if (state.gameTime !== 0 && state.gameTime % 5 === 0) {
        emit("newSuperFood");
      }
    },
  });

  engine.addSignalReducer("removeExpiredSuperFood", (state) => {
    const expiredSuperFood = state.superFood
      .filter(({ expiresAt }) => state.gameTime >= expiresAt)
      .map(({ location }) => location);

    if (expiredSuperFood.length === 0) {
      return state;
    }

    return {
      ...state,
      food: expiredSuperFood.reduce(
        (acc, expiredLocation) => {
          return {
            ...acc,
            [expiredLocation]: false,
          };
        },
        { ...state.food }
      ),
      superFood: state.superFood.filter(
        ({ expiresAt }) => state.gameTime < expiresAt
      ),
    };
  });

  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) =>
      prevState?.gameTime !== state.gameTime ||
      prevState.superFood !== state.superFood,
    effect: renderSuperFoodTimer,
  });

  engine.addSignalReducer("newSuperFood", (state) => {
    const superfoodExpirationTime = 5;
    const superFoodCoordinates = getRandomFoodCoordinates(
      getAllFood(state),
      state.snake
    );
    return {
      ...state,
      superFood: [
        ...state.superFood,
        {
          location: superFoodCoordinates,
          expiresAt: state.gameTime + superfoodExpirationTime,
        },
      ],
      food: {
        ...state.food,
        [superFoodCoordinates]: true,
      },
    };
  });

  engine.addSignalReducer("newFood", (state) => {
    const allFood = Object.entries(state.food).filter(
      ([_, value]) => value
    ).length;

    if (allFood > 2) {
      return state;
    }

    const foodCoordinates = getRandomFoodCoordinates(
      getAllFood(state),
      state.snake
    );

    return {
      ...state,
      food: {
        ...state.food,
        [foodCoordinates]: true,
      },
    };
  });

  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) => prevState?.frame !== state.frame,
    effect: ({ state }, emit) => {
      if (state.frame === 0) {
        emit("newFood");
      }
    },
  });
}

export function renderSuperFoodTimer({ state }) {
  let superFoodTimer = document.querySelector(".superfood-timer");

  if (!superFoodTimer) {
    superFoodTimer = document.createElement("div");
    superFoodTimer.classList.add("superfood-timer");
    document.body.appendChild(superFoodTimer);
  }

  if (state.superFood.length === 0) {
    superFoodTimer.classList.remove("active");
    return;
  }

  superFoodTimer.classList.add("active");

  const text = state.superFood
    .map((item) => item.expiresAt)
    .reduce((acc, expiresAt) => {
      const secondsLeft = expiresAt - state.gameTime;
      const minutes = Math.floor(secondsLeft / 60);
      const seconds = secondsLeft % 60;
      return `${adjustTimeToScreen(minutes)}:${adjustTimeToScreen(seconds)}\n`;
    }, "");

  superFoodTimer.innerHTML = text;
}
