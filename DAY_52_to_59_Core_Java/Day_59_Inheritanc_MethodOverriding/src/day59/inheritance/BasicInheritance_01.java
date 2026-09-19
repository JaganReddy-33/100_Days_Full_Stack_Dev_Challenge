package day59.inheritance;

class PaymentAccount {
	protected String accountType;
	
	public void showAccountType() {
		System.out.println("Account Type: " + accountType);
	}
}

public class BasicInheritance_01 extends PaymentAccount {
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public void processPayment() {
		System.out.println("Payment processing started... ");
	}
	
}