
// Assignment 3: Shopping Cart

const cart = {
  items: [],
  
  // 1. Add product
  addProduct(product, price, quantity) {
    const existing = this.items.find(item => item.product === product);
    if (existing) {
      existing.quantity += quantity;
    } else {
      this.items.push({ product, price, quantity });
    }
  },
  
  // 2. Remove product
  removeProduct(product) {
    this.items = this.items.filter(item => item.product !== product);
  },
  
  // 3. Update quantity
  updateQuantity(product, quantity) {
    const item = this.items.find(item => item.product === product);
    if (item) item.quantity = quantity;
  },
  
  // 4. Total bill
  getTotalBill() {
    return this.items.reduce((total, item) => total + (item.price * item.quantity), 0);
  }
};

// Quick verification
cart.addProduct("Wireless Mouse", 1200, 1);
cart.addProduct("USB-C Cable", 450, 2);
console.log("Total Bill:", cart.getTotalBill()); // 2100
