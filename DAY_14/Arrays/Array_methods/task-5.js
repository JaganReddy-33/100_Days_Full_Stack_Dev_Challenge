const products = [
  { id: 1, name: "Laptop", price: 50000, stock: 10 },
  { id: 2, name: "Mouse", price: 500, stock: 0 },
  { id: 3, name: "Keyboard", price: 1500, stock: 5 },
  { id: 4, name: "Monitor", price: 12000, stock: 3 }
];

// Get all product names.
const getProductNames = products.map((product)=>product.name);
console.log(getProductNames);


// Get products above ₹1000.
const getProductPrice = products.filter((product)=> product.price > 1000);
console.log(getProductPrice);


// Find Laptop.
const findLaptop = products.find((product)=>product.name === "Laptop");
console.log(findLaptop);


// Calculate total invent ory value. Formula: price * stock
const totalInventory = products.reduce((sum, product)=>{
  return sum+product.price * product.stock;
}, 0);
console.log(totalInventory);


// Check if any product is out of stock.
const checkStock = products.some((product)=>product.stock <= 0);
console.log(checkStock);


// Get out-of-stock products.
const getOutOfStock = products.filter((product)=>product.stock <= 0);
console.log(getOutOfStock);


// Get available products.
const getAvailableProducts = products.filter((product)=>product.stock > 0);
console.log(getAvailableProducts);


// Find most expensive product.
const mostExpensiveProduct = products.reduce((currentProduct, expensiveProduct)=>{
  return expensiveProduct.price > currentProduct.price ? expensiveProduct : currentProduct;
});
console.log(mostExpensiveProduct);


// Find cheapest product.
const cheapestProduct = products.reduce((currentProduct, cheapestProduct)=>{
  return currentProduct.price < cheapestProduct.price ? currentProduct : cheapestProduct;
});
console.log(cheapestProduct);


// Count available products.
const countAvailableProducts = products.reduce((count, product)=>{
  let availableProducts = product.stock > 0;
  return count + availableProducts;
}, 0);
console.log(countAvailableProducts);

