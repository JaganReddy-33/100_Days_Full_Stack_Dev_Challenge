import { useState } from "react";


const useCounter = (initialValue = 0)=>{

    const [count, setCount] = useState(initialValue);

    const handleIncrement = ()=>{
        setCount(prev => prev + 1);
    }

    const handleDecrement = () =>{
        setCount(prev => prev - 1);
    }

    const reset = ()=>{
        setCount(initialValue);
    }

    return [count, handleIncrement, handleDecrement, reset]; 
}

export default useCounter;