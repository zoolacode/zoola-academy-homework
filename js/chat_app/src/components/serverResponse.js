import React, { useContext } from "react";
import { UserContext } from "./UserContext";

export function useHttpClient() {
  const { auth } = useContext(UserContext);

  return (
    url,
    { method = "GET", body = undefined } = {
      method: "GET",
      body: undefined,
    }
  ) => {
    return fetchJSON(url, {
      method,
      body,
      headers: { "auth-token": auth?.authToken },
    });
  };
}

export const fetchJSON = (url, { method, body, headers }) => {
  return fetch(url, {
    method: method,
    headers: {
      "auth-token": headers["auth-token"],
      "Content-Type": "application/json",
    },
    body: body,
  }).then((response) => response.json());
};
