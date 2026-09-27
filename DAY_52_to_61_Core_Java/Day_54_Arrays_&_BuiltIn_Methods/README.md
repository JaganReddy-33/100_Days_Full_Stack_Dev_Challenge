
````markdown
# 🚀 Day 54 — Core Java: Arrays

> **100 Days Full Stack Developer Challenge**
>
> **Day 54 Focus:** Core Java — Arrays, Array Logic, Utility Methods & Arrays with Methods

---

## 📅 Day 54 Overview

Day 54 focused on mastering **Arrays in Core Java** from the fundamentals to practical and interview-oriented problem solving.

The goal was not only to understand how arrays work, but also to learn how to:

- Declare and initialize arrays
- Access and update array elements
- Traverse arrays using different loops
- Solve common array problems
- Find duplicates and frequencies
- Remove duplicates
- Find missing numbers
- Merge and compare arrays
- Work with the `java.util.Arrays` utility class
- Pass arrays to methods
- Modify arrays through methods
- Return arrays from methods
- Build reusable array operations

---

# 📚 Topics Covered

## 1. Array Basics

### Concepts Practiced

- What is an Array?
- Why arrays are used
- Characteristics of arrays
- Fixed-size nature of arrays
- Zero-based indexing
- Homogeneous data
- Array memory concept
- Array declaration
- Array initialization
- `new` keyword with arrays
- Declaration and initialization together
- Default values
- `.length` property
- Primitive arrays
- String arrays

### File

```text
ArrayBasics.java
````

### Methods Practiced

```text
arrayIntroduction()
arrayDeclaration()
arrayInitializationUsingNew()
arrayDeclarationAndInitialization()
arrayFixedSize()
arrayZeroBasedIndexing()
arrayLength()
arrayDefaultValues()
differentPrimitiveArrays()
stringArrayExample()
arrayUpdateExample()
arrayIndexExample()
arrayMemoryConcept()
arrayLengthWithDifferentSizes()
```

---

# 2. Accessing & Updating Arrays

The next section focused on accessing individual elements and modifying existing values.

### Concepts Practiced

* Reading array elements
* Accessing elements using indexes
* Updating elements
* First element
* Last element
* Index-based access
* Invalid indexes
* `ArrayIndexOutOfBoundsException`
* Different array data types

### File

```text
ArrayAccess.java
```

### Methods Practiced

```text
readArrayElements()
updateArrayElements()
accessFirstLastElements()
accessUsingIndex()
handleInvalidIndex()
accessDifferentArrayTypes()
```

---

# 3. Array Traversal

Arrays were traversed using different looping mechanisms.

### Concepts Practiced

* `for` loop
* `while` loop
* Enhanced `for-each` loop
* String array traversal
* Traversing and updating array elements

### File

```text
ArrayTraversal.java
```

### Methods Practiced

```text
traverseUsingForLoop()
traverseUsingWhileLoop()
traverseUsingForEach()
traverseStringArray()
traverseAndUpdateArray()
```

---

# 4. Basic 1D Array Programs

After learning the fundamentals, practical array programs were implemented.

### Programs Covered

* Print array elements
* Find sum
* Calculate average
* Find maximum
* Find minimum
* Count even elements
* Count odd elements
* Count positive elements
* Count negative elements
* Count zero values
* Count a particular element
* Search for an element
* Reverse an array
* Copy an array
* Display array information

### File

```text
BasicArrayPrograms.java
```

### Methods Practiced

```text
printArrayInformation()
basicCalculations()
countElements()
searchElements()
reverseArray()
copyArray()
```

---

# 5. Array Problem Solving

This section moved from basic operations into more practical and interview-oriented array problems.

### Problems Covered

### Second Largest & Second Smallest

* Find largest element
* Find second largest element
* Find smallest element
* Find second smallest element
* Handle duplicate values

### Duplicates & Frequency

* Find duplicate elements
* Count frequency of elements
* Display frequency of each element

### Remove Duplicates

* Identify repeated values
* Create an array containing unique elements

### Missing Number

* Calculate expected sum
* Calculate actual sum
* Find the missing number using the difference

### Common Elements & Merge

* Find common elements between two arrays
* Merge two arrays into a single array

### Even/Odd Separation

* Separate even elements
* Separate odd elements
* Store the results in another array

### Move Zeros

* Move all zero values toward the end
* Preserve the non-zero elements

### Compare Arrays

* Compare array lengths
* Compare corresponding elements
* Determine whether two arrays contain the same values

### File

```text
ArrayProblemSolving.java
```

### Methods Practiced

```text
findSecondLargestAndSmallest()
findDuplicatesAndFrequency()
removeDuplicates()
findMissingNumber()
findCommonElementsAndMerge()
separateEvenOddAndMoveZeros()
compareArrays()
```

---

# 6. `java.util.Arrays` Utility Class

The next section introduced the standard Java `Arrays` utility class.

### Utility Methods Practiced

### `Arrays.toString()`

Used to display array contents in a readable format.

```java
Arrays.toString(numbers);
```

### `Arrays.equals()`

Used to compare two arrays.

```java
Arrays.equals(first, second);
```

### `Arrays.sort()`

Used to sort array elements.

```java
Arrays.sort(numbers);
```

### `Arrays.binarySearch()`

Used to search for an element in a sorted array.

```java
Arrays.binarySearch(numbers, target);
```

### `Arrays.copyOf()`

Used to create a copy of an array with a specified length.

```java
Arrays.copyOf(numbers, length);
```

### `Arrays.copyOfRange()`

Used to copy a specific range of an array.

```java
Arrays.copyOfRange(numbers, start, end);
```

### `Arrays.fill()`

Used to fill an entire array or a specific range with a value.

```java
Arrays.fill(numbers, value);
```

### File

```text
ArraysUtility.java
```

### Methods Practiced

```text
displayAndCompareArrays()
sortAndSearchArray()
copyArrays()
fillArrays()
utilityWorkflow()
```

---

# 7. Arrays with Methods

The final Arrays section focused on combining **arrays and methods** to create reusable Java code.

### Concepts Practiced

* Passing arrays to methods
* Reading arrays inside methods
* Calculating values using array parameters
* Modifying arrays through methods
* Returning arrays from methods
* Passing multiple arrays
* Merging arrays through methods
* Reusable array operations
* Returning calculated values from array-processing methods

### File

```text
ArraysWithMethods.java
```

### Methods Practiced

```text
passArrayToMethod()
modifyArrayThroughMethod()
returnArrayFromMethod()
processMultipleArrays()
reusableArrayOperations()
```

Additional reusable private methods were created for:

```text
printArray()
calculateSum()
modifyElements()
reverseArray()
mergeArrays()
findMaximum()
findMinimum()
calculateAverage()
searchElement()
```

---

# 🧠 Key Concepts Learned

By completing the Arrays section, I practiced the complete flow:

```text
Array Declaration
        ↓
