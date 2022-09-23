export function getCurrentDate() {
  const currentDay = calculateDay();
  const hour = calculateHour();
  const minutes = calculateMinutes();
  const timeConvention = new Date().getHours() >= 12 ? 'PM' : 'AM';

  return `${currentDay}, ${hour}:${minutes} ${timeConvention}`;
}

function calculateDay() {
  const day = new Date().getDay();
  const dayList = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

  return dayList[day];
}

function calculateHour() {
  const hour = new Date().getHours();

  if (hour >= 12) {
    return hour - 12;
  } else {
    return hour;
  }
}

function calculateMinutes() {
  const minutes = new Date().getMinutes();

  if (minutes < 10) {
    return '0' + minutes;
  } else {
    return minutes;
  }
}

export function formatUserName(name) {
  const firstLetterToUpperCase = name[0].toUpperCase();

  return firstLetterToUpperCase + name.slice(1);
}
