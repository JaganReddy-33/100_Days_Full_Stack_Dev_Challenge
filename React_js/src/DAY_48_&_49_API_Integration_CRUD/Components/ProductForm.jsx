import { useEffect, useState } from "react";
import "./ProductForm.css";

const initialFormData = {
  title: "",
  description: "",
  category: "",
  price: "",
  rating: "",
  stock: "",
  thumbnail: "",
};

const ProductForm = ({
  onProductCreated,
  onProductUpdated,
  editingProduct,
  onCancelEdit,
  isSubmitting,
}) => {
  const [formData, setFormData] = useState(initialFormData);

  useEffect(() => {
    if (editingProduct) {
      setFormData({
        title: editingProduct.title || "",
        description: editingProduct.description || "",
        category: editingProduct.category || "",
        price: editingProduct.price || "",
        rating: editingProduct.rating || "",
        stock: editingProduct.stock || "",
        thumbnail: editingProduct.thumbnail || "",
      });
    } else {
      setFormData(initialFormData);
    }
  }, [editingProduct]);

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData((previous) => ({
      ...previous,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const productData = {
      title: formData.title.trim(),
      description: formData.description.trim(),
      category: formData.category.trim(),
      price: Number(formData.price),
      rating: Number(formData.rating),
      stock: Number(formData.stock),
      thumbnail: formData.thumbnail.trim(),
    };

    if (editingProduct) {
      await onProductUpdated(
        editingProduct.id,
        productData
      );
    } else {
      await onProductCreated(productData);
    }

    if (!editingProduct) {
      setFormData(initialFormData);
    }
  };

  return (
    <section className="product-form-section">
      <div className="form-header">
        <div>
          <h2>
            {editingProduct
              ? "Edit Product"
              : "Add New Product"}
          </h2>

          <p>
            {editingProduct
              ? "Update the product information."
              : "Enter the details to create a new product."}
          </p>
        </div>

        {editingProduct && (
          <button
            type="button"
            className="cancel-button"
            onClick={onCancelEdit}
          >
            Cancel
          </button>
        )}
      </div>

      <form
        className="product-form"
        onSubmit={handleSubmit}
      >
        <div className="form-grid">
          <div className="form-group">
            <label htmlFor="title">
              Product Title
            </label>

            <input
              id="title"
              type="text"
              name="title"
              value={formData.title}
              onChange={handleChange}
              placeholder="Enter product title"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="category">
              Category
            </label>

            <input
              id="category"
              type="text"
              name="category"
              value={formData.category}
              onChange={handleChange}
              placeholder="Example: smartphones"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="price">
              Price
            </label>

            <input
              id="price"
              type="number"
              name="price"
              value={formData.price}
              onChange={handleChange}
              placeholder="Enter price"
              min="0"
              step="0.01"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="rating">
              Rating
            </label>

            <input
              id="rating"
              type="number"
              name="rating"
              value={formData.rating}
              onChange={handleChange}
              placeholder="Example: 4.5"
              min="0"
              max="5"
              step="0.1"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="stock">
              Stock
            </label>

            <input
              id="stock"
              type="number"
              name="stock"
              value={formData.stock}
              onChange={handleChange}
              placeholder="Enter stock quantity"
              min="0"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="thumbnail">
              Thumbnail URL
            </label>

            <input
              id="thumbnail"
              type="url"
              name="thumbnail"
              value={formData.thumbnail}
              onChange={handleChange}
              placeholder="https://example.com/product.jpg"
              required
            />
          </div>

          <div className="form-group full-width">
            <label htmlFor="description">
              Description
            </label>

            <textarea
              id="description"
              name="description"
              value={formData.description}
              onChange={handleChange}
              placeholder="Enter product description"
              rows="5"
              required
            />
          </div>
        </div>

        <button
          type="submit"
          className="submit-button"
          disabled={isSubmitting}
        >
          {isSubmitting
            ? editingProduct
              ? "Updating..."
              : "Creating..."
            : editingProduct
            ? "Update Product"
            : "Add Product"}
        </button>
      </form>
    </section>
  );
};

export default ProductForm;