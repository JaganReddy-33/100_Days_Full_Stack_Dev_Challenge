import { useState } from "react";
import "../index.css";
import Navbar from "./Components/Navbar/Navbar";
import Sidebar from "./Components/Sidebar/Sidebar";
import UserProfile from "./Components/UserProfile/UserProfile";
import Skills from "./Components/Skills/Skills";
import AdminPanel from "./Components/AdminPanel/AdminPanel";

const App = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [isProfileVisible, setIsProfileVisible] = useState(true);
  const [isSkillsVisible, setIsSkillsVisible] = useState(true);
  const [isAdmin, setIsAdmin] = useState(true);

  return (
    <>
      <Navbar
        isLoggedIn={isLoggedIn}
        onAuthToggle={() => setIsLoggedIn(!isLoggedIn)}
      />

      {isLoggedIn ? (
        <div className="dashboard">
          <aside className="sidebar-column">
            <Sidebar
              isProfileVisible={isProfileVisible}
              isSkillsVisible={isSkillsVisible}
              isAdmin={isAdmin}
              onToggleProfile={() =>
                setIsProfileVisible(!isProfileVisible)
              }
              onToggleSkills={() =>
                setIsSkillsVisible(!isSkillsVisible)
              }
              onToggleAdmin={() => setIsAdmin(!isAdmin)}
            />
          </aside>

          <main className="main-column">
            {isProfileVisible && <UserProfile />}
            {isSkillsVisible && <Skills />}
            {isAdmin && <AdminPanel />}
          </main>
        </div>
      ) : (
        <main className="login-message">
          <h2>
            Welcome to MyDashboard. Please log in above to unlock your
            workspace screens.
          </h2>
        </main>
      )}
    </>
  );
};

export default App;