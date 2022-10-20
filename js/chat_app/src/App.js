import Login from "./components/Login";
import DashBoard from "./components/DashBoard";
import { useState, useEffect } from "react";
import { Navigate, Route, Routes, useNavigate } from "react-router-dom";
import { UserContext } from "./components/UserContext";

function App() {
  const session = JSON.parse(sessionStorage.getItem("user-info"));
  const [auth, setAuth] = useState(session);
  const navigate = useNavigate();

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
          <Route path="/login" element={<Login />} />
          <Route path="/dashboard" element={<DashBoard />} />
        </Routes>
      </UserContext.Provider>
    </div>
  );
}

export default App;
