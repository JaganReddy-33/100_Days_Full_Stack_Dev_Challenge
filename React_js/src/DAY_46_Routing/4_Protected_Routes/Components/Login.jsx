import { useLocation, useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  const location = useLocation();

  const from = location.state?.from || "/dashboard";

  const handleLogin = () => {
    localStorage.setItem("isAuthenticated", "true");

    navigate(from, { replace: true });
  };

  return (
    <div className="auth-page">
      <div className="auth-card">
        <div className="auth-icon">JT</div>

        <h1>Welcome Back</h1>

        <p>
          Sign in to continue to your JobTrack dashboard.
        </p>

        <button onClick={handleLogin} className="primary-button">
          Login
        </button>

        <small>
          Demo authentication — no real credentials required.
        </small>
      </div>
    </div>
  );
};

export default Login;