import Sidebar from "./Components/Sidebar/Sidebar";
import Header from "./Components/Header/Header";
import StatsCards from "./Components/StatsCards/StatsCards";
import Searchbar from "./Components/SearchBar/Searchbar";
import ApplicationList from "./Components/ApplicationList/ApplicationList";
import "./App.css";
const App = () => {
  return (
    <div className="dashboard-root">
      <Sidebar />
      <div className="dashboard-main-wrapper">
        <Header />
        <main className="dashboard-content-scroll">
          <StatsCards />
          <Searchbar />
          <ApplicationList />
        </main>
      </div>
    </div>
  );
};
export default App;
