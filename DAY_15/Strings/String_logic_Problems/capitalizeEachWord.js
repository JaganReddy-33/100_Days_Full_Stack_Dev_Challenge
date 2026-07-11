

// capitalize Each Word

const sentence = "JavaScript is awesome and powerful";
let arr = sentence.split(" ");

let capWords = arr.map((word)=>{
    return word[0].toUpperCase() + word.slice(1).toLowerCase();
});

let res = capWords.join(" ");
console.log(res);