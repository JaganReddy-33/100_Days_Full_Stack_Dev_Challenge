import React, { useState } from "react";



const Child = React.memo(() => {

    const [name, setName] = useState("Jagan");

    const handleNameChange = () =>{
        setName("Lohith")
    }

    console.log("Child rendered!");
    return (
        <div>
            <p>Hello {name} from Children!</p>
            <button onClick={handleNameChange}>Change Name</button>
        </div>
    );
});

const ReactMemo = () => {
    
    const [count, setCount] = useState(0);

    console.log("Parent rendered!");

  return (
    <div>
      <h2>{count}</h2>
      <button onClick={()=>setCount(prev => prev+1)}>Increment</button>
      <Child />   
    </div>
  )
}

export default ReactMemo
