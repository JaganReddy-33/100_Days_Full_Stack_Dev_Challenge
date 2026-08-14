import { useState } from "react";


const useToggle = (initialValue = false)=>{

    const [value, setValue] = useState(initialValue);
    
    const toggle = ()=>{
        setValue(prev => !prev);
    }

    const reset = ()=>{
        setValue(initialValue);
    }

    return [value, toggle, reset];
}

export default useToggle;