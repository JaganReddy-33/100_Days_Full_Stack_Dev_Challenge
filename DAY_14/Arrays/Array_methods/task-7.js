const orders = [
  { id: 1, amount: 2000, status: "completed" },
  { id: 2, amount: 5000, status: "pending" },
  { id: 3, amount: 3000, status: "completed" },
  { id: 4, amount: 1000, status: "cancelled" }
];


// Calculate total revenue.
const totalRevenue = orders.reduce((total, order)=>{
  let amount = order.amount;
  return total + amount;
}, 0);
console.log(totalRevenue);


// Get completed orders.
const getCompletedOrders = orders.filter((order)=>order.status === "completed");
console.log(getCompletedOrders);


// Get pending orders.
const getPendingOrders = orders.filter((order)=>order.status === "pending");
console.log(getPendingOrders);


// Count completed orders.
const countCompletedOrders = orders.reduce((count, order)=>{
  let completedOrders = order.status === "completed";
  return count + completedOrders;
}, 0);
console.log(countCompletedOrders);

// Find largest order.
const findLargestOrder = orders.reduce((currentOrder, largestOrder)=>{
  return largestOrder.amount > currentOrder.amount? largestOrder : currentOrder;
});
console.log(findLargestOrder);


// Find smallest order.
const findSmallestOrder = orders.reduce((currentOrder, smallestOrder)=>{
return currentOrder.amount < smallestOrder.amount ? currentOrder : smallestOrder; 
});
console.log(findSmallestOrder);


// Check if any order exceeds ₹4000.
const checkOrder = orders.some((order)=>order.amount > 4000);
console.log(checkOrder);


// Get completed order amounts.
const getCompletedOrdersAmount = orders.filter((order)=>order.status === "completed").map((order)=>order.amount);
console.log(getCompletedOrdersAmount);


// Calculate average order value.
const avgOrderVal = orders.reduce((total, order)=>{
  let amount = order.amount;
  return total + amount;
}, 0);
let avg = avgOrderVal / orders.length;
console.log(avg);


// Find order id = 3.
const findOrderId = orders.find((order)=>order.id === 3);
console.log(findOrderId); 