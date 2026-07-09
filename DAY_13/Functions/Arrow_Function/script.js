
// Arrow function


// 1. Sum
const sum = (a, b) => a + b;
console.log(sum(190, 340));


// 2. Difference
const difference = (a, b) => a - b;
console.log(difference(220, 40));


// 3. Multiply
const multiply = (a, b) => a * b;
console.log(multiply(45, 2));


// 4. Divide
const divide = (a, b) => b !== 0 ? a / b : "Cannot divide by zero";
console.log(divide(40, 4));


// 5. Square
const square = x => x * x;
console.log(square(67));


// 6. Cube
const cube = x => x * x * x;
console.log(cube(55));


// 7. Even/Odd (Returns true if even, false if odd)
const isEven = x => x % 2 === 0;
console.log(isEven(68));


// 8. Largest Number
const largestNumber = (a, b) => a > b ? a : b;
console.log(largestNumber(34, 67));


// 9. Greeting
const greeting = name => `Hello, ${name}!`;
console.log(greeting("Ajay"));


// 10. Area of Circle
const areaOfCircle = radius => Math.PI * radius * radius;
console.log(areaOfCircle(6));

