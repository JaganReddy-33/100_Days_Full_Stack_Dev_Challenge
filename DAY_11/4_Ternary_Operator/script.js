
// Ternary operator

// Adult / Minor
let age = 20;
let status = (age >= 18) ? "Adult" : "Minor";
console.log(status); 


//  Even / Odd
let number = 7;
let parity = (number % 2 === 0) ? "Even" : "Odd";
console.log(parity);



// Pass / Fail
let score = 65;
let result = (score >= 40) ? "Pass" : "Fail";
console.log(result);


// Positive / Negative
let num = -5;
let sign = (num >= 0) ? "Positive" : "Negative";
console.log(sign); 


// Logged In / Guest
let isLoggedIn = true;
let userGreeting = isLoggedIn ? "Welcome back, User!" : "Welcome, Guest!";
console.log(userGreeting);


// Eligible / Not Eligible (Voting)
let hasVoterId = false;
let eligibility = hasVoterId ? "Eligible" : "Not Eligible";
console.log(eligibility);


//  Discount Available / Not Available
let isPremiumMember = true;
let discountStatus = isPremiumMember ? "Discount Available" : "Not Available";
console.log(discountStatus); 


//  Free Shipping / Paid Shipping
let cartTotal = 45;
let shippingType = (cartTotal >= 50) ? "Free Shipping" : "Paid Shipping";
console.log(shippingType);



// Online / Offline
let isConnected = true;
let networkStatus = isConnected ? "Online" : "Offline";
console.log(networkStatus); 


// Morning / Evening Greeting
let currentHour = 10; 
let greeting = (currentHour < 12) ? "Good Morning" : "Good Evening";
console.log(greeting);