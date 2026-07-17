
// optional Chaining

const apiResponse = { 
    profile: { 
        name: "Jagan", 
        skills: ["React", "Node"], 
        getMetrics: () => "Metrics ready"
    }
}; 

const nullResponse = null; 

// 1. Valid nested property path
console.log(apiResponse?.profile?.name); 

// 2. Missing nested property
console.log(apiResponse?.settings?.theme); 

// 3. Deep property lookup on a completely null root
console.log(nullResponse?.profile?.name); 

// 4. Valid array index check
console.log(apiResponse?.profile?.skills?.[0]); 

// 5. Array index out of range (Array exists)
console.log(apiResponse?.profile?.skills?.[5]); 

// 6. Array index look up on a missing list
console.log(apiResponse?.settings?.tags?.[0]); 

// 7. Calling a valid existing method
console.log(apiResponse?.profile?.getMetrics?.()); 

// 8. Safely attempting to run a missing method
console.log(apiResponse?.profile?.downloadData?.()); 

// 9. Method run attempt on a missing parent object
console.log(nullResponse?.clearCache?.()); 

// 10. Mixing with Nullish Coalescing (??) for smart defaults
console.log(apiResponse?.settings?.language ?? "en-IN"); 

// 11. Checking lengths of conditional arrays
console.log(apiResponse?.profile?.skills?.length); 

// 12. Using dynamic object keys safely
const keyName = "name";
console.log(apiResponse?.profile?.[keyName]); 


// 13. Complex fallback destructuring
const { age } = apiResponse?.profile?.details ?? {};
console.log(age); 

// 14. Chaining after a conditional function return
const length = apiResponse?.profile?.getMetrics?.()?.length;
console.log(length);


// Task: Given const shop = { name: "Mart" };. Log shop.department.manager.id safely using ? .
const shop = {
    name: "Mart"
};
console.log(shop?.name);
console.log(shop?.department?.manager?.id);


// Task: Extract account.avatar from const account = { id: 101 };. Use optional chaining and ?? to provide a fallback string "fallback.png".
const account = {
    id: 101
};

let profile = account?.profile ?? "fallback.png";
console.log(profile);


// Task: Given an empty object const messenger = {};. Write a single-line statement to safely invoke messenger.showAlert() without crashing.
const messenger = {};
console.log(messenger?.showAlert?.());


// Task: An API returned an empty null payload. Write a log statement accessing payload.data.items safely.
const payLoad = null;
console.log(payLoad?.data?.items);


// Task: Given const config = { UI: { mode: "dark" } }; and const viewMode = "layout";. Safely read config.UI[viewMode] using bracket notation.
const config = {
    UI: {
        mode: "dark"
    }
};
const viewMode = "layout";
console.log(config?.UI?.[viewMode]);


// Task: Given const matrix = { grids: [] };. Safely extract the very first item of the first grid array element using optional chaining.
const matrix = {
    grid: []
};
console.log(matrix?.grid?.[0]);


// Task: Given const userObject = {};. Use optional chaining combined with a fallback empty object structure (?? {}) to safely destructure a nested billing object.
const userObj = {};
const {plan, cycle} = userObj?.billing ?? {};
console.log(plan, cycle);



// Task: Given const post = { title: "Hello", logs: null };. Attempt to read the string character length of post.logs.message safely.
const post = {
    title: "Hello",
    logs : null
};
let len = post?.logs?.message?.length;
console.log(len);
