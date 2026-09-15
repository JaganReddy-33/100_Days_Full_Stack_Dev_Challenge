
````markdown
# 🚀 100 Days Full Stack Developer Challenge

## 📅 DAY 58 — CORE JAVA + JDBC DAO

Day 58 focused on strengthening Core Java object-oriented programming concepts and applying them to a real-world backend-oriented JDBC DAO architecture.

The day was divided into two major areas:

- Core Java — Encapsulation, Constructors, Constructor Chaining and `static`
- JDBC — DAO Pattern, Account Model, CRUD-style database operations and real-world account management

The practical JDBC work was built around the project:

**Real-Time UPI Payment Fraud & Risk Scoring System**

---

# 📌 DAY 58 — TOPICS COVERED

## Core Java

- Encapsulation
- Data Hiding
- Private Instance Variables
- Getters and Setters
- Controlled Access
- Validation Through Setters
- Real-World Encapsulation
- Constructors
- No-Argument Constructors
- Default Constructors
- Parameterized Constructors
- Constructor Overloading
- Constructor Chaining
- `this()`
- `this.variable`
- Object State Initialization
- Real-World Constructor Design
- Static Variables
- Static Methods
- Static Initialization
- Instance vs Static
- Static Constants
- Utility-Style Static Design
- Static with Constructors
- Common Static Mistakes
- Object Initialization Order
- Initialization Blocks
- Real-World Transaction Model

## JDBC

- JDBC Connection Management
- External Database Configuration
- MySQL Database Connection
- Maven MySQL Connector
- Model / Entity Layer
- DAO Pattern
- DAO Interface
- DAO Implementation
- PreparedStatement
- ResultSet
- Generated Keys
- List of Model Objects
- Account CRUD Operations
- Balance Credit / Debit Operations
- Account Status Management
- Separation of Responsibilities
- Application Layer and User Input
- Database-backed Real-World Account Management

---

# 🔐 PART 1 — CORE JAVA

# 1. ENCAPSULATION

Encapsulation is the process of wrapping data and the methods that operate on that data inside a class while restricting direct access to the internal state.

The main mechanisms used for encapsulation in Java are:

- `private` fields
- `public` getters
- `public` setters
- Validation
- Controlled business operations

## Basic Flow

```text
Private Data
     ↓
Getter / Setter / Business Method
     ↓
Controlled Access
     ↓
Object State
````

---

# 2. DATA HIDING

Instance variables were declared as `private` so they cannot be directly accessed from outside the class.

Example:

```java
private int empId;

private String name;

private double salary;
```

External code cannot directly modify these fields.

Instead:

```text
Main.java
    ↓
setEmpId()
setName()
setSalary()
    ↓
Private Fields
```

This protects the internal state of the object.

---

# 3. GETTERS AND SETTERS

Getters are used to retrieve private data.

Setters are used to modify private data.

Example:

```java
public void setBalance(double balance) {

    if (balance < 0) {
        return;
    }

    this.balance = balance;
}

public double getBalance() {
    return balance;
}
```

This provides controlled access instead of allowing:

```java
account.balance = -50000;
```

---

# 4. VALIDATION THROUGH SETTERS

Validation can be placed inside setters before modifying object state.

Examples:

* ID must be positive
* Name cannot be empty
* Balance cannot be negative
* Marks must be between 0 and 100

Example:

```java
public void setMarks(double marks) {

    if (marks < 0 || marks > 100) {
        return;
    }

    this.marks = marks;
}
```

This ensures invalid values do not directly enter the object state.

---

# 5. REAL-WORLD ENCAPSULATION

A bank account should not expose its balance for direct modification.

Instead of:

```java
account.balance = 100000;
```

the application should provide controlled operations:

```java
account.deposit(50000);

account.withdraw(10000);
```

## Important Design Principle

```text
Private balance
      ↓
deposit()
withdraw()
      ↓
Validation
      ↓
Balance Updated
```

This is closer to how real business applications are designed.

Sensitive state should be controlled through business operations rather than exposing unrestricted setters.

---

# 🏗️ PART 2 — CONSTRUCTORS

# 6. CONSTRUCTOR

A constructor is a special member of a class used to initialize an object when it is created.

Example:

```java
ConstructorBasics_01 employee =
        new ConstructorBasics_01();
