
const Button = ({
  children,
  type = "button",
  className = "",
  onClick,
}) => {
  return (
    <button
      type={type}
      className={`submit-button ${className}`}
      onClick={onClick}
    >
      {children}
    </button>
  );
};

export default Button;