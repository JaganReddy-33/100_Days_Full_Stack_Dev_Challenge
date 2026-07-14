const userInput = document.getElementById("UserInput");
const userAmount = document.getElementById("userAmount");
const addBtn = document.getElementById("addBtn");
const itemList = document.getElementById("itemList");
const total = document.getElementById("totalAmount");

let expenses = JSON.parse(localStorage.getItem("expenses")) || [];
console.log(expenses);

renderExpenses();

addBtn.addEventListener("click", () => {
    let input = userInput.value.trim();
    let amount = Number(userAmount.value);
    // console.log(typeof amount);

    if (input === "" || userAmount.value.trim() === "") {
        alert("Enter your title and amount!");
        return;
    }
    if(amount <= 0){
    alert(
        "Amount must be greater than 0"
    );
    return;
}

    expenses.push({
        title: input,
        amount: amount
    });

    saveExpenses();
    renderExpenses();

    userInput.value = "";
    userAmount.value = "";
    userInput.focus();

});


userAmount.addEventListener("keydown", (event) => {
    if (event.key === "Enter" && userInput.value.trim() !== "" && userAmount.value.trim() !== "") {
        addBtn.click();
    }
});


function renderExpenses() {
    itemList.innerHTML = "";

    let totalAmount = expenses.reduce((total, expense)=>{
        return total+expense.amount;
    }, 0);

    total.innerText = `Your's total amount is: ₹${totalAmount}`

    for (let i = 0; i < expenses.length; i++) {
        let li = document.createElement("li");
        li.innerText = `${expenses[i].title} - ₹${expenses[i].amount}`;

        let deleteBtn = document.createElement("button");
        deleteBtn.innerText = "Delete";

        deleteBtn.addEventListener("click", () => {
            expenses = expenses.filter((_, index) => {
                return index !== i;
            });

            saveExpenses();
            renderExpenses();
        });

        li.appendChild(deleteBtn);
        itemList.appendChild(li);
    }
}


function saveExpenses() {
    localStorage.setItem("expenses", JSON.stringify(expenses));
}