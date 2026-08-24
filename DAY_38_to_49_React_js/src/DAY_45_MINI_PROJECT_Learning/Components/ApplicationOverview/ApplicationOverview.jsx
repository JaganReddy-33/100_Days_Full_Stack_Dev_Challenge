
import { useEffect, useRef } from 'react';
import './ApplicationOverview.css';
const ApplicationOverview = () => {
  const canvasRef = useRef(null);
  const data = [
    { label: 'Applied', value: 24, color: '#6366f1' },
    { label: 'Interview', value: 5, color: '#f97316' },
    { label: 'Offers', value: 2, color: '#22c55e' },
    { label: 'Rejected', value: 5, color: '#ef4444' }
  ];
  const total = data.reduce((sum, item) => sum + item.value, 0);
  useEffect(() => {
    const canvas = canvasRef.current;
    if (!canvas) return;
    const ctx = canvas.getContext('2d');
    const dpr = window.devicePixelRatio || 1;
    canvas.width = 160 * dpr;
    canvas.height = 160 * dpr;
    canvas.style.width = '160px';
    canvas.style.height = '160px';
    ctx.scale(dpr, dpr);
    const centerX = 80;
    const centerY = 80;
    const radius = 65;
    const lineWidth = 16;
    ctx.clearRect(0, 0, 160, 160);
    ctx.beginPath();
    ctx.arc(centerX, centerY, radius, 0, 2 * Math.PI);
    ctx.lineWidth = lineWidth;
    ctx.strokeStyle = '#f3f4f6';
    ctx.stroke();
    let startAngle = -Math.PI / 2;
    data.forEach((item) => {
      const sliceAngle = (item.value / total) * (2 * Math.PI);
      ctx.beginPath();
      ctx.arc(centerX, centerY, radius, startAngle, startAngle + sliceAngle);
      ctx.lineWidth = lineWidth;
      ctx.strokeStyle = item.color;
      ctx.lineCap = 'round';
      ctx.stroke();
      startAngle += sliceAngle;
    });
  }, [total]);
  return (
    <div className="overview-card">
      <h3 className="overview-title">Application Overview</h3>
      <div className="chart-wrapper">
        <canvas ref={canvasRef}></canvas>
        <div className="chart-center-text">
          <span className="total-count">{total}</span>
          <span className="total-label">Total</span>
        </div>
      </div>
      <div className="legend-grid">
        {data.map((item, idx) => (
          <div key={idx} className="legend-item">
            <div className="legend-marker-row">
              <span className="legend-dot" style={{ backgroundColor: item.color }}></span>
              <span className="legend-label">{item.label}</span>
            </div>
            <span className="legend-value">{item.value}</span>
          </div>
        ))}
      </div>
    </div>
  );
};
export default ApplicationOverview;
