package day59.inheritance;

class PaymentAccount_05 {

    protected String accountNumber;
    protected String accountStatus;

    public PaymentAccount_05(String accountNumber, String accountStatus) {
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        System.out.println("PaymentAccount constructor executed");
    }

    public void showAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Status: " + accountStatus);
    }
}

public class InheritanceWithConstructors_05 extends PaymentAccount_05 {

    private String upiId;

    public InheritanceWithConstructors_05(String accountNumber,
                                          String accountStatus,
                                          String upiId) {

        super(accountNumber, accountStatus);
        this.upiId = upiId;

        System.out.println("UPI account constructor executed");
    }

    public void showUpiDetails() {
        System.out.println("UPI ID: " + upiId);
    }
}