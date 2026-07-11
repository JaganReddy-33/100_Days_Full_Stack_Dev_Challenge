
// task 1: User Name Processing

const username = "   jaganmohan reddy   ";

// Remove extra spaces.
let removeSpace = username.trim();
console.log(removeSpace);

// Convert to uppercase.
let convertToUpperCase = username.toUpperCase();
console.log(convertToUpperCase);

// Convert to lowercase.
let convertToLowerCase = username.toLowerCase();
console.log(convertToLowerCase);

// Count total characters (excluding leading/trailing spaces).
let CountChar = username.trim().length;
console.log(CountChar);

// Check if the username contains "reddy".
let checkUserName = username.includes("reddy");
console.log(checkUserName);

// Check if the username starts with "j".
let checkStartName = username.startsWith("j");
console.log(checkStartName);

// Check if the username ends with "y".
let checkEndName = username.endsWith("y");
console.log(checkEndName);

// Replace "reddy" with "Reddy".
let replaceWord = username.replace("reddy", "REDDY");
console.log(replaceWord);