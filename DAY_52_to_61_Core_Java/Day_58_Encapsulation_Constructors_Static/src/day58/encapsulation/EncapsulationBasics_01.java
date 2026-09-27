package day58.encapsulation;

public class EncapsulationBasics_01 {
	private int empId;
	private String name;
	private double salary;
	
	public void setEmpId(int empId) {
		if(empId <= 0) {
			System.out.println("Emp ID must be always positive");
			return;	
		}
		this.empId = empId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(double salary) {
		if(salary < 0) {
			System.out.println("Salary must be always Positive");
			return;
		}
		this.salary = salary;
	}
	
	public int getEmpId() {
		return empId;
	}
	public String getName() {
		return name;
	}
	public Double getSalary() {
		return salary;
	}
	
	public void display() {
		System.out.println("Employee Details: ");
		System.out.println("Emp ID: " + getEmpId() + "| Name: "+getName()+ "| Salary: "+ getSalary());
	}
	
}
