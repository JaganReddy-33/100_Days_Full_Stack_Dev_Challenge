import React, { useCallback, useState } from "react"


const Child = React.memo(({handleClick})=>{
    console.log("Child rendered!");

    return (
        <div>
            <button onClick={handleClick}>Child Button</button>
        </div>
    );
});



const UseCallback = () => {

    const [count, setCount] = useState(0);

    console.log("Parent rendered!");

    const handleClick = useCallback(()=>{
        console.log("Child button clicked!");
    }, []);

  return (
    <div>
      <h2>{count}</h2>
      <button onClick={()=>setCount(prev => prev + 1)}>Increase</button>
      
      <Child handleClick= {handleClick}/>
    </div>
  )
}

export default UseCallback
