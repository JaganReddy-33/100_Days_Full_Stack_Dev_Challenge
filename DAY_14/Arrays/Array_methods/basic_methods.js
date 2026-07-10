
// Shift / Unshift / Push / Pop

// --- BROWSER TAB MANAGEMENT ---
const browserTabs = ['google.com', 'github.com'];
browserTabs.push('stackoverflow.com');
console.log("Opened a new tab at the end:", browserTabs);

const closedTab = browserTabs.pop();
console.log("Closed the last active tab:", browserTabs);
console.log("Tab that was closed:", closedTab);

const closedFirstTab = browserTabs.shift();
console.log("Closed the very first tab on the left:", browserTabs);
console.log("First tab that was closed:", closedFirstTab);

browserTabs.unshift('youtube.com');
console.log("Opened an urgent tab at the absolute front:", browserTabs);



// --- CALL CENTER PHONE SYSTEM QUEUE ---
const callQueue = ['Customer A', 'Customer B'];
callQueue.push('Customer C');
console.log("New caller joined the back of the queue:", callQueue);

const hungUp = callQueue.pop();
console.log("Last caller in line hung up early:", callQueue);
console.log("Customer who hung up:", hungUp);

const answeredCall = callQueue.shift();
console.log("Agent answered the first customer in line:", callQueue);
console.log("Customer being served now:", answeredCall);

callQueue.unshift('VIP Emergency Call');
console.log("VIP customer cut to the front of the queue:", callQueue);

// --- TEXT EDITOR UNDO/REDO ENGINE ---
const textHistory = ['Typed "Hello"', 'Typed "World"'];
textHistory.push('Typed "!"');
console.log("User typed a new character at the end:", textHistory);

const undoneAction = textHistory.pop();
console.log("User hit Ctrl+Z to undo the last action:", textHistory);
console.log("Action that was undone:", undoneAction);

const memoryPurged = textHistory.shift();
console.log("System cleared the oldest history to save memory:", textHistory);
console.log("Oldest action deleted:", memoryPurged);

textHistory.unshift('Auto-saved state');
console.log("System forced a recovery state into the front:", textHistory);

// --- VIDEO GAME INVENTORY QUICK-SLOTS ---
const quickSlots = ['Health Potion', 'Iron Shield'];
quickSlots.push('Steel Sword');
console.log("Picked up an item and stored it at the end:", quickSlots);

const droppedItem = quickSlots.pop();
console.log("Dropped the item from the last slot:", quickSlots);
console.log("Item dropped on the ground:", droppedItem);

const usedItem = quickSlots.shift();
console.log("Used the item from the primary hotkey slot:", quickSlots);
console.log("Item consumed:", usedItem);

quickSlots.unshift('Golden Apple');
console.log("Equipped a critical item into the primary hotkey slot:", quickSlots);
