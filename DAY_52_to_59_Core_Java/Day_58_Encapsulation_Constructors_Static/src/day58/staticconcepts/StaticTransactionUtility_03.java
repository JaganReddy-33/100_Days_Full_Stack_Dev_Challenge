package day58.staticconcepts;

public class StaticTransactionUtility_03 {

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static double calculateTransactionFee(double amount) {

        if (amount <= 0) {
            return 0;
        }

        return amount * 0.02;
    }

    public static String normalizePaymentMethod(String paymentMethod) {

        if (paymentMethod == null) {
            return "";
        }

        return paymentMethod.trim().toUpperCase();
    }

    public static boolean isSupportedPaymentMethod(String paymentMethod) {

        String method = normalizePaymentMethod(paymentMethod);

        return method.equals("UPI")
                || method.equals("CARD")
                || method.equals("NET_BANKING")
                || method.equals("WALLET");
    }
}