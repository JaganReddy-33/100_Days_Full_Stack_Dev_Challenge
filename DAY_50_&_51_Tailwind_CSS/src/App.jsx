import Dashboard from "./pages/Dashboard";
import { Route, Routes } from 'react-router-dom';


const App = () => {
  return (
    <div >
      <Routes>
        <Route path="/" element={<Dashboard />}/>
      </Routes>
    </div>
  )
}

export default App
