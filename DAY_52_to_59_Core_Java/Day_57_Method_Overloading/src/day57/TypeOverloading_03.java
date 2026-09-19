package day57;

public class TypeOverloading_03 {

    public void calculateInterest(double principal, int years) {
        double rate = 7.5;
        double interest = (principal * rate * years) / 100;

        System.out.println("Principal: " + principal);
        System.out.println("Years: " + years);
        System.out.println("Interest: " + interest);
    }

    public void calculateInterest(double principal, double rate) {
        double interest = (principal * rate) / 100;

        System.out.println("Principal: " + principal);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Interest: " + interest);
    }

    public void calculateInterest(int principal, int years) {
        double rate = 7.5;
        double interest = (principal * rate * years) / 100;

        System.out.println("Principal: " + principal);
        System.out.println("Years: " + years);
        System.out.println("Interest: " + interest);
    }

    public void calculateBill(int units) {
        double billAmount = units * 5.0;

        System.out.println("Units Consumed: " + units);
        System.out.println("Electricity Bill: " + billAmount);
    }

    public void calculateBill(double units) {
        double billAmount = units * 5.0;

        System.out.println("Units Consumed: " + units);
        System.out.println("Electricity Bill: " + billAmount);
    }

    public void calculateDiscount(double price, int percentage) {
        double discount = price * percentage / 100;
        double finalPrice = price - discount;

        System.out.println("Original Price: " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
    }

    public void calculateDiscount(double price, double percentage) {
        double discount = price * percentage / 100;
        double finalPrice = price - discount;

        System.out.println("Original Price: " + price);
        System.out.println("Discount: " + discount);
        System.out.println("Final Price: " + finalPrice);
    }

    public void processPayment(int amount) {
        System.out.println("Processing cash payment of ₹" + amount);
        System.out.println("Payment completed successfully.");
    }

    public void processPayment(double amount) {
        System.out.println("Processing digital payment of ₹" + amount);
        System.out.println("Payment completed successfully.");
    }

    public void processPayment(String transactionId) {
        System.out.println("Processing payment using transaction ID: " + transactionId);
        System.out.println("Transaction verified successfully.");
    }

    public void createUser(String username, int age) {
        System.out.println("Creating user account...");
        System.out.println("Username: " + username);
        System.out.println("Age: " + age);
        System.out.println("User account created successfully.");
    }

    public void createUser(String username, double age) {
        System.out.println("Creating user account...");
        System.out.println("Username: " + username);
        System.out.println("Age: " + age);
        System.out.println("User account created successfully.");
    }

    public void searchProduct(int productId) {
        System.out.println("Searching product using Product ID: " + productId);
    }

    public void searchProduct(String productName) {
        System.out.println("Searching product using Product Name: " + productName);
    }

    public void searchProduct(double productPrice) {
        System.out.println("Searching products with price: ₹" + productPrice);
    }
}