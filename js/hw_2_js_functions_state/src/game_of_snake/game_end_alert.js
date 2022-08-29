export function addGameEndAlert(engine) {
  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) =>
      prevState?.isGameEnded !== state.isGameEnded,
    effect: renderGameAlert,
  });

  function renderGameAlert({ state, prevState }, emit) {
    let alert = document.querySelector(".alert");

    if (!alert) {
      alert = document.createElement("div");
      alert.classList.add("alert");
      alert.innerHTML = 'Game has ended. Press "Enter" to start again';
      document.body.appendChild(alert);
    }

    const onAlertEnter = (e) => {
      if (e.key === "Enter") {
        emit("restartGame");
      }
    };

    if (state.isGameEnded) {
      document.addEventListener("keyup", onAlertEnter);
      alert.classList.add(state.gameWon ? "alert-win" : "alert-loss");
    } else {
      alert.classList.remove("alert-win");
      alert.classList.remove("alert-loss");
    }

    return () => {
      document.removeEventListener("keyup", onAlertEnter);
    };
  }
}
