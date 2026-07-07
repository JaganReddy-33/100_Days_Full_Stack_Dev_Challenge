
// Truthy and Falsy

// The number 0 is explicitly a falsy value.
if (0) {
    console.log("Truthy");
} else {
    console.log("Falsy"); 
}

//  Any non-zero number is truthy.
if (1) {
    console.log("Truthy");
} else {
    console.log("Falsy");
}

// An empty string "" containing no text is falsy.
if ("") {
    console.log("Truthy");
} else {
    console.log("Falsy"); 
}

// A non-empty string containing characters is truthy.
if ("Hello") {
    console.log("Truthy"); 
} else {
    console.log("Falsy");
}

// Empty arrays [] are structural objects and evaluate to truthy.
if ([]) {
    console.log("Truthy"); 
} else {
    console.log("Falsy");
}

//  Empty objects {} are complex reference types and evaluate to truthy.
if ({}) {
    console.log("Truthy"); 
} else {
    console.log("Falsy");
}

//  The value null is explicitly a falsy value.
if (null) {
    console.log("Truthy");
} else {
    console.log("Falsy"); 
}

//  The value undefined is explicitly a falsy value.
if (undefined) {
    console.log("Truthy");
} else {
    console.log("Falsy"); 
}

//  The engine value NaN (Not-a-Number) is explicitly a falsy value.
if (NaN) {
    console.log("Truthy");
} else {
    console.log("Falsy"); 
}

//  "false" is text inside quotes (a non-empty string), making it truthy.
if ("false") {
    console.log("Truthy"); 
} else {
    console.log("Falsy");
}
