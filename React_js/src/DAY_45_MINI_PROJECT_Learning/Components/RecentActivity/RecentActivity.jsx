
import { IoCheckmarkCircle, IoCalendar, IoBriefcase, IoCloseCircle } from 'react-icons/io5';
import './RecentActivity.css';
const RecentActivity = () => {
  const activities = [
    {
      id: 1,
      type: 'offer',
      icon: <IoCheckmarkCircle />,
      text: 'Received an offer from Wipro for React Developer role.',
      time: '2 hours ago'
    },
    {
      id: 2,
      type: 'interview',
      icon: <IoCalendar />,
      text: 'Interview scheduled with TCS for Frontend Developer position.',
      time: '5 hours ago'
    },
    {
      id: 3,
      type: 'applied',
      icon: <IoBriefcase />,
      text: 'Applied to Infosys for Java Backend Developer position.',
      time: 'Yesterday'
    },
    {
      id: 4,
      type: 'rejected',
      icon: <IoCloseCircle />,
      text: 'Application status updated to Rejected by Accenture.',
      time: '2 days ago'
    }
  ];
  return (
    <div className="activity-card">
      <h3 className="activity-title">Recent Activity</h3>
      <div className="timeline-container">
        {activities.map((act) => (
          <div key={act.id} className="timeline-item">
            <div className={`activity-icon-wrapper ${act.type}`}>
              {act.icon}
            </div>
            <div className="activity-details">
              <p className="activity-text">{act.text}</p>
              <span className="activity-time">{act.time}</span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};
export default RecentActivity;
