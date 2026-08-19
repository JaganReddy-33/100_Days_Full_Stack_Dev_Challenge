import { IoBriefcaseOutline, IoCalendarOutline, IoCheckmarkCircleOutline, IoCloseCircleOutline } from 'react-icons/io5';
import './StatsCards.css';
const StatsCards = () => {
  return (
    <div className="stats-container">
      <div className="stat-card">
        <div className="stat-card-inner">
          <div className="stat-info">
            <span className="stat-label">Total Applied</span>
            <span className="stat-number">24</span>
            <span className="stat-sub">All applications</span>
          </div>
          <div className="stat-icon-box applied">
            <IoBriefcaseOutline />
          </div>
        </div>
      </div>
      <div className="stat-card">
        <div className="stat-card-inner">
          <div className="stat-info">
            <span className="stat-label">Interview</span>
            <span className="stat-number">5</span>
            <span className="stat-sub">In Progress</span>
          </div>
          <div className="stat-icon-box interview">
            <IoCalendarOutline />
          </div>
        </div>
      </div>
      <div className="stat-card">
        <div className="stat-card-inner">
          <div className="stat-info">
            <span className="stat-label">Offers</span>
            <div className="stat-number-row">
              <span className="stat-number">2</span>
              <span className="stat-badge offer-badge">Congrats! 🎉</span>
            </div>
            <span className="stat-sub">Completed</span>
          </div>
          <div className="stat-icon-box offer">
            <IoCheckmarkCircleOutline />
          </div>
        </div>
      </div>
      <div className="stat-card">
        <div className="stat-card-inner">
          <div className="stat-info">
            <span className="stat-label">Rejected</span>
            <div className="stat-number-row">
              <span className="stat-number">5</span>
              <span className="stat-badge rejected-badge">Keep going! 💪</span>
            </div>
            <span className="stat-sub">Closed files</span>
          </div>
          <div className="stat-icon-box rejected">
            <IoCloseCircleOutline />
          </div>
        </div>
      </div>
    </div>
  );
};
export default StatsCards;
