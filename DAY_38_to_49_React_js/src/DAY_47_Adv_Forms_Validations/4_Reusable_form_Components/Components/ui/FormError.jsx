

const FormError = ({message}) => {

    if(!message) return null;

  return (
    <span className="error-message">
      <span>!</span>
      {message}
    </span>
  )
}

export default FormError;
