
// Students 

const students = [
  { id: 1, name: "Jagan", marks: 85, active: true },
  { id: 2, name: "Rahul", marks: 45, active: false },
  { id: 3, name: "Priya", marks: 92, active: true },
  { id: 4, name: "Alex", marks: 67, active: true }
];

// Get all student names.
const allStudentNames = students.map((student)=>student.name);
console.log(allStudentNames);

// Get students with marks above 60.
const getStudentMarks = students.filter((student)=>student.marks > 60);
console.log(getStudentMarks);

// Find student with id = 2.
const findStudent = students.find((student)=>student.id === 2);
console.log(findStudent);

// Check if any student scored above 90
const checkStudentScore = students.some((student)=>student.marks > 90 );
console.log(checkStudentScore);

// Count active students
const countActiveStudents = students.reduce((count, student)=>{
    let activeStudents = student.active === true;
    let totalCount  = count += activeStudents;
    return totalCount;
}, 0);
console.log(countActiveStudents);

// Calculate average marks
const calAvgMarks = students.reduce((total, student)=>{
    total += student.marks;
    return total;
}, 0);
let res = calAvgMarks / students.length;
console.log(res);


// Return names of active students.
const activeStudentNames = students.filter((student)=>student.active === true);
console.log(activeStudentNames);


// Find the topper
const findTopper = students.reduce((bestStudent, currentStudent)=>{
    return currentStudent.marks > bestStudent.marks ? currentStudent : bestStudent;
});
console.log(findTopper);


// find the lowest scorer
const findLowestMarks = students.reduce((currentStudentMarks, lowestStudentMarks)=>{
    return currentStudentMarks.marks < lowestStudentMarks.marks ? currentStudentMarks : lowestStudentMarks;
});
console.log(findLowestMarks);

// count students who failed (<50)
const failedStudents = students.reduce((count, student)=>{
    return count += student.marks < 50;
}, 0);
console.log(failedStudents); 