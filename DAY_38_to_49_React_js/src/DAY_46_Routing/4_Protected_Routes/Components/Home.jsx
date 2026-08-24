import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div className="public-page">

      <div className="hero-card">
        <span className="badge">JOBTRACK</span>

        <h1>Track your job search smarter.</h1>

        <p>
          Manage applications, interviews and job opportunities
          from one organized dashboard.
        </p>

        <div className="hero-actions">
          <Link to="/login" className="primary-button">
            Login
          </Link>

          <Link to="/dashboard" className="secondary-button">
            Open Dashboard
          </Link>
        </div>
      </div>

    </div>
  );
};

export default Home;