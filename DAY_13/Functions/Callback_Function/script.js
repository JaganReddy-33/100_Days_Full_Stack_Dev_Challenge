
// CALLBACK FUNCTIONS


// 1. Greeting callback
const userGreeting = (name, callback) => {
  const message = `Welcome, ${name}`;
  callback(message);
};
userGreeting("Alice", msg => console.log(msg));


// 2. Calculator callback
const calculate = (num1, num2, operationCallback) => {
  return operationCallback(num1, num2);
};
let res = calculate(5, 3, (a, b) => a + b);
console.log(res);



// 3. Student callback
const processStudentData = (student, callback) => {
  const report = `Student ${student.name} scored ${student.grade}%`;
  callback(report);
};
processStudentData({name: "John", grade: 85}, res => console.log(res));


// 4. Print message callback
const fetchMessage = (callback) => {
  const msg = "System status: Operational";
  callback(msg);
};
fetchMessage(msg => console.log(msg));


// 5. Execute callback after another function
const firstFunction = (callback) => {
  console.log("First function executed.");
  callback();
};
firstFunction(() => console.log("Second function executed."));
