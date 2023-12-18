export function getCurrentDate() {
  const currentDay = getCurrentDay();
  const hour = getFormatedTime(getCurrentHour());
  const minutes = getFormatedTime(new Date().getMinutes());
  const timeConvention = new Date().getHours() >= 12 ? "PM" : "AM";

  return `${currentDay}, ${hour}:${minutes} ${timeConvention}`;
}

function getCurrentDay() {
  const day = new Date().getDay();
  const dayList = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

  return dayList[day];
}

function getCurrentHour() {
  const hour = new Date().getHours();

  if (hour >= 12) {
    return hour - 12;
  } else {
    return hour;
  }
}

function getFormatedTime(time) {
  return time.toString().padStart(2, "0");
}
