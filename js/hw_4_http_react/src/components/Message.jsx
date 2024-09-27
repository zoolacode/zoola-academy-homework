import React from 'react'

const Message = ({ userName, message, date }) => {
    return (
        <div className='messageWrapper'>
            <span className='messageInfo'>
                {`[${userName} (${date})]`}
            </span>
            <span>{`: ${message}`}</span>
        </div>
    )
}

export default Message


// [Bob (Tue, 8:40 PM)] Hi all