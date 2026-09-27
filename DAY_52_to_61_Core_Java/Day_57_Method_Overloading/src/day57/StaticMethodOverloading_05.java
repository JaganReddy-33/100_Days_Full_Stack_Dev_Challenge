package day57;

public class StaticMethodOverloading_05 {

    public static void calculateTax(double salary) {
        double tax = salary * 0.10;

        System.out.println("Annual Salary: ₹" + salary);
        System.out.println("Estimated Tax: ₹" + tax);
    }

    public static void calculateTax(double salary, double taxRate) {
        double tax = salary * taxRate / 100;

        System.out.println("Annual Salary: ₹" + salary);
        System.out.println("Tax Rate: " + taxRate + "%");
        System.out.println("Calculated Tax: ₹" + tax);
    }

    public static void calculateTax(double salary, double taxRate, double deduction) {
        double taxableIncome = salary - deduction;
        double tax = taxableIncome * taxRate / 100;

        System.out.println("Annual Salary: ₹" + salary);
        System.out.println("Deduction: ₹" + deduction);
        System.out.println("Taxable Income: ₹" + taxableIncome);
        System.out.println("Calculated Tax: ₹" + tax);
    }

    public static void generateInvoice(String customerName, double amount) {
        System.out.println("Customer: " + customerName);
        System.out.println("Invoice Amount: ₹" + amount);
    }

    public static void generateInvoice(int invoiceNumber, double amount) {
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Invoice Amount: ₹" + amount);
    }

    public static void generateInvoice(String customerName, int invoiceNumber, double amount) {
        System.out.println("Customer: " + customerName);
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.println("Invoice Amount: ₹" + amount);
    }

    public static void calculateShipping(double weight) {
        double shippingCharge = weight * 50;

        System.out.println("Package Weight: " + weight + " kg");
        System.out.println("Shipping Charge: ₹" + shippingCharge);
    }

    public static void calculateShipping(double weight, double distance) {
        double shippingCharge = weight * distance * 2;

        System.out.println("Package Weight: " + weight + " kg");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Shipping Charge: ₹" + shippingCharge);
    }

    public static void calculateShipping(double weight, double distance, boolean express) {
        double shippingCharge = weight * distance * 2;

        if (express) {
            shippingCharge += 500;
        }

        System.out.println("Package Weight: " + weight + " kg");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Express Delivery: " + express);
        System.out.println("Shipping Charge: ₹" + shippingCharge);
    }

    public static void convertCurrency(double amount) {
        double convertedAmount = amount * 83.0;

        System.out.println("Amount in USD: $" + amount);
        System.out.println("Amount in INR: ₹" + convertedAmount);
    }

    public static void convertCurrency(double amount, double exchangeRate) {
        double convertedAmount = amount * exchangeRate;

        System.out.println("Original Amount: " + amount);
        System.out.println("Exchange Rate: " + exchangeRate);
        System.out.println("Converted Amount: " + convertedAmount);
    }
}