
// fetch() API - fetch() is JavaScript built-in function for making HTTP request.
// API - Application programming interface is a bridge that allows two applications to communicate.

// basic fetch (.then());
fetch("https://jsonplaceholder.typicode.com/users")
.then(res => res.json())
.then(data => {
    // console.log(data)
});

// basic fetch (async/await);
async function getUser(){
    const res = await fetch("https://jsonplaceholder.typicode.com/users");
    const data = await res.json();
    // console.log(data);
}
getUser();


// print all user names and emails, usernames;
async function getUserName(){
    const res = await fetch("https://jsonplaceholder.typicode.com/users");
    const users = await res.json();

    users.forEach(user => {
        // console.log(`${user.name} - ${user.email}`);
        // console.log(`${user.username}`);
        // console.log("========================"); 
    });    
}
getUserName();


// find user by ID;
async function findById(randomId) {
    const response = await fetch(`https://jsonplaceholder.typicode.com/users/${randomId}`);
    // console.log("Status: ",response.status);
    // console.log(response.ok);
    
    const user = await response.json();
    console.log(user);
    // console.log("company name:",user.company.name);
    
}
const id= [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
const randomId =Math.floor(Math.random()*id.length); 
findById(randomId);


// error handling and loading message
async function users(){
    try {
        // console.log("Loading...."); 
        
        const res = await fetch("https://jsonplaceholder.typicode.com/user");
        if(!res.ok){
            throw new Error("API Not Found!");
        }
        const data = await res.json();
        for(const user of data){
            // console.log(user);
        }
        
    } catch (error) {
        // console.log(error.message || error);
    }
}
users();


// complete user information

async function usersInfo() {
    try {
        // console.log("Loading....");
        const res = await fetch("https://jsonplaceholder.typicode.com/users");

        if(!res.ok){
            // throw new Error("API not found!");
        }

        const users = await res.json();

        users.forEach(user => {
            // console.log(`
            //     Name     : ${user.name}
            //     username : ${user.username}
            //     Email    : ${user.email}
            //     Phone    : ${user.phone}
            //     Website  : ${user.website}
            //     Company  : ${user.company.name}
            //     City     : ${user.address.city}
            //     =============================
            // `);
            
        });

    } catch (error) {
        // console.log(error.message || error);
    }
}
usersInfo();