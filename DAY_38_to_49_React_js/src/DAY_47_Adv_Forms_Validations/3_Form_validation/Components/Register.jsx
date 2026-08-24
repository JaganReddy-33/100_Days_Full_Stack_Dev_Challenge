import { useState } from "react";
import validationForm from "../utils/validation";
import "./Register.css";

const Register = () => {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: "",
    phone: "",
    ticketType: "",
    attendance: "",
    workshops: [],
    notes: "",
  });

  const [errors, setErrors] = useState({});
  const [submitted, setSubmitted] = useState(false);

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    let updatedFormData;

    if (type === "checkbox") {
      setFormData((prev) => {
        const workshops = checked
          ? [...prev.workshops, value]
          : prev.workshops.filter((workshop) => workshop !== value);

        updatedFormData = {
          ...prev,
          workshops,
        };

        const newErrors = validationForm(updatedFormData);

        setErrors((prevErrors) => ({
          ...prevErrors,
          workshops: newErrors.workshops || "",
        }));

        return updatedFormData;
      });

      return;
    }

    updatedFormData = {
      ...formData,
      [name]: value,
    };

    setFormData(updatedFormData);

    const newErrors = validationForm(updatedFormData);

    setErrors((prevErrors) => ({
      ...prevErrors,
      [name]: newErrors[name] || "",
    }));

    setSubmitted(false);
  };


  const handleSubmit = (e) => {
    e.preventDefault();

    const validationErrors = validationForm(formData);

    setErrors(validationErrors);

    if (Object.keys(validationErrors).length > 0) {
      setSubmitted(false);
      return;
    }

    console.log("Registration Data:", formData);

    setErrors({});
    setSubmitted(true);

    setFormData({
      firstName: "",
      lastName: "",
      email: "",
      phone: "",
      ticketType: "",
      attendance: "",
      workshops: [],
      notes: "",
    });
  };

  return (
    <div className="registration-page">
      <div className="registration-card">
        <div className="form-header">
          <div className="form-icon">✦</div>
          <div>
            <p className="eyebrow">TECH SUMMIT 2026</p>
            <h1>Event Registration</h1>
            <p className="form-subtitle">
              Reserve your place and build your conference experience.
            </p>
          </div>
        </div>
        {submitted && (
          <div className="success-message">
            <span className="success-icon">✓</span>

            <div>
              <strong>Registration successful!</strong>
              <p>
                Your event registration has been submitted successfully.
              </p>
            </div>
          </div>
        )}

        <form onSubmit={handleSubmit} noValidate>
          <section className="form-section">
            <div className="section-heading">
              <span className="section-number">01</span>
              <div>
                <h2>Personal Information</h2>
                <p>Tell us a little about yourself.</p>
              </div>
            </div>
            <div className="form-grid">
              <div className="field">
                <label htmlFor="firstName">
                  First Name <span>*</span>
                </label>
                <input
                  type="text"
                  id="firstName"
                  name="firstName"
                  placeholder="Enter your firstName"
                  value={formData.firstName}
                  onChange={handleChange}
                  className={errors.firstName ? "input-error" : ""}
                />
                {errors.firstName && (
                  <span className="error-message">
                    <span>!</span>
                    {errors.firstName}
                  </span>
                )}
              </div>
              <div className="field">
                <label htmlFor="lastName">
                  Last Name <span>*</span>
                </label>
                <input
                  type="text"
                  id="lastName"
                  name="lastName"
                  placeholder="Enter your lastName"
                  value={formData.lastName}
                  onChange={handleChange}
                  className={errors.lastName ? "input-error" : ""}
                />
                {errors.lastName && (
                  <span className="error-message">
                    <span>!</span>
                    {errors.lastName}
                  </span>
                )}
              </div>
              <div className="field">
                <label htmlFor="email">
                  Email Address <span>*</span>
                </label>
                <input
                  type="email"
                  id="email"
                  name="email"
                  placeholder="you@example.com"
                  value={formData.email}
                  onChange={handleChange}
                  className={errors.email ? "input-error" : ""}
                />
                {errors.email && (
                  <span className="error-message">
                    <span>!</span>
                    {errors.email}
                  </span>
                )}
              </div>

              <div className="field">
                <label htmlFor="phone">
                  Phone Number <span>*</span>
                </label>
                <input
                  type="tel"
                  id="phone"
                  name="phone"
                  placeholder="9876543210"
                  value={formData.phone}
                  onChange={handleChange}
                  className={errors.phone ? "input-error" : ""}
                />
                {errors.phone && (
                  <span className="error-message">
                    <span>!</span>
                    {errors.phone}
                  </span>
                )}
              </div>
            </div>
          </section>

          <section className="form-section">
            <div className="section-heading">
              <span className="section-number">02</span>
              <div>
                <h2>Ticket & Attendance</h2>
                <p>Choose your ticket and preferred attendance mode.</p>
              </div>
            </div>

            <div className="field">
              <label htmlFor="ticketType">
                Ticket Type <span>*</span>
              </label>
              <select
                id="ticketType"
                name="ticketType"
                value={formData.ticketType}
                onChange={handleChange}
                className={errors.ticketType ? "input-error" : ""}
              >
                <option value="" disabled>
                  Select your ticket
                </option>
                <option value="VIP">
                  VIP — ₹4,999
                </option>
                <option value="Student">
                  Student — ₹999
                </option>
                <option value="Employee">
                  Professional — ₹2,499
                </option>
              </select>
              {errors.ticketType && (
                <span className="error-message">
                  <span>!</span>
                  {errors.ticketType}
                </span>
              )}
            </div>

            <div className="field attendance-field">
              <label>
                Attendance Mode <span>*</span>
              </label>
              <div className="radio-grid">
                <label
                  className={`choice-card ${
                    formData.attendance === "online"
                      ? "choice-selected"
                      : ""
                  }`}
                >
                  <input
                    type="radio"
                    name="attendance"
                    value="online"
                    checked={formData.attendance === "online"}
                    onChange={handleChange}
                  />
                  <span className="choice-icon">💻</span>

                  <span>
                    <strong>Online</strong>
                    <small>Join virtually from anywhere</small>
                  </span>
                </label>
                <label
                  className={`choice-card ${
                    formData.attendance === "offline"
                      ? "choice-selected"
                      : ""
                  }`}
                >
                  <input
                    type="radio"
                    name="attendance"
                    value="offline"
                    checked={formData.attendance === "offline"}
                    onChange={handleChange}
                  />

                  <span className="choice-icon">📍</span>

                  <span>
                    <strong>Offline</strong>
                    <small>Attend the event in person</small>
                  </span>
                </label>
              </div>
              {errors.attendance && (
                <span className="error-message">
                  <span>!</span>
                  {errors.attendance}
                </span>
              )}
            </div>
          </section>

          <section className="form-section">
            <div className="section-heading">
              <span className="section-number">03</span>
              <div>
                <h2>Choose Workshops</h2>
                <p>Select at least one session you want to attend.</p>
              </div>
            </div>
            <div className="workshop-grid">
              <label
                className={`workshop-card ${
                  formData.workshops.includes("React & Frontend")
                    ? "workshop-selected"
                    : ""
                }`}
              >
                <input
                  type="checkbox"
                  name="workshops"
                  value="React & Frontend"
                  checked={formData.workshops.includes(
                    "React & Frontend"
                  )}
                  onChange={handleChange}
                />
                <span className="workshop-check">✓</span>
                <div>
                  <strong>React & Frontend</strong>
                  <p>Modern React architecture & UI patterns</p>
                </div>
              </label>
              <label
                className={`workshop-card ${
                  formData.workshops.includes("Node.js & Backend")
                    ? "workshop-selected"
                    : ""
                }`}
              >
                <input
                  type="checkbox"
                  name="workshops"
                  value="Node.js & Backend"
                  checked={formData.workshops.includes(
                    "Node.js & Backend"
                  )}
                  onChange={handleChange}
                />
                <span className="workshop-check">✓</span>
                <div>
                  <strong>Node.js & Backend</strong>
                  <p>Build scalable backend applications</p>
                </div>
              </label>
              <label
                className={`workshop-card ${
                  formData.workshops.includes(
                    "AI & Emerging Technologies"
                  )
                    ? "workshop-selected"
                    : ""
                }`}
              >
                <input
                  type="checkbox"
                  name="workshops"
                  value="AI & Emerging Technologies"
                  checked={formData.workshops.includes(
                    "AI & Emerging Technologies"
                  )}
                  onChange={handleChange}
                />
                <span className="workshop-check">✓</span>
                <div>
                  <strong>AI & Emerging Tech</strong>
                  <p>Explore practical AI development workflows</p>
                </div>
              </label>
            </div>
            {errors.workshops && (
              <span className="error-message workshop-error">
                <span>!</span>
                {errors.workshops}
              </span>
            )}
          </section>

          <section className="form-section">
            <div className="section-heading">
              <span className="section-number">04</span>

              <div>
                <h2>Additional Information</h2>
                <p>Anything else you'd like us to know?</p>
              </div>
            </div>

            <div className="field">
              <label htmlFor="notes">
                Additional Notes
                <small>Optional</small>
              </label>

              <textarea
                id="notes"
                name="notes"
                rows="5"
                placeholder="Tell us about your expectations, interests, or accessibility requirements..."
                value={formData.notes}
                onChange={handleChange}
              />
            </div>
          </section>

          <div className="form-footer">
            <p>
              <span>*</span> Required fields
            </p>

            <button type="submit" className="submit-button">
              Complete Registration
              <span>→</span>
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Register;