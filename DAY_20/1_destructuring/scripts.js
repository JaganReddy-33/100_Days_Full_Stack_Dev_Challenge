
//  Array Destructuring

// Extract the first two elements from fruits into variables first and second.
const fruits = ['apple', 'banana', 'cherry', 'mango', 'guava'];

const[first, second] = fruits;
console.log(first);
console.log(second);



// Extract the first and third elements from numArr into variables a and b (skip the second).
const numArr = [10, 20, 30, 40, 50, 60];

const [a,  , b] = numArr;
console.log(a);
console.log(b);


// Swap the values of two variables x = 5 and y = 10 using array destructuring in one line.
let x=5;
let y=10;
[x, y] = [y, x];
console.log(`After swap: x = ${x}, y=${y}`);



// Extract the first element into head and the rest of the elements into an array tail from [1, 2, 3, 4, 5].
const arr = [1, 2, 3, 4, 5];
const[head, ...trail] = arr;
console.log(head);
console.log(trail);


// Destructure the third element from ['stone', 'paper'] into a variable weapon with a default value of 'scissors'.
const game = ['stone', 'paper'];
const[, , weapon='scissors'] = game;


// Object Destructuring

// Extract title and author from movie
const movie = {
    title: 'the Hobbit',
    author: 'Tolkien',
    year: 1937
};
const {title, author} = movie;
console.log(title);
console.log(author);


// Extract width and height from { width: 100, color: 'red' }, giving height a default value of 200.
const obj = {
    width: 100,
    color: 'red'
};
const {width, height=200} = obj;
console.log(width);
console.log(height);


// Extract type from { type: 'admin', active: true } but rename the variable to userRole.
const obj2 = {
    type: 'admin',
    active: true
};
const {type: userRole} = obj2;
console.log(userRole);


// Extract name and rename it to heroName, and extract power with a default value of 'flight' from { name: 'Batman' }.
const obj3 = {
    name: 'Batman'
};
const {name:heroName, power= 'flight'} = obj3;
console.log(heroName);
console.log(power);


// Extract id and all remaining properties into a new object called details from { id: 7, name: 'Laptop', price: 999, brand: 'Tech' }
const obj4 = {
    id: 7,
    name: 'Laptop',
    price: 99999,
    brand: 'Tech'
};
const { id, ...details } = obj4
console.log(details);



// Nested & Mixed Destructuring

// Extract the lat and lng values from this object?
const location = { 
    city: 'NY', 
    coords: { lat: 40.71, lng: -74.00 } 
};
const {coords : {lat, lng}} = location;
console.log(lat);
console.log(lng);


// Extract the second element of the tags array from this object into a variable called secondTag?
const post = { 
    id: 1, 
    tags: ['js', 'frontend', 'web'] 
};
const {tags: [, secondTag]} = post;
console.log(secondTag);


// Extract the name of the second user from this array?
const users = [
{ 
    name: 'Alice' 
}, 
{ 
    name: 'Bob' 
}
];
const [, {name}] = users;
console.log(name);


// Extract street and number from the nested structure, providing a default value of 1 for number?
const order = { 
    customer: { address: { street: 'Main St' } }
};
const {customer: {address : {street, number = 1}}} = order;
console.log(`${street} ${number}`);



// Function Parameter Destructuring

// Create a function wrapper where the parameter destructure username and status directly from the argument object.
const user = ({name, status})=>{
    console.log(`UserName: ${name}, status: ${status}`);
}
user({name: "Jagan", status: "admin"});
user({ name: "Sathi", status: "Job Seeker" });


// Create a function that accepts a configuration object, destructuring mode (default 'light') and pro (default false).
const toggle = ({mode = 'light', pro = false})=>{
    console.log(`mode: ${mode}, pro: ${pro}`);
}
toggle({});
toggle({ mode: 'dark', pro: true });
toggle({ pro: true });


// Destructure a nested id from an object passed into a function's item property: fn({ item: { id: 99 } }).
const fn = ({item: {id}})=>{
    console.log(`given id is ${id}`);
}
fn({item : {id: 99}});



