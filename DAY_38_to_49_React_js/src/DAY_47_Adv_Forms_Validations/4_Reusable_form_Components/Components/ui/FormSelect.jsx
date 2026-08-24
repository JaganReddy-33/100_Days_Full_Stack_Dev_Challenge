
import FormError from "./FormError";

const FormSelect = ({
  label,
  name,
  value,
  onChange,
  error,
  options,
  required = false,
}) => {
  return (
    <div className="field">
      <label htmlFor={name}>
        {label} {required && <span>*</span>}
      </label>

      <select
        id={name}
        name={name}
        value={value}
        onChange={onChange}
        className={error ? "input-error" : ""}
      >
        <option value="" disabled>
          Select your ticket
        </option>

        {options.map((option) => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </select>

      <FormError message={error} />
    </div>
  );
};

export default FormSelect;