package day61.abstraction;

import java.util.Scanner;

abstract class Employee {
	private int empId;
	private String empName;
	
	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}
	
	public void displayEmployeeDetails() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + empName);
	}
	
	abstract void calculateSalary();
}


class FullTimeEmployee extends Employee {
	
	private double salary;

	public FullTimeEmployee(int empId, String empName, double salary) {
		super(empId, empName);
		this.salary = salary;
	}

	@Override
	public void calculateSalary() {
		System.out.println("Full Time Monthly Salary: " + salary);
	}
	
}

class PartTimeEmployee extends Employee {
	private double totalHours;
	private double hoursPay;

	public PartTimeEmployee(int empId, String empName, double totalHours, double hoursPay) {
		super(empId, empName);
		this.totalHours = totalHours;
		this.hoursPay = hoursPay;
	}
	

	@Override
	public void calculateSalary() {
		
		double salary = totalHours * hoursPay;
		
		System.out.println("Part Time Monthly Salary: " + salary);
	}
	
}




public class EmployeePayrollSystem {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter employee type: ");
		String empType = sc.nextLine();
		
		System.out.println("Enter employee ID: ");
		int empId = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter employee name: ");
		String name = sc.nextLine();
		
	
		Employee emp = null;
		
		if(empType.equalsIgnoreCase("Full Time")) {
			
			System.out.println("Enter monthly salary: ");
			double salary = sc.nextDouble();
			
			emp = new FullTimeEmployee(empId, name, salary);
			
		} else if(empType.equalsIgnoreCase("Part time")) {
			
			System.out.println("Enter hours worked.. ");
			double hours = sc.nextDouble();
			
			System.out.println("Enter hours pay amount...");
			double hoursPay = sc.nextDouble();
			
			emp = new PartTimeEmployee(empId, name, hours, hoursPay);
		} else {
			System.out.println("Invalid employee type!");
			return;
		}
		
		emp.displayEmployeeDetails();
		emp.calculateSalary();
		
		

	}

}
