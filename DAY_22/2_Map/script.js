

// Map - Collection

// What is a Map?
// A Map is a built-in JavaScript object used to store key-value pairs.

// Unlike objects:  
// Keys can be any data type (string, number, object, boolean, etc.).
// Maintains insertion order.
// Has useful built-in methods.



// Create a Map 2 types -
// 1. Empty Map
const std = new Map();
console.log(std);

// 2. Map With Initial Values 
const user = new Map([
    ["name", "Ajay"],
    ["age", 22],
    ["college", "SRIET"]
]);
console.log(user);

// Built in methods - set(), get(), delete(), clear(), has(), size.

const student = new Map();

// set() to add a data and to update also
student.set("name", "Jagan");
student.set("age", 22);
student.set("college", "SRIET");
console.log(student);

// If the key already exists, its value is updated.
student.set("age", 23);
student.set("name", "Jaganmohan");
console.log(student);

// get() - Returns the value associated with the given key.
console.log(student.get("age"));
console.log(student.get("Name")); // undefined, bcz we haven't added Name into Student Map
console.log(student.get("name"));

// delete() - to removes a key-value pair from the Map
console.log(student.delete("age"));
console.log(student);

// has() - check whether a key in the map
console.log(student.has("age"));
console.log(student.has("name"));

// clear() - Removes all key-value pairs.
student.clear();
console.log(student);

// size - is a property, not method to find out the size of the map
console.log(student.size);


// practice ex 

const map = new Map();

map.set("HTML", 1);
map.set("CSS", 2);
map.set("JS", 3);

console.log(map.has("CSS"));
console.log(map.get("CSS"));

map.set("CSS", 10);

console.log(map.get("CSS"));

console.log(map.has("React"));
console.log(map.get("React")); // undefined


// 2
const map1 = new Map();

map1.set("a", 10);
map1.set("b", 20);
map1.set("c", 30);

map1.delete("b");
map1.set("b", 40);

console.log(map1);

map1.set("Laptop", 60000);
map1.set("Mobile", 25000);

console.log(map1);


// 3
const map2 = new Map();

map2.set("name", "Jagan");
map2.set("age", 22);
map2.set("city", "Chennai");

console.log(map2.get("name"));

map2.set("city", "Bangalore");


for (const [key, value] of map2) {
    console.log(`${key} : ${value}`);
}







