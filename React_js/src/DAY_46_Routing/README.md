Understood. **One single `README.md` file. One single Markdown code block. Everything inside it. No separation into multiple files or multiple Markdown blocks.**

````markdown
# Day 46 — React Routing

## 📅 100 Days of Code

### 🎯 Objective

Learn how to implement client-side routing in React applications using React Router DOM.

Today was divided into two parts because of the amount of routing concepts covered.

---

# Part 1 — React Router Basics & Dynamic Routes

## 1. React Router Basics

React Router allows a React application to display different components based on the URL without performing a full browser page reload.

### Main Components

- `BrowserRouter`
- `Routes`
- `Route`
- `Link`
- `NavLink`

### Basic Routing

```jsx
import { BrowserRouter, Routes, Route } from "react-router-dom";

<BrowserRouter>
  <Routes>
    <Route path="/" element={<Home />} />
    <Route path="/about" element={<About />} />
    <Route path="/contact" element={<Contact />} />
  </Routes>
</BrowserRouter>
````

### Routes Practiced

```text
/
/about
/contact
```

---

## 2. Link

`Link` is used for client-side navigation.

```jsx
<Link to="/about">About</Link>
```

It changes the URL and renders the corresponding route without performing a complete browser reload.

---

## 3. NavLink

`NavLink` works like `Link`, but it also provides information about whether the current route is active.

```jsx
<NavLink
  to="/about"
  style={({ isActive }) => ({
    color: isActive ? "red" : "black",
    fontWeight: isActive ? "bold" : "normal"
  })}
>
  About
</NavLink>
```

### Link vs NavLink

| Feature                     | Link   | NavLink          |
| --------------------------- | ------ | ---------------- |
| Client-side navigation      | ✅      | ✅                |
| Active route information    | ❌      | ✅                |
| `isActive`                  | ❌      | ✅                |
| Useful for navigation menus | Yes    | Yes              |
| Active styling              | Manual | Built-in support |

### `end` Prop

The `end` prop can be used when the route should only be considered active on an exact match.

```jsx
<NavLink to="/" end>
  Home
</NavLink>
```

---

## 4. Programmatic Navigation — useNavigate

`useNavigate()` is used when navigation needs to happen through JavaScript logic.

```jsx
import { useNavigate } from "react-router-dom";

const navigate = useNavigate();

<button onClick={() => navigate("/contact")}>
  Go to Contact
</button>
```

### Going Back

```jsx
navigate(-1);
```

This moves backward through the browser history.

---

## 5. useLocation

`useLocation()` provides information about the current URL.

```jsx
import { useLocation } from "react-router-dom";

const location = useLocation();

console.log(location.pathname);
```

Example:

```text
/about
/contact
/products
```

This is useful when application logic depends on the current location.

---

# Dynamic Routes

## 6. Dynamic Route Parameters

A dynamic route contains a parameter whose value can change.

Example:

```jsx
<Route path="/user/:id" element={<UserDetails />} />
```

The `:id` part is dynamic.

The same route can handle:

```text
/user/1
/user/2
/user/3
/user/4
```

---

## 7. useParams

`useParams()` is used to retrieve dynamic route parameters.

```jsx
import { useParams } from "react-router-dom";

const { id } = useParams();
```

For:

```text
/user/3
```

the value will be:

```text
id = "3"
```

### Important

Route parameters returned by `useParams()` are strings.

Therefore, if the data contains numeric IDs:

```jsx
const currentUser = users.find(
  user => user.id === Number(id)
);
```

---

## 8. Dynamic User Details

Practiced a user details page using a dynamic route.

```jsx
<Route path="/user/:id" element={<UserDetails />} />
```

Example:

```text
/users
/user/1
/user/2
/user/3
/user/4
```

The selected user's ID is extracted from the URL and used to find the corresponding user from the data.

---

## 9. Handling Invalid Dynamic Routes

Also practiced handling cases where the requested user does not exist.

Example:

```text
/user/999
```

If no matching user is found:

```text
User Not Found
```

A navigation option can then be provided to return to the users page.

---

# Multiple Dynamic Parameters

## 10. Dynamic Product Routes

Practiced routes containing multiple parameters.

```jsx
<Route
  path="/products/:category/:id"
  element={<ProductDetails />}
