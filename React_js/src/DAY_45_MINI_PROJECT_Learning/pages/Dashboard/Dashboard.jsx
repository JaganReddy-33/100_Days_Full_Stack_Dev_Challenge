import StatsCards from "../../Components/StatsCards/StatsCards";
import Searchbar from "../../Components/SearchBar/Searchbar";
import ApplicationList from "../../Components/ApplicationList/ApplicationList";
import Pagination from "../../Components/Pagination/Pagination";
import ApplicationOverview from "../../Components/ApplicationOverview/ApplicationOverview";
import RecentActivity from "../../Components/RecentActivity/RecentActivity";
import InfoCard from "../../Components/InfoCard/InfoCard";
import "./Dashboard.css";

const Dashboard = () => {
  return (
    <div className="dashboard-layout-grid">
      <div className="dashboard-left-column">
        <StatsCards />
        <Searchbar />
        <div className="list-with-pagination">
          <ApplicationList />
          <Pagination />
        </div>
      </div>
      <aside className="dashboard-right-column">
        <ApplicationOverview />
        <RecentActivity />
        <InfoCard />
      </aside>
    </div>
  );
};
export default Dashboard;
