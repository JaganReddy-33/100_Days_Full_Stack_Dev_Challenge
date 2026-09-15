package day58.staticconcepts;

public class StaticTransactionCounter_01 {

    private int transactionId;
    private double amount;

    private static int totalTransactions;

    public void setTransactionDetails(int transactionId, double amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public void incrementTransactionCount() {
        totalTransactions++;
    }

    public static int getTotalTransactions() {
        return totalTransactions;
    }

    public String getTransactionDetails() {
        return "Transaction ID: " + transactionId
                + ", Amount: ₹" + amount;
    }
}