import { IoHome, IoSettingsOutline, IoCheckboxOutline } from 'react-icons/io5';
import { LuNotepadText } from "react-icons/lu";
import { IoMdAddCircleOutline } from "react-icons/io";
import { VscGraph } from "react-icons/vsc";
import './Sidebar.css';
import { useState } from 'react';
const Sidebar = () => {


  const [activeItem, setActiveItem] = useState("dashboard");

  const navItem = [
    {id: "dashboard", label:"Dashboard", icon: IoHome, path: "/"},
    {id: "applications", label: "Applications", icon: LuNotepadText, path:"/applications"},
    {id: "add-application", label: "Add Application", icon: IoMdAddCircleOutline, path:"/add-application"},
    {id: "statistics", label: "Statistics", icon: VscGraph, path: "/statistics" },
    {id: "settings", label: "Settings", icon: IoSettingsOutline, path: "/settings"}
  ];

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
          {navItem.map((item)=>{
            const IconComponent = item.icon;
            return (
            <a key={item.id}
              className={`nav-item ${activeItem === item.id ? "active" : ""}`} onClick={()=>setActiveItem(item.id)}>
              <IconComponent className="nav-icon" /> 
              <span>{item.label}</span>
          </a>
            );
          })}
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
