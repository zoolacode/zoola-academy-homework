import { Login } from "./components/Login";
import { DashBoard } from "./components/DashBoard";
import { useState, useEffect, useContext } from "react";
import { Navigate, Route, Routes, useNavigate } from "react-router-dom";
import { UserContext } from "./components/UserContext";
import { ThemeContext } from "./components/ThemeContext";
import { ProtectedRoute } from "./components/ProtectedRoute";

export const App = () => {
  const { setDarkMode, setChecked } = useContext(ThemeContext);
  const session = JSON.parse(sessionStorage.getItem("user-info"));
  const [auth, setAuth] = useState(session);
  const navigate = useNavigate();

  useEffect(() => {
    if (JSON.parse(sessionStorage.getItem("isChecked"))) {
      setChecked(JSON.parse(sessionStorage.getItem("isChecked")));
    }
  }, []);

  useEffect(() => {
    if (JSON.parse(sessionStorage.getItem("darkMode"))) {
      setDarkMode(JSON.parse(sessionStorage.getItem("darkMode")));
    }
  }, []);

  useEffect(() => {
    const auth = JSON.parse(sessionStorage.getItem("user-info"));
    setAuth(auth);
    if (auth !== null) {
      navigate("/dashboard", { replace: true });
    }
  }, []);

  return (
    <div>
      <UserContext.Provider value={{ auth, setAuth }}>
        <Routes>
          <Route
            path="/"
            element={
              <Navigate to={auth ? "/dashboard" : "/login"} replace={true} />
            }
          />
          <Route
            path="/dashboard"
            element={
              <ProtectedRoute>
                <DashBoard />
              </ProtectedRoute>
            }
          />
          <Route path="/login" element={<Login />} />
        </Routes>
      </UserContext.Provider>
    </div>
  );
};
