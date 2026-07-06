//!----PRIMITIVE DATA TYPES---


// Number - Storing age
const age = 25;
console.log(age);

const mobilePrice = 79999;
console.log(mobilePrice);

// String - Storing name
const name = "Alice";
console.log(name);

const college = "ABC Engineering College";
console.log(college);

// Boolean - Is the user logged in?
const isLoggedIn = false;
console.log(isLoggedIn);

const hasDrivingLicense = true;
console.log(hasDrivingLicense);

// Undefined - A variable that has been declared but not yet assigned a value
let numOfChildren;
console.log(numOfChildren);

let money;
console.log(money);


// Null - Intentionally setting a variable to have no value
const salary = null;
console.log(salary);

let selectedCourse = null;
console.log(selectedCourse);


//!---NON-PRIMITIVE DATA TYPES---

// Object - Storing user data
const user = {
  firstName: "Jagan",
  lastName: "Reddy",
  age: 21,
};
console.log(user);

const laptop = {
    brand: "Dell",
    processor: "i7",
    ram: "16GB",
    price: 85000
};
console.log(laptop);
console.log(laptop.brand);
console.log(laptop.price);


// Array - Storing a list of numbers
const mixedData = [19, "Jane", true, null, undefined, {}];
console.log(mixedData);

const fruits = [
    "Apple",
    "Orange",
    "Banana",
    "Mango"
];
console.log(fruits);
console.log(fruits[0]);
console.log(fruits[3]);

// typeof
let name = "Jagan";
let age = 21;
let isPlaced = false;
console.log(typeof name);
console.log(typeof age);
console.log(typeof isPlaced);

console.log(typeof []);

console.log(typeof {});

console.log(typeof null);

console.log(typeof undefined);