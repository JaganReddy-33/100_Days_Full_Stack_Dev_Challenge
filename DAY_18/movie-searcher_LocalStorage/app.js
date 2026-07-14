
const userInput = document.getElementById("userInput");
const searchBtn = document.getElementById("searchBtn");
const moviesInfo = document.getElementById("moviesInfo");



searchBtn.addEventListener("click", async () => {
    let movie = userInput.value.trim();

    if (movie === "") {
        alert("please enter your movie name!");
        return;
    }

    moviesInfo.innerHTML = `<h2>Loading...</h2>`;

    const url = `https://www.omdbapi.com/?apikey=4a0696b6&s=${encodeURIComponent(movie)}`;
    const response = await fetch(url);
    const data = await response.json();

    if (data.Response === "False") {
        moviesInfo.innerHTML = `<h2>${data.Error}</h2>`;
        return;
    }
    console.log(data);

    renderMovies(data.Search);

    userInput.value = "";

});

function renderMovies(movies) {
    moviesInfo.innerHTML = "";
    for (let i = 0; i < movies.length; i++) {

        const movie = movies[i];

        let div = document.createElement("div");
        div.innerHTML = `
        <br> <br>
    <img
        src="${movie.Poster}"
        alt="${movie.Title}"
        width="200"
    >

    <h2>Title: ${movie.Title}</h2>

    <p>Year: ${movie.Year}</p>

    <p>Type: ${movie.Type}</p>
    <hr>`;


        moviesInfo.appendChild(div);
    }
}