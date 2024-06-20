export function addNewUser(userName, userMessage) {
  if (userName.length === 0 || userMessage.length === 0) {
    return;
  }

  const currentDate = new Date();
  const data = {
    user: userName,
    message: userMessage,
    date: currentDate.toLocaleTimeString('en-US'),
  };

  fetch('/api/chat', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  })
    .then(response => response.json())
    .catch(error => {
      console.error('error', error);
    });
}
