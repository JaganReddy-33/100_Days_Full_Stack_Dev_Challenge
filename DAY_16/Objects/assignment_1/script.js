
//  Assignment 1: Student Management System

const student = {
  name: "Rohan",
  age: 21,
  marks: 78,
  course: "Full stack"
};

// 1. Update marks
student.marks = 89;

// 2. Add city
student.city = "Mumbai";

// 3. Delete course
delete student.course;

// 4. Print keys
console.log("Keys:", Object.keys(student));

// 5. Print values
console.log("Values:", Object.values(student));
