import { Routes, Route, Link, NavLink, useLocation } from "react-router-dom";
import About from "./Components/About";
import Contact from "./Components/Contact";
import Home from "./Components/Home";
import "./App.css";

const App = () => {
  const location = useLocation();
  console.log("Active pathname:", location.pathname);

  return (
    <div style={{ padding: "20px" }}>
      <h3>Using Link</h3>
      <nav style={{ marginBottom: "20px" }}>
        <Link to="/" style={{ marginRight: "10px" }}>Home</Link>
        <Link to="/about" style={{ marginRight: "10px" }}>About</Link>
        <Link to="/contact">Contact</Link>
      </nav>

      <h3>Using NavLink</h3>
      <nav style={{ marginBottom: "20px" }}>
        <NavLink
          to="/"
          end
          style={({ isActive }) => ({
            color: isActive ? "red" : "white",
            fontWeight: isActive ? "bold" : "normal",
          })}
        >
          Home
        </NavLink>
        <br />
        <NavLink
          to="/about"
          style={({ isActive }) => ({
            color: isActive ? "red" : "white",
            fontWeight: isActive ? "bold" : "normal",
          })}
        >
          About
        </NavLink>
        <br />
        <NavLink
          to="/contact"
          style={({ isActive }) => ({
            color: isActive ? "red" : "white",
            fontWeight: isActive ? "bold" : "normal",
          })}
        >
          Contact
        </NavLink>
      </nav>

      <hr />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
      </Routes>
    </div>
  );
};

export default App;
