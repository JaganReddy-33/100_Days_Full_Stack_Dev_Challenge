import { useEffect, useState } from "react";
import "./Users.css";

const Users = () => {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        setLoading(true);
        const res = await fetch("https://jsonplaceholder.typicode.com/users");
        if(!res.ok){
            throw new Error("Failed to fetch data!");
        }
        const data = await res.json();
        setUsers(data);
        // console.log(data);
      } catch (error) {
        setError(error.message || "Something went wrong!");
      } finally {
        setLoading(false);
      }
    };

    fetchUsers();
  }, []);

  if(loading){
    return <div className="loading-state">Loading users...</div>;
  }

  if(error){
    return <div className="error-state">Error: {error}</div>;
  }

  return (
    <div className="Card-section">
      {users.map((user) => (
        <div key={user.id} className="user-card">
          <h2>Name: {user.name}</h2>
          <p>
            <strong>Email:</strong> {user.email}
          </p>
          <p>
            <strong>Company:</strong> {user.company.name}
          </p>
          <strong>Website:</strong>{" "}
          <a href={user.website} target="_blank">
            {user.website}
          </a>
          <address className="address">
            <strong>Address: </strong>
            <p>City: {user.address.city}</p>
            <p>Street: {user.address.street}</p>
            <p>Phone Number: {user.phone}</p>
          </address>
          <div className="username">{user.username}</div>
        </div>
      ))}
    </div>
  );
};

export default Users;
