package day59.inheritance;


class PaymentAccount_04 {
	protected String accountNumber;
	protected String accountStatus;
	
	public void setAccountDetails(String accountNumber, String accountStatus) {
		this.accountNumber = accountNumber;
		this.accountStatus = accountStatus;
	}
	
	public void showAccountDetails() {
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Status: " + accountStatus);
	}
}

class UPIAccount extends PaymentAccount_04 {
	
	private String upiId;
	
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	public void processingUpiPayment() {
		System.out.println("UPI ID: " + upiId);
		System.out.println("UPI payment processing ...");
	}
	
}

public class HierarchicalInheritance_04 extends PaymentAccount_04 {
	
	private String cardNumber;

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void processCardPayment() {
		System.out.println("Card Number: " + cardNumber);
	    System.out.println("Card payment processing...");
	}
}
