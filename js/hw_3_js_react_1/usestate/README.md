# Setup

```
npm add yarn -g
yarn global add npx create-react-app

cd js/
npx create-react-app hw_3_js_react_1
cd hw_3_js_react_1
yarn start

```

2. Re-implement "Game of Snake" based on React infrastructure.

# Hints

1. Your main instruments should be `React.useState` and `React.useEffect`.

2. Remember that `React.useEffect` and `engine.addSideEffect` have their similarities:

- both can define re-run conditions (in `engine.addSideEffect` we used `onlyWhen`, but in `React.useEffect` we should its second argument)
- both can optionally return a clean-up function

3. Using `React.useState` is different from the approach we used with `engine.addSignalReducer` where you had to return new state from a pure function - with `React.useState` it is "easier" but at the same time it can be harder to maintain.

4. Move as much logic as you can in pure functions that live OUTSIDE of React components - to make your code more maintainable.

5. Decompose your application into several components - e.g. `Board`, `Snake`, `GameScore`, `GameTimer`.

6. Comply with Rules of Hooks https://reactjs.org/docs/hooks-rules.html

7. Don't use `React.useState` for every single variable - very often things can be derived from the existing state. E.g.

**Bad:**

```
const minDriverAge = 18

const [age, setAge] = React.useState(null)
const [ageDriving, setAgeDriving] = React.useState(null)

function onAgeSubmit(ageValue) {
  setAge(ageValue)
  setAgeDriving(ageValue - minDriverAge); // we don't need `ageDriving` to be in separate state
}

```

**Good:**

```
const minDriverAge = 18

const [age, setAge] = React.useState(null)
const ageDriving = age !== null ? age - minDriverAge : null

function onAgeSubmit(ageValue) {
  setAge(ageValue)
}

```

## Advanced

1. Try using `React.useReducer` to handle state changes in a more similar way to how `engine.addSignalReducer` worked.

