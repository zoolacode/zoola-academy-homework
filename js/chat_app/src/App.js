import { Login } from "./components/Login";
import { DashBoard } from "./components/DashBoard";
import { useState, useEffect, useContext } from "react";
import { Navigate, Route, Routes, useNavigate } from "react-router-dom";
import { UserContext } from "./components/UserContext";
import { ThemeContext } from "./components/ThemeContext";
import { ProtectedRoute } from "./components/ProtectedRoute";
import { set, get } from "./components/themeStorage.ts";

export const App = () => {
  const { setDarkMode, darkMode } = useContext(ThemeContext);
  const session = get("user-info");
  const [auth, setAuth] = useState(session);
  const navigate = useNavigate();

  useEffect(() => {
    set("darkMode", darkMode);
  }, [darkMode]);

  useEffect(() => {
    const storage = get("darkMode");
    if (storage) {
      setDarkMode(get("darkMode"));
    }
  }, []);

  useEffect(() => {
    const auth = get("user-info");
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