import { IoMdNotifications } from "react-icons/io";
import { CgProfile } from "react-icons/cg";
import { FaAngleDown, FaBars } from "react-icons/fa";

const Header = ({ onMenuClick }) => {
  return (
    <header className="fixed left-0 right-0 top-0 z-30 border-b border-slate-200 bg-white px-4 py-3 shadow-sm sm:px-6 lg:left-64 lg:px-8">
      <div className="flex items-center justify-between gap-4">

        <div className="flex min-w-0 flex-1 items-center gap-3">
          <button
            type="button"
            onClick={onMenuClick}
            className="flex h-10 w-10 shrink-0 items-center justify-center rounded-xl bg-indigo-50 text-indigo-600 transition hover:bg-indigo-100 lg:hidden"
          >
            <FaBars />
          </button>

          <div className="w-full max-w-md">
            <input
              type="text"
              placeholder="Search tasks..."
              className="w-full rounded-xl border border-slate-200 bg-slate-50 px-4 py-2.5 text-sm text-slate-700 outline-none transition focus:border-indigo-400 focus:bg-white focus:ring-2 focus:ring-indigo-400/20"
            />
          </div>
        </div>

        <div className="flex shrink-0 items-center gap-2 sm:gap-4">

          <button
            type="button"
            className="flex h-10 w-10 items-center justify-center rounded-full bg-blue-100 text-blue-600 transition hover:bg-blue-200"
          >
            <IoMdNotifications className="text-xl" />
          </button>

          <div className="flex items-center gap-2">
            <CgProfile className="text-2xl text-indigo-600" />

            <span className="hidden text-sm font-semibold text-slate-700 md:block">
              Jaganmohan Reddy
            </span>

            <FaAngleDown className="hidden text-xs text-slate-400 sm:block" />
          </div>

        </div>
      </div>
    </header>
  );
};

export default Header;