import { NavLink } from "react-router-dom";
import { MdAddTask } from "react-icons/md";
import { IoHome, IoSettings } from "react-icons/io5";
import { BiTask } from "react-icons/bi";
import { TiStarFullOutline } from "react-icons/ti";
import { SiGoogletasks as CompletedIcon } from "react-icons/si";
import { FaCrown } from "react-icons/fa";
import { IoClose } from "react-icons/io5";

const Sidebar = ({ isOpen, onClose }) => {
  const navItems = [
    {
      path: "/",
      label: "Dashboard",
      icon: <IoHome />,
    },
    {
      path: "/tasks",
      label: "My Tasks",
      icon: <BiTask />,
    },
    {
      path: "/important",
      label: "Important",
      icon: <TiStarFullOutline />,
    },
    {
      path: "/completed",
      label: "Completed",
      icon: <CompletedIcon />,
    },
    {
      path: "/settings",
      label: "Settings",
      icon: <IoSettings />,
    },
  ];

  return (
    <>
      {isOpen && (
        <div
          className="fixed inset-0 z-40 bg-black/50 lg:hidden"
          onClick={onClose}
        />
      )}

      <aside
        className={`fixed left-0 top-0 z-50 flex h-screen w-64 shrink-0 flex-col bg-[#11183f] p-5 text-white shadow-xl transition-transform duration-300 ${
          isOpen ? "translate-x-0" : "-translate-x-full"
        } lg:translate-x-0`}
      >
        <div className="mb-8 flex items-center justify-between">
          <div className="flex items-center gap-3">
            <div className="flex h-11 w-11 shrink-0 items-center justify-center rounded-xl bg-indigo-500 shadow-lg shadow-indigo-500/30">
              <MdAddTask className="text-3xl text-white" />
            </div>

            <div>
              <h1 className="text-lg font-bold leading-tight text-white">
                TaskFlow
              </h1>

              <p className="text-xs text-slate-300">
                Get Things Done!
              </p>
            </div>
          </div>

          <button
            type="button"
            onClick={onClose}
            className="rounded-lg p-2 text-slate-300 hover:bg-white/10 hover:text-white lg:hidden"
          >
            <IoClose className="text-xl" />
          </button>
        </div>

        <nav className="flex flex-col gap-2">
          {navItems.map((item) => (
            <NavLink
              key={item.path}
              to={item.path}
              onClick={onClose}
              className={({ isActive }) =>
                `flex items-center gap-3 rounded-xl px-4 py-3 text-sm transition-all duration-200 ${
                  isActive
                    ? "bg-indigo-600 font-semibold text-white shadow-lg shadow-indigo-600/20"
                    : "text-slate-300 hover:bg-indigo-500/20 hover:text-white"
                }`
              }
            >
              <span className="flex items-center justify-center text-xl">
                {item.icon}
              </span>

              <span>{item.label}</span>
            </NavLink>
          ))}
        </nav>

        <div className="mt-auto rounded-2xl border border-indigo-400/20 bg-indigo-900/70 p-5 text-center shadow-lg">
          <div className="mx-auto mb-3 flex h-11 w-11 items-center justify-center rounded-full bg-indigo-600 shadow-lg shadow-indigo-500/30">
            <FaCrown className="text-lg text-yellow-300" />
          </div>

          <h3 className="mb-1 text-sm font-bold text-white">
            Upgrade to Pro
          </h3>

          <p className="mb-4 text-xs leading-relaxed text-slate-300">
            Get more features and boost your productivity.
          </p>

          <button
            type="button"
            className="w-full rounded-lg bg-indigo-500 py-2.5 text-sm font-semibold text-white transition-all duration-200 hover:bg-indigo-400 hover:shadow-lg hover:shadow-indigo-500/30"
          >
            Upgrade
          </button>
        </div>
      </aside>
    </>
  );
};

export default Sidebar;