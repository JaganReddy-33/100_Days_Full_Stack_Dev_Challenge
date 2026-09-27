package day60.problems;

import java.util.Scanner;

class PaymentMethod {

    public void processPayment(double amount) {
        System.out.println("Processing general payment of ₹" + amount);
    }
}

class UPI extends PaymentMethod {

    private double totalBalance = 0;

    @Override
    public void processPayment(double amount) {
        totalBalance += amount;
        System.out.println("UPI Payment: ₹" + amount);
        System.out.println("Your total UPI Balance: ₹" + totalBalance);
    }
}

class CreditCard extends PaymentMethod {

    private double totalBalance = 0;

    @Override
    public void processPayment(double amount) {
        totalBalance += amount;
        System.out.println("Credit Card Payment: ₹" + amount);
        System.out.println("Your total Credit Card Balance: ₹" + totalBalance);
    }
}

class NetBanking extends PaymentMethod {

    private double totalBalance = 0;

    @Override
    public void processPayment(double amount) {
        totalBalance += amount;
        System.out.println("Net Banking Payment: ₹" + amount);
        System.out.println("Your total Net Banking Balance: ₹" + totalBalance);
    }
}

public class UPIPaymentGateway {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Payment Method (UPI/CreditCard/NetBanking): ");
        String paymentMethodType = sc.nextLine();

        System.out.println("Enter Amount:");
        double amount = sc.nextDouble();

        PaymentMethod paymentMethod = null;

        if (paymentMethodType.equalsIgnoreCase("UPI")) {
            paymentMethod = new UPI();

        } else if (paymentMethodType.equalsIgnoreCase("CreditCard")) {
            paymentMethod = new CreditCard();

        } else if (paymentMethodType.equalsIgnoreCase("NetBanking")) {
            paymentMethod = new NetBanking();

        } else {
            System.out.println("Invalid Payment Method!");
            return;
        }

        paymentMethod.processPayment(amount);
    }
}