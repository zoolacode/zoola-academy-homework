import React from 'react'
import "./index.css"

export default function Score(props) {
  return (
    <div className='score' >
      {props.score}
    </div>
  )
}
