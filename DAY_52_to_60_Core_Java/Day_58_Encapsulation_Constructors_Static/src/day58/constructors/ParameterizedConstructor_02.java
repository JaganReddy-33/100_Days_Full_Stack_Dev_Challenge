package day58.constructors;

public class ParameterizedConstructor_02 {

    private int empId;
    private String empName;
    private double salary;

    public ParameterizedConstructor_02(int empId, String empName, double salary) {
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