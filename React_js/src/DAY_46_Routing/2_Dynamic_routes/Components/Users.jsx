import { Link } from "react-router-dom";
import users from "../userData";

const Users = () => {
  const containerStyle = {
    padding: "30px",
    fontFamily: "sans-serif",
    backgroundColor: "#f8f9fa",
    minHeight: "100vh"
  };

  const titleStyle = {
    fontSize: "28px",
    color: "#2c3e50",
    marginBottom: "25px",
    borderBottom: "2px solid #e2e8f0",
    paddingBottom: "10px"
  };

  const gridStyle = {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fill, minmax(250px, 1fr))",
    gap: "20px",
    marginTop: "20px"
  };

  const cardStyle = {
    backgroundColor: "#ffffff",
    border: "1px solid #e2e8f0",
    borderRadius: "10px",
    padding: "20px",
    boxShadow: "0 4px 6px rgba(0, 0, 0, 0.05)",
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    gap: "10px",
    boxSizing: "border-box"
  };

  const userNameStyle = {
    fontSize: "20px",
    color: "#2c3e50",
    margin: "0"
  };

  const profileLinkStyle = {
    display: "block",
    backgroundColor: "#2ecc71",
    color: "#ffffff",
    borderRadius: "6px",
    padding: "10px 16px",
    fontSize: "14px",
    fontWeight: "bold",
    textDecoration: "none",
    textAlign: "center",
    width: "100%",
    boxSizing: "border-box"
  };

  const navigationContainerStyle = {
    display: "flex",
    justifyContent: "center",
    marginTop: "40px"
  };

  const productsLinkStyle = {
    display: "inline-block",
    backgroundColor: "#34495e",
    color: "#ffffff",
    borderRadius: "6px",
    padding: "12px 24px",
    fontSize: "15px",
    fontWeight: "bold",
    textDecoration: "none",
    textAlign: "center",
    boxShadow: "0 4px 6px rgba(0, 0, 0, 0.1)"
  };

  return (
    <div style={containerStyle}>
      <h3 style={titleStyle}>User Dashboard</h3>
      
      <div className="users" style={gridStyle}>
        {users.map((user) => (
          <div key={user.id} style={cardStyle}>
            <div style={{ fontSize: "40px" }}>👤</div>
            <h2 style={userNameStyle}>{user.name}</h2>
            <Link to={`/user/${user.id}`} style={profileLinkStyle}>View Profile</Link>
          </div>
        ))}
      </div>

      <div style={navigationContainerStyle}>
        <Link to="/products" style={productsLinkStyle}>📦 Go to Products</Link>
      </div>
    </div>
  );
};

export default Users;
