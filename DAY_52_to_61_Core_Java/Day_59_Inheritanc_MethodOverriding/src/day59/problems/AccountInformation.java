package day59.problems;

import java.util.*;

class Account {
	private long number;
	private long balance;

	public Account(long number, long balance) {
		this.number = number;
		this.balance = balance;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public String getDetails() {
		return "Account Number: " + number + ", Balance: " + balance;
	}
}

class SavingsAccount extends Account {
	private double InterestRate;

	public SavingsAccount(long number, long balance, double InterestRate) {
		super(number, balance);
		this.InterestRate = InterestRate;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(double InterestRate) {
		this.InterestRate = InterestRate;
	}

	@Override
	public String getDetails() {
		return (super.getDetails()) + ", Interest Rate: " + InterestRate + "%";
	}
}

class CurrentAccount extends Account {
	private long overdraftLimit;

	public CurrentAccount(long number, long balance, long overdraftLimit) {
		super(number, balance);
		this.overdraftLimit = overdraftLimit;
	}

	public long getLimit() {
		return overdraftLimit;
	}

	public void setLimit(long overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public String getDetails() {
		return (super.getDetails()) + ", Overdraft Limit: " + overdraftLimit;
	}

}

public class AccountInformation {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter account type: ");
        String accType = scanner.nextLine().trim();

        System.out.print("Enter account details (comma-separated): ");
        String details = scanner.nextLine().trim();

        String[] arr = details.split(",");
        long number = Long.parseLong(arr[0].trim());
        long balance = Long.parseLong(arr[1].trim());

        if (accType.equalsIgnoreCase("SavingsAccount")) {
            double interestRate = Double.parseDouble(arr[2].trim());
            SavingsAccount savings = new SavingsAccount(number, balance, interestRate);
            System.out.print("Account Details: " + savings.getDetails());
        } else if (accType.equalsIgnoreCase("CurrentAccount")) {
            long overdraftLimit = Long.parseLong(arr[2].trim());
            CurrentAccount current = new CurrentAccount(number, balance, overdraftLimit);
            System.out.print("Account Details: " + current.getDetails());
        }
	}
}
