import React from 'react'
import "./index.css"

export default function PopUp(props) {
    const style = {
        position: "relative",
        top: "-230px",
        left: "33%",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        fontSize: "30px",
        width: "600px",
        height: "100px",
        background: "#00ff00",
      }

      if(!props.isStartGame && props.timer===20){
        return (
            <div style={style} >
                Press Enter to start Game {(props.score!==-1)?`, your score ${props.score}`:``}
            </div>
          )
      }

      if(props.isStartGame && props.isPauseGame){
        return (
          <div style={style} >
              Pause, press Space to continue
          </div>
        )
      }
}
