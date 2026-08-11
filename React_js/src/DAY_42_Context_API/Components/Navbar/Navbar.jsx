import { useContext } from "react";
import { UserContext } from './../../Context/UserContext';


const Navbar = () => {

  const {user, isLoggedIn, login, logout} = useContext(UserContext);

  const onAuthToggle = () => {
    if(isLoggedIn){
      logout();
    } else {
      login();
    }
  };

  return (
    <nav>
      <div className="logo">Day 42 - Context API</div>

      {isLoggedIn && <p>Welcome, {user.name} 👋</p>}

      <button onClick={onAuthToggle}>
        {isLoggedIn ? "Logout" : "Login"}
      </button>
    </nav>
  );
};

export default Navbar;