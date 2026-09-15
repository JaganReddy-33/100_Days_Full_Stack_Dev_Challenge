package day58.staticconcepts;

public class UtilityClassDesign_08 {

    public static boolean isValidTransactionAmount(double amount) {
        return amount > 0;
    }

    public static boolean isValidRiskScore(int riskScore) {
        return riskScore >= 0 && riskScore <= 100;
    }

    public static String normalizePaymentMethod(String paymentMethod) {

        if (paymentMethod == null) {
            return "";
        }

        return paymentMethod.trim().toUpperCase();
    }

    public static String determineRiskLevel(int riskScore) {

        if (!isValidRiskScore(riskScore)) {
            return "INVALID";
        }

        if (riskScore >= 80) {
            return "HIGH";
        }

        if (riskScore >= 50) {
            return "MEDIUM";
        }

        return "LOW";
    }

    public static boolean isSupportedPaymentMethod(String paymentMethod) {

        String method = normalizePaymentMethod(paymentMethod);

        return method.equals("UPI")
                || method.equals("CARD")
                || method.equals("NET_BANKING")
                || method.equals("WALLET");
    }
}