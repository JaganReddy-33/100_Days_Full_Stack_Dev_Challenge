package day58.staticconcepts;

public class StaticConstants_07 {

    public static final String ACCOUNT_ACTIVE = "ACTIVE";
    public static final String ACCOUNT_SUSPENDED = "SUSPENDED";
    public static final String ACCOUNT_BLOCKED = "BLOCKED";

    public static final String TRANSACTION_PENDING = "PENDING";
    public static final String TRANSACTION_SUCCESS = "SUCCESS";
    public static final String TRANSACTION_FAILED = "FAILED";

    public static boolean isValidAccountStatus(String status) {

        if (status == null) {
            return false;
        }

        return status.equals(ACCOUNT_ACTIVE)
                || status.equals(ACCOUNT_SUSPENDED)
                || status.equals(ACCOUNT_BLOCKED);
    }

    public static boolean isValidTransactionStatus(String status) {

        if (status == null) {
            return false;
        }

        return status.equals(TRANSACTION_PENDING)
                || status.equals(TRANSACTION_SUCCESS)
                || status.equals(TRANSACTION_FAILED);
    }

    public static String getDefaultTransactionStatus() {
        return TRANSACTION_PENDING;
    }

    public static String getDefaultAccountStatus() {
        return ACCOUNT_ACTIVE;
    }
}