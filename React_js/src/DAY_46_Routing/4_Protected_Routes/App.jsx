import { Route, Routes } from "react-router-dom";
import Home from "./Components/Home";
import Login from "./Components/Login";
import Dashboard from "./Components/Dashboard";
import ProtectedRoute from "./Components/ProtectedRoute";

import "./style.css";

const Applications = () => {
  return (
    <div className="simple-page">
      <h1>Applications</h1>
      <p>Your job applications are displayed here.</p>
    </div>
  );
};

const Statistics = () => {
  return (
    <div className="simple-page">
      <h1>Statistics</h1>
      <p>Your job search statistics are displayed here.</p>
    </div>
  );
};

const App = () => {
  return (

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />

        <Route element={<ProtectedRoute />}>
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/applications" element={<Applications />} />
          <Route path="/statistics" element={<Statistics />} />
        </Route>
      </Routes>
  );
};

export default App;