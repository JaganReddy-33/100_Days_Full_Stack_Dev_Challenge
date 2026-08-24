import useToggle from "../../hooks/useToggle";
import "./UseToggle.css";

const UseToggle = () => {

    const [value, toggle, reset] = useToggle(false);

    return (
        <div className="hook-card toggle-card">

            <div className="hook-icon">🔄</div>

            <p className="hook-label">CUSTOM HOOK</p>

            <h2>useToggle</h2>

            <p className="hook-description">
                Reusable boolean state management using a Custom Hook.
            </p>

            <div className={`status-box ${value ? "active" : ""}`}>
                <span className="status-dot"></span>
                <span>
                    Status: <strong>{value ? "ON" : "OFF"}</strong>
                </span>
            </div>

            <div className="hook-actions">
                <button
                    className="primary-btn"
                    onClick={toggle}
                >
                    Toggle
                </button>

                <button
                    className="secondary-btn"
                    onClick={reset}
                >
                    Reset
                </button>
            </div>

        </div>
    );
};

export default UseToggle;