import classNames from 'classnames';
import './Board.css';
import {
  meshSize,
  isSnakeDead,
  isSnakeShouldSpeedUp,
  isDishActive,
  isBonusDishActive,
} from '../../utils';

export function Board({
  snakeCoords,
  dish,
  bonusDish,
  gameLost,
  speedUp
}) {
  const meshSizeArray = [...Array(meshSize)].map((_, index) => index);

  return (
    <div className='mesh'>
      {meshSizeArray.map((mesh) => (
        <div
          className={classNames(
            'item',
            { 'snake-body': snakeCoords.includes(mesh) },
            { 'snake-dead': isSnakeDead(snakeCoords, mesh, gameLost) },
            { 'speed-up': isSnakeShouldSpeedUp(snakeCoords, mesh, speedUp) },
            { 'active-dish': isDishActive(dish, mesh) },
            { 'active-bonus-dish': isBonusDishActive(bonusDish, mesh) }
          )}
          key={mesh}
        ></div>
      ))}
    </div>
  );
}
