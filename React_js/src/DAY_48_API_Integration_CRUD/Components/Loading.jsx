import "./Loading.css";

const Loading = () => {
  return (
    <div className="loading-container">
      <div className="loading-spinner"></div>
      <h2>Loading Products</h2>
      <p>Please wait while we fetch the products...</p>
    </div>
  );
};

export default Loading;