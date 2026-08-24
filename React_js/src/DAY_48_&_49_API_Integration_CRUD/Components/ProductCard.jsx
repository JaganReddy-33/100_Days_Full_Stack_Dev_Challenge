import "./ProductCard.css";

const ProductCard = ({ product, onEdit, onDelete, isDeleting }) => {
  const isOutOfStock = product.stock === 0;

  return (
    <article className="product-card">
      <div className="product-image-container">
        <img
          src={product.thumbnail}
          alt={product.title}
          className="product-image"
        />

        <span className="product-category">
          {product.category}
        </span>
      </div>

      <div className="product-content">
        <h3 className="product-title">
          {product.title}
        </h3>

        <p className="product-description">
          {product.description}
        </p>

        <div className="product-info">
          <span className="product-rating">
            ⭐ {product.rating}
          </span>

          <span
            className={
              isOutOfStock
                ? "stock out-of-stock"
                : "stock"
            }
          >
            {isOutOfStock
              ? "Out of stock"
              : `${product.stock} in stock`}
          </span>
        </div>

        <div className="product-bottom">
          <span className="product-price">
            ${product.price}
          </span>

          <div className="product-actions">
            <button
              type="button"
              className="edit-button"
              onClick={() => onEdit(product)}
            >
              Edit
            </button>

            <button
              type="button"
              className="delete-button"
              onClick={() => onDelete(product.id)}
              disabled={isDeleting}
            >
              {isDeleting ? "Deleting..." : "Delete"}
            </button>
          </div>
        </div>
      </div>
    </article>
  );
};

export default ProductCard;