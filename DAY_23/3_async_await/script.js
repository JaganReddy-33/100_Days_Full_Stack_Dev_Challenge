
// async and await


// Example 1 — Basic async
async function greet() {
    return "Hello";
}

greet().then(result => console.log(result));


// Example 2 — Basic await
async function welcome() {
    const message = await Promise.resolve("Welcome");
    console.log(message);
}

welcome();


// Example 3 — Number
async function number() {
    const num = await Promise.resolve(100);
    console.log(num);
}

number();


// Example 4 — Object
async function student() {
    const data = await Promise.resolve({
        name: "Jagan",
        age: 22
    });

    console.log(data);
}

student();


// Example 5 — Array
async function subjects() {
    const result = await Promise.resolve([
        "HTML",
        "CSS",
        "JavaScript"
    ]);

    console.log(result);
}

subjects();


// Example 6 — setTimeout with Promise
function download() {
    return new Promise((resolve) => {

        setTimeout(() => {
            resolve("Download Complete");
        }, 2000);

    });
}

async function startDownload() {
    const result = await download();
    console.log(result);
}

startDownload();


// Example 7 — Login
function login() {
    return Promise.resolve("Login Successful");
}

async function userLogin() {
    const result = await login();
    console.log(result);
}

userLogin();


// Example 8 — Sequential Await
function html() {
    return Promise.resolve("HTML");
}

function css() {
    return Promise.resolve("CSS");
}

async function course1() {

    const one = await html();
    console.log(one);

    const two = await css();
    console.log(two);

}

course1();


// Example 9 — Three Awaits
function js() {
    return Promise.resolve("JavaScript");
}

async function course2() {

    console.log(await html());
    console.log(await css());
    console.log(await js());

}

course2();


// Example 10 — Square
function square(num) {
    return Promise.resolve(num * num);
}

async function calculate() {

    const result = await square(8);

    console.log(result);

}

calculate();


// Example 11 — Addition
function add(a, b) {
    return Promise.resolve(a + b);
}

async function total() {

    const result = await add(20, 30);

    console.log(result);

}

total();


// Example 12 — Fake Payment
function payment() {

    return new Promise((resolve) => {

        setTimeout(() => {
            resolve("Payment Successful");
        }, 3000);

    });

}

async function pay() {

    console.log("Processing...");

    const result = await payment();

    console.log(result);

}

pay();


// Example 13 — Multiple Downloads
function file(name) {
    return Promise.resolve(`${name} Downloaded`);
}

async function files() {

    console.log(await file("HTML"));
    console.log(await file("CSS"));
    console.log(await file("JavaScript"));

}

files();


// Example 14 — Student Details
function studentData() {

    return Promise.resolve({
        name: "Jagan",
        age: 22,
        college: "SRIET"
    });

}

async function details() {

    const data = await studentData();

    console.log(data.name);
    console.log(data.age);
    console.log(data.college);

}

details();


// Example 15 — Login → Profile → Dashboard
function loginUser() {
    return Promise.resolve("Login Successful");
}

function profile() {
    return Promise.resolve("Profile Loaded");
}

function dashboard() {
    return Promise.resolve("Dashboard Loaded");
}

async function app() {

    console.log(await loginUser());
    console.log(await profile());
    console.log(await dashboard());

}

app();