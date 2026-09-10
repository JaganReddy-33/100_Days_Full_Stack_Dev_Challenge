
````markdown
# ☕ Day 56 — Core Java: Strings

## 🚀 100 Days Full Stack Developer Challenge

Day 56 focused completely on **Strings in Java**, starting from String fundamentals and built-in methods and progressing toward String manipulation, conversion, loop-based operations, basic programs, and problem solving.

The day was completed in **two parts**:

- **Part 1:** String Fundamentals → Modification
- **Part 2:** String Conversion → String Problem Solving

---

# 📅 Day 56 — Core Java

## 🎯 Objective

The main objective of Day 56 was to understand how Strings work internally and practically in Java, including:

- String creation
- String literals
- String pool
- String immutability
- String methods
- String comparison
- String searching
- String modification
- String conversion
- String traversal using loops
- Basic String programs
- String problem solving

---

# 🧩 Part 1 — String Fundamentals to Modification

The first part of Day 56 covered the core String concepts and commonly used String APIs.

## 📂 Part 1 Files

```text
Day_56_Strings
└── src
    └── day56
        ├── StringBasics.java
        ├── StringMethods.java
        ├── StringComparison.java
        ├── StringSearching.java
        └── StringModification.java
````

---

## 1️⃣ StringBasics.java

### Topics Covered

* What is a String?
* String declaration
* String initialization
* String literals
* `new String()`
* String indexing
* `length()`
* `charAt()`
* String vs character array
* String immutability
* String pool
* Literal vs `new String()`

### Key Concepts

```java
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");
```

Practiced the difference between String literals and objects created using `new String()`.

Also understood that Strings are **immutable**, meaning String objects cannot be directly modified after creation.

---

# 2️⃣ StringMethods.java

### Methods Practiced

* `toUpperCase()`
* `toLowerCase()`
* `trim()`
* `strip()`
* `substring()`
* `contains()`
* `startsWith()`
* `endsWith()`
* `isEmpty()`
* `isBlank()`
* `concat()`

### Practical Focus

Practiced using Java's built-in String methods for:

* Case conversion
* Removing surrounding whitespace
* Extracting substrings
* Checking String content
* Checking prefixes and suffixes
* Checking empty and blank Strings
* Combining Strings

---

# 3️⃣ StringComparison.java

### Topics Covered

* `equals()`
* `equalsIgnoreCase()`
* `compareTo()`
* `compareToIgnoreCase()`
* `==` vs `equals()`
* String pool comparison
* Reference comparison
* Content comparison

### Important Concept

```java
==
```

checks whether two references point to the same object.

```java
equals()
```

checks whether two Strings contain the same content.

This is an important Java interview concept.

---

# 4️⃣ StringSearching.java

### Topics Covered

* `indexOf()`
* `lastIndexOf()`
* `contains()`
* `startsWith()`
* `endsWith()`
* Character searching
* Substring searching
* Searching from a specific index
* First occurrence
* Last occurrence
* Multiple occurrence searching

### Practical Examples

Worked with Strings such as:

```text
Java Programming
Java Java Java
```

and practiced locating characters and substrings using different String searching methods.

---

# 5️⃣ StringModification.java

### Topics Covered

* `replace()`
* `replaceAll()`
* Character replacement
* String replacement
* Removing characters
* Removing spaces
* `substring()` based modification
* `concat()`
* String immutability during modification

### Important Concept

String methods return a **new String** because Strings are immutable.

Example:

```java
String text = "Java";

text.replace("Java", "Python");
```

does not change the original String.

To store the modified value:

```java
text = text.replace("Java", "Python");
```

---

# 🧩 Part 2 — Conversion to Problem Solving

After completing the first five String files, the remaining Day 56 topics were implemented as additional String practice files.

## 📂 Part 2 Files

```text
Day_56_Strings
└── src
    └── day56
        ├── StringConversion.java
        ├── StringWithLoops.java
        ├── BasicStringPrograms.java
        ├── StringProblemSolving.java
        └── Main.java
```

---

# 6️⃣ StringConversion.java

### Topics Covered

* String → `char[]`
* `char[]` → String
* String → `char`
* String → `int`
* String → `double`
* `int` → String
* `double` → String
* Character → String
* Character array modification
* Conversion and modification

### Methods / APIs Practiced

```java
toCharArray()
```

```java
new String(charArray)
```

```java
String.valueOf()
```

```java
Integer.parseInt()
```

```java
Double.parseDouble()
```

```java
charAt()
```

### Practical Flow

```text
String
  ↓
char[]
  ↓
Modify characters
  ↓
String
```

Also practiced:

```text
String number
      ↓
int / double
      ↓
Calculation
      ↓
