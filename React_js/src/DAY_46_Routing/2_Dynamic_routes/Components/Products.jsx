import { Link, useSearchParams } from "react-router-dom";
import products from "../productsData";

const Products = () => {

  const [searchParams, setSearchParams] = useSearchParams();
  const activityCategory = searchParams.get("category");

  const filteredProducts = activityCategory ? products.filter((product) => product.category === activityCategory) : products;

  const containerStyle = {
    padding: "30px",
    fontFamily: "sans-serif",
    backgroundColor: "#f8f9fa",
    minHeight: "100vh"
  };

  const titleStyle = {
    fontSize: "28px",
    color: "#2c3e50",
    marginBottom: "20px",
    borderBottom: "2px solid #e2e8f0",
    paddingBottom: "10px"
  };

  const filterBoxStyle = {
    display: "flex",
    gap: "10px",
    marginBottom: "25px",
    padding: "15px",
    backgroundColor: "#ffffff",
    borderRadius: "8px",
    border: "1px solid #e2e8f0",
  };

  const buttonStyle = (isActive) => ({
    padding: "8px 16px",
    backgroundColor: isActive ? "#3498db" : "#f1f2f6",
    color: isActive ? "#ffffff" : "#2c3e50",
    border: "none",
    borderRadius: "5px",
    fontWeight: "bold",
    cursor: "pointer",
  });

  const gridStyle = {
    display: "grid",
    gridTemplateColumns: "repeat(auto-fill, minmax(220px, 1fr))",
    gap: "20px",
    marginTop: "20px"
  };

  const cardStyle = {
    backgroundColor: "#ffffff",
    border: "1px solid #e2e8f0",
    borderRadius: "8px",
    padding: "20px",
    boxShadow: "0 4px 6px rgba(0, 0, 0, 0.05)",
    textAlign: "center",
    display: "flex",
    flexDirection: "column",
    justifyContent: "space-between",
    boxSizing: "border-box"
  };

  const productNameStyle = {
    fontSize: "18px",
    color: "#34495e",
    margin: "0 0 15px 0"
  };

  const detailsLinkStyle = {
    display: "block",
    backgroundColor: "#3498db",
    color: "#ffffff",
    borderRadius: "5px",
    padding: "10px 15px",
    fontSize: "14px",
    fontWeight: "bold",
    textDecoration: "none",
    textAlign: "center",
    boxSizing: "border-box"
  };

  return (
    <div style={containerStyle}>
      <h3 style={titleStyle}>Products List</h3>
      <div style={filterBoxStyle}>
        <span style={{ alignSelf: "center", fontWeight: "bold", marginRight: "10px" }}>Filter:</span>
        <button style={buttonStyle(activityCategory === null)} 
        onClick={() => setSearchParams({})}> All </button>
        <button style={buttonStyle(activityCategory === "electronics")} 
        onClick={() => setSearchParams({ category: "electronics" })}> Electronics </button>
        <button style={buttonStyle(activityCategory === "kitchen")} 
        onClick={() => setSearchParams({ category: "kitchen" })}> Kitchen </button>
        <button style={buttonStyle(activityCategory === "apparel")} 
        onClick={() => setSearchParams({ category: "apparel" })}> Apparel </button>
        <button style={buttonStyle(activityCategory === "books")} 
        onClick={() => setSearchParams({ category: "books" })}> Books </button>
        <button style={buttonStyle(activityCategory === "fitness")} 
        onClick={() => setSearchParams({ category: "fitness" })}> Fitness </button>
      </div>

      <div className="products" style={gridStyle}>
        {filteredProducts.map((product) => (
          <div key={product.id} style={cardStyle}>
            <h2 style={productNameStyle}>{product.name}</h2>
            <Link to={`/products/${product.category}/${product.id}`} style={detailsLinkStyle}>View Full Details</Link>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Products;
