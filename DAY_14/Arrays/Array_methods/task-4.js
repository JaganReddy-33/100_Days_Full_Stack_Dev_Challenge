
// Employees

const employees = [
  { id: 1, name: "John", salary: 50000, department: "IT" },
  { id: 2, name: "Mary", salary: 70000, department: "HR" },
  { id: 3, name: "David", salary: 40000, department: "IT" },
  { id: 4, name: "Sara", salary: 90000, department: "Finance" }
];

// Get employee names.
const getEmployees = employees.map((employee)=>employee.name);
console.log(getEmployees);


// Get employees earning above 60000.
const getSalary = employees.filter((employee)=>employee.salary > 60000);
console.log(getSalary);


// Find employee id = 3
const findEmployee = employees.find((employee)=>employee.id === 3);
console.log(findEmployee);


// Calculate total salary payout
const calTotal = employees.reduce((total, employee)=>{
    let salary = employee.salary;
     return total += salary;
}, 0);
console.log(calTotal);


//  Calculate average salary
const calAvg = employees.reduce((total, employee)=>{
    let salary = employee.salary;
    return total += salary;
}, 0);
let avg = calAvg / employees.length;
console.log(avg);   // console.log(calTotal / employees.length);


// Check if anyone earns above 100000
const checkSalary = employees.some((employee)=>employee.salary > 100000);
console.log(checkSalary);

// Get all IT employees
const getAllIt = employees.filter((employee)=>employee.department === "IT");
console.log(getAllIt);


// Get names of IT employees
const getNamesOfIt = employees
.filter((employee)=>employee.department === "IT")
.map((employee)=>employee.name);

console.log(getNamesOfIt);


// Find highest-paid employee
const highSalaryEmployee = employees.reduce((highSalary, currentSalary)=>{
    return highSalary.salary > currentSalary.salary ? highSalary : currentSalary;
});
console.log(highSalaryEmployee);

// Find lowest-paid employee
const lowSalaryEmployee = employees.reduce((currentSalary, lowSalary)=>{
    return currentSalary.salary < lowSalary.salary ? currentSalary : lowSalary;
});
console.log(lowSalaryEmployee);