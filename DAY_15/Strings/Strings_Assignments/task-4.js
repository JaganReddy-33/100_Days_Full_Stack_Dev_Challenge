// task-4: Reverse & Palindrome

const word = "madam";

// Reverse the string.
let reverse = "";
for(let i=word.length-1; i>=0; i--){
    reverse +=word[i];
}
console.log(reverse);

// Check whether it is a palindrome.
let rev = "";
for(let i=word.length-1; i>=0; i--){
    rev += word[i];
}
if(rev === word){
    console.log("Palindrome");
}

// Convert it to uppercase.
console.log(word.toUpperCase());

// Convert it to lowercase.
console.log(word.toLowerCase());

// Count characters.
console.log(word.length);

// Get the first character.
let arr = word.split("");
console.log(arr[0]);


// Get the last character.
 console.log(arr[arr.length-1]);