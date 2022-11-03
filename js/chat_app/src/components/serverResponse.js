import React, { useContext } from "react";
import { UserContext } from "./UserContext";

export const fetchJSON = (
  url,
  { method = "GET", body = undefined, headers = {} }
) => {
  return fetch(url, {
    method: method,
    headers: {
      "auth-token": headers["auth-token"],
      "Content-Type": "application/json",
    },
    body: body,
  }).then((response) => response.json());
};
