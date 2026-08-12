# Day 42 — React Context API

> Part of my **100 Days of Full Stack Development** journey 🚀

## 📌 Day 42 Overview

Today I learned how React components can share data without continuously passing props through multiple levels of the component tree.

The main focus was understanding **Prop Drilling**, **Context API**, `createContext()`, `Provider`, and `useContext()`.

I also applied these concepts by building a small **Context API Dashboard** with authentication and theme management.

---

## 🎯 Learning Objectives

By the end of Day 42, I aimed to understand:

- What Prop Drilling is
- Why Prop Drilling can become a problem
- What Context API is
- How `createContext()` works
- How Context Providers work
- How `useContext()` consumes shared data
- How to share state between unrelated/deeply nested components
- How Context can manage authentication state
- How Context can manage application themes
- How multiple Contexts can work together
- When Context API should and should not be used

---

# 📚 Topics Covered

## 1. Prop Drilling

Prop Drilling occurs when data has to be passed from a parent component to a deeply nested child component through intermediate components.

Example:

```text
App
 ↓
Dashboard
 ↓
Navbar
 ↓
Profile
 ↓
UserDetails
```

If `UserDetails` needs user information, that information may need to be passed through every component in between.

This can become difficult to maintain in large applications.

### Example

```jsx
const App = () => {
    const user = {
        name: "Jaganmohan",
        role: "Full Stack Dev"
    };

    return <Dashboard user={user} />;
};
```

Then:

```jsx
const Dashboard = ({ user }) => {
    return <Profile user={user} />;
};
```

Then:

```jsx
const Profile = ({ user }) => {
    return <UserDetails user={user} />;
};
```

The `Dashboard` and `Profile` components may not actually need the user data, but they still have to pass it.

That is Prop Drilling.

---

## 2. Context API

React Context API provides a way to share data between components without manually passing props through every level.

Common use cases include:

- Authentication
- User information
- Theme
- Language
- Application settings
- Shopping cart
- Global preferences

The basic flow is:

```text
createContext()
      ↓
Provider
      ↓
Shared Value
      ↓
useContext()
      ↓
Consumer Components
```

---

## 3. `createContext()`

`createContext()` creates a Context object.

Example:

```jsx
import { createContext } from "react";

export const UserContext = createContext(null);
```

The Context itself does not contain the application's actual state yet.

The Provider will supply the value.

---

## 4. Context Provider

A Provider makes data available to all descendant components.

Example:

```jsx
<UserContext.Provider value={user}>
    {children}
</UserContext.Provider>
```

A more practical example:

```jsx
<UserContext.Provider
    value={{
        user,
        isLoggedIn,
        login,
        logout
    }}
>
    {children}
</UserContext.Provider>
```

Every component inside this Provider can access these values.

---

## 5. `useContext()`

`useContext()` allows a component to consume data from a Context.

Example:

```jsx
const { user, isLoggedIn } = useContext(UserContext);
```

Instead of receiving:

```jsx
<Profile
    user={user}
    isLoggedIn={isLoggedIn}
/>
```

the Profile component can directly consume the Context.

This helps reduce unnecessary prop passing.

---

# 🔐 Authentication with Context

For the project, I created a `UserContext`.

The Context manages:

```text
user
isLoggedIn
login()
logout()
```

Example:

```jsx
const [isLoggedIn, setIsLoggedIn] = useState(false);

const login = () => {
    setIsLoggedIn(true);
};

const logout = () => {
    setIsLoggedIn(false);
};
```

The Provider exposes these values:

```jsx
<UserContext.Provider
    value={{
        user,
        isLoggedIn,
        login,
        logout
    }}
>
    {children}
</UserContext.Provider>
```

Now both the Navbar and Profile can use the same authentication state.

---

# 🌙 Theme Management with Context

I also created a separate `ThemeContext`.

It manages:

```text
theme
toggleTheme()
```

The application supports:

- Light Mode
- Dark Mode

Example:

```jsx
const [theme, setTheme] = useState("light");

const toggleTheme = () => {
    setTheme(prev =>
        prev === "light" ? "dark" : "light"
    );
};
```

The Theme Provider exposes:

```jsx
<ThemeContext.Provider
    value={{
        theme,
        toggleTheme
    }}
>
    {children}
</ThemeContext.Provider>
```

The Navbar consumes the theme using:

```jsx
const { theme, toggleTheme } = useContext(ThemeContext);
```

---

# 📝 Assessments

## Assessment 1 — Prop Drilling

Created a basic application where user information was passed through components using props.

User information:

- Name
- Role
- Location

The purpose was to understand how props move through a component tree.

---

