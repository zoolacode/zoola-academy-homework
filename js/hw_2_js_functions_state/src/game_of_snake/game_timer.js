import { getIsGameEnded, getIsGameOnPause } from "./game_utils";
import { adjustTimeToScreen } from "./utils";

export function addGameTime(engine) {
  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) =>
      prevState?.pause !== state.pause ||
      prevState?.isGameEnded !== state.isGameEnded ||
      prevState?.gameTime !== state.gameTime,
    effect: ({ state }, emit) => {
      if (getIsGameEnded(state) || getIsGameOnPause(state)) {
        return;
      }

      const timeoutId = setTimeout(() => {
        emit("incrementGameTime");
      }, 1000);

      return () => {
        clearTimeout(timeoutId);
      };
    },
  });

  engine.addSignalReducer("incrementGameTime", (state) => {
    const nextGameTime = state.gameTime + 1;

    return {
      ...state,
      isGameEnded: nextGameTime > state.maxGameTime,
      gameTime: nextGameTime,
    };
  });

  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) => prevState?.gameTime !== state.gameTime,
    effect: renderGameTime,
  });

  function renderGameTime({ state, prevState }, emit) {
    let gameTimeContainer = document.querySelector(".gametime");

    if (!gameTimeContainer) {
      gameTimeContainer = document.createElement("div");
      gameTimeContainer.classList.add("gametime");
      document.body.appendChild(gameTimeContainer);
    }

    const secondsLeft = state.maxGameTime - state.gameTime;

    if (secondsLeft < 0) {
      gameTimeContainer.innerHTML = "00:00";
      return;
    }

    const minutes = Math.floor(secondsLeft / 60);
    const seconds = secondsLeft % 60;
    gameTimeContainer.innerHTML = `${adjustTimeToScreen(
      minutes
    )}:${adjustTimeToScreen(seconds)}`;
  }
}