```

The constructor executes automatically during object creation.

---

# 7. NO-ARGUMENT CONSTRUCTOR

A constructor without parameters is a no-argument constructor.

Example:

```java
public ConstructorBasics_01() {

    this.empId = 101;
    this.empName = "John Doe";
    this.salary = 50000;
}
```

It initializes an object with predefined or default state.

---

# 8. PARAMETERIZED CONSTRUCTOR

A parameterized constructor accepts values while creating an object.

Example:

```java
ParameterizedConstructor_02 employee =
        new ParameterizedConstructor_02(
                empId,
                empName,
                salary
        );
```

This allows the object to be initialized with actual application data.

---

# 9. CONSTRUCTOR OVERLOADING

A class can have multiple constructors with different parameter lists.

Example:

```java
public ConstructorOverloading_03() {
}

public ConstructorOverloading_03(int empId) {
}

public ConstructorOverloading_03(
        int empId,
        String empName,
        double salary) {
}
```

The compiler selects the constructor based on the arguments supplied.

---

# 10. CONSTRUCTOR CHAINING

Constructor chaining allows one constructor to call another constructor using:

```java
this(...)
```

Example:

```java
public ConstructorChaining_04() {
    this("ORD-DEFAULT");
}

public ConstructorChaining_04(String orderId) {
    this(orderId, "Unknown Restaurant");
}

public ConstructorChaining_04(
        String orderId,
        String restaurant) {

    this(orderId, restaurant, "STANDARD", 40);
}
```

## Constructor Chain

```text
Constructor()
      ↓
Constructor(String)
      ↓
Constructor(String, String)
      ↓
Full Constructor
```

This reduces duplicate initialization logic.

## Important Rule

`this(...)` must be the first statement inside a constructor.

---

# 🔄 `this` KEYWORD

# 11. `this.variable`

When constructor parameters have the same names as instance variables:

```java
public ThisWithConstructors_06(
        String transactionId,
        double amount) {

    this.transactionId = transactionId;
    this.amount = amount;
}
```

The left side:

```java
this.transactionId
```

refers to the object's instance variable.

The right side:

```java
transactionId
```

refers to the constructor parameter.

---

# 💼 REAL-WORLD CORE JAVA EXAMPLES

## UPI Transaction

Constructor-based initialization was applied to a transaction object containing:

* Transaction ID
* Sender UPI
* Receiver UPI
* Amount
* Payment Method

The object could then perform basic transaction-related operations.

```text
Transaction
     ↓
Amount
     ↓
Validation / Risk Evaluation
     ↓
Transaction State
```

---

## Job Application Tracking

Constructor-based initialization was also applied to a job application object containing:

* Application ID
* Candidate Name
* Company
* Role
* Application Source
* Status

The initial application state could later be updated through a business method.

---

# ⚙️ PART 3 — STATIC CONCEPTS

The Static section focused on understanding class-level members and how shared state differs from object-specific state.

---

# 12. STATIC TRANSACTION COUNTER

File:

```text
StaticTransactionCounter_01.java
```

Concepts:

* Instance variables
* Static variables
* Instance methods
* Static methods
* Shared class-level state

The transaction details belong to individual transaction objects.

The transaction counter is shared by all objects.

```text
Transaction 1 ──┐
Transaction 2 ──┼──→ static totalTransactions
Transaction 3 ──┘
```

---

# 13. STATIC PAYMENT CONFIGURATION

File:

```text
StaticPaymentConfig_02.java
```

Concepts:

* Static configuration values
* Static getters
* Static setters
* Shared payment limits
* Validation through static methods

The example maintained:

* Minimum transaction amount
* Maximum transaction amount
* Maximum daily transaction count

Example operations:

```java
StaticPaymentConfig_02.setPaymentLimits(
        100000.00,
        20,
        1.00
);
```

---

# 14. STATIC TRANSACTION UTILITY

File:

```text
StaticTransactionUtility_03.java
```

Concepts:

* Static utility methods
* Validation
* Transaction fee calculation
* Payment method normalization
* Supported payment method validation

Examples:

```text
isValidAmount()
calculateTransactionFee()
normalizePaymentMethod()
isSupportedPaymentMethod()
```

These methods do not require an object because they operate on the supplied input.

---

# 15. STATIC INITIALIZATION

File:

```text
StaticInitialization_04.java
```

A static block is executed when the class is initialized.

The example initialized:

* System name
* Risk threshold
* Fraud detection status

Example flow:

```text
Class Loaded
     ↓
