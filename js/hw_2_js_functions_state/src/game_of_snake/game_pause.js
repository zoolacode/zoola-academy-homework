import { getIsGameEnded } from "./game_utils";

export function addGamePause(engine) {
  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) => prevState?.pause !== state.pause,
    effect: renderPauseScreen,
  });

  engine.addSideEffect({
    effect: ({ state }, emit) => {
      if (getIsGameEnded(state)) {
        return;
      }

      const onKeyUp = (e) => {
        if (e.code === "Space") {
          emit("togglePause");
        }
      };

      document.addEventListener("keyup", onKeyUp);

      return () => {
        document.removeEventListener("keyup", onKeyUp);
      };
    },
  });

  engine.addSignalReducer("togglePause", (state) => {
    return {
      ...state,
      pause: !state.pause,
    };
  });

  function renderPauseScreen({ state }) {
    let pauseScreen = document.querySelector(".pause-screen");

    if (!pauseScreen) {
      pauseScreen = document.createElement("div");
      pauseScreen.classList.add("pause-screen");
      document.body.appendChild(pauseScreen);
    }

    if (state.pause) {
      pauseScreen.classList.add("active");
    } else {
      pauseScreen.classList.remove("active");
    }
  }
}
