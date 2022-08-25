function pipe(...fns) {
  return (...args) => {
    const [first, ...rest] = fns;
    return rest.reduce((acc, fn) => {
      return fn(acc);
    }, first(...args));
  };
}

export const createEngine = () => {
  let sideEffects = [];

  let state;

  let globalReducerFn;

  const reducerFns = {
    [ENGINE_INITIALIZE_SIGNAL]: (state) => state,
  };

  const runSideEffects = ({ prevState, state }) => {
    sideEffects = sideEffects.map(({ effectFn, cleanUpFn, conditionFn }) => {
      let nextCleanUpFn = cleanUpFn;

      if (conditionFn({ prevState, state })) {
        cleanUpFn?.();
        nextCleanUpFn = effectFn({ state, prevState }, publicEmit);
      }

      return {
        effectFn,
        cleanUpFn: nextCleanUpFn,
        conditionFn,
      };
    });
  };

  const emit = (signal, payload) => {
    let prevState = state;

    const stateFn =
      typeof reducerFns[signal] === "function"
        ? reducerFns[signal]
        : (state) => state;

    const reducerFnsWithPayload = [
      stateFn,
      globalReducerFn ?? ((state) => state),
    ].map((fn) => (state) => fn(state, payload));

    state = pipe(...reducerFnsWithPayload)(prevState, payload);

    if (state !== prevState) {
      runSideEffects({ prevState, state });
    }
  };

  const publicEmit = (signal, payload) => {
    // always run "emit" in the a Event Loop iteration to let all synchronous code complete
    setTimeout(() => {
      try {
        emit(signal, payload);
      } catch (err) {
        logError("emit", err);
      }
    }, 0);
  };

  return {
    addSideEffect: ({ effect: sideEffectFn, onlyWhen = () => true }) => {
      sideEffects.push({
        effectFn: sideEffectFn,
        cleanUpFn: () => {},
        conditionFn: onlyWhen,
      });
    },
    addSignalReducer: (signal, fn) => {
      if (reducerFns[signal] && signal !== ENGINE_INITIALIZE_SIGNAL) {
        throw new Error(
          `Engine: There can be only one reducer for a given signal: ${signal}`
        );
      }
      reducerFns[signal] = fn;
    },
    addGlobalReducer: (fn) => {
      if (globalReducerFn) {
        throw new Error("Engine: There can be only one global reducer");
      }
      globalReducerFn = fn;
    },
    start: function () {
      emit(ENGINE_INITIALIZE_SIGNAL);
    },
  };
};

function logError(type, err) {
  console.log(`Engine: ${type} error`);
  console.dir(err);
}

// Initialize signal doesn't have to be a Symbol, but it's a valid use-case if you want to ensure uniqueness
export const ENGINE_INITIALIZE_SIGNAL = Symbol("ENGINE_INITIALIZE_SIGNAL");
