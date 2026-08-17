# Day 44 — React Performance Optimization

## 📌 Overview

Day 44 focuses on React performance optimization using `React.memo`, `useMemo`, and `useCallback`.

The goal was to understand unnecessary re-renders, memoization, referential equality, and how these techniques can improve component rendering performance.

## 🎯 Topics Covered

* `React.memo`
* `useMemo`
* `useCallback`
* Component re-rendering
* Referential equality
* Memoizing calculated values
* Memoizing function references
* Preventing unnecessary child component renders
* Dependency arrays

## 🧠 What I Learned

### React.memo

`React.memo` prevents a functional component from re-rendering when its props have not changed.

It is especially useful when a parent component re-renders frequently but the child component receives the same props.

### useMemo

`useMemo` memoizes the result of a calculation.

In this project, it was used for:

* Filtering products
* Calculating the total value of filtered products

The calculation only runs again when its dependencies change.

### useCallback

`useCallback` memoizes a function reference.

This is useful when passing a function to a memoized child component because a newly created function reference on every parent render can cause `React.memo` to render the child again.

## 🚀 Mini Project — Product Performance Dashboard

Built a Product Performance Dashboard that combines all three performance optimization techniques.

### Features

* Product search
* Category filtering
* Product statistics
* Total product value calculation
* Product selection
* Unrelated counter
* Optimized product rendering
* Responsive interface

## ⚡ Performance Optimization

The project demonstrates the relationship between the three concepts:

```text
useMemo
   ↓
Memoizes calculated values

useCallback
   ↓
Memoizes function references

React.memo
   ↓
Prevents unnecessary child renders
```

### Component Structure

```text
PerformanceDashboard
│
├── ProductItem
│   └── React.memo
│
├── filteredProducts
│   └── useMemo
│
├── totalValue
│   └── useMemo
│
└── handleSelect
    └── useCallback
```

## 🛠️ Technologies Used

* React
* JavaScript
* JSX
* React Hooks
* CSS
* Vite

## 📂 Project Structure

```text
Day_44/
└── src/
    └── Components/
        └── PerformanceDashboard/
            ├── PerformanceDashboard.jsx
            ├── ProductItem.jsx
            └── PerformanceDashboard.css
```

## 📚 Key Takeaway

Performance optimization is not about preventing every render.

The important part is understanding **when a render is unnecessary** and using memoization appropriately.

`React.memo`, `useMemo`, and `useCallback` solve different problems and work together when used in the right situations.

## 👨‍💻 Learning Progress

**Day 44 / 100 — React Performance Optimization**

**Author: Ragipalyam Jaganmohan Reddy**
React Performance → Completed ✅
