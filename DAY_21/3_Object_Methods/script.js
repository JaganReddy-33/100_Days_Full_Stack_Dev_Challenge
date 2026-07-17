
// Object methods

const user = { 
    id: 101, 
    username: "Jagan", 
    role: "Instructor", 
    score: 95 
};

// --- 1. Extracting Keys ---
const keys = Object.keys(user);
console.log(keys); 

// --- 2. Extracting Values ---
const values = Object.values(user);
console.log(values); 

// --- 3. Creating Key-Value Arrays ---
const entries = Object.entries(user);
console.log(entries); 

// --- 4. Rebuilding Objects ---
const productPairs = [['item', 'Laptop'], ['price', 1200]];
const productObj = Object.fromEntries(productPairs);
console.log(productObj); 

// --- 5. Filtering Object Properties ---
const highScoresOnly = Object.fromEntries(
  Object.entries(user).filter(([key, val]) => typeof val === 'number')
);
console.log(highScoresOnly); 

// --- 6. Totaling Numerical Values ---
const expenses = { rent: 1000, food: 300, utilities: 150 };
const totalExpense = Object.values(expenses).reduce((acc, curr) => acc + curr, 0);
console.log(totalExpense); 

// --- 7. Strict Freezing Immutability ---
const frozenUser = Object.freeze({ status: "online" });
frozenUser.status = "offline"; 
console.log(frozenUser.status); 

// --- 8. Sealing Behavior Properties ---
const sealedCart = Object.seal({ itemCount: 2 });
sealedCart.itemCount = 5; 
sealedCart.coupon = "SAVE10"; 
console.log(sealedCart); 

// --- 9. Direct Property Verification ---
console.log(user.hasOwnProperty("role")); 
console.log(user.hasOwnProperty("toString")); 

// --- 10. Shallow Cloning via Assign ---
const profileClone = Object.assign({}, user);
console.log(profileClone !== user); 

// --- 11. Merging Multiple Dataset Payloads ---
const defaults = { theme: "light", layout: "grid" };
const userCustoms = { theme: "dark" };
const finalConfig = Object.assign({}, defaults, userCustoms);
console.log(finalConfig); 

// --- 12. Modifying URL Query Params to Object ---
const searchParams = new URLSearchParams("?color=blue&size=large");
const filters = Object.fromEntries(searchParams.entries());
console.log(filters); 

// --- 13. Transforming Object Values via Entries ---
const upperCaseUser = Object.fromEntries(
  Object.entries(user).map(([k, v]) => [k, typeof v === 'string' ? v.toUpperCase() : v])
);
console.log(upperCaseUser.username); 

// --- 14. Checking if Object is Empty ---
const emptyObj = {};
const isEmpty = Object.keys(emptyObj).length === 0;
console.log(isEmpty); 

// --- 15. Safe Evaluation for Sealed/Frozen Objects ---
console.log(Object.isFrozen(frozenUser)); 
console.log(Object.isSealed(sealedCart)); 



// Task: Given an API data unit const report = { date: "2026-07-17", clicks: 340, revenue: 89 };. Use Object.keys() to extract all fields and verify the length of fields matches exactly 3
const report = {
    date: "2026-07-17",
    clicks: 340,
    revenue: 89
};
console.log(Object.keys(report).length);



// Task: Calculate the total stock in your warehouse given const inventory = { laptops: 12, phones: 45, tablets: 7 };. Use Object.values() combined with .reduce() to get a single summary value.
const inventory = {
    laptops: 12,
    phones: 45,
    tablets: 7
};
const totalStock = Object.values(inventory).reduce((total, val)=> total+=val, 0);
console.log(totalStock);


// Task: Take the object const criteria = { category: "books", page: 2 };. Transform it into a nested array format using Object.entries().
const criteria = {
    category: "books",
    page: 2
};
console.log(Object.entries(criteria));


// Task: A React custom form tracking map returns const formFields = [['email', 'a@b.com'], ['msg', 'hello']];. Use Object.fromEntries() to parse it back into a standard data submission object structure.
const formFields = [['email','abc@gmail.com'], ['msg', 'hello']];
console.log(Object.fromEntries(formFields));


// Task: Protect const appSettings = { apiBase: "https://api.com", retryCount: 3 }; from any modifications using Object.freeze(). Prove it works by attempting to reassign apiBase.
const appSettings = {
    apiBase: "https://api.com",
    retryCount: 3
};

Object.freeze(appSettings);
appSettings.apiBase = "https://google.com";
console.log(appSettings.apiBase);



// Task: Create a dynamic wizard form step runner using const validationState = { step: 1, valid: false };. Prevent adding any extra property parameters by applying Object.seal(). Change valid to true to ensure updates still function.
const validationState = {
    step:1,
    valid: false
};
Object.seal(validationState);
validationState.days = 7;
console.log(validationState);
validationState.valid = true;
console.log(validationState);


// Task: Test if const candidate = { skills: ["JS"] }; contains the custom flag key property "salaryExpectation" natively using .hasOwnProperty().
const candidate = {
    skills:["Js", "React", "Node.js"]
};
let res = candidate.hasOwnProperty("salaryExpectation");
console.log(res);



// Task: Replicate an old-school React class state merge strategy. Combine const current = { mode: "view", id: 4 }; with const updates = { mode: "edit" }; using Object.assign() into a new target object instance.
const current = {mode: "view", id: 4};
const updates = {mode: "edit"};
let mergedObj = Object.assign({}, current, updates);
console.log(mergedObj);
