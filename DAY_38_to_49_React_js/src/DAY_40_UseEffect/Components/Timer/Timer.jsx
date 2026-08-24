import { useEffect, useState } from "react";
import "./Timer.css";

const Timer = () => {
  const [currentTime, setCurrentTime] = useState(new Date().toLocaleTimeString());

  
  useEffect(() => {
    const timerInterval = setInterval(() => {
      setCurrentTime(new Date().toLocaleTimeString());
    }, 1000);

    return () => {
      clearInterval(timerInterval);
    };
  }, []);

  return (
    <div className="timer">
      <span className="timer-label">Current Time</span>
      <h3>{currentTime}</h3>
    </div>
  );
};

export default Timer;