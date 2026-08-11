// import DAY_38 from './DAY_38_React_Basics/App';
// import DAY_39 from "./DAY_39_EventHandling_ConditionalRendering/App";
// import DAY_40 from "./DAY_40_UseEffect/App";
// import DAY_41 from "./DAY_41_UseRef_Forms/App";
import DAY_42 from "./DAY_42_Context_API/App";


const user = {
  name : "Jaganmohan",
  role: "Full Stack Dev",
  location: "Coimbatore"
};

function App() {

  return (
    <>
    {/* <DAY_38 /> */}
    {/* <DAY_39 /> */}
    {/* <DAY_40 /> */}
    {/* <DAY_41 /> */}
    <DAY_42 user={user}/>
    </>
  )
}

export default App
