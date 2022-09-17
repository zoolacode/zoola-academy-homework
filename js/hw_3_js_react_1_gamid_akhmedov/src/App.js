import { useState } from 'react';
import './App.css';
import Board from './components/Board';

function App() {
  const [timeGone, setTimeGone] = useState(0)
  const [score, setScore] = useState(0)
  const [pause, setPause] = useState(false)


  return (
    <div className="App">
      <Board/>
    </div>
  );
}

export default App;
