# Day 62 — Advanced Java: Servlets

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square\&logo=openjdk)
![Servlet](https://img.shields.io/badge/Servlet-Jakarta%20Servlet-blue?style=flat-square)
![Tomcat](https://img.shields.io/badge/Apache%20Tomcat-10.1-F8DC75?style=flat-square\&logo=apachetomcat)
![HTTP](https://img.shields.io/badge/HTTP-Request%2FResponse-blue?style=flat-square)
![Status](https://img.shields.io/badge/Status-Completed-success?style=flat-square)

Part of my **100 Days Full Stack Developer Challenge**, focused on understanding how Java Servlets process HTTP requests and generate HTTP responses inside a servlet container.

---

## 📌 Overview

Day 62 introduces **Java Servlets**, the foundation of traditional Java web application development and an important step toward technologies such as **JSP, MVC, REST APIs, and Spring-based applications**.

The day focuses on understanding how a servlet container such as **Apache Tomcat** manages servlet execution, request processing, URL mapping, servlet lifecycle, HTTP methods, and request parameters.

The concepts are reinforced through practical servlet exercises deployed and tested using a real Java web application environment.

---

## 📚 Topics Covered

| Session | Topic                                     |
| ------- | ----------------------------------------- |
| S1      | Servlet Fundamentals                      |
| S2      | Servlet Lifecycle                         |
| S3      | URL Mapping                               |
| S4      | `doGet()` & `doPost()`                    |
| S5      | HTML Form Submission & Request Parameters |
| S6      | `HttpServletRequest` Parameters           |

---

## 💻 Practical Exercises

### S1 — Servlet Fundamentals

**File:** `HelloServlet_1.java`

Introduces the basic servlet architecture and demonstrates how a Java servlet receives an HTTP request and produces an HTTP response.

The exercise establishes the relationship between the browser, Tomcat, the servlet container, and the servlet:

```text
Browser
   ↓
HTTP Request
   ↓
Apache Tomcat
   ↓
Servlet Container
   ↓
HelloServlet
   ↓
HTTP Response
   ↓
Browser
```

The servlet extends `HttpServlet` and handles a GET request using `doGet()`.

---

### S2 — Servlet Lifecycle

**File:** `LifecycleServlet_2.java`

Demonstrates the lifecycle methods managed by the servlet container:

* `init()`
* `service()`
* `doGet()` / `doPost()`
* `destroy()`

The lifecycle flow is:

```text
Servlet Class
     ↓
Servlet Object Created
     ↓
init()
     ↓
service()
     ↓
doGet() / doPost()
     ↓
service()
     ↓
destroy()
```

The practical exercise also demonstrates that `init()` is used for servlet initialization and `destroy()` is called when the servlet is removed from service.

---

### S3 — URL Mapping

**File:** `AnnotationMappingServlet_3.java`

Demonstrates servlet URL mapping using the `@WebServlet` annotation.

Example mapping:

```java
@WebServlet("/annotation")
```

The servlet can then be accessed through:

```text
http://localhost:8081/Day_62_Servlet/annotation
```

The exercise also establishes the difference between annotation-based mapping and deployment-descriptor-based mapping using `web.xml`.

---

### S4 — HTTP GET & POST

**Files:**

* `GetRequestServlet_4.java`
* `PostRequestServlet_5.java`

Demonstrates how servlets handle different HTTP methods.

| HTTP Method | Servlet Method | Purpose                         |
| ----------- | -------------- | ------------------------------- |
| GET         | `doGet()`      | Retrieve/process requested data |
| POST        | `doPost()`     | Receive/process submitted data  |

The GET exercise handles a direct browser request, while the POST exercise receives data submitted from an HTML registration form.

---

### S5 — HTML Form Submission

**File:** `PostRequestServlet_5.java`

Demonstrates communication between an HTML form and a Java servlet.

The registration page submits data using:

```html
<form action="post" method="post">
```

The servlet receives the submitted form parameters using:

```java
request.getParameter("firstName");
request.getParameter("lastName");
request.getParameter("email");
request.getParameter("phone");
request.getParameter("password");
request.getParameter("confirmPassword");
request.getParameter("terms");
```

The request flow is:

```text
HTML Registration Form
          ↓
      POST /post
          ↓
   HttpServletRequest
          ↓
    getParameter()
          ↓
     Java Variables
          ↓
    Servlet Processing
          ↓
    HTML Response
```

The exercise demonstrates how frontend form fields become request parameters available to the servlet.

---

### S6 — Request Parameters

**File:** `RequestParameterServlet_6.java`

Demonstrates retrieving query parameters directly from the URL using `HttpServletRequest`.

Example request:

```text
http://localhost:8081/Day_62_Servlet/request-params?name=Jagan&email=jagan@gmail.com&course=Java
```

The servlet retrieves the parameters using:

```java
request.getParameter("name");
request.getParameter("email");
request.getParameter("course");
```

The request flow is:

```text
Browser URL
     ↓
Query Parameters
     ↓
HttpServletRequest
     ↓
getParameter()
     ↓
Java Variables
     ↓
HTML Response
```

This exercise isolates the core concept of retrieving request data through `HttpServletRequest`.

---

## 🛠️ Technologies & Tools

* Java 21
* Jakarta Servlet API
* Apache Tomcat 10.1
* Eclipse IDE
* Dynamic Web Project
* HTML
* CSS
* HTTP
* `HttpServlet`
* `HttpServletRequest`
* `HttpServletResponse`
* `@WebServlet`
* `web.xml`
* Browser Developer Tools

---

## 📂 Project Structure

```text
Day_62_Servlet/
│
├── Java Resources/
│   └── src/
│       └── day62/
│           ├── HelloServlet_1.java
│           ├── LifecycleServlet_2.java
│           ├── AnnotationMappingServlet_3.java
│           ├── GetRequestServlet_4.java
│           ├── PostRequestServlet_5.java
│           └── RequestParameterServlet_6.java
│
├── WebContent/
│   ├── index.html
│   ├── post.html
│   └── WEB-INF/
│       └── web.xml
│
└── README.md
```

---

## 🔄 Servlet Request Processing Flow

```text
Client / Browser
       │
       │ HTTP Request
       ▼
Apache Tomcat
       │
       ▼
Servlet Container
       │
       │ URL Mapping
       ▼
Java Servlet
       │
       ├── doGet()
       │
       └── doPost()
       │
       ▼
HttpServletRequest
       │
       │ getParameter()
       ▼
Java Application Logic
       │
       ▼
HttpServletResponse
       │
       ▼
HTML Response
       │
       ▼
Client / Browser
```

This flow demonstrates how a Java servlet acts as the server-side component responsible for receiving HTTP requests, processing request data, and generating responses.

---

## 🔗 URL Mapping Flow

```text
Browser
   │
   │ /hello
   ▼
@WebServlet("/hello")
   │
   ▼
HelloServlet_1
   │
   ▼
doGet()
   │
   ▼
HTTP Response
```

For deployment-descriptor mapping:

```text
Browser
   │
   │ /lifecycle
   ▼
web.xml
   │
   ▼
LifecycleServlet_2
   │
   ▼
doGet()
   │
   ▼
HTTP Response
```

---

## 📥 Request Parameter Flow

### GET Query Parameters

```text
GET /request-params?name=Jagan&email=jagan@gmail.com&course=Java
                         │
                         ▼
                HttpServletRequest
                         │
                         ▼
                  getParameter()
                         │
              ┌──────────┼──────────┐
              ▼          ▼          ▼
            name       email      course
              │          │          │
              ▼          ▼          ▼
           Jagan   jagan@gmail.com  Java
```

### POST Form Parameters

```text
HTML Form
    │
    │ method="POST"
    ▼
POST /post
    │
    ▼
HttpServletRequest
    │
    ▼
getParameter()
    │
    ├── firstName
    ├── lastName
    ├── email
    ├── phone
    ├── password
    ├── confirmPassword
    └── terms
```

---

## 🎯 Learning Outcome

After completing Day 62, I can:

* Explain what a Java Servlet is.
* Explain the role of a servlet container.
* Understand how Apache Tomcat manages servlets.
* Explain the relationship between `HttpServlet` and servlet classes.
* Understand the servlet lifecycle.
* Explain `init()`, `service()`, and `destroy()`.
* Understand how `service()` dispatches requests to `doGet()` and `doPost()`.
* Map servlets using `@WebServlet`.
* Configure servlet mappings using `web.xml`.
* Handle HTTP GET requests using `doGet()`.
* Handle HTTP POST requests using `doPost()`.
* Submit HTML form data to a servlet.
* Retrieve request parameters using `HttpServletRequest`.
* Understand URL query parameters.
* Use `request.getParameter()` to extract client-provided data.
* Understand the basic request-processing flow of a Java web application.
* Deploy and test a servlet application using Apache Tomcat.

---

## 📊 Progress

| Session    | Topic                                     | Status          |
| ---------- | ----------------------------------------- | --------------- |
| S1         | Servlet Fundamentals                      | ✅ Completed     |
| S2         | Servlet Lifecycle                         | ✅ Completed     |
| S3         | URL Mapping                               | ✅ Completed     |
| S4         | `doGet()` & `doPost()`                    | ✅ Completed     |
| S5         | HTML Form Submission & Request Parameters | ✅ Completed     |
| S6         | `HttpServletRequest` Parameters           | ✅ Completed     |
| **Day 62** | **Java Servlets**                         | **✅ Completed** |

---

## 🚀 Next Step

The next stage is to build on the Servlet foundation and understand how Java web applications separate **server-side Java logic from presentation**, leading into **JSP (JavaServer Pages)** and subsequent web application architecture.

**Day 62 — Advanced Java Servlets: Completed ✅**
