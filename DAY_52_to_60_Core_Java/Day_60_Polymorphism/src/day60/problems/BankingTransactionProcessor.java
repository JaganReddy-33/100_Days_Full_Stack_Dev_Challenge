package day60.problems;

import java.util.Scanner;

class BankTransaction {

    protected double amount;

    public BankTransaction(double amount) {
        this.amount = amount;
    }

    public void processTransaction() {
        System.out.println("Processing general banking transaction.");
    }

    public double calculateFee() {
        return 0;
    }
}

class Deposit extends BankTransaction {

    public Deposit(double amount) {
        super(amount);
    }

    @Override
    public void processTransaction() {
        System.out.println("Deposit of ₹" + amount + " processed successfully.");
    }

    @Override
    public double calculateFee() {
        return 0;
    }
}

class Withdrawal extends BankTransaction {

    public Withdrawal(double amount) {
        super(amount);
    }

    @Override
    public void processTransaction() {
        System.out.println("Withdrawal of ₹" + amount + " processed successfully.");
    }

    @Override
    public double calculateFee() {
        return amount * 0.02;
    }
}

class Transfer extends BankTransaction {

    public Transfer(double amount) {
        super(amount);
    }

    @Override
    public void processTransaction() {
        System.out.println("Bank Transfer of ₹" + amount + " processed successfully.");
    }

    @Override
    public double calculateFee() {
        return 25;
    }
}

class BillPayment extends BankTransaction {

    public BillPayment(double amount) {
        super(amount);
    }

    @Override
    public void processTransaction() {
        System.out.println("Bill Payment of ₹" + amount + " processed successfully.");
    }

    @Override
    public double calculateFee() {
        return 10;
    }
}

public class BankingTransactionProcessor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select Transaction Type:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdrawal");
        System.out.println("3. Transfer");
        System.out.println("4. Bill Payment");

        int choice = sc.nextInt();

        System.out.println("Enter Transaction Amount:");
        double amount = sc.nextDouble();

        BankTransaction transaction;

        if (choice == 1) {
            transaction = new Deposit(amount);
        } else if (choice == 2) {
            transaction = new Withdrawal(amount);
        } else if (choice == 3) {
            transaction = new Transfer(amount);
        } else if (choice == 4) {
            transaction = new BillPayment(amount);
        } else {
            System.out.println("Invalid Transaction Type!");
            sc.close();
            return;
        }

        transaction.processTransaction();

        double fee = transaction.calculateFee();

        System.out.println("Transaction Fee: ₹" + fee);
        System.out.println("Total Amount: ₹" + (amount + fee));
    }
}