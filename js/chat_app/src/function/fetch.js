

export const fetchRequestJSON = ({url, method = "GET", authToken, data} = {}) => {

    const authtoken = {"auth-token": authToken};
    const headers =  {
      "Content-Type": "application/json"
    };

    return fetch(url, {
        method,
        headers: authToken ? {...headers, ...authtoken} : headers,
        body: data ? JSON.stringify(data) : undefined
      }
    ).then((response) => response.json())
    .catch(err => {
      console.log(err)
    });
};
