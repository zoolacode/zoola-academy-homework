import { initialState } from "./game_constants";
import { getIsGameEnded } from "./game_utils";

export function addSnakeControls(engine) {
  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) => !prevState || !getIsGameEnded(state),
    effect: ({ state }, emit) => {
      const onKeyUp = (e) => {
        if (
          !["ArrowUp", "ArrowRight", "ArrowLeft", "ArrowDown"].includes(e.code)
        ) {
          return;
        }

        const arrowToDirection = {
          ArrowUp: [0, -1],
          ArrowRight: [1, 0],
          ArrowLeft: [-1, 0],
          ArrowDown: [0, 1],
        };
        const nextDirection = arrowToDirection[e.code];
        emit("changeDirection", nextDirection);
      };

      document.addEventListener("keyup", onKeyUp);

      return () => {
        document.removeEventListener("keyup", onKeyUp);
      };
    },
  });

  engine.addSideEffect({
    onlyWhen: ({ prevState }) => !prevState,
    effect: (_, emit) => {
      const onKeyUp = (e) => {
        if (e.key === "Shift") {
          emit("speedUp", false);
        }
      };

      const onKeyDown = (e) => {
        if (e.key === "Shift") {
          emit("speedUp", true);
        }
      };

      document.addEventListener("keydown", onKeyDown);
      document.addEventListener("keyup", onKeyUp);

      return () => {
        document.removeEventListener("keydown", onKeyDown);
        document.removeEventListener("keyup", onKeyUp);
      };
    },
  });

  engine.addSignalReducer("speedUp", (state, value) => {
    return {
      ...state,
      speedUp: value,
      speed: value ? initialState.speed / 2 : initialState.speed,
    };
  });
}
