import { Link, Outlet } from "react-router-dom";

const Dashboard = () => {
  return (
    <div className="dashboard">

      <header className="dashboard-header">
        <div>
          <p className="dashboard-label">WORKSPACE</p>
          <h2>JobTrack Dashboard</h2>
        </div>

        <div className="user-badge">
          JR
        </div>
      </header>

      <nav className="dashboard-nav">
        <Link to="/dashboard">Overview</Link>

        <Link to="/dashboard/applications">
          Applications
        </Link>

        <Link to="/dashboard/statistics">
          Statistics
        </Link>
      </nav>

      <main className="dashboard-content">
        <Outlet />
      </main>

    </div>
  );
};

export default Dashboard;