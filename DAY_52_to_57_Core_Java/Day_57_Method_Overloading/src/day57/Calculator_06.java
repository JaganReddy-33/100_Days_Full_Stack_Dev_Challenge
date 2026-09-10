package day57;

public class Calculator_06 {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b, double c) {
        return a + b + c;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public int multiply(int price, int quantity, int discount) {
        int total = price * quantity;
        return total - discount;
    }

    public double calculatePercentage(double amount, double percentage) {
        return amount * percentage / 100;
    }

    public double calculatePercentage(int amount, int percentage) {
        return (double) amount * percentage / 100;
    }

    public double calculateAverage(int a, int b) {
        return (a + b) / 2.0;
    }

    public double calculateAverage(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    public double calculateAverage(double a, double b) {
        return (a + b) / 2;
    }

    public double calculateAverage(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public double calculateEMI(double principal, double annualRate, int months) {
        double monthlyRate = annualRate / (12 * 100);

        return (principal * monthlyRate * Math.pow(1 + monthlyRate, months))
                / (Math.pow(1 + monthlyRate, months) - 1);
    }

    public double calculateDiscount(double price, int percentage) {
        return price - (price * percentage / 100);
    }

    public double calculateDiscount(double price, double percentage) {
        return price - (price * percentage / 100);
    }

    public double calculateDiscount(double price, double percentage, double couponDiscount) {
        double discountedPrice = price - (price * percentage / 100);
        return discountedPrice - couponDiscount;
    }
}