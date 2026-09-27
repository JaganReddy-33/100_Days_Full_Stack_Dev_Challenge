package day57;

public class MethodOverloadingBasics_01 {

    public void display() {
        System.out.println("Hello! Welcome to Day 57 Method Overloading Practice.");
    }

    public void display(String name) {
        System.out.println("Hello, " + name + "! Welcome to Java.");
    }

    public void display(String name, int rollNumber) {
        System.out.println("Hello, " + name + "! Your roll number is " + rollNumber + ".");
    }

    public void showNumber(int number) {
        System.out.println("Your lucky number is: " + number);
    }

    public void showNumber(double number) {
        System.out.println("Your lucky decimal number is: " + number);
    }

    public void showNumber(String number) {
        System.out.println("Your lucky number is: " + number);
    }

    public void printDetails(String name) {
        System.out.println("Name: " + name);
    }

    public void printDetails(String name, int age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void printDetails(String name, int age, double salary) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }

    public void calculate(int a, int b) {
        int result = a + b;
        System.out.println("Sum of two numbers: " + result);
    }

    public void calculate(int a, int b, int c) {
        int result = a + b + c;
        System.out.println("Sum of three numbers: " + result);
    }

    public void calculate(double a, double b) {
        double result = a + b;
        System.out.println("Sum of two decimal numbers: " + result);
    }
}