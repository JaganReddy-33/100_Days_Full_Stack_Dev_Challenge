# 🚀 Day 48 — React Reusable Components

## 📌 100 Days Full Stack Developer Challenge

Day 48 focused on building **reusable and maintainable React components**. After learning controlled forms and advanced form handling, I continued by improving the structure of a practical Product Dashboard application.

The main goal was to understand how to break a large React application into smaller, reusable components and manage communication between them using **props and callback functions**.

---

## 📚 Topics Covered

* Reusable Components in React
* Component Composition
* Props
* Passing Data Through Props
* Passing Functions Through Props
* Parent-to-Child Communication
* Child-to-Parent Communication
* Component Responsibility
* Separation of Concerns
* Reusable Form Components
* Reusable Product Card Components
* Reusable Loading Components
* Reusable Error Components
* Product List Components
* Product Filter Components
* Axios API Integration
* REST API CRUD Operations
* GET Requests
* POST Requests
* PUT Requests
* PATCH Requests
* DELETE Requests
* React State Management
* Loading States
* Error States
* Success Messages
* Search and Filtering
* Responsive Component Styling

---

## 🧠 What I Learned

### 1. Reusable Components

Instead of putting all application logic inside a single component, React applications can be divided into smaller components.

Example:

```jsx
<ProductList
  products={products}
  onEdit={handleEditProduct}
  onDelete={handleDeleteProduct}
/>
```

This makes the application easier to understand, maintain, and extend.

---

### 2. Component Composition

A large component can be composed of smaller components.

The Product Dashboard follows this structure:

```text
ProductDashboard
│
├── ProductFilters
│
├── ProductList
│   └── ProductCard
│
└── ProductForm
```

Each component has a specific responsibility.

---

### 3. Passing Data Through Props

The parent component can pass data to child components using props.

```jsx
<ProductList products={products} />
```

The child receives the data:

```jsx
const ProductList = ({ products }) => {
  // use products
};
```

---

### 4. Passing Functions Through Props

Functions can also be passed from parent to child components.

```jsx
<ProductCard
  product={product}
  onEdit={onEdit}
  onDelete={onDelete}
/>
```

The child can then trigger the parent's functionality:

```jsx
onClick={() => onDelete(product.id)}
```

This is an important React pattern for handling user interactions.

---

### 5. Separation of Concerns

Instead of making one component responsible for everything, responsibilities were separated.

```text
ProductDashboard
→ State and application logic

ProductList
→ Display product collection

ProductCard
→ Display individual product

ProductForm
→ Create and edit products

ProductFilters
→ Search and filter products

Loading
→ Loading UI

ErrorMessage
→ Error UI

productService
→ API communication
```

This makes the application much more scalable.

---

# 🛠️ Practical Project

## Product Management Dashboard

Built a complete React Product Dashboard using:

* React
* Axios
* DummyJSON API
* Reusable Components
* REST API
* CRUD operations
* CSS

### Features

* Fetch products from API
* Display products in responsive cards
* Create new products
* Edit existing products
* Delete products
* Search products
* Filter products by category
* Loading state
* Error handling
* Success messages
* Empty state
* Responsive design
* Separate CSS files for components

---

## 🔄 CRUD Operations

### GET

Fetch all products:

```text
GET /products
```

### POST

Create a product:

```text
POST /products/add
```

### PUT

Update a product:

```text
PUT /products/:id
```

### PATCH

Partially update a product:

```text
PATCH /products/:id
```

### DELETE

Delete a product:

```text
DELETE /products/:id
```

---

## 📂 Project Structure

```text
src/
│
├── App.jsx
├── App.css
│
├── Components/
│   ├── ErrorMessage.jsx
│   ├── ErrorMessage.css
│   ├── Loading.jsx
│   ├── Loading.css
│   ├── ProductCard.jsx
│   ├── ProductCard.css
│   ├── ProductForm.jsx
│   ├── ProductForm.css
│   ├── ProductList.jsx
│   ├── ProductList.css
│   ├── ProductFilters.jsx
│   └── ProductFilters.css
│
├── pages/
│   ├── ProductDashboard.jsx
│   └── ProductDashboard.css
│
└── services/
    └── productService.js
```

