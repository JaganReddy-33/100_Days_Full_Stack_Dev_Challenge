
# 📅 Day 41 – React.js (useRef, useEffect & Controlled Forms)

> **100 Days of Code | React.js Learning Journey**

Today, I focused on understanding and implementing `useRef`, `useEffect`, controlled components, form handling, form validation, input focus management, and real-world registration workflows in React.js.

---

# 🎯 Objective

Build practical knowledge of React patterns used in real-world applications, especially:

- DOM manipulation using `useRef`
- Tracking previous values
- Combining `useEffect` with `useRef`
- Controlled components
- Form state management
- Form validation
- Input focus management
- Handling different form input types
- Form submission and reset
- Conditional rendering

---

# 📚 Topics Covered

## 1. useRef

Learned how `useRef` can be used to:

- Access DOM elements directly
- Focus input fields
- Store mutable values
- Preserve values between renders
- Track previous values without causing re-renders

Example:

    const inputRef = useRef(null);

    inputRef.current.focus();

---

## 2. useEffect with useRef

Used `useRef` and `useEffect` together to track the previous value of a state variable.

Example:

    const previousRef = useRef("");

    useEffect(() => {
        previousRef.current = currentValue;
    }, [currentValue]);

This helped understand:

- Current value
- Previous value
- Mutable references
- Component re-rendering
- Effect execution

---

## 3. Controlled Components

Practiced controlled form inputs where React state becomes the source of truth.

Example:

    <input
        name="email"
        value={formData.email}
        onChange={handleChange}
    />

The input value is completely controlled by React state.

---

## 4. Form State Management

Managed multiple fields using a single state object.

Example:

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        password: "",
    });

Used computed property names to update fields dynamically.

Example:

    setFormData((prev) => ({
        ...prev,
        [name]: value,
    }));

---

## 5. Form Validation

Implemented client-side validation for:

- Name length
- Required email
- Password length
- Confirm password matching
- Terms and conditions

Validation errors were maintained separately from form data.

Example:

    const [error, setError] = useState({});

---

## 6. Input Focus Management

Used `useRef` to automatically focus the first invalid field after form submission.

Example:

    if (newErrors.name) {
        nameRef.current.focus();
    }

This improves the user experience during form validation.

---

# 🛠️ Assignments Completed

## 1. Focus Input

Created an input component that focuses the input field when the user clicks a button.

### Concepts Practiced

- `useRef`
- DOM references
- `.current`
- `.focus()`
- Event handling

---

## 2. Previous Value Tracker

Created a component that displays:

- Current value
- Previous value

### Concepts Practiced

- `useState`
- `useRef`
- `useEffect`
- Dependency arrays
- Previous state tracking

---

## 3. User Form

Created a controlled user form containing:

- Name
- Email
- Password
- Validation
- Error messages
- Automatic input focus
- Submitted data display

### Concepts Practiced

- Controlled components
- Form submission
- `preventDefault()`
- State objects
- Dynamic state updates
- Validation
- `useRef`

---

## 4. Registration Form

Built a complete registration workflow containing:

- Name
- Email
- Password
- Confirm Password
- Role selection
- Terms & Conditions
- Validation
- Error handling
- Automatic focus
- Successful submission state
- Reset functionality

### Concepts Practiced

- Controlled inputs
- Checkbox handling
- Select handling
- Form validation
- `useRef`
- `useState`
- Conditional rendering
- Form reset
- Multiple input types

---

# 🧠 Important React Patterns Learned

## Controlled Input

    <input
        value={formData.name}
        onChange={handleChange}
    />

## Dynamic Form State

    setFormData((prev) => ({
        ...prev,
        [name]: value,
    }));

## DOM Reference

    const inputRef = useRef(null);

    inputRef.current.focus();

## Previous Value Tracking

    useEffect(() => {
        previousRef.current = currentValue;
    }, [currentValue]);

## Form Submission

    const handleSubmit = (e) => {
        e.preventDefault();
    };

## Cleanup

    useEffect(() => {
        // setup

        return () => {
            // cleanup
        };
    }, []);

---

# 🌎 Real-World Applications

These React patterns are commonly used in:

- Login forms
- Registration forms
- Authentication systems
- Search interfaces
- Profile editing
- Checkout forms
- Admin dashboards
- Multi-step forms
- OTP inputs
- Auto-focus interfaces
- Form validation
- User onboarding
- Previous-state tracking
- Interactive forms

---

# ⚠️ Important Lessons

- `useRef` does not cause a component to re-render when its value changes.
- `useState` should be used when a value needs to update the UI.
- `useRef` is useful for values that need to persist between renders without triggering a re-render.
- Controlled inputs keep React state as the source of truth.
- Form submission should be handled using `onSubmit` on the `<form>`.
- `event.preventDefault()` prevents the browser's default form submission.
- Validation should happen before processing submitted data.
- `useRef` can improve UX by focusing invalid inputs automatically.
- Cleanup functions are important when using timers, event listeners, subscriptions, and other external resources.

---

# 📂 Project Structure

    DAY_41_UseRef_Forms/
    │
    ├── Components/
    │   │
    │   ├── FocusInput/
    │   │   ├── FocusInput.jsx
    │   │   └── FocusInput.css
    │   │
    │   ├── Prev_ValueTracker/
    │   │   ├── Tracker.jsx
    │   │   └── Tracker.css
    │   │
    │   ├── UserForm/
    │   │   ├── UserForm.jsx
    │   │   └── UserForm.css
    │   │
    │   └── RegisterForm/
    │       ├── RegisterForm.jsx
    │       └── RegisterForm.css
    │
    ├── App.jsx
    ├── App.css
    └── README.md

---

# 🚀 Key Takeaway

Day 41 strengthened my understanding of practical React development patterns.

I learned how to combine:

**useState + useEffect + useRef + Controlled Components + Form Validation**

to build interactive, reusable, and user-friendly React interfaces.

---

# 💻 Tech Stack

- React.js
- JavaScript
- JSX
- HTML
- CSS
- Vite

---

# 🎯 Next Progress

Continue with the React.js roadmap by learning reusable hooks, component patterns, performance optimization, routing, forms, data fetching, testing, and real-world application architecture.

---

**Author:** Ragipalyam Jaganmohan Reddy

**Day 41 – React.js (useRef, useEffect & Controlled Forms)**