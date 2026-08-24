import "./Navbar.css";

const Navbar = ({ isLoggedIn, onAuthToggle }) => {
  return (
    <nav className="navbar">
      <div className="logo">MyDashboard</div>

      <ul className="nav-links">
        <li><a href="#home">Home</a></li>
        <li><a href="#profile">Profile</a></li>
        <li><a href="#skills">Skills</a></li>
        <li><a href="#admin">Admin</a></li>
      </ul>

      {isLoggedIn && (
        <span className="welcome-txt">
          Welcome back, Jagan! 👋
        </span>
      )}

      <button className="login-btn" onClick={onAuthToggle}>
        {isLoggedIn ? "Logout" : "Login"}
      </button>
    </nav>
  );
};

export default Navbar;