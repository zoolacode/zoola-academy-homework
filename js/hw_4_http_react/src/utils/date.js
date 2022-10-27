export function getCurrentDate() {
    const weekdays = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
    const hour = new Date().getHours();
    const minutes = minutesView();
    const weekday = weekdays[new Date().getDay()]

    return `${weekday}, ${hour}:${minutes}`;
  }
 const minutesView = ()=>{
    const minutes = new Date().getMinutes();
    if (('' + minutes).split('').length===1){
        return `0${minutes}`
    }else{
        return minutes
    }
 }