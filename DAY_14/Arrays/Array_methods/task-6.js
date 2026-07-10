const tasks = [
  { id: 1, title: "Learn JS", completed: true },
  { id: 2, title: "Build Project", completed: false },
  { id: 3, title: "Practice DSA", completed: true },
  { id: 4, title: "Apply Jobs", completed: false }
];


// Get all task titles.
const getAllTitles = tasks.map((task)=>task.title);
console.log(getAllTitles);


// Get completed tasks.
const getCompletedTasks = tasks.filter((task)=>task.completed === true);
console.log(getCompletedTasks);


// Get pending tasks.
const pendingTasks = tasks.filter((task)=>task.completed !== true);
console.log(pendingTasks);


// Count completed tasks.
const countCompletedTasks = tasks.reduce((count, task)=>{
  let completedTasks = task.completed === true;
  return count + completedTasks;
}, 0);
console.log(countCompletedTasks);


// Count pending tasks.
const countPendingTasks = tasks.reduce((count, task)=>{
  let pendingTasks = task.completed !== true;
  return count + pendingTasks;
}, 0);
console.log(countPendingTasks);


// Check if all tasks are completed.
const checkAllTasks = tasks.every((task)=>task.completed === true);
console.log(checkAllTasks);


// Check if any task is completed.
const checkAnyTasks = tasks.some((task)=>task.completed === true);
console.log(checkAnyTasks);


// Get completed task titles.
const getCompletedTaskTitle = tasks
.filter((task)=>task.completed === true)
.map((task)=>task.title);

console.log(getCompletedTaskTitle);


// Find task id = 4.
const findGivenId = tasks.find((task)=>task.id === 4);
console.log(findGivenId);


// Remove task id = 2.
const revomeTaskId = tasks.filter((task)=>task.id !== 2);
console.log(revomeTaskId);