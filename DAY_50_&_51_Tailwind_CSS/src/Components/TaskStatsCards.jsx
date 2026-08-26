import { FaTasks } from "react-icons/fa";
import { MdPendingActions } from "react-icons/md";
import { IoCheckmarkDoneCircle } from "react-icons/io5";
import { BsCalendarCheck } from "react-icons/bs";

const TaskStatsCards = () => {
  const statCards = [
    {
      label: "Total Tasks",
      icon: FaTasks,
      count: 24,
      statistics: "+12% from last week",
      color: "bg-indigo-50 text-indigo-600",
      statisticColor: "text-emerald-600",
    },
    {
      label: "Pending",
      icon: MdPendingActions,
      count: 8,
      statistics: "-5% from last week",
      color: "bg-amber-50 text-amber-600",
      statisticColor: "text-red-500",
    },
    {
      label: "Completed",
      icon: IoCheckmarkDoneCircle,
      count: 14,
      statistics: "+20% from last week",
      color: "bg-emerald-50 text-emerald-600",
      statisticColor: "text-emerald-600",
    },
    {
      label: "Today",
      icon: BsCalendarCheck,
      count: 6,
      statistics: "+2% from yesterday",
      color: "bg-blue-50 text-blue-600",
      statisticColor: "text-emerald-600",
    },
  ];

  return (
    <div className="flex w-full flex-col gap-6">

      <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
        <div>
          <h2 className="text-xl font-bold text-slate-800 sm:text-2xl">
            Good Morning, Jagan! 👋
          </h2>

          <p className="mt-1 text-sm text-slate-500">
            Let's make today productive. You have 5 tasks pending.
          </p>
        </div>

        <button
          type="button"
          className="w-full cursor-pointer rounded-lg bg-indigo-500 px-4 py-2.5 text-sm font-semibold text-white transition-all duration-200 hover:bg-indigo-400 hover:shadow-lg hover:shadow-indigo-500/30 sm:w-auto"
        >
          + Add Task
        </button>
      </div>

      <div className="grid grid-cols-1 gap-4 sm:grid-cols-2 xl:grid-cols-4">
        {statCards.map((card) => {
          const Icon = card.icon;

          return (
            <div
              key={card.label}
              className="rounded-2xl border border-slate-200 bg-white p-5 shadow-sm transition-all duration-200 hover:-translate-y-1 hover:shadow-md"
            >
              <div className="flex items-center justify-between">
                <div>
                  <p className="text-sm font-medium text-slate-500">
                    {card.label}
                  </p>

                  <h3 className="mt-2 text-3xl font-bold text-slate-800">
                    {card.count}
                  </h3>
                </div>

                <div
                  className={`flex h-11 w-11 items-center justify-center rounded-xl ${card.color}`}
                >
                  <Icon className="text-xl" />
                </div>
              </div>

              <p
                className={`mt-4 text-xs font-medium ${card.statisticColor}`}
              >
                {card.statistics}
              </p>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default TaskStatsCards;