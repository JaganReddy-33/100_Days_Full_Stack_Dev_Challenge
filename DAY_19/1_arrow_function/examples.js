


// Arrow Functions  - BASICS

// normal function
function greet(name){
    return "Hello "+name;
}
console.log(greet("Jagan"));


// arrow function
const greeting = (name)=>{
    return "Hello " + name;
}
console.log(greeting("Lohith"));


// Arrow function with no parameters
const sayHello = ()=>{
    console.log("Hello world!");
}
sayHello();


// Arrow function with one parameter
const square = (num)=>{
    return num*num;
}
console.log("square of num is" ,square(6));

const cube = (num)=>{
    return num*num*num;
}
console.log("cube of the given num is: ",cube(2));

const printNum = (n)=>{
    return n;
}
console.log(printNum(4));


// Arrow function with multiple parameters
const add = (a, b)=>{
    return a+b;
}
console.log(add(1, 2));

const sub =(a, b)=>{
    return a-b;
}
console.log(sub(3, 2));

const mul = (a, b)=>{
    return a*b;
}
console.log(mul(8, 5));

const div = (a, b)=>{
    if(b === 0){
        console.log("b should not be zero at any cost! we can't divisible by zero!");
        return; 
    }
    return a / b;
}
console.log(div(9, 2));

const add2 = (a, b, c)=>{
    return a+b+c;
}
console.log(add2(1, 2, 10));



// Implicit Return
const multiply = (a, b) => a * b;
console.log(multiply(5, 4));

const add3 = (a, b) => a+b;
console.log(add3(5, 8));


// returning an object
const createStudent = ()=>({
    name:"Jagan",
    age:21
});
console.log(createStudent());



// Arrow Function inside Array Methods
const numbers = [1, 2, 3];

const doubled = numbers.map(num => num * 2);
console.log(doubled);



// ex 1: calculate GST
const calcGST = (price)=> price * 0.18;
console.log(calcGST(1000));


// ex 2:  check Adult or not?
const isAdult = (age) =>{
    if(age >= 18){
        console.log("Adult!");
    } else {
        console.log("Minor!");
    }
}
isAdult(18);


// ex 3: Area of rectangle
const area = (len, wid) => len * wid ;
console.log(area(12, 6));


// ex 4: Discount Calculator
const discount = (price, percentage) =>{
    return price - (price*percentage / 100);
};
console.log(discount(5000, 20));


// ex 5: Temperature converter
const celsiusToFahrenheit = celsius => (celsius * 9 / 5) + 32;
console.log(celsiusToFahrenheit(35));


// ex 6: largest num 
const largest = (a, b) => a > b ? a : b;
console.log(largest(25, 10));
 

// ex 7: even or odd
const checkEven = number => number % 2 === 0 ? "Even" : "Odd";
console.log(checkEven(19));


// ex 8: return full name
const fullName = (first, last) => `${first} ${last}`;
console.log(fullName("Jagan", "Reddy"));

// ex 9: average marks 
const average = (a, b, c) => (a + b + c) / 3;
console.log(average(80, 90, 70));

// ex 10: tax included price 
const finalPrice = price => price + price * 0.18;
console.log(finalPrice(500));


//  assignment

const students = [
  { id: 1, name: "Alice", marks: 85, active: true },
  { id: 2, name: "Bob", marks: 45, active: false },
  { id: 3, name: "Charlie", marks: 72, active: true },
  { id: 4, name: "David", marks: 58, active: true }
];

const highScorers = students.filter(student => student.marks > 60);
console.log(highScorers);



const studentById = students.find(student => student.id === 3);
console.log(studentById);



const hasFailedStudents = students.some(student => student.marks < 50);
console.log(hasFailedStudents);


const didEveryonePass = students.every(student => student.marks >= 50);
console.log(didEveryonePass);


const totalMarks = students.reduce((sum, student) => sum + student.marks, 0);
console.log(totalMarks);


const highestMarks = students.reduce((max, student) => student.marks > max ? student.marks : max, 0);
console.log(highestMarks);


const activeCount = students.reduce((count, student) => student.active ? count + 1 : count, 0);
console.log(activeCount);


const passedStudentNames = students.filter(student => student.marks >= 50).map(student => student.name);
console.log(passedStudentNames);
