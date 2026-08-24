import useCounter from "../../hooks/useCounter";
import "./UseCounter.css";

const UseCounter = () => {

    const [
        count,
        increment,
        decrement,
        reset
    ] = useCounter(10);

    return (
        <div className="counter-card">

            <div className="counter-icon">🔢</div>

            <p className="counter-label">CUSTOM HOOK</p>

            <h2>useCounter</h2>

            <p className="counter-description">
                Reusable numeric state management with increment,
                decrement and reset actions.
            </p>

            <div className="count-display">
                {count}
            </div>

            <div className="counter-actions">

                <button
                    className="counter-btn decrement"
                    onClick={decrement}
                >
                    −
                </button>

                <button
                    className="reset-btn"
                    onClick={reset}
                >
                    Reset
                </button>

                <button
                    className="counter-btn increment"
                    onClick={increment}
                >
                    +
                </button>

            </div>

        </div>
    );
};

export default UseCounter;