package day58.staticconcepts;

public class ObjectInitializationOrder_10 {

    private static String systemName = "UPI Risk Engine";

    private String transactionType = "UPI";

    static {
        System.out.println("1. Static block executed");
    }

    {
        System.out.println("3. Instance initialization block executed");
    }

    public ObjectInitializationOrder_10() {
        System.out.println("4. Constructor executed");
    }

    public static void showSystemName() {
        System.out.println("System: " + systemName);
    }

    public void showTransactionType() {
        System.out.println("Transaction Type: " + transactionType);
    }
}