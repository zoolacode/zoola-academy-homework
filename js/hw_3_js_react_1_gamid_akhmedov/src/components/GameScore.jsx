import React from 'react'

const GameScore = ({ score }) => {
  return (
    <div className='score'>
        <span className='score-value'>
            {score}
        </span>
    </div>
  )
}

export default GameScore