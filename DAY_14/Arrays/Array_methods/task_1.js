const products = [
    {name: "Laptop", price: 50000},
    {name: "Mouse", price: 500},
    {name: "Keyboard", price: 1500}
];

const ProductNames = products.map((item)=>item.name);
console.log(ProductNames);

const productsAboveNum = products.filter((product)=>{
    return product.price >= 1000;
});
console.log(productsAboveNum);

const findProduct = products.find((item)=>{
    return item.name === "Mouse";
})
console.log(findProduct);


const totalPrice = products.reduce((total, item)=>{
    return total + item.price;
}, 0);
console.log("Total Price: "+totalPrice);

const moreThanProducts = products.some((item)=>{
    let res = item.price >= 40000;
    return res;
})
console.log(moreThanProducts);