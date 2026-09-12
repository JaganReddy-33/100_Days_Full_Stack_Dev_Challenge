package day58.encapsulation;

public class EncapsulationProblems_04 {

    private long accountNumber;
    private String accountHolder;
    private double balance;

    public void setAccountNumber(long accountNumber) {
        if (accountNumber <= 0) {
            System.out.println("Account Number must be positive!");
            return;
        }

        this.accountNumber = accountNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            System.out.println("Account Holder name cannot be empty!");
            return;
        }

        this.accountHolder = accountHolder;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0!");
            return;
        }

        balance += amount;
        System.out.println("Amount deposited successfully: " + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= amount;
        System.out.println("Amount withdrawn successfully: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void displayAccountDetails() {
        System.out.println("\n--- Bank Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : " + balance);
    }
}