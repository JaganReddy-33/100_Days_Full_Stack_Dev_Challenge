
// Template literals - basics

// 1. basic template literals
const name = "Sathi";
console.log(`Hello ${name}!`);


// 2. Multiple Variables
const firstName = "Jagan";
const lastName = "Reddy";

console.log(`Full Name: ${firstName} ${lastName}`);


// 3. Expression inside Template Literal
const a = 20;
const b = 40;
console.log(`Addition  = ${a+b}`);


// 4. calling function
const square =(num)=>num*num;
console.log(`square of given num is = ${square(5)}`);


// 5. object values
const student = {
    name: "lohith",
    age: 22,
    relation: "friend"
};
console.log(`${student.name} is my ${student.relation}`);


// array values
const fruits = ["apple", "banana", "orange"];
for(let i=0; i<fruits.length; i++){
    console.log(`The ${i+1} place fruit is ${fruits[i]}`); 
}


// 7. Boolean
const isLoggedIn = true;
console.log(`Login Status : ${isLoggedIn}`);

// 8. Multiline Strings
const message = `
Welcome
to
JavaScript
ES6
`;
console.log(message);

// 9. Ternary Operator
const age = 21;
console.log(`${age >= 18 ? "Adult" : "Minor"}`);



// 10. Nested Object
const employee = {
    name: "John",
    company: {
        name: "Google"
    }
};

console.log(`${employee.name} works at ${employee.company.name}`);




// examples
// Example 1 - Invoice
const product = "Laptop";
const price = 60000;
console.log(`You purchased ${product} for ₹${price}`);



// Example 2 - Weather
const city = "Chennai";
const temp = 35;
console.log(`Today's temperature in ${city} is ${temp}°C`);



// Example 3 - Student Report
const Student = "Jagan";
const marks = 95;
console.log(`${Student} secured ${marks}%`);



// Example 4 - Login
const username = "admin";
console.log(`Welcome back, ${username}`);


// Example 5 - Shopping Cart
const item = "Shoes";
const quantity = 2;
const Price = 2500;
console.log(`You bought ${quantity} ${item} for ₹${quantity * Price}`);



// Example 6 - Electricity Bill
const units = 120;
const amount = units * 8;
console.log(`Total Bill : ₹${amount}`);



// Example 7 - Salary Slip
const basic = 40000;
const hra = 8000;
const total = basic + hra;
console.log(`Net Salary : ₹${total}`);



// Example 8 - Bank
const balance = 85000;
console.log(`Available Balance : ₹${balance}`);



// Example 9 - Order Status
const id = 101;
console.log(`Order #${id} has been delivered.`);


// Example 10 - GitHub Profile
const user = "JMR";
console.log(`https://github.com/${user}`);




// assignments
//  Print multiplication table using template literals.
for(let i=1; i<=10; i++){
    console.log(`5 x ${i} = ${5 * i}`);
}


//  Print today's date using template literals.

const date = new Date();
console.log(`Today's date is: ${date.toLocaleDateString()}`);


//  Print random number.
const random = Math.floor(Math.random()*100)+1;
console.log(`random number is: ${random}`);


//  Print BMI result.
const testWeight = 70; 
const testHeight = 1.75; 
const bmi = testWeight / (testHeight * testHeight);
console.log(`Your calculated BMI is ${bmi.toFixed(2)}`);



//  Print grade using ternary operator.
const testMarks = 85;
const grade = testMarks >= 90 ? 'A' : testMarks >= 80 ? 'B' : testMarks >= 70 ? 'C' : 'F';
console.log(`Your grade for ${testMarks} marks is: ${grade}`);



//  Print voting eligibility.
const testAge = 20;
const canVote = testAge >= 18 ? 'Eligible to vote' : 'Not eligible to vote';
console.log(`Voting Status for age ${testAge}: ${canVote}`);



//  Print discount amount.
const testBill = 1500;
const discount = testBill > 1000 ? testBill * 0.20 : testBill * 0.05;
console.log(`Discount on bill ₹${testBill}: ₹${discount}`);
