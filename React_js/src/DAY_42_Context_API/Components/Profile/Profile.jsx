

const Profile = ({ name, role, location }) => {
  return (
    <div>
      <h2>Name: {name}</h2>
      <p>Role: {role}</p>
      <p>Location: {location}</p>
    </div>
  );
};

export default Profile;