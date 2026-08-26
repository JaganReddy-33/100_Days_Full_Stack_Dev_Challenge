import { FaArrowUp } from "react-icons/fa";

const ProductivityCard = () => {
  const productivityData = [
    { day: "Mon", value: 45 },
    { day: "Tue", value: 58 },
    { day: "Wed", value: 47 },
    { day: "Thu", value: 68 },
    { day: "Fri", value: 78 },
    { day: "Sat", value: 82 },
    { day: "Sun", value: 92 },
  ];

  const points = productivityData
    .map((item, index) => {
      const x = 20 + index * 42;
      const y = 100 - item.value * 0.8;

      return `${x},${y}`;
    })
    .join(" ");

  return (
    <section className="overflow-hidden rounded-2xl bg-[#21145f] p-4 text-white shadow-lg sm:p-5">

      <div className="mb-5 flex items-start justify-between gap-4">
        <div>
          <h2 className="text-sm font-semibold">
            Productivity This Week
          </h2>

          <div className="mt-2 flex items-center gap-2">
            <FaArrowUp className="text-xs text-emerald-400" />

            <span className="text-xs font-medium text-emerald-400">
              12%
            </span>
          </div>
        </div>

        <span className="text-2xl font-bold sm:text-3xl">
          78%
        </span>
      </div>

      <div className="relative h-36 w-full sm:h-40">
        <div className="absolute inset-0 flex flex-col justify-between">
          <span className="border-t border-white/10" />
          <span className="border-t border-white/10" />
          <span className="border-t border-white/10" />
          <span className="border-t border-white/10" />
        </div>

        <svg
          viewBox="0 0 280 120"
          className="absolute inset-0 h-full w-full"
          preserveAspectRatio="none"
        >
          <polyline
            points={points}
            fill="none"
            stroke="currentColor"
            strokeWidth="3"
            strokeLinecap="round"
            strokeLinejoin="round"
            className="text-indigo-400"
          />

          {productivityData.map((item, index) => {
            const x = 20 + index * 42;
            const y = 100 - item.value * 0.8;

            return (
              <circle
                key={item.day}
                cx={x}
                cy={y}
                r="4"
                className="fill-indigo-400 stroke-white"
                strokeWidth="2"
              />
            );
          })}
        </svg>
      </div>

      <div className="mt-3 grid grid-cols-7 text-center text-[10px] text-slate-300 sm:text-xs">
        {productivityData.map((item) => (
          <span key={item.day}>
            {item.day}
          </span>
        ))}
      </div>
    </section>
  );
};

export default ProductivityCard;