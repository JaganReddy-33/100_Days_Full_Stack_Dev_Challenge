package day53;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Question2 {
	
	private static final String UPDATE_SALARY = "UPDATE `employees` SET salary = ? where employee_id = ? ";

	public static void runQuestion2() {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("--- Updated Salary Details ---");
			System.out.println();
			
			System.out.println("Enter your Updated Salary: ");
			double salary = sc.nextDouble();
			
			System.out.println("Enter your employee_id: ");
			int id = sc.nextInt();
			
			Employee emp = new Employee(salary, id);
			
			
			try(Connection con = ConnectionEx.getConnection();
					PreparedStatement stmt = con.prepareStatement(UPDATE_SALARY)){
				
				stmt.setDouble(1, emp.getSalary());
				stmt.setInt(2, emp.getEmployeeId());
						
				int i = stmt.executeUpdate();
				System.out.println(i +" Rows affected!");
				System.out.println("New Salary Updated Successfully!");	
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
