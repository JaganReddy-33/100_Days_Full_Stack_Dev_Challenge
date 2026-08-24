
import "./ProductFilter.css";

const ProductFilters = ({
  searchTerm,
  setSearchTerm,
  category,
  setCategory,
  categories,
  minPrice,
  setMinPrice,
  maxPrice,
  setMaxPrice,
  sortBy,
  setSortBy,
  onReset
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

      <div className="search-box">
        <input 
        type="number"
        min="0"
        value={minPrice}
        onChange={(e)=>setMinPrice(e.target.value)}
        placeholder="Min Price" 
      />
      </div>

      <div className="search-box">
        <input 
        type="number"
        min="0"
        value={maxPrice}
        onChange={(e)=> setMaxPrice(e.target.value)}
        placeholder="Max Price"
      />
      </div>

      <select
        value={sortBy}
        onChange={(e) => setSortBy(e.target.value)}
      >
        <option value="default">Sort By</option>
        <option value="price-low">Price: Low → High</option>
        <option value="price-high">Price: High → Low</option>
        <option value="rating-high">Rating: High → Low</option>
        <option value="rating-low">Rating: Low → High</option>
        <option value="name-asc">Name: A → Z</option>
        <option value="name-desc">Name: Z → A</option>
      </select>

      <button type="button" className="reset-button" onClick={onReset}> Reset </button>    
    </section>
  );
};

export default ProductFilters;