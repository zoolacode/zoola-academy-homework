export function getData(options = {}) {
  return fetch('/api/chat', options).then((response) => response.json());
}

export function submitMessage(userName, message, time) {
  return getData({
    method: 'POST',
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
    body: JSON.stringify({
      user: userName,
      message,
      time,
    }),
  });
}
