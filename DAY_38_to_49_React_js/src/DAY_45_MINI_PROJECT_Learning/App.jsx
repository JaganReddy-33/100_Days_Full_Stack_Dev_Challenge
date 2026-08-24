import { BrowserRouter, Routes, Route } from "react-router-dom";
import Sidebar from "./Components/Sidebar/Sidebar";
import Header from "./Components/Header/Header";
import Dashboard from "./pages/Dashboard/Dashboard";
import "./App.css";
const App = () => {
  return (
    <BrowserRouter>
      <div className="dashboard-root">
        <Sidebar />
        <div className="dashboard-main-wrapper">
          <Header />
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/applications" element={<div>Applications Page</div>} />
            <Route path="/add-application" element={<div>Add Application Page</div>} />
            <Route path="/statistics" element={<div>Statistics Page</div>} />
            <Route path="/settings" element={<div>Settings Page</div>} />
          </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
};
export default App;
