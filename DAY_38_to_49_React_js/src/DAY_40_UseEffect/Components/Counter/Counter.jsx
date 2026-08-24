import { useState } from "react";
import { useEffect } from "react";
import "./Counter.css";

const Counter = () => {
  const [count, setCount] = useState(0);

  const decreaseBtn = () => {
    setCount((prev) => prev - 1);
  };

  const resetBtn = () => {
    setCount(0);
  };

  const increaseBtn = () => {
    setCount((prev) => prev + 1);
  };

  useEffect(() => {
    console.log("React is trying to change title to:", count);
    document.title = `Count: ${count}`;
  }, [count]);

  return (
    <div className="counterDiv">
      <h1>{count}</h1>
      <div className="buttons-list">
        <button onClick={decreaseBtn}>Decrease</button>
        <button onClick={resetBtn}>Reset</button>
        <button onClick={increaseBtn}>Increase</button>
      </div>
    </div>
  );
};

export default Counter;
