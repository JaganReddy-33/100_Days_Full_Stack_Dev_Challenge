import ProductCard from "./ProductCard";
import "./ProductList.css";

const ProductList = ({
  products,
  onEdit,
  onDelete,
  deletingId,
}) => {
  if (products.length === 0) {
    return (
      <div className="empty-state">
        <div className="empty-icon">📦</div>

        <h2>No Products Found</h2>

        <p>
          No products match your current search or filter.
        </p>
      </div>
    );
  }

  return (
    <section className="product-list">
      <div className="product-list-header">
        <div>
          <h2>Products</h2>

          <p>
            Showing {products.length}{" "}
            {products.length === 1 ? "product" : "products"}
          </p>
        </div>
      </div>

      <div className="product-grid">
        {products.map((product) => (
          <ProductCard
            key={product.id}
            product={product}
            onEdit={onEdit}
            onDelete={onDelete}
            isDeleting={deletingId === product.id}
          />
        ))}
      </div>
    </section>
  );
};

export default ProductList;