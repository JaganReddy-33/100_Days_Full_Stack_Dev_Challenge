
// Function expression


// Greeting
const greet = function (name) {
    return `Hello, ${name}!`;
}
console.log(greet("JMR"));

// Calculator
const calculator =function (num1, num2, operation) {
    switch (operation) {
        case 'add': return num1 + num2;
        case 'subtract': return num1 - num2;
        case 'multiply': return num1 * num2;
        case 'divide': return num2 !== 0 ? num1 / num2 : 'Cannot divide by zero';
        default: return 'Invalid operation';
    }
}

console.log(calculator(10, 2, "add"));

// Square
const square = function(number) {
    return number * number;
};
console.log(square(6));


// Largest Number
const findLargest = function(num1, num2) {
    return num1 > num2 ? num1 : num2;
};
console.log(findLargest(54, 67));


// Even/Odd
const isEven = function(number) {
    return number % 2 === 0;
};
console.log(isEven(12));



