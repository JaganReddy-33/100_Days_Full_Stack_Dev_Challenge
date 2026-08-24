import { useContext } from "react";

import Navbar from "./Components/Navbar/Navbar";
import Profile from "./Components/Profile/Profile";

import { UserProvider } from "./Context/UserContext";
import { ThemeContext, ThemeProvider } from "./Context/ThemeContext";

import "./App.css";

const Dashboard = () => {
  const { theme } = useContext(ThemeContext);

  return (
    <div className={`dashboard ${theme}`}>
      <Navbar />

      <main className="dashboard-main">
        <section className="dashboard-header">
          <div>
            <p className="dashboard-label">MY WORKSPACE</p>

            <h1>Welcome to your Dashboard</h1>

            <p className="dashboard-description">
              Manage your profile and explore your workspace using React
              Context API.
            </p>
          </div>
        </section>

        <section className="dashboard-content">
          <Profile />
        </section>
      </main>
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