import React from "react";

const GameTime = ({ gameTime }) => {
    return <section className="gameTime">
        <p>
            Game time:
            <span>{` ${gameTime}`}</span>
        </p>
    </section>;
}

export default GameTime;
