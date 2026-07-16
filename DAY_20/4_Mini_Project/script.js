const initialStudent = {
  id: 101,
  name: "Joy Keery",
  class: "Grade 10",
  contact: { email: "steve@mail.com", phone: "123-456" }
};

const term1Grades = { math: 85, science: 90 };
const term2Grades = { english: 78, history: 92, math: 95 };

const generateReport = (studentObj, ...gradeObjects) => {
  const { name: studentName, contact: { email } } = studentObj;
  
  const finalGrades = Object.assign({}, ...gradeObjects);
  
  const marks = Object.values(finalGrades);
  const totalMarks = marks.reduce((sum, current) => sum + current, 0);
  const averageMark = totalMarks / marks.length;

  return `
    <div class="report-header">
      <h2>Academic Performance</h2>
      <p>Student ID: #${studentObj.id}</p>
    </div>
    <div class="info-grid">
      <div class="info-item">
        <label>Student Name</label>
        <span>${studentName}</span>
      </div>
      <div class="info-item">
        <label>Email Address</label>
        <span>${email}</span>
      </div>
    </div>
    <div class="metrics-row">
      <div class="metric-box">
        <label>Total Marks</label>
        <div class="value">${totalMarks}</div>
      </div>
      <div class="metric-box">
        <label>Average</label>
        <div class="value">${averageMark.toFixed(1)}%</div>
      </div>
    </div>
  `;
};

document.getElementById('generateBtn').addEventListener('click', () => {
  const reportContainer = document.getElementById('reportOutput');
  const reportHtml = generateReport(initialStudent, term1Grades, term2Grades);
  
  reportContainer.innerHTML = reportHtml;
  reportContainer.classList.remove('hidden');
});
