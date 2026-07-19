
//  promises - 

/*
A Promise represents the eventual result of an asynchronous operation.

It can be in one of three states:

Pending → Still waiting.
Fulfilled → Operation completed successfully.
Rejected → Operation failed.
*/


//  basic promise
// promise resolved
const promise = new Promise((resolve, reject)=>{
    resolve("Promise resolved!");
});

promise.then(res =>{
    console.log(res);
});

// promise rejected
const prom = new Promise((resolve, reject)=>{
    reject("Promise rejected");
});

prom.catch(err =>{
    console.log(err);
});

// login success
const login = new Promise((resolve, reject)=>{
    let success = true;
    if(success){
        console.log("Login Successful");
    } else {
        console.log("Invalid Credentials");
    }
});

login
.then(res => console.log(res))
.catch(err => console.log(err));


// using .finally()
const pro = Promise.resolve("Task Completed!");
pro.then(res => console.log(res))
.finally(()=>console.log("Finished"));


// promise chaining
Promise.resolve("Step 1")
.then(res => {
    console.log(res);
    return "step 2";
})
.then(res => {
    console.log(res);
    return "Step 3";
})
.then(res =>{
    console.log(res);
    return "Step 4";
})
.then(res => {
    console.log(res);
});

// promise.all()
const p1 = Promise.resolve("HTML");
const p2 = Promise.resolve("CSS");
const p3 = Promise.resolve("JavaScript");

Promise.all([p1, p2, p3])
.then(result => {
    console.log(result);
});

// promise.race()
const p11 = new Promise(resolve =>
    setTimeout(() => resolve("First"), 1000)
);

const p22 = new Promise(resolve =>
    setTimeout(() => resolve("Second"), 2000)
);

Promise.race([p11, p22])
.then(result => console.log(result));

// promise.allSettled()
const a1 = Promise.resolve("React");
const a2 = Promise.reject("Error");

Promise.allSettled([a1, a2])
.then(result => {
    console.log(result);
});

// payment simulation
function payment(){

    return new Promise((resolve, reject) => {

        let paid = true;

        if(paid){
            resolve("Payment Successful");
        }else{
            reject("Payment Failed");
        }

    });

}
payment()
.then(result => console.log(result))
.catch(error => console.log(error));


// multiple .then()
Promise.resolve(10)
.then(num => num * 2)
.then(num => num + 5)
.then(num => console.log(num));