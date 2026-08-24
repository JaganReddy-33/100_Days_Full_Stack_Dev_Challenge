import FocusInput from "./Components/FocusInput/FocusInput";
import Tracker from "./Components/Prev_ValueTracker/Tracker";
import UserForm from "./Components/UserForm/UserForm";
import RegisterForm from "./Components/RegisterForm/RegisterForm";
import "./App.css";

const App = () => {
  return (
    <div className="react-practice">
      <header className="practice-header">
        <div>
          <p className="eyebrow">DAY 41 • REACT.JS</p>
          <h1>Hooks & Forms Practice</h1>
          <p className="subtitle">
            useRef, useEffect, controlled components and form validation
          </p>
        </div>
      </header>

      <main className="practice-grid">
        <section className="practice-card">
          <div className="card-heading">
            <span className="card-number">01</span>
            <div>
              <h2>Focus Input</h2>
              <p>useRef DOM manipulation</p>
            </div>
          </div>
          <FocusInput />
        </section>

        <section className="practice-card">
          <div className="card-heading">
            <span className="card-number">02</span>
            <div>
              <h2>Previous Value Tracker</h2>
              <p>useRef + useEffect</p>
            </div>
          </div>
          <Tracker />
        </section>

        <section className="practice-card">
          <div className="card-heading">
            <span className="card-number">03</span>
            <div>
              <h2>User Form</h2>
              <p>Controlled component + validation</p>
            </div>
          </div>
          <UserForm />
        </section>

        <section className="practice-card register-card">
          <div className="card-heading">
            <span className="card-number">04</span>
            <div>
              <h2>Registration Form</h2>
              <p>Complete form handling</p>
            </div>
          </div>
          <RegisterForm />
        </section>
      </main>
    </div>
  );
};

export default App;