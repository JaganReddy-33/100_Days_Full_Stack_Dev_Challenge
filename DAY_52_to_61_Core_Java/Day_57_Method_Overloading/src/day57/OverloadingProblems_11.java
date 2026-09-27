package day57;

public class OverloadingProblems_11 {

    public void display(int value) {

        System.out.println("Integer value: " + value);
    }

    public void display(double value) {

        System.out.println("Double value: " + value);
    }

    public void display(String value) {

        System.out.println("String value: " + value);
    }

    public void display(int value, String text) {

        System.out.println("Integer: " + value);
        System.out.println("Text: " + text);
    }

    public void display(String text, int value) {

        System.out.println("Text: " + text);
        System.out.println("Integer: " + value);
    }

    public void calculate(int a, int b) {

        System.out.println("Integer Sum: " + (a + b));
    }

    public void calculate(double a, double b) {

        System.out.println("Double Sum: " + (a + b));
    }

    public void calculate(int a, double b) {

        System.out.println("Mixed Sum: " + (a + b));
    }

    public void calculate(double a, int b) {

        System.out.println("Mixed Sum: " + (a + b));
    }

    public void print(String text) {

        System.out.println("Text: " + text);
    }

    public void print(String text, int count) {

        for (int i = 1; i <= count; i++) {
            System.out.println(text);
        }
    }

    public void print(int number, String message) {

        System.out.println(message + ": " + number);
    }

    public void convert(int value) {

        double result = value;

        System.out.println("Integer to Double: " + result);
    }

    public void convert(double value) {

        int result = (int) value;

        System.out.println("Double to Integer: " + result);
    }

    public void convert(String value) {

        System.out.println("String value: " + value);
    }
}