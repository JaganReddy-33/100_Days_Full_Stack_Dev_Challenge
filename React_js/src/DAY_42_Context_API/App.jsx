import Navbar from "./Components/Navbar/Navbar";
import Profile from "./Components/Profile/Profile";
import { UserProvider } from "./Context/UserContext";

const App = () => {
  return (
    <UserProvider>
      <div>
        <Navbar />
        <Profile />
      </div>
    </UserProvider>
  );
};

export default App;
