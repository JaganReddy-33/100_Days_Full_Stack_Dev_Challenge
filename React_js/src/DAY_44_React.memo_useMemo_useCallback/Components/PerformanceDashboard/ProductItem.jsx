import React from "react";

const ProductItem = React.memo(({ product, onSelect }) => {
    console.log(`Product rendered: ${product.name}`);

    return (
        <article className="product-item">
            <div className="product-icon">
                {product.category === "Electronics" ? "💻" : "🎧"}
            </div>

            <div className="product-details">
                <span>{product.category}</span>
                <h3>{product.name}</h3>
                <p>₹{product.price.toLocaleString()}</p>
            </div>

            <button onClick={() => onSelect(product)}>
                Select
            </button>
        </article>
    );
});

export default ProductItem;