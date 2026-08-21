import { Link, Route, Routes } from "react-router-dom";

import Dashboard from "./Components/Dashboard";
import Overview from "./Components/Overview";
import Applications from "./Components/Applications";
import Statistics from "./Components/Statistics";

import "./App.css";

const App = () => {
  return (
    <div className="app-container">
      <div className="top-bar">
        <h1>JobTrack</h1>
        <Link to="/dashboard" className="dashboard-link">
          Open Dashboard
        </Link>
      </div>

      <Routes>
        <Route path="/dashboard" element={<Dashboard />}>
        
          <Route index element={<Overview />} />

          <Route path="applications" element={<Applications />} />

          <Route path="statistics" element={<Statistics />} />
        </Route>
      </Routes>
    </div>
  );
};

export default App;