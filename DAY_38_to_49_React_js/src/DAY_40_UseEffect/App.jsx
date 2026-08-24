import Counter from "./Components/Counter/Counter";
import Timer from "./Components/Timer/Timer";
import Users from "./Components/Users/Users";
import WindowSize from "./Components/WindowSize/WindowSize";


const App = ()=>{
    return (
        <div>
            <Users />
            <Timer />
            <Counter />
            <WindowSize />
        </div>
    );
}

export default App;