import useLocalStorage from "../../hooks/useLocalStorage";
import "./UseLocalStorage.css";

const UseLocalStorage = () => {

    const [name, setName] = useLocalStorage(
        "username",
        ""
    );

    const handleClear = () => {
        setName("");
    };

    return (
        <div className="storage-card">

            <div className="storage-icon">💾</div>

            <p className="storage-label">CUSTOM HOOK</p>

            <h2>useLocalStorage</h2>

            <p className="storage-description">
                Persist React state in the browser using
                LocalStorage.
            </p>

            <div className="input-group">

                <label htmlFor="username">
                    Your Name
                </label>

                <input
                    id="username"
                    type="text"
                    placeholder="Enter your name..."
                    value={name}
                    onChange={(e) =>
                        setName(e.target.value)
                    }
                />

            </div>

            <div className="saved-value">

                <span>Stored Value</span>

                <strong>
                    {name || "No name entered"}
                </strong>

            </div>

            <button
                className="clear-btn"
                onClick={handleClear}
            >
                Clear Stored Name
            </button>

            <p className="storage-note">
                🔄 Your value remains after refreshing the page.
            </p>

        </div>
    );
};

export default UseLocalStorage;