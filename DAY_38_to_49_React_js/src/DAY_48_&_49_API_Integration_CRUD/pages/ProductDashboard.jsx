import { useEffect, useMemo, useState } from "react";
import {
  createProduct,
  deleteProduct,
  getProducts,
  updateProduct,
} from "../services/productService";

import ProductList from "../Components/ProductList";
import ProductForm from "../Components/ProductForm";
import ProductFilters from "../Components/ProductFilter";
import Loading from "../Components/Loading";
import ErrorMessage from "../Components/ErrorMessage";

import "./ProductDashboard.css";
import Pagination from "../Components/Pagination";
import ProductStats from "../Components/ProductStats";

const ProductDashboard = () => {
  const [products, setProducts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [deletingId, setDeletingId] = useState(null);

  const [error, setError] = useState("");
  const [successMessage, setSuccessMessage] = useState("");

  const [editingProduct, setEditingProduct] = useState(null);

  const [searchTerm, setSearchTerm] = useState("");
  const [category, setCategory] = useState("all");
  const [minPrice, setMinPrice] = useState("");
  const [maxPrice, setMaxPrice] = useState("");

  const [sortBy, setSortBy] = useState("default");

  const [currentPage, setCurrentPage] = useState(1);
  const productsPerPage = 6;


  const fetchProducts = async () => {
    try {
      setIsLoading(true);
      setError("");

      const data = await getProducts();

      setProducts(data);
    } catch (error) {
      setError(
        error.response?.data?.message ||
          error.message ||
          "Unable to fetch products."
      );
    } finally {
      setIsLoading(false);
    }
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  const categories = useMemo(() => {
    return [
      ...new Set(
        products
          .map((product) => product.category)
          .filter(Boolean)
      ),
    ].sort();
  }, [products]);

  const filteredProducts = useMemo(() => {
    return products.filter((product) => {
      const matchesSearch =
        product.title
          ?.toLowerCase()
          .includes(searchTerm.toLowerCase()) ||
        product.description
          ?.toLowerCase()
          .includes(searchTerm.toLowerCase()) ||
        product.category
        ?.toLowerCase()
        .includes(searchTerm.toLowerCase());

      const matchesCategory =
        category === "all" ||
        product.category === category;

      const matchesPrice = 
      (!minPrice || product.price >= Number(minPrice)) &&
      (!maxPrice || product.price <= Number(maxPrice));

      return matchesSearch && matchesCategory && matchesPrice;
    });
  }, [products, searchTerm, category, minPrice, maxPrice]);


  const sortedProducts = useMemo(()=>{

    const result = [...filteredProducts];

    switch (sortBy) {
      case "price-low":
        return result.sort((a, b)=> a.price - b.price);
      
      case "price-high":
        return result.sort((a, b)=> b.price - a.price);

      case "rating-high":
        return result.sort((a, b)=>b.rating - a.rating);

      case "rating-low":
        return result.sort((a, b)=> a.rating - b.rating);

      case "name-asc":
        return result.sort((a, b)=> a.title.localeCompare(b.title));

      case "name-desc":
        return result.sort((a, b)=> b.title.localeCompare(a.title));
    
      default:
        return result;
    }
  }, [filteredProducts, sortBy]);

  const handleResetFilters = ()=>{
    setSearchTerm("");
    setCategory("all");
    setMinPrice("");
    setMaxPrice("");
    setSortBy("default");
    setCurrentPage(1);
  }

  const totalPages = Math.ceil(
    sortedProducts.length / productsPerPage
  );
  const startIndex = (currentPage - 1) * productsPerPage;

  const paginatedProducts = sortedProducts.slice(
  startIndex,
  startIndex + productsPerPage
);

const totalProducts = products.length;

const inStockProducts = products.filter(
  (product) => product.stock > 0
).length;

const outOfStockProducts = products.filter(
  (product) => product.stock === 0
).length;

const averageRating =
  products.length > 0
    ? (
        products.reduce(
          (total, product) =>
            total + product.rating,
          0
        ) / products.length
      ).toFixed(1)
    : "0.0";

  const handleProductCreated = async (productData) => {
    try {
      setIsSubmitting(true);
      setError("");
      setSuccessMessage("");

      const newProduct = await createProduct(productData);

      setProducts((previous) => [
        newProduct,
        ...previous,
      ]);

      setSuccessMessage(
        "Product created successfully."
      );
    } catch (error) {
      setError(
        error.response?.data?.message ||
          error.message ||
          "Unable to create product."
      );
      throw error;
    } finally {
      setIsSubmitting(false);
    }
  };

  const handleProductUpdated = async (
    id,
    productData
  ) => {
    try {
      setIsSubmitting(true);
      setError("");
      setSuccessMessage("");

      const updatedProduct = await updateProduct(
        id,
        productData
      );

      setProducts((previous) =>
        previous.map((product) =>
          product.id === id
            ? {
                ...product,
                ...updatedProduct,
              }
            : product
        )
      );

      setEditingProduct(null);

      setSuccessMessage(
        "Product updated successfully."
      );
    } catch (error) {
      setError(
        error.response?.data?.message ||
          error.message ||
          "Unable to update product."
      );
      throw error;
    } finally {
      setIsSubmitting(false);
    }
  };

  const handleDeleteProduct = async (id) => {
    const confirmed = window.confirm(
      "Are you sure you want to delete this product?"
    );

    if (!confirmed) {
      return;
    }

    try {
      setDeletingId(id);
      setError("");
      setSuccessMessage("");

      await deleteProduct(id);

      setProducts((previous) =>
        previous.filter(
          (product) => product.id !== id
        )
      );

      if (editingProduct?.id === id) {
        setEditingProduct(null);
      }

      setSuccessMessage(
        "Product deleted successfully."
      );
    } catch (error) {
      setError(
        error.response?.data?.message ||
          error.message ||
          "Unable to delete product."
      );
    } finally {
      setDeletingId(null);
    }
  };

  const handleEditProduct = (product) => {
    setEditingProduct(product);
    setSuccessMessage("");

    window.scrollTo({
      top: document.body.scrollHeight,
      behavior: "smooth",
    });
  };

  const handleCancelEdit = () => {
    setEditingProduct(null);
  };

  if (isLoading) {
    return <Loading />;
  }

  if (error && products.length === 0) {
    return (
      <ErrorMessage
        message={error}
        onRetry={fetchProducts}
      />
    );
  }

  return (
    <main className="dashboard-page">
      <div className="dashboard-container">
        <header className="dashboard-header">
          <div>
            <p className="dashboard-label">
              PRODUCT MANAGEMENT
            </p>

            <h1>Product Dashboard</h1>

            <p className="dashboard-description">
              Manage your products using Axios and REST
              API operations.
            </p>
          </div>

          <ProductStats 
            totalProducts={totalProducts}
            inStockProducts={inStockProducts}
            outOfStockProducts={outOfStockProducts}
            averageRating={averageRating}
          />

        </header>

        {successMessage && (
          <div className="success-message">
            <span>✓</span>
            {successMessage}
          </div>
        )}

        {error && (
          <div className="dashboard-error">
            <span>{error}</span>

            <button
              type="button"
              onClick={() => setError("")}
            >
              ×
            </button>
          </div>
        )}

        <ProductFilters
          searchTerm={searchTerm}
          setSearchTerm={setSearchTerm}
          category={category}
          setCategory={setCategory}
          categories={categories}
          minPrice={minPrice}
          setMinPrice={setMinPrice}
          maxPrice={maxPrice}
          setMaxPrice={setMaxPrice}
          sortBy={sortBy}
          setSortBy={setSortBy}
          onReset={handleResetFilters}
        />

        <ProductList
          products={paginatedProducts}
          onEdit={handleEditProduct}
          onDelete={handleDeleteProduct}
          deletingId={deletingId}
          totalProducts={products.length}
        />

        <Pagination 
          currentPage={currentPage}
          totalPages={totalPages}
          onPageChange={setCurrentPage}
        />

        <ProductForm
          onProductCreated={handleProductCreated}
          onProductUpdated={handleProductUpdated}
          editingProduct={editingProduct}
          onCancelEdit={handleCancelEdit}
          isSubmitting={isSubmitting}
        />
      </div>
    </main>
  );
};

export default ProductDashboard;