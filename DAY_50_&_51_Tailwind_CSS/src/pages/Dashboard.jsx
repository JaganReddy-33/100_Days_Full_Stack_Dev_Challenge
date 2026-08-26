import { useState } from "react";
import Calendar from "../Components/Calendar";
import Header from "../Components/Header";
import ProductivityCard from "../Components/ProductivityCard";
import Sidebar from "../Components/Sidebar";
import TaskCard from "../Components/TaskCard";
import TaskStatsCards from "../Components/TaskStatsCards";
import UpcomingTasks from "../Components/UpcomingTasks";
import TaskForm from "../Components/TaskForm";

const Dashboard = () => {
  const [isSidebarOpen, setIsSidebarOpen] = useState(false);

  return (
    <div className="min-h-screen bg-slate-100">
      <Sidebar
        isOpen={isSidebarOpen}
        onClose={() => setIsSidebarOpen(false)}
      />

      <div className="min-h-screen lg:pl-64">
        <Header
          onMenuClick={() => setIsSidebarOpen(true)}
        />

        <main className="px-4 pb-8 pt-24 sm:px-6 lg:px-8">
          <div className="mx-auto max-w-[1600px]">
            <div className="grid grid-cols-1 gap-6 xl:grid-cols-3">

              <div className="flex min-w-0 flex-col gap-6 xl:col-span-2">
                <TaskStatsCards />
                <TaskCard />
              </div>

              <div className="flex min-w-0 flex-col gap-6">
                <Calendar />
                <UpcomingTasks />
                <ProductivityCard />
              </div>

            </div>
          </div>
        </main>
      </div>
    </div>
  );
};

export default Dashboard;