import React, { useContext } from "react";
import { Navigate } from "react-router-dom";
import { UserContext } from "./UserContext";

export const ProtectedRoute = ({ children }) => {
  const { auth } = useContext(UserContext);
  if (!auth) {
    return <Navigate to="/login" />;
  }
  return children;
};
