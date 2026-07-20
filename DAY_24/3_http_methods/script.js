
// http methods - HTTP methods tell the server what action you want to perform.
/*
GET - Read data - fetch data
POST - Create data - Add new Data
PUT - Update data - Update existing data
DELETE - Delete - Delete existing data
*/

// GET req - fetch data from the server
async function getUsers() {
    const res = await fetch("https://jsonplaceholder.typicode.com/users");

    const user = await res.json();
    // console.log(user);
}
getUsers();

// POST req - used to create new data.
const newUser = {
    name: "Jagan",
    email: "jagan@gmail.com"
};

fetch("https://jsonplaceholder.typicode.com/users", {
    method: "POST",
    headers: {
        "content-Type": "application/json"
    },
    body: JSON.stringify(newUser)
})
    .then(res => res.json())
    .then(data => {
        // console.log(data);
    });

// PUT req - used to update the existing data
const updateUser = {
    name: "Jaganmohan Reddy"
};

fetch("https://jsonplaceholder.typicode.com/users/10", {
    method: "PUT",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify(updateUser)
})
    .then(res => res.json())
    .then(data => {
        // console.log(data);
    });

// DELETE - Used to delete data
fetch("https://jsonplaceholder.typicode.com/users/3", {
    method: "DELETE"
})
    .then(res => {
        // console.log("Deleted Successfully");
    });



// practice questions
// 1 fetch user details
async function users() {
    const res = await fetch("https://jsonplaceholder.typicode.com/users");

    const users = await res.json();
    // console.log(user);
    users.forEach(user => {
        // console.log(`
        //     Username : ${user.name}
        //     Email    : ${user.email}
        //     Phone    : ${user.phone}
        //     ========================
        // `);
    });

}
users();


// 2. fetch weather data.
async function getWeather(city) {
    try {
        const res = await fetch(`https://wttr.in/${city}?format=j1`);
        if(!res.ok){
            throw new Error("Failed to fetch weather data");
        }
        const data = await res.json();
        // console.log(data);

        const current = data.current_condition[0];

    //     console.log(`
    //     City        : ${city.toUpperCase()}
    //     Temperature : ${current.temp_C}°C
    //     Humidity    : ${current.humidity}%
    //     Condition   : ${current.weatherDesc[0].value}
    // `);
    } catch (error) {
        console.log("Caught error: ", error.message || error);
    }

}
getWeather("Coimbatore");


// student Registration
async function stdRegistration(newStd) {
    try {
        const res = await fetch("https://typicode.com", {
            method: "POST",
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify(newStd)
        });

        if(!res.ok){
            throw new Error(`HTTP error! Status : ${res.status}`);
        }

        const data = await res.json();
        console.log("Registration Successful", data);
        
    } catch (error) {
        console.log("Registration Failed:", error || error.message);
    }
}
const newStd = {
    name: "Jagan",
    age: 21,
    dept: "ECE"
};
stdRegistration(newStd);