

//  remove Duplicate char

const str = "programming";

let seen = "";
let finalStr = "";

for(let i=0; i<str.length; i++){
    let ch = str[i];
    if(seen.includes(ch)){
        continue;
    } else {
        finalStr += ch;
        seen += ch;
    }
}

console.log(finalStr);