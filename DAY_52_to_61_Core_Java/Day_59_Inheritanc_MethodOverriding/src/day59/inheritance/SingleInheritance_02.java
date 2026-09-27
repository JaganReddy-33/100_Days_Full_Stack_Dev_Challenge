package day59.inheritance;

class PaymentAccount_02{
	protected String accountNumber;
	protected String accountStatus;
	
	public void setAccountDetails(String accountNumber, String accountStatus) {
		this.accountNumber = accountNumber;
		this.accountStatus = accountStatus;
	}
	
	public void showAccountDetails() {
		System.out.println("Account Number: "+ accountNumber);
		System.out.println("Account Status: " + accountStatus);
	}
}

public class SingleInheritance_02 extends PaymentAccount_02 {
	
	private String upiId;
	
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	
	public void processingPayment() {
		System.out.println("UPI ID: " + upiId);
		System.out.println("UPI payment processing ... ");
	}
}
