package day53;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question7 {
	
    private static final String SQL = "SELECT employee_id, first_name, last_name, salary FROM employees WHERE salary >= ?";
    
    public static void runQuestion7() {
        
    	try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter minimum salary: ");
			double minSalary = sc.nextDouble();
			
			try (Connection con = ConnectionEx.getConnection();
			     PreparedStatement pstmt = con.prepareStatement(SQL)) {
				
			    pstmt.setDouble(1, minSalary);
			    
			    try (ResultSet rs = pstmt.executeQuery()) {
			        boolean dataFound = false;
			        while (rs.next()) {
			            dataFound = true;
			            Employee employee = new Employee(
			                    rs.getInt("employee_id"),
			                    rs.getString("first_name"),
			                    rs.getString("last_name"),
			                    0,
			                    rs.getDouble("salary"),
			                    null,
			                    0
			            );
			            System.out.println(employee);
			        }
			        if (!dataFound) {
			            System.out.println("No employees found matching the criteria.");
			        }
			    }
			    
			} catch (SQLException e) {
			    e.printStackTrace();
			} catch (ClassNotFoundException e) {
			    e.printStackTrace();
			}
		}
    }
}