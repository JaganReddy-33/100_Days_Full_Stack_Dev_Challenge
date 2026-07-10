
// Traversing (10)
const arr = [1, 2, 3, 4, 5, 6];

// Print all values
console.log("Original Array: ");
for(let i=0;i<arr.length; i++){
    console.log(arr[i]);;
}


// Reverse traversal
console.log("Reversed Array: ");
for(let i=arr.length-1; i>=0; i--){
    console.log(arr[i]);
}


// Sum
let sum = 0;
for(let i=0; i<arr.length; i++){
    sum += arr[i];
}
console.log("Total Sum: ", sum);


// Average
console.log("Average of Array: ");
let avg = sum / arr.length;
console.log(avg);


// Maximum
console.log("Max Numbers: ");
let max = arr.reduce((accumulator, current)=>{
    return current > accumulator ? current : accumulator;
}, -Infinity)

console.log(max);


// Minimum
console.log("Min Numbers: ");
let min = arr.reduce((accumulator, current)=>{
    return current < accumulator ? current : accumulator;
}, +Infinity)

console.log(min);


// Even numbers
console.log("Even Numbers: ");
for(let i=0; i<arr.length; i++){
    if(arr[i]%2 == 0){
        console.log(arr[i]);
    }
}


// Odd numbers
console.log("Odd Numbers: ");
for(let i=0; i<arr.length; i++){
    if(arr[i]%2 != 0){
        console.log(arr[i]);
    }
}


// Count positives
console.log("Count Positive Numbers: ");

const arr1 = [1, 3, -6, -3, 3, 2, 8, 9];
let count =0;
for(let i=0; i<arr1.length; i++){
    if(arr[i] > 0){
        count++;
    }
}
console.log(count);

// Count negatives
console.log("Count Negative Numbers: ");
let count1 = 0;
for(let i=0; i<arr1.length; i++){
    if(arr1[i] < 0){
        count1++;
    }
}
console.log(count1);

