
// do while loop

// Q1: Print numbers from 1 to 10.
let i1 = 1;
do {
    console.log(i1);
    i1++;
} while (i1 <= 10);


// Q2: Print numbers from 10 to 1.
let i2 = 10;
do {
    console.log(i2);
    i2--;
} while (i2 >= 1);



// Q3: Print multiples of 5 up to 100.
let i3 = 5;
do {
    console.log(i3);
    i3 += 5;
} while (i3 <= 100);



// Q4: Print the multiplication table of 9.
let i4 = 1;
do {
    console.log(`9 x ${i4} = ${9 * i4}`);
    i4++;
} while (i4 <= 10);



// Q5: Find factorial of a number (Example: 5).
let num5 = 5; 
let factorial = 1;
let i5 = num5;
do {
    factorial *= i5;
    i5--;
} while (i5 > 0);
console.log(factorial);



// Q6: Print cubes from 1 to 10.
let i6 = 1;
do {
    console.log(i6 * i6 * i6);
    i6++;
} while (i6 <= 10);


// Q7: Print this pattern: 
// 5
// 44 
// 333 
// 2222
// 11111

let row = 5;
let totalRows = 5;
do {
    let col = 1;
    let rowString = "";
    let timesToPrint = totalRows - row + 1;
    do {
        rowString += row;
        col++;
    } while (col <= timesToPrint);
    console.log(rowString);
    row--;
} while (row >= 1);
