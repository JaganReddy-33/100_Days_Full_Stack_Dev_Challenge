import Navbar from "./Components/Navbar/Navbar";
import Profile from "./Components/Profile/Profile";
import { UserProvider } from "./Context/UserContext";
import { ThemeContext, ThemeProvider } from "./Context/ThemeContext";
import ThemeToggle from "./Components/ThemeToggle/ThemeToggle";
import { useContext } from "react";



const Dashboard = () => {
  const { theme } = useContext(ThemeContext);

  return (
    <div
      style={{
        minHeight: "100vh",
        backgroundColor: theme === "dark" ? "#1a1a1a" : "#ffffff",
        color: theme === "dark" ? "#ffffff" : "#000000",
      }}
    >
      <Navbar />
      <ThemeToggle />
      <Profile />
    </div>
  );
};


const App = () => {
  return (
    <UserProvider>
      <ThemeProvider>
        <Dashboard />
      </ThemeProvider>
    </UserProvider>
  );
};

export default App;
