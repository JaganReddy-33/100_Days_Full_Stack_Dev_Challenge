package day58.constructors;

public class ConstructorOverloading_03 {

    private int empId;
    private String empName;
    private double salary;

    public ConstructorOverloading_03() {
        this.empId = 0;
        this.empName = "Unknown";
        this.salary = 0.0;
    }

    public ConstructorOverloading_03(int empId) {
        this.empId = empId;
        this.empName = "Unknown";
        this.salary = 0.0;
    }

    public ConstructorOverloading_03(int empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee ID   : " + empId);
        System.out.println("Employee Name : " + empName);
        System.out.println("Salary        : " + salary);
    }
}