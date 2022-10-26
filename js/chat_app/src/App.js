import Login from "./components/Login";
import DashBoard from "./components/DashBoard";
import { useState, useEffect } from "react";
import { Navigate, Route, Routes, useNavigate } from "react-router-dom";
import { UserContext } from "./components/UserContext";
import { ProtectedRoute } from "./components/ProtectedRoute";
import ChatCreationButton from "./components/ChatCreationButton";

const mas = [
  {
    "id": "fhs8dhf9s8dhf9sd8hf9sd8hf",
    "username": "admin"
  },
  {
    "id": "1793529f-c203-49e2-a2c9-5377eb7fae0f",
    "username": "bob"
  },
  {
    "id": "6a492281-c21d-46e9-9141-cd0b1e577551",
    "username": "alina"
  },
  {
    "id": "b246a940-660b-4443-9336-9ddd185d2a0e",
    "username": "vasyok"
  },
  {
    "id": "bbb8e4af-d960-4b28-bed2-989ed515fc29",
    "username": "alison"
  }
]

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
          <Route
            path="/dashboard"
            element={
              <ProtectedRoute>
                
                <ChatCreationButton arrayOfUsers={mas} auth={auth} />
                <DashBoard />
              </ProtectedRoute>
            }
          />
          <Route path="/login" element={<Login />} />
        </Routes>
      </UserContext.Provider>
    </div>
  );
}

export default App;
