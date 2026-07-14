const username = document.getElementById("username");

const searchBtn = document.getElementById("searchBtn");

const profile = document.getElementById("profile");

searchBtn.addEventListener("click", async () => {

    if (username.value.trim() === "") {
        username.focus();
        return;
    }

    try {
        profile.innerHTML = `<p>Loading...</p>`;

        const url = `https://api.github.com/users/${username.value}`;

        const response = await fetch(url);

        if (response.status === 404) {
            profile.innerHTML = `<h2>User does not exist!</h2>`;
            return;
        }

        const user = await response.json();

        profile.innerHTML = `
            <img src="${user.avatar_url}" width="150">
            <h2>${user.name}</h2>
            <span>Followers: ${user.followers}</span>
            <span> Following: ${user.following}</span>
            <p>Public Repos: ${user.public_repos}</p>
            <a href="${user.html_url}" target="_blank">GitHub Link</a>
            <p>User ID: ${user.id}</p>
        `;

    } catch (error) {
        
        profile.innerHTML = `<h2>Something went wrong!</h2>`;
        console.error(error);
    }
});

username.addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        searchBtn.click();
    }
});



