package day58.staticconcepts;

public class InitializationBlocks_11 {

    private static String systemName;
    private static int systemVersion;

    private int transactionId;
    private String paymentMethod;

    static {
        systemName = "UPI Payment Risk System";
        systemVersion = 1;

        System.out.println("Static block executed");
    }

    {
        transactionId = 0;
        paymentMethod = "UNKNOWN";

        System.out.println("Instance block executed");
    }

    public InitializationBlocks_11(int transactionId, String paymentMethod) {
        this.transactionId = transactionId;
        this.paymentMethod = paymentMethod;

        System.out.println("Constructor executed");
    }

    public static String getSystemName() {
        return systemName;
    }

    public static int getSystemVersion() {
        return systemVersion;
    }

    public String getTransactionDetails() {
        return "Transaction ID: " + transactionId
                + ", Payment Method: " + paymentMethod;
    }
}