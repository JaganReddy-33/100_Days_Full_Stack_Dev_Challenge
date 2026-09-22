package day58.staticconcepts;

public class StaticWithConstructors_06 {

    private int paymentId;
    private double amount;
    private String paymentMethod;

    private static int totalPayments;

    public StaticWithConstructors_06(int paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;

        totalPayments++;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public static int getTotalPayments() {
        return totalPayments;
    }

    public String getPaymentDetails() {
        return "Payment ID: " + paymentId
                + ", Amount: ₹" + amount
                + ", Method: " + paymentMethod;
    }
}