
// Interview Programs

// 1. Arrays
// Remove Duplicate using two pointer
let arr = [1, 3, 4, 4, 6, 2, 3, 1];
const sortedArray = arr.sort((a, b)=> a-b);
let i=0;
for(let j=1; j<sortedArray.length; j++){
    if(arr[j] !== arr[i]){
        i++;
        arr[i] = arr[j];  
    }
}
arr.length = i+1;
// console.log(sortedArray);

// using Set collection
// console.log([...new Set(arr)]);

// 2. largest num
let arr1 = [10, 22, 5, 34, 7, 8];
let max = -Infinity;
for(let i=0; i<arr1.length; i++){
    if(arr1[i] > max){
        max = arr1[i];
    }
}
console.log("Largest number:",max);

// 3. smallest number
let min = Infinity;
for(let i=0; i<arr1.length; i++){
    if(arr1[i] < min){
        min = arr1[i];
    }
}
console.log("Smallest Number: ",min);

// second smallest and largest
let max1 = -Infinity;
let max2 = -Infinity;
let min1 = Infinity;
let min2 = Infinity;

for(let i=0; i<arr1.length; i++){
    if(arr1[i] > max1){
        max2 = max1;
        max1 = arr1[i];
    } else if(arr[i] > max2 && arr[i] != max1){
        max2 = arr1[i];
    }

    if(arr1[i] < min1){
        min2 = min1;
        min1 = arr1[i];
    } else if(arr1[i] < min2 && arr1[i]!=min1){
        min2 = arr1[i];
    }
}
console.log("Largest Number:", max1);
console.log("Second Largest Number:", max2);
console.log("Smallest number:", min1);
console.log("Second Smallest Number:", min2);


// 5. frequency counter
let arr2 = [1, 3, 4, 4, 6, 2, 3, 1];
const freq = new Map();
for(const item of arr2){
    const count = freq.get(item) || 0;
    freq.set(item, count+1);
}
console.log(Object.fromEntries(freq));


// String
// 1. reverse a String using loop
let str = "hello";
let rev = "";
for(const ch of str){
    rev = ch + rev;
}
console.log(rev);

// using built-in
let rev1 = [...str].reverse().join("");
console.log(rev1);

// 2. Palindrome checker
// built-in 
let str1 = "racecar";
let isPal = str1 === [...str1].reverse().join("");
console.log(isPal);

// two pointers
let left=0; 
let right=str1.length-1;
let isPal_1 = true;

while(left < right){
    if(str1[left] !== str1[right]){
        isPal_1 = false;
        break;
    }
    left++;
    right--;
}
console.log(isPal_1);


// 3. character frequency
let str2 = "hellooo";
let freq1 = {};
for(const ch of str2){
    freq1[ch] = (freq1[ch] || 0) + 1;
}
console.log(freq1);

// 4. count vowels
let str3 = "javascript";
let vowels = new Set(['a', 'e', 'i', 'o', 'u']);
let count  = 0;
for(const ch of str3){
    if(vowels.has(ch)){
        count++;
    }
}
console.log(count);

// longest word
let str4 = "code everyday to learn";
let words = str4.split(" ");
let longest = "";

for (const word of words) {
  if (word.length > longest.length) {
    longest = word;
  }
}
console.log(longest);
 

// Objects
let employees = [
  { name: "Alice", salary: 5000, dept: "IT" },
  { name: "Bob", salary: 8000, dept: "HR" },
  { name: "Charlie", salary: 8000, dept: "IT" },
  { name: "David", salary: 6000, dept: "HR" }
];

let highestSalary = employees.reduce((max, emp) => emp.salary > max.salary ? emp : max, employees[0]);
console.log(highestSalary);

let groupedDept = Object.groupBy(employees, emp => emp.dept);
console.log(groupedDept);

let students = [
  { name: "John", marks: [80, 90, 85] },
  { name: "Jane", marks: [95, 92, 88] },
  { name: "Jake", marks: [70, 75, 80] }
];

let averages = students.map(student => ({
  name: student.name,
  average: student.marks.reduce((sum, mark) => sum + mark, 0) / student.marks.length
}));
console.log(averages);

let topper = averages.reduce((max, student) => student.average > max.average ? student : max, averages[0]);
console.log(topper);

let obj1 = { a: 1, b: 2, c: { x: 10 } };
let obj2 = { b: 4, d: 5, c: { y: 20 } };

let shallowMerged = Object.assign({}, obj1, obj2);
console.log(shallowMerged);

let deepMerged = structuredClone(obj1);
Object.assign(deepMerged, obj2);
deepMerged.c = Object.assign({}, obj1.c, obj2.c);
console.log(deepMerged);









