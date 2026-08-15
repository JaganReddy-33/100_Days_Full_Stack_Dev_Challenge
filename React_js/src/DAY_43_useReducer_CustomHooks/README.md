
# 🚀 Day 43 — useReducer & Custom Hooks

A hands-on React practice day focused on managing complex state with `useReducer` and creating reusable logic with Custom Hooks.

This day builds on the React concepts learned in previous days and introduces patterns that are commonly used in real-world React applications.

---

## 📌 Topics Covered

### 1. useReducer

- Understanding `useReducer`
- Reducer functions
- State and actions
- `dispatch()`
- Action types
- Payloads
- Managing complex state
- Immutable state updates
- Multiple actions in a single reducer
- Using `useReducer` for application-style state management

### 2. Custom Hooks

- What are Custom Hooks?
- Why Custom Hooks are useful
- Naming convention: `use...`
- Reusing stateful logic
- Returning state and functions from Custom Hooks
- Passing parameters to Custom Hooks
- Maintaining independent state between components

### 3. LocalStorage

- Browser `localStorage`
- `setItem()`
- `getItem()`
- `removeItem()`
- Persisting React state
- `JSON.stringify()`
- `JSON.parse()`
- Combining `useState`, `useEffect`, and LocalStorage
- Creating a reusable `useLocalStorage` Hook
- Handling LocalStorage errors with `try...catch`

---

## 🧠 What I Learned

### useReducer

`useReducer` is useful when state logic becomes more complex than simple `useState` updates.

Basic structure:

```jsx
const [state, dispatch] = useReducer(reducer, initialState);
```

The component sends an action:

```jsx
dispatch({
    type: "INCREMENT",
    payload: 5
});
```

The reducer decides how the state should change:

```jsx
function reducer(state, action) {
    switch (action.type) {
        case "INCREMENT":
            return state + action.payload;

        default:
            return state;
    }
}
```

---

## 🧩 Assessments Completed

### Assessment 1 — Basic Counter

Built a counter using `useReducer`.

Features:

- Increment
- Decrement
- Reset

Example:

```jsx
dispatch({ type: "INCREMENT" });
dispatch({ type: "DECREMENT" });
dispatch({ type: "RESET" });
```

---

### Assessment 2 — Counter with Payload

Extended the counter to use action payloads.

```jsx
dispatch({
    type: "INCREMENT",
    payload: 5
});
```

The reducer uses the payload:

```jsx
case "INCREMENT":
    return state + action.payload;
```

This allowed the counter to increase or decrease by a configurable amount.

---

### Assessment 3 — Todo Manager

Created a Todo Manager using `useReducer`.

Features:

- Add Todo
- Toggle Todo
- Delete Todo
- Clear Completed Todos
- Controlled input
- Conditional rendering
- Immutable array updates

Reducer actions:

```text
ADD_TODO
TOGGLE_TODO
DELETE_TODO
CLEAR_COMPLETED
```

Example state:

```jsx
{
    id: 1,
    title: "Learn React",
    completed: false
}
```

---

### Assessment 4 — Shopping Cart

Built a Shopping Cart using `useReducer`.

Features:

- Add products
- Remove products
- Increase quantity
- Decrease quantity
- Prevent quantity from going below `1`
- Calculate total price
- Clear entire cart
- Product-level state management

Reducer actions:

```text
ADD_PRODUCT
INCREASE_QUANTITY
DECREASE_QUANTITY
DELETE_PRODUCT
CLEAR_CART
```

Total calculation:

```jsx
const total = products.reduce(
    (sum, product) =>
        sum + product.price * product.quantity,
    0
);
```

---

# 🪝 Custom Hook Assessments

## Assessment 5 — useToggle

Created a reusable `useToggle` Custom Hook.

Usage:

```jsx
const [value, toggle, reset] = useToggle(false);
```

Features:

- Toggle boolean state
- Reset to original value
- Configurable initial value

Example:

```jsx
const useToggle = (initialValue = false) => {

    const [value, setValue] = useState(initialValue);

    const toggle = () => {
        setValue(prev => !prev);
    };

    const reset = () => {
        setValue(initialValue);
    };

    return [value, toggle, reset];
};
```

---

## Assessment 6 — useCounter

Created a reusable `useCounter` Custom Hook.

Usage:

```jsx
const [count, increment, decrement, reset] = useCounter(10);
```

Features:

- Configurable initial value
- Increment
- Decrement
- Reset to initial value

Example:

```text
Initial → 10
Increment → 11
Increment → 12
Decrement → 11
Reset → 10
```

---

# 💾 Assessment 7 — useLocalStorage

Created a reusable `useLocalStorage` Custom Hook that combines:

- `useState`
- `useEffect`
- Browser LocalStorage
- `JSON.stringify()`
- `JSON.parse()`

Usage:

```jsx
const [name, setName] = useLocalStorage(
    "username",
    ""
);
```

The hook automatically:

