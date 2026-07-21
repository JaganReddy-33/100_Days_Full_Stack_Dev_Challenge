
// Variables

console.log(n); // undefined
var n = 10;  //(function scoped, hoisted)
console.log(n);

// console.log(a);  //ReferenceError, a cannot access before initialization.
let a;
a = 20; //(Block scoped, reassignable.)
a = 40; // we can easily re assign
console.log(a);

const b = 3.14;  // (Block scoped, constant reference)
// b = 3.1; // typeError: assignment to constant variable. so constant variables w cannot reassign.
console.log(b);


// Data types
//      1. Primitive data types - (Stored directly by value: String, Number, boolean, null, undefined, symbol, bigInt).

// examples: 
let str = "Jagan"; // String
console.log(typeof str);
// console.log(str);

let num = 12; // number
console.log(typeof num);

let isFound = true; // boolean
console.log(typeof isFound);

let c; // undefined
console.log(typeof c);

let d = null; // null
console.log(typeof d);

const bigNum2 = 123456789012345678901234567890n; //bigInt
console.log(typeof bigNum2);

const sym1 = Symbol("id"); //symbol
console.log(typeof sym1);


//      2. Non-Primitive type - (Stored by reference: Objects, arrays);
// examples 
let user1 = { id: 1, name: "Alice" }; // object
console.log(typeof user1);

let primaryColors = ["Red", "Green", "Blue"];
console.log(typeof primaryColors);


// Operations

// 1. Arithmetic Operators 
let add = 10+20;
let sub = 10-4;
let mul = 2*6;
let div = 20/2;
let exponent = 5**3;
let bigSum =  9007199254740991n + 5n;


// 2. Comparison Operators
let isStrictMatch = 10 === 10;
let isLooseMatch = 10 == "10";
let isNotEqual = 5 !== 10;
let isGreater = 25 > 12;
let isLessOrEqual = 8 <= 8;


// 3. Logical Operators
let isAuthenticated = true;
let hasPermission = true;
let hasAccess = isAuthenticated && hasPermission; // and operator (&&)
// console.log(hasAccess); 

let isPremiumMember= true;
let hasFreeTrial = false;
let canProceed = isPremiumMember || hasFreeTrial; // or operator(||)
// console.log(canProceed);

let isValidated = false;
let isInvalid = !isValidated; //  not Operator(!)
// console.log(isValidated);

let userInput;
let fallbackValue = userInput ?? "Default Text";
// console.log(fallbackValue);


// Ternary Operator
let isAdmin  = true;
let accessLevel = isAdmin ? "Full" : "Restricted";
// console.log(accessLevel);


let isOnline = false;
let operationalStatus = isOnline ? "Active" : "Offline";
// console.log(operationalStatus);

let age = 20;
let ticketPrice = age >= 65 ? 10 : 15;
// console.log(ticketPrice);



// Loops
// 1. for loop
for(let i=1; i<=10; i++){
    // console.log(i);
}

// 2. while loop
let score = 0;
while (score < 5) {
    // console.log(score);
    score++;
}

// 3. do-while loop 
let count = 0;
do{
    // console.log(count);
    count++;
} while (count < 2);

// break 
for (let i = 0; i < 10; i++) {
    if (i === 4) {
        break;
    }
    // console.log(i);
}

// continue
for (let i = 0; i < 5; i++) {
    if (i === 2) {
        continue;
    }
    // console.log(i);
}


// Functions

// 1. Normal function
function welcome(name) {
    // console.log("welcome back!", name);
}
welcome("Lohith");

// Expression function
const greet = function(name){
    // console.log("Hello dear!", name);
}
greet("JMR");


// 2. Arrow function
const sum = (a, b)=>a+b;
// console.log(sum(10, 20));


// 3. default function
function taxCalculator(price, rate = 0.05) {
    return price * rate;
}
// console.log(taxCalculator(200));


// 4. Rest Parameter 
function collectNames(...names) {
    return names;
}
// console.log(collectNames("jagan", "sathi", "Ajay", "Lohith"));

// spread Operator
const groupA = ["Alice", "Bob"];
const groupB = [...groupA, "Charlie", "David"];
// console.log(groupB);


// Strings

// slice Method
let framework = "JavaScript".slice(0, 4);

let extension = "image.png".slice(-3);

let extraction = "Frontend".slice(4);


// split Method
let tags = "a,b,c".split(",");

let words = "Hello World Code".split(" ");

let characters = "JS".split("");


// replace Method
let animal = "cats".replace("c", "b");

