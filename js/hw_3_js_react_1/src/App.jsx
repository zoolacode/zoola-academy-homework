import './App.css';
import { useContext, useEffect } from 'react';
import { getIsBonusDishNeeded } from './utils';
import { bonusDishLifeTime } from './game_constants';

import { GameScore } from './components/GameScore/GameScore';
import { Board } from './components/Board/Board';
import { GameTimer } from './components/GameTimer/GameTimer';
import { BonusDishTimer } from './components/BonusDishTimer/BonusDishTimer';
import { DispatchContext, SnakeContext } from './SnakeContext';

export function App() {
  const dispatch = useContext(DispatchContext);
  const state = useContext(SnakeContext);
  const second = 100;

  useEffect(() => {
    if (!state.gameOn) {
      return;
    }

    if (state.gameLost) {
      window.addEventListener('keydown', restart);

      dispatch({ type: 'gameOver' });

      return () => {
        window.removeEventListener('keydown', restart);
      };
    }

    dispatch({ type: 'moveSnake' });

    if (state.speedUp) {
      const timeoutId = setTimeout(() => {
        dispatch({ type: 'runGameTimer', timeFrame: second });
      }, 50);

      return () => {
        clearTimeout(timeoutId);
      };
    } else {
      const timeoutId = setTimeout(() => {
        dispatch({ type: 'runGameTimer', timeFrame: second });

        if (getIsBonusDishNeeded(state.gameTimer, bonusDishLifeTime)) {
          dispatch({ type: 'giveBonusDish' });
        }
      }, 100);

      return () => {
        clearTimeout(timeoutId);
      };
    }
  }, [state.gameTimer, state.gameOn]);

  useEffect(() => {
    window.addEventListener('keydown', changeSnakeDirection);

    return () => {
      window.removeEventListener('keydown', changeSnakeDirection);
    };
  }, [state.gameTimer, state.gameOn]);

  function changeSnakeDirection(event) {
    switch (event.code) {
      case 'ArrowRight':
        dispatch({ type: 'moveRight', oppositeDirection: 'moveLeft' });
        break;
      case 'ArrowLeft':
        dispatch({ type: 'moveLeft', oppositeDirection: 'moveRight' });
        break;
      case 'ArrowDown':
        dispatch({ type: 'moveDown', oppositeDirection: 'moveUp' });
        break;
      case 'ArrowUp':
        dispatch({ type: 'moveUp', oppositeDirection: 'moveDown' });
        break;
      case 'Space':
        dispatch({ type: 'pauseGame' });
        break;
      default:
        break;
    }
  }

  function restart(event) {
    if (event.code === 'Enter') {
      dispatch({ type: 'restartGame' });
    }
  }

  return (
    <div className={`${state.gameOn ? 'App' : 'App pause'}`}>
      <GameScore />
      <Board />
      <div className='game-timer-container'>
        <GameTimer />
        {state.bonusDish && <BonusDishTimer />}
      </div>
      {state.gameLost && (
        <div className='alert'>
          'Game has ended. Press "Enter" to start again'
        </div>
      )}
    </div>
  );
}
