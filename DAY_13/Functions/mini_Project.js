
// Student Result Calculator
function calculateStudentResult(marks, displayCallback) {
    const maxMarksPerSubject = 100;

    const totalMarks = marks;
    const percentage = (marks / maxMarksPerSubject) * 100;
    const status = marks >= 40 ? "Pass" : "Fail";

    const getGrade = (score) => {
        if (score >= 90) return "A+";
        if (score >= 80) return "A";
        if (score >= 70) return "B+";
        if (score >= 60) return "B";
        if (score >= 50) return "C+";
        if (score >= 40) return "C";
        return "E";
    };

    const grade = getGrade(marks);

    const result = {
        totalMarks: totalMarks,
        percentage: percentage.toFixed(1) + "%",
        grade: grade,
        status: status
    };

    displayCallback(result);
}

const printResult = (output) => {
    console.log("=== Student Result ===");
    console.log(`Total Marks : ${output.totalMarks}`);
    console.log(`Percentage  : ${output.percentage}`);
    console.log(`Grade       : ${output.grade}`);
    console.log(`Status      : ${output.status}`);
};

const inputMarks = 69;
calculateStudentResult(inputMarks, printResult);