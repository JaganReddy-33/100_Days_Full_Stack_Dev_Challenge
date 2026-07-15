// Without Default Parameter

function greet(name) {
    console.log("Hello", name);
}

greet();          // Hello undefined
greet("Jagan");


// Default Parameter

function greetUser(name = "Guest") {
    console.log(`Hello ${name}`);
}

greetUser();
greetUser("Jagan");


// Multiple Default Parameters

function add(a = 0, b = 0) {
    return a + b;
}

console.log(add());
console.log(add(10));
console.log(add(10,20));


// Default Parameter with String

const welcome = (name = "Guest") => {
    console.log(`Welcome ${name}`);
};

welcome();
welcome("JMR");


// Default Parameter with Boolean

const login = (status = false) => {
    console.log(status ? "Logged In" : "Please Login");
};

login();
login(true);


// Default Parameter with Array

const printNumbers = (numbers = []) => {
    console.log(numbers);
};

printNumbers();
printNumbers([1,2,3]);


// Default Parameter with Object

const student = (user = {name:"Unknown",age:0})=>{
    console.log(user);
};

student();
student({name:"Jagan",age:22});



// some examples 

// GST
const bill = (price, gst = 18)=>{
    console.log(price + (price*gst/100));
};

bill(500);
bill(500,12);


// Salary
const salary = (basic, bonus = 0)=>{
   console.log(basic + bonus);
};

salary(30000);
salary(30000,5000);


// EMI
const emi = (amount, months = 12)=>{
    console.log(amount/months);
};

emi(120000);
emi(120000,24);


// Shopping
const order = (item, quantity = 1)=>{
    console.log(`${quantity} ${item}`);
};

order("Laptop");
order("Mouse",3);


// Student
const marks = (name, mark = 0)=>{
    console.log(`${name} : ${mark}`);
};

marks("Jagan");
marks("Ajay",95);


// assignments

// 1. Default age
const setAge = (age = 18) => `Age: ${age}`;
console.log(setAge());


// 2. Default salary
let inputSalary = null; 
let salary1 = inputSalary ?? 25000;
console.log(`Salary: ₹${salary1}`);


// 3. Default city
const getProfile = (city = "Mumbai") => `City: ${city}`;
console.log(getProfile());


// 4. Default GST
const calculateGST = (price, rate = 0.18) => price * rate;
console.log(`GST Amount: ₹${calculateGST(1000)}`);


// 5. Default discount
let userDiscount = null;
let finalDiscount = userDiscount ?? 0.10; 
console.log(`Discount Rate: ${finalDiscount * 100}%`);


// 6. Default quantity
const addToCart = (item, qty = 1) => `Added ${qty} x ${item} to cart.`;
console.log(addToCart("Laptop"));


// 7. Default bonus
const getBonus = (fixedBonus = 5000) => `Bonus: ₹${fixedBonus}`;
console.log(getBonus());


// 8. Default interest
const getInterest = (p, t, r = 0.07) => p * t * r;
console.log(`Interest: ₹${getInterest(10000, 2)}`);


// 9. Default marks
let enteredMarks;
let finalMarks = enteredMarks ?? 35;
console.log(`Marks: ${finalMarks}`);


// 10. Default username
const greetUser1 = (username = "Guest") => `Welcome, ${username}!`;
console.log(greetUser1());
