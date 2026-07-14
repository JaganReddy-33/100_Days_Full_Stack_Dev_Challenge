

const userInput = document.getElementById("userInput");

const addBtn = document.getElementById("addBtn");

const todoList = document.getElementById("todoList");

const totalTodos = document.getElementById("total-todos");

const completedTodos = document.getElementById("completed-todos");

const remainingTodos = document.getElementById("remaining-todos");

let todos = JSON.parse(localStorage.getItem("todos")) || [];
// console.log(todos);

renderTodos();

addBtn.addEventListener("click", () => {
    let todo = userInput.value.trim();
    if (todo === "") {
        alert("Enter a todo");
        return;
    }

    todos.push({
        text: todo,
        completed: false
    });

    saveTodos();
    renderTodos();
    userInput.value = "";
    userInput.focus();

});


userInput.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        addBtn.click();
    }
});


function renderTodos() {

    todoList.innerHTML = "";

    const total = todos.length;
    const completed =
        todos.filter(
            todo => todo.completed
        ).length;

    const remaining =
        total - completed;

    totalTodos.innerText = `Total todos: ${total} ||`;

    completedTodos.innerText = `Completed todos: ${completed} ||`;

    remainingTodos.innerText = `Not Completed todos: ${remaining} `;

    if (todos.length === 0) {
        totalTodos.style.display = "none";
        completedTodos.style.display = "none";
        remainingTodos.style.display = "none";
    } else {
        totalTodos.style.display = "inline";
        completedTodos.style.display = "inline";
        remainingTodos.style.display = "inline";
    }


    for (let i = 0; i < todos.length; i++) {
        let li = document.createElement("li");
        li.innerText =
            todos[i].completed
                ? "✔ " + todos[i].text
                : todos[i].text;
        li.style.textDecoration = todos[i].completed ? "line-through" : "none";

        let deleteBtn = document.createElement("button");
        deleteBtn.innerText = "Delete";

        deleteBtn.addEventListener("click", () => {
            todos = todos.filter((_, index) => {
                return index !== i;
            });

            saveTodos();
            renderTodos();
        });


        let markBtn = document.createElement("button");
        markBtn.innerText = todos[i].completed ? "undo todo!" : "Mark todo!";

        markBtn.addEventListener("click", () => {
            todos[i].completed = !todos[i].completed;

            saveTodos();
            renderTodos();

        });

        li.appendChild(deleteBtn);
        li.appendChild(markBtn);
        todoList.appendChild(li);
    }
}


function saveTodos() {
    localStorage.setItem("todos", JSON.stringify(todos));
}