## Assessment 2 — User Context

Created a `UserContext` to avoid unnecessary prop drilling.

The Context manages:

- User information
- Login state
- Login function
- Logout function

Components can access the information using:

```jsx
const { user, isLoggedIn, login, logout } =
    useContext(UserContext);
```

---

## Assessment 3 — Theme Context

Created a separate `ThemeContext`.

The Context manages:

- Current theme
- Theme toggle function

The application supports:

```text
Light Mode
Dark Mode
```

This assessment demonstrated how multiple Contexts can coexist in the same React application.

---

# 🚀 Mini Project — Context API Dashboard

The final mini project combines the concepts learned throughout Day 42.

## Features

- User authentication state
- Login / Logout
- User profile
- UserContext
- ThemeContext
- Light / Dark mode
- Conditional profile rendering
- Reusable components
- Responsive dashboard
- Context-based state sharing

---

# 🏗️ Project Structure

```text
DAY_42_Context_API/
│
├── App.jsx
├── App.css
│
├── Context/
│   ├── UserContext.jsx
│   └── ThemeContext.jsx
│
└── Components/
    │
    ├── Navbar/
    │   ├── Navbar.jsx
    │   └── Navbar.css
    │
    ├── Profile/
    │   ├── Profile.jsx
    │   └── Profile.css
    │
    └── ThemeToggle/
        ├── ThemeToggle.jsx
        └── ThemeToggle.css
```

---

# 🔄 Application Architecture

```text
                        App
                         │
                         ▼
                   UserProvider
                         │
                         ▼
                  ThemeProvider
                         │
                         ▼
                     Dashboard
                         │
                  ┌──────┴──────┐
                  │             │
                  ▼             ▼
               Navbar        Profile
                  │
                  ▼
             ThemeToggle


UserContext
│
├── user
├── isLoggedIn
├── login()
└── logout()


ThemeContext
│
├── theme
└── toggleTheme()
```

---

# 🧠 Important Concepts Learned

## Context does not automatically make everything global

A component must be inside the corresponding Provider to consume its Context.

For example:

```jsx
<UserProvider>
    <Dashboard />
</UserProvider>
```

`Dashboard` and its descendants can access `UserContext`.

---

## Multiple Contexts can be used

An application can have multiple Contexts.

For example:

```text
UserContext
    ↓
Authentication / User Information

ThemeContext
    ↓
Theme / Appearance
```

They can be nested:

```jsx
<UserProvider>
    <ThemeProvider>
        <Dashboard />
    </ThemeProvider>
</UserProvider>
```

---

# ⚖️ Prop Drilling vs Context API

| Feature | Prop Drilling | Context API |
|---|---|---|
| Data passing | Through props | Through Context |
| Deep component tree | Can become difficult | Easier |
| Intermediate components | Must pass props | Do not need to pass props |
| Shared application state | Less convenient | Useful |
| Small component tree | Simple | May be unnecessary |
| Large applications | Can become difficult | Useful when appropriately applied |

---

# ⚠️ When NOT to Use Context

Context should not be used for every piece of state.

For example, if only one component needs a counter:

```jsx
const [count, setCount] = useState(0);
```

There is no reason to create a Context just for that.

Context is useful when the same data needs to be accessed by multiple components at different levels of the component tree.

---

# 🌍 Real-World Applications

## Authentication

Context can provide:

- Current user
- Login status
- Login function
- Logout function
- User permissions

## Theme

Context can provide:

- Light / Dark mode
- Color preferences
- UI settings

## Localization

Context can provide:

- Current language
- Translation settings
- Locale preferences

## E-Commerce

Context can provide:

- Cart items
- Cart count
- User preferences
- Currency

## Admin Dashboards

Context can provide:

- Logged-in user
- Role
- Permissions
- Dashboard settings

---

# 🎯 Key Learnings

After completing Day 42, I can:

- Explain Prop Drilling
- Explain Context API
- Create a Context using `createContext()`
- Create a Context Provider
- Share state using Context
- Consume Context using `useContext()`
- Manage authentication using Context
- Manage themes using Context
- Use multiple Contexts
- Understand when Context is appropriate
- Build a practical Context API dashboard

---

# 💻 Technologies Used

- React
- JavaScript
- JSX
- CSS
- Vite
- `useState`
- `useContext`
- `createContext`
- Context API

---

# 🎤 Interview Questions & Answers

## 1. What is Prop Drilling?

**Answer:**

Prop Drilling is the process of passing data from a parent component to a deeply nested child component through intermediate components.

**Example:**

```text
App
 ↓
Dashboard
 ↓
Profile
 ↓
UserDetails
```

