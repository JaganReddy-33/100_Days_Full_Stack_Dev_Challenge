
const calculateSalaryDetails = (basic, customBonus) => {
    const bonus = customBonus ?? 5000; 
    const gstRate = 0.18;

    const grossSalary = basic + bonus;
    const gst = grossSalary * gstRate;
    const netSalary = grossSalary - gst;

    return {
        grossSalary,
        gst,
        netSalary,
        bonus
    };
};

const generateSlipHTML = (name, basic, bonus, gross, gst, net) => {
    return `
        <div class="slip-header">
            <h3>SALARY STATEMENT</h3>
            <p style="font-size: 0.8rem; color: #94a3b8;">Generated via ES6 System</p>
        </div>
        <div class="slip-row">
            <span>Employee Name:</span>
            <span class="value">${name}</span>
        </div>
        <div class="slip-row">
            <span>Basic Salary:</span>
            <span class="value">₹${basic.toFixed(2)}</span>
        </div>
        <div class="slip-row">
            <span>Bonus Applied:</span>
            <span class="value">₹${bonus.toFixed(2)}</span>
        </div>
        <div class="slip-row total-row">
            <span>Gross Salary:</span>
            <span class="value">₹${gross.toFixed(2)}</span>
        </div>
        <div class="slip-row">
            <span>GST Deduction (18%):</span>
            <span class="value" style="color: #f87171;">- ₹${gst.toFixed(2)}</span>
        </div>
        <div class="slip-row net-row">
            <span>Net Take-Home:</span>
            <span class="value">₹${net.toFixed(2)}</span>
        </div>
    `;
};


document.getElementById('generateBtn')
.addEventListener('click', () => {
    const empName = document.getElementById('empName').value.trim();
    const basicInput = document.getElementById('basicSalary').value;
    const bonusInput = document.getElementById('bonus').value;

    if (!empName || !basicInput) {
        alert("Please complete the required Employee Name and Basic Salary values.");
        return;
    }

    const basicSalary = parseFloat(basicInput);
    const customBonus = bonusInput === "" ? undefined : parseFloat(bonusInput);

    const { grossSalary, gst, netSalary, bonus } = calculateSalaryDetails(basicSalary, customBonus);

    // Render into the output target block node element
    const slipCard = document.getElementById('salarySlip');
    slipCard.innerHTML = generateSlipHTML(empName, basicSalary, bonus, grossSalary, gst, netSalary);
});
