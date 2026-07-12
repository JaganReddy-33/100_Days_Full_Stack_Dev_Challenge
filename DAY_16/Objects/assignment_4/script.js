
// Assignment 4: Library System


const library = [
  { title: "Eloquent JavaScript", author: "Marijn Haverbeke", price: 1800, available: true },
  { title: "You Don't Know JS", author: "Kyle Simpson", price: 2500, available: false },
  { title: "JavaScript: The Good Parts", author: "Douglas Crockford", price: 950, available: true }
];

// 1. Filter available books
const availableBooks = library.filter(book => book.available);
console.log("Available Books:", availableBooks);

// 2. Find most expensive book
const expensiveBook = library.reduce((max, book) => book.price > max.price ? book : max, library[0]);
console.log("Most Expensive Book:", expensiveBook);

// 3. Count available books
const totalAvailable = library.filter(book => book.available).length;
console.log("Total Available Count:", totalAvailable);

// 4. Update availability
const setAvailability = (title, status) => {
  const book = library.find(book => book.title.toLowerCase() === title.toLowerCase());
  if (book) book.available = status;
};
setAvailability("You Don't Know JS", true);
