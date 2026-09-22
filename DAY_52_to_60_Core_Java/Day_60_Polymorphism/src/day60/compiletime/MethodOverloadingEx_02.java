package day60.compiletime;

class Payment {

    public void makePayment(double amount, String upiId) {
        System.out.println("UPI Payment | Amount: ₹" + amount + " | UPI ID: " + upiId);
    }

    public void makePayment(double amount, long cardNum) {
        System.out.println("Card Payment | Amount: ₹" + amount + " | Card Number: " + cardNum);
    }

    public void makePayment(double amount, String upiId, String desc) {
        System.out.println("Payment Details | Amount: ₹" + amount + " | UPI ID: " + upiId
                + " | Description: " + desc);
    }
}

public class MethodOverloadingEx_02 {

    public static void main(String[] args) {

        Payment py = new Payment();

        py.makePayment(30000, "jagan@upi");
        py.makePayment(45000, 12356789L);
        py.makePayment(12000, "lohith@upi", "Payment completed");
    }
}