package day58.staticconcepts;

public class StaticPaymentConfig_02 {

    private static double maxTransactionAmount = 100000.00;
    private static int maxDailyTransactionCount = 20;
    private static double minTransactionAmount = 1.00;

    public static void setPaymentLimits(double maxAmount, int maxDailyCount, double minAmount) {
        maxTransactionAmount = maxAmount;
        maxDailyTransactionCount = maxDailyCount;
        minTransactionAmount = minAmount;
    }

    public static double getMaxTransactionAmount() {
        return maxTransactionAmount;
    }

    public static int getMaxDailyTransactionCount() {
        return maxDailyTransactionCount;
    }

    public static double getMinTransactionAmount() {
        return minTransactionAmount;
    }

    public static boolean isAmountWithinLimit(double amount) {
        return amount >= minTransactionAmount
                && amount <= maxTransactionAmount;
    }
}