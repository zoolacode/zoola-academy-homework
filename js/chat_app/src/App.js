/* eslint-disable jsx-quotes */
import React from 'react';
import { useSelector } from 'react-redux';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LogIn from './components/LogIn';
import LogOut from './components/LogOut';
import authSelectors from './redux/auth/authSelector';

function App() {
  const isLogin = useSelector(authSelectors.getLogin);
  return (
    <div>
      <Router>
        <Routes>
          <Route path='/' element={<LogIn />} />
          <Route path='/chat' element={<LogOut />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
