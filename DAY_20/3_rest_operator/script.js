
// rest operators

// Create a function sumAll(...nums) that accepts any number of numerical arguments and returns their sum.
function sumAll(...nums) {
  return nums.reduce((sum, num) => sum + num, 0);
}
console.log(sumAll(10, 20, 30, 40));



// Create a function countArguments(...args) that returns the total count of arguments passed into it.
function countArguments(...args) {
  return args.length;
}
console.log(countArguments('a', 'b', 'c', 'd', 'e'));



// Create a function showUser(firstName, lastName, ...hobbies) that logs the full name and captures all additional arguments into a hobbies array.
function showUser(firstName, lastName, ...hobbies) {
  console.log(`${firstName} ${lastName}`);
  return hobbies;
}
console.log(showUser('Alex', 'Smith', 'reading', 'cooking', 'gaming'));



// Create a function multiplyBy(factor, ...numbers) that multiplies every number in the numbers array by the first argument (factor).
function multiplyBy(factor, ...numbers) {
  return numbers.map(num => num * factor);
}
console.log(multiplyBy(2, 1, 2, 3, 4));



// Create a function ignoreFirst(first, ...rest) that returns only the rest array, completely ignoring the first argument.
function ignoreFirst(first, ...rest) {
  return rest;
}
console.log(ignoreFirst('ignoreMe', 'keep1', 'keep2', 'keep3'));



// Extract the first element of ['gold', 'silver', 'bronze', 'iron'] into winner and the remaining elements into a runnersUp array.
const [winner, ...runnersUp] = ['gold', 'silver', 'bronze', 'iron'];
console.log(winner, runnersUp);



// Extract the first two elements from [10, 20, 30, 40, 50] into x and y, then collect the remaining items into remainingNumbers.
const ele = [10, 20, 30, 40, 50];
const [x, y, ...remainingNumbers] = ele;
console.log(x, y, remainingNumbers);



// Skip the first element of ['skip', 'keep1', 'keep2', 'keep3'] and collect the remaining elements into a single array called validItems.
const [, ...validItems] = ['skip', 'keep1', 'keep2', 'keep3'];
console.log(validItems);



// Use array destructuring to grab the very first element into a variable head and the rest of the items into tail from an array containing only one element: ['lonely'].
const [head, ...tail] = ['lonely'];
console.log(head, tail);



// Extract password from { username: 'dev123', password: 'secretXP', email: 'dev@test.com' } and collect the remaining safe properties into an object named publicProfile.
const { password, ...publicProfile } = { username: 'dev123', password: 'secretXP', email: 'dev@test.com' };
console.log(password, publicProfile);




// Separate the configuration updates from the base system settings in this object, keeping theme out and storing everything else in a customConfigs object: { theme: 'dark', notifications: true, autoSave: false, volume: 80 }.
const { theme, ...customConfigs } = { theme: 'dark', notifications: true, autoSave: false, volume: 80 };
console.log(theme, customConfigs);



// Given { id: 99, title: 'Task 1', completed: false, priority: 'high' }, extract id and priority, and gather the rest of the core task fields into an object called taskData.
const { id, priority, ...taskData } = { id: 99, title: 'Task 1', completed: false, priority: 'high' };
console.log(id, priority, taskData);




// Write a function mergeAndClean(primaryKey, ...objects) that takes a key name as the first argument, gathers all subsequent objects into an array, and logs the gathered objects.
function mergeAndClean(primaryKey, ...objects) {
  console.log(objects);
}
mergeAndClean('userId', { name: 'Alice' }, { age: 30 });




// Destructure a nested object layout where you pull out status but gather the remaining nested data fields using rest: { status: 200, data: { user: 'Sam', role: 'editor', sessions: 5 } }. Gather role and sessions into a meta variable.
const { status, data: { user, ...meta } } = { status: 200, data: { user: 'Sam', role: 'editor', sessions: 5 } };
console.log(status, user, meta);



// Create a function dynamicGroup(type, ...items) that returns an object structured as { category: type, elements: items }.
function dynamicGroup(type, ...items) {
  return { category: type, elements: items };
}
console.log(dynamicGroup('fruits', 'apple', 'banana', 'orange'));
