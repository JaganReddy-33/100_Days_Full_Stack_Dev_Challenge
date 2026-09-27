package day59.overriding;

class PaymentService {

    public void processPayment() {
        System.out.println("Processing payment...");
    }

    protected void validateTransaction() {
        System.out.println("Validating transaction...");
    }

    public String getPaymentStatus() {
        return "PAYMENT COMPLETED";
    }

    public void generateReference() {
        System.out.println("Generating payment reference...");
    }
}

public class MethodOverridingRules_08 extends PaymentService {

    @Override
    public void processPayment() {
        System.out.println("Processing UPI payment...");
    }

    @Override
    public void validateTransaction() {
        System.out.println("Validating UPI transaction...");
    }

    @Override
    public String getPaymentStatus() {
        return "UPI PAYMENT SUCCESSFUL";
    }

    @Override
    public void generateReference() {
        System.out.println("Generating UPI transaction reference...");
    }
}