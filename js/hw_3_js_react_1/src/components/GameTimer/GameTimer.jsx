import './GameTimer.css';
import { getMinSec, getTimeString, timerLimitMs } from '../../utils';
import { useContext } from 'react';
import { SnakeContext } from '../../SnakeContext';

export function GameTimer() {
  const { gameTimer } = useContext(SnakeContext);
  const { min, sec } = getMinSec(timerLimitMs - gameTimer + 900);
  const timeStrTimer = getTimeString(min, sec);
  const timerNegativeValue = 110000;

  return (
    <>
      <div
        className={`${
          gameTimer > timerNegativeValue
            ? 'timer timer-negative'
            : 'timer timer-positive'
        }`}
      >
        {timeStrTimer}
      </div>
    </>
  );
}
