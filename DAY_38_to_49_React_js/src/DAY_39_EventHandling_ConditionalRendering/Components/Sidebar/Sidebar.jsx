import "./Sidebar.css";
import Counter from "../../../DAY_38_React_Basics/Components/Counter/Counter";

const Sidebar = ({isProfileVisible, isSkillsVisible, isAdmin, onToggleProfile, onToggleSkills, onToggleAdmin}) => {
  return (
    <div className="sidebar">
      <div className="quick-actions">
        <h2>Quick Actions</h2>
        <div className="btns">
          <button onClick={onToggleProfile}>{isProfileVisible ? "Hide Profile" : "Show Profile"}</button>
          <button onClick={onToggleSkills}>{isSkillsVisible ? "Hide Skills" : "Show Skills"}</button>
          <button onClick={onToggleAdmin}>{isAdmin ? "Hide Admin Panel" : "Show Admin Panel"}</button>
        </div>
      </div>
      <div className="counter">
        <Counter />
      </div>
    </div>
  );
};

export default Sidebar;
