package day58.constructors;

public class ThisWithConstructors_06 {

    private String transactionId;
    private String senderUpi;
    private String receiverUpi;
    private double amount;
    private String paymentMethod;

    public ThisWithConstructors_06(
            String transactionId,
            String senderUpi,
            String receiverUpi,
            double amount,
            String paymentMethod) {

        this.transactionId = transactionId;
        this.senderUpi = senderUpi;
        this.receiverUpi = receiverUpi;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public boolean isValidTransaction() {
        return transactionId != null
                && !transactionId.trim().isEmpty()
                && senderUpi != null
                && receiverUpi != null
                && amount > 0
                && !senderUpi.equalsIgnoreCase(receiverUpi);
    }

    public String getRiskLevel() {

        if (amount >= 100000) {
            return "HIGH";
        }

        if (amount >= 50000) {
            return "MEDIUM";
        }

        return "LOW";
    }

    public void displayTransaction() {
        System.out.println("\n--- UPI Transaction ---");
        System.out.println("Transaction ID : " + this.transactionId);
        System.out.println("Sender UPI     : " + this.senderUpi);
        System.out.println("Receiver UPI   : " + this.receiverUpi);
        System.out.println("Amount         : " + this.amount);
        System.out.println("Payment Method : " + this.paymentMethod);
        System.out.println("Risk Level     : " + getRiskLevel());
        System.out.println("Valid          : " + isValidTransaction());
    }
}