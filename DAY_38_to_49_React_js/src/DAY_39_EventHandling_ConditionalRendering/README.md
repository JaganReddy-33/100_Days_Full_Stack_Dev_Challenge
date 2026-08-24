# 📅 Day 39 – React State, Events & Interactive Dashboard

> **100 Days of Code | React.js Learning Journey**

Today, I continued my React.js journey by combining React fundamentals with practical state-driven UI development.

I built an interactive personal dashboard to practice component communication, state management, event handling, conditional rendering, and reusable components.

---

## 🎯 Objective

- Understand React components and JSX
- Practice props and parent-child communication
- Manage UI state using `useState`
- Handle user interactions using events
- Implement conditional rendering
- Build a component-based dashboard
- Understand how state controls the UI

---

## 📚 Topics Covered

### 1. React Components

- Functional components
- Reusable components
- Component composition
- Importing and exporting components

### 2. JSX

- JSX syntax
- JavaScript expressions inside JSX
- Dynamic content rendering
- Conditional UI rendering

### 3. Props

- Passing data from parent to child
- Passing functions through props
- Parent-to-child communication
- Using props to control child components

### 4. `useState`

Practiced React state management using:

```jsx
const [state, setState] = useState(initialValue);
```

Used multiple state variables to control different parts of the dashboard.

### 5. Event Handling

Practiced:

- `onClick`
- Event handler functions
- Passing event handlers through props
- Updating state from user interactions

### 6. Conditional Rendering

Used React state to dynamically show and hide:

- Profile section
- Skills section
- Admin panel
- Login/logout interface

---

# 🚀 Project – Interactive Developer Dashboard

Built a component-based developer dashboard with an interactive UI.

### Features

- Login / Logout functionality
- Navigation bar
- Sidebar
- Quick action controls
- Profile information
- Skills section
- Admin panel
- Interactive counter
- Show / Hide dashboard sections
- Responsive layout

---

## 🧩 Components Created

### `Navbar`

Responsible for:

- Navigation links
- Login / Logout button
- Login state display
- Welcome message

### `Sidebar`

Responsible for:

- Quick actions
- Profile visibility control
- Skills visibility control
- Admin panel visibility control
- Counter integration

### `UserProfile`

Displays:

- Profile image
- Name
- Job role
- Location

### `Skills`

Displays the developer's technical skills using reusable UI elements.

### `AdminPanel`

Displays basic administrative actions such as:

- User Management
- View All Users
- Delete Users

### `Counter`

Implemented an interactive counter with:

- Increase
- Decrease
- Reset

---

# 🧠 State Management

The main `App` component manages the dashboard state.

Example states:

```jsx
const [isLoggedIn, setIsLoggedIn] = useState(false);
const [isProfileVisible, setIsProfileVisible] = useState(true);
const [isSkillsVisible, setIsSkillsVisible] = useState(true);
const [isAdmin, setIsAdmin] = useState(true);
```

These states determine which parts of the dashboard are rendered.

---

# 🔄 Component Communication

The `App` component passes state and event handler functions to child components using props.

Example:

```jsx
<Sidebar
  isProfileVisible={isProfileVisible}
  isSkillsVisible={isSkillsVisible}
  isAdmin={isAdmin}
  onToggleProfile={...}
  onToggleSkills={...}
  onToggleAdmin={...}
/>
```

This helped me understand how React components communicate through props and how parent components can control child behavior.

---

# 📂 Project Structure

```text
DAY_38_to_DAY_39_React_Basics/
│
├── public/
│
├── src/
│   │
│   ├── assets/
│   │
│   ├── Components/
│   │   ├── Navbar/
│   │   │   ├── Navbar.jsx
│   │   │   └── Navbar.css
│   │   │
│   │   ├── Sidebar/
│   │   │   ├── Sidebar.jsx
│   │   │   └── Sidebar.css
│   │   │
│   │   ├── UserProfile/
│   │   │   ├── UserProfile.jsx
│   │   │   └── UserProfile.css
│   │   │
│   │   ├── Skills/
│   │   │   ├── Skills.jsx
│   │   │   └── Skills.css
│   │   │
│   │   ├── AdminPanel/
│   │   │   ├── AdminPanel.jsx
│   │   │   └── AdminPanel.css
│   │   │
│   │   └── Counter/
│   │       ├── Counter.jsx
│   │       └── Counter.css
│   │
│   ├── App.jsx
│   ├── main.jsx
│   └── index.css
│
├── package.json
├── package-lock.json
└── README.md
```

---

# 🛠️ Tech Stack

- React.js
- JavaScript
- JSX
- CSS
- Vite
- React Hooks

---

# 💡 Key Learning

The most important takeaway from today's practice was understanding that React applications are **state-driven**.

Instead of manually changing the DOM, React re-renders the required UI when state changes.

```text
User Action
     ↓
Event Handler
     ↓
State Update
     ↓
React Re-render
     ↓
Updated UI
```

---

# 📈 Learning Outcome

Today I strengthened my understanding of:

- Component-based architecture
- JSX
- Props
- State management
- Event handling
- Conditional rendering
- Parent-child communication
- Reusable components
- State-driven UI

---

# 🚀 Next

Continue with the React learning roadmap:

- `useEffect`
- `useRef`
- `useContext`
- `useReducer`
- Custom Hooks
- Performance Optimization
- React Router
- Forms
- API Integration
- Testing
- Advanced React Project

---

## 💻 Author

**Ragipalyam Jaganmohan Reddy**

> **100 Days of Code Challenge**