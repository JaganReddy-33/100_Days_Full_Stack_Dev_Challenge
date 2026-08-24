import { Link } from "react-router-dom";

const Contact = () => {
  return (
    <div style={{ height: "50vh", padding: "20px", background: "#fff5f5" }}>
      <h1>Contact Page</h1>
      <p>Get in touch with us via email or using the mock fields below.</p>
      
      <form onSubmit={(e) => e.preventDefault()} style={{ margin: "20px 0" }}>
        <input type="text" placeholder="Your Name" style={{ display: "block", marginBottom: "10px" }} />
        <button type="submit">Submit</button>
      </form>

      <Link to="/">Back to Home</Link>
    </div>
  );
};

export default Contact;
