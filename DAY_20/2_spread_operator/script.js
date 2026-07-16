
// Spread Operator

// Arrays
// Create a shallow copy of the array ['a', 'b', 'c'] into a new variable alphaCopy.
let arr = ['a', 'b', 'c'];
let alphaCOpy =[...arr];
console.log(alphaCOpy);


// Combine [1, 2] and [3, 4] into a single array called combined.
let arr1 = [1, 2];
let arr2 = [3, 4];
let combinedArr = [...arr1, ...arr2];
console.log(combinedArr);


// Insert the elements of ['red', 'blue'] into the middle of ['start', 'end'] so it becomes ['start', 'red', 'blue', 'end'].
let ele = ['red', 'blue']
let originalArr = ['start', ...ele, 'end'];
console.log(originalArr);



// Convert the string 'hello' into an array of individual characters ['h', 'e', 'l', 'l', 'o'].
let str = "Hello";
let charArr = [...str]
console.log(charArr);



// Given const numbers = [45, 99, 12, 8], use a built-in Math function and the spread operator to find the lowest number.
let numbers = [45, 99, 12, 8];
let minNumber = Math.min(...numbers);
console.log(minNumber);



// Objects

// Create a shallow copy of { brand: 'Apple', model: 'iPhone' } into a new object deviceCopy.
let obj = {
    brand: 'Apple',
    model: 'Iphone'
};
let deviceCopy = {...obj};
console.log(deviceCopy);



// Merge { item: 'Book' } and { price: 15 } into a single object named product.
let obj1 = {
    item: 'Book'
};
let obj2 = {
    price: 150
};

let mergedObj = {...obj1, ...obj2};
console.log(mergedObj);



// Copy the object { status: 'pending', user: 'Alex' } but update the status property to 'approved' in a single step.
const original = {
    status: 'pending',
    user: 'Alex'
};

const updated = {...original, status: 'approved'};
console.log(updated);


// Combine { brand: 'Sony' } and { brand: 'LG', screen: 'OLED' }. Which brand wins? Write the code to make sure 'LG' wins.
const sony = { brand: 'Sony' };
const lg = { brand: 'LG', screen: 'OLED' };
const combined = { ...sony, ...lg };
console.log(combined);



// Add a new property isVerified: true while copying an existing user object { name: 'John', age: 25 }
const user = { name: 'John', age: 25 };
const verifiedUser = { ...user, isVerified: true };
console.log(verifiedUser);


// functions

// Pass the array [5, 10, 2] as individual arguments into a function sum(x, y, z) using the spread operator.
function sum(x, y, z) {
  return x + y + z;
}
const numbersArr =[1, 2, 3];
console.log(sum(...numbersArr));


// Safely shallow-copy a nested array [[1, 2], [3, 4]]. Modify the copy's first inner element.
const originalNested = [[1, 2], [3, 4]];
const shallowCopy = [...originalNested];
shallowCopy[0][0] = 99;
console.log(shallowCopy);
console.log(originalNested);



// Given an array of objects [{id: 1}, {id: 2}], create a new array that adds a third object {id: 3} to the end without mutating the original array.
const initialObjects = [{id: 1}, {id: 2}];
const extendedObjects = [...initialObjects, {id: 3}];
console.log(extendedObjects);


// Create a function joinArrays(...arrays) that takes any number of array arguments and flattens them into one single array.
function joinArrays(...arrays) {
  return arrays.flat();
}
const result1 = joinArrays();
console.log(result1); 

const result2 = joinArrays([1, 2], [3, 4], [5]);
console.log(result2); 

const result3 = joinArrays(['apple'], ['banana']);
console.log(result3); 
