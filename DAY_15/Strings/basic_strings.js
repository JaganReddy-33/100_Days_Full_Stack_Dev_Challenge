

//Single quotes
const singleQuoteString = 'This is a string using single quoutes';
console.log(singleQuoteString);


//double quotes
const doubleQuoteString = "This is a string using double quoutes";
console.log(doubleQuoteString);

//Using the string constructor
const stringConstructor = new String("This is a string using the string constructor quoutes");
console.log(stringConstructor);


// Template Literals
//Basic usage
const greeting = `Hello, world`;
console.log(greeting);


//String interploation
const username = "Emma";
const welcomeMessage = `Hello, ${username}! welcome to our website`;
console.log(welcomeMessage);


//Multiline-string
const poem = `
Roses are red,
violets are blue,
Sugar is sweet,
And so are you?
`;
console.log(poem);


//Expression evaluation
const price = 10;
const tax = 0.05;
const total = `The price: ${price * (1 + tax)}`;
console.log(total);



//Escaping backtics
const stringWithBacktick = `He's a backtick \``;
console.log(stringWithBacktick);



//Using backslahes before escaping
const quote = 'He said, "Hello, world"'
console.log(quote);


//NewLines and Tabs
const multiline = "Line 1\nLine 2\tTabbed"
console.log(multiline);


//Escaping backslashes
const filePath = "c:\\Program files\\App"
console.log(filePath);


//Using the Template literals
const anotherQuote = `He said, "That's awesome"`

//Unicode characters
const heart = "I \u2764 Javascript"
console.log(heart);


// Escape Sequence for a Dollar Sign and Curly Braces in Template Literals
const metaString = `The syntax for variable is \${variableName}`
console.log(metaString);


//using the + operator
const firstname = 'Ben';
const lastname = 'Emma';
const fullname = firstname + " " + lastname;
console.log(fullname);


//using the .concat() method
const str1 = 'Hello';
const str2 = 'World'
const combinedStr = str1.concat(" ",str2)
console.log(combinedStr);


//Template literal
const fruit = 'apple';
const color = 'red';
const sentence = `The ${fruit} is  ${color}`
console.log(sentence);



//toUpperCase()
const localCaseStr = "Hello, world";
const result1 = localCaseStr.toLocaleUpperCase()
console.log(result1);


//toLowerCase()
const upperCaseStr = "HELLO, WORLD";
const Result = localCaseStr.toLocaleLowerCase()
console.log(Result);


//Mixing both methods
const mixStr = "HeLLo, WoRLD"
// const result = mixStr.toLocaleLowerCase();
// const result = mixStr.toUpperCase();


//case-insensitive comparison
const string1 = 'Javascript';
const string2 = 'javascript';
if(string1.toLowerCase() === string2.toLowerCase()){
  console.log('The strings are equal, ignoring the case');
}


//Note on non-english characters
const accentedStr = 'áéíóú"';
const result6 = accentedStr.toLocaleUpperCase()
console.log(result6);



//Find the length of a string
const myStr = 'Hello, world'
const strLength = myStr.length
console.log(strLength);


//Check for empty string
const emptyStr = "";
const result5 = emptyStr.length
console.log(result5);


//string validation
const username1 = 'Emma';
if(username1.length >= 6){
 console.log('Valid username');
}else{
 console.log('Invalid user, Must be at least 6 characters');
}


//Basic use
const greeting1 = 'Hello, world';
const extractedWord = greeting1.slice(7, 12)
console.log(extractedWord);


//omitting the end index
const text = 'Hello, world'
const result4 = text.slice(7, 9)
console.log(result4);


//using negative indices
const phrase = 'Hello, world';
const endingText = phrase.slice(-6);
console.log(endingText);



//slicing between negative indices
const sentence2 = 'Hello, world';
const result7 = sentence2.slice(-6,-1);
console.log(result7);



//Simple split by space
const mySentence = 'Hello,world';
const words = mySentence.split(',');
console.log(words);


//Limit number od split
const fruits = "apple,banana,pear";
const limitedFruits = fruits.split(',',1);
console.log(limitedFruits);


//Split by multiple characters
const complextText = "apple:banana;pear"
const mixedFruits = complextText.split(/[:;]/);
console.log(mixedFruits);


//split into characters
const word = 'Emmanuel';
const letters = word.split("");
console.log(letters);



//Basic usage
const sentences = 'Hello,world';
const index = sentences.indexOf('Hello');
console.log(index);


//Trimming user input
const userInput = '   emma@gmail.com   ';
const emailTrimmed = userInput.trim();
console.log(emailTrimmed);


//Removing Line Breaks
const stringsWithBreaks = '\n\t Hello, World';
const cleanString = stringsWithBreaks.trim();
console.log(cleanString);


//Basic usage
const originalText = 'This is an old text.';
const updatedText = originalText.replace('old','new');
console.log(updatedText);


//Replace all occurances
const repititiveText = 'old text with old words';
const replaceAll = repititiveText.replace('old', 'new');
console.log(replaceAll);



//Basic usage
const myText = 'apple organe, apple, banana';
const lastIndx = myText.lastIndexOf('apple');
console.log(lastIndx);



//Basic usage
const myText2 = 'I have an apple';
const res = myText2.includes('apple');
console.log(res);
// const result = myText2.includes('I');

// const result = myText2.includes('apple',8);



//Converting a number to a string;
const num = 42;
const strNum= String(num);
console.log(strNum);


//Converting a boolean to a string;
const boolVal = true
const strBool = String(boolVal);



//Converting  an array to a string;
const arr = [1,2,3];
// console.log(arr);
let stringArr = String(arr);
// console.log(stringArr);
// console.log(typeof stringArr);


//Converting  object to a string;
const obj = {name:'Emma', age:25}
// console.log(typeof String(obj));


//Converting  null and undefined to a string;
const str1Null = String(null)
// console.log(typeof str1Null);



//Convert number to string
const num1 = 25
const strNum1 = num1.toString()
//console.log( typeof strNum1);


//Convert boolean to string
const boolVal2 = false;
// console.log(typeof boolVal2.toString());



//Converting Pixel Value to Number with parseInt()
const pixelvalueAsString = '42px';
// const convertedVal = parseInt(pixelvalueAsString)
// console.log( convertedVal+10);



// Example 2: Converting Dimension String to Number with parseFloat()
const dimensionStr = "42.5px"
//  const convertedVal = parseFloat(dimensionStr)



 // Example 3: Converting Age Input to Number using Number()
 const ageInput = "42";
//  const convertedVal = Number(ageInput)
//  console.log( convertedVal + 10);



// Example 4: Quick Conversion using Unary + Operator
 const scoreStr = '100';
//  const convertedVal = +scoreStr
//  console.log( convertedVal + 200);



// Example 1: Using Boolean() for Form Validation
const usernameInput = 'Thomas';
// const convertedVal = Boolean(usernameInput)
// console.log(convertedVal);


// Example 2: Using Boolean() with Empty String
const emptyField = "";
//  const convertedVal = Boolean(emptyField)
//  console.log(convertedVal);


 // Example 3: Using Double Negation !! for Quick Conversion
 const emailInput = "emma@gmail.com";
 const convertedVal = !!emailInput
 console.log(convertedVal);