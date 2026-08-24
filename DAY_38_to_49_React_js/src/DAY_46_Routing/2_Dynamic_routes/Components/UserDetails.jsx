import { Link, useNavigate, useParams } from "react-router-dom";
import users from "../userData";

const UserDetails = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  const currUser = users.find((user) => user.id === Number(id));

  const containerStyle = {
    padding: "30px",
    fontFamily: "sans-serif",
    backgroundColor: "#f8f9fa",
    minHeight: "100vh",
    display: "flex",
    justifyContent: "center",
    alignItems: "flex-start"
  };

  const cardStyle = {
    backgroundColor: "#ffffff",
    border: "1px solid #e2e8f0",
    borderRadius: "12px",
    padding: "30px",
    boxShadow: "0 10px 15px rgba(0, 0, 0, 0.05)",
    maxWidth: "400px",
    width: "100%",
    textAlign: "center",
    boxSizing: "border-box"
  };

  const titleStyle = {
    fontSize: "22px",
    color: "#34495e",
    marginTop: "0",
    marginBottom: "20px",
    borderBottom: "1px solid #e2e8f0",
    paddingBottom: "10px"
  };

  const detailsBoxStyle = {
    background: "#f8f9fa",
    padding: "20px",
    borderRadius: "8px",
    border: "1px solid #edf2f7",
    marginBottom: "25px",
    textAlign: "left"
  };

  const textStyle = {
    margin: "8px 0",
    fontSize: "16px",
    color: "#4a5568"
  };

  const backButtonStyle = {
    backgroundColor: "#7f8c8d",
    color: "#ffffff",
    border: "none",
    borderRadius: "6px",
    padding: "12px 20px",
    fontSize: "14px",
    fontWeight: "bold",
    cursor: "pointer",
    width: "100%",
    boxSizing: "border-box"
  };

  const errorLinkStyle = {
    display: "block",
    backgroundColor: "#e74c3c",
    color: "#ffffff",
    borderRadius: "6px",
    padding: "12px 20px",
    fontSize: "14px",
    fontWeight: "bold",
    textDecoration: "none",
    textAlign: "center",
    width: "100%",
    boxSizing: "border-box"
  };

  if (!currUser) {
    return (
      <div style={containerStyle}>
        <div style={cardStyle}>
          <h3 style={{ color: "#e74c3c", marginBottom: "20px" }}>User not found!</h3>
          <Link to="/" style={errorLinkStyle}>Back to Users</Link>
        </div>
      </div>
    );
  }

  return (
    <div style={containerStyle}>
      <div style={cardStyle}>
        <h3 style={titleStyle}>User Details Profile</h3>
        
        <div style={{ fontSize: "60px", marginBottom: "15px" }}>👤</div>

        <div style={detailsBoxStyle}>
          <p style={textStyle}><strong>User ID:</strong> {currUser.id}</p>
          <p style={textStyle}><strong>Full Name:</strong> {currUser.name}</p>
          <p style={textStyle}><strong>Account Status:</strong> Active ✅</p>
        </div>

        <button onClick={() => navigate(-1)} style={backButtonStyle}>
          ⬅️ Go Back
        </button>
      </div>
    </div>
  );
};

export default UserDetails;
