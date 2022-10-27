import {getCurrentDate} from '../utils/date.js'

export const getChatHistory = ()=>{
    return fetch('/api/chat').then(res=>res.json()).then(res=>res.reverse())
}

export const sendMessage = (data)=>{
    data.date = getCurrentDate()
    fetch('/api/chat', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    })
      .then(response => response.json())
      .catch(error => {
        console.error('Happened an error: ', error);
      });
}