import './BonusDishTimer.css';
import { getMinSec, getTimeString } from '../../utils';
import { bonusDishLifeTime } from '../../game_constants';

export function BonusDishTimer({ gameTimer }) {
  const { min, sec } = getMinSec(
    bonusDishLifeTime - (gameTimer % bonusDishLifeTime) + 900
  );
  const timeStrBonusTimer = getTimeString(min, sec);

  return <div className='bonus-timer'>{timeStrBonusTimer}</div>;
}
