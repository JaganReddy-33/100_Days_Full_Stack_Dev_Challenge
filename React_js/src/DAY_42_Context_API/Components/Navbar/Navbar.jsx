const Navbar = ({ name, isLoggedIn, onAuthToggle }) => {
  return (
    <nav>
      <div className="logo">Day 42 - Context API</div>

      {isLoggedIn && <p>Welcome, {name} 👋</p>}

      <button onClick={onAuthToggle}>
        {isLoggedIn ? "Logout" : "Login"}
      </button>
    </nav>
  );
};

export default Navbar;