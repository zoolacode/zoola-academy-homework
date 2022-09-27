import React from 'react'

const ModalGamePause = ({ gameIsPaused }) => {
    return (
        <>
            {gameIsPaused 
                ?
                <div className='modalPause'>
                    <p>Game has paused. Press "Space" to continue</p>
                </div>
                : null
            }
        </>
    )
}

export default ModalGamePause