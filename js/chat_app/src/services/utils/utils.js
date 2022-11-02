export const query = async (url, method, authToken, body = {}) => {
  try {
    if (Object.keys(body).length) {
      const data = await fetch(url, {
        method,
        headers: {
          'content-type': 'application/json',
          'Auth-Token': authToken
        },
        body: JSON.stringify(body)
      });
      return data.json();
    }

    const data = await fetch(url, {
      method,
      headers: {
        'content-type': 'application/json',
        'Auth-Token': authToken
      }
    });

    return data.json();
  } catch (error) {
    console.log(error);
  }
};
