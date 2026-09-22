package day60.problems;

import java.util.Scanner;


class Employee {
  public int calculateSalary() {
    return 0;
  }
}


class Manager extends Employee {
	
  @Override
  public int calculateSalary() {
    return 80000;
  }
}


class Programmer extends Employee {
	
  @Override
  public int calculateSalary() {
    return 60000;
  }
}

public class CalculatingSalaries {
	
  public static void main(String[] args) {
	  
    Scanner scanner = new Scanner(System.in);

    String role = scanner.nextLine().trim();

    Employee employee = null;
            
    if (role.equalsIgnoreCase("Manager")) {
      employee = new Manager();
      System.out.println("Manager Salary: $" + employee.calculateSalary());
    } else if (role.equalsIgnoreCase("Programmer")) {
      employee = new Programmer();
      System.out.println("Programmer Salary: $" + employee.calculateSalary());
    }
  }
}