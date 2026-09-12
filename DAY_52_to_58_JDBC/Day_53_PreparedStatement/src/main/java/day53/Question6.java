package day53;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question6 {
    private static final String SQL = "SELECT employee_id, CONCAT(first_name, ' ', last_name) AS name, salary, experience_years FROM employees WHERE department_id = ?";
    public static void runQuestion6() {
    	
        try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Department ID:");
			int id = sc.nextInt();
			
			try (Connection con = ConnectionEx.getConnection();
			     PreparedStatement stmt = con.prepareStatement(SQL)) {
				
			    stmt.setInt(1, id);
			    
			    try (ResultSet res = stmt.executeQuery()) {
			        boolean hasData = false;
			        while (res.next()) {
			            hasData = true;
			            Employee employee = new Employee(
			                    res.getInt("employee_id"),
			                    res.getString("name"),
			                    null,
			                    0,
			                    res.getDouble("salary"),
			                    null,
			                    res.getInt("experience_years")
			            );
			            System.out.println(employee);
			        }
			        if (!hasData) {
			            System.out.println("No employees found in Department ID: " + id);
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