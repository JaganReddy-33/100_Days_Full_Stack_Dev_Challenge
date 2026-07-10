
const users = [
    {id: 1, name: "Jagan", age: 22, active: true},
    {id: 2, name: "Rahul", age: 17, active: false},
    {id: 3, name: "Priya", age: 25, active: true},
    {id: 4, name: "Alex",  age: 30, active: false}
];

const getAllUsers = users.map((user)=>user.name);
console.log(getAllUsers);


const getActiveUsers = users.filter((user)=>{
    let res = user.active === true;
    return res;
});
console.log(getActiveUsers);


const getUserAge = users.filter((user)=>user.age>18);
console.log(getUserAge);



const findUser = users.find((user)=>user.id === 3);
console.log(findUser);


const checkUserAge = users.some((user)=>user.age < 18);
console.log(checkUserAge);



const countActiveUsers = users.reduce((total, user)=>{
    let activeUsers = user.active === true;
    return total += activeUsers;
}, 0);
console.log(countActiveUsers);


const avgAge = users.reduce((total, user)=>{
    total += user.age;
    return total;
}, 0);
let result = avgAge/users.length;
console.log(result);


const activeNames = users
.filter((user)=>user.active === true)
.map(user => user.name);

console.log(activeNames);

