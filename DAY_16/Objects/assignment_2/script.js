
// Assignment 2: Employee Database

const employees = [
  { id: 1, name: "Amit", salary: 60000 },
  { id: 2, name: "Priya", salary: 95000 },
  { id: 3, name: "Karan", salary: 45000 }
];

// 1. Highest salary
const highestSalaryEmp = employees.reduce((max, emp) => emp.salary > max.salary ? emp : max, employees[0]);
console.log("Highest Salary:", highestSalaryEmp);

// 2. Lowest salary
const lowestSalaryEmp = employees.reduce((min, emp) => emp.salary < min.salary ? emp : min, employees[0]);
console.log("Lowest Salary:", lowestSalaryEmp);

// 3. Average salary
const avgSalary = employees.reduce((sum, emp) => sum + emp.salary, 0) / employees.length;
console.log("Average Salary:", avgSalary);

// 4. Find employee by ID
const findEmployee = (id) => employees.find(emp => emp.id === id);
console.log("Find ID 2:", findEmployee(2));

// 5. Update salary
const updateSalary = (id, newSalary) => {
  const emp = employees.find(emp => emp.id === id);
  if (emp) emp.salary = newSalary;
};
updateSalary(3, 55000);