/>
```

Example:

```text
/products/electronics/101
```

The parameters can be accessed using:

```jsx
const { category, id } = useParams();
```

Then the product can be located using both values:

```jsx
const currentProduct = products.find(
  product =>
    product.id === Number(id) &&
    product.category === category
);
```

---

# Route Parameters vs Query Parameters

## 11. Route Parameters

Route parameters are part of the route path and are generally used to identify a specific resource.

Example:

```text
/products/electronics/101
```

Route:

```text
/products/:category/:id
```

Common examples:

```text
/users/:id
/products/:id
/jobs/:id
/applications/:id
```

---

## 12. Query Parameters

Query parameters appear after `?` in the URL.

Example:

```text
/products?category=electronics
```

They are commonly useful for:

* Filtering
* Searching
* Sorting
* Pagination
* Other view-related options

---

## Route Parameters vs Query Parameters

| Route Parameters            | Query Parameters                         |
| --------------------------- | ---------------------------------------- |
| Part of the route path      | Added after `?`                          |
| Usually identify a resource | Usually modify/filter the result         |
| `/products/:id`             | `/products?category=electronics`         |
| Example `/products/101`     | Example `/products?category=electronics` |

---

# useSearchParams

## 13. Reading Query Parameters

Practiced `useSearchParams()`.

```jsx
import { useSearchParams } from "react-router-dom";

const [searchParams, setSearchParams] = useSearchParams();

const category = searchParams.get("category");
```

For:

```text
/products?category=electronics
```

the value will be:

```text
electronics
```

---

## 14. Updating Query Parameters

Query parameters can be updated using `setSearchParams()`.

```jsx
setSearchParams({
  category: "electronics"
});
```

Result:

```text
/products?category=electronics
```

---

## 15. Clearing Query Parameters

```jsx
setSearchParams({});
```

This removes the query parameters.

---

## 16. Filtering Products Using Query Parameters

Practiced filtering products based on the URL.

```jsx
const filteredProducts = category
  ? products.filter(
      product => product.category === category
    )
  : products;
```

This allows URLs such as:

```text
/products
/products?category=electronics
/products?category=kitchen
/products?category=apparel
```

The URL itself represents the current filter state.

---

# Part 1 Practice

### Concepts Practiced

* React Router
* `BrowserRouter`
* `Routes`
* `Route`
* `Link`
* `NavLink`
* `useNavigate`
* `useLocation`
* Dynamic routes
* `useParams`
* Multiple route parameters
* Route parameters
* Query parameters
* `useSearchParams`
* URL-based filtering
* Handling invalid dynamic resources

---

# Part 2 — Nested Routes & Protected Routes

## 17. Nested Routes

Nested routes allow child routes to exist inside a parent route.

Example:

```jsx
<Route path="/dashboard" element={<Dashboard />}>
  <Route index element={<Overview />} />
  <Route path="applications" element={<Applications />} />
  <Route path="statistics" element={<Statistics />} />
</Route>
```

This creates:

```text
/dashboard
/dashboard/applications
/dashboard/statistics
```

The parent dashboard can provide the common layout while the child route changes the displayed content.

---

# 18. Outlet

`Outlet` is used inside the parent component to specify where the child route should be rendered.

```jsx
import { Outlet } from "react-router-dom";

const Dashboard = () => {
  return (
    <div>
      <h1>Dashboard</h1>

      <nav>
        <Link to="overview">Overview</Link>
        <Link to="applications">Applications</Link>
        <Link to="statistics">Statistics</Link>
      </nav>

      <Outlet />
    </div>
  );
};
```

Without `<Outlet />`, the nested child component will not appear inside the parent layout.

---

# 19. Relative Navigation

Inside nested routes, child paths can be written relative to the parent route.

Example:

```jsx
<Link to="applications">
  Applications
</Link>
```

If the current parent route is:

```text
/dashboard
```

this navigates to:

```text
/dashboard/applications
```

Instead of writing the complete path:

```jsx
<Link to="/dashboard/applications">
  Applications
</Link>
```

---

# 20. Index Routes

An index route represents the default child route.

```jsx
<Route path="/dashboard" element={<Dashboard />}>
  <Route index element={<Overview />} />
  <Route path="applications" element={<Applications />} />
  <Route path="statistics" element={<Statistics />} />
</Route>
```

When the user visits:

```text
/dashboard
```

the `Overview` component is rendered automatically.

---

# Nested Dashboard Structure

Practiced a dashboard structure similar to a real-world application:

```text
/dashboard
    │
    ├── Overview
    ├── Applications
    └── Statistics
```

The dashboard acts as the parent layout.

The child page is rendered through:

```jsx
<Outlet />
```

---

# Protected Routes

## 21. Why Protected Routes?

Some application pages should only be accessible to authenticated users.

Example:

```text
Public Routes
│
├── /
├── /login
└── /register

