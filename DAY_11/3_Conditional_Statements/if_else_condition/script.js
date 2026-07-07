// if_else condition


// Positive or Negative
let n = 20;
if(n > 0){
    console.log("Positive values");
} else {
    console.log("Negative values");
}


// Even or Odd
let num = 5;
if(num%2 == 0){
    console.log("even numbers");
} else {
    console.log("Odd numbers");
}


// Adult or Minor
let age = 21;
if(age >= 18){
    console.log("Adult");
} else {
    console.log("Minor");    
}


// Pass or Fail
let marks = 69;
if(marks >= 35){
    console.log("Pass");
} else {
    console.log("fail");
}


// Free Delivery
let purchase = 3400;
if(purchase > 1000){
    console.log("Free delivery");    
} else {
    console.log("no free delivery");    
}


// Voting Eligible
let age1 = 21;
let hasVoterId = true;
if(age1 >= 18 && hasVoterId){
    console.log("Voting Eligible");
} else {
    console.log("not eligible");
}


// Electricity Bill Paid or Pending
let hasBillPaid = false;
if(hasBillPaid){
    console.log("Bill already paid");
} else {
    console.log("bill isn't paid! pending");
}