Static Block
     ↓
Static Data Initialized
     ↓
Static Methods Available
```

---

# 16. INSTANCE VS STATIC

File:

```text
InstanceVsStatic_05.java
```

This demonstrated the difference between object-level and class-level data.

```text
INSTANCE                         STATIC
──────────────────────          ─────────────────────
paymentId                       totalPayments
amount
paymentMethod
status
```

Each object maintains its own payment details.

The static counter is shared across all objects.

---

# 17. STATIC WITH CONSTRUCTORS

File:

```text
StaticWithConstructors_06.java
```

The constructor initializes instance-level payment information.

At the same time, a static counter tracks how many payment objects have been created.

```text
new Payment()
      ↓
Constructor
      ↓
Instance State Initialized
      +
Static Counter Increased
```

This demonstrated how constructors and static variables can work together.

---

# 18. STATIC CONSTANTS

File:

```text
StaticConstants_07.java
```

Static constants were used to represent fixed application states.

Examples:

```text
ACCOUNT_ACTIVE
ACCOUNT_SUSPENDED
ACCOUNT_BLOCKED

TRANSACTION_PENDING
TRANSACTION_SUCCESS
TRANSACTION_FAILED
```

The concept demonstrated:

```java
public static final String ACCOUNT_ACTIVE = "ACTIVE";
```

`static final` represents a shared constant value that should not be reassigned.

---

# 19. UTILITY CLASS DESIGN

File:

```text
UtilityClassDesign_08.java
```

The class contained static utility operations such as:

* Transaction amount validation
* Risk score validation
* Payment method normalization
* Risk level determination
* Payment method validation

Risk levels were evaluated as:

```text
80 – 100  → HIGH
50 – 79   → MEDIUM
0 – 49    → LOW
```

---

# 20. STATIC MISTAKES

File:

```text
StaticMistakes_09.java
```

This example was used to understand the difference between:

```text
Object-specific state
        vs
Shared class-level state
```

Account balances remained instance-specific.

The account counter remained static and shared.

This is important because incorrectly declaring business data as `static` can cause all objects to share data unintentionally.

---

# 21. OBJECT INITIALIZATION ORDER

File:

```text
ObjectInitializationOrder_10.java
```

The example demonstrated the execution sequence involving:

```text
Static Initialization
        ↓
Instance Initialization
        ↓
Constructor
```

The practical example used a UPI risk-engine context.

---

# 22. INITIALIZATION BLOCKS

File:

```text
InitializationBlocks_11.java
```

Two types of initialization were demonstrated:

### Static Block

Used for class-level initialization.

### Instance Initialization Block

Used for object-level initialization.

General flow:

```text
Class Initialization
       ↓
Static Block

Object Creation
       ↓
Instance Block
       ↓
