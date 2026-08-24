import { useMemo, useState } from "react"

const UseMemo = () => {

    const [count, setCount] = useState(0);
    const [number, setNumber] = useState(5);

    const expensiveCal = useMemo(()=>{
        console.log("Calculating....");
        return number*10;
    }, [number])

    const result = expensiveCal;

  return (
    <div>
      <h2>{count}</h2>
      <button onClick={()=>setCount(prev => prev + 1)}>Increment Count</button>

      <h2>{number}</h2>
      <button onClick={()=> setNumber(prev => prev+1)}>Increment Number</button>

      <h2>Result: {result}</h2>
    </div>
  )
}

export default UseMemo
