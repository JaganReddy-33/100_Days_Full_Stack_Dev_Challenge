
// for... of - 

// The for...of loop is used to iterate over the values of iterable objects.

// using for...of with arrays
const numbers = [10, 20, 30, 40, 50];
for(const num of numbers){
    console.log(num);
}


// Using for...of with Strings
const name = "Jagan";
for(const ch of name){
    console.log(ch);
}


// using for...of with Sets
const colors = new Set(["red", "blue", "green", "yellow"]);
for(const color of colors){
    console.log(color);
}


// using for...of with Maps
const student = new Map();
student.set("name", "Jagan");
student.set("age", 21);
student.set("College", "SRIET");

for(const [key, value] of student){
    console.log(`${key} : ${value}`);
}


// using break 
const numbers2 = [10, 20, 30, 40, 50];

for (const num of numbers2) {
    if (num === 30) {
        break;
    }
    console.log(num);
}

// using continue
const numbers3 = [10, 20, 30, 40, 50];

for (const num of numbers3) {
    if (num === 30) {
        continue;
    }

    console.log(num);
}

// Practice questions

const word = "JavaScript";
for (const ch of word) {
    console.log(ch);
}

// 
const cities = new Set(["Chennai", "Bangalore", "Hyderabad"]);
for (const city of cities) {
    console.log(city);
}


// 
const languages = ["HTML", "CSS", "JavaScript", "React"];
for (const lang of languages) {
    console.log(lang.toUpperCase());
}

// 
const marks = [90, 85, 70, 95];

let total = 0;
for (const mark of marks) {
    total += mark;
}
console.log(total);