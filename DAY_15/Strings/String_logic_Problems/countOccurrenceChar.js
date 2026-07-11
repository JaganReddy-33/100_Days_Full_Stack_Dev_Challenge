

// print count occurrences of a character

const str = "javascript";
const ch = "a";

let count = 0;
for(let i=0; i<str.length; i++){
    if(str[i] === ch){
        count++;
    }
}
console.log(count);
