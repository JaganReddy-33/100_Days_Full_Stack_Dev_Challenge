import { useContext } from "react";

import { UserContext } from "../../Context/UserContext";
import { ThemeContext } from "../../Context/ThemeContext";

import "./Navbar.css";

const Navbar = () => {
  const { user, isLoggedIn, login, logout } =
    useContext(UserContext);

  const { theme, toggleTheme } =
    useContext(ThemeContext);

  const handleAuthToggle = () => {
    if (isLoggedIn) {
      logout();
    } else {
      login();
    }
  };

  return (
    <header className="day42-navbar">
      <div className="navbar-inner">

        <div className="navbar-brand">
          <div className="brand-icon">
            M
          </div>

          <div className="brand-name">
            MyDashboard
          </div>
        </div>

        <div className="navbar-actions">

          {isLoggedIn && (
            <div className="navbar-welcome">
              Welcome,{" "}
              <strong>{user.name}</strong>
              <span className="wave">👋</span>
            </div>
          )}

          <button
            type="button"
            className="theme-button"
            onClick={toggleTheme}
          >
            <span className="theme-icon">
              {theme === "light" ? "🌙" : "☀️"}
            </span>

            <span>
              {theme === "light" ? "Dark" : "Light"}
            </span>
          </button>

          <button
            type="button"
            className={`auth-button ${
              isLoggedIn ? "logout" : "login"
            }`}
            onClick={handleAuthToggle}
          >
            {isLoggedIn ? "Logout" : "Login"}
          </button>

        </div>
      </div>
    </header>
  );
};

export default Navbar;