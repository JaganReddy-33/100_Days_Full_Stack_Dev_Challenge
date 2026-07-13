
// task: 1

const title = document.getElementById("title");
const btn = document.getElementById("btn");

btn.addEventListener("click", function(){
    title.innerText = "DOM Master";
});


// task: 2

const para = document.getElementById("para");
const redBtn = document.getElementById("redBtn");
const blueBtn = document.getElementById("blueBtn");

redBtn.addEventListener("click", function(){
    para.style.color = 'red';
    // para.style.backgroundColor = 'black';
});

blueBtn.addEventListener("click", function(){
    para.style.color = 'blue';
    // para.style.backgroundColor = 'black';
});


// task: 3
const input = document.getElementById("name");
const output = document.getElementById("output");

input.addEventListener("input", function(){
    output.innerText = input.value;
});


// task: 4
const task = document.getElementById("task");
const addBtn = document.getElementById("addBtn");
const list = document.getElementById("list");

addBtn.addEventListener("click", ()=>{

    if(task.value.trim() === ""){
        return;
    }

    let li = document.createElement("li");
    li.innerText = task.value;
    let deleteBtn = document.createElement("button");
    deleteBtn.innerText = "Delete";
    let markBtn = document.createElement("button");
    markBtn.innerText = "Mark Completed!";
    
    deleteBtn.addEventListener("click", ()=>{
        li.remove();
    });

    markBtn.addEventListener("click", ()=>{
        li.style.textDecoration = "line-through";
    });

    list.appendChild(li);
    li.appendChild(deleteBtn);
    li.appendChild(markBtn);
    task.value = "";
});



// task: 5
const display = document.getElementById("count");
const incBtn = document.getElementById("inc");
const decBtn = document.getElementById("dec");
const resetBtn = document.getElementById("reset");

let count = 0;
display.innerText = count;

incBtn.addEventListener("click", ()=>{
    count++;
    display.innerText = count;
});

decBtn.addEventListener("click", ()=>{
    count--;
    display.innerText = count;
});

resetBtn.addEventListener("click", () => {
    count = 0;
    display.innerText = count;
});


// task: 6
const password = document.getElementById("password");
const toggle = document.getElementById("toggle");

toggle.addEventListener("click", ()=>{
    if(password.type == "password"){
        password.type = "text";
        toggle.innerText = "Hide"
    } else {
        password.type = "password";
        toggle.innerText = "Show";
    }
});


// task: 7
const message = document.getElementById("message");
const charLen = document.getElementById("countChar");

message.addEventListener("input", ()=>{
    charLen.innerText = `${message.value.length} / 100 Characters`;

    if(message.value.length === 100){
        charLen.style.color = "red";
    } else {
        charLen.style.color = "";
    }
});


// task: 8
const search = document.getElementById("search");
const items = document.querySelectorAll("#list li");

search.addEventListener("input", ()=>{

    for(let i=0; i<items.length; i++){
        let item = items[i];
        if(item.innerText.toLowerCase().includes(search.value.toLowerCase())){
            item.style.display = "";
        } else {
            item.style.display = "none";
        }
    }
});


// task: 9
const themeBtn = document.getElementById("themeBtn");

let isDark = false;

themeBtn.addEventListener("click", ()=>{
    if(!isDark){
        document.body.style.backgroundColor = "black";
        document.body.style.color = "red";
        isDark = true;
    } else {
        document.body.style.backgroundColor = "white";
        document.body.style.color = "black";
        isDark = false;
    }
});


// task: 10
const nameInput = document.getElementById("studentName");
const addStudentBtn = document.getElementById("addStudent");
const studentList = document.getElementById("studentList");

addStudentBtn.addEventListener("click", ()=>{
   if(nameInput.value.trim() === ""){
    return;
   } 

   let li = document.createElement("li");
   li.innerText = nameInput.value;

   studentList.appendChild(li);

   nameInput.value = "";
});



// task: 11
const ageInput = document.getElementById("age");
const checkAgeBtn = document.getElementById("check");
const result = document.getElementById("result");

checkAgeBtn.addEventListener("click", ()=>{
    if(ageInput.value >= 18){
        result.innerText = "Adult"; 
    } else {
        result.innerText = "Minor";
    }
});


// task: 12

const colorBtn = document.getElementById("colorBtn");

let colors = ["red", "black", "green", "yellow", "pink", "blue"];
colorBtn.addEventListener("click", ()=>{
    let randomIndex = Math.floor(Math.random() * colors.length);
    document.body.style.backgroundColor = colors[randomIndex];
});


// task: 13

const userName = document.getElementById("username");
const userPassword = document.getElementById("userPassword");
const loginBtn = document.getElementById("login");
const showMessage = document.getElementById("loginMessage");

loginBtn.addEventListener("click", ()=>{
    if(userName.value === "" || userPassword.value === ""){
        showMessage.innerText = "Please fill all fields.";
        userName.value = "";
        userPassword.value = "";
    } else {
        showMessage.innerText = "Login Successful";
        userName.value = "";
        userPassword.value = "";
    }
});



