package day58.staticconcepts;

public class StaticInitialization_04 {

    private static String systemName;
    private static int riskThreshold;
    private static boolean fraudDetectionEnabled;

    static {
        systemName = "UPI Fraud Detection System";
        riskThreshold = 70;
        fraudDetectionEnabled = true;
    }

    public static String getSystemName() {
        return systemName;
    }

    public static int getRiskThreshold() {
        return riskThreshold;
    }

    public static boolean isFraudDetectionEnabled() {
        return fraudDetectionEnabled;
    }

    public static boolean isHighRisk(int riskScore) {
        return riskScore >= riskThreshold;
    }
}