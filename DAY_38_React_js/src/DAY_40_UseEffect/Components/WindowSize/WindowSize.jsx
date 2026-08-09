import { useEffect, useState } from "react";
import "./WindowSize.css";

const WindowSize = () => {
  const [width, setWidth] = useState(window.innerWidth);
  const [height, setHeight] = useState(window.innerHeight);

  const handleSize = () => {
    setWidth(window.innerWidth);
    setHeight(window.innerHeight);
  };

  useEffect(() => {
    window.addEventListener("resize", handleSize);

    return () => {
      window.removeEventListener("resize", handleSize);
    };
  }, []);

  return (
    <div className="window-size">
      <h2>Window Size</h2>

      <div className="size-details">
        <div className="size-card">
          <span>Width</span>
          <strong>{width}px</strong>
        </div>

        <div className="size-card">
          <span>Height</span>
          <strong>{height}px</strong>
        </div>
      </div>
    </div>
  );
};

export default WindowSize;