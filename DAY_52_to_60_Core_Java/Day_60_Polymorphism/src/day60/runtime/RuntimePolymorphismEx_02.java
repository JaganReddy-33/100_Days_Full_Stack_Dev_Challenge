package day60.runtime;


class Employee {
	
	public void calculateSalary() {
        System.out.println("Employee | Calculating basic salary");
    }
}

class Manager extends Employee {
	
	@Override
	public void calculateSalary() {
		double basicSalary = 50000;
		double bonus = 10000;
		double totalSalary = basicSalary + bonus;
		
		System.out.println("Manager | Basic Salary: ₹" + basicSalary
	                + " | Bonus: ₹" + bonus
	                + " | Total Salary: ₹" + totalSalary);
	}
}

class Developer extends Employee {
	
	@Override
	public void calculateSalary() {
		double basicSalary = 40000;
		double incentive = 5000;
		double totalSalary = basicSalary + incentive;
		
		System.out.println("Developer | Basic Salary: ₹" + basicSalary
	                + " | Incentive: ₹" + incentive
	                + " | Total Salary: ₹" + totalSalary);
	}
}


public class RuntimePolymorphismEx_02 {

	public static void main(String[] args) {
		
		Employee emp;
		
		emp = new Manager();
		emp.calculateSalary();
		
		emp = new Developer();
		emp.calculateSalary();
	}

}
