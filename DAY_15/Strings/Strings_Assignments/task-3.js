//  task-3: Email Validation Practice

const email = "jaganmohan@gmail.com";


// Check if the email contains "@".
console.log(email.includes("@"));

// Check if the email contains ".com".
console.log(email.includes(".com"));


// Extract the username part. Expected: "jaganmohan"
console.log(email.slice(0, email.indexOf("@")));

// Extract the domain name. Expected: "gmail.com"
console.log(email.slice(email.indexOf("@")+1));

// Convert email to uppercase.
console.log(email.toUpperCase());

// Count total characters.
console.log(email.length);