const path = '/api/chat';

export function getMessages(options = {}) {
    return fetch(path).then(res => res.json())
}

export function sendMessage(userName, message, time) {
    return fetch(path, {
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