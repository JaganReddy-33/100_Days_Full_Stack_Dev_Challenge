

const noteInput = document.getElementById("noteInput");

const addBtn = document.getElementById("addBtn");

const noteList = document.getElementById("noteList");

const searchInput = document.getElementById("searchInput");

const totalNotes = document.getElementById("totalNotes");


let notes = [];
addBtn.addEventListener("click", () => {
    if (noteInput.value.trim() === "") {
        noteInput.focus();
        return;
    }

    notes.push(noteInput.value);

    renderNotes();

    totalNotes.innerText = `Total Notes Count is ${notes.length}`;

    noteInput.value = "";
});

searchInput.addEventListener("input", ()=>{
    let userInput = searchInput.value.trim();

    let filteredNotes = notes.filter((note)=>{
        return note.toLowerCase().includes(userInput.toLowerCase());
    });

    renderNotes(filteredNotes)
});


function renderNotes(noteArray = notes) {
    noteList.innerHTML = "";
    for (let i = 0; i < noteArray.length; i++) {

        let li = document.createElement("li");
        li.innerText = noteArray[i];

        let deleteBtn = document.createElement("button");
        deleteBtn.innerText = "Delete";

        deleteBtn.addEventListener("click", () => {
            notes = notes.filter((note)=>{
                return note !== noteArray[i];
            });
            renderNotes();
            totalNotes.innerText = `Total Notes Count is ${notes.length}`;
        });

        
        li.appendChild(deleteBtn);
        noteList.appendChild(li);
    }

}