# Day 61 — Advanced Java: Web Fundamentals

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square\&logo=openjdk)
![Maven](https://img.shields.io/badge/Maven-Project-C71A36?style=flat-square\&logo=apachemaven)
![HTTP](https://img.shields.io/badge/HTTP-Web%20Fundamentals-blue?style=flat-square)
![Status](https://img.shields.io/badge/Status-Completed-success?style=flat-square)

Part of my **100 Days Full Stack Developer Challenge**, focused on understanding the fundamentals of how web applications communicate through HTTP.

---

## 📌 Overview

Day 61 introduces the core concepts required before working with Java web technologies such as **Servlets, JSP, REST APIs, and Spring-based applications**.

The concepts are reinforced through small Java-based practical exercises rather than theory alone.

---

## 📚 Topics Covered

| Session | Topic                                                    |
| ------- | -------------------------------------------------------- |
| S1      | Client, Server & Web Application                         |
| S2      | URL, URI, HTTP & HTTPS                                   |
| S3      | HTTP Methods                                             |
| S4      | HTTP Headers, Content-Type & MIME Types                  |
| S5      | Status Codes, Query Parameters, Request Body & Form Data |

---

## 💻 Practical Exercises

### S1 — HTTP Request & Response

**File:** `HttpRequestResponseSimulator_1.java`

Simulates the basic web communication flow:

```text
Client
   ↓
HTTP Request
   ↓
Server
   ↓
Java Application
   ↓
HTTP Response
   ↓
Client
```

---

### S2 — URL & URI Parser

**File:** `URLURIParser_2.java`

Works with a real URI and extracts:

* Scheme
* Host
* Port
* Path
* Query
* Query Parameters

Uses Java's `java.net.URI` API.

---

### S3 — HTTP Method Router

**File:** `HttpMethodRouter_3.java`

Demonstrates routing requests based on HTTP methods:

| Method | Operation |
| ------ | --------- |
| GET    | Retrieve  |
| POST   | Create    |
| PUT    | Update    |
| DELETE | Delete    |

Also demonstrates handling an unsupported HTTP method with `405 Method Not Allowed`.

---

### S4 — HTTP Headers & MIME Types

**File:** `HttpHeadersAndMimeTypes_4.java`

Practices:

* HTTP Headers
* `Content-Type`
* `Accept`
* `Authorization`
* `Cache-Control`
* MIME Types

Examples include:

```text
application/json
text/html
text/plain
application/xml
application/x-www-form-urlencoded
```

---

### S5 — Request Data

**File:** `RequestDataSystem_5.java`

Demonstrates different ways request data can be transmitted:

```text
GET
 └── Query Parameters

POST
 ├── Request Body
 └── Form Data
```

The exercise compares how these different request-data mechanisms are represented in a web request.

---

## 🛠️ Technologies & Tools

* Java 21
* Maven
* HTTP Fundamentals
* URI API
* Postman
* Browser Developer Tools

---

## 📂 Project Structure

```text
Day_61_Web_Fundamentals/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── day61/
│   │   │       ├── HttpRequestResponseSimulator_1.java
│   │   │       ├── URLURIParser_2.java
│   │   │       ├── HttpMethodRouter_3.java
│   │   │       ├── HttpHeadersAndMimeTypes_4.java
│   │   │       └── RequestDataSystem_5.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│       └── java/
│
├── pom.xml
└── README.md
```

---

## 🔄 Web Fundamentals Flow

```text
Client
  │
  │ HTTP Request
  ▼
Server
  │
  │ Route Request
  ▼
Java Application
  │
  │ Process Data
  ▼
HTTP Response
  │
  ▼
Client
```

These fundamentals provide the foundation for understanding how Java web technologies process HTTP requests and responses.

---

## 🎯 Learning Outcome

After completing Day 61, I can:

* Explain the client-server architecture.
* Understand the HTTP request/response model.
* Identify the components of a URL and URI.
* Understand HTTP vs HTTPS.
* Explain GET, POST, PUT, and DELETE.
* Understand safe and idempotent HTTP methods.
* Work with HTTP headers and MIME types.
* Understand common HTTP status-code categories.
* Distinguish query parameters, request bodies, and form data.
* Understand the basic communication model used by Java web applications.

---

## 📊 Progress

| Session    | Topic                              | Status          |
| ---------- | ---------------------------------- | --------------- |
| S1         | Client, Server & Request/Response  | ✅ Completed     |
| S2         | URL, URI, HTTP & HTTPS             | ✅ Completed     |
| S3         | HTTP Methods                       | ✅ Completed     |
| S4         | Headers, Content-Type & MIME Types | ✅ Completed     |
| S5         | Status Codes & Request Data        | ✅ Completed     |
| **Day 61** | **Web Fundamentals**               | **✅ Completed** |

---

## 🚀 Next Step

The next stage is to apply these HTTP fundamentals using **Java Servlets**, where HTTP requests and responses will be handled by an actual Java web application.

**Day 61 — Advanced Java Web Fundamentals: Completed ✅**
