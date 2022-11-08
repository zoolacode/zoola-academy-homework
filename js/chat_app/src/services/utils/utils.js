export const query = async (url, method, authToken, body = {
}) => {
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

      const response = await data.json();

      return response;
    }
    if (Object.keys(body).length) {
      const data = await fetch(url, {
        method,
        headers: {
          'content-type': 'application/json'
        },
        body: JSON.stringify(body)
      });

      const response = await data.json();

      return response;
    }

    const data = await fetch(url, {
      method,
      headers: {
        'content-type': 'application/json',
        'Auth-Token': authToken
      }
    });

    const response = await data.json();

    return response;
  } catch (error) {
    console.log(error);
  }
};

export const queryAuth = async (url, method, body = {
}) => {
  try {
    if (Object.keys(body).length) {
      const data = await fetch(url, {
        method,
        headers: {
          'content-type': 'application/json'
        },
        body: JSON.stringify(body)
      });

      const response = await data.json();

      return response;
    }
  } catch (error) {
    console.log(error);
  }
};
