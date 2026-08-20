import { Link, useNavigate } from "react-router-dom";

const Home = () => {
  const navigate = useNavigate();

  return (
    <div style={{ height: "50vh", padding: "20px", background: "#f9f9f9" }}>
      <h1>Home Page</h1>
      <p>Welcome to our practice website! This is the main landing area.</p>
      
      <div style={{ marginTop: "20px" }}>

        {/* standard navigation via Link component */}

        <Link to="/about" style={{ marginRight: "15px" }}>
          Go to About
        </Link>
        

        
        {/* programmatic routing via useNavigate hook */}

        <button onClick={() => navigate("/contact")}>
          Go to Contact
        </button>
      </div>
    </div>
  );
};

export default Home;
