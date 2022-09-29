export function getData(options = {}) {
   return fetch('/api/chat', options).then((response) => response.json());
 }

export function updateData(messageData) {

  return fetch('/api/chat', {
      method: 'POST',
      headers: {
        'Content-type': 'application/json; charset=UTF-8',
      },
      body: JSON.stringify(messageData),
    })
  .then((response) => {
    response.json()
  });
}