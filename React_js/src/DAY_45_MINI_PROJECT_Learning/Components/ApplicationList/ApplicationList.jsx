import { IoLocationOutline, IoBriefcaseOutline, IoCreateOutline, IoTrashOutline } from 'react-icons/io5';
import './ApplicationList.css';
const ApplicationList = () => {
  const applications = [
    {
      id: 1,
      company: 'Infosys',
      logo: 'https://clearbit.com',
      role: 'Java Backend Developer',
      location: 'Bengaluru, India',
      type: 'Full Time',
      status: 'Applied',
      statusClass: 'status-applied',
      date: 'Aug 17, 2026',
      salary: '₹6 LPA'
    },
    {
      id: 2,
      company: 'TCS',
      logo: 'https://clearbit.com',
      role: 'Frontend Developer',
      location: 'Mumbai, India',
      type: 'Full Time',
      status: 'Interview',
      statusClass: 'status-interview',
      date: 'Aug 14, 2026',
      salary: '₹7 LPA'
    },
    {
      id: 3,
      company: 'Wipro',
      logo: 'https://clearbit.com',
      role: 'React Developer',
      location: 'Bengaluru, India',
      type: 'Full Time',
      status: 'Offer',
      statusClass: 'status-offer',
      date: 'Aug 10, 2026',
      salary: '₹8 LPA'
    },
    {
      id: 4,
      company: 'Accenture',
      logo: 'https://clearbit.com',
      role: 'Software Engineer',
      location: 'Pune, India',
      type: 'Full Time',
      status: 'Rejected',
      statusClass: 'status-rejected',
      date: 'Aug 05, 2026',
      salary: '₹5.5 LPA'
    },
    {
      id: 5,
      company: 'Cognizant',
      logo: 'https://clearbit.com',
      role: 'Backend Developer',
      location: 'Hyderabad, India',
      type: 'Full Time',
      status: 'Applied',
      statusClass: 'status-applied',
      date: 'Aug 02, 2026',
      salary: '₹6.5 LPA'
    }
  ];
  return (
    <div className="list-container">
      {applications.map((app) => (
        <div key={app.id} className="app-row">
          <div className="company-meta-col">
            <div className="company-logo-box">
              <img src={app.logo} alt={app.company} onError={(e) => { e.target.style.display = 'none'; }} />
              <span className="logo-fallback">{app.company[0]}</span>
            </div>
            <div className="role-details">
              <h3 className="company-name">{app.company}</h3>
              <h4 className="role-title">{app.role}</h4>
              <div className="meta-info-row">
                <div className="meta-item">
                  <IoLocationOutline className="meta-icon" />
                  <span>{app.location}</span>
                </div>
                <div className="meta-item">
                  <IoBriefcaseOutline className="meta-icon" />
                  <span>{app.type}</span>
                </div>
              </div>
            </div>
          </div>
          <div className="status-timeline-col">
            <span className={`status-badge ${app.statusClass}`}>{app.status}</span>
            <span className="action-date">{app.date}</span>
            <span className="salary-text">{app.salary}</span>
          </div>
          <div className="actions-col">
            <button className="action-btn edit-btn">
              <IoCreateOutline />
            </button>
            <button className="action-btn delete-btn">
              <IoTrashOutline />
            </button>
          </div>
        </div>
      ))}
    </div>
  );
};
export default ApplicationList;
