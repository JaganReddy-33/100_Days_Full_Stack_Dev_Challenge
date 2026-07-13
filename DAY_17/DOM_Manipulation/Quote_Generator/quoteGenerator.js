
const quotes = [
  "Dream big and dare to fail.",
  "Consistency beats talent when talent doesn't work hard.",
  "Never give up on a dream just because of the time it will take.",
  "Action is the foundational key to all success.",
  "Make each day your masterpiece."
];

const quoteText = document.getElementById("quoteText");
const quoteBtn = document.getElementById("quoteBtn");

quoteBtn.addEventListener("click", ()=>{
    const randomIdx = Math.floor(Math.random()*quotes.length);

    quoteText.innerText = `"${quotes[randomIdx]}"`;
});