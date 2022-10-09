import React from 'react'

const Restart = ({ restart, isLose }) => {
    if(isLose) {
        var onAlertEnter = (e) => {
            if (e.keyCode === 13) {
              restart()
              document.removeEventListener('keyup', onAlertEnter);
            }
        }
    }

    document.addEventListener('keyup', onAlertEnter);
  return (
    <div className='alert'>
        Game has ended. Press "Enter" to start again
    </div>
  )
}

export default Restart