String
```

---

# 7️⃣ StringWithLoops.java

### Topics Covered

* String traversal using `for`
* String traversal using `while`
* Enhanced `for` loop with `char[]`
* Character indexing
* Printing characters with indexes
* Counting vowels
* Counting consonants
* Counting digits
* Counting spaces
* Counting uppercase characters
* Counting lowercase characters

### Practical Focus

Combined:

```text
String + charAt() + length() + loops
```

to build the foundation for String-based problem solving.

---

# 8️⃣ BasicStringPrograms.java

### Programs Practiced

* Reverse a String
* Check palindrome
* Count vowels
* Count consonants
* Count digits
* Count special characters
* Count words
* Count spaces
* Find longest word
* Find shortest word
* Replace characters
* Remove spaces

### Problem-Solving Flow

```text
Input String
     ↓
Traverse characters
     ↓
Apply condition
     ↓
Maintain count/result
     ↓
Display output
```

---

# 9️⃣ StringProblemSolving.java

This was the final and more problem-solving-oriented section of Day 56.

### Problems Practiced

* Character frequency
* Find duplicate characters
* Remove duplicate characters
* First non-repeating character
* First repeating character
* Reverse each word
* Reverse word order
* Check anagram
* Count substring occurrences
* Check whether String contains only digits

### Important Problem-Solving Concepts

Practiced combining:

* `for` loops
* `while` loops
* Nested loops
* `charAt()`
* `indexOf()`
* `split()`
* `substring()`
* `toCharArray()`
* `Arrays.sort()`
* `Arrays.equals()`
* Conditional logic

---

# 🔟 Main.java

`Main.java` was used to execute the methods from all String classes.

The individual classes contain the actual implementation, while `Main.java` calls the methods one by one.

Example:

```java
StringBasics stringBasics = new StringBasics();

stringBasics.declarationAndInitialization();
stringBasics.stringLiteralsAndNew();
stringBasics.indexingAndLength();
```

The same approach was followed for the remaining String classes.

---

# 📂 Complete Day 56 Structure

```text
Day_56_Strings
│
├── src
│   └── day56
│       │
│       ├── StringBasics.java
│       ├── StringMethods.java
│       ├── StringComparison.java
│       ├── StringSearching.java
│       ├── StringModification.java
│       │
│       ├── StringConversion.java
│       ├── StringWithLoops.java
│       ├── BasicStringPrograms.java
│       ├── StringProblemSolving.java
│       │
│       └── Main.java
│
└── JRE System Library
```

---

# 🧠 Key Learnings from Day 56

By completing Day 56, I strengthened my understanding of Java Strings from fundamentals to practical problem solving.

### String Fundamentals

* String creation
* String literals
* `new String()`
* String pool
* String immutability

### String API

* Case conversion
* Whitespace handling
* Substrings
* Content checking
* Prefix/suffix checking
* Empty/blank checking
* Concatenation

### String Comparison

* `equals()`
* `equalsIgnoreCase()`
* `compareTo()`
* `compareToIgnoreCase()`
* `==` vs `equals()`

### String Searching

* `indexOf()`
* `lastIndexOf()`
* `contains()`
* `startsWith()`
* `endsWith()`

### String Modification

* `replace()`
* `replaceAll()`
* `substring()`
* `concat()`
* Removing characters/spaces

### String Conversion

* String ↔ `char[]`
* String ↔ numeric values
* Character conversion

### String + Loops

* Character traversal
* Counting
* Searching
* Conditional processing

### String Problem Solving

* Reverse
* Palindrome
* Frequency
* Duplicates
* Non-repeating characters
* Anagram
* Word manipulation
* Substring occurrence
* Digit validation

---

# 🎯 Day 56 Outcome

Day 56 progressed through the following learning path:

```text
String Fundamentals
        ↓
String Methods
        ↓
String Comparison
        ↓
String Searching
        ↓
String Modification
        ↓
String Conversion
        ↓
String + Loops
        ↓
Basic String Programs
        ↓
String Problem Solving
```

This completed the planned **Core Java String module for Day 56**.

---

# 💻 Development Environment

* Java
* JDK
* Eclipse IDE
* Git
* GitHub

---

# 📊 Day 56 Progress

```text
Part 1 — String Fundamentals → Modification     ✅ 100%
Part 2 — Conversion → Problem Solving            ✅ 100%

Day 56 Core Java                              ✅ COMPLETED
```

---

# 🚀 Next Step

**Day 56 Core Java — COMPLETED ✅**

The next focus is the **JDBC part of Day 56**.

JDBC Day 56 already includes **5 practical transaction problems** covering transaction handling, multiple operations, transfers, rollback/business-rule failures, and transaction verification.

If needed, I will continue with **3–4 additional practical JDBC transaction problems** to strengthen the concepts before moving to the next JDBC topic.

---

# 👨‍💻 Author

**Jaganmohan Reddy**

100 Days Full Stack Developer Challenge

> Learn → Practice → Build → Debug → Improve → Repeat

**Day 56 — Core Java Strings Completed 🚀**

```
```
