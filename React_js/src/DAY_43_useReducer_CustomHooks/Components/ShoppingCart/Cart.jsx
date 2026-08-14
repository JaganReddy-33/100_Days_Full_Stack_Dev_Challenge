import { useReducer, useState } from "react";
import "./Cart.css";

const initialValue = [];

function reducer(state, action) {
    switch (action.type) {

        case "ADD_PRODUCT":
            return [...state, action.payload];

        case "INCREASE_QUANTITY":
            return state.map((product) =>
                product.id === action.payload
                    ? {
                        ...product,
                        quantity: product.quantity + 1
                    }
                    : product
            );

        case "DECREASE_QUANTITY":
            return state.map((product) =>
                product.id === action.payload
                    ? {
                        ...product,
                        quantity: Math.max(
                            1,
                            product.quantity - 1
                        )
                    }
                    : product
            );

        case "DELETE_PRODUCT":
            return state.filter(
                (product) => product.id !== action.payload
            );

        case "CLEAR_CART":
            return [];

        default:
            return state;
    }
}

const Cart = () => {

    const [products, dispatch] = useReducer(
        reducer,
        initialValue
    );

    const [input, setInput] = useState("");
    const [price, setPrice] = useState("");

    const addProduct = () => {

        if (!input.trim() || !price) {
            return;
        }

        dispatch({
            type: "ADD_PRODUCT",
            payload: {
                id: Date.now(),
                title: input.trim(),
                price: Number(price),
                quantity: 1
            }
        });

        setInput("");
        setPrice("");
    };

    const handleIncrease = (id) => {
        dispatch({
            type: "INCREASE_QUANTITY",
            payload: id
        });
    };

    const handleDecrease = (id) => {
        dispatch({
            type: "DECREASE_QUANTITY",
            payload: id
        });
    };

    const handleDelete = (id) => {
        dispatch({
            type: "DELETE_PRODUCT",
            payload: id
        });
    };

    const handleClearCart = () => {
        dispatch({
            type: "CLEAR_CART"
        });
    };

    const total = products.reduce(
        (sum, product) =>
            sum + product.price * product.quantity,
        0
    );

    return (
        <div className="cart-page">

            <div className="cart-container">

                {/* Header */}
                <header className="cart-header">
                    <div>
                        <span className="cart-badge">
                            useReducer Assessment 4
                        </span>

                        <h1>Shopping Cart</h1>

                        <p>
                            Manage products and quantities
                            using React useReducer.
                        </p>
                    </div>

                    <div className="cart-icon">
                        🛒
                    </div>
                </header>

                {/* Add Product */}
                <section className="add-product-card">

                    <h2>Add Product</h2>

                    <div className="product-form">

                        <input
                            type="text"
                            placeholder="Product name"
                            value={input}
                            onChange={(e) =>
                                setInput(e.target.value)
                            }
                        />

                        <div className="price-input">
                            <span>₹</span>

                            <input
                                type="number"
                                placeholder="Price"
                                value={price}
                                onChange={(e) =>
                                    setPrice(e.target.value)
                                }
                            />
                        </div>

                        <button
                            className="add-btn"
                            onClick={addProduct}
                        >
                            + Add Product
                        </button>

                    </div>

                </section>

                {/* Cart Items */}
                <section className="cart-items-section">

                    <div className="section-title">
                        <div>
                            <h2>Your Cart</h2>

                            <p>
                                {products.length}{" "}
                                {products.length === 1
                                    ? "product"
                                    : "products"}
                            </p>
                        </div>
                    </div>

                    {products.length === 0 ? (

                        <div className="empty-cart">
                            <div className="empty-icon">
                                🛍️
                            </div>

                            <h3>Your cart is empty</h3>

                            <p>
                                Add a product above to get
                                started.
                            </p>
                        </div>

                    ) : (

                        <div className="product-list">

                            {products.map((product) => (

                                <div
                                    className="product-card"
                                    key={product.id}
                                >

                                    <div className="product-info">

                                        <div className="product-image">
                                            🛒
                                        </div>

                                        <div>
                                            <h3>
                                                {product.title}
                                            </h3>

                                            <p>
                                                ₹
                                                {product.price.toLocaleString(
                                                    "en-IN"
                                                )}{" "}
                                                each
                                            </p>
                                        </div>

                                    </div>

                                    <div className="product-actions">

                                        <div className="quantity-control">

                                            <button
                                                onClick={() =>
                                                    handleDecrease(
                                                        product.id
                                                    )
                                                }
                                            >
                                                −
                                            </button>

                                            <span>
                                                {product.quantity}
                                            </span>

                                            <button
                                                onClick={() =>
                                                    handleIncrease(
                                                        product.id
                                                    )
                                                }
                                            >
                                                +
                                            </button>

                                        </div>

                                        <strong className="item-total">
                                            ₹
                                            {(
                                                product.price *
                                                product.quantity
                                            ).toLocaleString(
                                                "en-IN"
                                            )}
                                        </strong>

                                        <button
                                            className="remove-btn"
                                            onClick={() =>
                                                handleDelete(
                                                    product.id
                                                )
                                            }
                                        >
                                            Remove
                                        </button>

                                    </div>

                                </div>

                            ))}

                        </div>

                    )}

                </section>

                {/* Cart Summary */}
                {products.length > 0 && (

                    <section className="cart-summary">

                        <div>
                            <span className="summary-label">
                                Cart Total
                            </span>

                            <strong>
                                ₹
                                {total.toLocaleString(
                                    "en-IN"
                                )}
                            </strong>
                        </div>

                        <button
                            className="clear-btn"
                            onClick={handleClearCart}
                        >
                            Clear Cart
                        </button>

                    </section>

                )}

            </div>

        </div>
    );
};

export default Cart;