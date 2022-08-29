The engine can be instantiated by calling `createEngine`.
Engine uses several entities, such as signals, reducers, side-effects, and state.

## State

Application state is derived from reducer functions based on the previous state and the latest signal.
Whenever state is changed, engine runs side-effects. State can only be changed with the help of reducers.

## Держава

Стан програми виводиться з функцій редуктора на основі попереднього стану та останнього сигналу.
Щоразу, коли стан змінюється, двигун запускає побічні ефекти. Стан можна змінити тільки за допомогою редукторів.

## Signals

- Signals can be emitted with the help of `emit` function.
- `emit` function can only be accessed inside side-effects.
- `emit` takes two parameters - signal name and signal value.
- To subscribe reducer function to a signal, use `addSignalReducer(signalName, reducerFunction)`
## Сигнали

- Сигнали можна випромінювати за допомогою функції `emit`.
- Функція `emit` доступна лише всередині побічних ефектів.
- `emit` приймає два параметри - назву сигналу та значення сигналу.
- Щоб підписатися на функцію редуктора для сигналу, використовуйте `addSignalReducer(signalName, reducerFunction)`


## Reducers

- Reducer is a pure function that calculates next state based on previous state and signal name/value.
- `state` is passed as the first parameter, signal value as the second.
- Use `addSignalReducer` to register a reducer for a particular signal.
- Use `addGlobalReducer` to register a reducer that will be called after signal reducer have finished their work.

## Редуктори

- Reducer — це чиста функція, яка обчислює наступний стан на основі попереднього стану та назви/значення сигналу.
- `state` передається як перший параметр, значення сигналу як другий.
- Використовуйте `addSignalReducer`, щоб зареєструвати редуктор для певного сигналу.
- Використовуйте `addGlobalReducer`, щоб зареєструвати редуктор, який буде викликаний після того, як редуктор сигналу завершить свою роботу.


### Side-effects

- Side-effects are functions that are called every time a state has been changed.

- If side-effect returns a function, it is considered to be a clean-up function and is called right before a side-effect is called. Returning a clean-up function is optional.

- Side-effects can define `onlyWhen` function to help framework understand the conditions under which a side-effects needs to be called. It is useful to when dealing with timeouts, because if `onlyWhen` is not defined - the timeout will keep reseting on every state change (if a clean-up function was provided, which is a good practice when working with timeouts).

- Side-effect function accepts previous application state and current application state as the first parameter, and `emit` function as the second.

- `emit` function can be used to publish new signals.

- Side-effects can be registered via `engine.addSideEffect`.

- If you need a side effect to run on every change - do not use `onlyWhen` function.

- If you need a side effect to run only when the engine starts - use `onlyWhen: ({prevState}) => prevState === undefined`


### Побічні ефекти

- Побічні ефекти – це функції, які викликаються кожного разу, коли змінюється стан.

- Якщо побічний ефект повертає функцію, вона вважається функцією очищення та викликається безпосередньо перед викликом побічного ефекту. Повернення функції очищення необов’язкове.

- Побічні ефекти можуть визначати функцію `onlyWhen`, щоб допомогти структурі зрозуміти умови, за яких потрібно викликати побічні ефекти. Це корисно під час роботи з тайм-аутами, тому що якщо `onlyWhen` не визначено, тайм-аут продовжуватиме скидатися при кожній зміні стану (якщо було надано функцію очищення, що є хорошою практикою під час роботи з тайм-аутами).

- Функція побічного ефекту приймає попередній стан програми та поточний стан програми як перший параметр, а функцію `emit` як другий.

- Функція `emit` може бути використана для публікації нових сигналів.

- Побічні ефекти можна зареєструвати через `engine.addSideEffect`.

- Якщо вам потрібно, щоб побічний ефект запускався при кожній зміні - не використовуйте функцію `onlyWhen`.

- Якщо вам потрібен побічний ефект, щоб працювати лише під час запуску двигуна - використовуйте `onlyWhen: ({prevState}) => prevState === undefined`


### Initial state

Always subscribe to ENGINE_INITIALIZE_SIGNAL and return application initial state.

### Початковий стан

Завжди підписуйтесь на ENGINE_INITIALIZE_SIGNAL і повертайте програмі початковий стан.

### Engine start

Remember to start the engine when you're ready.

### Запуск двигуна

Не забудьте запустити двигун, коли будете готові.

```
const engine = createEngine()
engine.addSignalReducer(...)
engine.addSignalReducer(...)
engine.addSignalReducer(...)
engine.addSignalReducer(...)
engine.addSideEffect(...)
engine.addSideEffect(...)
engine.addSideEffect(...)

engine.start()
```

Механізм можна створити, викликавши `createEngine`.
Механізм використовує кілька сутностей, таких як сигнали, редуктори, побічні ефекти та стан.


```
const engine = createEngine()
engine.addSignalReducer(...)
engine.addSignalReducer(...)
engine.addSignalReducer(...)
engine.addSignalReducer(...)
engine.addSideEffect(...)
engine.addSideEffect(...)
engine.addSideEffect(...)

engine.start()
```







