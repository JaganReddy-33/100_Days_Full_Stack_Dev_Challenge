
// for loop

// for(initialization; condition; increment/decrement){
//     body (activity);
// }

// print numbers from 1 to 20;

for(let i=1; i<=20; i++){
    console.log(i);
}



// print numbers from 20 to 1;
for(let i=20; i>=1; i--){
    console.log(i);
    
}



// Print all even numbers between 1 and 100
for(let i=1; i<=100; i++){
    if(i%2 == 0){
        console.log("even number",i);
        
    }
}




// print the multiplication table of 5 number.
for(let i=1; i<=10; i++){
    console.log(5 + " x " + i + " = " + (5*i));
}



// Find the sum of numbers from 1 to 100.
let sum = 0;
for(let i=1; i<=100; i++){
    sum += i;
}
console.log("total sum from 1 to 100:", sum);



//  Print the square of numbers from 1 to 20.
for(let i=1; i<=20; i++){
    console.log( `square of ${i} is :`,i*i);
}



// Print this pattern
// *
// **
// ***
// ****
// *****

for(let i=1; i<=5; i++){
    let row = "";
    for(let j=1; j<=i; j++){
        row += "*";
    }
    console.log(row); 
}


//  Number pyramid:
// 1
// 12
// 123
// 1234
// 12345
for(let i=1; i<=5; i++){
    let row = "";
    for(let j=1; j<=i; j++){
        row += j;
    }
    console.log(row);
}

console.log("\n");

for(let i=5; i>=1; i--){
    let row = "";
    for(let j=1; j<=i; j++){
        row += j;
    }
    console.log(row);
}
