import { FaRegClock } from "react-icons/fa";
import { MdOutlineRadioButtonUnchecked } from "react-icons/md";

const UpcomingTasks = () => {
  const upcomingTasks = [
    {
      id: 1,
      title: "Complete React Dashboard",
      date: "Today",
      time: "10:00 AM",
      priority: "High",
      color: "bg-red-100 text-red-600",
    },
    {
      id: 2,
      title: "Review Java Backend",
      date: "Tomorrow",
      time: "09:30 AM",
      priority: "Medium",
      color: "bg-yellow-100 text-yellow-600",
    },
    {
      id: 3,
      title: "Practice JDBC Queries",
      date: "Tomorrow",
      time: "02:00 PM",
      priority: "Medium",
      color: "bg-yellow-100 text-yellow-600",
    },
    {
      id: 4,
      title: "Build TaskFlow Components",
      date: "Aug 22",
      time: "11:00 AM",
      priority: "Low",
      color: "bg-green-100 text-green-600",
    },
  ];

  return (
    <section className="rounded-2xl bg-white p-4 shadow-sm ring-1 ring-slate-200 sm:p-5">

      <div className="mb-5 flex items-start justify-between gap-3">
        <div className="min-w-0">
          <h2 className="text-lg font-bold text-slate-800">
            Upcoming Tasks
          </h2>

          <p className="mt-1 text-xs text-slate-400">
            Your next scheduled tasks
          </p>
        </div>

        <button
          type="button"
          className="shrink-0 text-sm font-semibold text-indigo-600 transition hover:text-indigo-500"
        >
          View All
        </button>
      </div>

      <div className="flex flex-col gap-3">
        {upcomingTasks.map((task) => (
          <div
            key={task.id}
            className="flex items-center gap-3 rounded-xl border border-slate-100 p-3 transition hover:border-indigo-100 hover:bg-indigo-50/40"
          >
            <MdOutlineRadioButtonUnchecked className="shrink-0 text-xl text-slate-300" />

            <div className="min-w-0 flex-1">
              <h3 className="truncate text-sm font-semibold text-slate-700">
                {task.title}
              </h3>

              <div className="mt-1 flex items-center gap-2 text-xs text-slate-400">
                <FaRegClock className="shrink-0" />

                <span className="truncate">
                  {task.date} • {task.time}
                </span>
              </div>
            </div>

            <span
              className={`shrink-0 rounded-full px-2 py-1 text-[10px] font-semibold sm:px-2.5 sm:text-xs ${task.color}`}
            >
              {task.priority}
            </span>
          </div>
        ))}
      </div>
    </section>
  );
};

export default UpcomingTasks;