

let password = document.getElementById("password");

let showStrength = document.getElementById("showStrength");

password.addEventListener("input", ()=>{
    let passwordLen = password.value.length;
    if(passwordLen < 6) {
        showStrength.innerText = "Weak";
        showStrength.style.color = "red";

    } else if(passwordLen>=6 && passwordLen<=10){
        showStrength.innerText = "Medium";
        showStrength.style.color="orange";

    } else if(passwordLen>10 && /\d/.test(password.value)){
        showStrength.innerText = "Strong";
        showStrength.style.color="green";
        
    } else {
        showStrength.innerText = "Medium (Add a numbers for Strong)";
        showStrength.style.color = "orange";
    }

    if(passwordLen <= 0){
        showStrength.innerText = "";
    }
});