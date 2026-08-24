import { useNavigate } from "react-router-dom";

const About = () => {
  const navigate = useNavigate();

  return (
    <div style={{ height: "50vh", padding: "20px", background: "#f0f4f8" }}>
      <h1>About Page</h1>
      <p>We are learning Single Page Application (SPA) routing with React Router v6!</p>
      
      <div style={{ marginTop: "20px" }}>
        <button onClick={() => navigate("/")}>
          Return Home
        </button>
      </div>
    </div>
  );
};

export default About;
