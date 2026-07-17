

// Nullish coalescing

// 1. Handling Null
const user = null;
console.log(user ?? "Anonymous"); 

// 2. Handling Undefined
let score;
console.log(score ?? 100); 

// 3. Preserving Zero (0)
const totalDownloads = 0;
console.log(totalDownloads || 10); 
console.log(totalDownloads ?? 10); 

// 4. Preserving Empty Strings ("")
const middleName = "";
console.log(middleName || "N/A"); 
console.log(middleName ?? "N/A"); 


// 5. Preserving False Booleans
const animationEnabled = false;
console.log(animationEnabled || true); 
console.log(animationEnabled ?? true); 


// 6. Deep Integration with Optional Chaining (?.)
const apiData = { 
    user: { 
        profile: { 
            setupCompleted: false 
        } 
    } 
};
const isComplete = apiData?.user?.profile?.setupCompleted ?? true;
console.log(isComplete); 

// 7. Dynamic API Arrays Fallback
const payload = { items: null };
const list = payload?.items ?? [];
console.log(list); 

// 8. Chaining Multiple Coalescing
const primaryEmail = null;
const secondaryEmail = undefined;
const fallbackEmail = "admin@domain.com";
console.log(primaryEmail ?? secondaryEmail ?? fallbackEmail); 

// 9. Short-Circuit Evaluation Behavior
function getFallback() {
  return "Default Value";
}
const validData = "Hello";
console.log(validData ?? getFallback()); 



// Task: Given const balance = 0;. Write a statement using ?? to supply a default fallback value of 100 if the balance is nullish. Ensure it logs 0.
const balance = 0;
console.log(balance ?? 100);


// Task: A user types nothing into a profile nickname slot, making const inputName = "";. Use ?? to provide a fallback name "Guest User". Verify it prints "".
const inputName = "";
console.log(inputName ?? "Guest User");


// Task: Given an API response object const response = { status: "success", data: null };. Safely extract response.data using ?? to fall back to an empty array literal [].
const response = {
    status : "success",
    data: null
};
console.log(response?.data ?? []);


//  Task: Change this buggy code to use nullish coalescing so it preserves the false setting: const standardMode = config.enableDark || true; where config = { enableDark: false }.
const config = {
    enableDark: false
};
const standardMode = config?.enableDark || true;
console.log(standardMode);
const standardMode2 = config?.enableDark ?? true;
console.log(standardMode2);


// Task: You have three connection routes: let primary = null;, let backup = undefined;, and let emergency = "192.168.1.1";. Connect them in a single line using sequential ?? statements to find the first valid string.
let primary = null;
let secondary = undefined;
let backUp = "192.168.1.1";
console.log(primary ?? secondary ?? backUp);


// Task: Given const customer = { history: {} };. Attempt to look up customer.history.orders?.[0]?.price and apply a default fallback value of 0 if it is nullish.
const customer = {
    history: {}
};
console.log(customer?.history?.orders?.[0]?.price ?? 0);


// Task: A checkbox input value might be missing entirely (undefined). Write an assignment statement that reads const checkedState = formProp ?? false; to guarantee a clean boolean fallback state.
let formProp;
const checkedState = formProp ?? false;
console.log(checkedState);



// Task: Fix the syntax error in this statement by adding parentheses to ensure the logical OR resolves before the nullish check: const status = account.active || user.active ?? false;
let account = {
    active: true
};

let person = {
    active: false
};
const status = (account.active || person.active) ?? false;
console.log(status);

