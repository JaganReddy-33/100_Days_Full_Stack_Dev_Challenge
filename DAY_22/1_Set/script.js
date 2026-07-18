
// Set Collection

// What is a Set?
// A Set is a special JavaScript object that ***(stores only unique values)***.

// Unlike arrays:
// Arrays ***(allow duplicates)***.
// Sets automatically ***(remove duplicates)***.

// Normal Array
const arr = [1, 2, 2, 4, 5, 6, 6, 6];
console.log(arr);

// using Set Array
const setArr = new Set([1, 2, 2, 4, 5, 6, 6, 6]);
console.log(setArr);



// without set
const emails = [];
emails.push("abc@gamil.com");
emails.push("xyz@gamil.com");
emails.push("abc@gamil.com");
emails.push("abc@gamil.com");
emails.push("xyz@gamil.com");

console.log(emails);

// with set
const setEmails = new Set();
setEmails.add("abc@gamil.com");
setEmails.add("xyz@gamil.com");
setEmails.add("abc@gamil.com");
setEmails.add("abc@gamil.com");
setEmails.add("xyz@gamil.com");

console.log(setEmails);


// Creating a Set (set stores any data type: Numbers, boolean, String, char, Objects, mixed data types)

// method 1 - Empty set
const fruits = new Set();
console.log(fruits);

// method 2 - Create from an Array
const arrFruits = new Set(["Apple", "banana", "guava", "banana", "mango", "Apple"]);
console.log(arrFruits);


// Practice examples

// Initialize empty: const set = new Set();
const set = new Set();
console.log(set);

// Add different types: set.add(10).add("hello").add(true);
set.add(10);
set.add("hello");
set.add(true);
console.log(set);


// Strict equality comparison: set.add(5).add("5"); (Both coexist because types differ).
set.add(5);
set.add("5");
console.log(set);


// Checking missing items: set.has("missing"); (Returns false).
let check = set.has("missing");
console.log(check);

let check1 = set.has("hello");
console.log(check1);


// Deleting missing items: set.delete("missing"); (Returns false).
let del = set.delete("missing");
console.log(del);

let del2 = set.delete("hello");
console.log(del2);

console.log(set);

// Checking size after clear: set.clear(); console.log(set.size); (Returns 0).
set.clear();
console.log(set);


// Deduplicate a string array: [...new Set(["a", "b", "a"])] yields ["a", "b"].
const uniqueArr = [...new Set(["a", "b", "a"])];
console.log(uniqueArr);


// Convert string to unique chars: new Set("hello") yields Set(4) { 'h', 'e', 'l', 'o' }.
const uniqueCharSet = new Set("hello");
console.log(uniqueCharSet);
const uniqueCharArray = [...new Set("hello")];
console.log(uniqueCharArray);



// Object references: set.add({}); set.add({}); (Both are added because they point to different memory addresses).
const setObj = new Set();
setObj.add({});
setObj.add({});
console.log(setObj);


// Identical object references: const obj = {}; set.add(obj); set.add(obj); (Added only once).
const obj = {};
const setObj2 = new Set();
setObj2.add(obj);
setObj2.add(obj);
console.log(setObj2);


// Deduplicate Array: Write a function that takes an array with duplicate numbers and returns a clean array with unique numbers.
const checkDuplicates = function(numArr){
    return [...new Set(numArr)];
}
console.log(checkDuplicates([1, 2, 3, 4, 3, 4, 1, 6]));


// Tag System: Create a system where a user can type tags for a blog post. Ensure no duplicate tags can be added using a Set.
function checkTags(rawTagsArr){
    const uniqueTags = new Set();

    for(const tag of rawTagsArr){
        const cleanTag = tag.trim().toLowerCase();
        // const cleanTag = tag.trim(); //with out converting into lowercase

        if(cleanTag !== "" && !uniqueTags.has(cleanTag)){
            uniqueTags.add(cleanTag);
        }
    }
    return [...uniqueTags];
}
console.log(checkTags([" JavaScript", "html", "javascript ", "CSS", "", "HTML"]));


// Unique Visitors: Create an array of simulated IP addresses checking into a server. Use a Set to calculate total unique visitors.Array containing unique, valid IPv4 and IPv6 sample addresses

function checkUniqueVisitors(rawIPAddressData) {

    const ipv4Regex = /^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;

    const ipv6Regex = /^(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,5}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))$/;

    const uniqueAddress = new Set();

    for(let address of rawIPAddressData){
        let cleanIp = address.trim().replace(/[/[/]]/g, '').toLowerCase();

        const isValid = ipv4Regex.test(cleanIp) || ipv6Regex.test(cleanIp);

        if(isValid){
            uniqueAddress.add(cleanIp);
        }
    }
    return [...uniqueAddress];
}


const ipAddresses = [
    "192.168.1.1 ", 
    "8.8.8.8", 
    "invalid_ip_string", 
    "[2001:db8::1]", 
    "192.168.1.1", 
    "2001:DB8::1"
];
let res = checkUniqueVisitors(ipAddresses) 
console.log(res);


const names = new Set(["Jagan", "Lohith", "Ajay", "Sathi"]);
for (const name of names) {
    console.log(name);
}

