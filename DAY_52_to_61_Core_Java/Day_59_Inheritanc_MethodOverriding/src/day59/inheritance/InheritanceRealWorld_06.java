package day59.inheritance;

class PaymentAccount_06 {

    protected int accountId;
    protected String accountStatus;

    public PaymentAccount_06(int accountId, String accountStatus) {
        this.accountId = accountId;
        this.accountStatus = accountStatus;
    }

    public void showAccountDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Status: " + accountStatus);
    }
}

class UPIAccount_06 extends PaymentAccount_06 {

    protected String upiId;

    public UPIAccount_06(int accountId, String accountStatus, String upiId) {
        super(accountId, accountStatus);
        this.upiId = upiId;
    }

    public void showUpiDetails() {
        System.out.println("UPI ID: " + upiId);
    }
}

public class InheritanceRealWorld_06 extends UPIAccount_06 {

    private int riskScore;

    public InheritanceRealWorld_06(int accountId,
                                   String accountStatus,
                                   String upiId,
                                   int riskScore) {

        super(accountId, accountStatus, upiId);
        this.riskScore = riskScore;
    }

    public void showRiskDetails() {
        System.out.println("Risk Score: " + riskScore);
    }

    public boolean isHighRisk() {
        return riskScore >= 80;
    }
}