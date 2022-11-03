import React, { useContext } from "react";

export const serverResponse = (url, header, method = "GET", body = null) => {
  switch (method) {
    case "POST":
      return fetch(url, {
        method: method,
        headers: {
          "auth-token": header["auth-token"],
          "Content-Type": "application/json",
        },
        body: body,
      }).then((response) => response.json());

    default:
      return fetch(url, {
        method: method,
        headers: {
          "auth-token": header["auth-token"],
          "Content-Type": "application/json",
        },
      }).then((response) => response.json());
  }
};
