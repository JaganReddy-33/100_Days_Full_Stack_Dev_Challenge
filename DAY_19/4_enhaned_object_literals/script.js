// Basics ES5
const name = "Jagan";
const age = 22;
const student1 = {
    name: name,
    age: age
};
console.log(student1);


// Basics ES6
const student2 = {
    name,
    age
};
console.log(student2);


// Method Shorthand
const person = {
    name: "Jagan",
    greet() {
        console.log("Hello");
    }
};
person.greet();


// Dynamic Property Names
const key = "email";
const user = {
    name: "Jagan",
    [key]: "jmr@gmail.com"
};
console.log(user);


// Real-world Examples Student
const rollNo = 101;
const department = "ECE";
const studentExample = {
    name,
    age,
    rollNo,
    department
};
console.log(studentExample);


// Real-world Examples Employee
const companyName = "Google";
const salaryAmount = 80000;
const employeeExample = {
    name,
    company: companyName,
    salary: salaryAmount
};
console.log(employeeExample);


// Real-world Examples Product
const productNameExample = "Laptop";
const priceExample = 70000;
const productExample = {
    productName: productNameExample,
    price: priceExample
};
console.log(productExample);


// Real-world Examples Shopping Cart
const quantityExample = 2;
const cartExample = {
    productName: productNameExample,
    quantity: quantityExample,
    total() {
        return quantityExample * priceExample;
    }
};
console.log(cartExample.total());


// Real-world Examples User
const usernameExample = "JMR";
const profileExample = {
    username: usernameExample,
    login() {
        console.log(`${usernameExample} Logged In`);
    }
};
profileExample.login();



// 1. Student Object
const studentName = "Jagan";
const studentRollNo = 101;
const studentDept = "ECE";
const student = {
    studentName,
    rollNo: studentRollNo,
    department: studentDept
};
console.log(student);


// 2. Employee Object
const company = "Google";
const salary = 80000;
const employee = {
    company,
    salary
};
console.log(employee);


// 3. Product Object
const productName = "Laptop";
const price = 70000;
const product = {
    productName,
    price
};
console.log(product);


// 4. Shopping Cart
const quantity = 2;
const cart = {
    productName,
    quantity,
    total() {
        return this.quantity * price;
    }
};
console.log(cart.total());


// 5. Bank Account
const accountHolder = "Jagan";
const balance = 50000;
const accountKey = "acc_type";
const bankAccount = {
    accountHolder,
    balance,
    [accountKey]: "Savings",
    withdraw(amount) {
        this.balance -= amount;
        console.log(`Withdrew ${amount}. New balance: ${this.balance}`);
    }
};
bankAccount.withdraw(5000);


// 6. Movie Object
const title = "Inception";
const director = "Christopher Nolan";
const movie = {
    title,
    director,
    details() {
        console.log(`${this.title} directed by ${this.director}`);
    }
};
movie.details();


// 7. Car Object
const brand = "Tesla";
const model = "Model 3";
const car = {
    brand,
    model,
    start() {
        console.log(`${this.brand} ${this.model} is starting...`);
    }
};
car.start();


// 8. Book Object
const bookTitle = "Atomic Habits";
const author = "James Clear";
const book = {
    bookTitle,
    author
};
console.log(book);


// 9. College Object
const collegeName = "IIT Madras";
const cityKey = "location";
const college = {
    collegeName,
    [cityKey]: "Chennai"
};
console.log(college);


// 10. Mobile Object
const brandName = "Apple";
const storage = "128GB";
const mobile = {
    brandName,
    storage,
    specs() {
        console.log(`${this.brandName} with ${this.storage} storage`);
    }
};
mobile.specs();
