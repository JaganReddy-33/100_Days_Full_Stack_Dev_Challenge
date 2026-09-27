package day61.abstraction;

import java.util.Scanner;

abstract class BankAccount {
    private int accNumber;
    private String accHolder;
    private double balance;

    public BankAccount(int accNumber, String accHolder, double balance) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accNumber);
        System.out.println("Account Holder: " + accHolder);
        System.out.printf("Balance: %.2f%n", balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(int accNumber, String accHolder, double balance) {
        super(accNumber, accHolder, balance);
    }

    @Override
    void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.printf("Deposited: %.2f | New Balance: %.2f%n", amount, getBalance());
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    @Override
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.printf("Withdrawal successful. New Balance: %.2f%n", getBalance());
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(int accNumber, String accHolder, double balance, double overdraftLimit) {
        super(accNumber, accHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void deposit(double amount) {
        if (amount > 0) {
            setBalance(getBalance() + amount);
            System.out.printf("Deposited: %.2f | New Balance: %.2f%n", amount, getBalance());
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    @Override
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount <= getBalance() + overdraftLimit) {
            setBalance(getBalance() - amount);
            System.out.printf("Withdrawal successful. Balance: %.2f%n", getBalance());
        } else {
            System.out.println("Withdrawal exceeds overdraft limit!");
        }
    }
}

public class BankAccountSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account type (Savings/Current): ");
        String accType = sc.nextLine();

        System.out.print("Enter account number: ");
        int accNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter account holder name: ");
        String accHolder = sc.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();

        BankAccount account = null;

        if (accType.equalsIgnoreCase("Savings")) {
            account = new SavingsAccount(accNumber, accHolder, balance);
        } else if (accType.equalsIgnoreCase("Current")) {
            System.out.print("Enter overdraft limit: ");
            double overdraftLimit = sc.nextDouble();
            account = new CurrentAccount(accNumber, accHolder, balance, overdraftLimit);
        } else {
            System.out.println("Invalid account type!");
            sc.close();
            return;
        }

        System.out.println("\n--- Initial Account Details ---");
        account.displayAccountDetails();

        System.out.print("\nEnter amount to deposit: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

        System.out.println("\n--- Final Account Details ---");
        account.displayAccountDetails();

        sc.close();
    }
}