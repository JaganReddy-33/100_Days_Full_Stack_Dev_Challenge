package day57;

public class ParameterOverloading_02 {

    public void calculateSum(int a, int b) {
        int sum = a + b;
        System.out.println("Sum of Two Integers: " + sum);
    }

    public void calculateSum(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println("Sum of Three Integers: " + sum);
    }

    public void calculateSum(int a, int b, int c, int d) {
        int sum = a + b + c + d;
        System.out.println("Sum of Four Integers: " + sum);
    }

    public void calculateSum(double a, double b) {
        double sum = a + b;
        System.out.println("Sum of Two Decimal Numbers: " + sum);
    }

    public void calculateSum(double a, double b, double c) {
        double sum = a + b + c;
        System.out.println("Sum of Three Decimal Numbers: " + sum);
    }

    public void calculateAverage(int a, int b) {
        double average = (a + b) / 2.0;
        System.out.println("Average of Two Integers: " + average);
    }

    public void calculateAverage(int a, int b, int c) {
        double average = (a + b + c) / 3.0;
        System.out.println("Average of Three Integers: " + average);
    }

    public void calculateAverage(double a, double b, double c) {
        double average = (a + b + c) / 3.0;
        System.out.println("Average of Three Decimal Numbers: " + average);
    }

    public void printEmployee(String name) {
        System.out.println("Employee Name: " + name);
    }

    public void printEmployee(String name, int age) {
        System.out.println("Employee Name: " + name + " | Age: " + age);
    }

    public void printEmployee(String name, int age, double salary) {
        System.out.println("Employee Name: " + name
                + " | Age: " + age
                + " | Salary: " + salary);
    }

    public void calculateSalary(double basicSalary) {
        System.out.println("Basic Salary: " + basicSalary);
    }

    public void calculateSalary(double basicSalary, double allowance) {
        double totalSalary = basicSalary + allowance;
        System.out.println("Total Salary: " + totalSalary);
    }

    public void calculateSalary(double basicSalary, double allowance, double bonus) {
        double totalSalary = basicSalary + allowance + bonus;
        System.out.println("Total Salary: " + totalSalary);
    }

    public void displayProduct(String productName) {
        System.out.println("Product Name: " + productName);
    }

    public void displayProduct(String productName, double price) {
        System.out.println("Product Name: " + productName
                + " | Price: " + price);
    }

    public void displayProduct(String productName, double price, int quantity) {
        double totalPrice = price * quantity;

        System.out.println("Product Name: " + productName
                + " | Price: " + price
                + " | Quantity: " + quantity
                + " | Total: " + totalPrice);
    }
}