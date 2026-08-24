import "./UserProfile.css";
import profile_img from "../../../assets/profile-photo.jpeg";

const UserProfile = () => {
  return (
    <div className="user-profile">
      <h2>Profile Information</h2>
      <div className="user">
        <img src={profile_img} alt="profile" />
        <div className="user-details">
          <h3>Jaganmohan Reddy</h3>
          <p>Full Stack Developer</p>
          <p>Coimbatore, TamilNadu</p>
        </div>
      </div>
    </div>
  );
};

export default UserProfile;
