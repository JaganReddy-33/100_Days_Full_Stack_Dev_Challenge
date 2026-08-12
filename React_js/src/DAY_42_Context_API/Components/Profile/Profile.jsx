import { useContext } from "react";

import { UserContext } from "../../Context/UserContext";

import "./Profile.css";

const Profile = () => {
  const { user, isLoggedIn } = useContext(UserContext);


  if (!isLoggedIn) {
    return (
      <div className="profile-card profile-locked">

        <div className="locked-icon">
          🔐
        </div>

        <h2>Profile Locked</h2>

        <p>
          Please login to view your profile information.
        </p>

      </div>
    );
  }


  return (
    <div className="profile-card">

      <div className="profile-header">

        <div className="profile-avatar">
          {user.name.charAt(0).toUpperCase()}
        </div>

        <div className="profile-title">

          <p className="profile-label">
            PROFILE INFORMATION
          </p>

          <h2>{user.name}</h2>

          <p className="profile-role">
            {user.role}
          </p>

        </div>

      </div>

      <div className="profile-details">

        <div className="profile-detail">

          <div className="detail-icon">
            👤
          </div>

          <div>
            <span>NAME</span>
            <strong>{user.name}</strong>
          </div>

        </div>


        <div className="profile-detail">

          <div className="detail-icon">
            💼
          </div>

          <div>
            <span>ROLE</span>
            <strong>{user.role}</strong>
          </div>

        </div>


        <div className="profile-detail">

          <div className="detail-icon">
            📍
          </div>

          <div>
            <span>LOCATION</span>
            <strong>{user.location}</strong>
          </div>

        </div>

      </div>

    </div>
  );
};

export default Profile;