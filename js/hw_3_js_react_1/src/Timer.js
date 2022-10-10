import React from 'react'
import "./index.css"

export default function Timer(props) {

    function prettyDisplay(seconds) {
        
        let min = Math.floor(seconds/60)
        let sec = seconds-min*60
        if (sec<10) return `0${min}:0${sec}`
        return `0${min}:${sec}`
    }

    return (
        <div className='timer'>
            {prettyDisplay(props.timer)}
        </div>
    )
}