1. Reads the stored value when the component starts.
2. Uses the initial value if nothing is stored.
3. Updates React state when `setValue()` is called.
4. Saves the updated value to LocalStorage.
5. Restores the value after a page refresh.
6. Handles invalid LocalStorage data safely.

Example:

```jsx
const useLocalStorage = (key, initialValue) => {

    const [value, setValue] = useState(() => {

        try {
            const storedValue =
                localStorage.getItem(key);

            return storedValue !== null
                ? JSON.parse(storedValue)
                : initialValue;

        } catch (error) {
            console.error(
                "Error reading from localStorage:",
                error
            );

            return initialValue;
        }
    });

    useEffect(() => {

        try {
            localStorage.setItem(
                key,
                JSON.stringify(value)
            );

        } catch (error) {
            console.error(
                "Error saving to localStorage:",
                error
            );
        }

    }, [key, value]);

    return [value, setValue];
};
```

---

# 🔄 LocalStorage Data Flow

The `useLocalStorage` Hook follows this flow:

```text
React Component
      │
      ▼
useLocalStorage()
      │
      ├── Read existing value
      │       │
      │       ▼
      │   localStorage.getItem()
      │       │
      │       ▼
      │   JSON.parse()
      │
      ▼
React State
      │
      │ setValue()
      ▼
useEffect()
      │
      ▼
JSON.stringify()
      │
      ▼
localStorage.setItem()
```

---

# 📂 Day 43 Practice Structure

The practice work is organized around separate assessments and reusable hooks.

```text
DAY_43_useReducer_Custom_Hooks/
│
├── App.jsx
│
├── hooks/
│   ├── useToggle.js
│   ├── useCounter.js
│   └── useLocalStorage.js
│
└── Components/
    │
    ├── Counter/
    │   └── Counter.jsx
    │
    ├── Todo/
    │   └── Todo.jsx
    │
    ├── Cart/
    │   └── Cart.jsx
    │
    ├── UseToggle/
    │   └── UseToggle.jsx
    │
    ├── UseCounter/
    │   └── UseCounter.jsx
    │
    └── UseLocalStorage/
        └── UseLocalStorage.jsx
```

> The exact folder structure may change while practicing. The important goal is understanding how `useReducer` and Custom Hooks work.

---

# 🛠️ Technologies Used

| Technology | Purpose |
| --- | --- |
| React | UI development |
| JavaScript | Application logic |
| `useReducer` | Complex state management |
| `useState` | Local component state |
| `useEffect` | Side effects and persistence |
| Custom Hooks | Reusable stateful logic |
| LocalStorage | Browser-side data persistence |
| JSON | Serializing and parsing stored data |
| JSX | React component structure |

---

# ▶️ How to Run

Install the project dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

Then open the local development URL shown in the terminal.

---

# 🧪 Practice Goals

By completing Day 43, I practiced:

- [x] `useReducer`
- [x] Reducer functions
- [x] Actions
- [x] `dispatch`
- [x] Payloads
- [x] Array state management
- [x] Object state updates
- [x] Todo state management
- [x] Shopping cart state management
- [x] Custom Hooks
- [x] Hook parameters
- [x] Returning multiple values/functions from Hooks
- [x] `useToggle`
- [x] `useCounter`
- [x] LocalStorage
- [x] `getItem()`
- [x] `setItem()`
- [x] `removeItem()`
- [x] `JSON.stringify()`
- [x] `JSON.parse()`
- [x] Persisting React state
- [x] Error handling with `try...catch`

---

# 💡 Key Takeaways

### `useState`

Best suited for relatively simple component state.

```jsx
const [count, setCount] = useState(0);
```

### `useReducer`

Useful when state has multiple related actions or more complex update logic.

```jsx
const [state, dispatch] = useReducer(
    reducer,
    initialState
);
```

### Custom Hooks

Custom Hooks allow reusable stateful logic to be extracted from components.

```jsx
const [value, toggle, reset] = useToggle(false);
```

### LocalStorage

LocalStorage allows data to survive page refreshes.

```jsx
localStorage.setItem(
    "username",
    JSON.stringify(value)
);
```

---

# 🎯 Day 43 Outcome

Day 43 helped me move from basic React state management toward more reusable and scalable patterns.

The main progression was:

```text
useState
   ↓
useReducer
   ↓
Complex State Management
   ↓
Custom Hooks
   ↓
Reusable Stateful Logic
   ↓
LocalStorage Persistence
```

These concepts form an important foundation for building larger React applications.

---

## 🚀 Next Step

Continue with advanced React optimization concepts such as:

- `useMemo`
- `useCallback`
- Memoization
- Preventing unnecessary calculations
- Preventing unnecessary function recreation
- `React.memo`
- Performance optimization

---

## 👨‍💻 Author

**Jaganmohan Reddy**

React / JavaScript Backend & Full Stack Development Practice

---

⭐ Day 43 completed — **useReducer + Custom Hooks**