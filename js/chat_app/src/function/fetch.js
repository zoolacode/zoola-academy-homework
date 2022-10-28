export const getData = async (URL, options = {}) => {
  return fetch(URL, options).then((response) => response.json());
};

export const fetchRequestJSON = (URL, method, token, data) => {
  if (method === "POST") {
    return getData(URL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "auth-token": token,
      },
      body: JSON.stringify(data),
    });
  } else if (method === "GET") {
    return getData(URL, {
      headers: {
        "Content-Type": "application/json",
        "auth-token": token,
      },
    });
  }
};
