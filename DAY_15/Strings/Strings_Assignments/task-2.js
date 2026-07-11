// task 2: Sentence Analysis

const sentence = "JavaScript is awesome and powerful";

// Count total characters.
console.log(sentence.length);

// Count total words.
let countTotalWords = sentence.split(" ").length;
console.log(countTotalWords);

// Convert sentence into an array of words.
console.log(sentence.split(" "));

// Find the first word.
let array = sentence.split(" ");
console.log(array[0]);

// Find the last word.
console.log(array[array.length-1]);

// Convert the entire sentence to uppercase.
console.log(sentence.toUpperCase());

// Convert the entire sentence to lowercase.
console.log(sentence.toLowerCase());

// Check whether the sentence contains "awesome".
let CheckSentence = sentence.includes("awesome");
console.log(CheckSentence);