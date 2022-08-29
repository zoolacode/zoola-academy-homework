export function addGameScore(engine) {
  engine.addSideEffect({
    onlyWhen: ({ prevState, state }) => prevState?.points !== state.points,
    effect: renderGameScore,
  });

  function renderGameScore({ state, prevState }, emit) {
    let scoreContainer = document.querySelector(".score");

    if (!scoreContainer) {
      scoreContainer = document.createElement("div");
      scoreContainer.classList.add("score");
      document.body.appendChild(scoreContainer);
    }

    scoreContainer.innerHTML = state.points;
  }
}
