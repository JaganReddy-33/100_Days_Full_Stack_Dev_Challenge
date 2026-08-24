import { useRef, useState } from "react";
import "./RegisterForm.css";

const initialFormState = {
  name: "",
  email: "",
  password: "",
  confirmPassword: "",
  role: "",
  terms: false,
};

const RegisterForm = () => {
  const [formData, setFormData] = useState(initialFormState);
  const [errors, setErrors] = useState({});
  const [isSubmitted, setIsSubmitted] = useState(false);

  const nameRef = useRef(null);
  const emailRef = useRef(null);
  const passwordRef = useRef(null);
  const confirmRef = useRef(null);
  const roleRef = useRef(null);
  const termsRef = useRef(null);

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    setFormData((prev) => ({
      ...prev,
      [name]: type === "checkbox" ? checked : value,
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
    } else if (!/^\S+@\S+\.\S+$/.test(formData.email)) {
      newErrors.email = "Enter a valid email address.";
    }

    if (formData.password.length < 6) {
      newErrors.password = "Password must be at least 6 characters.";
    }

    if (formData.password !== formData.confirmPassword) {
      newErrors.confirmPassword = "Passwords do not match.";
    }

    if (!formData.role) {
      newErrors.role = "Please select a role.";
    }

    if (!formData.terms) {
      newErrors.terms = "You must accept the terms.";
    }

    setErrors(newErrors);

    if (Object.keys(newErrors).length > 0) {
      if (newErrors.name) {
        nameRef.current.focus();
      } else if (newErrors.email) {
        emailRef.current.focus();
      } else if (newErrors.password) {
        passwordRef.current.focus();
      } else if (newErrors.confirmPassword) {
        confirmRef.current.focus();
      } else if (newErrors.role) {
        roleRef.current.focus();
      } else if (newErrors.terms) {
        termsRef.current.focus();
      }

      return;
    }

    setIsSubmitted(true);

    console.log("Form successfully submitted:", formData);
  };

  const handleReset = () => {
    setFormData(initialFormState);
    setErrors({});
    setIsSubmitted(false);
  };

  if (isSubmitted) {
    return (
      <div className="success-card">
        <div className="success-icon">✓</div>

        <h2>Account Created Successfully! ✅</h2>

        <p>Your registration has been completed.</p>

        <div className="submitted-info">
          <div>
            <span>Name</span>
            <strong>{formData.name}</strong>
          </div>

          <div>
            <span>Email</span>
            <strong>{formData.email}</strong>
          </div>

          <div>
            <span>Role</span>
            <strong>{formData.role}</strong>
          </div>
        </div>

        <button
          type="button"
          className="secondary-button"
          onClick={handleReset}
        >
          Create Another Account
        </button>
      </div>
    );
  }

  return (
    <div className="register-card">
      <div className="register-heading">
        <h2>Create Your Account</h2>
        <p>Complete the form to register.</p>
      </div>

      <form onSubmit={handleSubmit}>
        <div className="register-group">
          <label htmlFor="register-name">Name</label>

          <input
            ref={nameRef}
            id="register-name"
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Enter your name"
          />

          {errors.name && (
            <p className="register-error">{errors.name}</p>
          )}
        </div>

        <div className="register-group">
          <label htmlFor="register-email">Email</label>

          <input
            ref={emailRef}
            id="register-email"
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="you@example.com"
          />

          {errors.email && (
            <p className="register-error">{errors.email}</p>
          )}
        </div>

        <div className="register-group">
          <label htmlFor="register-password">Password</label>

          <input
            ref={passwordRef}
            id="register-password"
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            placeholder="Minimum 6 characters"
          />

          {errors.password && (
            <p className="register-error">{errors.password}</p>
          )}
        </div>

        <div className="register-group">
          <label htmlFor="register-confirm">
            Confirm Password
          </label>

          <input
            ref={confirmRef}
            id="register-confirm"
            type="password"
            name="confirmPassword"
            value={formData.confirmPassword}
            onChange={handleChange}
            placeholder="Re-enter your password"
          />

          {errors.confirmPassword && (
            <p className="register-error">
              {errors.confirmPassword}
            </p>
          )}
        </div>

        <div className="register-group">
          <label htmlFor="register-role">Role</label>

          <select
            ref={roleRef}
            id="register-role"
            name="role"
            value={formData.role}
            onChange={handleChange}
          >
            <option value="">Select your role</option>
            <option value="Full Stack Developer">
              Full Stack Developer
            </option>
            <option value="Frontend Developer">
              Frontend Developer
            </option>
            <option value="Backend Developer">
              Backend Developer
            </option>
          </select>

          {errors.role && (
            <p className="register-error">{errors.role}</p>
          )}
        </div>

        <div className="terms-group">
          <input
            ref={termsRef}
            id="register-terms"
            type="checkbox"
            name="terms"
            checked={formData.terms}
            onChange={handleChange}
          />

          <label htmlFor="register-terms">
            I accept the Terms & Conditions
          </label>
        </div>

        {errors.terms && (
          <p className="register-error">{errors.terms}</p>
        )}

        <button className="register-button" type="submit">
          Create Account
        </button>
      </form>
    </div>
  );
};

export default RegisterForm;