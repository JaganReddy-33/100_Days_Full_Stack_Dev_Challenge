import { useRef, useState } from "react";
import "./UserForm.css";

const initialFormState = {
  name: "",
  email: "",
  password: "",
};

const UserForm = () => {
  const [formData, setFormData] = useState(initialFormState);
  const [errors, setErrors] = useState({});

  const nameRef = useRef(null);
  const emailRef = useRef(null);
  const passwordRef = useRef(null);

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));

    if (errors[name]) {
      setErrors((prev) => ({
        ...prev,
        [name]: "",
      }));
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const newErrors = {};

    if (formData.name.trim().length < 3) {
      newErrors.name = "Name must be at least 3 characters.";
    }

    if (!formData.email.trim()) {
      newErrors.email = "Email is required.";
    }

    if (formData.password.length < 6) {
      newErrors.password = "Password must be at least 6 characters.";
    }

    setErrors(newErrors);

    if (Object.keys(newErrors).length > 0) {
      if (newErrors.name) {
        nameRef.current.focus();
      } else if (newErrors.email) {
        emailRef.current.focus();
      } else if (newErrors.password) {
        passwordRef.current.focus();
      }

      return;
    }

    console.log("Form successfully submitted:", formData);
  };

  return (
    <div className="user-form-card">
      <div className="form-heading">
        <h2>User Form</h2>
        <p>Controlled component with validation</p>
      </div>

      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="user-name">Name</label>

          <input
            ref={nameRef}
            id="user-name"
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Enter your name"
          />

          {errors.name && (
            <p className="form-error">{errors.name}</p>
          )}
        </div>

        <div className="form-group">
          <label htmlFor="user-email">Email</label>

          <input
            ref={emailRef}
            id="user-email"
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter your email"
          />

          {errors.email && (
            <p className="form-error">{errors.email}</p>
          )}
        </div>

        <div className="form-group">
          <label htmlFor="user-password">Password</label>

          <input
            ref={passwordRef}
            id="user-password"
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            placeholder="Enter your password"
          />

          {errors.password && (
            <p className="form-error">{errors.password}</p>
          )}
        </div>

        <button className="submit-button" type="submit">
          Submit
        </button>
      </form>

      <div className="entered-data">
        <h3>Entered Data</h3>
        <p>
          <strong>Name:</strong> {formData.name || "—"}
        </p>
        <p>
          <strong>Email:</strong> {formData.email || "—"}
        </p>
        <p>
          <strong>Password:</strong>{" "}
          {formData.password ? "••••••••" : "—"}
        </p>
      </div>
    </div>
  );
};

export default UserForm;