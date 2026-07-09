
//  Return function

// Return sum.
function getSum(a, b) {
    return a + b;
}
let sum = getSum(12, 5);
console.log(sum);


// Return largest of two numbers.
function getLargest(a, b) {
    return a > b ? a : b;
}
let largestNum = getLargest(17, 6);
console.log(largestNum);


// Return smallest number.
function getSmallest(a, b) {
    return a < b ? a : b;
}
let smallestNum = getSmallest(2, 67);
console.log(smallestNum);


// Return square.
function getSquare(num) {
    return num * num;
}
let square = getSquare(4);
console.log(square);


// Return cube.
function getCube(num) {
    return num * num * num;
}
let cube = getCube(5);
console.log(cube);


// Return factorial.
function getFactorial(num) {
    if (num < 0) return undefined;
    let result = 1;
    for (let i = 2; i <= num; i++) {
        result *= i;
    }
    return result;
}
let factorial = getFactorial(7);
console.log(factorial);


// Return even/odd.
function isEvenOrOdd(num) {
    return num % 2 === 0 ? "Even" : "Odd";
}
console.log( isEvenOrOdd(6));


// Return palindrome.
function isPalindrome(str) {
    const cleanStr = String(str).toLowerCase().replace(/[^a-z0-9]/g, "");
    const reversedStr = cleanStr.split("").reverse().join("");
    return cleanStr === reversedStr;
}
let str = isPalindrome("madam")
console.log(str);


// Return reverse string.
function reverseString(str) {
    return String(str).split("").reverse().join("");
}
let reverse = reverseString("Jagan")
console.log(reverse);


// Return grade.
function getGrade(score) {
    if (score >= 90) return "A";
    if (score >= 80) return "B";
    if (score >= 70) return "C";
    if (score >= 60) return "D";
    return "F";
}
let grade = getGrade(87);
console.log(grade);
