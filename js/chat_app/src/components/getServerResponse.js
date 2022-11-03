import React, { useContext } from "react";

export const getServerResponse = (
  url,
  header,
  method = "GET",
  body = undefined
) => {
  return fetch(url, {
    method: method,
    headers: {
      "auth-token": header["auth-token"],
      "Content-Type": "application/json",
    },
    body: body,
  }).then((response) => response.json());
};
s;
