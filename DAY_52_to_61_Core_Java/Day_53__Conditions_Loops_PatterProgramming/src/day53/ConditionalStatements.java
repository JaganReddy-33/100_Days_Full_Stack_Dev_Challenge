package day53;

public class ConditionalStatements {
	

	public static void ifStatement() {

		System.out.println("IF Conditional Statement");

		int age = 25;

		if (age >= 18) {
			System.out.println("Eligible to vote");
		}
		System.out.println("-----------------------------");

		double salary = 75000;

		if (salary >= 50000) {
			System.out.println("Employee is eligible for premium benefits");
		}
		System.out.println("-----------------------------");


		int marks = 85;

		if (marks >= 80) {
			System.out.println("Student scored above 80");
		}
		System.out.println("-----------------------------");

	}
	
	

	public static void elseStatement() {

		System.out.println("IF-ELSE Conditional Statement");

		int number = 25;

		if (number % 2 == 0) {
			System.out.println("Even number");
		} else {
			System.out.println("Odd number");
		}
		System.out.println("-----------------------------");

		
		int age = 16;

		if (age >= 18) {
			System.out.println("Eligible to vote");
		} else {
			System.out.println("Not eligible to vote");
		}
		System.out.println("-----------------------------");


		double balance = 2500;

		if (balance >= 5000) {
			System.out.println("Minimum balance maintained");
		} else {
			System.out.println("Minimum balance not maintained");
		}
		System.out.println("-----------------------------");

	}
	
	

	public static void elseIfStatement() {

		System.out.println("IF-ELSE-IF Conditional Statement");

		int marks = 85;

		if (marks >= 90) {
			System.out.println("Grade A");
		} else if (marks >= 80) {
			System.out.println("Grade B");
		} else if (marks >= 70) {
			System.out.println("Grade C");
		} else if (marks >= 60) {
			System.out.println("Grade D");
		} else {
			System.out.println("Grade F");
		}
		System.out.println("-----------------------------");


		double salary = 85000;

		if (salary < 30000) {
			System.out.println("Entry Level");
		} else if (salary < 70000) {
			System.out.println("Mid Level");
		} else if (salary < 120000) {
			System.out.println("Senior Level");
		} else {
			System.out.println("Lead or Management Level");
		}
		System.out.println("-----------------------------");


		int temperature = 32;

		if (temperature >= 40) {
			System.out.println("Extremely Hot");
		} else if (temperature >= 30) {
			System.out.println("Hot");
		} else if (temperature >= 20) {
			System.out.println("Moderate");
		} else if (temperature >= 10) {
			System.out.println("Cold");
		} else {
			System.out.println("Extremely Cold");
		}
		System.out.println("-----------------------------");

	}

	
	
	public static void nestedIfStatement() {

		System.out.println("Nested IF Conditional Statement");

		int age = 25;
		boolean hasLicense = true;

		if (age >= 18) {

			if (hasLicense) {
				System.out.println("Eligible to drive");
			} else {
				System.out.println("Age is valid but driving license is required");
			}

		} else {
			System.out.println("Not eligible to drive");
		}
		System.out.println("-----------------------------");


		int marks = 85;
		boolean attendance = true;

		if (marks >= 40) {

			if (attendance) {
				System.out.println("Student passed and attendance requirement is satisfied");
			} else {
				System.out.println("Student passed but attendance requirement is not satisfied");
			}

		} else {
			System.out.println("Student failed");
		}
		System.out.println("-----------------------------");

		
		double salary = 80000;
		int experience = 6;

		if (salary >= 50000) {

			if (experience >= 5) {
				System.out.println("Eligible for senior employee benefits");
			} else {
				System.out.println("Eligible for standard employee benefits");
			}

		} else {
			System.out.println("Eligible for basic employee benefits");
		}
		System.out.println("-----------------------------");

	}
	
	