If `UserDetails` needs the data, every component in between may have to pass it.

**Follow-up:**  
How can Context API solve Prop Drilling?

---

## 2. What is Context API?

**Answer:**

Context API is a React feature used to share data between components without manually passing props through every level of the component tree.

**Common use cases:**

- Authentication
- Theme
- Language
- User information
- Application settings

**Follow-up:**  
What are the main APIs used with Context?

---

## 3. What does `createContext()` do?

**Answer:**

`createContext()` creates a Context object that can be used to share data between React components.

Example:

```jsx
const UserContext = createContext(null);
```

**Follow-up:**  
Does `createContext()` itself store application state?

---

## 4. What is a Context Provider?

**Answer:**

A Context Provider supplies a value to all descendant components that consume that Context.

Example:

```jsx
<UserContext.Provider value={user}>
    {children}
</UserContext.Provider>
```

**Follow-up:**  
What happens if a component is outside the Provider?

---

## 5. What does `useContext()` do?

**Answer:**

`useContext()` allows a functional component to consume the current value of a Context.

Example:

```jsx
const { user } = useContext(UserContext);
```

**Follow-up:**  
Can a component consume more than one Context?

---

## 6. Can Context API manage authentication?

**Answer:**

Yes.

Context can share authentication-related information such as:

- Current user
- Login status
- Login function
- Logout function

However, Context itself is not a complete authentication system.

Real applications still require backend authentication, sessions or tokens, authorization, protected APIs, and secure storage strategies.

**Follow-up:**  
How would you implement protected routes?

---

## 7. Can an application have multiple Contexts?

**Answer:**

Yes.

An application can have multiple Contexts for different responsibilities.

For example:

```text
UserContext
    ↓
Authentication

ThemeContext
    ↓
Appearance
```

This is often better than putting unrelated data into one huge Context.

**Follow-up:**  
Why might separate Contexts be better?

---

## 8. Is Context API a replacement for Redux?

**Answer:**

Not necessarily.

Context is mainly a mechanism for sharing values through the component tree.

State-management libraries such as Redux provide additional features for managing complex global state, predictable updates, middleware, debugging, and large-scale application architecture.

**Follow-up:**  
When would you choose Redux over Context?

---

## 9. Does Context API prevent all re-renders?

**Answer:**

No.

When a Context value changes, components consuming that Context can re-render.

For large applications, Context should therefore be designed carefully.

**Follow-up:**  
How can `useMemo()` help with Context performance?

---

## 10. What is the difference between `useContext()` and `useState()`?

**Answer:**

`useState()` creates and manages state inside a component.

`useContext()` consumes a value provided through React Context.

They often work together.

Example:

```jsx
const [theme, setTheme] = useState("light");
```

The state is then exposed through Context:

```jsx
<ThemeContext.Provider
    value={{
        theme,
        toggleTheme
    }}
>
    {children}
</ThemeContext.Provider>
```

---

# 🔥 Important Interview Follow-Up

A common interview question is:

> "Why not put everything into Context?"

A good answer:

**Context should be used for values that genuinely need to be shared across multiple parts of the component tree. Local state should remain local when possible. Overusing Context can increase unnecessary re-renders and make application state harder to reason about.**

This is an important concept before moving into React performance optimization.

---

# 📈 Progress

**Day 42 / 100 — React Phase**

- [x] Prop Drilling
- [x] Context API
- [x] `createContext()`
- [x] Context Provider
- [x] `useContext()`
- [x] User Context
- [x] Authentication Context
- [x] Theme Context
- [x] Light / Dark Mode
- [x] Mini Project
- [x] Interview Preparation

---

# 🔮 Next Topics

The next React topics will build on the concepts learned so far:

- Custom Hooks
- `useMemo()`
- `useCallback()`
- React Performance Optimization
- Reusable Logic
- Preventing unnecessary calculations
- Preventing unnecessary function recreation

---

# 🏁 Day 42 Outcome

Day 42 helped me understand how React applications can share state between multiple components without relying heavily on Prop Drilling.

I also built a practical dashboard using:

```text
UserContext
+
ThemeContext
+
useContext()
+
useState()
+
Reusable Components
```

The next step is to understand **Custom Hooks, `useMemo()`, and `useCallback()`** and how they improve React code quality and performance.

---

## 🚀 100 Days of Full Stack Development

**Previous:** Day 41 — `useRef`, Forms & Controlled Components

**Current:** Day 42 — Context API

**Next:** Custom Hooks, `useMemo()` & `useCallback()`

---

# 👨‍💻 Author

**Jaganmohan Reddy**

Full Stack Developer | MERN Stack

Learning in public and building every day 🚀