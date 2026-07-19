
// synchronous js -  javaScript executes code line by line, one statement at a time.

// Asynchronous js - means JavaScript can start a task and continue executing the next line without waiting.

// callback - A function passes as an argument to another function, to be executed later....

// for ex:
function greet(name, callback){
    // console.log("Hello", name);

    callback();
}

function welcome(){
    // console.log("Welcome!");
}
greet("Jagan", welcome);


// callback hell

/*
login(function(){
    getProfile(function(){
        getPosts(function(){
            getComments(function(){
                console.log("Done!");
            });
        });
    });
}); 
*/


// setTimeout() - runs a function once after a specified delay

// syntax 
// setTimeout(function, milliseconds);

// ex: 
// console.log("Start");

setTimeout(() => {
    // console.log("Hello JMR!");
    
}, 3000);

// console.log("End");


// setInterval() - runs a function repeatedly after every specified interval
// ex: 
setInterval(() => {
    // console.log("Hey steve!"); 
}, 4000);

// clearTimeout() - cancels a scheduled setTimeout().
const timer = setTimeout(() => {
    console.log("How are you ?");
}, 5000);
clearTimeout(timer);

// clearInterval - stops a running setInterval().
const timerInterval = setInterval(() => {
    console.log("Im Fine!");
}, 5000);
clearInterval(timerInterval);


// Assignments

// 1 Create a function sayHello(callback)
function sayHello(callback){
    // console.log("Hello");
    callback();
}
sayHello(()=>{
    // console.log("Welcome");
});


// 2 Create a function that takes two numbers and a callback. Use the callback to print their subtraction.
function calculate(a, b, subtraction){
    subtraction(a, b);
}
calculate(20, 10, (x, y)=>{
    // console.log(x - y);
});

// 3 Create a callback that prints the square of a number
function printSquare(n, callback){
    // console.log("Square of given number is: ");
    callback(n);
}
printSquare(6, (a)=>{
    // console.log(a*a);
});

// 4
function payment(callback){
    // console.log("Processing payment....");
    setTimeout(() => {
        callback();
    }, 2000);
}
payment(() => {
    // console.log("Payment Successful");
    // console.log("Thank you!"); 
});


// create a countdown using setInterval();
let count  = 5;
const countdown = setInterval(() => {
    if(count >0){
        // console.log(count);
        count--;
    } else {
        // console.log("Done!");
        clearInterval(countdown);
    }
}, 1000);

// create a timer that prints loading... every second then stop after 5 sec
let printLoading = setInterval(() => {
    // console.log("Loading");
}, 1000);

setTimeout(() => {
    clearInterval(printLoading);
}, 5000);

// simulate this process login -> fetch profile -> load dashboard
setTimeout(() => { 
    // console.log("Login successful");
    setTimeout(() => {
        // console.log("Fetch profile");
        setTimeout(() => {
            // console.log("Load dashboard!");
        }, 1000);
    }, 1000);
}, 1000);


// Create a callback that checks whether a number is even or odd.
function checkNumber(num, callback){
    callback(num);
}
checkNumber(16, (n)=>{
    if(n%2 === 0){
        console.log("Even number")
    } else {
        console.log("Odd Number");
    }
});


// Create a function calculate(a, b, callback). Use the same function to perform:
// Addition -> Subtraction -> Multiplication -> Division. using different callbacks.

function calc(a, b, callback){
    return callback(a, b);
}

const add = (a, b)=> a+b;
const sub = (a, b)=> a-b;
const mul = (a, b)=> a*b;
const div = (a, b)=> a/b;

console.log(calc(10, 20, add));
console.log(calc(10, 2, sub));
console.log(calc(10, 20, mul));
console.log(calc(400, 20, div));


// Create a callback chain for an online shopping app.
setTimeout(() => {
    console.log("Order Placed");
    setTimeout(() => {
        console.log("Payment successful");
        setTimeout(() => {
            console.log("Packing");
            setTimeout(() => {
                console.log("Shipping");
                setTimeout(() => {
                    console.log("Delivered");
                }, 1000);  
            }, 1000);
        }, 1000);
    }, 1000);
}, 1000);
