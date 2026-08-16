import { useCallback, useMemo, useState } from "react";
import ProductItem from "./ProductItem";
import "./PerformanceDashboard.css";

const products = [
    { id: 1, name: "Laptop", price: 65000, category: "Electronics" },
    { id: 2, name: "Phone", price: 30000, category: "Electronics" },
    { id: 3, name: "Headphones", price: 2500, category: "Accessories" },
    { id: 4, name: "Keyboard", price: 1800, category: "Accessories" },
    { id: 5, name: "Monitor", price: 12000, category: "Electronics" },
    { id: 6, name: "Mouse", price: 1200, category: "Accessories" },
    { id: 7, name: "Tablet", price: 22000, category: "Electronics" },
    { id: 8, name: "Webcam", price: 3500, category: "Accessories" }
];

const PerformanceDashboard = () => {
    const [search, setSearch] = useState("");
    const [category, setCategory] = useState("All");
    const [count, setCount] = useState(0);
    const [selectedProduct, setSelectedProduct] = useState(null);

    const filteredProducts = useMemo(() => {
        console.log("Filtering products...");

        return products.filter((product) => {
            const matchesSearch = product.name
                .toLowerCase()
                .includes(search.toLowerCase());

            const matchesCategory =
                category === "All" ||
                product.category === category;

            return matchesSearch && matchesCategory;
        });
    }, [search, category]);

    const totalValue = useMemo(() => {
        console.log("Calculating total...");

        return filteredProducts.reduce(
            (total, product) => total + product.price,
            0
        );
    }, [filteredProducts]);

    const handleSelect = useCallback((product) => {
        setSelectedProduct(product);
    }, []);

    return (
        <div className="performance-dashboard">
            <header className="dashboard-header">
                <span className="dashboard-badge">
                    DAY 44 · PERFORMANCE
                </span>

                <h1>Product Performance Dashboard</h1>

                <p>
                    Optimized with React.memo, useMemo and useCallback.
                </p>
            </header>

            <section className="dashboard-controls">
                <input
                    type="text"
                    placeholder="Search products..."
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                />

                <select
                    value={category}
                    onChange={(e) => setCategory(e.target.value)}
                >
                    <option value="All">All Categories</option>
                    <option value="Electronics">Electronics</option>
                    <option value="Accessories">Accessories</option>
                </select>

                <button onClick={() => setCount((prev) => prev + 1)}>
                    Unrelated Counter: {count}
                </button>
            </section>

            <section className="dashboard-stats">
                <div className="stat-card">
                    <span>Products</span>
                    <strong>{filteredProducts.length}</strong>
                </div>

                <div className="stat-card">
                    <span>Total Value</span>
                    <strong>₹{totalValue.toLocaleString()}</strong>
                </div>

                <div className="stat-card">
                    <span>Category</span>
                    <strong>{category}</strong>
                </div>
            </section>

            <section className="products-section">
                <div className="section-heading">
                    <div>
                        <span>PRODUCTS</span>
                        <h2>Available Products</h2>
                    </div>

                    <p>{filteredProducts.length} results</p>
                </div>

                <div className="product-grid">
                    {filteredProducts.map((product) => (
                        <ProductItem
                            key={product.id}
                            product={product}
                            onSelect={handleSelect}
                        />
                    ))}
                </div>
            </section>

            {selectedProduct && (
                <section className="selected-product">
                    <span>SELECTED PRODUCT</span>

                    <h2>{selectedProduct.name}</h2>

                    <p>
                        ₹{selectedProduct.price.toLocaleString()}
                        {" · "}
                        {selectedProduct.category}
                    </p>
                </section>
            )}
        </div>
    );
};

export default PerformanceDashboard;