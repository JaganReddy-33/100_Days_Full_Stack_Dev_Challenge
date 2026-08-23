import axios from "axios";

const API_URL = "https://dummyjson.com/products";

export const getProducts = async () => {
  const response = await axios.get(API_URL);
  return response.data.products;
};

export const getProductById = async (id) => {
  const response = await axios.get(`${API_URL}/${id}`);
  return response.data;
};

export const createProduct = async (productData) => {
  const response = await axios.post(`${API_URL}/add`, productData);
  return response.data;
};

export const updateProduct = async (id, productData) => {
  const response = await axios.put(`${API_URL}/${id}`, productData);
  return response.data;
};

export const patchProduct = async (id, productData) => {
  const response = await axios.patch(`${API_URL}/${id}`, productData);
  return response.data;
};

export const deleteProduct = async (id) => {
  const response = await axios.delete(`${API_URL}/${id}`);
  return response.data;
};