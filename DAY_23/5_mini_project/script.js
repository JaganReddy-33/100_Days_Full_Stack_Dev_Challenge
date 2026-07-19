

// Fake Login System 
const usernameInput = document.getElementById("username");
const passwordInput = document.getElementById("password");
const loginBtn = document.getElementById("loginBtn");
const message = document.getElementById("message");


function login(user, pass) {
    return new Promise((resolve, reject)=>{
        setTimeout(() => {
            if(user === "admin" && pass==="1234"){
                resolve("Login Successful");
            } else {
                reject("Invalid Credentials");
            }
        }, 3000);
    });    
}

async function handleLogin() {
    const userValue = usernameInput.value.trim();
    const passValue = passwordInput.value;

    if(userValue==="" || passValue===""){
        message.innerText = "You must enter the credentials";
        message.style.color = "red";
        return;
    }
    message.innerText = "Loading...";
    message.style.color = "blue";
    loginBtn.disabled = true;

    try {
        const res = await login(userValue, passValue);
        message.innerText = res;
        message.style.color = "green";

        usernameInput.value = "";
        passwordInput.value = "";
    } catch (error) {
        message.innerText = error;
        message.style.color ="red";
    } finally {
        loginBtn.disabled = false;
    }
}


loginBtn.addEventListener("click", handleLogin);

passwordInput.addEventListener("keypress", (event)=>{
    if(event.key === "Enter"){
        handleLogin();
    }
});