let greeting = "Hello World".replace("World", "JS");

let secureText = "password123".replace("123", "***");


// trim Method
let cleanText = "  hello  ".trim();

let cleanEmail = "  user@test.com\n".trim();

let cleanInput = "   admin   ".trim();


// includes Method
let hasWord = "frontend".includes("front");

let hasMatch = "package.json".includes(".json");

let hasValue = "developer".includes("dev");


// startsWith Method
let matchStart = "react".startsWith("re");

let isUrlSecure = "https://example.com".startsWith("https");

let checkPrefix = "id-9823".startsWith("id-");


// endsWith Method
let matchEnd = "script".endsWith("pt");

let isImage = "photo.jpg".endsWith(".jpg");

let isZip = "archive.zip".endsWith(".zip");


// Arrays

// map Method
let doubled = [1, 2].map(x => x * 2);

let lengths = ["apple", "banana"].map(str => str.length);

let stringified = [10, 20].map(num => String(num));


// filter Method
let filteredNumbers = [1, 6, 3].filter(x => x > 5);

let evenNumbers = [1, 2, 3, 4].filter(num => num % 2 === 0);

let activeUsers = [{ active: true }, { active: false }].filter(u => u.active);


// reduce Method
let sum1 = [1, 2, 3].reduce((acc, curr) => acc + curr, 0);

let product = [2, 3, 4].reduce((acc, curr) => acc * curr, 1);

let flattened = [[1, 2], [3, 4]].reduce((acc, curr) => acc.concat(curr), []);


// find Method
let matchedNumber = [1, 5, 10].find(x => x > 4);

let specificWord = ["cat", "elephant", "dog"].find(w => w.length > 5);

let targetUser = [{ id: 1 }, { id: 2 }].find(user => user.id === 2);


// some Method
let hasLargeNumber = [1, 2, 3].some(x => x > 2);

let hasAdmin = ["guest", "editor", "admin"].some(role => role === "admin");

let hasNegative = [5, 12, -3, 8].some(num => num < 0);


// every Method
let allPositive = [1, 2, 3].every(x => x > 0);

let allStrings = ["a", "b", "c"].every(item => typeof item === "string");

let allValid = [true, true, false].every(bool => bool === true);


// sort Method
let sortedAscending = [3, 1, 2].sort((a, b) => a - b);

let sortedDescending = [3, 1, 2].sort((a, b) => b - a);

let sortedWords = ["pear", "apple", "banana"].sort((a, b) => a.localeCompare(b));



// Objects
const employee = { id: 101, name: "Alice", age: 30, city: "London" };

const defaults = { theme: "light", volume: 50 };

const client = { profile: { zip: "E1 6AN" } };

// Destructuring
const { id, city } = employee;
const { name, age1 } = employee;

// Spread 
const mergedObj = { ...defaults, active: true };
const updatedUser = { ...employee, location: "UK" };

// Optional Chaining 
const postalCode = client?.profile?.zip;
const street = client?.address?.street;


// ES6+ features
const scoreSet = new Set([10, 20, 20, 30]);
scoreSet.add(40);
const totalScores = scoreSet.size;
// console.log(totalScores);


const productMap = new Map([['sku', 'A12'], ['price', 99]]);
productMap.set('stock', 15);
const itemPrice = productMap.get('price');
// console.log(itemPrice);


const prices =[200, 300, 5000, 300, 108];
for (const price of prices) {
    // console.log(price);
}

const userProfile = { username: "dev1", email: "a@b.com", status: "online" };
for (const prop in userProfile) {
    // console.log(prop);
}



// Async JavaScript
setTimeout(() => {
    // console.log("Done");
}, 1000);

const myPromise = new Promise((resolve, reject) => {
    let success = true;
    if (success) {
        resolve("Success");
    } else {
        reject("Failed");
    }
});

async function run() {
    const res = await myPromise;
    console.log(res);
}

try {
    let result = 10 / 0;
    throw new Error("dinominator is never be zero");
    
    run();
} catch (error) {
    console.error(error.message);
}


// Fetch API & JSON
const obj = JSON.parse('{"id":1}');
console.log(obj);

const str1 = JSON.stringify(obj);
console.log(str1);


fetch("https://typicode.com")
  .then(res => res.json())
  .then(data => console.log(data))
  .catch(err => console.error("Fetch Error:", err.message)); 


fetch("https://typicode.com", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify({ name: "Alex" })
})
  .then(res => res.json())
  .then(result => console.log(result))
  .catch(err => console.error("Post Error:", err.message));


