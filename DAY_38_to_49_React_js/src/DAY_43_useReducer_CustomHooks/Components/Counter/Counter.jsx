import { useReducer } from "react";
import "./Counter.css";

const initialState = 0;

function reducer(state, action) {
    switch (action.type) {
        case "INCREMENT":
            return state + action.payload;

        case "DECREMENT":
            return state - action.payload;

        case "RESET":
            return initialState;

        default:
            return state;
    }
}

const Counter = () => {
    const [count, dispatch] = useReducer(reducer, initialState);

    return (
        <div className="counter-page">
            <div className="counter-card">

                <span className="counter-badge">
                    useReducer Assessment 1 & 2
                </span>

                <h1>Reducer Counter</h1>

                <p className="counter-description">
                    Practice state management using actions and payloads.
                </p>

                <div className="counter-display">
                    <span>Current Count</span>
                    <h2>{count}</h2>
                </div>

                <div className="counter-actions">

                    <button
                        className="counter-btn decrease"
                        onClick={() =>
                            dispatch({
                                type: "DECREMENT",
                                payload: 5
                            })
                        }
                    >
                        −5
                    </button>

                    <button
                        className="counter-btn reset"
                        onClick={() =>
                            dispatch({
                                type: "RESET"
                            })
                        }
                    >
                        Reset
                    </button>

                    <button
                        className="counter-btn increase"
                        onClick={() =>
                            dispatch({
                                type: "INCREMENT",
                                payload: 5
                            })
                        }
                    >
                        +5
                    </button>

                </div>

            </div>
        </div>
    );
};

export default Counter;