//Basic Arithmetic Operations
let a = 11;
let b = 2;
//Addition
const add = a + b;
console.log(add);

//Subtraction
const sub = a - b;
console.log(sub);

//multiplication
const mul = a * b;
console.log(mul);

//division
const div = a / b;
console.log(div);

//Using Modulus to Find Remainder
const result = a % b;
console.log(result);


//Increment and Decrement
let number = 10;
number++; //increase by 1
number--; //decrease by 1
console.log(number);

let x = 20;
console.log(x++);
console.log(x);

let y = 10;
console.log(++y);
console.log(y);

//Compound Assignment with Arithmetic Operators
let score = 5;
score -= 2; // score/ 2
console.log(score);

let balance = 1000;
console.log(balance);

balance += 500;
console.log(balance);

balance -= 200;
console.log(balance);

balance *= 2;
console.log(balance);

balance /= 4;
console.log(balance);




// more problems
// avg
let english = 85;
let maths = 90;
let science = 88;

let total = english + maths + science;
console.log(total);

// percentage
let totalMarks = 500;
let obtained = 430;

let percentage = (obtained / totalMarks) * 100;
console.log(percentage);

// rectangle area 
let length = 20;
let breadth = 10;

let area = length * breadth;
console.log(area);

// circle area 
const PI = 3.14;
let radius = 7;
let circleArea = PI * radius * radius;
console.log(circleArea);

// celsius to fahrenheit
let celsius = 30;

let fahrenheit = (celsius * 9 / 5) + 32;
console.log(fahrenheit);


// String Concatenation
let firstName = "Jagan";
let lastName = "Reddy";
console.log(firstName + " " + lastName);

// template literals
let name = "Jagan";
let age = 21;
console.log(`My name is ${name} and I am ${age} years old.`);