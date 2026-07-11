
// Find Longest Word

const sentence = "JavaScript is awesome and powerful";

let arr = sentence.split(" ");
let longestWord = arr[0];

for(let i=1; i<arr.length; i++){
    if(arr[i].length > longestWord.length){
        longestWord = arr[i];
    }
}
console.log(longestWord);