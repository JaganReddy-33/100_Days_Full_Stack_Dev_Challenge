

//Mini_Project:  STUDENT DATA MANAGER

/*
Features: 
1. Students stored inside Map
2. Subjects stored inside Set
3. Print students using for...of
4. Print student object using for...in
5. Prevent duplicate subjects
6. Display Total Subjects
7. Display Student Information 

*/

// 1. Students stored inside Map 
const students = new Map();
students.set(101, {
    name: "Jagan",
    age: 21,
    College: "SRIET",
    subjects: new Set()
});

students.set(102, {
    name: "Ajay",
    age: 22,
    College: "SRIET",
    subjects: new Set()
});

students.set(103, {
    name: "Lohith",
    age: 23,
    College: "SRIET",
    subjects: new Set()
});

students.set(104, {
    name: "Sathi",
    age: 21,
    College: "SRIET",
    subjects: new Set()
});

// 2. Subjects stored inside Set
students.get(101).subjects.add("Html").add("Css").add("JS").add("Css");

students.get(102).subjects.add("React").add("Html").add("Html").add("CSS").add("Node.js");

students.get(103).subjects.add("Html").add("Js").add("CSS").add("Node.js").add("Computer Basics").add("MongoDB");

students.get(104).subjects.add("Node.js").add("Js").add("React.js").add("Express.js").add("Computer networks").add("MongoDB").add("DSA");

// console.log(students);


// 3. Print students using for...of
for(const [id, student] of students){
    console.log(`${id} => `, student);
}


// 4. Print student object using for...in
for(const [id, student] of students){
    for(const key in student){
        console.log(`${key}:`,student[key]);
    }
}

// 5. Prevent duplicate subjects
for(const [id, student] of students){
    for(const key in student){
        if(key === "subjects"){
            for(const subject of student.subjects){
                console.log("student subjects:", subject);
            }
            console.log("----------------");
            
        }
    }
}

// Display Total Subjects
for(const [id, student] of students){
    console.log(`Student ID: ${id}`);
    console.log(`Total Subjects: ${student.subjects.size}`);
    console.log("--------------------");
}

// Display Student Information

for(const [id, student] of students){
    console.log("========================");
    console.log(`Student ID : ${id}`);
    for(const key in student){
        if (key === "subjects") {
            console.log("Subjects:");
            for(const subject of student.subjects){
                console.log(`- ${subject}`);
            }
            console.log(`Total Subjects : ${student.subjects.size}`);
        } else {

            console.log(`${key} : ${student[key]}`);

        }
    }
    console.log("========================\n");
}

