import './GameScore.css';
import { useContext } from 'react';
import { SnakeContext } from '../../SnakeContext';

export function GameScore() {
  const { currentScore } = useContext(SnakeContext);
  return <div className='score'>{currentScore}</div>;
}
