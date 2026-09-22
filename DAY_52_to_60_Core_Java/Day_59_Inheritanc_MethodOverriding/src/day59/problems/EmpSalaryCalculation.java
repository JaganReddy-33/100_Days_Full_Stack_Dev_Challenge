package day59.problems;

import java.util.Scanner;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAnnualSalary() {
        return this.salary * 12;
    }
}

class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getAnnualSalary() {
        return super.getAnnualSalary() + this.bonus;
    }
}

class Engineer extends Employee {
    private double overtime;

    public Engineer(String name, double salary, double overtime) {
        super(name, salary);
        this.overtime = overtime;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    @Override
    public double getAnnualSalary() {
        return super.getAnnualSalary() + this.overtime;
    }
}

public class EmpSalaryCalculation {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter empType: ");
        String employeeType = sc.nextLine().trim();
        System.out.println("Enter Details...");
        String detailsLine = sc.nextLine().trim();
        String[] details = detailsLine.split(",");

        String name = details[0].trim();
        double salary = Double.parseDouble(details[1].trim());

        if (employeeType.equalsIgnoreCase("Manager")) {
            double bonus = Double.parseDouble(details[2].trim());
            Manager manager = new Manager(name, salary, bonus);
            System.out.printf("Annual Salary of Manager: %.2f\n", manager.getAnnualSalary());
        } else if (employeeType.equalsIgnoreCase("Engineer")) {
            double overtime = Double.parseDouble(details[2].trim());
            Engineer engineer = new Engineer(name, salary, overtime);
            System.out.printf("Annual Salary of Engineer: %.2f\n", engineer.getAnnualSalary());
        }
    }
}