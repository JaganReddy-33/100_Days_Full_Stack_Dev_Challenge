// task-5: Product Title Formatter

const product = "wireless bluetooth headphones";


// Convert to uppercase.
console.log(product.toUpperCase());

// Convert to lowercase.
console.log(product.toLowerCase());

// Count total words.
let ar = product.split(" ");
console.log(ar.length);

// Check whether "bluetooth" exists.
console.log(product.includes("bluetooth"));

// Replace "bluetooth" with "Bluetooth".
console.log(product.replace("bluetooth", "Bluetooth"));

// Convert to array of words.
let arr = product.split(" ");
console.log(arr);

// Get the second word. Expected: "bluetooth"
console.log(arr[1]);

// Find the length of the product title.
console.log(product.length);