package day60.problems;


import java.util.Scanner;

class Order {

    protected double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public void addProduct(String productName) {
        System.out.println("Product Added: " + productName);
    }

    public void addProduct(String productName, int quantity) {
        System.out.println("Product Added: " + productName + " | Quantity: " + quantity);
    }

    public double calculateFinalAmount() {
        return amount;
    }
}

class RegularOrder extends Order {

    public RegularOrder(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount;
    }
}

class PremiumOrder extends Order {

    public PremiumOrder(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount - (amount * 0.10);
    }
}

class InternationalOrder extends Order {

    public InternationalOrder(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        double internationalCharge = amount * 0.15;
        return amount + internationalCharge;
    }
}

public class ECommerceOrderPricing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Order Type:");
        System.out.println("1. Regular");
        System.out.println("2. Premium");
        System.out.println("3. International");

        int choice = sc.nextInt();

        System.out.println("Enter Order Amount:");
        double amount = sc.nextDouble();

        Order order;

        if (choice == 1) {
            order = new RegularOrder(amount);
        } else if (choice == 2) {
            order = new PremiumOrder(amount);
        } else if (choice == 3) {
            order = new InternationalOrder(amount);
        } else {
            System.out.println("Invalid Order Type!");
            return;
        }

        System.out.println("Enter Product Name:");
        sc.nextLine();
        String productName = sc.nextLine();

        System.out.println("Enter Quantity:");
        int quantity = sc.nextInt();

        order.addProduct(productName, quantity);

        System.out.println("Final Order Amount: ₹" + order.calculateFinalAmount());
    }
}