
//  Break statement

// Print numbers from 1 to 100. Stop when you reach 50.
for(let i=1; i<=100; i++){
    if(i == 50){
        break;
    }
    console.log(i);
}


// Print numbers until you find the first number divisible by 17.
for(let i=1; i<=100; i++){
    if(i%17 == 0){
        break;
    }
    console.log(i);
}

// Stop after printing 10 even numbers.
let count = 0;
for(let i=2; i<=20; i+=2){
    console.log(i);
    count++;

    if(count === 10){
        break;
    }
}

// Print numbers from 1–100. Stop when you encounter 81.
for(let i=1; i<=100; i++){
    if(i === 81) break;
    console.log(i);
}


// Print multiplication table. Stop after 5 multiples.
for(let i=1; i<=10; i++){
    if(i === 6){
        break;
    }
    console.log(2 * i);
}

