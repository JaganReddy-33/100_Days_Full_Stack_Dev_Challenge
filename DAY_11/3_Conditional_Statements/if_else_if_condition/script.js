// if_else_if condition

// Grade Cal
let score = 77;
if (score >= 90) {
    console.log("A");
} else if (score >= 80) {
    console.log("B");
} else if (score >= 70) {
    console.log("C");
} else if (score >= 60) {
    console.log("D");
} else {
    console.log("F");
}


// Traffic Signal
let color = "red";
let cleanColor = color.trim().toLowerCase();

if (cleanColor === "red") {
    console.log("Stop");
} else if (cleanColor === "yellow") {
    console.log("Slow Down");
} else if (cleanColor === "green") {
    console.log("Go");
} else {
    console.log("Invalid Signal");
}

// BMI Category
let bmi = 22.5; 
let bmiCategory;

if (bmi < 18.5) {
    bmiCategory = "Underweight";
} else if (bmi >= 18.5 && bmi < 25.0) {
    bmiCategory = "Normal weight";
} else if (bmi >= 25.0 && bmi < 30.0) {
    bmiCategory = "Overweight";
} else {
    bmiCategory = "Obese";
}
console.log(bmiCategory);

//  Weather
let temperature = 24;
let weather;

if (temperature >= 30) {
    weather = "Hot";
} else if (temperature >= 15 && temperature < 30) {
    weather = "Warm";
} else {
    weather = "Cold";
}
console.log(weather);

// Income Tax Slab
let income = 75000;
let taxRate;

if (income <= 50000) {
    taxRate = 0.05; 
} else if (income > 50000 && income <= 100000) {
    taxRate = 0.15; 
} else {
    taxRate = 0.30; 
}
console.log(taxRate);

//  movie rating
let stars = 4;
let movieRating;

if (stars === 5) {
    movieRating = "Excellent";
} else if (stars === 4) {
    movieRating = "Good";
} else if (stars === 3) {
    movieRating = "Average";
} else if (stars === 1 || stars === 2) {
    movieRating = "Poor";
} else {
    movieRating = "Invalid Rating";
}
console.log(movieRating);

// Speed Fine
let currentSpeed = 75;
let speedLimit = 60;
let excessSpeed = currentSpeed - speedLimit;
let speedFine;

if (excessSpeed <= 0) {
    speedFine = 0;    
} else if (excessSpeed > 0 && excessSpeed <= 10) {
    speedFine = 50;   
} else if (excessSpeed > 10 && excessSpeed <= 20) {
    speedFine = 150;  
} else {
    speedFine = 300;
}
console.log(speedFine);

// Attendance
let percentage = 85;
let attendanceStatus;

if (percentage >= 90) {
    attendanceStatus = "Excellent";
} else if (percentage >= 75 && percentage < 90) {
    attendanceStatus = "Average";
} else {
    attendanceStatus = "Poor";
}
console.log(attendanceStatus);

// Electricity Bill Category
let kwhUnits = 250;
let billCategory;

if (kwhUnits <= 100) {
    billCategory = "Low Usage";
} else if (kwhUnits > 100 && kwhUnits <= 300) {
    billCategory = "Moderate Usage";
} else {
    billCategory = "High Usage";
}
console.log(billCategory);

// Age Group
let age = 34;
let ageGroup;

if (age >= 0 && age <= 12) {
    ageGroup = "Child";
} else if (age >= 13 && age <= 19) {
    ageGroup = "Teen";
} else if (age >= 20 && age <= 64) {
    ageGroup = "Adult";
} else if (age >= 65) {
    ageGroup = "Senior Citizen";
} else {
    ageGroup = "Invalid Age";
}
console.log(ageGroup);