/* eslint-disable jsx-quotes */
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import LogIn from './components/LogIn';
import Header from './components/Header';

function App() {
  return (
    <div>
      <Router>
        <Routes>
          <Route path='/' element={<LogIn />} />
          <Route path='/chat' element={<Header />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
