package day58.constructors;

public class ConstructorBasics_01 {

	private int empId;
    private String empName;
    private double salary;

    public ConstructorBasics_01() {
        this.empId = 101;
        this.empName = "John Doe";
        this.salary = 50000.0;
        System.out.println("Default constructor called: Employee initialized.");
    }

    public void displayEmployeeDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Salary        : $" + salary);
    }
}