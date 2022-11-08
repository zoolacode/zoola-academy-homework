export const query = async (url, method, authToken, body = {}) => {
  const headers = {
    'content-type': 'application/json', 'Auth-Token': authToken
  };
  try {
    if (Object.keys(body).length) {
      const data = await fetch(url, {
        method,
        headers,
        body: JSON.stringify(body)
      });
      return data.json();
    }

    const data = await fetch(url, {
      method,
      headers
    });

    return data.json();
  } catch (error) {
    console.log(error);
  }
};
