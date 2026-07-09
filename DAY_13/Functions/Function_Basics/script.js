
// Function Basics

// Create a function to print your name.
function printName() {
    console.log("Jaganmohan");
}
printName();


// Create a function to print "Hello JavaScript".
function print() {
    console.log("Hello, JavaScript");
}
print();


// Create a function that prints numbers from 1–10.
function printNumbers() {
    for(let i=1; i<=10; i++){
        console.log(i);
    }
}
printNumbers();


// Create a function to print even numbers.
function  printEven() {
    for(let i=0; i<=10; i+=2){
        console.log(i);
    }
}
printEven();

// Create a function to print odd numbers.
function printOdd() {
    for(let i=1; i<=10; i+=2){
        console.log(i);
    }
}
printOdd();


// Print your college details.
function collegeDetails() {
    let collegeName ="SRIET";
    let location = "Coimbatore";
    console.log("College Name:", collegeName);
    console.log("Location:", location);
}
collegeDetails();


// Print your favorite programming language.
function progLang() {
    let programming = "JavaScript";
    console.log("Fav Programming Language:",programming);
}
progLang();

// Print today's date.
function date() {
    let todayDate = new Date();
    console.log(todayDate);
}
date();

// Print a welcome message.
function  welcome() {
    let msg = "Welcome! Mr. JMR";
    console.log(msg);
}
welcome();

// Call one function multiple times.
function  func() {
    console.log("welcome to 100 days Full stack development challenge!");
}
func();
func();
func();
func();
func();
func();
func();
func();
