package day61.interfaces;

import java.util.Scanner;

interface PaymentGateway {

    void processPayment(double amount);

    void refundPayment(double amount);
}

class UPI implements PaymentGateway {

    public void processPayment(double amount) {
        System.out.println("UPI payment processed: ₹" + amount);
    }

    public void refundPayment(double amount) {
        System.out.println("UPI refund initiated: ₹" + amount);
    }
}

class CreditCard implements PaymentGateway {

    public void processPayment(double amount) {
        System.out.println("Credit Card payment processed: ₹" + amount);
    }

    public void refundPayment(double amount) {
        System.out.println("Credit Card refund initiated: ₹" + amount);
    }
}

class NetBanking implements PaymentGateway {

    public void processPayment(double amount) {
        System.out.println("Net Banking payment processed: ₹" + amount);
    }

    public void refundPayment(double amount) {
        System.out.println("Net Banking refund initiated: ₹" + amount);
    }
}

public class PaymentGatewaySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter payment amount: ");
        double amount = sc.nextDouble();

        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Net Banking");

        System.out.print("Choose payment method: ");
        int choice = sc.nextInt();

        PaymentGateway paymentGateway;

        if (choice == 1) {
            paymentGateway = new UPI();
        } else if (choice == 2) {
            paymentGateway = new CreditCard();
        } else if (choice == 3) {
            paymentGateway = new NetBanking();
        } else {
            System.out.println("Invalid payment method");
            sc.close();
            return;
        }

        paymentGateway.processPayment(amount);

        System.out.print("Enter refund amount: ");
        double refund = sc.nextDouble();

        paymentGateway.refundPayment(refund);

        sc.close();
    }
}