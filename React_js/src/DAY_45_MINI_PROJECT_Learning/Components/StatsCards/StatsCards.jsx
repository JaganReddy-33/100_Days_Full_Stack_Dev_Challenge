import { IoBriefcaseOutline, IoCalendarOutline, IoCheckmarkCircleOutline, IoCloseCircleOutline } from 'react-icons/io5';
import './StatsCards.css';
const StatsCards = () => {
  return (
    <div className="stats-container">
      <div className="stat-card">
        <div className="stat-icon-box applied">
          <IoBriefcaseOutline />
        </div>
        <div className="stat-info">
          <span className="stat-number">24</span>
          <span className="stat-label">Total Applied</span>
          <span className="stat-sub">All applications</span>
        </div>
      </div>
      <div className="stat-card">
        <div className="stat-icon-box interview">
          <IoCalendarOutline />
        </div>
        <div className="stat-info">
          <span className="stat-number">5</span>
          <span className="stat-label">Interview</span>
          <span className="stat-sub">In Progress</span>
        </div>
      </div>
      <div className="stat-card">
        <div className="stat-icon-box offer">
          <IoCheckmarkCircleOutline />
        </div>
        <div className="stat-info">
          <div className="stat-title-row">
            <span className="stat-number">2</span>
            <span className="stat-badge offer-badge">Congrats! 🎉</span>
          </div>
          <span className="stat-label">Offers</span>
        </div>
      </div>
      <div className="stat-card">
        <div className="stat-icon-box rejected">
          <IoCloseCircleOutline />
        </div>
        <div className="stat-info">
          <div className="stat-title-row">
            <span className="stat-number">5</span>
            <span className="stat-badge rejected-badge">Keep going! 💪</span>
          </div>
          <span className="stat-label">Rejected</span>
        </div>
      </div>
    </div>
  );
};
export default StatsCards;