Protected Routes
│
├── /dashboard
├── /applications
├── /statistics
└── /settings
```

If a user is not authenticated and tries to access:

```text
/dashboard
```

the application can redirect them to:

```text
/login
```

---

# 22. ProtectedRoute Component

Practiced creating a reusable `ProtectedRoute` component using:

* `Outlet`
* `Navigate`

Basic structure:

```jsx
import { Navigate, Outlet } from "react-router-dom";

const ProtectedRoute = () => {

  const isAuthenticated = true;

  if (!isAuthenticated) {
    return <Navigate to="/login" replace />;
  }

  return <Outlet />;
};

export default ProtectedRoute;
```

---

# 23. Navigate

`Navigate` is used to redirect the user to another route.

```jsx
<Navigate to="/login" replace />
```

The `replace` prop replaces the current history entry instead of adding another entry.

---

# 24. Protecting Multiple Routes

A parent route can be used to protect multiple child routes.

Example:

```jsx
<Route element={<ProtectedRoute />}>

  <Route
    path="/dashboard"
    element={<Dashboard />}
  />

  <Route
    path="/applications"
    element={<Applications />}
  />

  <Route
    path="/statistics"
    element={<Statistics />}
  />

</Route>
```

This avoids repeating the authentication check for every individual route.

---

# Important Security Understanding

A protected React route is only a frontend access-control mechanism.

It does **not** provide complete application security.

For a real-world application:

```text
React Frontend
       ↓
Protected Route
       ↓
Backend API
       ↓
Authentication / Authorization
       ↓
Database
```

The backend must independently verify authentication and authorization before returning protected data.

---

# Day 46 Concepts Summary

| Concept           | Purpose                       |
| ----------------- | ----------------------------- |
| `BrowserRouter`   | Enables React Router          |
| `Routes`          | Contains route definitions    |
| `Route`           | Maps paths to components      |
| `Link`            | Client-side navigation        |
| `NavLink`         | Navigation with active state  |
| `useNavigate`     | Programmatic navigation       |
| `useLocation`     | Access current location       |
| `useParams`       | Read dynamic route parameters |
| `useSearchParams` | Read/update query parameters  |
| `Outlet`          | Render nested route content   |
| `Navigate`        | Redirect users                |
| Nested Routes     | Create hierarchical layouts   |
| Index Route       | Default child route           |
| Protected Routes  | Restrict frontend access      |

---

# 🧪 Practice Projects

## Practice 1 — Basic React Router

Created pages for:

```text
/
/about
/contact
```

Practiced:

* `BrowserRouter`
* `Routes`
* `Route`
* `Link`
* `NavLink`

---

## Practice 2 — Dynamic User Routes

Created:

```text
/users
/user/:id
```

Practiced:

* Dynamic route parameters
* `useParams`
* Finding users from local data
* Handling invalid user IDs
* Navigation between users and details

---

## Practice 3 — Dynamic Product Routes

Created:

```text
/products
/products/:category/:id
```

Practiced:

* Multiple dynamic parameters
* `useParams`
* Product lookup
* Category matching
* Product not found handling

---

## Practice 4 — Query Parameter Filtering

Created:

```text
/products?category=electronics
```

Practiced:

* `useSearchParams`
* Reading query parameters
* Updating query parameters
* Clearing query parameters
* Filtering products using URL state

---

## Practice 5 — Nested Dashboard

Created:

```text
/dashboard
/dashboard/applications
/dashboard/statistics
```

Practiced:

* Nested routes
* Parent route
* Child routes
* `Outlet`
* Index routes
* Relative navigation

---

## Practice 6 — Protected Routes

Created a reusable protected route structure using:

```text
ProtectedRoute
Navigate
Outlet
```

Practiced the concept of redirecting unauthenticated users to a login route.

---

# 🌍 Real-World Application — JobTrack

The routing concepts from Day 46 will directly apply to the JobTrack project.

A possible routing architecture is:

```text
/
├── /login
├── /register
│
└── Protected Routes
    │
    ├── /dashboard
    ├── /applications
    ├── /applications/:id
    ├── /add-application
    ├── /statistics
    └── /settings
