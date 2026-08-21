import { Link, useNavigate } from "react-router-dom";

const Dashboard = () => {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("isAuthenticated");

    navigate("/login", { replace: true });
  };

  return (
    <div className="dashboard-page">

      <header className="dashboard-header">

        <div>
          <span className="badge">PRIVATE AREA</span>

          <h1>JobTrack Dashboard</h1>

          <p>
            Welcome back! Here's your job search overview.
          </p>
        </div>

        <button
          onClick={handleLogout}
          className="logout-button"
        >
          Logout
        </button>

      </header>

      <div className="dashboard-grid">

        <div className="dashboard-card">
          <span>Total Applications</span>
          <strong>42</strong>
          <small>+8 this month</small>
        </div>

        <div className="dashboard-card">
          <span>Interviews</span>
          <strong>8</strong>
          <small>2 this week</small>
        </div>

        <div className="dashboard-card">
          <span>Offers</span>
          <strong>3</strong>
          <small>1 new offer</small>
        </div>

      </div>

      <div className="dashboard-panel">

        <h2>Quick Actions</h2>

        <div className="quick-actions">

          <Link to="/applications">
            View Applications
          </Link>

          <Link to="/statistics">
            View Statistics
          </Link>

        </div>

      </div>

    </div>
  );
};

export default Dashboard;