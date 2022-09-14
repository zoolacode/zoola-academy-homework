import './GameScore.css';

export function GameScore({ currentScore }) {
  return <div className='score'>{currentScore}</div>;
}
