# 📅 Day 40 – React `useEffect`

> **100 Days of Code | React.js Learning Journey**

Today, I focused on mastering the **React `useEffect` Hook** and understanding how React handles side effects and external systems.

---

## 🎯 Objective

Learn how to use `useEffect` for:

- Side effects
- Dependency arrays
- API fetching
- Loading and error handling
- Timers
- Cleanup functions
- Browser event listeners
- Component mounting and unmounting

---

## 📚 Topics Covered

### 1. `useEffect` Basics

Learned how `useEffect` allows functional components to perform side effects after rendering.

### 2. Dependency Arrays

Practiced:

- No dependency array
- Empty dependency array `[]`
- Specific dependencies such as `[count]`

### 3. Document Title Synchronization

Used `useEffect` with React state to dynamically update the browser document title.

### 4. API Data Fetching

Built a Users component using:

- `useEffect`
- `useState`
- Fetch API
- `async/await`
- `try/catch/finally`

API used:

```text
https://jsonplaceholder.typicode.com/users
```

### 5. Loading and Error Handling

Implemented:

- Loading state
- Error state
- Successful API response
- HTTP response validation using `response.ok`

### 6. Cleanup Functions

Built a real-time clock using `setInterval` and cleaned it up using `clearInterval`.

### 7. Event Listener Cleanup

Built a Window Size component using the browser `resize` event and removed the event listener during cleanup.

---

## 🛠️ Practical Components Built

### Counter

Used `useEffect` to synchronize the browser document title with the counter state.

### Users

Fetched users from an external API and displayed them with loading and error handling.

### Timer

Created a real-time clock using `setInterval` and implemented cleanup using `clearInterval`.

### Window Size

Tracked browser width and height using the `resize` event and cleaned up the event listener when the component was unmounted.

---

## 🧠 Key Concepts Learned

- `useEffect`
- Dependency arrays
- Side effects
- API fetching
- Loading states
- Error handling
- `async/await`
- `try/catch/finally`
- `setInterval`
- `clearInterval`
- Event listeners
- Cleanup functions
- Component mounting
- Component unmounting
- Effect re-execution

---

## 🔄 `useEffect` Lifecycle

```text
Component Render
       ↓
DOM Updated
       ↓
useEffect Runs
       ↓
Side Effect
       ↓
Dependency Changes
       ↓
Cleanup Previous Effect
       ↓
Effect Runs Again
```

When the component unmounts:

```text
Component Unmounts
       ↓
Cleanup Function
       ↓
External Resource Removed
```

---

## 💡 Real-World Applications

`useEffect` is commonly used for:

- REST API requests
- WebSocket connections
- Browser event listeners
- Timers
- Subscriptions
- Authentication state synchronization
- Document title updates
- Synchronizing React with external systems

---

## 🎯 Interview Preparation

Practiced interview questions covering:

- What is `useEffect`?
- What is the dependency array?
- Difference between `[]`, `[dependency]`, and no dependency array
- Why cleanup functions are required
- API fetching with `useEffect`
- Fetch error handling
- Infinite effect loops
- Event listener cleanup
- Effect execution timing
- Component mounting and unmounting

---

## 💻 Tech Stack

- React.js
- JavaScript
- JSX
- Vite
- CSS
- Fetch API

---

## 🚀 Next Progress

Continue with the next React topic according to the learning roadmap.

---

**Author:** Ragipalyam Jaganmohan Reddy

**Day 40 – React `useEffect`**