package day59.overriding;

class PaymentProcessor {

    public void processPayment() {
        System.out.println("Processing general payment...");
    }

    public void validatePayment() {
        System.out.println("Validating general payment...");
    }

    public void generateReceipt() {
        System.out.println("Generating general payment receipt...");
    }

    public String getPaymentStatus() {
        return "PAYMENT PROCESSED";
    }
}

public class BasicMethodOverriding_07 extends PaymentProcessor {

    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment...");
    }

    @Override
    public void validatePayment() {
        System.out.println("Validating UPI ID and transaction amount...");
    }

    @Override
    public void generateReceipt() {
        System.out.println("Generating UPI transaction receipt...");
    }

    @Override
    public String getPaymentStatus() {
        return "UPI PAYMENT SUCCESSFUL";
    }
}