package day58.staticconcepts;

public class InstanceVsStatic_05 {

    private int paymentId;
    private double amount;
    private String paymentMethod;
    private String status;

    private static int totalPayments;

    public void setPaymentDetails(int paymentId, double amount,
                                  String paymentMethod, String status) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public void registerPayment() {
        totalPayments++;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getPaymentDetails() {
        return "Payment ID: " + paymentId
                + ", Amount: ₹" + amount
                + ", Method: " + paymentMethod
                + ", Status: " + status;
    }

    public static int getTotalPayments() {
        return totalPayments;
    }
}