```

Dynamic application details:

```text
/applications/:id
```

Example:

```text
/applications/105
```

Query parameters can later be used for:

```text
/applications?status=interview
/applications?search=google
/applications?sort=latest
/applications?page=2
```

Nested routes can also be used when a shared dashboard layout is required:

```text
/dashboard
/dashboard/overview
/dashboard/applications
/dashboard/statistics
```

Protected routes will later be connected to the actual authentication system when the JobTrack backend is implemented.

---

# 💡 Key Learnings

### 1. React Router enables client-side routing

Different components can be rendered based on the URL without performing a complete page reload.

### 2. Dynamic routes represent resources

```text
/users/:id
/products/:id
/applications/:id
```

are useful when the URL identifies a particular resource.

### 3. Query parameters represent view state

```text
/products?category=electronics
```

is useful for filtering, searching, sorting, and pagination.

### 4. Nested routes allow shared layouts

A parent component can remain visible while child route content changes through `<Outlet />`.

### 5. Protected routes provide frontend access control

Authentication checks can redirect unauthenticated users away from private pages.

### 6. Backend security is still required

Frontend route protection must never be treated as a replacement for backend authentication and authorization.

---

# 🎯 Day 46 Interview Questions

## 1. What is React Router?

**Direct answer:**
React Router is a routing library used to implement client-side navigation in React applications.

**Why/how:**
It maps URL paths to React components and allows navigation without completely reloading the page.

**Real-world gotcha:**
React Router itself does not provide backend authentication or authorization.

**Likely follow-up:**
What are `BrowserRouter`, `Routes`, and `Route`?

---

## 2. What is the difference between Link and NavLink?

**Direct answer:**
Both provide client-side navigation, but `NavLink` also provides active route information.

**Why/how:**
`NavLink` provides `isActive`, which can be used to apply active styles.

**Real-world gotcha:**
The root route may require the `end` prop for exact matching.

**Likely follow-up:**
How would you highlight the active sidebar item?

---

## 3. What is a dynamic route?

**Direct answer:**
A dynamic route contains a parameter whose value changes depending on the URL.

**Why/how:**

```text
/user/:id
```

can handle:

```text
/user/1
/user/2
/user/3
```

**Real-world gotcha:**
`useParams()` returns parameter values as strings.

**Likely follow-up:**
How do you convert a route ID into a number?

---

## 4. What is the difference between route parameters and query parameters?

**Direct answer:**
Route parameters generally identify a resource, while query parameters usually control filtering, searching, sorting, or pagination.

**Why/how:**

```text
/products/:id
```

identifies a product.

```text
/products?category=electronics
```

filters products.

**Real-world gotcha:**
Query parameters are not defined as part of the route path.

**Likely follow-up:**
How do you read query parameters in React Router?

---

## 5. What is Outlet?

**Direct answer:**
`Outlet` is a placeholder where the matched child route is rendered.

**Why/how:**
It allows a parent component to provide a shared layout while nested child content changes.

**Real-world gotcha:**
Without `<Outlet />`, the nested child route will not be rendered inside the parent.

**Likely follow-up:**
What is an index route?

---

## 6. What are protected routes?

**Direct answer:**
Protected routes restrict access to certain frontend pages based on authentication or authorization.

**Why/how:**
A wrapper component checks authentication and uses `Navigate` to redirect unauthorized users.

**Real-world gotcha:**
Frontend route protection alone cannot secure backend APIs or database data.

**Likely follow-up:**
How would you connect protected routes with JWT authentication?

---

# 📊 Day 46 Progress

## Part 1

* [x] React Router Basics
* [x] BrowserRouter
* [x] Routes
* [x] Route
* [x] Link
* [x] NavLink
* [x] useNavigate
* [x] useLocation
* [x] Dynamic Routes
* [x] useParams
* [x] Multiple Dynamic Parameters
* [x] Route Parameters
* [x] Query Parameters
* [x] useSearchParams
* [x] Query Parameter Filtering

## Part 2

* [x] Nested Routes
* [x] Outlet
* [x] Relative Navigation
* [x] Index Routes
* [x] Protected Routes
* [x] Navigate
* [x] Authentication-based Route Protection Concept

---

# 🛠️ Technologies Used

* React
* JavaScript
* JSX
* React Router DOM
* CSS

---

# 📁 Folder Structure

```text
day_46_Routing/
│
├── 1_React_Router_Basics/
│
├── 2_Dynamic_Routes/
│
├── 3_Nested_Routes/
│
├── 4_Protected_Routes/
│
└── README.md
```

---

# ✅ Day 46 Status

**Completed**

Day 46 covered React routing from the fundamentals through dynamic routes, query parameters, nested routes, and protected routes.

The routing concepts practiced today form the foundation for implementing navigation, authentication boundaries, resource-specific pages, filtering, and dashboard layouts in larger React applications.

---

# 🚀 Next

**Day 47 — React Forms & Form Handling**

```
```
