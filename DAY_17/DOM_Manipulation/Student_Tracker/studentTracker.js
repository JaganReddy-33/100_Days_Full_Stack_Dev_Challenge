const studentName = document.getElementById("student-name");
const studentMarks = document.getElementById("student-marks");
const addBtn = document.getElementById("addBtn");

const studentList = document.getElementById("list");

const avgMarks = document.getElementById("avg-marks");
const topper = document.getElementById("topper");

const search = document.getElementById("search");

const getMarks = document.getElementById("minMarks");

const filterBtn = document.getElementById("filterBtn");

const showAll = document.getElementById("showAllBtn");


let students = [];

// Add Student
addBtn.addEventListener("click", () => {

    let marks = Number(studentMarks.value);

    if (
        studentName.value.trim() === "" ||
        studentMarks.value.trim() === ""
    ) {
        return;
    }

    if (marks < 0 || marks > 100) {
        alert("Marks must be between 0 and 100");
        return;
    }

    students.push({
        name: studentName.value,
        marks: marks
    });

    renderStudents();
    updateStats();

    studentName.value = "";
    studentMarks.value = "";
});

// Search Student
search.addEventListener("input", () => {

    let value = search.value.trim();

    let filteredStudents;

    if (isNaN(value)) {

        // Search by name

        filteredStudents = students.filter((student) => {
            return student.name
                .toLowerCase()
                .includes(value.toLowerCase());
        });

    } else {

        // Search by marks

        let marks = Number(value);

        filteredStudents = students.filter((student) => {
            return student.marks >= marks;
        });
    }

    renderStudents(filteredStudents);
});


// filterBtn.addEventListener("click", ()=>{

//     if(getMarks.value.trim() === ""){
//         alert("Enter minimum marks");
//         return;
//     }

//     let enteredMarks = Number(getMarks.value);
//     if(isNaN(enteredMarks)){
//         return;
//     }

//     let filteredMarks = students.filter((student)=>{
//         return student.marks >= enteredMarks;
//     });
//     renderStudents(filteredMarks);
// });

showAll.addEventListener("click", () => {
    renderStudents();
})

// Render Students
function renderStudents(studentArray = students) {

    studentList.innerHTML = "";

    for (let i = 0; i < studentArray.length; i++) {

        let li = document.createElement("li");

        li.innerText =
            `${studentArray[i].name} - ${studentArray[i].marks}`;

        let deleteBtn = document.createElement("button");

        deleteBtn.innerText = "Delete";

        deleteBtn.addEventListener("click", () => {

            students = students.filter((student) => {
                return student !== studentArray[i];
            });

            renderStudents();
            updateStats();
        });

        li.appendChild(deleteBtn);

        studentList.appendChild(li);
    }
}

// Calculate Average
function calculateAverage() {

    if (students.length === 0) {
        return 0;
    }

    let total = students.reduce((sum, student) => {
        return sum + student.marks;
    }, 0);

    return total / students.length;
}

// Find Topper
function findTopper() {

    if (students.length === 0) {
        return null;
    }

    return students.reduce((best, current) => {
        return current.marks > best.marks
            ? current
            : best;
    });
}

// Update Stats
function updateStats() {

    let avg = calculateAverage();

    avgMarks.innerText =
        `Average Marks: ${avg.toFixed(2)}`;

    let topperStudent = findTopper();

    if (topperStudent) {
        topper.innerText =
            `Topper: ${topperStudent.name} (${topperStudent.marks})`;
    } else {
        topper.innerText = "Topper: None";
    }
}