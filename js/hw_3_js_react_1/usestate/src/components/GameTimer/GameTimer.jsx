import './GameTimer.css';
import { getMinSec, getTimeString, timerLimitMs } from '../../utils';

export function GameTimer({ gameTimer }) {
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