	public static void switchStatement() {

		System.out.println("Switch Conditional Statement");

		int departmentId = 2;

		switch (departmentId) {

		case 1:
			System.out.println("Development");
			break;

		case 2:
			System.out.println("Testing");
			break;

		case 3:
			System.out.println("Human Resources");
			break;

		case 4:
			System.out.println("Finance");
			break;

		default:
			System.out.println("Unknown Department");
		}
		System.out.println("-----------------------------");


		int day = 3;

		switch (day) {

		case 1:
			System.out.println("Monday");
			break;

		case 2:
			System.out.println("Tuesday");
			break;

		case 3:
			System.out.println("Wednesday");
			break;

		case 4:
			System.out.println("Thursday");
			break;

		case 5:
			System.out.println("Friday");
			break;

		case 6:
			System.out.println("Saturday");
			break;

		case 7:
			System.out.println("Sunday");
			break;

		default:
			System.out.println("Invalid day");
		}
		System.out.println("-----------------------------");


		char grade = 'A';

		switch (grade) {

		case 'A':
			System.out.println("Excellent");
			break;

		case 'B':
			System.out.println("Very Good");
			break;

		case 'C':
			System.out.println("Good");
			break;

		case 'D':
			System.out.println("Pass");
			break;

		case 'F':
			System.out.println("Fail");
			break;

		default:
			System.out.println("Invalid Grade");
		}
		System.out.println("-----------------------------");

	}
	
	

	public static void switchStatement2() {

		System.out.println("Switch with String");

		String role = "ADMIN";

		switch (role) {

		case "ADMIN":
			System.out.println("Full system access");
			break;

		case "MANAGER":
			System.out.println("Manager access");
			break;

		case "EMPLOYEE":
			System.out.println("Employee access");
			break;

		case "GUEST":
			System.out.println("Limited access");
			break;

		default:
			System.out.println("Invalid role");
		}
		System.out.println("-----------------------------");

		
		String paymentMethod = "UPI";

		switch (paymentMethod) {

		case "UPI":
			System.out.println("Processing UPI payment");
			break;

		case "CARD":
			System.out.println("Processing card payment");
			break;

		case "NET_BANKING":
			System.out.println("Processing net banking payment");
			break;

		case "CASH":
			System.out.println("Processing cash payment");
			break;

		default:
			System.out.println("Unsupported payment method");
		}
		System.out.println("-----------------------------");


		String status = "SUCCESS";

		switch (status) {

		case "SUCCESS":
			System.out.println("Transaction completed successfully");
			break;

		case "PENDING":
			System.out.println("Transaction is pending");
			break;

		case "FAILED":
			System.out.println("Transaction failed");
			break;

		case "CANCELLED":
			System.out.println("Transaction was cancelled");
			break;

		default:
			System.out.println("Unknown transaction status");
		}
		System.out.println("-----------------------------");

	}
	
	

	public static void multipleConditions() {

		System.out.println("Multiple Conditions using Logical Operators");

		int age = 25;
		double salary = 60000;

		if (age >= 21 && salary >= 50000) {
			System.out.println("Eligible for premium loan");
		} else {
			System.out.println("Not eligible for premium loan");
		}
		System.out.println("-----------------------------");


		int marks = 85;
		int attendance = 90;

		if (marks >= 40 && attendance >= 75) {
			System.out.println("Student is eligible for examination");
		} else {
			System.out.println("Student is not eligible for examination");
		}
		System.out.println("-----------------------------");


		boolean emailVerified = true;
		boolean phoneVerified = true;

		if (emailVerified && phoneVerified) {
			System.out.println("Account verification completed");
		} else {
			System.out.println("Account verification incomplete");
		}
		System.out.println("-----------------------------");

	}
	
	
	

	public static void ternaryOperator() {

		System.out.println("Ternary Conditional Operator");

		int number = 25;

		String result = number % 2 == 0 ? "Even" : "Odd";

		System.out.println(result);
		System.out.println("-----------------------------");

		
		int age = 20;

		String eligibility = age >= 18 ? "Eligible" : "Not Eligible";

		System.out.println(eligibility);
		System.out.println("-----------------------------");


		double salary = 75000;

		double bonus = salary >= 50000 ? salary * 0.10 : salary * 0.05;

		System.out.println("Bonus = " + bonus);
		System.out.println("-----------------------------");

	}
}