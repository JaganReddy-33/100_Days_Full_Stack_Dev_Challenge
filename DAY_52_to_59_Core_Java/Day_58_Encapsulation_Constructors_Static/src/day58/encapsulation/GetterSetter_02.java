package day58.encapsulation;

public class GetterSetter_02 {
	
	private long accNumber;
	private String accName;
	private double balance;
	
	public void setAccNumber(long accNumber) {
		if(accNumber <= 0) {
			System.out.println("Account Number must be Positive!");
			return;
		}
		this.accNumber = accNumber;
	}
	
	public void setAccName(String accName) {
		this.accName = accName;
	}
	
	public void setBalance(double balance) {
		if(balance < 0) {
			System.out.println("Balance must be positive!");
			return;
		}
		this.balance = balance;
	}
	
	public long getAccNumber() {
		return accNumber;
	}
	public String getAccName() {
		return accName;
	}
	public double getBalance() {
		return balance;
	}
	
	public void displayAccountDetails() {
		System.out.println("--- User Account Details ---");
		System.out.println("Account Number: " + getAccNumber());
		System.out.println("Account Name: " + getAccName());
		System.out.println("User Balance: " + getBalance());
	}
}
