import { IoHome, IoSettingsOutline, IoCheckboxOutline } from 'react-icons/io5';
import { LuNotepadText } from "react-icons/lu";
import { IoMdAddCircleOutline } from "react-icons/io";
import { VscGraph } from "react-icons/vsc";
import './Sidebar.css';
const Sidebar = () => {
  return (
    <aside className="sidebar-container">
      <div className="sidebar-top">
        <div className="sidebar-brand">
          <div className="brand-icon-wrapper">
            <LuNotepadText className="brand-icon" />
          </div>
          <h1 className="brand-title">Job Tracker</h1>
        </div>
        <nav className="sidebar-nav">
          <a href="#" className="nav-item">
            <IoHome className="nav-icon" /> 
            <span>Dashboard</span>
          </a>
          <a href="#" className="nav-item">
            <LuNotepadText className="nav-icon" /> 
            <span>Applications</span>
          </a>
          <a href="#" className="nav-item">
            <IoMdAddCircleOutline className="nav-icon" /> 
            <span>Add Application</span>
          </a>
          <a href="#" className="nav-item">
            <VscGraph className="nav-icon" /> 
            <span>Statistics</span>
          </a>
          <a href="#" className="nav-item">
            <IoSettingsOutline className="nav-icon" /> 
            <span>Settings</span>
          </a>
        </nav>
      </div>
      <div className="sidebar-premium-card">
        <div className="premium-icon-box">
          <IoCheckboxOutline className="premium-icon" />
        </div>
        <h3 className="premium-title">Stay Organized</h3>
        <p className="premium-description">Track your applications and never miss an opportunity.</p>
        <button className="premium-button">Go Premium</button>
      </div>
    </aside>
  );
};
export default Sidebar;
