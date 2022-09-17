import React from 'react'

const GameTimer = ({ timer }) => {
    let minutes = Math.floor(timer/ (1000 * 60));
    let seconds = Math.floor((timer / 1000) - (minutes * 60));

    function getFormatedTime (time) {
        return time.toString().padStart(2, '0')
    }

    return (
      <div className='timer'>
        {`${getFormatedTime(minutes)} : ${getFormatedTime(seconds)}`}
      </div>
    )
}

export default GameTimer