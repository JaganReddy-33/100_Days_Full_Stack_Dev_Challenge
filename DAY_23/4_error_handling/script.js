
// Error Handling

// Error handling allows your program to handle errors gracefully instead of crashing.

// 1. try block - it contains code that might produce an error.
try {
    console.log("Hello");
} catch (error) {
    console.log(error);
}


// catch block - it runs only if an error occurs inside try
try {
    console.log(name);

} catch (error) {
    console.error("Actual error: ", error);
    console.log("Something went wrong!");
}

// finally block - it always executes, whether an error occurs or not.
try {
    console.log("Inside try");
} catch (error) {
    console.log("Inside catch");
} finally {
    console.log("Inside Finally");
}

// throw - the throw keyword let's you create your own custom error
function checkAge(age) {
    if (age < 18) {
        throw "You are not Eligible";
    }
    console.log("Welcome");
}
try {
    checkAge(10);
} catch (error) {
    console.log(error);
}

function divide(a, b) {
    if (b === 0) {
        throw "Cannot divide by Zero";
    }
    return a / b;
}

try {
    console.log(divide(10, 0));
} catch (error) {
    console.log(error);
}


// error handling with async/await
function login(username, password) {
    return new Promise((resolve, reject) => {
        if (username === "admin" && password === "jmr@12") {
            resolve("Login Successful");
        } else {
            reject("Invalid Credentials");
        }
    });
}

async function start() {
    try {
        let username = "admin";
        let password = "jmr@123";
        if (username === "" || password === "") {
            throw "You must enter the credentials";
        }
        const res = await login(username, password);
        console.log(res);
    } catch (error) {
        console.log("Error caught: ", error.message || error);
    }
}
start();

function amountWithdrawal(balance, amount) {
    return new Promise((resolve, reject) => {
        if (amount > balance) {
            reject(new Error("Insufficient Balance"));
        } else {
            resolve("Withdrawal Successful");
        }
    });
}

// ATM Withdrawal
async function ATM() {
    try {
        let amount = 1500;
        let balance = 1000;
        if (amount <=0 || isNaN(amount) || !amount) {
            throw "Enter a valid amount to withdraw";
        }

        let res = await amountWithdrawal(balance, amount);
        console.log(res);
    } catch (error) {
        console.log("Error Caught: ", error.message || error);
    }
}
ATM();