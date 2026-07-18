
// for...in -
// loop is used to iterate over the keys (property names) of an object.

// Using for...in with Objects
const student = {
    name: "Jagan",
    age: 21,
    College: "SRIET"
};

// returns keys
for(const key in student){
    console.log(key);
}

// returns keys, use bracket notation to access value
for(const key in student){
    console.log(`${key}: ${student[key]}`);
}


// Using for...in with Arrays
const fruits = ["Apple", "Banana", "Mango"];
for(const index in fruits){
    console.log(index);
}

// to get values 
for (const index in fruits) {
    console.log(fruits[index]);
}


// Nested Objects
const user = {
    name: "Jagan",
    age: 21,
    city: "Bangalore"
};
for(const key in user){
    console.log(`${key}: ${user[key]}`);
}

// break
for (const key in user) {
    if (key === "city") break;

    console.log(key, student[key]);
}

// continue
for(const key in user){
    if(key === "age") continue;
    console.log(`${key}: ${user[key]}`);
    
}


// 
const marks = {
    Math: 95,
    Science: 90,
    English: 88
};

for (const subject in marks) {
    console.log(subject, marks[subject]);
}

// 
const employee = {
    id: 101,
    name: "Rahul",
    salary: 50000
};

for (const key in employee) {
    if (key === "salary") break;

    console.log(key, employee[key]);
}

for (const key in employee) {
    if (key === "name") continue;

    console.log(key, employee[key]);
}


// 
const mobile = {
    brand: "Samsung",
    model: "S24",
    price: 70000
};

for (const key in mobile) {
    console.log(`${key} => ${mobile[key]}`);
}


// 
const car = {
    brand: "Toyota",
    color: "Black",
    year: 2024
};

for (const key in car) {
    console.log(key.toUpperCase(), car[key]);
}