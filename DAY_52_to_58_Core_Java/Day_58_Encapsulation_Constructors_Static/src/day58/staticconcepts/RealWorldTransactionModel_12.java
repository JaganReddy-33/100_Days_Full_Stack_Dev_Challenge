package day58.staticconcepts;

public class RealWorldTransactionModel_12 {

    private int transactionId;
    private String senderUpi;
    private String receiverUpi;
    private double amount;
    private String status;

    private static int totalTransactions;

    public static final String PENDING = "PENDING";
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    public RealWorldTransactionModel_12(int transactionId,
                                        String senderUpi,
                                        String receiverUpi,
                                        double amount) {

        this.transactionId = transactionId;
        this.senderUpi = senderUpi;
        this.receiverUpi = receiverUpi;
        this.amount = amount;
        this.status = PENDING;

        totalTransactions++;
    }

    public boolean isValidTransaction() {

        return amount > 0
                && senderUpi != null
                && !senderUpi.trim().isEmpty()
                && receiverUpi != null
                && !receiverUpi.trim().isEmpty()
                && !senderUpi.equalsIgnoreCase(receiverUpi);
    }

    public void markSuccessful() {

        if (isValidTransaction()) {
            status = SUCCESS;
        }
    }

    public void markFailed() {
        status = FAILED;
    }

    public String getTransactionDetails() {

        return "Transaction ID: " + transactionId
                + ", Sender: " + senderUpi
                + ", Receiver: " + receiverUpi
                + ", Amount: ₹" + amount
                + ", Status: " + status;
    }

    public static int getTotalTransactions() {
        return totalTransactions;
    }

    public static boolean isValidStatus(String status) {

        if (status == null) {
            return false;
        }

        return status.equals(PENDING)
                || status.equals(SUCCESS)
                || status.equals(FAILED);
    }
}