
import FormError from "./FormError";


const FormInput = ({
    label, 
    name, 
    type="text", 
    placeholder, 
    value, 
    onChange, 
    error, 
    required = false
}) => {
  return (
    <div className="field">
        
        <label htmlFor={name}>
            {label} {required && <span>*</span>}
        </label>

        <input
        type={type}
        id={name}
        name={name}
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        className={error ? "input-error" : ""}
        />

        <FormError message={error}/>
    </div>
  )
}

export default FormInput
