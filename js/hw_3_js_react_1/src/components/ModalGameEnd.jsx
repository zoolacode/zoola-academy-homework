import React from 'react'

const ModalGameEnd = ({ gameIsEnd }) => {
    return (
        <>
            {gameIsEnd
                ?
                <div className='modalEnd'>
                    <p>Game has ended. Press "Enter" to start again</p>
                </div>
                : null
            }
        </>
    )
}

export default ModalGameEnd