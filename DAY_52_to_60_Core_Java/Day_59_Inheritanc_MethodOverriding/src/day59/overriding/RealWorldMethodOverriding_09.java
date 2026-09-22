package day59.overriding;

class PaymentProcessor_09 {

    public void validatePayment() {
        System.out.println("Validating payment...");
    }

    public void processPayment() {
        System.out.println("Processing payment...");
    }

    public void checkRisk() {
        System.out.println("Checking transaction risk...");
    }

    public String getPaymentStatus() {
        return "PAYMENT COMPLETED";
    }
}

class UPIPayment extends PaymentProcessor_09 {

    @Override
    public void validatePayment() {
        System.out.println("Validating UPI ID and transaction amount...");
    }

    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment...");
    }

    @Override
    public void checkRisk() {
        System.out.println("Checking UPI transaction risk...");
    }

    @Override
    public String getPaymentStatus() {
        return "UPI PAYMENT SUCCESSFUL";
    }
}

public class RealWorldMethodOverriding_09 extends PaymentProcessor_09 {

    @Override
    public void validatePayment() {
        System.out.println("Validating card details and transaction amount...");
    }

    @Override
    public void processPayment() {
        System.out.println("Processing card payment...");
    }

    @Override
    public void checkRisk() {
        System.out.println("Checking card transaction risk...");
    }

    @Override
    public String getPaymentStatus() {
        return "CARD PAYMENT SUCCESSFUL";
    }
}