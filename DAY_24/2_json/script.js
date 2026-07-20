
// Json() - it is a JavaScript Object Notation is a format used to store and exchange data between a client and server.
/* ex :  keys must be in double quotes
{
    "name" : "Jagan",
    "age" : 21,
    "college" : "SRIET"
} */

// Json.stringify() - converts a JavaScript Object to Json String
//  ex: 
const student = {
    name: "Jagan",
    age: 21
};
const json = JSON.stringify(student);
// console.log(json);


// JSON.parse() - converts a JSON string to JavaScript Object

const JsonString = '{"name":"Jagan","age":22}';

const JsObj = JSON.parse(JsonString);
// console.log(JsObj);
// console.log(JsObj.name);
// console.log(JsObj.age);

// Arrays to JSON
const numbers = [10, 20, 30];
const Json = JSON.stringify(numbers);
// console.log(Json);
// console.log(typeof Json);

// JSON Array to JS Object
const j = '[10,20,30,40]';
const arrNum = JSON.parse(j);
// console.log(arrNum);


// students array
const studentsArr = [
    { name: "Jagan", age: 22 },
    { name: "Ajay", age: 21 }
];
const jsonStr = JSON.stringify(studentsArr);
// console.log(jsonStr);


// Q1: student details
const stdDetails = {
    name: "Jagan",
    age:21,
    college: "SRIET"
};
// Json Object to Json String
const JsonStringFormat = JSON.stringify(stdDetails);
console.log(JsonStringFormat);

// Json String to Json Object
const JsonParseFormat = JSON.parse(JsonStringFormat);
console.log(JsonParseFormat);
console.log(JsonParseFormat.name);


// Q2. Employee Data - Convert it to JSON and back. then print employee name, dept
const employee = {
    id: 1,
    name: "Sathi",
    dept: "Software",
    salary: 40000
};

// Json Object to Json String
const JsonString2 = JSON.stringify(employee);
console.log(JsonString2);

// Json String to Json Object
const JsonObject2 = JSON.parse(JsonString2);
console.log(JsonObject2);
console.log(`${JsonObject2.name} => ${JsonObject2.dept}`);


// Q3. Product Information - convert to Json then back, then print total price
const product = {
    id: 1,
    name:"Laptop",
    price: 67000,
    quantity: 4
};

// Json Object to Json String
const JsonString3 = JSON.stringify(product);
console.log(JsonString3);

// Json String to Json Object
const JsonObject3 = JSON.parse(JsonString3);
console.log(JsonObject3);
console.log(`total Price -  ${JsonObject3.price * JsonObject3.quantity}`);


// Q4: Shopping Cart - crete an products array, convert into Json then back. print every product name.
const products = [
    {name: "Laptop", price:50000},
    {name: "Mouse", price:500},
    {name: "Keyboard", price: 1200}
];

// Json Object to Json String
const JsonString4 = JSON.stringify(products);
console.log(JsonString4);

// Json String to Json Object
const JsonObject4 = JSON.parse(JsonString4);
console.log(JsonObject4);
// JsonObject4.forEach(obj => {
//     console.log(obj.name);
// });
for(let i=0; i<JsonObject4.length; i++){
    console.log(JsonObject4[i].name);
}


// Q5: 
const login = {
    "success": true,
    "message":"Login Successful",
    "user" : {
        "id":101,
        "name":"Jagan"
    }
}

console.log(login);
console.log(login?.message ?? "No message found!");
console.log(login?.user?.id);