Array Initialization
        ↓
Array Access
        ↓
Array Updating
        ↓
Array Traversal
        ↓
Basic Array Operations
        ↓
Array Problem Solving
        ↓
java.util.Arrays
        ↓
Arrays + Methods
        ↓
Reusable Array Logic
```

---

# 💡 Important Java Concepts Reinforced

### Zero-Based Indexing

Array indexes start from:

```text
0
```

Therefore, for an array of length `n`, the last valid index is:

```text
n - 1
```

---

### Fixed Size

Once an array is created, its size cannot be changed.

```java
int[] numbers = new int[5];
```

The array will always contain exactly 5 positions.

---

### `.length`

The number of elements can be obtained using:

```java
numbers.length
```

---

### Enhanced For Loop

The enhanced `for` loop provides a convenient way to traverse arrays.

```java
for (int number : numbers) {
    System.out.println(number);
}
```

---

### Array Parameters

Arrays can be passed directly to methods.

```java
calculateSum(numbers);
```

---

### Returning Arrays

Methods can return arrays.

```java
int[] result = reverseArray(numbers);
```

---

### Array Modification Through Methods

When an array is passed to a method, the method can modify its elements.

This is important when designing reusable array-processing methods.

---

# 🛠️ Practical Skills Developed

During Day 54, I practiced:

* Writing reusable Java methods
* Working with array indexes
* Using loops with arrays
* Processing arrays without relying entirely on library methods
* Handling invalid indexes
* Comparing arrays
* Searching arrays
* Sorting arrays
* Copying arrays
* Removing duplicates
* Finding frequencies
* Solving missing-number problems
* Merging arrays
* Separating values based on conditions
* Moving zeros
* Returning arrays from methods

---

# 📁 Day 54 Core Java Structure

```text
DAY_54
│
└── src
    │
    └── day54
        │
        ├── ArrayBasics.java
        ├── ArrayAccess.java
        ├── ArrayTraversal.java
        ├── BasicArrayPrograms.java
        ├── ArrayProblemSolving.java
        ├── ArraysUtility.java
        └── ArraysWithMethods.java
```

---

# 🎯 Day 54 Learning Progress

| Topic                        | Status      |
| ---------------------------- | ----------- |
| Array Introduction           | ✅ Completed |
| Declaration & Initialization | ✅ Completed |
| Accessing & Updating         | ✅ Completed |
| Array Traversal              | ✅ Completed |
| Basic 1D Programs            | ✅ Completed |
| Array Problem Solving        | ✅ Completed |
| `java.util.Arrays`           | ✅ Completed |
| Arrays with Methods          | ✅ Completed |

---

# 🔥 Day 54 Achievement

> **Core Java Arrays — Completed**

I progressed from understanding basic array syntax to implementing practical array-processing logic and reusable methods.

The most important progression was:

```text
Syntax → Understanding → Implementation → Problem Solving → Reusability
```

---

# 📌 Next Learning Goal

After completing the Core Java Arrays section, the next planned backend topic is:

## JDBC — Batch Processing

Upcoming concepts:

```text
Batch Processing Fundamentals
        ↓
Statement Batch
        ↓
PreparedStatement Batch
        ↓
Batch INSERT
        ↓
Batch UPDATE
        ↓
Batch DELETE
        ↓
Batch Update Counts
        ↓
BatchUpdateException
        ↓
Try-With-Resources
        ↓
Real-World Bulk Operations
        ↓
Practical JDBC Problems
```

---

# 💻 Tech Stack

* Java
* Core Java
* Eclipse IDE
* JDBC
* MySQL

---

# 🚀 100 Days Full Stack Developer Challenge

**Current Phase:**

```text
Frontend
   ↓
SQL
   ↓
React
   ↓
Tailwind CSS
   ↓
Core Java
   ↓
JDBC
   ↓
Backend Development
```

**Day 54 — Arrays ✅**

---

## 👨‍💻 Author

**Ragipalyam Jaganmohan Reddy**

Aspiring Full Stack Developer
Java Backend + MERN Stack


````

### Git commands for Day 54

```bash
git add .
git commit -m "Day 54: Core Java Arrays"
git push origin main
````

