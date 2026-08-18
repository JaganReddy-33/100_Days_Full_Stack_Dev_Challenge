import { MdOutlineLightMode } from "react-icons/md";
import { CgProfile } from "react-icons/cg";
import './Header.css';
const Header = () => {
  return (
    <header className="header-container">
      <div className="header-left">
        <h1 className="header-title">Dashboard</h1>
        <p className="header-subtitle">Track and manage your job applications</p>
      </div>
      <div className="header-right">
        <button className="add-app-btn">+ Add Application</button>
        <button className="icon-btn">
          <MdOutlineLightMode className="header-icon" />
        </button>
        <div className="avatar-wrapper">
          <CgProfile className="avatar-icon" />
        </div>
      </div>
    </header>
  );
};
export default Header;
