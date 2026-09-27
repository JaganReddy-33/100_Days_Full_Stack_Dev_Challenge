package day57;

public class EmployeeUtility_10 {

    public void employeeDetails(int employeeId) {

        System.out.println("Employee ID: " + employeeId);
    }

    public void employeeDetails(int employeeId, String name) {

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
    }

    public void employeeDetails(int employeeId, String name, String department) {

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
    }

    public void employeeDetails(int employeeId, String name, double salary) {

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }

    public void employeeDetails(String name, String department, double salary) {

        System.out.println("Employee Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }

    public void calculateSalary(double basicSalary) {

        double finalSalary = basicSalary;

        System.out.println("Final Salary: " + finalSalary);
    }

    public void calculateSalary(double basicSalary, double bonus) {

        double finalSalary = basicSalary + bonus;

        System.out.println("Final Salary: " + finalSalary);
    }

    public void calculateSalary(double basicSalary, double bonus, double deduction) {

        double finalSalary = basicSalary + bonus - deduction;

        System.out.println("Final Salary: " + finalSalary);
    }

    public void calculateBonus(double salary, int percentage) {

        double bonus = salary * percentage / 100.0;

        System.out.println("Bonus: " + bonus);
    }

    public void calculateBonus(double salary, double fixedAmount) {

        double bonus = salary + fixedAmount;

        System.out.println("Salary After Bonus: " + bonus);
    }

    public void calculateExperience(int joiningYear, int currentYear) {

        int experience = currentYear - joiningYear;

        System.out.println("Experience: " + experience + " years");
    }

    public void calculateExperience(int joiningYear, int currentYear, String unit) {

        int experience = currentYear - joiningYear;

        System.out.println("Experience: " + experience + " " + unit);
    }
}