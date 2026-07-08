
//  continue statement

//  Print numbers from 1 to 20. Skip 10.
for (let i = 1; i <= 15; i++) {
    if (i === 10) {
        continue;
    }
    console.log(i);     
}


//  Print numbers from 1 to 100. Skip multiples of 3.
for (let i = 1; i <= 30; i++) {
    if (i % 3 === 0) {
        continue;
    }
    console.log(i);    
}


// Print even numbers. Skip numbers divisible by 4.
for (let i = 1; i <= 40; i++) {
    if (i % 2 !== 0) {
        continue;
    }
    if (i % 4 === 0) {
        continue; 
    }
    console.log(i);
}

// Print numbers from 1 to 50. Skip all odd numbers.
for (let i = 1; i <= 50; i++) {
    if (i % 2 !== 0) {
        continue;
    }
    console.log(i);
}


// Print multiplication table of 8. Skip 8 × 5.
for (let i = 1; i <= 10; i++) {
    if (i === 5) {
        continue;
    }
    console.log(`8 x ${i} = ${8 * i}`);
}


// Print numbers from 50 to 100. Skip numbers ending in 5.
for (let i = 50; i <= 100; i++) {
    if (i % 10 === 5) {
        continue;
    }
    console.log(i);
}


// Print numbers from 1 to 100. Skip all numbers divisible by 2 and 3.
for (let i = 1; i <= 100; i++) {
    if (i % 2 === 0 && i % 3 === 0) {
        continue;
    }
    console.log(i);
}