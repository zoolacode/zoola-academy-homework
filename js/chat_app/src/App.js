import Login from "./components/Login";
import DashBoard from "./components/DashBoard";
import { useState } from "react";
import {
  BrowserRouter as Router,
  Navigate,
  Route,
  Routes,
} from "react-router-dom";
import { UserContext } from "./components/UserContext";

function App() {
  const session = JSON.parse(sessionStorage.getItem("user-info"));
  const [auth, setAuth] = useState(session);

  return (
    <div>
      <UserContext.Provider value={{ auth, setAuth }}>
        <Router>
          <Routes>
            <Route
              path="/"
              element={
                <Navigate to={auth ? "/dashboard" : "login"} replace={true} />
              }
            />
            <Route path="/login" element={<Login />} />
            <Route path="/dashboard" element={<DashBoard />} />
          </Routes>
        </Router>
      </UserContext.Provider>
    </div>
  );
}

export default App;
