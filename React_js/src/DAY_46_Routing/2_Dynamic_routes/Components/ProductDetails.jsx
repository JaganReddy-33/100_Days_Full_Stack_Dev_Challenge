import { Link, useNavigate, useParams } from "react-router-dom";
import products from "../productsData";

const ProductDetails = () => {
  const { category, id } = useParams();
  const navigate = useNavigate();

  const currProduct = products.find((product) => {
    return product.id === Number(id) && product.category === category;
  });


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
    maxWidth: "450px",
    width: "100%"
  };

  const headingStyle = {
    fontSize: "24px",
    color: "#2c3e50",
    marginTop: "0",
    marginBottom: "15px"
  };

  const idStyle = {
    fontSize: "16px",
    color: "#7f8c8d",
    marginBottom: "10px"
  };

  const badgeStyle = {
    display: "inline-block",
    backgroundColor: "#e8f4fd",
    color: "#2980b9",
    padding: "5px 12px",
    borderRadius: "20px",
    fontSize: "14px",
    fontWeight: "600",
    textTransform: "uppercase",
    marginBottom: "25px"
  };

  const backButtonStyle = {
    backgroundColor: "#7f8c8d",
    color: "#ffffff",
    border: "none",
    borderRadius: "5px",
    padding: "10px 20px",
    fontSize: "14px",
    fontWeight: "bold",
    cursor: "pointer",
    width: "100%"
  };

  const errorButtonStyle = {
    ...backButtonStyle,
    backgroundColor: "#e74c3c"
  };

  if (!currProduct) {
    return (
      <div style={containerStyle}>
        <div style={{ ...cardStyle, textAlign: "center" }}>
          <h3 style={{ color: "#e74c3c", marginBottom: "20px" }}>Product Not Found</h3>
          <Link to="/products" style={errorButtonStyle}>Back to Products</Link>
        </div>
      </div>
    );
  }

  return (
    <div style={containerStyle}>
      <div style={cardStyle}>
        <h2 style={headingStyle}>{currProduct.name}</h2>
        <h3 style={idStyle}>Product ID: {currProduct.id}</h3>
        <span style={{ margin: "0 0 8px 0", color: "#34495e" }}>Category: </span> 
        <span style={badgeStyle}>{currProduct.category}</span>
        
        <button onClick={() => navigate(-1)} style={backButtonStyle}>
          ⬅️ Go Back
        </button>
      </div>
    </div>
  );
};

export default ProductDetails;
