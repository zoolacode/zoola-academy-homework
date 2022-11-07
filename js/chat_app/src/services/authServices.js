const login = async ({ username, password }) => {
  const response = await fetch('/api/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      password,
      username
    })
  });
  if (response.status === 401) {
    throw Error('Bad req');
  }
  return response;
};

export default login;
