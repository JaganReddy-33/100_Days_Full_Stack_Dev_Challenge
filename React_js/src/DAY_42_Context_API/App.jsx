import { useState } from "react";
import Navbar from "./Components/Navbar/Navbar";
import Profile from "./Components/Profile/Profile";

const App = ({ user }) => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleAuthToggle = () => {
    setIsLoggedIn((prev) => !prev);
  };

  return (
    <div>
      <Navbar
        name={user.name}
        isLoggedIn={isLoggedIn}
        onAuthToggle={handleAuthToggle}
      />

      {isLoggedIn && (
        <Profile
          name={user.name}
          role={user.role}
          location={user.location}
        />
      )}
    </div>
  );
};

export default App;