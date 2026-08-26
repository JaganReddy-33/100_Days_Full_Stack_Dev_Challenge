import { NavLink } from "react-router-dom";
import { FaCalendarAlt, FaFlag, FaEllipsisH } from "react-icons/fa";

const TaskCard = () => {
  const tasks = [
    {
      id: 1,
      title: "Complete React Dashboard",
      description: "Finish the TaskFlow dashboard using Tailwind CSS.",
      category: "Development",
      priority: "High",
      dueDate: "Today, 6:00 PM",
      status: "In Progress",
    },
    {
      id: 2,
      title: "Practice Java Collections",
      description: "Revise List, Set, Map and solve practice problems.",
      category: "Learning",
      priority: "Medium",
      dueDate: "Tomorrow",
      status: "Pending",
    },
    {
      id: 3,
      title: "Update GitHub README",
      description: "Document the latest project progress and learning.",
      category: "Career",
      priority: "Low",
      dueDate: "Aug 28",
      status: "Completed",
    },
  ];

  return (
    <section className="mt-2 flex flex-col gap-5 sm:mt-4">

      <div className="flex items-center justify-between">
        <h2 className="text-xl font-bold text-slate-800 sm:text-2xl">
          My Tasks
        </h2>
      </div>

      <div className="flex flex-col gap-3 xl:flex-row xl:items-center xl:justify-between">

        <div className="flex w-full flex-wrap items-center gap-1 rounded-xl bg-white p-1 shadow-sm xl:w-auto">
          <NavLink
            to="/"
            className="rounded-lg bg-indigo-600 px-3 py-2 text-xs font-medium text-white sm:px-4 sm:text-sm"
          >
            All
          </NavLink>

          <NavLink
            to="/pending"
            className="rounded-lg px-3 py-2 text-xs font-medium text-slate-500 transition hover:bg-slate-100 hover:text-slate-800 sm:px-4 sm:text-sm"
          >
            Pending
          </NavLink>

          <NavLink
            to="/progress"
            className="rounded-lg px-3 py-2 text-xs font-medium text-slate-500 transition hover:bg-slate-100 hover:text-slate-800 sm:px-4 sm:text-sm"
          >
            In Progress
          </NavLink>

          <NavLink
            to="/completed"
            className="rounded-lg px-3 py-2 text-xs font-medium text-slate-500 transition hover:bg-slate-100 hover:text-slate-800 sm:px-4 sm:text-sm"
          >
            Completed
          </NavLink>
        </div>

        <button
          type="button"
          className="flex w-full items-center justify-between gap-2 rounded-xl border border-slate-200 bg-white px-4 py-2 text-sm font-medium text-slate-600 shadow-sm transition hover:border-indigo-300 hover:text-indigo-600 xl:w-auto"
        >
          Sort: Due Date
          <span className="text-xs">⌄</span>
        </button>
      </div>

      <div className="grid grid-cols-1 gap-4">
        {tasks.map((task) => (
          <article
            key={task.id}
            className="rounded-2xl border border-slate-200 bg-white p-4 shadow-sm transition-all duration-200 hover:-translate-y-0.5 hover:shadow-md sm:p-5"
          >
            <div className="flex items-start justify-between gap-3 sm:gap-5">

              <div className="flex min-w-0 flex-1 gap-3 sm:gap-4">

                <div className="mt-1 flex h-5 w-5 shrink-0 items-center justify-center rounded-md border-2 border-slate-300" />

                <div className="min-w-0 flex-1">

                  <div className="flex flex-col gap-2 sm:flex-row sm:items-center sm:gap-3">
                    <h3 className="truncate text-sm font-semibold text-slate-800 sm:text-base">
                      {task.title}
                    </h3>

                    <span
                      className={`w-fit rounded-full px-2.5 py-1 text-xs font-medium ${
                        task.status === "Completed"
                          ? "bg-emerald-50 text-emerald-600"
                          : task.status === "In Progress"
                          ? "bg-blue-50 text-blue-600"
                          : "bg-amber-50 text-amber-600"
                      }`}
                    >
                      {task.status}
                    </span>
                  </div>

                  <p className="mt-2 text-sm leading-relaxed text-slate-500">
                    {task.description}
                  </p>

                  <div className="mt-4 flex flex-wrap items-center gap-3 sm:gap-4">

                    <span className="rounded-lg bg-slate-100 px-3 py-1.5 text-xs font-medium text-slate-600">
                      {task.category}
                    </span>

                    <span
                      className={`flex items-center gap-1.5 text-xs font-medium ${
                        task.priority === "High"
                          ? "text-red-500"
                          : task.priority === "Medium"
                          ? "text-amber-500"
                          : "text-slate-400"
                      }`}
                    >
                      <FaFlag />
                      {task.priority}
                    </span>

                    <span className="flex items-center gap-1.5 text-xs font-medium text-slate-500">
                      <FaCalendarAlt />
                      {task.dueDate}
                    </span>

                  </div>
                </div>
              </div>

              <button
                type="button"
                className="shrink-0 rounded-lg p-2 text-slate-400 transition hover:bg-slate-100 hover:text-slate-700"
              >
                <FaEllipsisH />
              </button>

            </div>
          </article>
        ))}
      </div>
    </section>
  );
};

export default TaskCard;