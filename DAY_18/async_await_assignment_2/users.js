

const loadBtn = document.getElementById("loadBtn");
const userList = document.getElementById("userList");
const searchUser = document.getElementById("searchUser");


let users = [];
async function fetchUsers() {
    try {
        const res = await fetch("https://jsonplaceholder.typicode.com/users");
        return await res.json();
    } catch (err) {
        console.log("Error in fetchUsers: ", err);
    }
}

loadBtn.addEventListener("click", async () => {
    users = await fetchUsers();
    // console.log(users);
    renderUsers(users);
});


searchUser.addEventListener("input", () => {
    let input = searchUser.value.trim().toLowerCase();

    const filteredUsers = users.filter(user => user.name.toLowerCase().includes(input) || user.email.toLowerCase().includes(input));

    renderUsers(filteredUsers);
});



function renderUsers(usersToRender = users) {
    userList.innerHTML = "";
    for (let i = 0; i < usersToRender.length; i++) {

        let li = document.createElement("li");

        li.innerText = `${usersToRender[i].name} - (${usersToRender[i].email}) `;

        let deleteBtn = document.createElement("button");
        deleteBtn.innerText = "Delete";

        deleteBtn.addEventListener("click", () => {
            users = users.filter(user => user.id !== usersToRender[i].id);

            const input = searchUser.value.trim().toLowerCase();
            if (input === "") {
                renderUsers(users);
            } else {
                const filteredUsers = users.filter(user =>
                    user.name.toLowerCase().includes(input) ||
                    user.email.toLowerCase().includes(input)
                );

                renderUsers(filteredUsers);
            }
        });

        li.appendChild(deleteBtn);
        userList.appendChild(li);
    }
}