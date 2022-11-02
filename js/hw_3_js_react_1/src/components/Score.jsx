import React from "react";

const Score = ({ score }) => {
    return <section className="score">
        <p>
            score:
            <span>{` ${score}`}</span>
        </p>
    </section>;
}

export default Score;
