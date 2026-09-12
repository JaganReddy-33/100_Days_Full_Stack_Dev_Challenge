package day58;

import java.util.Scanner;

//import day58.constructors.ConstructorChaining_04;
//import day58.constructors.ConstructorRules_05;
//import day58.constructors.RealWorldConstructorDesign_07;
//import day58.constructors.ThisWithConstructors_06;
//import day58.encapsulation.EncapsulationProblems_04;
//import day58.constructors.ParameterizedConstructor_02;
//import day58.encapsulation.EncapsulationValidation_03;
//import day58.encapsulation.EncapsulationBasics_01;
//import day58.encapsulation.GetterSetter_02;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		
//		---- Encapsulation ----
		
//		EncapsulationBasics_01 emp = new EncapsulationBasics_01();
//		System.out.println("Enter Emp ID: ");
//		emp.setEmpId(sc.nextInt());
//		sc.nextLine();
//		System.out.println("Enter Emp Name: ");
//		emp.setName(sc.nextLine());
//		System.out.println("Enter Emp Salary: ");
//		emp.setSalary(sc.nextDouble());
//		emp.display();		
		
//		GetterSetter_02 acc = new GetterSetter_02();
//		System.out.println("Enter User account Number: ");
//		acc.setAccNumber(sc.nextLong());
//		sc.nextLine();
//		System.out.println("Enter User account Name: ");
//		acc.setAccName(sc.nextLine());
//		System.out.println("Enter User Balance: ");
//		acc.setBalance(sc.nextDouble());
//		acc.displayAccountDetails();	
		
//		EncapsulationValidation_03 student = new EncapsulationValidation_03();
//        System.out.println("Enter Student ID: ");
//        student.setStudentId(sc.nextInt());
//        sc.nextLine(); 
//        System.out.println("Enter Student Name: ");
//        student.setStudentName(sc.nextLine());
//        System.out.println("Enter Marks (0 - 100): ");
//        student.setMarks(sc.nextDouble());
//        student.displayStudentDetails();
		
//		EncapsulationProblems_04 account = new EncapsulationProblems_04();
//		System.out.println("Enter Account Number: ");
//		account.setAccountNumber(sc.nextLong());
//		sc.nextLine();
//		System.out.println("Enter Account Name: ");
//		account.setAccountHolder(sc.nextLine());
//		System.out.println("Enter Deposit amount: ");
//		account.deposit(sc.nextDouble());
//		System.out.println("Enter Withdrawl amount: ");
//		account.withdraw(sc.nextDouble());
//		System.out.println("Current Balance: " + account.getBalance());
//		account.displayAccountDetails();
		
	
		
//		---- Constructor ---- 
		
//		ConstructorBasics_01 emp = new ConstructorBasics_01();
//        emp.displayEmployeeDetails();
		
		
//		System.out.print("Enter Employee ID: ");
//        int empId = sc.nextInt();
//        sc.nextLine(); 
//        System.out.print("Enter Employee Name: ");
//        String empName = sc.nextLine();
//        System.out.print("Enter Employee Salary: ");
//        double salary = sc.nextDouble();
//        ParameterizedConstructor_02 emp = new ParameterizedConstructor_02(empId, empName, salary);
//        emp.displayEmployeeDetails();

		
//		System.out.println("--- Creating Employee with Default Constructor ---");
//        ConstructorOverloading_03 emp1 = new ConstructorOverloading_03();
//        emp1.displayEmployeeDetails();
//
//        System.out.println("\n--- Creating Employee with ID only ---");
//        System.out.print("Enter Employee ID: ");
//        int idOnly = sc.nextInt();
//        sc.nextLine();
//        ConstructorOverloading_03 emp2 = new ConstructorOverloading_03(idOnly);
//        emp2.displayEmployeeDetails();
//        
//        System.out.println("\n--- Creating Employee with Full Details ---");
//        System.out.print("Enter Employee ID: ");
//        int fullId = sc.nextInt();
//        sc.nextLine();
//        System.out.print("Enter Employee Name: ");
//        String fullName = sc.nextLine();
//        System.out.print("Enter Employee Salary: ");
//        double fullSalary = sc.nextDouble();
//        ConstructorOverloading_03 emp3 = new ConstructorOverloading_03(fullId, fullName, fullSalary);
//        emp3.displayEmployeeDetails();
		
		
//		System.out.print("Enter Order ID: ");
//		String orderId = sc.nextLine();
//		System.out.print("Enter Restaurant Name: ");
//		String restaurant = sc.nextLine();
//		System.out.print("Enter Delivery Type (STANDARD/EXPRESS): ");
//		String deliveryType = sc.nextLine();
//		System.out.print("Enter Base Delivery Fee: ");
//		double deliveryFee = sc.nextDouble();
//		ConstructorChaining_04 order = new ConstructorChaining_04(
//		                orderId,
//		                restaurant,
//		                deliveryType,
//		                deliveryFee
//		        );
//		order.displayOrder();
		
		
//		System.out.print("Enter Request ID: ");
//		String requestId = sc.nextLine();
//		System.out.print("Enter API Endpoint: ");
//		String endpoint = sc.nextLine();
//		System.out.print("Enter HTTP Method: ");
//		String method = sc.nextLine();
//		System.out.print("Enter Timeout in Seconds: ");
//		int timeout = sc.nextInt();
//		ConstructorRules_05 request = new ConstructorRules_05(
//		                requestId,
//		                endpoint,
//		                method,
//		                timeout
//		        );
//		request.displayRequest();
		
		
//		System.out.print("Enter Transaction ID: ");
//		String transactionId = sc.nextLine();
//		System.out.print("Enter Sender UPI ID: ");
//		String senderUpi = sc.nextLine();
//		System.out.print("Enter Receiver UPI ID: ");
//		String receiverUpi = sc.nextLine();
//		System.out.print("Enter Transaction Amount: ");
//		double amount = sc.nextDouble();
//		sc.nextLine();
//		System.out.print("Enter Payment Method: ");
//		String paymentMethod = sc.nextLine();
//		ThisWithConstructors_06 transaction = new ThisWithConstructors_06(
//		                transactionId,
//		                senderUpi,
//		                receiverUpi,
//		                amount,
//		                paymentMethod
//		        );
//		transaction.displayTransaction();
		
		
//		System.out.print("Enter Application ID: ");
//		String applicationId = sc.nextLine();
//		System.out.print("Enter Candidate Name: ");
//		String candidateName = sc.nextLine();
//		System.out.print("Enter Company Name: ");
//		String companyName = sc.nextLine();
//		System.out.print("Enter Job Role: ");
//		String role = sc.nextLine();
//		System.out.print("Enter Application Source: ");
//		String applicationSource = sc.nextLine();
//		RealWorldConstructorDesign_07 application =
//		        new RealWorldConstructorDesign_07(
//		                applicationId,
//		                candidateName,
//		                companyName,
//		                role,
//		                applicationSource
//		        );
//		application.displayApplication();
//		System.out.print("\nEnter Updated Status: ");
//		String status = sc.nextLine();
//		application.updateStatus(status);
//		application.displayApplication();
		
		sc.close();
	}
}
