import { useState } from "react";
import { FaChevronLeft, FaChevronRight } from "react-icons/fa";

const Calendar = () => {
  const [currentDate, setCurrentDate] = useState(new Date());

  const year = currentDate.getFullYear();
  const month = currentDate.getMonth();

  const monthName = currentDate.toLocaleString("default", {
    month: "long",
  });

  const firstDay = new Date(year, month, 1).getDay();
  const daysInMonth = new Date(year, month + 1, 0).getDate();

  const previousMonth = () => {
    setCurrentDate(new Date(year, month - 1, 1));
  };

  const nextMonth = () => {
    setCurrentDate(new Date(year, month + 1, 1));
  };

  const today = new Date();

  const isToday = (day) => {
    return (
      day === today.getDate() &&
      month === today.getMonth() &&
      year === today.getFullYear()
    );
  };

  const days = [];

  for (let i = 0; i < firstDay; i++) {
    days.push(
      <div
        key={`empty-${i}`}
        className="h-8 sm:h-9"
      />
    );
  }

  for (let day = 1; day <= daysInMonth; day++) {
    days.push(
      <button
        key={day}
        type="button"
        className={`flex h-8 w-8 items-center justify-center rounded-lg text-xs transition sm:h-9 sm:w-9 sm:text-sm ${
          isToday(day)
            ? "bg-indigo-600 font-bold text-white shadow-md shadow-indigo-500/30"
            : "text-slate-600 hover:bg-indigo-50 hover:text-indigo-600"
        }`}
      >
        {day}
      </button>
    );
  }

  return (
    <section className="rounded-2xl bg-white p-4 shadow-sm ring-1 ring-slate-200 sm:p-5">

      <div className="mb-5 flex items-center justify-between">
        <h2 className="text-lg font-bold text-slate-800">
          Calendar
        </h2>

        <div className="flex items-center gap-1">
          <button
            type="button"
            onClick={previousMonth}
            className="flex h-8 w-8 items-center justify-center rounded-lg text-slate-500 transition hover:bg-indigo-50 hover:text-indigo-600"
          >
            <FaChevronLeft className="text-xs" />
          </button>

          <button
            type="button"
            onClick={nextMonth}
            className="flex h-8 w-8 items-center justify-center rounded-lg text-slate-500 transition hover:bg-indigo-50 hover:text-indigo-600"
          >
            <FaChevronRight className="text-xs" />
          </button>
        </div>
      </div>

      <div className="mb-4 text-center">
        <h3 className="text-sm font-semibold text-slate-700">
          {monthName} {year}
        </h3>
      </div>

      <div className="mb-2 grid grid-cols-7 text-center">
        {["S", "M", "T", "W", "T", "F", "S"].map(
          (day, index) => (
            <span
              key={`${day}-${index}`}
              className="text-xs font-semibold text-slate-400"
            >
              {day}
            </span>
          )
        )}
      </div>

      <div className="grid grid-cols-7 place-items-center gap-y-1">
        {days}
      </div>
    </section>
  );
};

export default Calendar;