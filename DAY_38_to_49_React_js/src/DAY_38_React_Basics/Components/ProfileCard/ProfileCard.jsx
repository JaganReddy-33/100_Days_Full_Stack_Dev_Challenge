import './ProfileCard.css';

const ProfileCard = ({ user }) => {
  return (
    <div className="profile-card">
      <img 
        src={user.profileImg} 
        alt="Profile" 
        className="profile-img"
      />
      
      <h2 className="profile-name">
        {user.name}
      </h2>

      <p className="profile-role">
        {user.role}
      </p>
      
      <p className="profile-location">
        📍 {user.location}
      </p>
      
      <div className="skills-section">
        <div className="skills-container">
          {user.skills.map((skill, index) => (
            <span key={index} className="skill-badge">
              {skill}
            </span>
          ))}
        </div>
      </div>
      
      <p className="github-section">
        <strong>GitHub: </strong>
        <a 
          href={user.GitHub} 
          target="_blank" 
          rel="noopener noreferrer"
          className="github-link"
        >
          View Profile
        </a>
      </p>
    </div>
  );
};

export default ProfileCard;
