

// Function _ Parameters

// Add two numbers.
function add(a, b) {
    let add = a+b;
    console.log("Sum of Two numbers: ",add);
}
add(10, 20);

// Subtract two numbers.
function  sub(a, b) {
    let sub = a - b;
    console.log("Subtract of two numbers",sub);
}
sub(20, 10)


// Multiply two numbers.
function mul(a, b) {
    let mul = a * b;
    console.log("multiply of two numbers",mul);
}
mul(10, 2)

// Divide two numbers.
function division(a, b) {
    let div = a / b;
    console.log(div);
}
division(10, 2);


// Find the square.
function square(a) {
    let square = a*a;
    console.log(square);
}
square(6);

// Find the cube.
function cube(a) {
    let cube = a*a*a;
    console.log(cube);
}
cube(3);


// Print full name.
function printFullName(firstName, lastName) {
    console.log("Full Name: ", firstName+" "+lastName);
}
printFullName("Jagan", "Reddy");



// Calculate age.
function calculateAge(birthDateString) {
    const today = new Date();
    const birthDate = new Date(birthDateString); 
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDifference = today.getMonth() - birthDate.getMonth(); 
    if (monthDifference < 0 || (monthDifference === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age;
}
const myAge = calculateAge("2005-01-11");
console.log("Calculated Age:", myAge);



// Calculate simple interest.
function calculateSimpleInterest(principal, rate, time) {
    const interest = (principal * rate * time) / 100;
    return interest;
}
const totalInterest = calculateSimpleInterest(5000, 7.5, 3);
console.log("Simple Interest Amount:", totalInterest);



// Print multiplication table.
function printMultiplicationTable(targetNumber) {
    for (let i = 1; i <= 10; i++) {
        console.log(`${targetNumber} x ${i} = ${targetNumber * i}`);
    }
}
printMultiplicationTable(8);