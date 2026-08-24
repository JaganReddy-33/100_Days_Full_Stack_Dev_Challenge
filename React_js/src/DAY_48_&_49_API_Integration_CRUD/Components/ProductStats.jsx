
import "./ProductStats.css";

const ProductStats = ({
  totalProducts = 0,
  inStockProducts = 0,
  outOfStockProducts = 0,
  averageRating = 0,
}) => {
  return (
    <div className="header-stats-bar" aria-label="Inventory Overview">
      <div className="header-stat-item">
        <span className="stat-label">Total:</span>
        <strong className="stat-value">{totalProducts}</strong>
      </div>

      <div className="header-stat-item">
        <span className="stat-label">In Stock:</span>
        <strong className="stat-value text-success">{inStockProducts}</strong>
      </div>

      <div className="header-stat-item">
        <span className="stat-label">Out:</span>
        <strong className="stat-value text-danger">{outOfStockProducts}</strong>
      </div>

      <div className="header-stat-item rating-item">
        <span className="stat-icon" aria-hidden="true">⭐</span>
        <strong className="stat-value">{Number(averageRating).toFixed(1)}</strong>
      </div>
    </div>
  );
};

export default ProductStats;
