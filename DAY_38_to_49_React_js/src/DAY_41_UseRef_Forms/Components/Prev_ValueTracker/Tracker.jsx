import { useEffect, useRef, useState } from "react";
import "./Tracker.css";

const Tracker = () => {
  const [currentVal, setCurrentVal] = useState("");
  const [prevVal, setPrevVal] = useState("");

  const prevRef = useRef("");

  useEffect(() => {
    setPrevVal(prevRef.current);
    prevRef.current = currentVal;
  }, [currentVal]);

  return (
    <div className="tracker-card">
      <h2>Previous Value Tracker</h2>
      <p>Using useRef to remember the previous value.</p>

      <input
        type="text"
        value={currentVal}
        onChange={(e) => setCurrentVal(e.target.value)}
        placeholder="Type something..."
      />

      <div className="tracker-values">
        <div className="value-box current">
          <span>Current Value</span>
          <strong>{currentVal || "—"}</strong>
        </div>

        <div className="value-box previous">
          <span>Previous Value</span>
          <strong>{prevVal || "—"}</strong>
        </div>
      </div>
    </div>
  );
};

export default Tracker;