Constructor
```

---

# 23. REAL-WORLD TRANSACTION MODEL

File:

```text
RealWorldTransactionModel_12.java
```

This was the final integration example for the Static section.

The model represented a UPI transaction containing:

* Transaction ID
* Sender UPI
* Receiver UPI
* Amount
* Transaction Status

It also used:

* Encapsulation
* Constructor initialization
* Static transaction counter
* Static constants
* Instance methods
* Static methods
* Basic transaction validation

Transaction states:

```text
PENDING
SUCCESS
FAILED
```

The model demonstrated how multiple Core Java concepts can work together in one real-world domain object.

---

# 📂 DAY 58 CORE JAVA STRUCTURE

```text
Day_58_Encapsulation_Constructors_Static
│
├── src
│   └── day58
│       │
│       ├── encapsulation
│       │   ├── EncapsulationBasics_01.java
│       │   ├── GetterSetter_02.java
│       │   ├── EncapsulationValidation_03.java
│       │   └── EncapsulationProblems_04.java
│       │
│       ├── constructors
│       │   ├── ConstructorBasics_01.java
│       │   ├── ParameterizedConstructor_02.java
│       │   ├── ConstructorOverloading_03.java
│       │   ├── ConstructorChaining_04.java
│       │   ├── ConstructorRules_05.java
│       │   ├── ThisWithConstructors_06.java
│       │   └── RealWorldConstructorDesign_07.java
│       │
│       ├── staticconcepts
│       │   ├── StaticTransactionCounter_01.java
│       │   ├── StaticPaymentConfig_02.java
│       │   ├── StaticTransactionUtility_03.java
│       │   ├── StaticInitialization_04.java
│       │   ├── InstanceVsStatic_05.java
│       │   ├── StaticWithConstructors_06.java
│       │   ├── StaticConstants_07.java
│       │   ├── UtilityClassDesign_08.java
│       │   ├── StaticMistakes_09.java
│       │   ├── ObjectInitializationOrder_10.java
│       │   ├── InitializationBlocks_11.java
│       │   └── RealWorldTransactionModel_12.java
│       │
│       └── Main.java
```

---

# 🔌 PART 4 — JDBC DAO

After completing the Core Java portion, the JDBC section moved from basic JDBC concepts into a more realistic DAO-based backend architecture.

The project used:

**Real-Time UPI Payment Fraud & Risk Scoring System**

---

# 🏗️ JDBC ARCHITECTURE

The application follows:

```text
App
 ↓
DAO Interface
 ↓
DAO Implementation
 ↓
JDBC
 ↓
MySQL
```

The responsibilities are separated instead of placing all database code inside `Main.java`.

---

# 📌 DAO PATTERN

DAO stands for:

```text
Data Access Object
```

The DAO layer is responsible for database access operations.

The basic structure is:

```text
Model
  ↓
DAO Interface
  ↓
DAO Implementation
  ↓
JDBC
  ↓
