package day59.inheritance;

class PaymentAccount_03 {

    protected String accountNumber;

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void showAccountNumber() {
        System.out.println("Account Number: " + accountNumber);
    }
}

class DigitalAccount extends PaymentAccount_03 {

    protected String accountStatus;

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public void showAccountStatus() {
        System.out.println("Account Status: " + accountStatus);
    }
}

public class MultilevelInheritance_03 extends DigitalAccount {

    private String upiId;

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public void processUpiPayment() {
        System.out.println("UPI ID: " + upiId);
        System.out.println("UPI payment processing...");
    }
}