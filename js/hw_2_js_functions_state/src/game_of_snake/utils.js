export function pipe(...fns) {
  return (...args) => {
    const [first, ...rest] = fns;
    return rest.reduce((acc, fn) => {
      return fn(acc);
    }, first(...args));
  };
}

export function getRandomNumber(max) {
  return Math.floor(Math.random() * max);
}

export function stringifyCoordinates([x, y]) {
  return `${x}:${y}`;
}

export function parseStringCoordinates(xy) {
  return xy.split(":").map((i) => Number(i));
}

export function arrayOfLength(length, defaultValue) {
  return new Array(length).fill(defaultValue);
}

export function flattenSuperFood(superFood) {
  return Object.values(superFood)
    .map(({ location }) => location)
    .reduce((acc, location) => {
      return {
        ...acc,
        [location]: true,
      };
    }, {});
}

export function adjustTimeToScreen(num) {
  const str = String(num);
  if (str.length < 2) {
    return `0${str}`;
  }
  return str;
}