Database
```

---

# 🧩 MODEL / ENTITY

File:

```text
src/main/java/day58/model/Account.java
```

Class:

```text
Account
```

The `Account` class represents one row from the `accounts` database table.

Fields:

```text
accountId
userName
upiId
accountNumber
balance
accountStatus
createdAt
```

The class contains:

* No-argument constructor
* Parameterized constructor
* Getters
* Setters
* `toString()`

The model represents data.

It does not perform database operations.

---

# 🔌 DATABASE CONNECTION

File:

```text
src/main/java/day58/ConnectionEx.java
```

Responsibility:

* Load `db.properties`
* Read database configuration
* Load MySQL JDBC driver
* Create a JDBC connection

Database configuration:

```text
src/main/resources
└── db.properties
```

Example:

```properties
db.url=jdbc:mysql://localhost:3306/upi_fraud_system
db.username=root
db.password=YOUR_MYSQL_PASSWORD
```

The actual database password is not committed to GitHub.

---

# 🗄️ DATABASE

Database:

```text
upi_fraud_system
```

Current table:

```text
accounts
```

Schema:

```sql
CREATE TABLE accounts (
    account_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    upi_id VARCHAR(100) NOT NULL UNIQUE,
    account_number VARCHAR(20) NOT NULL UNIQUE,
    balance DECIMAL(15,2) NOT NULL DEFAULT 0.00,
    account_status VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

# 📄 DATABASE SCRIPT

File:

```text
database/accounts.sql
```

The SQL file contains the database definition for the `accounts` table.

Future tables will be added separately as the project grows.

Planned future modules include:

```text
transactions
risk_scores
fraud_alerts
audit_logs
```

These are part of the larger application architecture and were not created all at once.

---

# 📋 DAO INTERFACE

File:

```text
src/main/java/day58/dao/AccountDAO.java
```

Type:

```text
interface
```

Responsibility:

The interface defines the database operations that an account DAO must provide.

Methods:

```text
createAccount()

findAccountById()

findAccountByUpiId()

findAllActiveAccounts()

updateBalance()

updateAccountStatus()
```

The interface defines **what operations are available**.

It does not contain the JDBC implementation.

---

# 🛠️ DAO IMPLEMENTATION

File:

```text
src/main/java/day58/daoimpl/AccountDAOImpl.java
```

Type:

```text
class
```

The class implements:

```text
AccountDAO
```

Responsibility:

* Write JDBC code
* Execute SQL statements
* Map ResultSet data to Account objects
* Handle generated keys
* Perform database updates
* Return database operation results

Architecture:

```text
AccountDAO
     ↑
implements
     │
AccountDAOImpl
     ↓
JDBC
     ↓
MySQL
```

---

# 1. CREATE ACCOUNT

Method:

```text
createAccount(Account account)
```

Purpose:

Creates a new account in the database.

SQL operation:

```sql
INSERT INTO accounts
(user_name, upi_id, account_number, balance, account_status)
VALUES (?, ?, ?, ?, ?)
```

The implementation uses:

```text
PreparedStatement
```

to safely bind values.

After insertion, the generated `account_id` is retrieved using:

```text
Statement.RETURN_GENERATED_KEYS
getGeneratedKeys()
```

The generated ID is then assigned back to the Account object.

```text
Application
     ↓
Create Account Object
     ↓
INSERT
     ↓
MySQL AUTO_INCREMENT
     ↓
Generated Account ID
     ↓
Account Object Updated
```

---

# 2. FIND ACCOUNT BY ID

Method:

```text
findAccountById(int accountId)
```

SQL:

```sql
SELECT *
FROM accounts
WHERE account_id = ?
```

Because `account_id` is the primary key, the query returns at most one account.

The ResultSet values are mapped into an `Account` object.

If no account exists:

```text
return null
```

---

# 3. FIND ACCOUNT BY UPI ID

Method:

```text
findAccountByUpiId(String upiId)
```

SQL:

```sql
SELECT *
FROM accounts
WHERE upi_id = ?
```

Because `upi_id` is declared `UNIQUE`, the method returns at most one account.

This demonstrates a practical alternative to using an internal database ID.

```text
User-facing UPI ID
       ↓
Database Lookup
       ↓
Account Object
```

---

# 4. FIND ALL ACTIVE ACCOUNTS

Method:

```text
findAllActiveAccounts()
```

SQL:

```sql
SELECT *
FROM accounts
WHERE account_status = 'ACTIVE'
```

Because multiple accounts can be returned, the method returns:

```java
List<Account>
```

The process is:

```text
ResultSet
    ↓
while(resultSet.next())
    ↓
Create Account Object
    ↓
accounts.add(account)
    ↓
Return List<Account>
```

If there are no active accounts, an empty list is returned.

---

# 5. UPDATE ACCOUNT BALANCE

Method:

```text
updateBalance(
    int accountId,
    BigDecimal amount,
    String operation
)
```

The method was designed as a balance adjustment instead of simply replacing the existing balance.

Supported operations:

```text
CREDIT
DEBIT
```

## CREDIT

```text
Existing Balance
       +
Amount
       ↓
New Balance
```

SQL logic:

```sql
UPDATE accounts
SET balance = balance + ?
WHERE account_id = ?
AND account_status = 'ACTIVE'
```

## DEBIT

```text
Existing Balance
       -
Amount
       ↓
New Balance
```

The debit operation also checks that sufficient balance exists.

```sql
UPDATE accounts
SET balance = balance - ?
WHERE account_id = ?
AND account_status = 'ACTIVE'
AND balance >= ?
```

This prevents the database balance from becoming negative through this operation.

---

# 6. UPDATE ACCOUNT STATUS

Method:

```text
updateAccountStatus(
    int accountId,
    String status
)
```

Supported statuses:

```text
ACTIVE
SUSPENDED
BLOCKED
```

The input status is normalized before being stored.

Example:

```text
active
   ↓
ACTIVE
```

SQL:

```sql
UPDATE accounts
SET account_status = ?
WHERE account_id = ?
```

The status becomes an important business rule for future transaction processing.

---

# 🔐 ACCOUNT STATUS FLOW

```text
ACTIVE
  │
  ├── Transactions Allowed
  │
  ↓
SUSPENDED
  │
  ├── Restricted Activity
  │
  ↓
BLOCKED
  │
  └── Transactions Denied
```

The actual transaction authorization rules will be implemented later in the Service layer.

---

# 🖥️ APPLICATION LAYER

File:

```text
src/main/java/day58/App.java
```

Responsibility:

* User input
* Menu display
* Calling DAO methods
* Displaying results
* Basic application flow

The application currently provides account operations such as:

```text
1. Create Account
2. Find Account By ID
3. Find All Active Accounts
4. Update Account Balance
5. Update Account Status
0. Exit
```

Scanner input remains in the application layer.

DAO classes do not handle Scanner input or user-interface printing.

---

# 📂 DAY 58 JDBC STRUCTURE

```text
Day_58_JDBC_DAO
│
├── database
│   └── accounts.sql
│
├── src
│   └── main
│       │
│       ├── java
│       │   └── day58
│       │       │
│       │       ├── config
│       │       │
│       │       ├── model
│       │       │   └── Account.java
│       │       │
│       │       ├── dao
│       │       │   └── AccountDAO.java
│       │       │
│       │       ├── daoimpl
│       │       │   └── AccountDAOImpl.java
│       │       │
│       │       ├── ConnectionEx.java
│       │       └── App.java
│       │
│       └── resources
│           ├── db.properties
│           └── db.properties.example
│
└── pom.xml
```

---

# 🧠 IMPORTANT JDBC LEARNINGS

## PreparedStatement

Used for parameterized SQL queries.

```text
SQL
 ↓
?
 ↓
setInt()
setString()
setBigDecimal()
 ↓
execute
```

It provides cleaner parameter handling and helps prevent SQL injection.

---

## ResultSet

Used to read rows returned by a SELECT query.

For one expected row:

```java
if (resultSet.next()) {
}
```

For multiple rows:

```java
while (resultSet.next()) {
}
```

This distinction is important.

---

## List<Account>

`List<Account>` means:

```text
A List
   ↓
containing
   ↓
Account objects
```

Example:

```text
Account 1
Account 2
Account 3
Account 4
```

All can be stored inside:

```java
List<Account>
```

---

## BigDecimal

`BigDecimal` was used for database balance and monetary values.

This is more appropriate for financial calculations than using floating-point values such as `double`.

---

## Generated Keys

The `accounts.account_id` column uses:

```text
AUTO_INCREMENT
```

The application does not manually generate the ID.

JDBC retrieves the generated ID after insertion.

```text
INSERT
  ↓
MySQL generates ID
  ↓
getGeneratedKeys()
  ↓
Account.setAccountId()
```

---

# 🏗️ CURRENT BACKEND ARCHITECTURE

The Day 58 JDBC implementation established the foundation for a larger backend architecture.

Current:

```text
App
 ↓
DAO Interface
 ↓
DAO Implementation
 ↓
JDBC
 ↓
MySQL
```

Target architecture:

```text
App / Controller
       ↓
    Service
       ↓
      DAO
       ↓
     JDBC
       ↓
     MySQL
```

Later, the Service layer will contain business rules instead of placing them directly in the application layer.

---

# 🚀 REAL-TIME UPI FRAUD & RISK SCORING SYSTEM

The JDBC DAO work is the database foundation of the larger project.

Planned modules:

```text
Users
Accounts
Merchants
Transactions
Risk Scores
Fraud Alerts
Audit Logs
Notifications
```

Planned high-level flow:

```text
UPI Transaction
      ↓
Account Validation
      ↓
Transaction Validation
      ↓
Risk Evaluation
      ↓
Risk Score
      ↓
Risk Level
      ↓
Fraud Detection
      ↓
Fraud Alert
      ↓
Audit Log
```

The current Day 58 implementation only establishes the account and DAO foundation.

The complete fraud detection system will be built progressively.

---

# 🧠 DAY 58 KEY LEARNINGS

## Core Java

* Encapsulation protects internal object state.
* `private` fields prevent direct external access.
* Getters provide controlled read access.
* Setters provide controlled write access.
* Validation should happen before modifying object state.
* Business methods can be better than exposing unrestricted setters.
* Constructors initialize objects during creation.
* Constructors do not have a return type.
* Constructor names must match the class name.
* Constructors can be overloaded.
* `this()` is used for constructor chaining.
* `this.variable` refers to the current object's instance variable.
* Constructor chaining reduces duplicate initialization logic.
* Static variables belong to the class rather than an individual object.
* Static methods can be called without creating an object.
* Static blocks perform class-level initialization.
* Instance state and static state have different lifecycles.
* `static final` is useful for shared constants.
* Utility-style classes can provide reusable static operations.
* Initialization order is important when working with static and instance blocks.

## JDBC

* JDBC connects Java applications to relational databases.
* Database configuration should be externalized.
* Maven can manage the MySQL JDBC dependency.
* Model classes represent database data.
* DAO means Data Access Object.
* DAO interfaces define database operation contracts.
* DAO implementations contain actual JDBC code.
* PreparedStatement handles parameterized SQL.
* ResultSet represents query results.
* `if(resultSet.next())` is suitable when one row is expected.
* `while(resultSet.next())` is required when multiple rows may exist.
* `List<Account>` represents multiple Account objects.
* Generated keys can retrieve AUTO_INCREMENT IDs.
* `BigDecimal` is suitable for monetary database values.
* Scanner/user input belongs in the application layer.
* DAO classes should focus on database access.
* Database operations can be separated from application logic.
* Account status can become an important business rule.
* Balance operations should distinguish between CREDIT and DEBIT.

---

# 🎯 DAY 58 PRACTICE COMPLETED

## Core Java — Encapsulation

* Employee data encapsulation
* Getter/setter implementation
* Validation
* Student validation
* Bank account controlled operations
* Real-world encapsulation

## Core Java — Constructors

* No-argument constructor
* Default constructor
* Parameterized constructor
* Constructor overloading
* Constructor chaining
* `this()`
* `this.variable`
* Object state initialization
* API request configuration
* Food delivery order configuration
* UPI transaction object
* Job application object

## Core Java — Static

* Static variables
* Static methods
* Static configuration
* Static utility methods
* Static initialization
* Instance vs static
* Static constants
* Utility class design
* Static mistakes
* Object initialization order
* Initialization blocks
* Static with constructors
* Real-world transaction model

## JDBC — DAO

* Database configuration
* JDBC connection
* MySQL connection
* Account model
* DAO interface
* DAO implementation
* Create account
* Find account by ID
* Find account by UPI ID
* Find all active accounts
* Credit balance
* Debit balance
* Account status update
* Generated account IDs
* PreparedStatement
* ResultSet
* List of Account objects
* Application-level Scanner input
* DAO-based architecture

---

# 🎤 DAY 58 — INTERVIEW QUESTIONS

## 1. What is encapsulation?

**Direct answer:**

Encapsulation is wrapping data and methods together inside a class while restricting direct access to the object's internal state.

**Why/how:**

Java commonly achieves this using `private` fields and controlled public methods.

**Real-world gotcha:**

Do not blindly create setters for every field. Sensitive state can be changed through business methods such as `deposit()` and `withdraw()`.

**Likely follow-up:**

What is the difference between encapsulation and data hiding?

---

## 2. Why are fields usually declared private?

**Direct answer:**

To prevent direct external modification and maintain control over object state.

**Why/how:**

Access is provided through getters, setters, or business methods.

**Real-world gotcha:**

A public setter can still expose too much control, so validation and business rules matter.

**Likely follow-up:**

Can encapsulation exist without setters?

---

## 3. What is a constructor?

**Direct answer:**

A constructor is a special member used to initialize an object when it is created.

**Why/how:**

It executes automatically when `new` creates an object.

**Real-world gotcha:**

A constructor has no return type, not even `void`.

**Likely follow-up:**

What happens if no constructor is explicitly written?

---

## 4. What is constructor overloading?

**Direct answer:**

Constructor overloading means defining multiple constructors with different parameter lists in the same class.

**Why/how:**

Java selects the appropriate constructor based on the arguments supplied.

**Real-world gotcha:**

Changing only the return type is irrelevant because constructors do not have return types.

**Likely follow-up:**

How is constructor overloading different from method overloading?

---

## 5. What is constructor chaining?

**Direct answer:**

Constructor chaining is calling one constructor from another constructor using `this(...)`.

**Why/how:**

It allows common initialization logic to be centralized.

**Real-world gotcha:**

`this(...)` must be the first statement in the constructor.

**Likely follow-up:**

What is the difference between `this()` and `super()`?

---

## 6. What is the difference between static and instance variables?

**Direct answer:**

An instance variable belongs to an individual object, while a static variable belongs to the class and is shared by its objects.

**Why/how:**

Every object gets its own instance state, while one static variable exists at the class level.

**Real-world gotcha:**

Business data such as an account balance should normally not be static because different accounts need independent balances.

**Likely follow-up:**

Can a static method directly access an instance variable?

---

## 7. Why are utility methods often static?

**Direct answer:**

Because they usually perform operations using only their input parameters and do not require object-specific state.

**Why/how:**

They can be called directly using the class name.

**Real-world gotcha:**

Do not make a method static simply because it is convenient. If the method depends on object state, it should generally be an instance method.

**Likely follow-up:**

Can a static method access an instance variable directly?

---

## 8. What is DAO?

**Direct answer:**

DAO stands for Data Access Object. It separates database access logic from the rest of the application.

**Why/how:**

The DAO contains operations such as create, find, update and delete while the application layer does not need to know the JDBC implementation details.

**Real-world gotcha:**

DAO is a design pattern, not a separate database technology.

**Likely follow-up:**

What is the difference between DAO and Service?

---

## 9. Why use an interface for DAO?

**Direct answer:**

The DAO interface defines the database operation contract while the implementation class provides the actual JDBC logic.

**Why/how:**

This creates separation of responsibilities and allows the implementation to change without changing the contract.

**Real-world gotcha:**

The interface should describe what the DAO can do, not contain the JDBC implementation itself.

**Likely follow-up:**

What is the difference between an interface and an implementation class?

---

## 10. Why use `List<Account>` for `findAllActiveAccounts()`?

**Direct answer:**

Because the query can return multiple database rows and each row is represented by an `Account` object.

**Why/how:**

Each ResultSet row becomes an Account object and those objects are stored inside a List.

**Real-world gotcha:**

Use `while(resultSet.next())` when multiple rows are expected.

**Likely follow-up:**

What happens when no active accounts exist?

---

# 📈 DAY 58 FINAL PROGRESS

```text
DAY 58
│
├── Core Java
│   │
│   ├── Encapsulation              ✅
│   ├── Constructors               ✅
│   ├── Constructor Chaining       ✅
│   └── static                     ✅
│
└── JDBC
    │
    ├── Connection                 ✅
    ├── Model / Entity             ✅
    ├── DAO Interface              ✅
    ├── DAO Implementation         ✅
    ├── Create Account             ✅
    ├── Find By ID                 ✅
    ├── Find By UPI ID             ✅
    ├── Find All Active Accounts   ✅
    ├── Update Balance             ✅
    └── Update Account Status      ✅
```

# ✅ DAY 58 — COMPLETED

Day 58 successfully combined Core Java object-oriented programming with practical JDBC database development.

The Core Java portion strengthened:

```text
Encapsulation
      ↓
Constructors
      ↓
Constructor Chaining
      ↓
Static
      ↓
Real-World Object Design
```

The JDBC portion established:

```text
Application
      ↓
DAO Interface
      ↓
DAO Implementation
      ↓
JDBC
      ↓
MySQL
```

The foundation is now ready for the next backend layer.

---

# 🔜 NEXT STEP

The next major backend progression is:

```text
DAY 58 JDBC DAO
      ↓
SERVICE LAYER
      ↓
BUSINESS LOGIC
      ↓
TRANSACTION DOMAIN
      ↓
MULTI-STEP DATABASE OPERATIONS
      ↓
JDBC TRANSACTIONS
      ↓
RISK SCORING
      ↓
FRAUD DETECTION
      ↓
FRAUD ALERTS
      ↓
AUDIT LOGGING
```

The project will continue progressively instead of creating the entire backend at once.

---

# 🛠️ TECHNOLOGY

* Java
* JDK
* Eclipse IDE
* Object-Oriented Programming
* JDBC
* MySQL
* Maven
* MySQL Connector/J
* Git
* GitHub

---

# 👨‍💻 AUTHOR

**Jagan Mohan Reddy**

GitHub:

```text
JaganReddy-33
```

100 Days Full Stack Developer Challenge

---

# 🚀 PROGRESS

**Day 58 — COMPLETED ✅**

Core Java:

**Encapsulation + Constructors + Constructor Chaining + Static**

JDBC:

**Connection + Model + DAO + Account Database Operations**

The Day 58 foundation is complete and ready for the next backend architecture layer.

```
```
