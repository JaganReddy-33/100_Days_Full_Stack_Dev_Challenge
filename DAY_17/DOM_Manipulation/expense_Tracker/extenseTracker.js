


const itemName = document.getElementById("item-name");
const itemAmount = document.getElementById("item-amount");
const addBtn = document.getElementById("addBtn");
const itemList = document.getElementById("list");
const totalAmount = document.getElementById("total");

let sum = 0;
addBtn.addEventListener("click", ()=>{
    if(itemName.value.trim()==="" || itemAmount.value.trim() === ""){
        return;
    }

    let amount =  Number(itemAmount.value);

    if(amount <= 0){
        return;
    }

    let li = document.createElement("li");
    li.innerText = `${itemName.value} - ₹${itemAmount.value} `;


    let button = document.createElement("button");
    button.innerText = "Delete";

    button.addEventListener("click", ()=>{
        li.remove();
        sum -= amount;
        totalAmount.innerText = `Total: ₹${sum}`;
    });

    sum += amount;
    totalAmount.innerText = `Total: ₹${sum}`;

    li.appendChild(button);
    itemList.appendChild(li);

    itemName.value = "";
    itemAmount.value = "";

});