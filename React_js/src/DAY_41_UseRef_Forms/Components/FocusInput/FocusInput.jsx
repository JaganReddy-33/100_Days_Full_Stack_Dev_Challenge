import { useRef } from "react";
import "./FocusInput.css";

const FocusInput = () => {
  const inputRef = useRef(null);

  const handleFocus = () => {
    inputRef.current.focus();
  };

  return (
    <div className="focus-card">
      <h2>Focus Input</h2>
      <p>useRef can directly access a DOM element.</p>

      <div className="focus-controls">
        <input
          ref={inputRef}
          type="text"
          placeholder="Enter your name..."
        />

        <button type="button" onClick={handleFocus}>
          Focus
        </button>
      </div>
    </div>
  );
};

export default FocusInput;