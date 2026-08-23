
import "./ProductFilter.css";

const ProductFilters = ({
  searchTerm,
  setSearchTerm,
  category,
  setCategory,
  categories,
}) => {
  return (
    <section className="product-filters">
      <div className="search-box">
        <span className="search-icon">⌕</span>

        <input
          type="text"
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          placeholder="Search products..."
        />
      </div>

      <select
        value={category}
        onChange={(e) => setCategory(e.target.value)}
      >
        <option value="all">All Categories</option>

        {categories.map((item) => (
          <option
            key={item}
            value={item}
          >
            {item}
          </option>
        ))}
      </select>
    </section>
  );
};

export default ProductFilters;