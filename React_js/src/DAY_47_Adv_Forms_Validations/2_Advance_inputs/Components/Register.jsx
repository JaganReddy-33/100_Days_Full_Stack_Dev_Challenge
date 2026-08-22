import { useState } from "react";

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

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;

    if (type === "checkbox") {
      setFormData((prev) => {
        const currentWorkshops = prev.workshops;

        if (checked) {
          return {
            ...prev,
            workshops: [...currentWorkshops, value],
          };
        }

        return {
          ...prev,
          workshops: currentWorkshops.filter(
            (workshop) => workshop !== value
          ),
        };
      });
    } else {
      setFormData((prev) => ({
        ...prev,
        [name]: value,
      }));
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (
      !formData.firstName ||
      !formData.lastName ||
      !formData.email ||
      !formData.phone ||
      !formData.ticketType ||
      !formData.attendance ||
      formData.workshops.length === 0
    ) {
      alert(
        "Please complete all required fields and select at least one workshop."
      );
      return;
    }

    console.log("Registration Data:", formData);

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
    <div>
      <h2>Event Registration Form</h2>

      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="firstName">First Name: </label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            placeholder="Enter your first name"
            value={formData.firstName}
            onChange={handleChange}
          />
        </div>
        <br />

        <div>
          <label htmlFor="lastName">Last Name: </label>
          <input
            type="text"
            id="lastName"
            name="lastName"
            placeholder="Enter your last name"
            value={formData.lastName}
            onChange={handleChange}
          />
        </div>
        <br />

        <div>
          <label htmlFor="email">Email: </label>
          <input
            type="email"
            id="email"
            name="email"
            placeholder="Enter your email"
            value={formData.email}
            onChange={handleChange}
          />
        </div>
        <br />

        <div>
          <label htmlFor="phone">Phone: </label>
          <input
            type="tel"
            id="phone"
            name="phone"
            placeholder="Enter your phone number"
            value={formData.phone}
            onChange={handleChange}
          />
        </div>
        <br />

        <div>
          <label htmlFor="ticketType">Ticket Type: </label>
          <select
            id="ticketType"
            name="ticketType"
            value={formData.ticketType}
            onChange={handleChange}
          >
            <option value="" disabled>Choose your type</option>
            <option value="VIP">VIP</option>
            <option value="Student">Student</option>
            <option value="Employee">Employee</option>
          </select>
        </div>
        <br />

        <div>
          <p>Attendance Mode:</p>
          <input
            type="radio"
            id="online"
            name="attendance"
            value="online"
            checked={formData.attendance === "online"}
            onChange={handleChange}
          />
          <label htmlFor="online">Online</label>
          <br />
          <input
            type="radio"
            id="offline"
            name="attendance"
            value="offline"
            checked={formData.attendance === "offline"}
            onChange={handleChange}
          />
          <label htmlFor="offline">Offline</label>
        </div>
        <br />

        <div>
          <p>Workshops:</p>
          <input
            type="checkbox"
            id="react"
            name="workshops"
            value="React & Frontend"
            checked={formData.workshops.includes("React & Frontend")}
            onChange={handleChange}
          />
          <label htmlFor="react">React & Frontend</label>
          <br />
          <input
            type="checkbox"
            id="node"
            name="workshops"
            value="Node.js & Backend"
            checked={formData.workshops.includes("Node.js & Backend")}
            onChange={handleChange}
          />
          <label htmlFor="node">Node.js & Backend</label>
          <br />
          <input
            type="checkbox"
            id="ai"
            name="workshops"
            value="AI & Emerging Technologies"
            checked={formData.workshops.includes(
              "AI & Emerging Technologies"
            )}
            onChange={handleChange}
          />
          <label htmlFor="ai">AI & Emerging Technologies</label>
        </div>
        <br />

        <div>
          <label htmlFor="notes">Additional Notes:</label>
          <br />
          <textarea
            id="notes"
            name="notes"
            rows="5"
            cols="30"
            placeholder="Enter your additional notes here"
            value={formData.notes}
            onChange={handleChange}
          />
        </div>
        <br />

        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default Register;