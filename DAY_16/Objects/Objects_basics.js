

// 1. OBJECT CREATION & PROPERTY ACCESS

const dynamicKey = "status";

const userProfile = {
  name: "Jane Doe",
  age: 28,
  "current city": "Bengaluru", 
  [dynamicKey]: "active",    
  skills: ["JS", "Python"],   
};

// Accessing Properties
console.log(userProfile.name);           
console.log(userProfile["current city"]); 
console.log(userProfile[dynamicKey]);   



// Modifying Properties
userProfile.age = 29;                      
userProfile.country = "India";             
delete userProfile["current city"];
console.log(userProfile);



// 2. THE 'this' KEYWORD & METHODS
const account = {
  holder: "Alex",
  balance: 5000,
  showBalance() {
    return `${this.holder} has ₹${this.balance}`;
  },
  invalidShow: () => {
    return `${this.holder} has ₹${this.balance}`;  //(Fails here; points to global/window)
  }
};

console.log(account.showBalance());
console.log(account.invalidShow());


// 3. OBJECT ITERATION METHODS
const scores = { 
    math: 90, 
    science: 85, 
    history: 88 
};

// for...in loop (Iterates over keys)
for (let subject in scores) {
  console.log(`${subject}: ${scores[subject]}`);
}


// Static Object Methods
const keys = Object.keys(scores);
console.log(keys);
const values = Object.values(scores);
console.log(values);
const entries = Object.entries(scores);
console.log(entries);
 


// 4. DESTRUCTURING, SPREAD, & ASSIGN
const client = { 
    id: 101, 
    meta: { role: "admin" }, 
    tags: ["vip"] 
};

// Destructuring with renaming, nesting, and default values
const { id: clientId, meta: { role }, tags } = client;
console.log(clientId);
console.log(role);
console.log(tags);



// Shallow Copy & Merge via Spread Operator
const baseObj = { 
    x: 1, 
    y: 2 
};
const shallowCopy = { ...baseObj };
console.log(shallowCopy);
const mergedObj = { ...baseObj, z: 3, x: 99 };
console.log(mergedObj);


// Object.assign() (Alternative shallow copy/merge mechanism)
const targeted = {};
console.log(Object.assign(targeted, baseObj, { w: 4 }));


// 5. OPTIONAL CHAINING & NULLISH COALESCING
const networkResponse = {
  data: {
    user: { settings: { theme: null } }
  }
};
// Optional Chaining (?.) stops execution and returns undefined if a reference is missing
const zip = networkResponse.data?.user?.address?.zipCode; // undefined (No crash!)
console.log(zip);


// Nullish Coalescing (??) checks strictly for null or undefined
const activeTheme = networkResponse.data?.user?.settings?.theme ?? "dark-default";
console.log(activeTheme);
