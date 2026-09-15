package day58.staticconcepts;

public class StaticMistakes_09 {

    private int accountId;
    private String accountHolder;
    private double balance;

    private static int accountCount;

    public StaticMistakes_09(int accountId, String accountHolder, double balance) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;

        accountCount++;
    }

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountDetails() {
        return "Account ID: " + accountId
                + ", Holder: " + accountHolder
                + ", Balance: ₹" + balance;
    }

    public static int getAccountCount() {
        return accountCount;
    }

    public static boolean isValidAccountId(int accountId) {
        return accountId > 0;
    }

    public static boolean isValidDepositAmount(double amount) {
        return amount > 0;
    }
}