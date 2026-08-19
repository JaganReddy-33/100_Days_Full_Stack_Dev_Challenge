
import { IoAnalyticsOutline } from 'react-icons/io5';
import './InfoCard.css';
const InfoCard = () => {
  return (
    <div className="info-card-box">
      <div className="info-icon-wrapper">
        <IoAnalyticsOutline />
      </div>
      <h3 className="info-title">Keep tracking</h3>
      <p className="info-description">Consistency is key to finding your dream job. Update your progress daily.</p>
    </div>
  );
};
export default InfoCard;
