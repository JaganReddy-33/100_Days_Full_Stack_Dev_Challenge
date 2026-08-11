import { useContext } from "react";
import { UserContext } from "../../Context/UserContext";


const Profile = () => {

  const {user, isLoggedIn} = useContext(UserContext);

  if(!isLoggedIn){
    return <p>Please login to view your Profile</p>
  }

  return (
    <div>
      <h2>Name: {user.name}</h2>
      <p>Role: {user.role}</p>
      <p>Location: {user.location}</p>
    </div>
  );
};

export default Profile;