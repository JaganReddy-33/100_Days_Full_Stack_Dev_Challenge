import { useState } from "react";
import validationForm from "../utils/validationForm"

import FormInput from "../components/ui/FormInput";
import FormSelect from "../components/ui/FormSelect";
import FormError from "../components/ui/FormError";
import Button from "../components/ui/Button";

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

    if (type === "checkbox") {
      setFormData((prev) => {
        const workshops = checked
          ? [...prev.workshops, value]
          : prev.workshops.filter((workshop) => workshop !== value);

        const updatedFormData = {
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

    const updatedFormData = {
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

              <FormInput
                label="First Name"
                name="firstName"
                placeholder="Enter your first name"
                value={formData.firstName}
                onChange={handleChange}
                error={errors.firstName}
                required
              />

              <FormInput
                label="Last Name"
                name="lastName"
                placeholder="Enter your last name"
                value={formData.lastName}
                onChange={handleChange}
                error={errors.lastName}
                required
              />

              <FormInput
                label="Email Address"
                name="email"
                type="email"
                placeholder="you@example.com"
                value={formData.email}
                onChange={handleChange}
                error={errors.email}
                required
              />

              <FormInput
                label="Phone Number"
                name="phone"
                type="tel"
                placeholder="9876543210"
                value={formData.phone}
                onChange={handleChange}
                error={errors.phone}
                required
              />

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

            <FormSelect
              label="Ticket Type"
              name="ticketType"
              value={formData.ticketType}
              onChange={handleChange}
              error={errors.ticketType}
              required
              options={[
                {
                  value: "VIP",
                  label: "VIP — ₹4,999",
                },
                {
                  value: "Student",
                  label: "Student — ₹999",
                },
                {
                  value: "Employee",
                  label: "Professional — ₹2,499",
                },
              ]}
            />

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

              <FormError message={errors.attendance} />

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

              {[
                {
                  id: "react",
                  value: "React & Frontend",
                  title: "React & Frontend",
                  description: "Modern React architecture & UI patterns",
                },
                {
                  id: "node",
                  value: "Node.js & Backend",
                  title: "Node.js & Backend",
                  description: "Build scalable backend applications",
                },
                {
                  id: "ai",
                  value: "AI & Emerging Technologies",
                  title: "AI & Emerging Tech",
                  description: "Explore practical AI development workflows",
                },
              ].map((workshop) => (
                <label
                  key={workshop.id}
                  className={`workshop-card ${
                    formData.workshops.includes(workshop.value)
                      ? "workshop-selected"
                      : ""
                  }`}
                >
                  <input
                    type="checkbox"
                    name="workshops"
                    value={workshop.value}
                    checked={formData.workshops.includes(workshop.value)}
                    onChange={handleChange}
                  />

                  <span className="workshop-check">✓</span>

                  <div>
                    <strong>{workshop.title}</strong>
                    <p>{workshop.description}</p>
                  </div>
                </label>
              ))}

            </div>

            <FormError message={errors.workshops} />

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

            <Button type="submit">
              Complete Registration
              <span>→</span>
            </Button>

          </div>

        </form>

      </div>
    </div>
  );
};

export default Register;