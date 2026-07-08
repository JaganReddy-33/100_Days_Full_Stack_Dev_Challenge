
// WHILE LOOP

// Print numbers from 1 to 10 using a while loop.

let i =1;
while(i<=10){
    console.log(i);
    i++;
}


// Print numbers from 10 to 1.
let j=10;
while(j>=1){
    console.log(j);
    j--;
}


// Print odd numbers from 1 to 50.
let k = 1;
while(k<=50){
    console.log(k);
    k+=2;
}



// Reverse a number. 12345

let n = 12345;
let rev = "";
while(n>0){
    let rem = n%10;
    rev += rem;
    n = Math.floor(n/10);
}
console.log(rev);



// Count the number of digits. 987654
let N = 987654;
let count = 0;
while(N>0){
    count++;
    N = Math.floor(N / 10);
}
console.log(count);



// Find the sum of digits. ex: 12345
let x = 12345;
let sum = 0;
while(x>0){
    let rem = x%10;
    sum +=rem;
    x = Math.floor(x / 10);
}
console.log(sum);



// Check whether a number is a palindrome. ex: 121
let num = 121;
let temp = num;
let sum1 =0;
while(num > 0){
    let rem = num%10;
    sum1 = sum1*10 + rem;
    num = Math.floor(num / 10);
}
if(sum1 === temp){
    console.log("Palindrome");
} else {
console.log("Not Palindrome");
}