---

## 💡 Key Learnings

* React applications should be divided into focused components.
* Reusable components reduce code duplication.
* Props allow components to receive dynamic data.
* Callback props allow child components to communicate with parents.
* A component should ideally have a clear responsibility.
* API logic should be separated from UI components.
* Service files make API communication cleaner.
* CRUD operations can be integrated into React applications using Axios.
* Loading, error, success, and empty states improve user experience.
* Search and filtering can be implemented efficiently using derived state.
* Component-level CSS keeps styling organized.
* Good component architecture makes future application development easier.

---

## 🎯 Practice Completed

* [x] Created reusable React components
* [x] Created reusable ProductCard component
* [x] Created ProductList component
* [x] Created reusable ProductForm component
* [x] Created ProductFilters component
* [x] Created Loading component
* [x] Created ErrorMessage component
* [x] Passed data using props
* [x] Passed callback functions using props
* [x] Implemented Axios GET
* [x] Implemented Axios POST
* [x] Implemented Axios PUT
* [x] Implemented Axios PATCH
* [x] Implemented Axios DELETE
* [x] Added search functionality
* [x] Added category filtering
* [x] Added loading state
* [x] Added error handling
* [x] Added success messages
* [x] Added responsive styling

---

## 🎤 Daily Interview Wrap-Up

### 1. What are reusable components in React?

**Direct Answer:**
Reusable components are React components designed to be used in multiple places with different data or behavior.

**Why/How:**
They receive dynamic information through props instead of hardcoding values.

**Real-World Gotcha:**
A component becomes difficult to reuse when it contains too much application-specific logic.

**Likely Follow-up:**
How do you make a component reusable?

---

### 2. How does a child component communicate with its parent?

**Direct Answer:**
A parent passes a function to the child through props, and the child calls that function.

**Why/How:**

```jsx
<ProductCard onDelete={handleDelete} />
```

The child can execute:

```jsx
onDelete(product.id);
```

**Real-World Gotcha:**
The function belongs to the parent, so the child should not directly modify the parent's state.

**Likely Follow-up:**
What is the difference between props and state?

---

### 3. Why should API logic be separated into a service file?

**Direct Answer:**
It separates API communication from UI and component logic.

**Why/How:**
Instead of writing Axios requests throughout components, API functions can be centralized inside a service.

**Real-World Gotcha:**
This becomes especially important when an application has many endpoints.

**Likely Follow-up:**
Where would you handle authentication headers?

---

### 4. What is component composition?

**Direct Answer:**
Component composition means building larger interfaces by combining smaller components.

**Why/How:**

```text
Dashboard
 ├── Filters
 ├── List
 │    └── Card
 └── Form
```

**Real-World Gotcha:**
Avoid creating extremely small components without a meaningful responsibility.

**Likely Follow-up:**
What is the difference between composition and inheritance in React?

---

### 5. Why should we avoid putting everything inside one component?

**Direct Answer:**
Large components become difficult to understand, test, maintain, and reuse.

**Why/How:**
Separating responsibilities creates a cleaner component architecture.

**Real-World Gotcha:**
Over-componentization can also make an application unnecessarily complicated.

**Likely Follow-up:**
How do you decide when to create a new component?

---

## 📈 Challenge Progress

```text
100 Days Full Stack Developer Challenge

JavaScript      ████████████████████  Completed
SQL             ████████████████████  Completed
React           ██████████░░░░░░░░░░  In Progress

Current Day: 48 / 100
Current Topic: React Reusable Components
```

---

## 🚀 Next Goal

Continue deeper into React application development by improving component architecture, state management, forms, API integration, and practical application development.

---

## 🧰 Tech Stack

* HTML5
* CSS3
* JavaScript
* React
* Axios
* REST API
* DummyJSON
* Vite
* Git
* GitHub
* VS Code

---

## 👨‍💻 Author

**Jaganmohan Reddy**

Aspiring Full Stack Developer
Focused on MERN Stack Development and Java Backend Development.

#100DaysOfCode #ReactJS #JavaScript #FullStackDevelopment #MERN #Axios #WebDevelopment #LearningInPublic
