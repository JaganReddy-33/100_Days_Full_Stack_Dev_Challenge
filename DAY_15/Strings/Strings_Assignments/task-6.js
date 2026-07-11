// task-6: Vowel & Character Analysis

const text = "Frontend Developer";

// Count total characters.
console.log(text.length);

// Count vowels.
let count = 0;
for(let i=0; i<text.length; i++){
    if("aeiouAEIOU".includes(text[i])){
        count++;
    }
}
console.log(count);

// Count consonants.
let countCons = 0;
for(let i=0; i<text.length; i++){
    if(!"aeiouAEIOU".includes(text[i])){
        countCons++;
    }
}
console.log(countCons);

// Convert to uppercase.
console.log(text.toUpperCase());

// Convert to lowercase.
console.log(text.toLowerCase());

// Replace "Developer" with "Engineer".
console.log(text.replace("Developer", "Engineer"));


// Check whether "Front" exists.
console.log(text.includes("Frontend"));


// Reverse the string.
let rev = "";
for(let i=text.length-1; i>=0; i--){
    rev += text[i];
}
console.log(rev);